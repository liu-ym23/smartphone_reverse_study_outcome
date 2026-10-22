package fk;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.ec.hybrid.popup.o;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends gk.b implements g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.ec.hybrid.card.api.e f477558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f477559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WeakReference<com.bytedance.android.ec.hybrid.card.api.f> f477560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f477561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f477562l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f477563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f477564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ g f477565o;

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final int c() {
        return this.f477565o.c();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final boolean d() {
        return this.f477565o.d();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final boolean e() {
        return this.f477565o.e();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final int f() {
        return this.f477565o.f();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final boolean g() {
        return this.f477565o.g();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final JSONObject getBcm() {
        return this.f477565o.getBcm();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final String getBtm() {
        return this.f477565o.getBtm();
    }

    @Override // fk.g
    public final String getData() {
        return this.f477565o.getData();
    }

    @Override // fk.g
    public final String getSchema() {
        return this.f477565o.getSchema();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.j, com.bytedance.android.ec.hybrid.popup.f
    public int getType() {
        return this.f477565o.getType();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final int h() {
        return this.f477565o.h();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final boolean i() {
        return this.f477565o.i();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final boolean j() {
        return this.f477565o.j();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.f
    public final boolean k() {
        return this.f477565o.k();
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.j
    public final boolean start() {
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.e.f47505b, "ECLynxCardPopupTask start: " + getSchema());
        boolean r101 = super.start();
        com.bytedance.android.ec.hybrid.popup.g r102 = this.f481520c;
        if (r102 != null) goto L5;
        return false;
    L5:
        Map r110 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ec.popup_dismiss", new dk.a(this.f481522e, this))});
        FrameLayout r103 = new FrameLayout(r102.c().getContext());
        this.f477559i = r103;
        r102.c().addView(r103, new ViewGroup.LayoutParams(m(r102.c(), f(), true), m(r102.c(), h(), false)));
        com.bytedance.android.ec.hybrid.card.api.f r104 = this.f477560j.get();
        if (r104 != null) goto L8;
        return false;
    L8:
        String r105 = getSchema();
        String r106 = getData();
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-1, -1);
        if (i() == false) goto L11;
        int r107 = 80;
    L12:
        r111.gravity = r107;
        Unit r108 = Unit.INSTANCE;
        this.f477558h = r104.IW(r103, r105, r106, null, r111, this.f477561k, r110);
        if (d() == false) goto L22;
        FrameLayout r109 = this.f477559i;
        if (r109 == null) goto L17;
        r109.setAlpha(0.0f);
    L17:
        FrameLayout r112 = this.f477559i;
        if (r112 == null) goto L25;
        ViewTreeObserver r113 = r112.getViewTreeObserver();
        if (r113 == null) goto L25;
        r113.addOnGlobalLayoutListener(this.f477562l);
    L25:
        return r101;
    L22:
        FrameLayout r114 = this.f477559i;
        if (r114 == null) goto L25;
        r114.setAlpha(1.0f);
        goto L25
    L11:
        r107 = 17;
        goto L12
    }

    @Override // gk.b, com.bytedance.android.ec.hybrid.popup.j
    public final long stop() {
        long r100 = super.stop();
        if (d() == true) goto L14;
        com.bytedance.android.ec.hybrid.popup.g r101 = this.f481520c;
        if (r101 == null) goto L9;
        FrameLayout r102 = r101.c();
        if (r102 == null) goto L9;
        r102.removeAllViews();
    L9:
        com.bytedance.android.ec.hybrid.card.api.e r103 = this.f477558h;
        if (r103 == null) goto L12;
        r103.release();
    L12:
        this.f477558h = null;
        return r100;
    L14:
        l(false);
        return r100;
    }

    public final void l(boolean r100) {
        if (r100 == false) goto L5;
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r101.setDuration(300);
        r101.addUpdateListener(this.f477564n);
    L6:
        r101.start();
        return;
    L5:
        r101 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r101.setDuration(300);
        r101.addUpdateListener(this.f477564n);
        r101.addListener(this.f477563m);
        goto L6
    }

    public static int m(ViewGroup r100, int r101, boolean r102) {
        if (r101 != 0) goto L4;
        return -2;
    L4:
        if (r101 == 100) goto L9;
        if (r102 == false) goto L7;
        int r103 = r100.getMeasuredWidth();
    L12:
        return (int) (((double) r103) * (((double) r101) / 100.0d));
    L7:
        r103 = r100.getMeasuredHeight();
        goto L12
    L9:
        return -1;
    }

    public e(ck.b r100, o r101, g r102, com.bytedance.android.ec.hybrid.card.api.f r110, com.bytedance.android.ec.hybrid.popup.d r111) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "taskConfig");
        Intrinsics.checkNotNullParameter(r102, "popupConfig");
        Intrinsics.checkNotNullParameter(r110, "lynxCardLoader");
        super(r100, r101, r102);
        this.f477565o = r102;
        this.f477560j = new WeakReference(r110);
        this.f477561k = new c(this, r100, r102, this.f477558h, "popup " + r102.getSchema());
        this.f477562l = new d(this);
        this.f477563m = new a(this);
        this.f477564n = new b(this);
    }
}
