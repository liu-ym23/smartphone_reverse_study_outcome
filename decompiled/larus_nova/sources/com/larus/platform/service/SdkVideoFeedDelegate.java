package com.larus.platform.service;

import androidx.fragment.app.FragmentManager;
import com.larus.platform.api.ISdkVideoFeedService;
import com.larus.platform.api.SdkVideoFeedServiceNoop;
import com.larus.platform.model.video.business.VideoFeedConfigure;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001J!\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/service/SdkVideoFeedDelegate;", "Lcom/larus/platform/api/ISdkVideoFeedService;", "<init>", "()V", "addGlobalPlayerListener", "", "listener", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomGlobalPlayerListener;", "getLoadMoreAids", "loadMoreTimes", "", "callback", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomILoadMoreCallback;", "getPreLoader", "Lcom/larus/platform/model/video/sdkwrapper/preload/IPreloadVideoProvider;", "getTopPlayerController", "Lcom/larus/platform/model/video/sdkwrapper/preload/ICustomPlayerController;", "init", "openFeedFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IOperateFeedFragment;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "pageConfig", "Lcom/larus/platform/model/video/business/VideoFeedConfigure;", "removeGlobalPlayerListener", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SdkVideoFeedDelegate implements ISdkVideoFeedService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SdkVideoFeedDelegate f365711b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ISdkVideoFeedService f365712a;

    static {
        f365711b = new SdkVideoFeedDelegate();
    }

    @Override // com.larus.platform.api.ISdkVideoFeedService
    public final qr9.c b() {
        return this.f365712a.b();
    }

    @Override // com.larus.platform.api.ISdkVideoFeedService
    public final pr9.h c(FragmentManager r100, VideoFeedConfigure r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter("", "tag");
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        return this.f365712a.c(r100, r101);
    }

    @Override // com.larus.platform.api.ISdkVideoFeedService
    public final qr9.b getTopPlayerController() {
        return this.f365712a.getTopPlayerController();
    }

    @Override // com.larus.platform.api.ISdkVideoFeedService
    public final void init() {
        this.f365712a.init();
    }

    private SdkVideoFeedDelegate() {
        ISdkVideoFeedService r100 = (ISdkVideoFeedService) ServiceManager.get().getService(ISdkVideoFeedService.class);
        if (r100 != null) goto L5;
        r100 = new SdkVideoFeedServiceNoop();
    L5:
        this.f365712a = r100;
    }
}
