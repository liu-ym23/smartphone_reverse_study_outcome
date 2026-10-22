package kotlinx.coroutines.debug.internal;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes42.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f504729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentWeakMap<a<?>, Boolean> f504730b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Function1<Boolean, Unit> f504731c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentWeakMap<CoroutineStackFrame, kotlinx.coroutines.debug.internal.b> f504732d = null;

    public static final class a<T> implements Continuation<T>, CoroutineStackFrame {
        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            throw null;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public final CoroutineStackFrame getCallerFrame() {
            throw null;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public final StackTraceElement getStackTraceElement() {
            throw null;
        }

        public final String toString() {
            throw null;
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object r100) {
            c.f504729a.getClass();
            c.f504730b.remove(this);
            throw null;
        }
    }

    public c() {
    }

    static {
        f504729a = new c();
        a.a.a(new Exception(), a.c.class.getSimpleName());
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f504730b = new ConcurrentWeakMap(false);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = a().getConstructors()[0].newInstance(new Object[0]);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r101, 1));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        f504731c = (Function1) r102;
        f504732d = new ConcurrentWeakMap(true);
        new b();
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach");
    }
}
