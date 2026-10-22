package kotlin.reflect.jvm.internal;

import android.util.EventsUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.DescriptorsJvmAbiUtil;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 C*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004@ABCB5\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u0012J\n\u0010#\u001a\u0004\u0018\u00010$H\u0004J(\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010\f2\b\u0010(\u001a\u0004\u0018\u00010\fH\u0004J\u0013\u0010;\u001a\u00020\u001b2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020\u0007H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010 \u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\n0\n0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u0006\u0012\u0002\b\u0003038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0002\b\u0003\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u00108\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u001cR\u0014\u00109\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u001cR\u0014\u0010:\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u001c¨\u0006D"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "V", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", XmlPullParser.NO_NAMESPACE, "signature", "descriptorInitialValue", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "rawBoundReceiver", XmlPullParser.NO_NAMESPACE, "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getName", "()Ljava/lang/String;", "getSignature", "getBoundReceiver", "()Ljava/lang/Object;", "isBound", XmlPullParser.NO_NAMESPACE, "()Z", "_javaField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "computeDelegateSource", "Ljava/lang/reflect/Member;", "getDelegateImpl", "fieldOrMethod", "receiver1", "receiver2", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "getDefaultCaller", "isLateinit", "isConst", "isSuspend", "equals", "other", "hashCode", XmlPullParser.NO_NAMESPACE, "toString", "Accessor", "Getter", "Setter", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {
    public static final Companion Companion = null;
    private static final Object EXTENSION_PROPERTY_DELEGATE = null;
    private final ReflectProperties.LazySoftVal<PropertyDescriptor> _descriptor;
    private final Lazy<Field> _javaField;
    private final KDeclarationContainerImpl container;
    private final String name;
    private final Object rawBoundReceiver;
    private final String signature;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", XmlPullParser.NO_NAMESPACE, "<init>", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Object getEXTENSION_PROPERTY_DELEGATE() {
            return KPropertyImpl.access$getEXTENSION_PROPERTY_DELEGATE$cp();
        }
    }

    public static /* synthetic */ Field accessor$KPropertyImpl$lambda0(KPropertyImpl r0) {
        return _javaField$lambda$2(r0);
    }

    public static /* synthetic */ PropertyDescriptor accessor$KPropertyImpl$lambda1(KPropertyImpl r0) {
        return _descriptor$lambda$5(r0);
    }

    /* JADX INFO: renamed from: getGetter */
    public abstract Getter<V> mo170getGetter();

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    static {
        Companion = new Companion(null);
        EXTENSION_PROPERTY_DELEGATE = new Object();
    }

    public final Object getBoundReceiver() {
        return ValueClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, m171getDescriptor());
    }

    /* JADX INFO: renamed from: getDescriptor, reason: collision with other method in class */
    public PropertyDescriptor m171getDescriptor() {
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
        return ReflectionObjectRenderer.INSTANCE.renderProperty(m171getDescriptor());
    }

    public final Member computeDelegateSource() {
        if (m171getDescriptor().isDelegated() == true) goto L5;
        return null;
    L5:
        JvmPropertySignature.KotlinProperty r0 = RuntimeTypeMapper.INSTANCE.mapPropertySignature(m171getDescriptor());
        if ((r0 instanceof JvmPropertySignature.KotlinProperty) == false) goto L18;
        JvmPropertySignature.KotlinProperty r1 = r0;
        if (r1.getSignature().hasDelegateMethod() == false) goto L18;
        JvmProtoBuf.JvmMethodSignature r2 = r1.getSignature().getDelegateMethod();
        if (r2.hasName() == true) goto L12;
    L16:
        return null;
    L12:
        if (r2.hasDesc() == false) goto L16;
        String r3 = r1.getNameResolver().getString(r2.getName());
        String r4 = r1.getNameResolver().getString(r2.getDesc());
        return getContainer().findMethodBySignature(r3, r4);
    L18:
        return getJavaField();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getCaller() {
        return mo170getGetter().getCaller();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return mo170getGetter().getDefaultCaller();
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return m171getDescriptor().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return m171getDescriptor().isLateInit();
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
        return m171getDescriptor();
    }

    private static final PropertyDescriptor _descriptor$lambda$5(KPropertyImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r2.getContainer().findPropertyDescriptor(r2.getName(), r2.signature);
    }

    private static final Field _javaField$lambda$2(KPropertyImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        JvmPropertySignature.KotlinProperty r0 = RuntimeTypeMapper.INSTANCE.mapPropertySignature(r10.m171getDescriptor());
        if ((r0 instanceof JvmPropertySignature.KotlinProperty) == false) goto L20;
        JvmPropertySignature.KotlinProperty r1 = r0;
        PropertyDescriptor r2 = r1.getDescriptor();
        JvmMemberSignature.Field r3 = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, r1.getProto(), r1.getNameResolver(), r1.getTypeTable(), false, 8, null);
        if (r3 != null) goto L7;
        return null;
    L7:
        if (DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(r2) == false) goto L9;
    L15:
        Class<?> r11 = r10.getContainer().getJClass().getEnclosingClass();
    L16:
        if (r11 == null) goto L33;
        return r11.getDeclaredField(r3.getName());
    L38:
        return null;
    L33:
        return null;
    L9:
        if (JvmProtoBufUtil.isMovedFromInterfaceCompanion(r1.getProto()) == true) goto L15;
        ClassDescriptor r4 = r2.getContainingDeclaration();
        if ((r4 instanceof ClassDescriptor) == false) goto L14;
        r11 = UtilKt.toJavaClass(r4);
        goto L16
    L14:
        r11 = r10.getContainer().getJClass();
        goto L16
    L20:
        if ((r0 instanceof JvmPropertySignature.JavaField) == false) goto L23;
        return ((JvmPropertySignature.JavaField) r0).getField();
    L23:
        if ((r0 instanceof JvmPropertySignature.JavaMethodProperty) == false) goto L26;
        return null;
    L26:
        if ((r0 instanceof JvmPropertySignature.MappedKotlinProperty) == false) goto L29;
        return null;
    L29:
        throw new NoWhenBranchMatchedException();
    }

    public boolean equals(Object r4) {
        KPropertyImpl r5 = UtilKt.asKPropertyImpl(r4);
        if (r5 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(getContainer(), r5.getContainer()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getName(), r5.getName()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.signature, r5.signature) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rawBoundReceiver, r5.rawBoundReceiver) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public KPropertyImpl(KDeclarationContainerImpl r8, PropertyDescriptor r9) {
        Intrinsics.checkNotNullParameter(r8, "container");
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        this(r8, r9.getName().asString(), RuntimeTypeMapper.INSTANCE.mapPropertySignature(r9).asString(), r9, CallableReference.NO_RECEIVER);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object getDelegateImpl(Member r9, Object r10, Object r11) {
        Object r3 = EXTENSION_PROPERTY_DELEGATE;     // Catch: IllegalAccessException -> L64
        if (r10 == r3) goto L7;
        if (r11 == r3) goto L7;
    L9:
        if (isBound() == false) goto L11;
        Object r2 = getBoundReceiver();     // Catch: IllegalAccessException -> L64
    L13:
        if (r2 == r3) goto L15;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L21;
        r2 = null;
    L21:
        if (isBound() == true) goto L24;
        r10 = r11;
    L24:
        if (r10 == r3) goto L26;
        boolean r12 = true;
    L27:
        if (r12 == true) goto L31;
        r10 = null;
    L31:
        if ((r9 instanceof AccessibleObject) == false) goto L33;
        AccessibleObject r13 = (AccessibleObject) r9;     // Catch: IllegalAccessException -> L64
    L34:
        if (r13 == null) goto L36;
        r13.setAccessible(KCallablesJvm.isAccessible(this));     // Catch: IllegalAccessException -> L64
    L36:
        if (r9 != 0) goto L39;
        return null;
    L39:
        if ((r9 instanceof Field) == false) goto L42;
        return ((Field) r9).get(r2);
    L42:
        if ((r9 instanceof Method) == false) goto L61;
        int r14 = ((Method) r9).getParameterTypes().length;     // Catch: IllegalAccessException -> L64
        if (r14 == 0) goto L59;
        if (r14 != 1) goto L47;
        Method r15 = (Method) r9;     // Catch: IllegalAccessException -> L64
        Object[] r16 = new Object[1];     // Catch: IllegalAccessException -> L64
        if (r2 != null) goto L57;
        r2 = UtilKt.defaultPrimitiveValue(((Method) r9).getParameterTypes()[0]);     // Catch: IllegalAccessException -> L64
    L57:
        r16[0] = r2;     // Catch: IllegalAccessException -> L64
        return r15.invoke(null, r16);
    L47:
        if (r14 != 2) goto L53;
        Method r17 = (Method) r9;     // Catch: IllegalAccessException -> L64
        Object[] r0 = new Object[2];     // Catch: IllegalAccessException -> L64
        r0[0] = r2;     // Catch: IllegalAccessException -> L64
        if (r10 != null) goto L51;
        r10 = UtilKt.defaultPrimitiveValue(((Method) r9).getParameterTypes()[1]);     // Catch: IllegalAccessException -> L64
    L51:
        r0[1] = r10;     // Catch: IllegalAccessException -> L64
        return r17.invoke(null, r0);
    L53:
        throw new AssertionError("delegate method " + r9 + " should take 0, 1, or 2 parameters");     // Catch: IllegalAccessException -> L64
    L59:
        return ((Method) r9).invoke(null, new Object[0]);
    L61:
        throw new AssertionError("delegate field/method " + r9 + " neither field nor method");     // Catch: IllegalAccessException -> L64
    L33:
        r13 = null;
        goto L34
    L26:
        r12 = false;
        goto L27
    L15:
        r6 = false;
        goto L17
    L11:
        r2 = r10;
    L7:
        if (m171getDescriptor().getExtensionReceiverParameter() != null) goto L9;
        throw new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");     // Catch: IllegalAccessException -> L64
    L64:
        e = move-exception;
        throw new IllegalPropertyDelegateAccessException(e);
    }

    public KPropertyImpl(KDeclarationContainerImpl r8, String r9, String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r8, "container");
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r10, "signature");
        this(r8, r9, r10, null, r11);
    }

    private KPropertyImpl(KDeclarationContainerImpl r1, String r2, String r3, PropertyDescriptor r4, Object r5) {
        this.container = r1;
        this.name = r2;
        this.signature = r3;
        this.rawBoundReceiver = r5;
        this._javaField = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPropertyImpl$$Lambda$0(this));
        this._descriptor = ReflectProperties.lazySoft(r4, new KPropertyImpl$$Lambda$1(this));
    }
}
