package com.obric.assistant.interaction.api.window;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0017\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b\u001a\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\tH\u0002\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0011H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001e\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"WINDOW_CONTEXT_TAG", "", "logWindowContextCheck", "", "msg", "Lkotlin/Function0;", "findFieldRecursive", "Ljava/lang/reflect/Field;", "clsStart", "Ljava/lang/Class;", "name", "OUTER_CONTEXT_ACCESSOR_CACHE", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/interaction/api/window/OuterContextAccessor;", "buildOuterContextAccessor", "cls", "tryGetOuterContextFromContextImpl", "Landroid/content/Context;", "isWindowContext", "", "api_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IWindowContextKt {
    private static final ConcurrentHashMap<Class<?>, OuterContextAccessor> OUTER_CONTEXT_ACCESSOR_CACHE = null;
    private static final String WINDOW_CONTEXT_TAG = "ObricWindowContext";

    public static /* synthetic */ OuterContextAccessor a(Function1 r100, Object r101) {
        return tryGetOuterContextFromContextImpl$lambda$9(r100, r101);
    }

    public static /* synthetic */ OuterContextAccessor b(Class r100) {
        return tryGetOuterContextFromContextImpl$lambda$8(r100);
    }

    private static final void logWindowContextCheck(Function0<String> r100) {
    }

    static {
        OUTER_CONTEXT_ACCESSOR_CACHE = new ConcurrentHashMap();
    }

    private static final OuterContextAccessor buildOuterContextAccessor(Class<?> r100) {
        if (StringsKt.endsWith$default(r100.getName(), "ContextImpl", false, 2, null) == false) goto L5;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Method r102 = r100.getDeclaredMethod("getOuterContext", new Class[0]);     // Catch: Throwable -> L8
        r102.setAccessible(true);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L8
        return new MethodOuterContextAccessor(r102);
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        Field r104 = findFieldRecursive(r100, "mOuterContext");     // Catch: Throwable -> L16
        if (r104 != null) goto L13;
        Object r105 = NoOuterContextAccessor.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L16
    L18:
        Result.m9452exceptionOrNullimpl(r106);
        NoOuterContextAccessor r107 = NoOuterContextAccessor.INSTANCE;
        if (Result.m9455isFailureimpl(r106) == false) goto L22;
        r106 = r107;
    L22:
        return (OuterContextAccessor) r106;
    L13:
        r105 = new FieldOuterContextAccessor(r104);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        return NoOuterContextAccessor.INSTANCE;
    }

    public static final boolean isWindowContext(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Application) == false) goto L8;
        return false;
    L8:
        IdentityHashMap r101 = new IdentityHashMap(8);
        int r102 = 0;
    L10:
        if (r101.put(r100, Boolean.TRUE) != null) goto L38;
        int r103 = r102 + 1;
        if (r102 >= 32) goto L38;
        if ((r100 instanceof IChatWindowActivity) == true) goto L43;
        if ((r100 instanceof IWindowContext) == true) goto L56;
        Context r104 = tryGetOuterContextFromContextImpl(r100);
        if (r104 == null) goto L31;
        if (r104 == r100) goto L31;
        if ((r104 instanceof Application) == true) goto L25;
        if (r101.containsKey(r104) == true) goto L38;
    L29:
        r100 = r104;
        r102 = r103;
        goto L10
    L25:
        return false;
    L31:
        if ((r100 instanceof ContextWrapper) == false) goto L33;
        ContextWrapper r105 = (ContextWrapper) r100;
    L34:
        if (r105 == null) goto L38;
        r104 = r105.getBaseContext();
        if (r104 == r100) goto L38;
        if ((r104 instanceof Application) == true) goto L41;
        Intrinsics.checkNotNull(r104);
        goto L29
    L41:
        return false;
    L33:
        r105 = null;
        goto L34
    L56:
        return true;
    L43:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.assistant.interaction.api.window.a] */
    private static final Context tryGetOuterContextFromContextImpl(Context r100) {
        Class<?> r101 = r100.getClass();
        ConcurrentHashMap<Class<?>, OuterContextAccessor> r102 = OUTER_CONTEXT_ACCESSOR_CACHE;
        final ?? r103 = new a();
        Context r104 = r102.computeIfAbsent(r101, new b(r103)).getOuter(r100);
        if (r104 != null) goto L6;
        return null;
    L6:
        return r104;
    }

    private static final OuterContextAccessor tryGetOuterContextFromContextImpl$lambda$8(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return buildOuterContextAccessor(r100);
    }

    private static final Field findFieldRecursive(Class<?> r100, String r101) {
    L2:
        if (r100 == null) goto L6;
        Field r102 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L5
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return r102;
    L5:
        r100 = r100.getSuperclass();
        goto L2
    L6:
        return null;
    }

    private static final OuterContextAccessor tryGetOuterContextFromContextImpl$lambda$9(Function1 r100, Object r101) {
        return (OuterContextAccessor) r100.invoke(r101);
    }
}
