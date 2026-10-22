package com.larus.platform.api;

import androidx.fragment.app.FragmentManager;
import com.larus.platform.model.video.business.VideoFeedConfigure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/api/SdkVideoFeedServiceNoop;", "Lcom/larus/platform/api/ISdkVideoFeedService;", "<init>", "()V", "openFeedFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IOperateFeedFragment;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "pageConfig", "Lcom/larus/platform/model/video/business/VideoFeedConfigure;", "getPreLoader", "Lcom/larus/platform/model/video/sdkwrapper/preload/IPreloadVideoProvider;", "getLoadMoreAids", "", "loadMoreTimes", "", "callback", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomILoadMoreCallback;", "getTopPlayerController", "Lcom/larus/platform/model/video/sdkwrapper/preload/ICustomPlayerController;", "addGlobalPlayerListener", "listener", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomGlobalPlayerListener;", "removeGlobalPlayerListener", "init", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SdkVideoFeedServiceNoop implements ISdkVideoFeedService {
    public SdkVideoFeedServiceNoop() {
    }

    @Override // com.larus.platform.api.ISdkVideoFeedService
    public final qr9.b getTopPlayerController() {
        return null;
    }

    @Override // com.larus.platform.api.ISdkVideoFeedService
    public final void init() {
    }

    @Override // com.larus.platform.api.ISdkVideoFeedService
    public final qr9.c b() {
        return new qr9.a();
    }

    @Override // com.larus.platform.api.ISdkVideoFeedService
    public final pr9.h c(FragmentManager r100, VideoFeedConfigure r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter("", "tag");
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        return new or9.b();
    }
}
