package com.ss.ttvideoengine.utils;

import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public class DisplayMode {
    private static final String TAG = "DisplayMode";
    private final Runnable applyDisplayMode;
    private int mDisplayMode;
    private View mDisplayView;
    private boolean mEnable;
    private int mVideoHeight;
    private int mVideoWidth;

    public static /* synthetic */ void a(DisplayMode r100) {
        r100.applyDisplayMode();
    }

    private void applyDisplayMode() {
        if (this.mEnable == true) goto L5;
        return;
    L5:
        View r100 = this.mDisplayView;
        if (r100 != null) goto L8;
        return;
    L8:
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == true) goto L12;
        TTVideoEngineLog.d(TAG, "containerView error " + r101);
        return;
    L12:
        View r102 = (View) r101;
        int r103 = r102.getWidth();
        int r104 = r102.getHeight();
        int r105 = this.mDisplayMode;
        int r106 = this.mVideoWidth;
        int r107 = this.mVideoHeight;
        if (r106 <= 0) goto L49;
        if (r107 <= 0) goto L50;
        if (r103 <= 0) goto L51;
        if (r104 <= 0) goto L53;
        float r108 = r106 / r107;
        float r109 = r103;
        float r110 = r104;
        float r111 = r109 / r110;
        if (r105 == 0) goto L36;
        if (r105 != 1) goto L23;
    L38:
        FrameLayout.LayoutParams r112 = (FrameLayout.LayoutParams) r100.getLayoutParams();
        if (r112 != null) goto L42;
        return;
    L42:
        if (r112.height == r104) goto L44;
    L47:
        r112.gravity = 17;
        r112.width = r103;
        r112.height = r104;
        r100.setLayoutParams(r112);
        TTVideoEngineLog.i(TAG, "applyDisplayMode width:" + r112.width + ", height:" + r112.height);
        return;
    L44:
        if (r112.width != r103) goto L47;
        if (r112.gravity != 17) goto L47;
        return;
    L23:
        if (r105 == 2) goto L33;
        if (r105 != 3) goto L27;
    L31:
        r104 = (int) (r109 / r108);
        goto L38
    L27:
        if (r105 != 4) goto L30;
    L28:
        r103 = (int) (r110 * r108);
        goto L38
    L30:
        throw new IllegalArgumentException("unknown displayMode = " + r105);
    L33:
        if (r108 < r111) goto L31;
    L36:
        if (r108 < r111) goto L28;
    L53:
        return;
    L51:
        return;
    L50:
        return;
    }

    public void apply() {
        View r100 = this.mDisplayView;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mEnable == false) goto L15;
        r100.removeCallbacks(this.applyDisplayMode);     // Catch: NullPointerException -> L9
        r100.postOnAnimation(this.applyDisplayMode);     // Catch: NullPointerException -> L9
        return;
    L9:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return;
    }

    public DisplayMode() {
        this.mDisplayMode = 0;
        this.mEnable = true;
        this.applyDisplayMode = new a(this);
    }

    public void setDisplayMode(int r100) {
        this.mDisplayMode = r100;
        apply();
    }

    public void setDisplayView(View r100) {
        TTVideoEngineLog.d(TAG, "setDisplayView " + r100);
        this.mDisplayView = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        apply();
    }

    public void setEnable(boolean r100) {
        this.mEnable = r100;
    }

    public void setVideoSize(int r100, int r101) {
        TTVideoEngineLog.d(TAG, "setVideoSize videoWidth:" + r100 + ", videoHeight:" + r101);
        this.mVideoWidth = r100;
        this.mVideoHeight = r101;
        apply();
    }
}
