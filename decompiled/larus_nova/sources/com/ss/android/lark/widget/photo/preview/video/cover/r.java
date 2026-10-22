package com.ss.android.lark.widget.photo.preview.video.cover;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.g0;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;
import com.ss.android.lark.widget.photo.preview.video.online.f0;
import com.ss.android.lark.widget.photo.preview.video.online.k0;
import com.ss.android.lark.widget.photo.preview.video.pip.PipModeProcessor;
import com.ss.android.lark.widget.photo.preview.video.speed.PlaySpeedLevel;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class r extends vcc.a {
    public static final /* synthetic */ int D = 0;
    public y0c.b A;
    public int B;
    public final Lazy C;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRequestCreator f447235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PhotoItem f447236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OperateListener f447237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vcc.b f447238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f447239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AppCompatImageView f447240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AppCompatImageView f447241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f447242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f447243m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AppCompatImageView f447244n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AppCompatImageView f447245o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public VideoControlBar f447246p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ProgressBar f447247q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AppCompatTextView f447248r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AppCompatImageView f447249s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AppCompatImageView f447250t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AppCompatImageView f447251u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f447252v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f447253w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f447254x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f447255y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final z f447256z;

    public static final class a {
    }

    public static final class b implements rkb.g<Object, Object> {
        public b() {
        }

        @Override // rkb.g
        public final boolean onLoadFailed(Exception r100, Object r101, Target<Object> r102, boolean r103) {
            ErrorResult r104 = new ErrorResult(PerfPhotoViewMonitor.ErrorReason.PIC_LOAD_MEDIA_COVER_FAILED);
            if ((r101 instanceof EncryptImage) == false) goto L5;
            r104 = ((EncryptImage) r101).getErrorResult();
        L5:
            PerfPhotoViewMonitor.f447616a.getClass();
            PerfPhotoViewMonitor.c(r104);
            return false;
        }

        @Override // rkb.g
        public final boolean onResourceReady(Object r100, Object r101, Target<Object> r102, DataSource r103, boolean r104) {
            PerfPhotoViewMonitor.f447616a.getClass();
            PerfPhotoViewMonitor.d(2);
            PerfPhotoViewMonitor.c(null);
            return false;
        }
    }

    static {
    }

    public final void G() {
        C(true);
        VideoControlBar r100 = this.f447246p;
        AppCompatImageView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoControlBar");
        r100 = null;
    L5:
        r100.e(false);
        VideoControlBar r102 = this.f447246p;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoControlBar");
        r102 = null;
    L8:
        SeekBar r103 = r102.f447170e;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
        r103 = null;
    L11:
        r102.d(0, r103.getMax());
        AppCompatImageView r104 = this.f447240j;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoCover");
    L15:
        r101.setVisibility(0);
        v(true);
        H();
        return;
    L14:
        r101 = r104;
        goto L15
    }

    public final void F() {
        String r100 = this.f447236f.getMiddlePicInfo().key;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = this.f447236f.getOriginPicInfo().key;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        r100 = this.f447236f.getImageKey();
    L8:
        boolean r101 = true;
        if (r100 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L18;
        Object r103 = new EncryptImage(r100);
    L26:
        Intrinsics.checkNotNull(r103);
        IRequestCreator r104 = this.f447235e.load(r103).error(R.drawable.__picker_ic_broken_image_black_48dp).listener(new b());
        AppCompatImageView r105 = this.f447240j;
        if (r105 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoCover");
        r105 = null;
    L29:
        r104.into(r105);
        return;
    L18:
        if ((!this.f447236f.getPaths().isEmpty()) == true) goto L20;
    L25:
        r103 = "";
        goto L26
    L20:
        if (((CharSequence) ListProtector.get(this.f447236f.getPaths(), 0)).length() > 0) goto L23;
        r101 = false;
    L23:
        if (r101 == false) goto L25;
        r103 = ListProtector.get(this.f447236f.getPaths(), 0);
        goto L26
    L11:
        if (r100.length() == 0) goto L14;
        r102 = false;
        goto L15
    }

    public final void H() {
        ((VideoControllerCover$mHandler$2.a) this.C.getValue()).removeMessages(1);
        ((VideoControllerCover$mHandler$2.a) this.C.getValue()).sendEmptyMessageDelayed(1, 3000);
    }

    @Override // vcc.a, y0c.b
    public final void f() {
        y0c.b r100 = this.A;
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // v0c.o
    public final void g() {
        ViewGroup r100 = this.f447239i;
        VideoControlBar r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        r100 = null;
    L5:
        this.f447240j = (AppCompatImageView) r100.findViewById(R.id.video_cover);
        this.f447241k = (AppCompatImageView) r100.findViewById(R.id.center_play_btn);
        this.f447242l = (ViewGroup) r100.findViewById(R.id.function_top_layout);
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.function_bottom_layout);
        float[] r103 = {0.0f, 0.5f, 0.9f};
        GradientDrawable r104 = new GradientDrawable();
        r104.setGradientType(0);
        r104.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        r104.setColors(new int[]{1711276032, 1275068416, 0});
        r104.setGradientCenter(r103[0], r103[1]);
        r102.setBackground(r104);
        this.f447243m = r102;
        this.f447244n = (AppCompatImageView) r100.findViewById(R.id.close_btn);
        this.f447245o = (AppCompatImageView) r100.findViewById(R.id.enter_pip_btn);
        this.f447246p = (VideoControlBar) r100.findViewById(R.id.video_control_bar);
        this.f447248r = (AppCompatTextView) r100.findViewById(R.id.speed_btn);
        this.f447249s = (AppCompatImageView) r100.findViewById(R.id.download_btn);
        this.f447250t = (AppCompatImageView) r100.findViewById(R.id.album_btn);
        this.f447251u = (AppCompatImageView) r100.findViewById(R.id.more_action_btn);
        this.f447247q = (ProgressBar) r100.findViewById(R.id.pip_mode_progress_bar);
        VideoControlBar r105 = this.f447246p;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoControlBar");
        r105 = null;
    L8:
        ProgressBar r106 = this.f447247q;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPipModeProgressBar");
        r106 = null;
    L11:
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "pipModeProgressBar");
        AppCompatImageView r107 = (AppCompatImageView) r105.findViewById(R.id.toggle_play_btn);
        int r108 = UIUtils.dp2px(r105.getContext(), 30.0f);
        g0.a(r107, r108, r108, r108, r108);
        r105.f447168c = r107;
        r105.f447169d = (TextView) r105.findViewById(R.id.current_play_time);
        SeekBar r109 = (SeekBar) r105.findViewById(R.id.seek_bar);
        int r110 = UIUtils.dp2px(r109.getContext(), 30.0f);
        g0.a(r109, r110, r110, r110, r110);
        r105.f447170e = r109;
        r105.f447171f = (TextView) r105.findViewById(R.id.video_duration);
        r105.f447172g = r106;
        AppCompatTextView r111 = this.f447248r;
        if (r111 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSpeedBtn");
        r111 = null;
    L14:
        r111.setText(PlaySpeedLevel.LEVEL_NORMAL.getDesc());
        AppCompatImageView r112 = this.f447245o;
        if (r112 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mEnterPipBtn");
        r112 = null;
    L17:
        int r113 = 8;
        if (PipModeProcessor.b(((f0.d) this.f447238h).f447350a.f447323d) == false) goto L20;
        int r114 = 0;
    L21:
        r112.setVisibility(r114);
        AppCompatImageView r115 = this.f447250t;
        if (r115 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mAlbumBtn");
        r115 = null;
    L25:
        if (((f0.d) this.f447238h).f447350a.f447322c == false) goto L27;
        int r116 = 0;
    L28:
        r115.setVisibility(r116);
        AppCompatImageView r117 = this.f447249s;
        if (r117 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mSaveBtn");
        r117 = null;
    L32:
        if (((f0.d) this.f447238h).f447350a.f447337r == false) goto L34;
        r113 = 0;
    L34:
        r117.setVisibility(r113);
        MediaExtra r118 = this.f447236f.getMediaExtra();
        if (r118 == null) goto L37;
        long r119 = r118.getDuration();
    L39:
        if (r119 <= 0) goto L44;
        VideoControlBar r120 = this.f447246p;
        if (r120 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoControlBar");
        r120 = null;
    L43:
        r120.d(0, (int) r119);
    L44:
        AppCompatTextView r121 = this.f447248r;
        if (r121 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mSpeedBtn");
        r121 = null;
    L47:
        r121.setOnClickListener(new t(this));
        AppCompatImageView r122 = this.f447249s;
        if (r122 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mSaveBtn");
        r122 = null;
    L50:
        r122.setOnClickListener(new u(this));
        AppCompatImageView r123 = this.f447250t;
        if (r123 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mAlbumBtn");
        r123 = null;
    L53:
        r123.setOnClickListener(new v(this));
        AppCompatImageView r124 = this.f447251u;
        if (r124 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreActionBtn");
        r124 = null;
    L56:
        r124.setOnClickListener(new w(this));
        AppCompatImageView r125 = this.f447241k;
        if (r125 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterPlayBtn");
        r125 = null;
    L59:
        r125.setOnClickListener(new x(this));
        AppCompatImageView r126 = this.f447244n;
        if (r126 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mCloseBtn");
        r126 = null;
    L62:
        r126.setOnClickListener(new y(this));
        AppCompatImageView r127 = this.f447245o;
        if (r127 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mEnterPipBtn");
        r127 = null;
    L65:
        int r128 = UIUtils.dp2px(getContext(), 30.0f);
        g0.a(r127, r128, r128, r128, r128);
        AppCompatImageView r129 = this.f447244n;
        if (r129 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mCloseBtn");
        r129 = null;
    L68:
        int r130 = UIUtils.dp2px(getContext(), 30.0f);
        g0.a(r129, r130, r130, r130, r130);
        AppCompatImageView r131 = this.f447245o;
        if (r131 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mEnterPipBtn");
        r131 = null;
    L71:
        r131.setOnClickListener(new s(this));
        VideoControlBar r132 = this.f447246p;
        if (r132 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoControlBar");
    L75:
        r101.setOnTogglePlay(new VideoControllerCover$initListeners$8$1(this));
        r101.setOnSeekBarChangeListener((VideoControllerCover$onSeekBarChangeListener$2.a) this.f447255y.getValue());
        F();
        return;
    L74:
        r101 = r132;
        goto L75
    L37:
        r119 = 0;
        goto L39
    L27:
        r116 = 8;
        goto L28
    L20:
        r114 = 8;
        goto L21
    }

    @Override // vcc.a
    public final void s() {
        ((VideoControllerCover$mHandler$2.a) this.C.getValue()).removeMessages(1);
        ((VideoControllerCover$mHandler$2.a) this.C.getValue()).removeCallbacks(this.f447256z);
    }

    @Override // vcc.a
    public final void t() {
        ((VideoControllerCover$mHandler$2.a) this.C.getValue()).removeMessages(1);
        I(true);
        if (this.B != 3) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L9;
        C(true);
        return;
    L9:
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // vcc.a
    public final void A(String r100) {
        Intrinsics.checkNotNullParameter(r100, "speedTxt");
        AppCompatTextView r101 = this.f447248r;
        if (r101 == null) goto L8;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSpeedBtn");
        r101 = null;
    L6:
        r101.setText(r100);
        return;
    }

    @Override // vcc.a
    public final void C(boolean r100) {
        if (this.f447253w == false) goto L5;
        return;
    L5:
        AppCompatImageView r101 = this.f447241k;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterPlayBtn");
        r101 = null;
    L8:
        if (r100 == false) goto L10;
        int r102 = 0;
    L11:
        r101.setVisibility(r102);
        return;
    L10:
        r102 = 8;
        goto L11
    }

    @Override // vcc.a
    public final void D(boolean r100) {
        AppCompatImageView r101 = this.f447251u;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreActionBtn");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    @Override // vcc.a
    public final void E(boolean r100) {
        p();
        VideoControlBar r101 = this.f447246p;
        AppCompatImageView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoControlBar");
        r101 = null;
    L5:
        int r103 = 8;
        r101.setVisibility(8);
        AppCompatTextView r104 = this.f447248r;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSpeedBtn");
        r104 = null;
    L8:
        r104.setVisibility(8);
        AppCompatImageView r105 = this.f447249s;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSaveBtn");
        r105 = null;
    L11:
        r105.setVisibility(8);
        AppCompatImageView r106 = this.f447240j;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoCover");
        r106 = null;
    L14:
        r106.setVisibility(0);
        AppCompatImageView r107 = this.f447241k;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterPlayBtn");
        r107 = null;
    L17:
        r107.setVisibility(8);
        AppCompatImageView r108 = this.f447245o;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mEnterPipBtn");
        r108 = null;
    L20:
        r108.setVisibility(8);
        AppCompatImageView r109 = this.f447251u;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreActionBtn");
    L25:
        if ((!r100) == false) goto L27;
        r103 = 0;
    L27:
        r102.setVisibility(r103);
        return;
    L23:
        r102 = r109;
        goto L25
    }

    public final void I(boolean r100) {
        if (this.f447253w == false) goto L5;
        return;
    L5:
        ViewGroup r101 = this.f447242l;
        ViewGroup r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFuncTopLayout");
        r101 = null;
    L8:
        int r103 = 0;
        if (r100 == false) goto L11;
        int r104 = 0;
    L12:
        r101.setVisibility(r104);
        ViewGroup r105 = this.f447243m;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFuncBottomLayout");
    L16:
        if (r100 == true) goto L19;
        r103 = 8;
    L19:
        r102.setVisibility(r103);
        return;
    L15:
        r102 = r105;
        goto L16
    L11:
        r104 = 8;
        goto L12
    }

    public final void J(int r100) {
        if (this.B != 3) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        I(false);
        C(false);
    L9:
        ((f0.d) this.f447238h).f447350a.s(Integer.valueOf(r100));
        return;
    L8:
        I(true);
        C(true);
        H();
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    @Override // v0c.a
    public final View m(Context r100) {
        View r101 = LayoutInflater.from(r100).inflate(R.layout.layout_video_controller_cover, null);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r102 = (ViewGroup) r101;
        this.f447239i = r102;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        return null;
    L6:
        return r102;
    }

    @Override // vcc.a, y0c.b
    public final void onDoubleTap(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        y0c.b r101 = this.A;
        if (r101 == null) goto L6;
        r101.onDoubleTap(r100);
        return;
    }

    @Override // vcc.a, y0c.b
    public final void onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        y0c.b r101 = this.A;
        if (r101 == null) goto L6;
        r101.onDown(r100);
        return;
    }

    @Override // vcc.a, y0c.b
    public final void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        y0c.b r101 = this.A;
        if (r101 == null) goto L6;
        r101.onLongPress(r100);
        return;
    }

    @Override // vcc.a, y0c.b
    public final void onSingleTapUp(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = com.ss.android.lark.widget.photo.preview.utils.a.f447152a;
        ViewGroup r102 = this.f447242l;
        AppCompatImageView r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mFuncTopLayout");
        r102 = null;
    L6:
        if (com.ss.android.lark.widget.photo.preview.utils.a.b(r102, r100) == true) goto L14;
        ViewGroup r104 = this.f447243m;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFuncBottomLayout");
        r104 = null;
    L11:
        if (com.ss.android.lark.widget.photo.preview.utils.a.b(r104, r100) == true) goto L14;
        J(com.ss.android.lark.widget.photo.preview.utils.a.a(this.f447236f.getVideoKey()));
    L68:
        y0c.b r105 = this.A;
        if (r105 == null) goto L72;
        r105.onSingleTapUp(r100);
        return;
    L72:
        return;
    L14:
        int r106 = 8;
        if (this.f447253w == true) goto L47;
        ViewGroup r107 = this.f447242l;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFuncTopLayout");
        r107 = null;
    L20:
        ViewGroup r108 = this.f447242l;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mFuncTopLayout");
        r108 = null;
    L24:
        if (r108.getVisibility() != 0) goto L26;
        boolean r109 = true;
    L28:
        if ((!r109) == false) goto L30;
        int r110 = 0;
    L31:
        r107.setVisibility(r110);
        ViewGroup r111 = this.f447243m;
        if (r111 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFuncBottomLayout");
        r111 = null;
    L34:
        ViewGroup r112 = this.f447243m;
        if (r112 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mFuncBottomLayout");
        r112 = null;
    L38:
        if (r112.getVisibility() != 0) goto L40;
        boolean r113 = true;
    L42:
        if ((!r113) == false) goto L44;
        int r114 = 0;
    L45:
        r111.setVisibility(r114);
        goto L47
    L44:
        r114 = 8;
        goto L45
    L40:
        r113 = false;
        goto L42
    L30:
        r110 = 8;
        goto L31
    L26:
        r109 = false;
    L47:
        if (this.B != 3) goto L49;
        boolean r115 = true;
    L50:
        if (r115 == true) goto L66;
        AppCompatImageView r116 = this.f447241k;
        if (r116 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterPlayBtn");
        r116 = null;
    L54:
        AppCompatImageView r117 = this.f447241k;
        if (r117 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterPlayBtn");
    L59:
        if (r103.getVisibility() != 0) goto L61;
        boolean r118 = true;
    L63:
        if ((!r118) == false) goto L65;
        r106 = 0;
    L65:
        r116.setVisibility(r106);
    L67:
        H();
        goto L68
    L61:
        r118 = false;
        goto L63
    L57:
        r103 = r117;
        goto L59
    L66:
        C(false);
        goto L67
    L49:
        r115 = false;
        goto L50
    }

    @Override // vcc.a
    public final void u(boolean r100) {
        this.f447253w = r100;
        ProgressBar r101 = this.f447247q;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPipModeProgressBar");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    @Override // vcc.a
    public final void v(boolean r100) {
        if (this.B != 3) goto L5;
        boolean r101 = true;
    L6:
        Log.i("VideoFunctionCover", "setControlLayerVisibility: " + r100 + ", isVideoPlaying: " + r101);
        if (r101 == false) goto L10;
        if (r100 == false) goto L10;
        H();
    L10:
        I(r100);
        C(!r101);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // vcc.a
    public final void x(int r100) {
        AppCompatImageView r101 = this.f447240j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoCover");
        r101 = null;
    L5:
        r101.setBackgroundColor(r100);
    }

    @Override // vcc.a
    public final void z(k0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.A = r100;
    }

    @Override // vcc.a
    public final void B(boolean r100, boolean r101) {
        ViewGroup r102 = this.f447243m;
        AppCompatImageView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFuncBottomLayout");
        r102 = null;
    L5:
        int r104 = 8;
        if (r100 == false) goto L8;
        int r105 = 0;
    L9:
        r102.setVisibility(r105);
        ViewGroup r106 = this.f447242l;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFuncTopLayout");
        r106 = null;
    L12:
        if (r100 == false) goto L14;
        int r107 = 0;
    L15:
        r106.setVisibility(r107);
        AppCompatImageView r108 = this.f447241k;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterPlayBtn");
    L19:
        if (r100 == false) goto L21;
        r104 = 0;
    L21:
        r103.setVisibility(r104);
        if (r101 == false) goto L25;
        H();
        return;
    L25:
        return;
    L18:
        r103 = r108;
        goto L19
    L14:
        r107 = 8;
        goto L15
    L8:
        r105 = 8;
        goto L9
    }

    @Override // v0c.b, v0c.o
    public final void a(int r100, Bundle r101) {
        AppCompatImageView r102 = null;
        boolean r103 = false;
        switch(r100) {
            case -99031: goto L16;
            case -99016: goto L13;
            case -99015: goto L8;
            case -99014: goto L7;
            case -99010: goto L6;
            case -99004: goto L5;
            default: goto L57;
        };
    L5:
        this.f447236f.setLoadStatus(PhotoItem.LOAD_STATUS.SUCCESS);
        com.ss.android.lark.widget.photopicker.utils.b.f447647a.b(this.f447236f);
        return;
    L6:
        C(false);
        return;
    L7:
        this.f447252v = true;
        v(true);
        return;
    L8:
        AppCompatImageView r104 = this.f447240j;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoCover");
    L12:
        r102.setVisibility(8);
        this.f447252v = true;
        return;
    L11:
        r102 = r104;
        goto L12
    L13:
        p();
        G();
        int r105 = com.ss.android.lark.widget.photo.preview.utils.a.f447152a;
        ucc.a r106 = (ucc.a) com.ss.android.lark.widget.photo.preview.utils.a.c(ucc.a.class);
        if (r106 == null) goto L53;
        r106.oa(this.f447236f.getVideoKey());
        return;
    L53:
        return;
    L16:
        if (r101 == null) goto L55;
        int r107 = r101.getInt("int_data");
        this.B = r107;
        StringBuilder r108 = new StringBuilder("onPlayerStatusChange: ");
        int r109 = this.B;
        switch(r109) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            default: goto L19;
        };
    L19:
        String r110 = String.valueOf(r109);
    L26:
        r108.append(r110);
        Log.i("VideoFunctionCover", r108.toString());
        if (r107 != 3) goto L29;
        C(false);
        VideoControlBar r111 = this.f447246p;
        if (r111 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoControlBar");
        r111 = null;
    L41:
        r111.e(true);
        H();
        PipModeProcessor.f(true);
    L43:
        if (this.B != 3) goto L45;
        r103 = true;
    L45:
        if (r103 == false) goto L47;
        n();
        return;
    L47:
        j(-66016, null);
        return;
    L29:
        if (r107 != 4) goto L31;
        C(true);
        I(true);
        VideoControlBar r112 = this.f447246p;
        if (r112 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoControlBar");
        r112 = null;
    L37:
        r112.e(false);
        H();
        PipModeProcessor.f(false);
        goto L43
    L31:
        if (r107 != 6) goto L43;
        PipModeProcessor.f(false);
        goto L43
    L20:
        r110 = "PLAYBACK_COMPLETE";
        goto L26
    L21:
        r110 = "STOPPED";
        goto L26
    L22:
        r110 = "PAUSED";
        goto L26
    L23:
        r110 = "STARTED";
        goto L26
    L24:
        r110 = "PREPARED";
        goto L26
    L25:
        r110 = "INITIALIZED";
        goto L26
    L55:
        return;
    }

    @Override // v0c.b, v0c.o
    public final void h(int r100, Bundle r101) {
        Log.e("VideoFunctionCover", "onErrorEvent: " + r100);
        if (r100 == (-88019)) goto L5;
        G();
        F();
    L20:
        this.f447236f.setLoadStatus(PhotoItem.LOAD_STATUS.FAILED);
        com.ss.android.lark.widget.photopicker.utils.b.f447647a.b(this.f447236f);
        return;
    L5:
        if (r101 == null) goto L7;
        String r102 = r101.getString("string_data");
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
    L18:
        G();
        F();
        goto L20
    L17:
        if (StringsKt.contains$default(r102, "HTTP/1.1 410 Gone", false, 2, null) == true) goto L20;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    L7:
        r102 = null;
        goto L9
    }

    @Override // com.ss.android.lark.player.player.o
    public final void e(int r100, int r101, int r102) {
        if (this.f447252v == true) goto L5;
        return;
    L5:
        VideoControlBar r103 = this.f447246p;
        VideoControlBar r104 = null;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoControlBar");
        r103 = null;
    L8:
        r103.setBufferPercentage(r102);
        VideoControlBar r105 = this.f447246p;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoControlBar");
    L12:
        r104.d(r100, r101);
        int r106 = com.ss.android.lark.widget.photo.preview.utils.a.f447152a;
        ucc.a r107 = (ucc.a) com.ss.android.lark.widget.photo.preview.utils.a.c(ucc.a.class);
        if (r107 == null) goto L16;
        r107.b7(this.f447236f.getVideoKey(), r100);
        return;
    L16:
        return;
    L11:
        r104 = r105;
        goto L12
    }

    @Override // vcc.a, y0c.b
    public final void onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "e1");
        Intrinsics.checkNotNullParameter(r101, "e2");
        y0c.b r104 = this.A;
        if (r104 == null) goto L6;
        r104.onScroll(r100, r101, r102, r103);
        return;
    }

    public r(FragmentActivity r100, IRequestCreator r101, PhotoItem r102, OperateListener r103, f0.d r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "requestCreator");
        Intrinsics.checkNotNullParameter(r102, "photoItem");
        Intrinsics.checkNotNullParameter(r103, "operateListener");
        Intrinsics.checkNotNullParameter(r104, "functionCoverDependency");
        super(r100);
        this.f447235e = r101;
        this.f447236f = r102;
        this.f447237g = r103;
        this.f447238h = r104;
        this.f447252v = true;
        this.f447254x = -1;
        this.f447255y = LazyKt.lazy(new VideoControllerCover$onSeekBarChangeListener$2(this));
        this.f447256z = new z(this);
        this.B = -1;
        this.C = LazyKt.lazy(new VideoControllerCover$mHandler$2(this));
    }
}
