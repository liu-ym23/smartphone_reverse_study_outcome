package com.bytedance.android.livesdk.livecommerce.playback.multicards;

import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements ml.b {
    public final /* synthetic */ ExplainPlaybackMultiCardsPresenter a;

    public final String c() {
        com.bytedance.android.livesdk.livecommerce.playback.main.b r0 = this.a.e0().getExplainPlaybackOriginParams();
        if (r0 == null) goto L8;
        ExplainPlaybackRequest r1 = r0.a;
        if (r1 == null) goto L8;
        String r2 = r1.getAuthorId();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public final String d() {
        com.bytedance.android.livesdk.livecommerce.playback.main.b r0 = this.a.e0().getExplainPlaybackOriginParams();
        if (r0 == null) goto L8;
        ExplainPlaybackRequest r1 = r0.a;
        if (r1 == null) goto L8;
        String r2 = r1.getSecAuthorId();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public final String roomId() {
        com.bytedance.android.livesdk.livecommerce.playback.main.b r0 = this.a.e0().getExplainPlaybackOriginParams();
        if (r0 == null) goto L8;
        ExplainPlaybackRequest r1 = r0.a;
        if (r1 == null) goto L8;
        String r2 = r1.getRoomId();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public a(ExplainPlaybackMultiCardsPresenter r1) {
        this.a = r1;
    }
}
