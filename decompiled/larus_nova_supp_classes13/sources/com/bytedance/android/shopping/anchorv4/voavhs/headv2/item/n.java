package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.HeadVideoController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements k73.d {
    public final /* synthetic */ k a;

    public final boolean isMuted() {
        HeadVideoController r0 = this.a.c;
        if (r0 == null) goto L8;
        BasePdpVideoView r1 = r0.d;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isMute();
    L8:
        return false;
    }

    public final boolean isPlaying() {
        HeadVideoController r0 = this.a.c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d() != true) goto L7;
        return true;
    }

    public n(k r1) {
        this.a = r1;
    }
}
