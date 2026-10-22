package kotlin.reflect.jvm.internal;

import android.util.EventsUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u00107\u001a\u00028\u00002\u0016\u00108\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010:09\"\u0004\u0018\u00010:H\u0016¢\u0006\u0002\u0010;J#\u0010<\u001a\u00028\u00002\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010:0=H\u0016¢\u0006\u0002\u0010>J\u0015\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:09H\u0002¢\u0006\u0002\u0010AJ3\u0010B\u001a\u00028\u00002\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010:0=2\f\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010DH\u0000¢\u0006\u0004\bE\u0010FJ\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020!H\u0002J#\u0010L\u001a\u00028\u00002\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010:0=H\u0002¢\u0006\u0002\u0010>J\u0010\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020'H\u0002J\n\u0010O\u001a\u0004\u0018\u00010PH\u0002R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R(\u0010\u0017\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001a \u001b*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020! \u001b*\n\u0012\u0004\u0012\u00020!\u0018\u00010 0 0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u001c\u0010$\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010%0%0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R(\u0010*\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020+ \u001b*\n\u0012\u0004\u0012\u00020+\u0018\u00010\u00190\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u001eR\u0016\u0010/\u001a\u0004\u0018\u0001008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0016R\u0014\u00104\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0016R\u0014\u00105\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u0014\u00106\u001a\u00020\u00158DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0016R,\u0010?\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010: \u001b*\f\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u000109090\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00150HX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "<init>", "()V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "getDefaultCaller", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "isBound", XmlPullParser.NO_NAMESPACE, "()Z", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "kotlin.jvm.PlatformType", "annotations", "getAnnotations", "()Ljava/util/List;", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "parameters", "getParameters", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isOpen", "isAbstract", "isAnnotationConstructor", "call", "args", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", XmlPullParser.NO_NAMESPACE, "(Ljava/util/Map;)Ljava/lang/Object;", "_absentArguments", "getAbsentArguments", "()[Ljava/lang/Object;", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parametersNeedMFVCFlattening", "Lkotlin/Lazy;", "getParameterTypeSize", XmlPullParser.NO_NAMESPACE, "parameter", "callAnnotationConstructor", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazySoftVal<Object[]> _absentArguments;
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;
    private final Lazy<Boolean> parametersNeedMFVCFlattening;

    private static final ParameterDescriptor _parameters$lambda$5$lambda$1(ReceiverParameterDescriptor r0) {
        return r0;
    }

    private static final ParameterDescriptor _parameters$lambda$5$lambda$2(ReceiverParameterDescriptor r0) {
        return r0;
    }

    public static /* synthetic */ List accessor$KCallableImpl$lambda0(KCallableImpl r0) {
        return _annotations$lambda$0(r0);
    }

    public static /* synthetic */ ArrayList accessor$KCallableImpl$lambda1(KCallableImpl r0) {
        return _parameters$lambda$5(r0);
    }

    public static /* synthetic */ KTypeImpl accessor$KCallableImpl$lambda2(KCallableImpl r0) {
        return _returnType$lambda$7(r0);
    }

    public static /* synthetic */ List accessor$KCallableImpl$lambda3(KCallableImpl r0) {
        return _typeParameters$lambda$9(r0);
    }

    public static /* synthetic */ Object[] accessor$KCallableImpl$lambda4(KCallableImpl r0) {
        return _absentArguments$lambda$14(r0);
    }

    public static /* synthetic */ boolean accessor$KCallableImpl$lambda5(KCallableImpl r0) {
        return parametersNeedMFVCFlattening$lambda$20(r0);
    }

    public static /* synthetic */ ParameterDescriptor accessor$KCallableImpl$lambda6(ReceiverParameterDescriptor r0) {
        return _parameters$lambda$5$lambda$1(r0);
    }

    public static /* synthetic */ ParameterDescriptor accessor$KCallableImpl$lambda7(ReceiverParameterDescriptor r0) {
        return _parameters$lambda$5$lambda$2(r0);
    }

    public static /* synthetic */ ParameterDescriptor accessor$KCallableImpl$lambda8(CallableMemberDescriptor r0, int r1) {
        return _parameters$lambda$5$lambda$3(r0, r1);
    }

    public static /* synthetic */ Type accessor$KCallableImpl$lambda9(KCallableImpl r0) {
        return _returnType$lambda$7$lambda$6(r0);
    }

    public abstract Caller<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    public abstract boolean isBound();

    private final Object[] getAbsentArguments() {
        return (Object[]) this._absentArguments.invoke().clone();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return this._annotations.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        return this._parameters.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return this._returnType.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        return this._typeParameters.invoke();
    }

    public KCallableImpl() {
        this._annotations = ReflectProperties.lazySoft(new KCallableImpl$$Lambda$0(this));
        this._parameters = ReflectProperties.lazySoft(new KCallableImpl$$Lambda$1(this));
        this._returnType = ReflectProperties.lazySoft(new KCallableImpl$$Lambda$2(this));
        this._typeParameters = ReflectProperties.lazySoft(new KCallableImpl$$Lambda$3(this));
        this._absentArguments = ReflectProperties.lazySoft(new KCallableImpl$$Lambda$4(this));
        this.parametersNeedMFVCFlattening = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KCallableImpl$$Lambda$5(this));
    }

    private final Type extractContinuationArgument() {
        if (isSuspend() == false) goto L22;
        Object r0 = CollectionsKt.lastOrNull(getCaller().getParameterTypes());
        if ((r0 instanceof ParameterizedType) == false) goto L7;
        ParameterizedType r1 = (ParameterizedType) r0;
    L8:
        if (r1 == null) goto L10;
        Type r2 = r1.getRawType();
    L12:
        if (Intrinsics.areEqual(r2, Continuation.class) == false) goto L23;
        Object r3 = ArraysKt.single(r1.getActualTypeArguments());
        if ((r3 instanceof WildcardType) == false) goto L16;
        WildcardType r4 = (WildcardType) r3;
    L17:
        if (r4 == null) goto L24;
        Type[] r5 = r4.getLowerBounds();
        if (r5 != null) goto L21;
        return null;
    L21:
        return (Type) ArraysKt.first(r5);
    L24:
        return null;
    L16:
        r4 = null;
        goto L17
    L23:
        return null;
    L10:
        r2 = null;
        goto L12
    L7:
        r1 = null;
        goto L8
    L22:
        return null;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        return UtilKt.toKVisibility(getDescriptor().getVisibility());
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        if (getDescriptor().getModality() != Modality.ABSTRACT) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isAnnotationConstructor() {
        if (Intrinsics.areEqual(getName(), "<init>") == true) goto L5;
    L7:
        return false;
    L5:
        if (getContainer().getJClass().isAnnotation() == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        if (getDescriptor().getModality() != Modality.FINAL) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        if (getDescriptor().getModality() != Modality.OPEN) goto L5;
        return true;
    L5:
        return false;
    }

    private static final Object[] _absentArguments$lambda$14(KCallableImpl r9) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        List<KParameter> r0 = r9.getParameters();
        int r1 = r0.size() + (r9.isSuspend() ? 1 : 0);
        if (r9.parametersNeedMFVCFlattening.getValue().booleanValue() == false) goto L12;
        Iterator<T> r2 = r0.iterator();
        int r5 = 0;
    L6:
        if (r2.hasNext() == false) goto L28;
        KParameter r6 = (KParameter) r2.next();
        if (r6.getKind() != KParameter.Kind.VALUE) goto L10;
        int r7 = r9.getParameterTypeSize(r6);
    L11:
        r5 = r5 + r7;
        goto L6
    L10:
        r7 = 0;
    L28:
        int r8 = ((r5 + 32) - 1) / 32;
        Object[] r3 = new Object[(r1 + r8) + 1];
        Iterator<T> r4 = r0.iterator();
    L30:
        if (r4.hasNext() == false) goto L39;
        KParameter r10 = (KParameter) r4.next();
        if (r10.isOptional() == false) goto L37;
        if (UtilKt.isInlineClassType(r10.getType()) == true) goto L37;
        r3[r10.getIndex()] = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(r10.getType()));
    L37:
        if (r10.isVararg() == false) goto L30;
        r3[r10.getIndex()] = r9.defaultEmptyArray(r10.getType());
        goto L30
    L39:
        int r11 = 0;
    L40:
        if (r11 >= r8) goto L42;
        r3[r1 + r11] = 0;
        r11 = r11 + 1;
        goto L40
    L42:
        return r3;
    L12:
        List<KParameter> r12 = r0;
        if ((r12 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r13 = r12.iterator();
        r5 = 0;
    L19:
        if (r13.hasNext() == false) goto L28;
        if (((KParameter) r13.next()).getKind() != KParameter.Kind.VALUE) goto L23;
        boolean r14 = true;
    L24:
        if (r14 == false) goto L19;
        r5 = r5 + 1;
        if (r5 >= 0) goto L19;
        CollectionsKt.throwCountOverflow();
        goto L19
    L23:
        r14 = false;
        goto L24
    L15:
        if (r12.isEmpty() == false) goto L17;
        r5 = 0;
        goto L28
    }

    private static final List _annotations$lambda$0(KCallableImpl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return UtilKt.computeAnnotations(r1.getDescriptor());
    }

    private static final ArrayList _parameters$lambda$5(KCallableImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        CallableMemberDescriptor r0 = r10.getDescriptor();
        ArrayList r1 = new ArrayList();
        int r4 = 0;
        if (r10.isBound() == true) goto L11;
        ReceiverParameterDescriptor r2 = UtilKt.getInstanceReceiverParameter(r0);
        if (r2 == null) goto L7;
        r1.add(new KParameterImpl(r10, 0, KParameter.Kind.INSTANCE, new KCallableImpl$.Lambda.6(r2)));
        int r3 = 1;
    L8:
        ReceiverParameterDescriptor r5 = r0.getExtensionReceiverParameter();
        if (r5 == null) goto L12;
        r1.add(new KParameterImpl(r10, r3, KParameter.Kind.EXTENSION_RECEIVER, new KCallableImpl$.Lambda.7(r5)));
        r3 = r3 + 1;
    L12:
        int r6 = r0.getValueParameters().size();
    L13:
        if (r4 >= r6) goto L16;
        r1.add(new KParameterImpl(r10, r3, KParameter.Kind.VALUE, new KCallableImpl$.Lambda.8(r0, r4)));
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L13
    L16:
        if (r10.isAnnotationConstructor() == true) goto L18;
    L22:
        r1.trimToSize();
        return r1;
    L18:
        if ((r0 instanceof JavaCallableMemberDescriptor) == false) goto L22;
        if (r1.size() <= 1) goto L22;
        CollectionsKt.sortWith(r1, new KCallableImpl$_parameters$lambda$5$.inlined.sortBy.1());
        goto L22
    L7:
        r3 = 0;
        goto L8
    L11:
        r3 = 0;
        goto L12
    }

    private static final KTypeImpl _returnType$lambda$7(KCallableImpl r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        KotlinType r1 = r3.getDescriptor().getReturnType();
        Intrinsics.checkNotNull(r1);
        return new KTypeImpl(r1, new KCallableImpl$.Lambda.9(r3));
    }

    private static final Type _returnType$lambda$7$lambda$6(KCallableImpl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Type r0 = r1.extractContinuationArgument();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1.getCaller().getReturnType();
    }

    private static final List _typeParameters$lambda$9(KCallableImpl r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        List r0 = r4.getDescriptor().getTypeParameters();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        TypeParameterDescriptor r3 = (TypeParameterDescriptor) r2.next();
        Intrinsics.checkNotNull(r3);
        r1.add(new KTypeParameterImpl(r4, r3));
        goto L4
    L6:
        return r1;
    }

    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> r5) {
        List<KParameter> r0 = getParameters();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L21;
        KParameter r3 = (KParameter) r2.next();
        if (r5.containsKey(r3) == false) goto L13;
        Object r4 = r5.get(r3);
        if (r4 != null) goto L18;
        throw new IllegalArgumentException("Annotation argument value cannot be null (" + r3 + ')');
    L18:
        r1.add(r4);
        goto L4
    L13:
        if (r3.isOptional() == false) goto L16;
        r4 = null;
        goto L18
    L16:
        if (r3.isVararg() == false) goto L20;
        r4 = defaultEmptyArray(r3.getType());
        goto L18
    L20:
        throw new IllegalArgumentException("No argument provided for a required parameter: " + r3);
    L21:
        Caller<?> r6 = getDefaultCaller();
        if (r6 == null) goto L30;
        return (R) r6.call(r1.toArray(new Object[0]));
    L26:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    L30:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    }

    private final Object defaultEmptyArray(KType r4) {
        Class r5 = JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(r4));
        if (r5.isArray() == false) goto L7;
        return Array.newInstance(r5.getComponentType(), 0);
    L7:
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + r5.getSimpleName() + ", because it is not an array type");
    }

    private final int getParameterTypeSize(KParameter r2) {
        if (this.parametersNeedMFVCFlattening.getValue().booleanValue() == false) goto L10;
        if (UtilKt.getNeedsMultiFieldValueClassFlattening(r2.getType()) == false) goto L7;
        KTypeImpl r3 = r2.getType();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        List r4 = ValueClassAwareCallerKt.getMfvcUnboxMethods(TypeSubstitutionKt.asSimpleType(r3.getType()));
        Intrinsics.checkNotNull(r4);
        return r4.size();
    L7:
        return 1;
    L10:
        throw new IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before".toString());
    }

    private static final boolean parametersNeedMFVCFlattening$lambda$20(KCallableImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        List<KParameter> r3 = r2.getParameters();
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        if (UtilKt.getNeedsMultiFieldValueClassFlattening(((KParameter) r4.next()).getType()) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r3.isEmpty() == false) goto L7;
        return false;
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        return (R) getCaller().call(r2);
    L5:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<KParameter, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        if (isAnnotationConstructor() == false) goto L6;
        return callAnnotationConstructor(r2);
    L6:
        return callDefaultMethod$kotlin_reflection(r2, null);
    }

    private static final ParameterDescriptor _parameters$lambda$5$lambda$3(CallableMemberDescriptor r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$descriptor");
        return (ParameterDescriptor) ListProtector.get(r1.getValueParameters(), r2);
    }

    public final R callDefaultMethod$kotlin_reflection(Map<KParameter, ? extends Object> r14, Continuation<?> r15) {
        Intrinsics.checkNotNullParameter(r14, "args");
        List<KParameter> r0 = getParameters();
        boolean r2 = false;
        if (r0.isEmpty() == true) goto L61;
        int r1 = r0.size() + (isSuspend() ? 1 : 0);
        Object[] r4 = getAbsentArguments();
        if (isSuspend() == false) goto L16;
        r4[r0.size()] = r15;
    L16:
        boolean r16 = this.parametersNeedMFVCFlattening.getValue().booleanValue();
        Iterator<KParameter> r3 = r0.iterator();
        int r5 = 0;
    L18:
        if (r3.hasNext() == false) goto L42;
        KParameter r6 = r3.next();
        if (r16 == false) goto L22;
        int r7 = getParameterTypeSize(r6);
    L24:
        if (r14.containsKey(r6) == false) goto L27;
        r4[r6.getIndex()] = r14.get(r6);
    L38:
        if (r6.getKind() != KParameter.Kind.VALUE) goto L18;
        r5 = r5 + r7;
        goto L18
    L27:
        if (r6.isOptional() == false) goto L36;
        if (r16 == false) goto L33;
        int r8 = r5 + r7;
        int r9 = r5;
    L31:
        if (r9 >= r8) goto L34;
        int r10 = (r9 / 32) + r1;
        Object r11 = r4[r10];
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Int");
        r4[r10] = Integer.valueOf(((Integer) r11).intValue() | (1 << (r9 % 32)));
        r9 = r9 + 1;
    L34:
        r2 = true;
        goto L38
    L33:
        int r12 = (r5 / 32) + r1;
        Object r13 = r4[r12];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Int");
        r4[r12] = Integer.valueOf(((Integer) r13).intValue() | (1 << (r5 % 32)));
        goto L34
    L36:
        if (r6.isVararg() == true) goto L38;
        throw new IllegalArgumentException("No argument provided for a required parameter: " + r6);
    L22:
        r7 = 1;
        goto L24
    L42:
        if (r2 == false) goto L57;
        Caller<?> r17 = getDefaultCaller();
        if (r17 == null) goto L56;
        return (R) r17.call(r4);
    L52:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    L56:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    L57:
        return (R) getCaller().call(Arrays.copyOf(r4, r1));
    L45:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    L61:
        Caller<?> r18 = getCaller();     // Catch: IllegalAccessException -> L10
        if (isSuspend() == false) goto L7;
        Continuation[] r19 = {r15};     // Catch: IllegalAccessException -> L10
    L8:
        return (R) r18.call(r19);
    L7:
        r19 = new Continuation[0];     // Catch: IllegalAccessException -> L10
    L10:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    }
}
