package com.bytedance.locallife.adapter.live.impl.host.live.float_window;

import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import it6.m;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements IVideoFloatManager.VideoFloatManagerListener {
    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onClick() {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onClick(this);
        m r100 = b.f256526b;
        if (r100 == null) goto L6;
        r100.onClick();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onShow() {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onShow(this);
        m r100 = b.f256526b;
        if (r100 == null) goto L6;
        r100.onShow();
        return;
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
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onClose(this, r100);
        m r101 = b.f256526b;
        if (r101 == null) goto L6;
        r101.onClose(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onMuteButtonClick(boolean r100) {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onMuteButtonClick(this, r100);
        m r101 = b.f256526b;
        if (r101 == null) goto L6;
        r101.onMuteButtonClick(r100);
        return;
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
