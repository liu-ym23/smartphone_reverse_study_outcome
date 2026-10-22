package xma;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.oui.view.ViewCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f564561a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Field f564562a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Field f564563b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Field f564564c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final boolean f564565d = false;

        static {
            Field r100 = View.class.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L4
            f564562a = r100;     // Catch: ReflectiveOperationException -> L4
            r100.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Class r101 = a();     // Catch: ReflectiveOperationException -> L4
            Field r102 = r101.getDeclaredField("mStableInsets");     // Catch: ReflectiveOperationException -> L4
            f564563b = r102;     // Catch: ReflectiveOperationException -> L4
            r102.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Field r103 = r101.getDeclaredField("mContentInsets");     // Catch: ReflectiveOperationException -> L4
            f564564c = r103;     // Catch: ReflectiveOperationException -> L4
            r103.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            f564565d = true;     // Catch: ReflectiveOperationException -> L4
            return;
        L4:
            e = move-exception;
            e.getMessage();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("android.view.View$AttachInfo");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("android.view.View$AttachInfo");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("android.view.View$AttachInfo");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("android.view.View$AttachInfo");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("android.view.View$AttachInfo");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("android.view.View$AttachInfo");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("android.view.View$AttachInfo");
        }
    }

    public static class b extends C8257e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Field f564566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f564567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Constructor<WindowInsets> f564568e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static boolean f564569f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WindowInsets f564570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public xma.b f564571b;

        @Override // xma.e.C8257e
        public final e a() {
            e r100 = e.a(this.f564570a, null);
            r100.f564561a.o();
            xma.b r101 = this.f564571b;
            r100.f564561a.q(r101);
            return r100;
        }

        public b() {
            if (f564567d == false) goto L28;
        L6:
            Field r100 = f564566c;
            WindowInsets r101 = null;
            if (r100 == null) goto L14;
            WindowInsets r102 = (WindowInsets) r100.get(null);     // Catch: ReflectiveOperationException -> L12
            if (r102 == null) goto L14;
            r101 = new WindowInsets(r102);     // Catch: ReflectiveOperationException -> L12
        L21:
            this.f564570a = r101;
            return;
        L14:
            if (f564569f == false) goto L30;
        L17:
            Constructor<WindowInsets> r103 = f564568e;
            if (r103 == null) goto L21;
            r101 = r103.newInstance(new Object[]{new Rect()});     // Catch: ReflectiveOperationException -> L23
            goto L21
        L30:
            f564568e = WindowInsets.class.getConstructor(new Class[]{Rect.class});     // Catch: ReflectiveOperationException -> L24
        L16:
            f564569f = true;
            goto L17
        L28:
            f564566c = WindowInsets.class.getDeclaredField("CONSUMED");     // Catch: ReflectiveOperationException -> L25
        L5:
            f564567d = true;
            goto L6
        }

        @Override // xma.e.C8257e
        public final void b(xma.b r100) {
            this.f564571b = r100;
        }

        @Override // xma.e.C8257e
        public final void c(xma.b r100) {
            WindowInsets r101 = this.f564570a;
            if (r101 == null) goto L6;
            this.f564570a = r101.replaceSystemWindowInsets(r100.f564554a, r100.f564555b, r100.f564556c, r100.f564557d);
            return;
        }
    }

    public static class c extends C8257e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsets.Builder f564572a;

        @Override // xma.e.C8257e
        public final e a() {
            e r100 = e.a(this.f564572a.build(), null);
            r100.f564561a.o();
            return r100;
        }

        public c() {
            this.f564572a = new WindowInsets.Builder();
        }

        @Override // xma.e.C8257e
        public final void b(xma.b r100) {
            this.f564572a.setStableInsets(r100.c());
        }

        @Override // xma.e.C8257e
        public final void c(xma.b r100) {
            this.f564572a.setSystemWindowInsets(r100.c());
        }
    }

    public static class d extends c {
        public d() {
        }
    }

    /* JADX INFO: renamed from: xma.e$e, reason: collision with other inner class name */
    public static class C8257e {
        public e a() {
            throw null;
        }

        public void b(xma.b r100) {
            throw null;
        }

        public void c(xma.b r100) {
            throw null;
        }

        public C8257e() {
            new e();
        }
    }

    public static class f extends k {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f564573h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static Method f564574i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static Class<?> f564575j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static Class<?> f564576k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static Field f564577l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static Field f564578m;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f564579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public xma.b[] f564580d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public xma.b f564581e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e f564582f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public xma.b f564583g;

        @Override // xma.e.k
        public xma.b g() {
            return s(7, true);
        }

        @Override // xma.e.k
        public final void o() {
            this.f564580d = null;
        }

        @Override // xma.e.k
        public final xma.b k() {
            if (this.f564581e != null) goto L6;
            this.f564581e = xma.b.a(this.f564579c.getSystemWindowInsetLeft(), this.f564579c.getSystemWindowInsetTop(), this.f564579c.getSystemWindowInsetRight(), this.f564579c.getSystemWindowInsetBottom());
        L6:
            return this.f564581e;
        }

        @Override // xma.e.k
        public final boolean n() {
            return this.f564579c.isRound();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class r(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
            Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

        @Override // xma.e.k
        public void d(View r100) {
            if (Build.VERSION.SDK_INT >= 30) goto L34;
            if (f564573h == false) goto L36;
        L12:
            Method r101 = f564574i;
            if (r101 != null) goto L15;
        L28:
            xma.b r102 = null;
        L29:
            if (r102 != null) goto L31;
            r102 = xma.b.f564553e;
        L31:
            this.f564583g = r102;
            return;
        L15:
            if (f564576k == null) goto L28;
            if (f564577l == null) goto L28;
            Object r103 = r101.invoke(r100, new Object[0]);     // Catch: ReflectiveOperationException -> L26
            if (r103 == null) goto L28;
            Object r104 = f564578m.get(r103);     // Catch: ReflectiveOperationException -> L26
            Rect r105 = (Rect) f564577l.get(r104);     // Catch: ReflectiveOperationException -> L26
            if (r105 == null) goto L28;
            xma.b r106 = xma.b.f564553e;     // Catch: ReflectiveOperationException -> L26
            r102 = xma.b.a(r105.left, r105.top, r105.right, r105.bottom);     // Catch: ReflectiveOperationException -> L26
        L26:
            e = move-exception;
            e.getMessage();
            goto L28
        L36:
            f564574i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: ReflectiveOperationException -> L9
            f564575j = r("android.view.ViewRootImpl");     // Catch: ReflectiveOperationException -> L9
            Class<?> r107 = r("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L9
            f564576k = r107;     // Catch: ReflectiveOperationException -> L9
            f564577l = r107.getDeclaredField("mVisibleInsets");     // Catch: ReflectiveOperationException -> L9
            f564578m = f564575j.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L9
            f564577l.setAccessible(true);     // Catch: ReflectiveOperationException -> L9
            f564578m.setAccessible(true);     // Catch: ReflectiveOperationException -> L9
        L11:
            f564573h = true;
        L9:
            e = move-exception;
            e.getMessage();
            goto L11
        L34:
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // xma.e.k
        public boolean equals(Object r100) {
            if (super.equals(r100) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.f564583g, ((f) r100).f564583g);
        }

        @Override // xma.e.k
        public xma.b f(int r100) {
            return s(r100, false);
        }

        @Override // xma.e.k
        public final void p(e r100) {
            this.f564582f = r100;
        }

        public f(e r100, WindowInsets r101) {
            super(r100);
            this.f564581e = null;
            this.f564579c = r101;
        }

        public final xma.b s(int r110, boolean r111) {
            xma.b r100 = xma.b.f564553e;
            int r101 = 1;
        L4:
            if (r101 > 256) goto L87;
            if ((r110 & r101) == 0) goto L86;
            int r102 = 0;
            if (r101 == 1) goto L78;
            xma.b r103 = null;
            if (r101 != 2) goto L13;
            if (r111 == false) goto L71;
            e r104 = this.f564582f;
            if (r104 == null) goto L69;
            xma.b r105 = r104.f564561a.i();
        L70:
            xma.b r106 = i();
            xma.b r107 = xma.b.a(Math.max(r105.f564554a, r106.f564554a), 0, Math.max(r105.f564556c, r106.f564556c), Math.max(r105.f564557d, r106.f564557d));
        L85:
            r100 = xma.b.a(Math.max(r100.f564554a, r107.f564554a), Math.max(r100.f564555b, r107.f564555b), Math.max(r100.f564556c, r107.f564556c), Math.max(r100.f564557d, r107.f564557d));
            goto L86
        L69:
            r105 = xma.b.f564553e;
            goto L70
        L71:
            xma.b r108 = k();
            e r109 = this.f564582f;
            if (r109 == null) goto L74;
            r103 = r109.f564561a.i();
        L74:
            int r112 = r108.f564557d;
            if (r103 == null) goto L77;
            r112 = Math.min(r112, r103.f564557d);
        L77:
            r107 = xma.b.a(r108.f564554a, 0, r108.f564556c, r112);
            goto L85
        L13:
            if (r101 != 8) goto L15;
            xma.b[] r113 = this.f564580d;
            if (r113 == null) goto L48;
            r103 = r113[3];
        L48:
            if (r103 == null) goto L50;
            r107 = r103;
            goto L85
        L50:
            xma.b r114 = k();
            e r115 = this.f564582f;
            if (r115 == null) goto L53;
            xma.b r116 = r115.f564561a.i();
        L54:
            int r117 = r114.f564557d;
            if (r117 <= r116.f564557d) goto L57;
            r107 = xma.b.a(0, 0, 0, r117);
            goto L85
        L57:
            xma.b r118 = this.f564583g;
            if (r118 != null) goto L60;
        L64:
            r107 = xma.b.f564553e;
            goto L85
        L60:
            if (r118.equals(xma.b.f564553e) == true) goto L64;
            int r119 = this.f564583g.f564557d;
            if (r119 <= r116.f564557d) goto L64;
            r107 = xma.b.a(0, 0, 0, r119);
            goto L85
        L53:
            r116 = xma.b.f564553e;
            goto L54
        L15:
            if (r101 != 16) goto L17;
            r107 = j();
            goto L85
        L17:
            if (r101 != 32) goto L19;
            r107 = h();
            goto L85
        L19:
            if (r101 != 64) goto L21;
            r107 = l();
            goto L85
        L21:
            if (r101 == 128) goto L23;
            r107 = xma.b.f564553e;
            goto L85
        L23:
            e r120 = this.f564582f;
            if (r120 == null) goto L26;
            xma.a r121 = r120.f564561a.e();
        L27:
            if (r121 == null) goto L41;
            int r122 = Build.VERSION.SDK_INT;
            if (r122 < 28) goto L31;
            int r123 = ((DisplayCutout) r121.f564552a).getSafeInsetLeft();
        L32:
            if (r122 < 28) goto L34;
            int r124 = ((DisplayCutout) r121.f564552a).getSafeInsetTop();
        L35:
            if (r122 < 28) goto L37;
            int r125 = ((DisplayCutout) r121.f564552a).getSafeInsetRight();
        L38:
            if (r122 < 28) goto L40;
            r102 = ((DisplayCutout) r121.f564552a).getSafeInsetBottom();
        L40:
            r107 = xma.b.a(r123, r124, r125, r102);
            goto L85
        L37:
            r125 = 0;
            goto L38
        L34:
            r124 = 0;
            goto L35
        L31:
            r123 = 0;
            goto L32
        L41:
            r107 = xma.b.f564553e;
            goto L85
        L26:
            r121 = e();
            goto L27
        L78:
            if (r111 == false) goto L84;
            e r126 = this.f564582f;
            if (r126 == null) goto L82;
            xma.b r127 = r126.f564561a.i();
        L83:
            r107 = xma.b.a(0, Math.max(r127.f564555b, k().f564555b), 0, 0);
            goto L85
        L82:
            r127 = xma.b.f564553e;
            goto L83
        L84:
            r107 = xma.b.a(0, k().f564555b, 0, 0);
        L86:
            r101 = r101 << 1;
            goto L4
        L87:
            return r100;
        }
    }

    public static class g extends f {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public xma.b f564584n;

        @Override // xma.e.k
        public final e b() {
            return e.a(this.f564579c.consumeStableInsets(), null);
        }

        @Override // xma.e.k
        public final e c() {
            return e.a(this.f564579c.consumeSystemWindowInsets(), null);
        }

        @Override // xma.e.k
        public final xma.b i() {
            if (this.f564584n != null) goto L6;
            this.f564584n = xma.b.a(this.f564579c.getStableInsetLeft(), this.f564579c.getStableInsetTop(), this.f564579c.getStableInsetRight(), this.f564579c.getStableInsetBottom());
        L6:
            return this.f564584n;
        }

        @Override // xma.e.k
        public final boolean m() {
            return this.f564579c.isConsumed();
        }

        @Override // xma.e.k
        public void q(xma.b r100) {
            this.f564584n = r100;
        }

        public g(e r100, WindowInsets r101) {
            super(r100, r101);
            this.f564584n = null;
        }
    }

    public static class h extends g {
        @Override // xma.e.k
        public final e a() {
            return e.a(this.f564579c.consumeDisplayCutout(), null);
        }

        @Override // xma.e.k
        public final xma.a e() {
            DisplayCutout r100 = this.f564579c.getDisplayCutout();
            if (r100 != null) goto L6;
            return null;
        L6:
            return new xma.a(r100);
        }

        @Override // xma.e.k
        public final int hashCode() {
            return this.f564579c.hashCode();
        }

        @Override // xma.e.f, xma.e.k
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (Objects.equals(this.f564579c, r101.f564579c) == true) goto L11;
        L13:
            return false;
        L11:
            if (Objects.equals(this.f564583g, r101.f564583g) == false) goto L13;
            return true;
        }

        public h(e r100, WindowInsets r101) {
            super(r100, r101);
        }
    }

    public static class i extends h {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public xma.b f564585o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public xma.b f564586p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public xma.b f564587q;

        @Override // xma.e.g, xma.e.k
        public final void q(xma.b r100) {
        }

        @Override // xma.e.k
        public final xma.b h() {
            if (this.f564586p != null) goto L6;
            this.f564586p = xma.b.b(this.f564579c.getMandatorySystemGestureInsets());
        L6:
            return this.f564586p;
        }

        @Override // xma.e.k
        public final xma.b j() {
            if (this.f564585o != null) goto L6;
            this.f564585o = xma.b.b(this.f564579c.getSystemGestureInsets());
        L6:
            return this.f564585o;
        }

        @Override // xma.e.k
        public final xma.b l() {
            if (this.f564587q != null) goto L6;
            this.f564587q = xma.b.b(this.f564579c.getTappableElementInsets());
        L6:
            return this.f564587q;
        }

        public i(e r100, WindowInsets r101) {
            super(r100, r101);
            this.f564585o = null;
            this.f564586p = null;
            this.f564587q = null;
        }
    }

    public static class j extends i {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ int f564588r = 0;

        @Override // xma.e.f, xma.e.k
        public final void d(View r100) {
        }

        static {
            e.a(WindowInsets.CONSUMED, null);
        }

        @Override // xma.e.f, xma.e.k
        public final xma.b g() {
            return xma.b.b(this.f564579c.getInsetsIgnoringVisibility(l.a(7)));
        }

        @Override // xma.e.f, xma.e.k
        public final xma.b f(int r100) {
            return xma.b.b(this.f564579c.getInsets(l.a(r100)));
        }

        public j(e r100, WindowInsets r101) {
            super(r100, r101);
        }
    }

    public static class k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f564589b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f564590a;

        public void d(View r100) {
        }

        public xma.a e() {
            return null;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Boolean.valueOf(n()), Boolean.valueOf(m()), k(), i(), e()});
        }

        public boolean m() {
            return false;
        }

        public boolean n() {
            return false;
        }

        public void o() {
        }

        public void p(e r100) {
        }

        public void q(xma.b r100) {
        }

        static {
            int r100 = Build.VERSION.SDK_INT;
            if (r100 < 30) goto L6;
            C8257e r101 = new d();
        L9:
            r101.a().f564561a.a().f564561a.b().f564561a.c();
            return;
        L6:
            if (r100 < 29) goto L8;
            r101 = new c();
            goto L9
        L8:
            r101 = new b();
            goto L9
        }

        public xma.b h() {
            return k();
        }

        public xma.b j() {
            return k();
        }

        public xma.b l() {
            return k();
        }

        public e a() {
            return this.f564590a;
        }

        public e b() {
            return this.f564590a;
        }

        public e c() {
            return this.f564590a;
        }

        public xma.b g() {
            return xma.b.f564553e;
        }

        public xma.b i() {
            return xma.b.f564553e;
        }

        public xma.b k() {
            return xma.b.f564553e;
        }

        public k(e r100) {
            this.f564590a = r100;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (n() == r101.n()) goto L11;
        L19:
            return false;
        L11:
            if (m() != r101.m()) goto L19;
            if (ObjectsCompat.equals(k(), r101.k()) == false) goto L19;
            if (ObjectsCompat.equals(i(), r101.i()) == false) goto L19;
            if (ObjectsCompat.equals(e(), r101.e()) == false) goto L19;
            return true;
        }

        public xma.b f(int r100) {
            return xma.b.f564553e;
        }
    }

    public static final class l {
        public static int a(int r100) {
            int r101 = 0;
            int r102 = 1;
        L4:
            if (r102 > 256) goto L33;
            if ((r100 & r102) == 0) goto L32;
            if (r102 != 1) goto L9;
            int r103 = WindowInsets.Type.statusBars();
        L31:
            r101 = r101 | r103;
            goto L32
        L9:
            if (r102 != 2) goto L11;
            r103 = WindowInsets.Type.navigationBars();
            goto L31
        L11:
            if (r102 != 4) goto L13;
            r103 = WindowInsets.Type.captionBar();
            goto L31
        L13:
            if (r102 != 8) goto L15;
            r103 = WindowInsets.Type.ime();
            goto L31
        L15:
            if (r102 != 16) goto L17;
            r103 = WindowInsets.Type.systemGestures();
            goto L31
        L17:
            if (r102 != 32) goto L19;
            r103 = WindowInsets.Type.mandatorySystemGestures();
            goto L31
        L19:
            if (r102 != 64) goto L21;
            r103 = WindowInsets.Type.tappableElement();
            goto L31
        L21:
            if (r102 != 128) goto L32;
            r103 = WindowInsets.Type.displayCutout();
        L32:
            r102 = r102 << 1;
            goto L4
        L33:
            return r101;
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        int r100 = j.f564588r;
        return;
    L5:
        int r101 = k.f564589b;
    }

    public final int hashCode() {
        k r100 = this.f564561a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public e() {
        this.f564561a = new k(this);
    }

    public e(WindowInsets r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 30) goto L6;
        this.f564561a = new j(this, r100);
        return;
    L6:
        if (r101 < 29) goto L9;
        this.f564561a = new i(this, r100);
        return;
    L9:
        if (r101 < 28) goto L11;
        this.f564561a = new h(this, r100);
        return;
    L11:
        this.f564561a = new g(this, r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.f564561a, ((e) r100).f564561a);
    }

    public static e a(WindowInsets r100, View r101) {
        e r102 = new e((WindowInsets) Preconditions.checkNotNull(r100));
        if (r101 != null) goto L5;
    L35:
        return r102;
    L5:
        if (r101.isAttachedToWindow() == false) goto L35;
        int r103 = ViewCompat.f403725a;
        e r104 = null;
        if (Build.VERSION.SDK_INT < 23) goto L13;
        WindowInsets r105 = r101.getRootWindowInsets();
        if (r105 == null) goto L34;
        r104 = a(r105, null);
        r104.f564561a.p(r104);
        View r106 = r101.getRootView();
        r104.f564561a.d(r106);
    L34:
        r102.f564561a.p(r104);
        View r107 = r101.getRootView();
        r102.f564561a.d(r107);
        goto L35
    L13:
        if (a.f564565d == false) goto L34;
        if (r101.isAttachedToWindow() == false) goto L34;
        View r108 = r101.getRootView();
        Object r109 = a.f564562a.get(r108);     // Catch: IllegalAccessException -> L32
        if (r109 == null) goto L34;
        Rect r110 = (Rect) a.f564563b.get(r109);     // Catch: IllegalAccessException -> L32
        Rect r111 = (Rect) a.f564564c.get(r109);     // Catch: IllegalAccessException -> L32
        if (r110 == null) goto L34;
        if (r111 == null) goto L34;
        int r112 = Build.VERSION.SDK_INT;     // Catch: IllegalAccessException -> L32
        if (r112 < 30) goto L27;
        C8257e r113 = new d();     // Catch: IllegalAccessException -> L32
    L30:
        xma.b r114 = xma.b.f564553e;     // Catch: IllegalAccessException -> L32
        r113.b(xma.b.a(r110.left, r110.top, r110.right, r110.bottom));     // Catch: IllegalAccessException -> L32
        r113.c(xma.b.a(r111.left, r111.top, r111.right, r111.bottom));     // Catch: IllegalAccessException -> L32
        e r115 = r113.a();     // Catch: IllegalAccessException -> L32
        r115.f564561a.p(r115);     // Catch: IllegalAccessException -> L32
        View r116 = r101.getRootView();     // Catch: IllegalAccessException -> L32
        r115.f564561a.d(r116);     // Catch: IllegalAccessException -> L32
        r104 = r115;
        goto L34
    L27:
        if (r112 < 29) goto L29;
        r113 = new c();     // Catch: IllegalAccessException -> L32
        goto L30
    L29:
        r113 = new b();     // Catch: IllegalAccessException -> L32
    L32:
        e = move-exception;
        e.getMessage();
        goto L34
    }
}
