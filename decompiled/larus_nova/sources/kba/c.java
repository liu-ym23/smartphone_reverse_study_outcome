package kba;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.ui.ObricListeningVisualView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements View.OnAttachStateChangeListener, ViewTreeObserver.OnWindowVisibilityChangeListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f502288m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f502289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f502290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Float, Unit> f502291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f502292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f502293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f502294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f502295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f502296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f502297i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f502298j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f502299k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f502300l;

    public static final class a {
    }

    static {
    }

    public c() {
        throw null;
    }

    public final void a(String r100) {
        if (this.f502295g == false) goto L6;
        this.f502295g = false;
        this.f502289a.removeCallbacks(this.f502300l);
        FLogger.f375446a.i("ListeningFakeAmplitudePlayer", "fake_amplitude_start_cancelled: trigger=" + r100 + " mode=" + this.f502290b.invoke());
    L6:
        if (this.f502296h == true) goto L8;
        return;
    L8:
        long r101 = SystemClock.uptimeMillis();
        this.f502296h = false;
        this.f502289a.removeCallbacks(this.f502299k);
        FLogger.f375446a.i("ListeningFakeAmplitudePlayer", "fake_amplitude_stopped: trigger=" + r100 + " durationMs=" + (r101 - this.f502297i) + " mode=" + this.f502290b.invoke());
        this.f502297i = 0;
        this.f502298j = 0;
    }

    public final void b(String r100) {
        if (this.f502292d == true) goto L5;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L14;
        a(r100);
        return;
    L14:
        if (this.f502296h == false) goto L16;
        return;
    L16:
        if (this.f502295g == true) goto L23;
        this.f502295g = true;
        FLogger.f375446a.i("ListeningFakeAmplitudePlayer", "fake_amplitude_start_scheduled: trigger=" + r100 + " delayMs=1100 mode=" + this.f502290b.invoke());
        this.f502289a.postDelayed(this.f502300l, 1100);
        return;
    L23:
        return;
    L5:
        if (this.f502293e == true) goto L11;
        if (this.f502289a.isAttachedToWindow() == false) goto L11;
        if (this.f502289a.getWindowVisibility() != 0) goto L11;
        r101 = true;
        goto L12
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.getViewTreeObserver().addOnWindowVisibilityChangeListener(this);
        b("view_attached");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101.isAlive() == false) goto L5;
        r101.removeOnWindowVisibilityChangeListener(this);
    L5:
        a("view_detached");
    }

    @Override // android.view.ViewTreeObserver.OnWindowVisibilityChangeListener
    public final void onWindowVisibilityChanged(int r100) {
        b("window_visibility_changed");
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [kba.b] */
    public c(ObricListeningVisualView r100, com.obric.assistant.activation.presentation.ui.b r101, Function1 r102) {
        this.f502289a = r100;
        this.f502290b = r101;
        this.f502291c = r102;
        this.f502294f = kba.a.b(0);
        this.f502299k = new d(this);
        this.f502300l = new b(this);
        r100.addOnAttachStateChangeListener(this);
    }
}
