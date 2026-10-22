package com.bytedance.bdp.appbase.base.ui.viewwindow;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes11.dex */
public class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f200624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f200625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f200626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f200627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f200628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f200629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f200630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f200631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f200632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f200633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f200634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f200635l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f200636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f200637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f200638o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f200639p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f200640q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f200641r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f200642s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f200643t;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Scroller f200644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f200645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f200646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f200647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d f200648e;

        public final void a() {
            if (this.f200648e != null) goto L5;
        L10:
            d r100 = this.f200648e;     // Catch: Exception -> L23
            if (r100.f200626c == null) goto L21;
            View r101 = r100.f200638o;     // Catch: Exception -> L23
            if (r101 == null) goto L21;
            if (r101.getParent() == null) goto L17;
            r100.f200626c.removeView(r100.f200638o);     // Catch: Exception -> L23
        L17:
            r100.f200638o.setOnClickListener(null);     // Catch: Exception -> L23
            if (r100.f200639p.getParent() == null) goto L20;
            r100.f200626c.removeView(r100.f200639p);     // Catch: Exception -> L23
        L20:
            r100.f200641r = null;     // Catch: Exception -> L23
            r100.f200638o = null;     // Catch: Exception -> L23
            r100.f200639p = null;     // Catch: Exception -> L23
        L21:
            this.f200648e.getClass();     // Catch: Exception -> L23
            return;
        L5:
            if (this.f200644a.computeScrollOffset() == false) goto L10;
            if (this.f200646c == false) goto L9;
            d.a(this.f200648e, this.f200644a.getCurrX());     // Catch: Exception -> L23
        L9:
            this.f200648e.postOnAnimation(this);     // Catch: Exception -> L23
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100, Context r101) {
            this.f200648e = r100;
            this.f200647d = 300;
            this.f200644a = new Scroller(r101, new DecelerateInterpolator());
            if (com.bytedance.bdp.bdpbase.util.e.f201336b != 0) goto L5;
        L25:
            DisplayMetrics r102 = new DisplayMetrics();     // Catch: Exception -> L24
            ((WindowManager) r101.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getMetrics(r102);     // Catch: Exception -> L24
            com.bytedance.bdp.bdpbase.util.e.f201336b = r102.widthPixels;     // Catch: Exception -> L24
            com.bytedance.bdp.bdpbase.util.e.f201335a = r102.heightPixels;     // Catch: Exception -> L24
        L7:
            int r103 = r101.getResources().getConfiguration().orientation;
            if (com.bytedance.bdp.bdpbase.util.e.f201336b != 0) goto L10;
        L27:
            DisplayMetrics r104 = new DisplayMetrics();     // Catch: Exception -> L13
            ((WindowManager) r101.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getMetrics(r104);     // Catch: Exception -> L13
            com.bytedance.bdp.bdpbase.util.e.f201336b = r104.widthPixels;     // Catch: Exception -> L13
            com.bytedance.bdp.bdpbase.util.e.f201335a = r104.heightPixels;     // Catch: Exception -> L13
        L15:
            if (r101.getResources().getConfiguration().orientation != 1) goto L20;
            int r105 = com.bytedance.bdp.bdpbase.util.e.f201336b;
            int r106 = com.bytedance.bdp.bdpbase.util.e.f201335a;
            if (r105 < r106) goto L22;
        L19:
            r105 = r106;
        L22:
            this.f200645b = r105;
            return;
        L20:
            r105 = com.bytedance.bdp.bdpbase.util.e.f201336b;
            r106 = com.bytedance.bdp.bdpbase.util.e.f201335a;
            if (r105 <= r106) goto L19;
        L10:
            if (com.bytedance.bdp.bdpbase.util.e.f201335a != 0) goto L15;
        L5:
            if (com.bytedance.bdp.bdpbase.util.e.f201335a != 0) goto L7;
            goto L7
        }
    }

    public interface b {
    }

    public void setDragFinishListener(b r100) {
    }

    public d(Context r100) {
        super(r100);
        this.f200625b = true;
        this.f200629f = 3000;
        this.f200630g = 100;
        this.f200631h = 100;
        this.f200632i = false;
        this.f200642s = false;
        this.f200643t = true;
    }

    private void setDragFrameByLeft(float r100) {
        setX(r100);
        if (this.f200643t == false) goto L5;
        this.f200639p.setX(r100 - this.f200640q);
        this.f200638o.setX(r100 - getWidth());
        this.f200638o.setAlpha(1.0f - (r100 / getWidth()));
        return;
    L5:
        this.f200639p.setX(getWidth() + r100);
        this.f200638o.setX(getWidth() + r100);
        this.f200638o.setAlpha(1.0f - (Math.abs(r100) / getWidth()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction();
        boolean r101 = true;
        boolean r102 = false;
        if (r100 == 0) goto L99;
        if (r100 == 1) goto L64;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L64;
        if (r100 == 4) goto L64;
    L129:
        return super.dispatchTouchEvent(r110);
    L13:
        if (this.f200624a == true) goto L15;
    L19:
        boolean r103 = false;
    L20:
        if (r103 == false) goto L129;
        if (this.f200626c == null) goto L129;
        float r104 = r110.getRawX() - this.f200627d;
        float r105 = r110.getRawY() - this.f200628e;
        if (this.f200643t == false) goto L30;
        if (r104 < 0.0f) goto L129;
    L33:
        if (this.f200637n == true) goto L40;
        if (Math.abs(r104) < this.f200633j) goto L129;
        if (Math.abs(r105) > this.f200634k) goto L129;
    L40:
        if (this.f200638o != null) goto L50;
        View r106 = new View(getContext());
        this.f200638o = r106;
        r106.setBackgroundColor(ColorProtector.parseColor("#4f000000"));
        if (this.f200641r == null) goto L44;
        this.f200641r = new c();
    L44:
        this.f200638o.setOnClickListener(this.f200641r);
        View r107 = new View(getContext());
        this.f200639p = r107;
        GradientDrawable r108 = new GradientDrawable();
        r108.setColors(new int[]{0, 1291845632});
        r108.setShape(0);
        if (this.f200643t == false) goto L47;
        r108.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
    L48:
        r107.setBackground(r108);
        goto L50
    L47:
        r108.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
    L50:
        if (this.f200638o.getParent() != null) goto L53;
        this.f200626c.addView(this.f200638o, new FrameLayout.LayoutParams(-1, -1));
        this.f200626c.addView(this.f200639p, new FrameLayout.LayoutParams(this.f200640q, -1));
    L53:
        if (this.f200643t == false) goto L59;
        if (r104 >= 0.0f) goto L57;
        setDragFrameByLeft(0.0f);
    L62:
        this.f200637n = true;
        goto L129
    L57:
        setDragFrameByLeft(r104);
        goto L62
    L59:
        if (r104 >= (-getWidth())) goto L61;
        setDragFrameByLeft(-getWidth());
        goto L62
    L61:
        setDragFrameByLeft(r104);
        goto L62
    L30:
        if (r104 <= 0.0f) goto L33;
    L15:
        if (this.f200632i == false) goto L19;
        if (this.f200625b == false) goto L19;
        r103 = true;
    L64:
        if (this.f200624a == true) goto L66;
    L70:
        boolean r109 = false;
    L71:
        if (r109 == false) goto L129;
        if (this.f200637n == false) goto L97;
        a r111 = new a(this, getContext());
        this.f200635l = r111;
        int r112 = (int) getX();
        r111.f200646c = true;
        if (r112 == 0) goto L94;
        VelocityTracker r113 = this.f200636m;
        if (r113 == null) goto L86;
        r113.computeCurrentVelocity(1000, this.f200629f);
        int r114 = (int) this.f200636m.getXVelocity();
        int r115 = this.f200629f;
        if (r114 <= r115) goto L82;
        r114 = r115;
    L82:
        if (r114 >= 0) goto L84;
        r111.f200647d = TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG;
        goto L86
    L84:
        r111.f200647d = TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG - ((r114 * 150) / r115);
    L86:
        if (Math.abs(r112 + 0) > this.f200631h) goto L89;
        r101 = false;
    L89:
        if (r101 == false) goto L93;
        if (r112 <= 0) goto L92;
        r111.f200644a.startScroll(r112, 0, r111.f200645b - r112, 0, r111.f200647d);
        goto L94
    L92:
        r111.f200644a.startScroll(r112, 0, (-getWidth()) - r112, 0, r111.f200647d);
        goto L94
    L93:
        int r116 = 0 - r112;
        r111.f200644a.startScroll(r112, 0, r116, 0, Math.min(((Math.abs(r116) * 1800) / r111.f200645b) + 100, 400));
    L94:
        post(this.f200635l);
        VelocityTracker r117 = this.f200636m;
        if (r117 == null) goto L97;
        r117.recycle();
        this.f200636m = null;
    L97:
        this.f200637n = false;
        goto L129
    L66:
        if (this.f200632i == false) goto L70;
        if (this.f200625b == false) goto L70;
        r109 = true;
        goto L71
    L99:
        if (this.f200643t == false) goto L106;
        if (r110.getRawX() >= this.f200630g) goto L103;
        boolean r118 = true;
    L104:
        this.f200632i = r118;
    L110:
        this.f200627d = r110.getRawX();
        this.f200628e = r110.getY();
        if (this.f200624a == true) goto L113;
    L117:
        if (r102 == false) goto L129;
        if (getParent() == null) goto L122;
        this.f200626c = (ViewGroup) getParent();
    L122:
        a r119 = this.f200635l;
        if (r119 != null) goto L125;
    L127:
        VelocityTracker r120 = VelocityTracker.obtain();
        this.f200636m = r120;
        r120.addMovement(r110);
        goto L129
    L125:
        if (r119.f200644a.isFinished() == true) goto L127;
        this.f200635l.f200644a.forceFinished(true);
        goto L127
    L113:
        if (this.f200632i == false) goto L117;
        if (this.f200625b == false) goto L117;
        r102 = true;
        goto L117
    L103:
        r118 = false;
        goto L104
    L106:
        if (r110.getRawX() <= (getWidth() - this.f200630g)) goto L108;
        boolean r121 = true;
    L109:
        this.f200632i = r121;
        goto L110
    L108:
        r121 = false;
        goto L109
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f200637n == false) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    public void setDragEnable(boolean r100) {
        this.f200624a = r100;
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f200625b == true) goto L7;
        return;
    L7:
        if (this.f200642s == true) goto L12;
        this.f200642s = true;
        ViewConfiguration r101 = ViewConfiguration.get(getContext());
        Math.max((int) (r101.getScaledMinimumFlingVelocity() * com.bytedance.bdp.bdpbase.util.e.a(getContext())), 100);
        int r102 = r101.getScaledTouchSlop();
        this.f200633j = r102;
        this.f200634k = r102 * 4;
        this.f200640q = (int) ((11.0f * com.bytedance.bdp.bdpbase.util.e.a(getContext())) + 0.5f);
        int r103 = (int) ((80.0f * com.bytedance.bdp.bdpbase.util.e.a(getContext())) + 0.5f);
        this.f200630g = r103;
        this.f200631h = r103;
        return;
    }

    public static /* synthetic */ void a(d r100, float r101) {
        r100.setDragFrameByLeft(r101);
    }
}
