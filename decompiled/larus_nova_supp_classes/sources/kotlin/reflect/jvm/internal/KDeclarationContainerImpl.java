package kotlin.reflect.jvm.internal;

import android.util.EventsUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 B2\u00020\u0001:\u0004?@ABB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H&J\"\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0004J\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJE\u0010 \u001a\u0004\u0018\u00010!*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000f\u001a\u00020\u001d2\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010%\u001a\u00020&H\u0002¢\u0006\u0002\u0010'J=\u0010(\u001a\u0004\u0018\u00010!*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000f\u001a\u00020\u001d2\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0002\u0010)J(\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0006\u0012\u0002\b\u00030\u00052\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050,H\u0002J\u0018\u0010-\u001a\u0004\u0018\u00010!2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001dJ \u0010/\u001a\u0004\u0018\u00010!2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001d2\u0006\u00100\u001a\u00020&J\u0014\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\u0006\u0010.\u001a\u00020\u001dJ\u0014\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\u0006\u0010.\u001a\u00020\u001dJ4\u00103\u001a\u0002042\u0010\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005062\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050,2\u0006\u00108\u001a\u00020&H\u0002J\u0018\u00109\u001a\u00020:2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020&H\u0002J$\u0010<\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0015H\u0002R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006C"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "<init>", "()V", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "constructorDescriptors", XmlPullParser.NO_NAMESPACE, "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", XmlPullParser.NO_NAMESPACE, "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "findPropertyDescriptor", XmlPullParser.NO_NAMESPACE, "signature", "findFunctionDescriptor", "lookupMethod", "Ljava/lang/reflect/Method;", "parameterTypes", XmlPullParser.NO_NAMESPACE, "returnType", "isStaticDefault", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "tryGetConstructor", "Ljava/lang/reflect/Constructor;", XmlPullParser.NO_NAMESPACE, "findMethodBySignature", "desc", "findDefaultMethod", "isMember", "findConstructorBySignature", "findDefaultConstructor", "addParametersAndMasks", XmlPullParser.NO_NAMESPACE, "result", XmlPullParser.NO_NAMESPACE, "valueParameters", "isConstructor", "parseJvmDescriptor", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$FunctionJvmDescriptor;", "parseReturnType", "parseType", "begin", "end", "Data", "MemberBelonginess", "FunctionJvmDescriptor", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    public static final Companion Companion = null;
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = null;
    private static final Regex LOCAL_PROPERTY_SIGNATURE = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", XmlPullParser.NO_NAMESPACE, "<init>", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "Ljava/lang/Class;", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.access$getLOCAL_PROPERTY_SIGNATURE$cp();
        }
    }

    public KDeclarationContainerImpl() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ int accessor$KDeclarationContainerImpl$lambda0(DescriptorVisibility r0, DescriptorVisibility r1) {
        return findPropertyDescriptor$lambda$3(r0, r1);
    }

    public static /* synthetic */ int accessor$KDeclarationContainerImpl$lambda1(Function2 r0, Object r1, Object r2) {
        return findPropertyDescriptor$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ CharSequence accessor$KDeclarationContainerImpl$lambda2(PropertyDescriptor r0) {
        return findPropertyDescriptor$lambda$5(r0);
    }

    public static /* synthetic */ CharSequence accessor$KDeclarationContainerImpl$lambda3(FunctionDescriptor r0) {
        return findFunctionDescriptor$lambda$9(r0);
    }

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name r1);

    public abstract PropertyDescriptor getLocalProperty(int r1);

    public abstract Collection<PropertyDescriptor> getProperties(Name r1);

    static {
        Companion = new Companion(null);
        DEFAULT_CONSTRUCTOR_MARKER = INVOKESTATIC_kotlin_reflect_jvm_internal_KDeclarationContainerImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.jvm.internal.DefaultConstructorMarker");
        LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");
    }

    public Class<?> getMethodOwner() {
        Class<?> r0 = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getJClass();
    }

    public static final /* synthetic */ Regex access$getLOCAL_PROPERTY_SIGNATURE$cp() {
        return LOCAL_PROPERTY_SIGNATURE;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_kotlin_reflect_jvm_internal_KDeclarationContainerImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private static final CharSequence findFunctionDescriptor$lambda$9(FunctionDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return DescriptorRenderer.DEBUG_TEXT.render(r2) + " | " + RuntimeTypeMapper.INSTANCE.mapSignature(r2).asString();
    }

    private static final CharSequence findPropertyDescriptor$lambda$5(PropertyDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return DescriptorRenderer.DEBUG_TEXT.render(r2) + " | " + RuntimeTypeMapper.INSTANCE.mapPropertySignature(r2).asString();
    }

    public final Constructor<?> findConstructorBySignature(String r3) {
        Intrinsics.checkNotNullParameter(r3, "desc");
        return tryGetConstructor(getJClass(), parseJvmDescriptor(r3, false).getParameters());
    }

    public final Constructor<?> findDefaultConstructor(String r4) {
        Intrinsics.checkNotNullParameter(r4, "desc");
        Class<?> r0 = getJClass();
        ArrayList r1 = new ArrayList();
        addParametersAndMasks(r1, parseJvmDescriptor(r4, false).getParameters(), true);
        Unit r5 = Unit.INSTANCE;
        return tryGetConstructor(r0, r1);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_kotlin_reflect_jvm_internal_KDeclarationContainerImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r3);
    }

    private static final int findPropertyDescriptor$lambda$3(DescriptorVisibility r0, DescriptorVisibility r1) {
        Integer r2 = DescriptorVisibilities.compare(r0, r1);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.intValue();
    }

    private final FunctionJvmDescriptor parseJvmDescriptor(String r10, boolean r11) {
        ArrayList r0 = new ArrayList();
        int r8 = 1;
    L3:
        Class<?> r4 = null;
        if (r10.charAt(r8) == ')') goto L18;
        int r2 = r8;
    L7:
        if (r10.charAt(r2) != '[') goto L9;
        r2 = r2 + 1;
        goto L7
    L9:
        char r3 = r10.charAt(r2);
        if (StringsKt.contains$default("VZCBSIFJD", r3, false, 2, null) == false) goto L13;
        int r5 = r2 + 1;
    L15:
        r0.add(parseType(r10, r8, r5));
        r8 = r5;
        goto L3
    L13:
        if (r3 != 'L') goto L17;
        r5 = StringsKt.indexOf$default(r10, ';', r8, false, 4, null) + 1;
        goto L15
    L17:
        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: ".concat(r10));
    L18:
        if (r11 == false) goto L21;
        r4 = parseType(r10, r8 + 1, r10.length());
    L21:
        return new FunctionJvmDescriptor(r0, r4);
    }

    private final Constructor<?> tryGetConstructor(Class<?> r2, List<? extends Class<?>> r3) {
        Class[] r4 = (Class[]) r3.toArray(new Class[0]);     // Catch: NoSuchMethodException -> L4
        return r2.getDeclaredConstructor((Class[]) Arrays.copyOf(r4, r4.length));
    L4:
        return null;
    }

    public final FunctionDescriptor findFunctionDescriptor(String r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "name");
        Intrinsics.checkNotNullParameter(r19, "signature");
        boolean r4 = true;
        if (Intrinsics.areEqual(r18, "<init>") == false) goto L25;
        List r3 = CollectionsKt.toList(getConstructorDescriptors());
        ArrayList r7 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L6:
        if (r6.hasNext() == false) goto L32;
        Object r8 = r6.next();
        ConstructorDescriptor r9 = (ConstructorDescriptor) r8;
        if (r9.isPrimary() == true) goto L10;
    L21:
        String r10 = RuntimeTypeMapper.INSTANCE.mapSignature(r9).asString();
    L23:
        if (Intrinsics.areEqual(r10, r19) == false) goto L6;
        r7.add(r8);
        goto L6
    L10:
        if (InlineClassesUtilsKt.isMultiFieldValueClass(r9.getContainingDeclaration()) == false) goto L21;
        String r11 = RuntimeTypeMapper.INSTANCE.mapSignature(r9).asString();
        if (StringsKt.startsWith$default(r11, "constructor-impl", false, 2, null) == true) goto L14;
    L16:
        boolean r12 = false;
    L17:
        if (r12 == false) goto L20;
        r10 = StringsKt.removeSuffix(r11, "V") + ValueClassAwareCallerKt.toJvmDescriptor(r9.getContainingDeclaration());
        goto L23
    L20:
        throw new IllegalArgumentException(("Invalid signature of " + r9 + ": " + r11).toString());
    L14:
        if (StringsKt.endsWith$default(r11, ")V", false, 2, null) == false) goto L16;
        r12 = true;
    L32:
        if (r7.size() == 1) goto L43;
        String r5 = CollectionsKt.joinToString$default(r3, "\n", null, null, 0, null, KDeclarationContainerImpl$.Lambda.3.INSTANCE, 30, null);
        StringBuilder r13 = new StringBuilder("Function '");
        r13.append(r18);
        r13.append("' (JVM signature: ");
        r13.append(r19);
        r13.append(") not resolved in ");
        r13.append(this);
        r13.append(':');
        if (r5.length() == 0) goto L37;
        r4 = false;
    L37:
        if (r4 == false) goto L39;
        String r1 = " no members found";
    L40:
        r13.append(r1);
        throw new KotlinReflectionInternalError(r13.toString());
    L39:
        r1 = "\n" + r5;
        goto L40
    L43:
        return (FunctionDescriptor) CollectionsKt.single(r7);
    L25:
        r3 = getFunctions(Name.identifier(r18));
        r7 = new ArrayList();
        Iterator<T> r14 = r3.iterator();
    L27:
        if (r14.hasNext() == false) goto L32;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) r15).asString(), r19) == false) goto L27;
        r7.add(r15);
        goto L27
    }

    public final Method findMethodBySignature(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r10, "desc");
        if (Intrinsics.areEqual(r9, "<init>") == false) goto L5;
        return null;
    L5:
        FunctionJvmDescriptor r11 = parseJvmDescriptor(r10, true);
        Class<?>[] r0 = (Class[]) r11.getParameters().toArray(new Class[0]);
        Class<?> r12 = r11.getReturnType();
        Intrinsics.checkNotNull(r12);
        Method r2 = lookupMethod(getMethodOwner(), r9, r0, r12, false);
        if (r2 == null) goto L9;
        return r2;
    L9:
        if (getMethodOwner().isInterface() == false) goto L13;
        Method r13 = lookupMethod(Object.class, r9, r0, r12, false);
        if (r13 == null) goto L13;
        return r13;
    L13:
        return null;
    }

    public final PropertyDescriptor findPropertyDescriptor(String r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "name");
        Intrinsics.checkNotNullParameter(r20, "signature");
        MatchResult r3 = LOCAL_PROPERTY_SIGNATURE.matchEntire(r20);
        boolean r4 = true;
        if (r3 == null) goto L9;
        String r1 = (String) ListProtector.get(r3.getDestructured().getMatch().getGroupValues(), 1);
        PropertyDescriptor r2 = getLocalProperty(CastIntegerProtector.parseInt(r1));
        if (r2 == null) goto L8;
        return r2;
    L8:
        throw new KotlinReflectionInternalError("Local property #" + r1 + " not found in " + getJClass());
    L9:
        Collection<PropertyDescriptor> r5 = getProperties(Name.identifier(r19));
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L16;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) r8).asString(), r20) == false) goto L11;
        r6.add(r8);
        goto L11
    L16:
        if (r6.isEmpty() == true) goto L42;
        if (r6.size() == 1) goto L40;
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r10 = r6.iterator();
    L21:
        if (r10.hasNext() == false) goto L26;
        Object r11 = r10.next();
        DescriptorVisibility r12 = ((PropertyDescriptor) r11).getVisibility();
        Object r13 = r9.get(r12);
        if (r13 != null) goto L25;
        r13 = new ArrayList();
        r9.put(r12, r13);
    L25:
        ((List) r13).add(r11);
        goto L21
    L26:
        List r14 = (List) CollectionsKt.last(MapsKt.toSortedMap(r9, new KDeclarationContainerImpl$.Lambda.1(KDeclarationContainerImpl$.Lambda.0.INSTANCE)).values());
        if (r14.size() != 1) goto L30;
        Intrinsics.checkNotNull(r14);
        return (PropertyDescriptor) CollectionsKt.first(r14);
    L30:
        String r15 = CollectionsKt.joinToString$default(getProperties(Name.identifier(r19)), "\n", null, null, 0, null, KDeclarationContainerImpl$.Lambda.2.INSTANCE, 30, null);
        StringBuilder r16 = new StringBuilder("Property '");
        r16.append(r19);
        r16.append("' (JVM signature: ");
        r16.append(r20);
        r16.append(") not resolved in ");
        r16.append(this);
        r16.append(':');
        if (r15.length() == 0) goto L34;
        r4 = false;
    L34:
        if (r4 == false) goto L36;
        String r17 = " no members found";
    L37:
        r16.append(r17);
        throw new KotlinReflectionInternalError(r16.toString());
    L36:
        r17 = "\n" + r15;
        goto L37
    L40:
        return (PropertyDescriptor) CollectionsKt.single(r6);
    L42:
        throw new KotlinReflectionInternalError("Property '" + r19 + "' (JVM signature: " + r20 + ") not resolved in " + this);
    }

    public final Collection<KCallableImpl<?>> getMembers(MemberScope r8, MemberBelonginess r9) {
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r9, "belonginess");
        getMembers.visitor.1 r0 = new getMembers.visitor.1(this);
        Collection r10 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r8, null, null, 3, null);
        ArrayList r1 = new ArrayList();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        CallableMemberDescriptor r3 = (DeclarationDescriptor) r11.next();
        if ((r3 instanceof CallableMemberDescriptor) == false) goto L12;
        CallableMemberDescriptor r4 = r3;
        if (Intrinsics.areEqual(r4.getVisibility(), DescriptorVisibilities.INVISIBLE_FAKE) == true) goto L12;
        if (r9.accept(r4) == false) goto L12;
        KCallableImpl r5 = (KCallableImpl) r3.accept(r0, Unit.INSTANCE);
    L13:
        if (r5 == null) goto L4;
        r1.add(r5);
    L12:
        r5 = null;
        goto L13
    L16:
        return CollectionsKt.toList(r1);
    }

    private final void addParametersAndMasks(List<Class<?>> r3, List<? extends Class<?>> r4, boolean r5) {
        int r1 = 0;
        if (Intrinsics.areEqual(CollectionsKt.lastOrNull(r4), DEFAULT_CONSTRUCTOR_MARKER) == false) goto L5;
        r4 = r4.subList(0, r4.size() - 1);
    L5:
        r3.addAll(r4);
        int r6 = ((r4.size() + 32) - 1) / 32;
    L6:
        if (r1 >= r6) goto L8;
        r3.add(Integer.TYPE);
        r1 = r1 + 1;
        goto L6
    L8:
        if (r5 == false) goto L10;
        Class<?> r7 = DEFAULT_CONSTRUCTOR_MARKER;
    L11:
        Intrinsics.checkNotNull(r7);
        r3.add(r7);
        return;
    L10:
        r7 = Object.class;
        goto L11
    }

    private static final int findPropertyDescriptor$lambda$4(Function2 r1, Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        return ((Number) r1.invoke(r2, r3)).intValue();
    }

    private final Class<?> parseType(String r8, int r9, int r10) {
        char r0 = r8.charAt(r9);
        if (r0 != 'L') goto L6;
        return INVOKEVIRTUAL_kotlin_reflect_jvm_internal_KDeclarationContainerImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ReflectClassUtilKt.getSafeClassLoader(getJClass()), StringsKt.replace$default(r8.substring(r9 + 1, r10 - 1), '/', '.', false, 4, null));
    L6:
        if (r0 != '[') goto L9;
        return UtilKt.createArrayType(parseType(r8, r9 + 1, r10));
    L9:
        if (r0 != 'V') goto L12;
        return Void.TYPE;
    L12:
        if (r0 != 'Z') goto L15;
        return Boolean.TYPE;
    L15:
        if (r0 != 'C') goto L18;
        return Character.TYPE;
    L18:
        if (r0 != 'B') goto L21;
        return Byte.TYPE;
    L21:
        if (r0 != 'S') goto L24;
        return Short.TYPE;
    L24:
        if (r0 != 'I') goto L27;
        return Integer.TYPE;
    L27:
        if (r0 != 'F') goto L30;
        return Float.TYPE;
    L30:
        if (r0 != 'J') goto L33;
        return Long.TYPE;
    L33:
        if (r0 != 'D') goto L37;
        return Double.TYPE;
    L37:
        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: ".concat(r8));
    }

    public final Method findDefaultMethod(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "desc");
        if (Intrinsics.areEqual(r10, "<init>") == false) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        if (r12 == false) goto L9;
        r0.add(getJClass());
    L9:
        FunctionJvmDescriptor r13 = parseJvmDescriptor(r11, true);
        addParametersAndMasks(r0, r13.getParameters(), false);
        Class<?> r4 = getMethodOwner();
        String r5 = r10 + "$default";
        Class<?>[] r6 = (Class[]) r0.toArray(new Class[0]);
        Class<?> r7 = r13.getReturnType();
        Intrinsics.checkNotNull(r7);
        return lookupMethod(r4, r5, r6, r7, r12);
    }

    private final Method tryGetMethod(Class<?> r7, String r8, Class<?>[] r9, Class<?> r10) {
        Method r1 = r7.getDeclaredMethod(r8, (Class[]) Arrays.copyOf(r9, r9.length));     // Catch: NoSuchMethodException -> L20
        if (Intrinsics.areEqual(r1.getReturnType(), r10) == true) goto L19;
        Method[] r11 = r7.getDeclaredMethods();     // Catch: NoSuchMethodException -> L20
        int r2 = r11.length;     // Catch: NoSuchMethodException -> L20
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L27;
        Method r4 = r11[r3];     // Catch: NoSuchMethodException -> L20
        if (Intrinsics.areEqual(r4.getName(), r8) == true) goto L11;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L25;
        r3 = r3 + 1;
        goto L7
    L25:
        return r4;
    L11:
        if (Intrinsics.areEqual(r4.getReturnType(), r10) == false) goto L15;
        if (Arrays.equals(r4.getParameterTypes(), r9) == false) goto L15;
        r5 = true;
        goto L16
    L27:
        return null;
    L19:
        return r1;
    L26:
        return null;
    }

    private final Method lookupMethod(Class<?> r9, String r10, Class<?>[] r11, Class<?> r12, boolean r13) {
        if (r13 == false) goto L5;
        r11[0] = r9;
    L5:
        Method r1 = tryGetMethod(r9, r10, r11, r12);
        if (r1 == null) goto L8;
        return r1;
    L8:
        Class<? super Object> r3 = r9.getSuperclass();
        if (r3 == null) goto L13;
        Method r2 = lookupMethod(r3, r10, r11, r12, r13);
        if (r2 == null) goto L13;
        return r2;
    L13:
        Iterator r14 = ArrayIteratorKt.iterator(r9.getInterfaces());
    L15:
        if (r14.hasNext() == false) goto L25;
        Class<?> r4 = (Class) r14.next();
        Intrinsics.checkNotNull(r4);
        Method r5 = lookupMethod(r4, r10, r11, r12, r13);
        if (r5 != null) goto L18;
        if (r13 == false) goto L15;
        Class<?> r6 = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(r4), r4.getName().concat("$DefaultImpls"));
        if (r6 == null) goto L15;
        r11[0] = r4;
        Method r7 = tryGetMethod(r6, r10, r11, r12);
        if (r7 == null) goto L15;
        return r7;
    L18:
        return r5;
    L25:
        return null;
    }
}
