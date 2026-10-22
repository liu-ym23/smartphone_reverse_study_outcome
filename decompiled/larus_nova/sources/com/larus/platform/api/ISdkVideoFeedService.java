package com.larus.platform.api;

import androidx.fragment.app.FragmentManager;
import com.larus.platform.model.video.business.VideoFeedConfigure;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\rH&¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/api/ISdkVideoFeedService;", "", "openFeedFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IOperateFeedFragment;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "pageConfig", "Lcom/larus/platform/model/video/business/VideoFeedConfigure;", "getPreLoader", "Lcom/larus/platform/model/video/sdkwrapper/preload/IPreloadVideoProvider;", "getLoadMoreAids", "", "loadMoreTimes", "", "callback", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomILoadMoreCallback;", "getTopPlayerController", "Lcom/larus/platform/model/video/sdkwrapper/preload/ICustomPlayerController;", "addGlobalPlayerListener", "listener", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomGlobalPlayerListener;", "removeGlobalPlayerListener", "init", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISdkVideoFeedService {
    qr9.c b();

    pr9.h c(FragmentManager r100, VideoFeedConfigure r101);

    qr9.b getTopPlayerController();

    void init();
}
