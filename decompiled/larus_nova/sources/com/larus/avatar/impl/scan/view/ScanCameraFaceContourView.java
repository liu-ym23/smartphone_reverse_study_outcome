package com.larus.avatar.impl.scan.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.larus.platform.service.e2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import p88.i;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0002J0\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/avatar/impl/scan/view/ScanCameraFaceContourView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "faceContourImageView", "Landroid/widget/ImageView;", "density", "", "isPad", "", "frameWidth", "frameHeight", "onSizeChanged", "", "w", "h", "oldw", "oldh", "updateImageViewLayout", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanCameraFaceContourView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f291190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f291191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f291192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f291193d;

    public static final class a {
    }

    static {
    }

    public ScanCameraFaceContourView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ScanCameraFaceContourView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f291192c > 0) goto L5;
        return;
    L5:
        if (this.f291193d <= 0) goto L18;
        int r100 = i.f528209a;
        int r101 = getWidth();
        int r102 = getHeight();
        boolean r103 = this.f291191b;
        if (r101 >= r102) goto L10;
        boolean r104 = true;
    L11:
        if (r103 == false) goto L14;
        if (r104 == false) goto L14;
        float r105 = r102 * 0.173f;
        FLogger.f375446a.i("ScanCameraFaceContourHelper", "calculateTopMargin pad portrait: viewHeight=" + r102 + ", margin=" + r105);
    L15:
        ImageView r106 = this.f291190a;
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(this.f291192c, this.f291193d);
        r107.gravity = 49;
        r107.topMargin = (int) r105;
        r106.setLayoutParams(r107);
        return;
    L14:
        r105 = r102 * 0.2f;
        goto L15
    L10:
        r104 = false;
        goto L11
    }

    public ScanCameraFaceContourView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ImageView r103 = new ImageView(r100);
        r103.setImageResource(R.drawable.larus_dialog_avatar_ic_face_contour);
        r103.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f291190a = r103;
        Resources r104 = r100.getResources();
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        this.f291191b = e2.f365734a.isPad();
        addView(r103);
    }

    public /* synthetic */ ScanCameraFaceContourView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        int r113 = i.f528209a;
        boolean r114 = this.f291191b;
        boolean r115 = false;
        if (r100 >= r110) goto L5;
        boolean r101 = true;
    L7:
        if (r114 == false) goto L10;
        if (r101 == false) goto L10;
        int r116 = (int) (r100 * 0.94f);
        int r117 = (int) (r116 / 0.8861353f);
        FLogger.f375446a.i("ScanCameraFaceContourHelper", "calculateFrameSize pad portrait: viewWidth=" + r100 + ", viewHeight=" + r110 + ", frameWidth=" + r116 + ", frameHeight=" + r117);
        Pair r102 = TuplesKt.to(Integer.valueOf(r116), Integer.valueOf(r117));
    L16:
        int r118 = ((Number) r102.component1()).intValue();
        int r103 = ((Number) r102.component2()).intValue();
        if (r118 == this.f291192c) goto L19;
    L20:
        this.f291192c = r118;
        this.f291193d = r103;
        a();
        return;
    L19:
        if (r103 != this.f291193d) goto L20;
        return;
    L10:
        if (r100 < r110) goto L12;
        r115 = true;
    L12:
        if (r115 == false) goto L14;
        int r119 = r100 / 2;
    L15:
        int r104 = (int) (r119 / 0.8861353f);
        FLogger.f375446a.i("ScanCameraFaceContourHelper", "calculateFrameSize: viewWidth=" + r100 + ", viewHeight=" + r110 + ", isPad=" + r114 + ", frameWidth=" + r119 + ", frameHeight=" + r104);
        r102 = TuplesKt.to(Integer.valueOf(r119), Integer.valueOf(r104));
        goto L16
    L14:
        r119 = r100;
        goto L15
    L5:
        r101 = false;
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f291192c > 0) goto L7;
        return;
    L7:
        if (this.f291193d <= 0) goto L12;
        a();
        return;
    }
}
