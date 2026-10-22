package com.ss.android.lark.cameraview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010'\u001a\u00020(2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010)\u001a\u00020(2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010*\u001a\u00020(2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0014J\b\u0010.\u001a\u00020(H\u0002J\u0006\u0010/\u001a\u00020(J\b\u00100\u001a\u00020(H\u0002J\u0006\u00101\u001a\u00020(J\u0006\u00102\u001a\u00020(J\u0010\u00103\u001a\u00020(2\b\u00104\u001a\u0004\u0018\u000105J\u000e\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u0007J\u000e\u00108\u001a\u00020(2\u0006\u00109\u001a\u000205J\u0010\u0010:\u001a\u00020(2\b\u00104\u001a\u0004\u0018\u000105J\u0006\u0010;\u001a\u00020(J\u0016\u0010<\u001a\u00020(2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010=\u001a\u00020(J\u0010\u0010>\u001a\u00020(2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010?\u001a\u00020(2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/ss/android/lark/cameraview/CaptureLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "captureListener", "Lcom/ss/android/lark/cameraview/listener/CaptureListener;", "typeListener", "Lcom/ss/android/lark/cameraview/listener/TypeListener;", "returnListener", "Lcom/ss/android/lark/cameraview/listener/ReturnListener;", "leftClickListener", "Lcom/ss/android/lark/cameraview/listener/ClickListener;", "rightClickListener", "btnCapture", "Lcom/ss/android/lark/cameraview/CaptureButton;", "btnConfirm", "Lcom/ss/android/lark/cameraview/TypeButton;", "btnCancel", "btnReturn", "Lcom/ss/android/lark/cameraview/ReturnButton;", "ivCustomLeft", "Landroid/widget/ImageView;", "ivCustomRight", "customMargin", "txtTip", "Landroid/widget/TextView;", "layoutWidth", "layoutHeight", "buttonSize", "iconLeft", "iconRight", "isFirst", "", "setTypeListener", "", "setCaptureListener", "setReturnListener", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "initEvent", "startTypeBtnAnimator", "initView", "resetCaptureLayout", "startAlphaAnimation", "setTextWithAnimation", AppConstants.BUNDLE_TIP, "", "setDuration", "duration", "setButtonMode", "mode", "setTip", "showTip", "setIconSrc", "enableCaptureBtn", "setLeftClickListener", "setRightClickListener", "cameraview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0b.a f410807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0b.f f410808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0b.b f410809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d0b.b f410810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w f410811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a1 f410812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a1 f410813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public y0 f410814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f410815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f410816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f410817k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f410818l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f410819m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f410820n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f410821o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f410822p;

    public CaptureLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CaptureLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setReturnListener(d0b.e r100) {
    }

    public final void a() {
        w r100 = this.f410811e;
        ImageView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r100 = null;
    L5:
        r100.f411024a = 1;
        a1 r102 = this.f410813g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        r102 = null;
    L8:
        r102.setVisibility(8);
        a1 r103 = this.f410812f;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        r103 = null;
    L11:
        r103.setVisibility(8);
        w r104 = this.f410811e;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r104 = null;
    L14:
        r104.setVisibility(0);
        if (this.f410820n == 0) goto L20;
        ImageView r105 = this.f410815i;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r105 = null;
    L19:
        r105.setVisibility(0);
    L25:
        if (this.f410821o == 0) goto L32;
        ImageView r106 = this.f410816j;
        if (r106 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
    L30:
        r101.setVisibility(0);
        return;
    L29:
        r101 = r106;
        goto L30
    L32:
        return;
    L20:
        y0 r107 = this.f410814h;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("btnReturn");
        r107 = null;
    L23:
        r107.setVisibility(0);
        goto L25
    }

    public final void b() {
        if (this.f410822p == false) goto L9;
        TextView r100 = this.f410817k;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("txtTip");
        r100 = null;
    L7:
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        r101.setDuration(500);
        r101.start();
        this.f410822p = false;
        return;
    }

    public final void setButtonMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        w r101 = this.f410811e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r101 = null;
    L5:
        r101.setButtonMode(r100);
    }

    public final void setCaptureListener(d0b.a r100) {
        this.f410807a = r100;
    }

    public final void setDuration(int r100) {
        w r101 = this.f410811e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r101 = null;
    L5:
        r101.setDuration(r100);
    }

    public final void setLeftClickListener(d0b.b r100) {
        this.f410809c = r100;
    }

    public final void setRightClickListener(d0b.b r100) {
        this.f410810d = r100;
    }

    public final void setTextWithAnimation(String r100) {
        TextView r101 = this.f410817k;
        TextView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("txtTip");
        r101 = null;
    L5:
        r101.setText(r100);
        TextView r103 = this.f410817k;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("txtTip");
    L9:
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r102, "alpha", new float[]{0.0f, 1.0f, 1.0f, 0.0f});
        r104.setDuration(2500);
        r104.start();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void setTip(String r100) {
        TextView r101 = this.f410817k;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("txtTip");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public final void setTypeListener(d0b.f r100) {
        this.f410808b = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(this.f410818l, this.f410819m);
    }

    public CaptureLayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f410822p = true;
        Object r113 = r110.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics r100 = new DisplayMetrics();
        ((WindowManager) r113).getDefaultDisplay().getMetrics(r100);
        if (getResources().getConfiguration().orientation != 1) goto L5;
        int r114 = r100.widthPixels;
    L6:
        this.f410818l = r114;
        int r101 = (int) (r114 / 6.0f);
        this.f410819m = (((r101 / 5) * 2) + r101) + UIUtils.dp2px(r110, 60.0f);
        int r115 = (r114 * 2) / 9;
        setWillNotDraw(false);
        this.f410811e = new w(getContext(), r101);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -1);
        r102.gravity = 17;
        w r103 = this.f410811e;
        a1 r104 = null;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r103 = null;
    L9:
        r103.setLayoutParams(r102);
        w r105 = this.f410811e;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r105 = null;
    L12:
        r105.setCaptureLisenter(new f0(this));
        this.f410813g = new a1(getContext(), 1, r101);
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, -1);
        r106.gravity = 16;
        int r107 = (r114 / 4) - (r101 / 2);
        r106.setMargins(r107, 0, 0, 0);
        a1 r108 = this.f410813g;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        r108 = null;
    L15:
        r108.setLayoutParams(r106);
        a1 r109 = this.f410813g;
        if (r109 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        r109 = null;
    L18:
        r109.setOnClickListener(new g0(this));
        this.f410812f = new a1(getContext(), 2, r101);
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(-1, -1);
        r116.gravity = 21;
        r116.setMargins(0, 0, r107, 0);
        a1 r117 = this.f410812f;
        if (r117 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        r117 = null;
    L21:
        r117.setLayoutParams(r116);
        a1 r118 = this.f410812f;
        if (r118 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        r118 = null;
    L24:
        r118.setOnClickListener(new h0(this));
        int r119 = (int) (r101 / 2.5f);
        this.f410814h = new y0(getContext(), r119);
        FrameLayout.LayoutParams r120 = new FrameLayout.LayoutParams(-2, -2);
        r120.gravity = 16;
        r120.setMargins(r114 / 6, 0, 0, 0);
        y0 r121 = this.f410814h;
        if (r121 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("btnReturn");
        r121 = null;
    L27:
        r121.setLayoutParams(r120);
        y0 r122 = this.f410814h;
        if (r122 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("btnReturn");
        r122 = null;
    L30:
        r122.setOnClickListener(new i0(this));
        this.f410815i = new ImageView(getContext());
        FrameLayout.LayoutParams r123 = new FrameLayout.LayoutParams(r119, r119);
        r123.gravity = 16;
        r123.setMargins(r115, 0, 0, 0);
        ImageView r124 = this.f410815i;
        if (r124 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r124 = null;
    L33:
        r124.setLayoutParams(r123);
        ImageView r125 = this.f410815i;
        if (r125 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r125 = null;
    L36:
        r125.setOnClickListener(new j0(this));
        this.f410816j = new ImageView(getContext());
        FrameLayout.LayoutParams r126 = new FrameLayout.LayoutParams(r119, r119);
        r126.gravity = 21;
        r126.setMargins(0, 0, r115, 0);
        ImageView r127 = this.f410816j;
        if (r127 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r127 = null;
    L39:
        r127.setLayoutParams(r126);
        ImageView r128 = this.f410816j;
        if (r128 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r128 = null;
    L42:
        r128.setOnClickListener(new k0(this));
        this.f410817k = new TextView(getContext());
        FrameLayout.LayoutParams r129 = new FrameLayout.LayoutParams(-1, -2);
        r129.gravity = 1;
        r129.setMargins(0, 0, 0, UIUtils.dp2px(getContext(), 5.0f));
        TextView r130 = this.f410817k;
        if (r130 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("txtTip");
        r130 = null;
    L45:
        r130.setText(UIUtils.getString(getContext(), R.string.Lark_Legacy_CameraRecordTip));
        TextView r131 = this.f410817k;
        if (r131 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("txtTip");
        r131 = null;
    L48:
        r131.setTextColor(-1);
        TextView r132 = this.f410817k;
        if (r132 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("txtTip");
        r132 = null;
    L51:
        r132.setGravity(49);
        TextView r133 = this.f410817k;
        if (r133 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("txtTip");
        r133 = null;
    L54:
        r133.setLayoutParams(r129);
        w r134 = this.f410811e;
        if (r134 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r134 = null;
    L57:
        addView(r134);
        a1 r135 = this.f410813g;
        if (r135 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        r135 = null;
    L60:
        addView(r135);
        a1 r136 = this.f410812f;
        if (r136 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        r136 = null;
    L63:
        addView(r136);
        y0 r137 = this.f410814h;
        if (r137 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("btnReturn");
        r137 = null;
    L66:
        addView(r137);
        ImageView r138 = this.f410815i;
        if (r138 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r138 = null;
    L69:
        addView(r138);
        ImageView r139 = this.f410816j;
        if (r139 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r139 = null;
    L72:
        addView(r139);
        TextView r140 = this.f410817k;
        if (r140 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("txtTip");
        r140 = null;
    L75:
        addView(r140);
        ImageView r141 = this.f410816j;
        if (r141 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r141 = null;
    L78:
        r141.setVisibility(8);
        a1 r142 = this.f410813g;
        if (r142 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        r142 = null;
    L81:
        r142.setVisibility(8);
        a1 r143 = this.f410812f;
        if (r143 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
    L85:
        r104.setVisibility(8);
        return;
    L84:
        r104 = r143;
        goto L85
    L5:
        r114 = r100.widthPixels / 2;
        goto L6
    }

    public /* synthetic */ CaptureLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
