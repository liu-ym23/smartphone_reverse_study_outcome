package com.ss.android.lark.cameraview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class w extends View {
    public ValueAnimator A;
    public final float B;
    public boolean C;
    public boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f411024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f411025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f411026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f411027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f411028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f411029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f411030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f411031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f411032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f411033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f411034k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f411035l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f411036m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f411037n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f411038o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f411039p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f411040q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f411041r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f411042s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f411043t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f411044u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f411045v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RectF f411046w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f411047x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d0b.a f411048y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AnimatorSet f411049z;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f411050a;

        public final void a() {
            w r100 = this.f411050a;
            if (r100.C == true) goto L5;
            return;
        L5:
            r100.f411024a = 3;
            r100.b();
            w r101 = this.f411050a;
            float r102 = r101.f411040q;
            float r103 = r101.f411032i + r102;
            float r104 = r101.f411041r;
            float r105 = r104 - r101.f411033j;
            if (r103 <= r102) goto L8;
            r101.D = true;
            r101.f411028e = j08.b.c(r101.getContext(), R.color.lkui_N200, 0.5f);
        L9:
            ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r102, r103});
            ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{r104, r105});
            r106.addUpdateListener(new b0(r101));
            r107.addUpdateListener(new c0(r101));
            AnimatorSet r108 = new AnimatorSet();
            r108.addListener(new d0(r101));
            r108.playTogether(new Animator[]{r106, r107});
            r108.setDuration(200);
            r108.start();
            r101.f411049z = r108;
            return;
        L8:
            r101.D = false;
            r101.f411028e = UIUtils.getColor(r101.getContext(), R.color.lkui_N00);
            goto L9
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

        public b(w r100) {
            this.f411050a = r100;
        }
    }

    static {
    }

    public final void a() {
        this.f411024a = 5;
        d0b.a r100 = this.f411048y;
        if (r100 == null) goto L8;
        int r101 = this.f411045v;
        if (r101 >= this.f411044u) goto L7;
        r100.a(r101);
        goto L8
    L7:
        r100.d(r101);
    L8:
        this.f411045v = 0;
        this.f411024a = 1;
        b();
    }

    public final void b() {
        this.f411037n = this.f411040q;
        this.f411038o = this.f411041r;
        this.D = false;
        this.f411042s = 0.0f;
        invalidate();
    }

    public w(Context r100) {
        this(r100, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f411030g.setStrokeWidth(this.B);
        this.f411030g.setStyle(Paint.Style.FILL);
        this.f411030g.setColor(this.f411028e);
        r100.drawCircle(this.f411034k, this.f411035l, this.f411037n, this.f411030g);
        this.f411030g.setColor(this.f411029f);
        r100.drawCircle(this.f411034k, this.f411035l, this.f411038o, this.f411030g);
        if (this.D == false) goto L5;
    L6:
        this.f411030g.setColor(this.f411026c);
        this.f411030g.setStyle(Paint.Style.STROKE);
        this.f411030g.setStrokeWidth(this.f411031h);
        r100.drawArc(this.f411046w, 0.0f, 360.0f, false, this.f411030g);
        this.f411030g.setColor(this.f411027d);
        this.f411030g.setStyle(Paint.Style.STROKE);
        this.f411030g.setStrokeWidth(this.f411031h);
        r100.drawArc(this.f411046w, -90.0f, this.f411042s, false, this.f411030g);
        return;
    L5:
        if (this.f411024a == 4) goto L6;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        int r100 = r110.getAction();
        if (r100 != 0) goto L8;
        Log.d("CaptureButton", "state = " + this.f411024a);
        if (r110.getPointerCount() <= 1) goto L49;
    L56:
        return true;
    L49:
        if (this.f411024a != 1) goto L56;
        r110.getY();
        this.f411024a = 2;
        if (Intrinsics.areEqual(this.f411025b, CameraParam.MODE_ONLY_VIDEO) == false) goto L54;
    L55:
        this.C = true;
        postDelayed(this.f411047x, 100);
        goto L56
    L54:
        if (Intrinsics.areEqual(this.f411025b, CameraParam.MODE_PHOTO_VIDEO_BOTH) == false) goto L56;
    L8:
        if (r100 == 1) goto L20;
        if (r100 != 2) goto L56;
        if (this.f411048y == null) goto L56;
        if (this.f411024a != 4) goto L56;
        if (Intrinsics.areEqual(this.f411025b, CameraParam.MODE_ONLY_VIDEO) == false) goto L18;
    L19:
        r110.getY();
        goto L56
    L18:
        if (Intrinsics.areEqual(this.f411025b, CameraParam.MODE_PHOTO_VIDEO_BOTH) == false) goto L56;
    L20:
        this.C = false;
        int r111 = this.f411024a;
        if (r111 == 2) goto L31;
        if (r111 == 3) goto L31;
        if (r111 == 4) goto L25;
        this.f411024a = 1;
        b();
        this.f411024a = 1;
        goto L56
    L25:
        setEnabled(false);
        ValueAnimator r112 = this.A;
        if (r112 == null) goto L28;
        r112.cancel();
    L28:
        ValueAnimator r113 = this.A;
        if (r113 == null) goto L56;
        r113.removeAllListeners();
    L31:
        if (r111 != 2) goto L33;
        removeCallbacks(this.f411047x);
    L39:
        if (this.f411048y != null) goto L41;
    L45:
        this.f411024a = 1;
        goto L56
    L41:
        if (Intrinsics.areEqual(this.f411025b, CameraParam.MODE_ONLY_PHOTO) == false) goto L43;
    L44:
        setEnabled(false);
        b();
        float r114 = this.f411038o;
        Log.d("CaptureButton", "startCaptureAnimation func");
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{r114, 0.5f * r114, r114});
        r115.addUpdateListener(new x(this));
        r115.addListener(new y(this));
        r115.setDuration(100);
        r115.start();
        goto L56
    L43:
        if (Intrinsics.areEqual(this.f411025b, CameraParam.MODE_PHOTO_VIDEO_BOTH) == false) goto L45;
    L33:
        AnimatorSet r116 = this.f411049z;
        if (r116 == null) goto L39;
        r116.removeAllListeners();
        AnimatorSet r117 = this.f411049z;
        if (r117 == null) goto L39;
        r117.cancel();
        goto L39
    }

    public final void setButtonMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f411025b = r100;
    }

    public final void setCaptureLisenter(d0b.a r100) {
        this.f411048y = r100;
    }

    public final void setDuration(int r100) {
        this.f411043t = r100;
    }

    public final void setMinDuration(int r100) {
        this.f411044u = r100;
    }

    public w(Context r100, int r101) {
        super(r100);
        this.f411025b = CameraParam.MODE_ONLY_PHOTO;
        this.f411026c = -1;
        this.f411027d = FakePickerAvatarCreator.BLUE;
        this.f411028e = FakePickerAvatarCreator.GRAY;
        this.f411029f = -1;
        this.C = true;
        this.f411026c = UIUtils.getColor(getContext(), R.color.lkui_N00);
        this.f411027d = UIUtils.getColor(getContext(), R.color.lkui_B500);
        this.f411028e = UIUtils.getColor(getContext(), R.color.lkui_N00);
        this.f411029f = UIUtils.getColor(getContext(), R.color.lkui_N200);
        Paint r102 = new Paint(1);
        this.f411030g = r102;
        this.B = r102.getStrokeWidth();
        this.f411039p = r101;
        float r103 = r101 / 2.0f;
        this.f411036m = r103;
        this.f411037n = r103;
        this.f411040q = r103;
        float r104 = r103 - UIUtils.dp2px(getContext(), 6.0f);
        this.f411038o = r104;
        this.f411041r = r104;
        float r105 = UIUtils.dp2px(getContext(), 9.0f);
        this.f411031h = r105;
        float r106 = 2;
        int r107 = (int) ((r103 / 3) * r106);
        this.f411032i = r107;
        this.f411033j = (int) this.f411038o;
        this.f411042s = 0.0f;
        this.f411047x = new b(this);
        this.f411024a = 1;
        this.f411025b = CameraParam.MODE_PHOTO_VIDEO_BOTH;
        this.f411043t = 30000;
        this.f411044u = 1500;
        this.f411034k = ((r107 * 2) + r101) / 2;
        this.f411035l = (r101 + (r107 * 2)) / 2;
        float r108 = (r103 + r107) - (r105 / r106);
        float r109 = this.f411034k;
        float r110 = this.f411035l;
        this.f411046w = new RectF(r109 - r108, r110 - r108, r109 + r108, r110 + r108);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = this.f411039p;
        int r103 = this.f411032i;
        setMeasuredDimension((r103 * 2) + r102, r102 + (r103 * 2));
    }
}
