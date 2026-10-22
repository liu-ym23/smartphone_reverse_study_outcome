package com.bytedance.awemeopen.apps.framework.card.video;

import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/card/video/VideoCardPlayerViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper;", "feedPlayerHelper", "Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper;", "getFeedPlayerHelper", "()Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper;", "", "isReusedPlayer", "Z", "()Z", "Lcom/bytedance/awemeopen/infra/base/player/g;", "player", "<init>", "(Lcom/bytedance/awemeopen/infra/base/player/g;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class VideoCardPlayerViewModel extends AosViewModel {
    private final FeedPlayerHelper feedPlayerHelper;
    private final boolean isReusedPlayer;

    public VideoCardPlayerViewModel() {
        com.bytedance.awemeopen.infra.base.player.g r0 = null;
        this(r0, 1, r0);
    }

    public final FeedPlayerHelper getFeedPlayerHelper() {
        return this.feedPlayerHelper;
    }

    public final boolean isReusedPlayer() {
        return this.isReusedPlayer;
    }

    public VideoCardPlayerViewModel(com.bytedance.awemeopen.infra.base.player.g r2) {
        this.feedPlayerHelper = new FeedPlayerHelper(r2);
        if (r2 == null) goto L5;
        boolean r3 = true;
    L6:
        this.isReusedPlayer = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public /* synthetic */ VideoCardPlayerViewModel(com.bytedance.awemeopen.infra.base.player.g r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
