package com.ss.android.lark.cameraview.cameraViewV2;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.VideoView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larksuite.framework.utils.DeviceUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.camera_export.CameraFG;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/cameraview/cameraViewV2/VideoPreview;", "Landroid/widget/VideoView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "defaultWidth", "defaultHeight", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "realDisplayMetrics", "Landroid/util/DisplayMetrics;", "Companion", "cameraview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoPreview extends VideoView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f410938b;

    public static final class a {
    }

    static {
    }

    public VideoPreview(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public VideoPreview(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public final void onMeasure(int r100, int r110) {
        ViewParent r101 = getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r102 = (ViewGroup) r101;
        if (CameraFG.getEnableAdaptPadAndFoldable() == false) goto L29;
        Resources r103 = getContext().getResources();
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
        Object r105 = getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Integer r106 = null;
        if ((r105 instanceof WindowManager) == false) goto L7;
        WindowManager r107 = (WindowManager) r105;
    L8:
        if (r107 != null) goto L10;
        Intrinsics.checkNotNull(r104);
    L11:
        Integer r108 = Integer.valueOf(r102.getMeasuredWidth());
        boolean r109 = false;
        if (r108.intValue() <= 0) goto L14;
        boolean r111 = true;
    L15:
        if (r111 == true) goto L18;
        r108 = null;
    L18:
        if (r108 == null) goto L20;
        int r112 = r108.intValue();
    L21:
        Integer r113 = Integer.valueOf(r102.getMeasuredHeight());
        if (r113.intValue() <= 0) goto L24;
        r109 = true;
    L24:
        if (r109 == false) goto L26;
        r106 = r113;
    L26:
        if (r106 == null) goto L28;
        int r114 = r106.intValue();
    L30:
        boolean r115 = DeviceUtils.isPad();
        int r116 = VideoView.getDefaultSize(this.f410937a, r100);
        int r117 = VideoView.getDefaultSize(this.f410938b, r110);
        if (r114 <= 0) goto L45;
        if (r112 <= 0) goto L45;
        if (r115 == false) goto L39;
        int r118 = (r112 * 4) / 3;
        if (r114 < r118) goto L38;
        int r119 = View.MeasureSpec.makeMeasureSpec(r112, 1073741824);
        int r120 = View.MeasureSpec.makeMeasureSpec(r118, 1073741824);
    L42:
        r117 = r120;
        r116 = r119;
        goto L45
    L38:
        int r121 = View.MeasureSpec.makeMeasureSpec(r112, 1073741824);
        int r122 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
    L44:
        int r123 = r121;
        r117 = r122;
        r116 = r123;
        goto L45
    L39:
        int r124 = (r112 * 16) / 9;
        if (r114 < r124) goto L43;
        r119 = View.MeasureSpec.makeMeasureSpec(r112, 1073741824);
        r120 = View.MeasureSpec.makeMeasureSpec(r124, 1073741824);
        goto L42
    L43:
        r121 = View.MeasureSpec.makeMeasureSpec((r114 * 9) / 16, 1073741824);
        r122 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
    L45:
        Log.i("VideoPreview", "screenWidth: " + r112 + ", screenHeight: " + r114 + ", finalWidth: " + r116 + ", finalHeight: " + r117);
        super.onMeasure(r116, r117);
        return;
    L28:
        r114 = r104.heightPixels;
        goto L30
    L20:
        r112 = r104.widthPixels;
        goto L21
    L14:
        r111 = false;
        goto L15
    L10:
        r104 = new DisplayMetrics();
        r107.getDefaultDisplay().getRealMetrics(r104);
        goto L11
    L7:
        r107 = null;
        goto L8
    L29:
        Resources r125 = getContext().getResources();
        r112 = WindowDisplayMetricsOverride.apply(r125, r125.getDisplayMetrics()).widthPixels;
        Resources r126 = getContext().getResources();
        r114 = WindowDisplayMetricsOverride.apply(r126, r126.getDisplayMetrics()).heightPixels;
        goto L30
    }

    public VideoPreview(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        Resources r103 = getContext().getResources();
        this.f410937a = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels;
        Resources r104 = getContext().getResources();
        this.f410938b = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).heightPixels;
    }
}
