package com.bytedance.locallife.live.util;

import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements IVideoFloatManager.VideoFloatManagerListener {
    public i() {
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onClick() {
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onShow() {
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onReturnClick() {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onReturnClick(this);
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onViewReleased() {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onViewReleased(this);
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onClose(boolean r100) {
        if (r100 == false) goto L5;
        EventCenter.enqueueEvent(new Event("live_local_life_float_window_close", System.currentTimeMillis(), null, 4, null));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onMuteButtonClick(boolean r100) {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onMuteButtonClick(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onShow(int r100, int r101, int r102, int r103) {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onShow(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onViewPositionChanged(int r100, int r101, int r102, int r103) {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onViewPositionChanged(this, r100, r101, r102, r103);
    }
}
