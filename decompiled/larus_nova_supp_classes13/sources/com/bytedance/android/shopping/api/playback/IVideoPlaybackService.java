package com.bytedance.android.shopping.api.playback;

import android.content.Context;
import da3.a;
import da3.b;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&Jh\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u000bH&J,\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\bH&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/api/playback/IVideoPlaybackService;", "", "Landroid/content/Context;", "context", "Lda3/a;", "getAuthorInfoView", "Ljava/io/Serializable;", "aweme", "", "productId", "promotionId", "", "openAsActivity", "enterFrom", "enterMethod", "entranceInfo", "v3EventsAdditions", "activityWillFinish", "", "showAnchorV3Page", "fromSearch", "shareSearchPlayerId", "awemeId", "Lda3/b;", "getPlaybackAwemeVideoView", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVideoPlaybackService {
    a getAuthorInfoView(Context r1);

    b getPlaybackAwemeVideoView(boolean r1, String r2, String r3);

    void showAnchorV3Page(Context r1, Serializable r2, String r3, String r4, boolean r5, String r6, String r7, String r8, String r9, boolean r10);
}
