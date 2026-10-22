package com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository;

import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.livereplay.repository.NetState;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    void onInvalidated();

    void selectFirstCard(ECUIPromotion r1, ExplainPlaybackVideoInfo r2, ECReplayVideo r3, List<ExplainReplaySubTitle> r4);

    void setNetworkState(NetState r1);
}
