package kotlin.jvm.internal;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class Intrinsics {

    /* JADX INFO: loaded from: classes6.dex */
    public static class Kotlin {
        private Kotlin() {
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static int compare(int r100, int r101) {
        if (r100 >= r101) goto L4;
        return -1;
    L4:
        if (r100 != r101) goto L6;
        return 0;
    L6:
        return 1;
    }

    public static int compare(long r100, long r101) {
        if (r100 >= r101) goto L5;
        return -1;
    L5:
        if (r100 != r101) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static void throwAssert() {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError()));
    }

    public static void throwIllegalArgument() {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException()));
    }

    public static void throwIllegalState() {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException()));
    }

    public static void throwJavaNpe() {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException()));
    }

    public static void throwNpe() {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException()));
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    private Intrinsics() {
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_kotlin_jvm_internal_Intrinsics_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void checkHasClass(String r100) throws ClassNotFoundException {
        String r101 = r100.replace('/', '.');
        INVOKESTATIC_kotlin_jvm_internal_Intrinsics_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101);     // Catch: ClassNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException("Class " + r101 + " is not found. Please update the Kotlin runtime to the latest version", e)));
    }

    public static void checkNotNull(Object r100) {
        if (r100 != null) goto L5;
        throwJavaNpe();
        return;
    }

    private static String createParameterIsNullExceptionMessage(String r100) {
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        String r102 = Intrinsics.class.getName();
        int r103 = 0;
    L4:
        if (r101[r103].getClassName().equals(r102) == true) goto L7;
        r103 = r103 + 1;
    L7:
        if (r101[r103].getClassName().equals(r102) == false) goto L9;
        r103 = r103 + 1;
        goto L7
    L9:
        StackTraceElement r104 = r101[r103];
        return "Parameter specified as non-null is null: method " + r104.getClassName() + "." + r104.getMethodName() + ", parameter " + r100;
    }

    public static void needClassReification(String r100) {
        throwUndefinedForReified(r100);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r100) {
        return (T) sanitizeStackTrace(r100, Intrinsics.class.getName());
    }

    public static void throwAssert(String r100) {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(r100)));
    }

    public static void throwIllegalArgument(String r100) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(r100)));
    }

    public static void throwIllegalState(String r100) {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r100)));
    }

    public static void throwJavaNpe(String r100) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(r100)));
    }

    public static void throwNpe(String r100) {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException(r100)));
    }

    private static void throwParameterIsNullIAE(String r100) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(createParameterIsNullExceptionMessage(r100))));
    }

    private static void throwParameterIsNullNPE(String r100) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(createParameterIsNullExceptionMessage(r100))));
    }

    public static void throwUndefinedForReified(String r100) {
        throw new UnsupportedOperationException(r100);
    }

    public static void throwUninitializedProperty(String r100) {
        throw ((UninitializedPropertyAccessException) sanitizeStackTrace(new UninitializedPropertyAccessException(r100)));
    }

    public static void throwUninitializedPropertyAccessException(String r100) {
        throwUninitializedProperty("lateinit property " + r100 + " has not been initialized");
    }

    public static boolean areEqual(Double r100, Double r101) {
        if (r100 != null) goto L6;
        if (r101 == null) goto L12;
    L10:
        return false;
    L12:
        return true;
    L6:
        if (r101 == null) goto L10;
        if (r100.doubleValue() != r101.doubleValue()) goto L10;
        return true;
    }

    public static void checkExpressionValueIsNotNull(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r101 + " must not be null")));
    }

    public static void checkFieldIsNotNull(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r101)));
    }

    public static void checkHasClass(String r100, String r101) throws ClassNotFoundException {
        String r102 = r100.replace('/', '.');
        INVOKESTATIC_kotlin_jvm_internal_Intrinsics_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r102);     // Catch: ClassNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException("Class " + r102 + " is not found: this code requires the Kotlin runtime of version at least " + r101, e)));
    }

    public static void checkNotNull(Object r100, String r101) {
        if (r100 != null) goto L5;
        throwJavaNpe(r101);
        return;
    }

    public static void checkNotNullExpressionValue(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(r101 + " must not be null")));
    }

    public static void checkNotNullParameter(Object r100, String r101) {
        if (r100 != null) goto L5;
        throwParameterIsNullNPE(r101);
        return;
    }

    public static void checkParameterIsNotNull(Object r100, String r101) {
        if (r100 != null) goto L5;
        throwParameterIsNullIAE(r101);
        return;
    }

    public static void checkReturnedValueIsNotNull(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r101)));
    }

    public static void reifiedOperationMarker(int r100, String r101) {
        throwUndefinedForReified();
    }

    public static <T extends Throwable> T sanitizeStackTrace(T r100, String r101) {
        StackTraceElement[] r102 = r100.getStackTrace();
        int r103 = r102.length;
        int r104 = -1;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L8;
        if (r101.equals(r102[r105].getClassName()) == false) goto L7;
        r104 = r105;
    L7:
        r105 = r105 + 1;
        goto L3
    L8:
        r100.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r102, r104 + 1, r103));
        return r100;
    }

    public static String stringPlus(String r100, Object r101) {
        return r100 + r101;
    }

    public static boolean areEqual(Float r100, Float r101) {
        if (r100 != null) goto L6;
        if (r101 == null) goto L12;
    L10:
        return false;
    L12:
        return true;
    L6:
        if (r101 == null) goto L10;
        if (r100.floatValue() != r101.floatValue()) goto L10;
        return true;
    }

    public static boolean areEqual(double r100, Double r101) {
        if (r101 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100 != r101.doubleValue()) goto L6;
        return true;
    }

    public static boolean areEqual(float r100, Float r101) {
        if (r101 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100 != r101.floatValue()) goto L6;
        return true;
    }

    public static boolean areEqual(Double r100, double r101) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.doubleValue() != r101) goto L6;
        return true;
    }

    public static boolean areEqual(Float r100, float r101) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.floatValue() != r101) goto L6;
        return true;
    }

    public static boolean areEqual(Object r100, Object r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r100.equals(r101);
    }

    public static void checkFieldIsNotNull(Object r100, String r101, String r102) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException("Field specified as non-null is null: " + r101 + "." + r102)));
    }

    public static void checkReturnedValueIsNotNull(Object r100, String r101, String r102) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException("Method specified as non-null returned null: " + r101 + "." + r102)));
    }

    public static void reifiedOperationMarker(int r100, String r101, String r102) {
        throwUndefinedForReified(r102);
    }
}
