package kotlin.reflect.jvm.internal;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.facebook.keyframes.model.KFAnimation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.DescriptorsJvmAbiUtil;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 C*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004@ABCB5\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u0012J\n\u0010#\u001a\u0004\u0018\u00010$H\u0004J(\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010\f2\b\u0010(\u001a\u0004\u0018\u00010\fH\u0004J\u0013\u0010;\u001a\u00020\u001b2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020\u0007H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010 \u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\n0\n0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u0006\u0012\u0002\b\u0003038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0002\b\u0003\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u00108\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u001cR\u0014\u00109\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u001cR\u0014\u0010:\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u001c¨\u0006D"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "V", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", KtvSubElement.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "descriptorInitialValue", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "rawBoundReceiver", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getName", "()Ljava/lang/String;", "getSignature", "getBoundReceiver", "()Ljava/lang/Object;", "isBound", "", "()Z", "_javaField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "computeDelegateSource", "Ljava/lang/reflect/Member;", "getDelegateImpl", "fieldOrMethod", "receiver1", "receiver2", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "getDefaultCaller", "isLateinit", "isConst", "isSuspend", "equals", "other", "hashCode", "", "toString", "Accessor", "Getter", "Setter", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {
    public static final Companion Companion = null;
    private static final Object EXTENSION_PROPERTY_DELEGATE = null;
    private final ReflectProperties.LazySoftVal<PropertyDescriptor> _descriptor;
    private final Lazy<Field> _javaField;
    private final KDeclarationContainerImpl container;
    private final String name;
    private final Object rawBoundReceiver;
    private final String signature;

    /* JADX INFO: loaded from: classes42.dex */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001a¨\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "<init>", "()V", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", KtvSubElement.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "isBound", "", "()Z", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Accessor<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType>, KProperty.Accessor<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getDefaultCaller() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public abstract PropertyAccessorDescriptor getDescriptor();

        public abstract KPropertyImpl<PropertyType> getProperty();

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public KDeclarationContainerImpl getContainer() {
            return getProperty().getContainer();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public boolean isBound() {
            return getProperty().isBound();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isExternal() {
            return getDescriptor().isExternal();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInfix() {
            return getDescriptor().isInfix();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInline() {
            return getDescriptor().isInline();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isOperator() {
            return getDescriptor().isOperator();
        }

        @Override // kotlin.reflect.KCallable
        public boolean isSuspend() {
            return getDescriptor().isSuspend();
        }

        public Accessor() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "<init>", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Object getEXTENSION_PROPERTY_DELEGATE() {
            return KPropertyImpl.access$getEXTENSION_PROPERTY_DELEGATE$cp();
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "toString", "equals", "", "other", "", "hashCode", "", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Getter<V> extends Accessor<V, V> implements KProperty.Getter<V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final Lazy caller$delegate;
        private final ReflectProperties.LazySoftVal descriptor$delegate;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Getter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;"))};
        }

        public static /* synthetic */ PropertyGetterDescriptor accessor$KPropertyImpl$Getter$lambda0(Getter r100) {
            return descriptor_delegate$lambda$0(r100);
        }

        public static /* synthetic */ Caller accessor$KPropertyImpl$Getter$lambda1(Getter r100) {
            return caller_delegate$lambda$1(r100);
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getCaller() {
            return (Caller) this.caller$delegate.getValue();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public PropertyGetterDescriptor getDescriptor() {
            return (PropertyGetterDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            return "<get-" + getProperty().getName() + Typography.greater;
        }

        public String toString() {
            return "getter of " + getProperty();
        }

        public Getter() {
            this.descriptor$delegate = ReflectProperties.lazySoft(new KPropertyImpl$Getter$$Lambda$0(this));
            this.caller$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPropertyImpl$Getter$$Lambda$1(this));
        }

        public int hashCode() {
            return getProperty().hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
            return getDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public /* bridge */ /* synthetic */ PropertyAccessorDescriptor getDescriptor() {
            return getDescriptor();
        }

        private static final Caller caller_delegate$lambda$1(Getter r100) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            return KPropertyImplKt.access$computeCallerForAccessor(r100, true);
        }

        private static final PropertyGetterDescriptor descriptor_delegate$lambda$0(Getter r100) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            PropertyGetterDescriptor r101 = r100.getProperty().getDescriptor().getGetter();
            if (r101 == null) goto L5;
            return r101;
        L5:
            return DescriptorFactory.createDefaultGetter(r100.getProperty().getDescriptor(), Annotations.Companion.getEMPTY());
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Getter) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(getProperty(), ((Getter) r100).getProperty()) == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "toString", "equals", "", "other", "", "hashCode", "", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Setter<V> extends Accessor<V, Unit> implements KMutableProperty.Setter<V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final Lazy caller$delegate;
        private final ReflectProperties.LazySoftVal descriptor$delegate;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Setter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;"))};
        }

        public static /* synthetic */ PropertySetterDescriptor accessor$KPropertyImpl$Setter$lambda0(Setter r100) {
            return descriptor_delegate$lambda$0(r100);
        }

        public static /* synthetic */ Caller accessor$KPropertyImpl$Setter$lambda1(Setter r100) {
            return caller_delegate$lambda$1(r100);
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getCaller() {
            return (Caller) this.caller$delegate.getValue();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public PropertySetterDescriptor getDescriptor() {
            return (PropertySetterDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            return "<set-" + getProperty().getName() + Typography.greater;
        }

        public String toString() {
            return "setter of " + getProperty();
        }

        public Setter() {
            this.descriptor$delegate = ReflectProperties.lazySoft(new KPropertyImpl$Setter$$Lambda$0(this));
            this.caller$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPropertyImpl$Setter$$Lambda$1(this));
        }

        public int hashCode() {
            return getProperty().hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
            return getDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public /* bridge */ /* synthetic */ PropertyAccessorDescriptor getDescriptor() {
            return getDescriptor();
        }

        private static final Caller caller_delegate$lambda$1(Setter r100) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            return KPropertyImplKt.access$computeCallerForAccessor(r100, false);
        }

        private static final PropertySetterDescriptor descriptor_delegate$lambda$0(Setter r100) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            PropertySetterDescriptor r101 = r100.getProperty().getDescriptor().getSetter();
            if (r101 != null) goto L6;
            PropertyDescriptor r102 = r100.getProperty().getDescriptor();
            Annotations.Companion r103 = Annotations.Companion;
            return DescriptorFactory.createDefaultSetter(r102, r103.getEMPTY(), r103.getEMPTY());
        L6:
            return r101;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Setter) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(getProperty(), ((Setter) r100).getProperty()) == false) goto L7;
            return true;
        }
    }

    public static /* synthetic */ Field accessor$KPropertyImpl$lambda0(KPropertyImpl r100) {
        return _javaField$lambda$2(r100);
    }

    public static /* synthetic */ PropertyDescriptor accessor$KPropertyImpl$lambda1(KPropertyImpl r100) {
        return _descriptor$lambda$5(r100);
    }

    public abstract Getter<V> getGetter();

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    static {
        Companion = new Companion(null);
        EXTENSION_PROPERTY_DELEGATE = new Object();
    }

    public final Object getBoundReceiver() {
        return ValueClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public PropertyDescriptor getDescriptor() {
        return this._descriptor.invoke();
    }

    public final Field getJavaField() {
        return this._javaField.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        if (this.rawBoundReceiver == CallableReference.NO_RECEIVER) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderProperty(getDescriptor());
    }

    public final Member computeDelegateSource() {
        if (getDescriptor().isDelegated() == true) goto L5;
        return null;
    L5:
        JvmPropertySignature r100 = RuntimeTypeMapper.INSTANCE.mapPropertySignature(getDescriptor());
        if ((r100 instanceof JvmPropertySignature.KotlinProperty) == false) goto L18;
        JvmPropertySignature.KotlinProperty r101 = (JvmPropertySignature.KotlinProperty) r100;
        if (r101.getSignature().hasDelegateMethod() == false) goto L18;
        JvmProtoBuf.JvmMethodSignature r102 = r101.getSignature().getDelegateMethod();
        if (r102.hasName() == true) goto L12;
    L16:
        return null;
    L12:
        if (r102.hasDesc() == false) goto L16;
        String r103 = r101.getNameResolver().getString(r102.getName());
        String r104 = r101.getNameResolver().getString(r102.getDesc());
        return getContainer().findMethodBySignature(r103, r104);
    L18:
        return getJavaField();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getCaller() {
        return getGetter().getCaller();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return getGetter().getDefaultCaller();
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getDescriptor().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getDescriptor().isLateInit();
    }

    public static final /* synthetic */ Object access$getEXTENSION_PROPERTY_DELEGATE$cp() {
        return EXTENSION_PROPERTY_DELEGATE;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.name;
    }

    public final String getSignature() {
        return this.signature;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
        return getDescriptor();
    }

    private static final PropertyDescriptor _descriptor$lambda$5(KPropertyImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        return r100.getContainer().findPropertyDescriptor(r100.getName(), r100.signature);
    }

    private static final Field _javaField$lambda$2(KPropertyImpl r110) {
        Intrinsics.checkNotNullParameter(r110, "this$0");
        JvmPropertySignature r100 = RuntimeTypeMapper.INSTANCE.mapPropertySignature(r110.getDescriptor());
        if ((r100 instanceof JvmPropertySignature.KotlinProperty) == false) goto L20;
        JvmPropertySignature.KotlinProperty r101 = (JvmPropertySignature.KotlinProperty) r100;
        PropertyDescriptor r102 = r101.getDescriptor();
        JvmMemberSignature.Field r103 = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, r101.getProto(), r101.getNameResolver(), r101.getTypeTable(), false, 8, null);
        if (r103 != null) goto L7;
        return null;
    L7:
        if (DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(r102) == false) goto L9;
    L15:
        Class<?> r111 = r110.getContainer().getJClass().getEnclosingClass();
    L16:
        if (r111 == null) goto L33;
        return r111.getDeclaredField(r103.getName());
    L38:
        return null;
    L33:
        return null;
    L9:
        if (JvmProtoBufUtil.isMovedFromInterfaceCompanion(r101.getProto()) == true) goto L15;
        DeclarationDescriptor r104 = r102.getContainingDeclaration();
        if ((r104 instanceof ClassDescriptor) == false) goto L14;
        r111 = UtilKt.toJavaClass((ClassDescriptor) r104);
        goto L16
    L14:
        r111 = r110.getContainer().getJClass();
        goto L16
    L20:
        if ((r100 instanceof JvmPropertySignature.JavaField) == false) goto L23;
        return ((JvmPropertySignature.JavaField) r100).getField();
    L23:
        if ((r100 instanceof JvmPropertySignature.JavaMethodProperty) == false) goto L26;
        return null;
    L26:
        if ((r100 instanceof JvmPropertySignature.MappedKotlinProperty) == false) goto L29;
        return null;
    L29:
        throw new NoWhenBranchMatchedException();
    }

    public boolean equals(Object r100) {
        KPropertyImpl<?> r101 = UtilKt.asKPropertyImpl(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(getContainer(), r101.getContainer()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getName(), r101.getName()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.signature, r101.signature) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rawBoundReceiver, r101.rawBoundReceiver) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public KPropertyImpl(KDeclarationContainerImpl r100, PropertyDescriptor r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "descriptor");
        this(r100, r101.getName().asString(), RuntimeTypeMapper.INSTANCE.mapPropertySignature(r101).asString(), r101, CallableReference.NO_RECEIVER);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object getDelegateImpl(Member r100, Object r110, Object r111) {
        Object r101 = EXTENSION_PROPERTY_DELEGATE;     // Catch: IllegalAccessException -> L64
        if (r110 == r101) goto L7;
        if (r111 == r101) goto L7;
    L9:
        if (isBound() == false) goto L11;
        Object r102 = getBoundReceiver();     // Catch: IllegalAccessException -> L64
    L13:
        if (r102 == r101) goto L15;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L21;
        r102 = null;
    L21:
        if (isBound() == true) goto L24;
        r110 = r111;
    L24:
        if (r110 == r101) goto L26;
        boolean r112 = true;
    L27:
        if (r112 == true) goto L31;
        r110 = null;
    L31:
        if ((r100 instanceof AccessibleObject) == false) goto L33;
        AccessibleObject r113 = (AccessibleObject) r100;     // Catch: IllegalAccessException -> L64
    L34:
        if (r113 == null) goto L36;
        r113.setAccessible(KCallablesJvm.isAccessible(this));     // Catch: IllegalAccessException -> L64
    L36:
        if (r100 != 0) goto L39;
        return null;
    L39:
        if ((r100 instanceof Field) == false) goto L42;
        return ((Field) r100).get(r102);
    L42:
        if ((r100 instanceof Method) == false) goto L61;
        int r114 = ((Method) r100).getParameterTypes().length;     // Catch: IllegalAccessException -> L64
        if (r114 == 0) goto L59;
        if (r114 != 1) goto L47;
        Method r115 = (Method) r100;     // Catch: IllegalAccessException -> L64
        Object[] r116 = new Object[1];     // Catch: IllegalAccessException -> L64
        if (r102 != null) goto L57;
        r102 = UtilKt.defaultPrimitiveValue(((Method) r100).getParameterTypes()[0]);     // Catch: IllegalAccessException -> L64
    L57:
        r116[0] = r102;     // Catch: IllegalAccessException -> L64
        return r115.invoke(null, r116);
    L47:
        if (r114 != 2) goto L53;
        Method r117 = (Method) r100;     // Catch: IllegalAccessException -> L64
        Object[] r104 = new Object[2];     // Catch: IllegalAccessException -> L64
        r104[0] = r102;     // Catch: IllegalAccessException -> L64
        if (r110 != null) goto L51;
        r110 = UtilKt.defaultPrimitiveValue(((Method) r100).getParameterTypes()[1]);     // Catch: IllegalAccessException -> L64
    L51:
        r104[1] = r110;     // Catch: IllegalAccessException -> L64
        return r117.invoke(null, r104);
    L53:
        throw new AssertionError("delegate method " + r100 + " should take 0, 1, or 2 parameters");     // Catch: IllegalAccessException -> L64
    L59:
        return ((Method) r100).invoke(null, new Object[0]);
    L61:
        throw new AssertionError("delegate field/method " + r100 + " neither field nor method");     // Catch: IllegalAccessException -> L64
    L33:
        r113 = null;
        goto L34
    L26:
        r112 = false;
        goto L27
    L15:
        r103 = false;
        goto L17
    L11:
        r102 = r110;
    L7:
        if (getDescriptor().getExtensionReceiverParameter() != null) goto L9;
        throw new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");     // Catch: IllegalAccessException -> L64
    L64:
        e = move-exception;
        throw new IllegalPropertyDelegateAccessException(e);
    }

    public KPropertyImpl(KDeclarationContainerImpl r100, String r101, String r110, Object r111) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r110, "signature");
        this(r100, r101, r110, null, r111);
    }

    private KPropertyImpl(KDeclarationContainerImpl r100, String r101, String r102, PropertyDescriptor r103, Object r104) {
        this.container = r100;
        this.name = r101;
        this.signature = r102;
        this.rawBoundReceiver = r104;
        this._javaField = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPropertyImpl$$Lambda$0(this));
        this._descriptor = ReflectProperties.lazySoft(r103, new KPropertyImpl$$Lambda$1(this));
    }
}
