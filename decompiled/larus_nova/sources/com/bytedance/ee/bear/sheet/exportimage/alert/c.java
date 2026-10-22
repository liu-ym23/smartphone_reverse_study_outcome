package com.bytedance.ee.bear.sheet.exportimage.alert;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.util.ui.n;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttm.player.MediaPlayer;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotImageAlertFragment f237511a;

    public c(ScreenshotImageAlertFragment r100) {
        this.f237511a = r100;
    }

    public final void a() {
        FrameLayout r100 = this.f237511a.f237485n;
        if (r100 == null) goto L5;
        int r101 = r100.getMeasuredWidth();
    L6:
        ScreenshotImageAlertFragment r102 = this.f237511a;
        float r103 = r101 / r102.f237491t;
        r102.f237493v = r103;
        SubsamplingScaleImageView r104 = r102.f237486o;
        if (r104 == null) goto L9;
        r104.setMinScale(r103);
    L9:
        ScreenshotImageAlertFragment r105 = this.f237511a;
        SubsamplingScaleImageView r106 = r105.f237486o;
        if (r106 == null) goto L12;
        float r107 = r105.f237493v;
        int r108 = ScreenshotImageAlertFragment.f237478w;
        r106.setMaxScale(RangesKt.coerceAtLeast(r107, 5.0f));
    L12:
        ScreenshotImageAlertFragment r109 = this.f237511a;
        FrameLayout r110 = r109.f237485n;
        if (r110 == null) goto L16;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        int r112 = ScreenshotImageAlertFragment.f237478w;
        r111.height = Math.min(n.d(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND), Math.max(n.d(26), (int) (r109.f237492u * r109.f237493v)));
        r110.setLayoutParams(r111);
        return;
    L16:
        return;
    L5:
        r101 = 0;
        goto L6
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
}
