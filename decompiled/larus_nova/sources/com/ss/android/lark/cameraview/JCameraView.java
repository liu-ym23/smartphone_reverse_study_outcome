package com.ss.android.lark.cameraview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.camera_export.CameraFG;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class JCameraView extends FrameLayout implements SurfaceHolder.Callback, g0b.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f410828u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0b.c f410829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0b.d f410830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0b.b f410831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d0b.b f410832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f410833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VideoView f410834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public VideoView f410835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f410836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f410837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f410838j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CaptureLayout f410839k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FocusView f410840l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MediaPlayer f410841m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f410842n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Bitmap f410843o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f410844p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f410845q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f410846r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ExecutorService f410847s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f410848t;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f410849a;

        public a(View r100) {
            this.f410849a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            this.f410849a.setVisibility(4);
        }
    }

    @Override // g0b.a
    public final void a() {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
    }

    public final void h() {
        Log.i("JCameraView onDestroy");
        l.a().b();
        this.f410834f.animate().cancel();
        this.f410835g.animate().cancel();
    }

    public final void i() {
        MediaPlayer r100 = this.f410841m;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isPlaying() == false) goto L13;
        MediaPlayer r101 = this.f410841m;
        if (fna.g.d() == true) goto L9;
        r101.stop();
    L10:
        this.f410841m.release();
        this.f410841m = null;
        return;
    L9:
        r101.stop();
        gna.a.a(r101.hashCode());
        goto L10
    }

    private int getMaxWidth() {
        if (CameraFG.getEnableBigScreenCompat() == false) goto L10;
        int r100 = getMeasuredWidth();
        if (r100 <= 0) goto L7;
        return r100;
    L7:
        Log.w("JCameraView", "getMaxWidth / Invalid measuredWidth " + r100 + ", use screenWidth");
        return DeviceUtils.getScreenWidth(this.f410833e);
    L10:
        return DeviceUtils.getScreenWidth(this.f410833e);
    }

    private int getZoomGradient() {
        return (int) (getMaxWidth() / 16.0f);
    }

    public JCameraView(Context r100) {
        this(r100, null);
    }

    private void setButtonMode(String r100) {
        this.f410839k.setButtonMode(r100);
        if (r100.equals(CameraParam.MODE_PHOTO_VIDEO_BOTH) == false) goto L5;
        this.f410839k.setTip(getResources().getString(R.string.Lark_Legacy_CameraRecordTip));
        return;
    L5:
        this.f410839k.setTip("");
    }

    private void setMaxDuration(int r100) {
        if (r100 > 0) goto L4;
        r100 = 30000;
    L4:
        this.f410839k.setDuration(r100);
    }

    @Override // g0b.a
    public final void b(final String r100) {
        j(true);
        this.f410844p = r100;
        this.f410847s.execute(new o0(this, r100));
        CaptureLayout r101 = this.f410839k;
        r101.getClass();
        r101.postDelayed(new e0(r101), 300);
    }

    @Override // g0b.a
    public final void d(Bitmap r100) {
        this.f410843o = r100;
        CaptureLayout r101 = this.f410839k;
        r101.getClass();
        r101.postDelayed(new e0(r101), 300);
        this.f410829a.f470659c.e(1);
    }

    @Override // g0b.a
    public final void e(int r100) {
        if (r100 != 1) goto L5;
        this.f410836h.setVisibility(4);
        d0b.d r101 = this.f410830b;
        if (r101 == null) goto L13;
        r101.a(this.f410843o);
    L13:
        this.f410839k.a();
        return;
    L5:
        if (r100 != 2) goto L13;
        i();
        this.f410829a.h(this.f410834f.getHolder(), this.f410842n);
        d0b.d r102 = this.f410830b;
        if (r102 == null) goto L13;
        r102.c(this.f410844p);
        goto L13
    }

    @Override // g0b.a
    public final void f(int r100) {
        if (r100 != 1) goto L5;
        this.f410836h.setVisibility(4);
    L11:
        this.f410839k.a();
        return;
    L5:
        if (r100 == 2) goto L9;
        if (r100 != 4) goto L11;
        j(false);
        goto L11
    L9:
        j(false);
        i();
        FileUtils.g(this.f410844p);
        this.f410829a.h(this.f410834f.getHolder(), this.f410842n);
        goto L11
    }

    public final void g(CameraParam r100) {
        setMaxDuration(r100.getMaxDuration());
        setButtonMode(r100.getMode());
        l.a().e(getContext(), this.f410834f, r100);
    }

    public final void j(boolean r100) {
        if (r100 == false) goto L4;
        VideoView r101 = this.f410835g;
    L5:
        if (r100 == false) goto L7;
        VideoView r102 = this.f410834f;
    L8:
        r101.setAlpha(1.0f);
        r101.setVisibility(0);
        r102.animate().setDuration(200).alpha(0.0f).setListener(new a(r102));
        return;
    L7:
        r102 = this.f410835g;
        goto L8
    L4:
        r101 = this.f410834f;
        goto L5
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction();
        if (r100 == 0) goto L20;
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L8;
    L25:
        return true;
    L8:
        if (r110.getPointerCount() != 1) goto L11;
        this.f410845q = true;
    L11:
        if (r110.getPointerCount() != 2) goto L25;
        float r101 = r110.getX(0);
        float r102 = r110.getY(0);
        float r111 = (float) Math.sqrt(Math.pow(r101 - r110.getX(1), 2.0d) + Math.pow(r102 - r110.getY(1), 2.0d));
        if (this.f410845q == false) goto L16;
        this.f410846r = r111;
        this.f410845q = false;
    L16:
        if ((((int) (r111 - this.f410846r)) / getZoomGradient()) == 0) goto L25;
        this.f410845q = true;
        this.f410829a.d((r111 - this.f410846r) / getZoomGradient());
        goto L25
    L18:
        this.f410845q = true;
        goto L25
    L20:
        if (r110.getPointerCount() != 1) goto L23;
        this.f410829a.c(r110.getX(), r110.getY(), this.f410834f.getWidth(), this.f410834f.getHeight(), new v0(this));
    L23:
        if (r110.getPointerCount() != 2) goto L25;
        Log.i("JCameraView", "ACTION_DOWN = 2");
        goto L25
    }

    public void setErrorListener(d0b.c r100) {
        l.a().f410948d = r100;
    }

    public void setJCameraListener(d0b.d r100) {
        this.f410830b = r100;
    }

    public void setLeftClickListener(d0b.b r100) {
        this.f410831c = r100;
    }

    public void setRightClickListener(d0b.b r100) {
        this.f410832d = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        Log.i("JCameraView SurfaceCreated");
        this.f410847s.execute(new m0(this));
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        Log.i("JCameraView SurfaceDestroyed");
        l.a().getClass();
    }

    public JCameraView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // g0b.a
    public final boolean c(float r100, float r101) {
        if (r101 <= this.f410839k.getTop()) goto L5;
        return false;
    L5:
        this.f410840l.setVisibility(0);
        if (r100 >= (this.f410840l.getWidth() / 2)) goto L9;
        r100 = this.f410840l.getWidth() / 2;
    L9:
        if (r100 <= (getMaxWidth() - (this.f410840l.getWidth() / 2))) goto L12;
        r100 = getMaxWidth() - (this.f410840l.getWidth() / 2);
    L12:
        if (r101 >= (this.f410840l.getWidth() / 2)) goto L15;
        r101 = this.f410840l.getWidth() / 2;
    L15:
        if (r101 <= (this.f410839k.getTop() - (this.f410840l.getWidth() / 2))) goto L17;
        r101 = this.f410839k.getTop() - (this.f410840l.getWidth() / 2);
    L17:
        FocusView r102 = this.f410840l;
        r102.setX(r100 - (r102.getWidth() / 2));
        FocusView r103 = this.f410840l;
        r103.setY(r101 - (r103.getHeight() / 2));
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f410840l, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.6f});
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f410840l, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.6f});
        ObjectAnimator r106 = ObjectAnimator.ofFloat(this.f410840l, "alpha", new float[]{1.0f, 0.4f, 1.0f, 0.4f, 1.0f, 0.4f, 1.0f});
        AnimatorSet r107 = new AnimatorSet();
        r107.play(r104).with(r105).before(r106);
        r107.setDuration(400);
        r107.start();
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        float r102 = this.f410834f.getMeasuredWidth();
        float r103 = this.f410834f.getMeasuredHeight();
        if (this.f410842n != 0.0f) goto L6;
        this.f410842n = r103 / r102;
        return;
    }

    public JCameraView(Context r100, AttributeSet r101, int r110) {
        super(r100, r101, r110);
        this.f410842n = 0.0f;
        this.f410845q = true;
        this.f410846r = 0.0f;
        this.f410847s = CoreThreadPool.getDefault().getSingleScheduledThreadPool("ve_camera");
        this.f410848t = false;
        this.f410833e = r100;
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.duration_max, R.attr.iconLeft, R.attr.iconMargin, R.attr.iconRight, R.attr.iconSize, R.attr.iconSrc}, r110, 0);
        Resources r111 = getResources();
        r102.getDimensionPixelSize(4, (int) TypedValue.applyDimension(2, 35.0f, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics())));
        Resources r112 = getResources();
        r102.getDimensionPixelSize(2, (int) TypedValue.applyDimension(2, 15.0f, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics())));
        int r113 = r102.getResourceId(5, R.drawable.ic_svg_camera);
        int r103 = r102.getResourceId(1, 0);
        int r104 = r102.getResourceId(3, 0);
        int r105 = r102.getInteger(0, 30000);
        r102.recycle();
        this.f410829a = new e0b.c(getContext(), this);
        setWillNotDraw(false);
        View r106 = LayoutInflater.from(r100).inflate(R.layout.camera_view, this);
        this.f410834f = (VideoView) r106.findViewById(R.id.video_preview);
        this.f410835g = (VideoView) r106.findViewById(R.id.video_play);
        this.f410836h = (ImageView) r106.findViewById(R.id.image_photo);
        ImageView r107 = (ImageView) r106.findViewById(R.id.image_switch);
        this.f410837i = r107;
        r107.setImageResource(r113);
        this.f410838j = (ImageView) r106.findViewById(R.id.image_flash);
        CaptureLayout r108 = (CaptureLayout) r106.findViewById(R.id.capture_layout);
        this.f410839k = r108;
        r108.setDuration(r105);
        CaptureLayout r109 = this.f410839k;
        r109.f410820n = r103;
        r109.f410821o = r104;
        ImageView r114 = null;
        if (r103 == 0) goto L14;
        ImageView r115 = r109.f410815i;
        if (r115 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r115 = null;
    L7:
        r115.setImageResource(r103);
        ImageView r116 = r109.f410815i;
        if (r116 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r116 = null;
    L10:
        r116.setVisibility(0);
        y0 r117 = r109.f410814h;
        if (r117 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("btnReturn");
        r117 = null;
    L13:
        r117.setVisibility(8);
    L22:
        if (r109.f410821o == 0) goto L31;
        ImageView r118 = r109.f410816j;
        if (r118 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r118 = null;
    L26:
        r118.setImageResource(r104);
        ImageView r119 = r109.f410816j;
        if (r119 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
    L30:
        r114.setVisibility(0);
    L36:
        this.f410840l = (FocusView) r106.findViewById(R.id.fouce_view);
        this.f410834f.getHolder().addCallback(this);
        this.f410837i.setOnClickListener(new n0(this));
        this.f410839k.setCaptureListener(new r0(this));
        this.f410839k.setTypeListener(new s0(this));
        this.f410839k.setLeftClickListener(new t0(this));
        this.f410839k.setRightClickListener(new u0(this));
        return;
    L29:
        r114 = r119;
        goto L30
    L31:
        ImageView r120 = r109.f410816j;
        if (r120 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
    L35:
        r114.setVisibility(8);
        goto L36
    L34:
        r114 = r120;
        goto L35
    L14:
        ImageView r121 = r109.f410815i;
        if (r121 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r121 = null;
    L17:
        r121.setVisibility(8);
        y0 r122 = r109.f410814h;
        if (r122 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("btnReturn");
        r122 = null;
    L20:
        r122.setVisibility(0);
        goto L22
    }
}
