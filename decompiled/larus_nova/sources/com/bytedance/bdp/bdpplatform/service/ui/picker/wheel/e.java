package com.bytedance.bdp.bdpplatform.service.ui.picker.wheel;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelView f201487a;

    public e(WheelView r100) {
        this.f201487a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r110, float r111) {
        WheelView r102 = this.f201487a;
        int r103 = WheelView.T;
        r102.a();
        WheelView.b r104 = new WheelView.b(r102, r111);
        r102.f201449e = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("eel/WheelView")).scheduleWithFixedDelay(r104, 0, 5, TimeUnit.MILLISECONDS);
        return true;
    }
}
