package t3a;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<g> f544528j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f544529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f544530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f544531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t3a.b f544532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f544533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f544534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup.LayoutParams f544535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f544536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f544537i;

    public static final class a {
    }

    public static final class b implements t3a.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f544538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f544539b;

        @Override // t3a.b.a
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // t3a.b.a
        public final void onLongClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // t3a.b.a
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (this.f544538a.f544527f == false) goto L8;
            Function0<Unit> r101 = this.f544539b.f544537i;
            if (r101 == null) goto L9;
            r101.invoke();
            return;
        L9:
            return;
        }

        public b(e r100, g r101) {
            this.f544538a = r100;
            this.f544539b = r101;
        }
    }

    public g() {
    }

    static {
        f544528j = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new f());
    }

    public final void a() {
        i r100 = this.f544533e;
        if (r100 == null) goto L5;
        AppHost.f326268a.getApplication().unregisterActivityLifecycleCallbacks(r100);
        this.f544533e = null;
        FLogger.f375446a.d("RealtimeVideoGlobalFloatWindow", "activity lifecycle callback unregistered");
    L5:
        this.f544532d = null;
        this.f544529a = null;
        this.f544530b = null;
        this.f544534f = null;
        this.f544535g = null;
        this.f544537i = null;
    }

    public final void b() {
        View r100 = this.f544530b;
        if (r100 == null) goto L16;
        ViewGroup r101 = this.f544529a;
        if (r101 == null) goto L7;
        r101.removeView(r100);
    L7:
        ViewGroup r102 = this.f544534f;
        if (r102 != null) goto L10;
    L14:
        r100.setVisibility(this.f544536h);
        return;
    L10:
        if (Intrinsics.areEqual(r100.getParent(), r102) == true) goto L14;
        ViewGroup.LayoutParams r103 = this.f544535g;
        if (r103 == null) goto L14;
        r102.addView(r100, r103);
        goto L14
    }

    public final boolean c(View r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "videoView");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (this.f544531c == false) goto L30;
        FLogger.f375446a.w("RealtimeVideoGlobalFloatWindow", "float window is showing");
        return false;
    L30:
        FLogger r102 = FLogger.f375446a;     // Catch: Exception -> L27
        r102.i("RealtimeVideoGlobalFloatWindow", "start to show global float window");     // Catch: Exception -> L27
        this.f544530b = r100;     // Catch: Exception -> L27
        ViewParent r103 = r100.getParent();     // Catch: Exception -> L27
        if ((r103 instanceof ViewGroup) == false) goto L9;
        ViewGroup r104 = (ViewGroup) r103;     // Catch: Exception -> L27
    L10:
        this.f544534f = r104;     // Catch: Exception -> L27
        this.f544535g = r100.getLayoutParams();     // Catch: Exception -> L27
        this.f544536h = r100.getVisibility();     // Catch: Exception -> L27
        ViewGroup r105 = this.f544534f;     // Catch: Exception -> L27
        if (r105 == null) goto L13;
        r105.removeView(r100);     // Catch: Exception -> L27
    L13:
        FrameLayout r106 = new FrameLayout(r100.getContext());     // Catch: Exception -> L27
        r106.setLayoutParams(new FrameLayout.LayoutParams(r101.f544522a, r101.f544523b));     // Catch: Exception -> L27
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-1, -2);     // Catch: Exception -> L27
        r106.setOutlineProvider(new h());     // Catch: Exception -> L27
        r106.setClipToOutline(true);     // Catch: Exception -> L27
        r106.addView(r100, r107);     // Catch: Exception -> L27
        this.f544529a = r106;     // Catch: Exception -> L27
        this.f544531c = true;     // Catch: Exception -> L27
        if (this.f544532d != null) goto L17;
        t3a.b r108 = new t3a.b(r106.getContext(), r106, r101);     // Catch: Exception -> L27
        this.f544532d = r108;     // Catch: Exception -> L27
        b r109 = new b(r101, this);     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r109, "listener");     // Catch: Exception -> L27
        r108.f544518z = r109;     // Catch: Exception -> L27
    L17:
        if (this.f544533e != null) goto L20;
        this.f544533e = new i(this);     // Catch: Exception -> L27
        Application r110 = AppHost.f326268a.getApplication();     // Catch: Exception -> L27
        i r111 = this.f544533e;     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L27
        r110.registerActivityLifecycleCallbacks(r111);     // Catch: Exception -> L27
        r102.d("RealtimeVideoGlobalFloatWindow", "activity lifecycle callback registered");     // Catch: Exception -> L27
    L20:
        Activity r112 = AppHost.f326268a.a().getCurrentActivity();     // Catch: Exception -> L27
        if (r112 == null) goto L25;
        t3a.b r113 = this.f544532d;     // Catch: Exception -> L27
        if (r113 == null) goto L25;
        r113.a(r112);     // Catch: Exception -> L27
    L25:
        r102.i("RealtimeVideoGlobalFloatWindow", "show global float window success");     // Catch: Exception -> L27
        return true;
    L9:
        r104 = null;
    L27:
        e = move-exception;
        FLogger.f375446a.e("RealtimeVideoGlobalFloatWindow", "show global float window error: " + e.getMessage(), e);
        b();
        a();
        return false;
    }
}
