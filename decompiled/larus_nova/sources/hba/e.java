package hba;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.AttachedSurfaceControl;
import android.view.SurfaceControl;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.activation.presentation.runtime.surface.ObricRootSurfaceEvent;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f484506a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f484507b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f484508c = null;

    public static final class a implements g, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f484509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f484510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f484511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f484512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f484513e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f484514f;

        public final void b() {
            if (this.f484514f == true) goto L5;
            return;
        L5:
            this.f484514f = false;
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
            this.f484510b.onRootSurfaceDestroyed();     // Catch: Throwable -> L8
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            Result.Companion r101 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        public final void c() {
            e();
            e.f484506a.getClass();     // Catch: Throwable -> L16
            Class r100 = (Class) e.f484507b.getValue();     // Catch: Throwable -> L16
            if (r100 == null) goto L15;
            final AttachedSurfaceControl r101 = this.f484509a.getRootSurfaceControl();     // Catch: Throwable -> L16
            if (r101 == null) goto L13;
            Object r102 = Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new d(this, r101));     // Catch: Throwable -> L16
            Method r103 = e.g(r101.getClass(), "addSurfaceChangedCallback", new Class[]{r100});     // Catch: Throwable -> L16
            if (r103 == null) goto L11;
            r103.invoke(r101, new Object[]{r102});     // Catch: Throwable -> L16
            this.f484512d = r101;     // Catch: Throwable -> L16
            this.f484513e = r102;     // Catch: Throwable -> L16
            a(r101, ObricRootSurfaceEvent.INITIAL, null);     // Catch: Throwable -> L16
            return;
        L11:
            throw new NoSuchMethodException("addSurfaceChangedCallback");     // Catch: Throwable -> L16
        L13:
            throw new IllegalStateException("rootSurfaceControl unavailable");     // Catch: Throwable -> L16
        L15:
            throw new ClassNotFoundException("ViewRootImpl.SurfaceChangedCallback");     // Catch: Throwable -> L16
        L16:
            th = th;
            e();
            Throwable r104 = th.getCause();
            if (r104 == null) goto L21;
            th = r104;
        L21:
            d("reflection_".concat(th.getClass().getSimpleName()));
        }

        @Override // hba.g
        public final void close() {
            if (this.f484511c == false) goto L5;
            return;
        L5:
            this.f484511c = true;
            this.f484509a.removeOnAttachStateChangeListener(this);
            e();
            b();
        }

        public final void e() {
            Object r100 = this.f484512d;
            Object r101 = this.f484513e;
            Object r102 = null;
            this.f484512d = null;
            this.f484513e = null;
            if (r100 == null) goto L19;
            if (r101 == null) goto L20;
            e.f484506a.getClass();
            Class r103 = (Class) e.f484507b.getValue();
            if (r103 != null) goto L17;
            return;
        L17:
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L14
            Method r105 = e.g(r100.getClass(), "removeSurfaceChangedCallback", new Class[]{r103});     // Catch: Throwable -> L14
            if (r105 == null) goto L12;
            r102 = r105.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L14
        L12:
            Result.m9449constructorimpl(r102);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return;
        L20:
            return;
        }

        public final void d(String r100) {
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
            this.f484510b.onRootSurfaceUnavailable(r100);     // Catch: Throwable -> L4
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Result.Companion r102 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (this.f484511c == true) goto L6;
            c();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            e();
            b();
        }

        public a(View r100, f r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "listener");
            this.f484509a = r100;
            this.f484510b = r101;
        }

        public final void a(Object r100, ObricRootSurfaceEvent r101, SurfaceControl.Transaction r102) {
            if (this.f484511c == false) goto L5;
            return;
        L5:
            if (this.f484512d == r100) goto L8;
            return;
        L8:
            if (r101 == ObricRootSurfaceEvent.INITIAL) goto L12;
            if (r102 != null) goto L12;
            d("missing_callback_transaction");
            return;
        L12:
            Object r103 = null;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L23
            e.f484506a.getClass();     // Catch: Throwable -> L23
            Method r105 = e.g(r100.getClass(), "getSurfaceControl", new Class[0]);     // Catch: Throwable -> L23
            if (r105 == null) goto L16;
            Object r106 = r105.invoke(r100, new Object[0]);     // Catch: Throwable -> L23
        L18:
            if ((r106 instanceof SurfaceControl) == false) goto L20;
            SurfaceControl r107 = (SurfaceControl) r106;     // Catch: Throwable -> L23
        L21:
            Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L23
        L26:
            if (Result.m9455isFailureimpl(r108) == true) goto L29;
            r103 = r108;
        L29:
            SurfaceControl r109 = (SurfaceControl) r103;
            e.f484506a.getClass();
            if (e.e(r109) == false) goto L32;
            this.f484514f = true;
            f r110 = this.f484510b;     // Catch: Throwable -> L42
            if (r109 == null) goto L41;
            r110.onRootSurfaceAvailable(r109, r101, r102);     // Catch: Throwable -> L42
            Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L42
        L44:
            Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
            if (r112 == null) goto L52;
            d("listener_".concat(r112.getClass().getSimpleName()));
            return;
        L52:
            return;
        L41:
            throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L44
        L32:
            if (r101 != ObricRootSurfaceEvent.INITIAL) goto L34;
            return;
        L34:
            b();
            d("invalid_root_surface");
            return;
        L20:
            r107 = null;
            goto L21
        L16:
            r106 = null;
        L23:
            th = move-exception;
            Result.Companion r114 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L26
        }
    }

    public e() {
    }

    static {
        f484506a = new e();
        f484507b = LazyKt.lazy(new hba.a());
        f484508c = LazyKt.lazy(new b());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.ViewRootImpl$SurfaceChangedCallback");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.ViewRootImpl$SurfaceChangedCallback");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.ViewRootImpl$SurfaceChangedCallback");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.ViewRootImpl$SurfaceChangedCallback");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.ViewRootImpl$SurfaceChangedCallback");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.ViewRootImpl$SurfaceChangedCallback");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.ViewRootImpl$SurfaceChangedCallback");
    }

    public static boolean e(SurfaceControl r100) {
        if (r100 != null) goto L15;
    L13:
        return false;
    L15:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(r100.isValid()));     // Catch: Throwable -> L5
    L7:
        Boolean r103 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = r103;
    L11:
        if (((Boolean) r102).booleanValue() == false) goto L13;
        return true;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static boolean c(SurfaceControl.Transaction r100, SurfaceControl r101) {
        Intrinsics.checkNotNullParameter(r100, "transaction");
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        if (e(r101) == true) goto L14;
        return false;
    L14:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        r100.setLayer(r101, 0);     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L7
    L9:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = r104;
    L13:
        return ((Boolean) r103).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static boolean d(View r100, SurfaceControl.Transaction r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "transaction");
        if (r100.isAttachedToWindow() == false) goto L25;
        Looper r102 = Looper.myLooper();
        Handler r103 = r100.getHandler();
        if (r103 == null) goto L7;
        Looper r104 = r103.getLooper();
    L8:
        if (r102 != r104) goto L25;
        AttachedSurfaceControl r105 = r100.getRootSurfaceControl();
        if (r105 != null) goto L26;
        return false;
    L26:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L18
        boolean r107 = r105.applyTransactionOnDraw(r101);     // Catch: Throwable -> L18
        if (r107 == false) goto L16;
        r100.invalidate();     // Catch: Throwable -> L18
    L16:
        Object r108 = Result.m9449constructorimpl(Boolean.valueOf(r107));     // Catch: Throwable -> L18
    L20:
        Boolean r109 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r108) == false) goto L24;
        r108 = r109;
    L24:
        return ((Boolean) r108).booleanValue();
    L18:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L7:
        r104 = null;
    L25:
        return false;
    }

    public static g f(View r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "listener");
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 35) goto L6;
        r101.onRootSurfaceUnavailable("unsupported_sdk_" + r102);
        return new c();
    L6:
        a r103 = new a(r100, r101);
        if (Looper.myLooper() != null) goto L9;
    L19:
        r103.d("wrong_thread");
    L20:
        return r103;
    L9:
        if (r103.f484509a.isAttachedToWindow() == false) goto L16;
        Looper r104 = Looper.myLooper();
        Handler r105 = r103.f484509a.getHandler();
        if (r105 == null) goto L13;
        Looper r106 = r105.getLooper();
    L14:
        if (r104 == r106) goto L16;
    L13:
        r106 = null;
    L16:
        r103.f484509a.addOnAttachStateChangeListener(r103);
        if (r103.f484509a.isAttachedToWindow() == false) goto L20;
        r103.c();
        goto L20
    }

    public static boolean b(SurfaceControl.Transaction r100, SurfaceControl r101, SurfaceControl r102) {
        Intrinsics.checkNotNullParameter(r100, "transaction");
        Intrinsics.checkNotNullParameter(r101, "childRoot");
        Intrinsics.checkNotNullParameter(r102, "mainRoot");
        if (e(r102) == true) goto L5;
    L19:
        return false;
    L5:
        if (e(r101) == false) goto L19;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Method r104 = (Method) f484508c.getValue();     // Catch: Throwable -> L12
        if (r104 == null) goto L11;
        r104.invoke(r100, new Object[]{r102, r101, -1});     // Catch: Throwable -> L12
        Object r105 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L12
    L14:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L18;
        r105 = r106;
    L18:
        return ((Boolean) r105).booleanValue();
    L11:
        throw new NoSuchMethodException("SurfaceControl.Transaction#setRelativeLayer");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static Method g(Class r100, String r110, Class... r111) {
        Class<?> r101 = new Class[0].getClass();
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Method r104 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, r101});     // Catch: Throwable -> L12
        r104.setAccessible(true);     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L12
        Object r105 = r104.invoke(r100, new Object[]{r110, r111});     // Catch: Throwable -> L12
        if ((r105 instanceof Method) == false) goto L6;
        Method r106 = (Method) r105;     // Catch: Throwable -> L12
    L7:
        if (r106 == null) goto L9;
        r106.setAccessible(true);     // Catch: Throwable -> L12
    L10:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r107) == false) goto L17;
        r107 = null;
    L17:
        Method r108 = (Method) r107;
        if (r108 != null) goto L33;
        Method r109 = r100.getDeclaredMethod(r110, (Class[]) Arrays.copyOf(r111, r111.length));     // Catch: Throwable -> L21
        r109.setAccessible(true);     // Catch: Throwable -> L21
        Object r112 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r112) == true) goto L28;
        r102 = r112;
    L28:
        return (Method) r102;
    L21:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L33:
        return r108;
    L9:
        r106 = null;
        goto L10
    L6:
        r106 = null;
    L12:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
