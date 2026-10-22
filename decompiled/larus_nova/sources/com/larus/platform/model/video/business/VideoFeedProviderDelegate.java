package com.larus.platform.model.video.business;

import com.larus.video.impl.douyin.DouYinVideoActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l48.a;
import org.json.JSONObject;
import pr9.g;
import pr9.h;
import qr9.b;
import qr9.c;
import zp9.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0001J\t\u0010 \u001a\u00020\u0005H\u0096\u0001J\u0011\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0096\u0001J\u0011\u0010'\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH\u0096\u0001¨\u0006("}, d2 = {"Lcom/larus/platform/model/video/business/VideoFeedProviderDelegate;", "Lcom/larus/platform/model/video/business/IVideoFeedProvider;", "<init>", "()V", "addGlobalPlayerListener", "", "listener", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomGlobalPlayerListener;", "addLoadMoreListener", "Lcom/larus/platform/model/video/sdkwrapper/feed/IGetAidsCallback;", "addSendEventListener", "Lcom/larus/platform/model/video/sdkwrapper/feed/ISendEventCallback;", "doSendEvent", "event", "", "params", "Lorg/json/JSONObject;", "getBmfBitmapHandler", "Lcom/larus/platform/api/creation/IBitmapHandler;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getBmfVideoSRHelper", "Lcom/larus/platform/api/creation/IBmfVideoSRHelper;", "getLoadMoreAids", "loadMoreTimes", "", "callback", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomILoadMoreCallback;", "getPreLoader", "Lcom/larus/platform/model/video/sdkwrapper/preload/IPreloadVideoProvider;", "getTopPlayerController", "Lcom/larus/platform/model/video/sdkwrapper/preload/ICustomPlayerController;", "init", "openFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IOperateFeedFragment;", "videoFeedConfigure", "Lcom/larus/platform/model/video/business/VideoFeedConfigure;", "removeGlobalPlayerListener", "removeLoadMoreListener", "removeSendEventListener", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoFeedProviderDelegate implements IVideoFeedProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final VideoFeedProviderDelegate f365695b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IVideoFeedProvider f365696a;

    static {
        f365695b = new VideoFeedProviderDelegate();
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f365696a.a(r100, r101);
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final c b() {
        return this.f365696a.b();
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final void c(DouYinVideoActivity.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f365696a.c(r100);
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final void d(int r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f365696a.d(r100, r101);
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final void e(g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f365696a.e(r100);
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final k f() {
        return this.f365696a.f();
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final void g(g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f365696a.g(r100);
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final b getTopPlayerController() {
        return this.f365696a.getTopPlayerController();
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final void h(DouYinVideoActivity.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f365696a.h(r100);
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final h i(VideoFeedConfigure r100) {
        Intrinsics.checkNotNullParameter(r100, "videoFeedConfigure");
        return this.f365696a.i(r100);
    }

    @Override // com.larus.platform.model.video.business.IVideoFeedProvider
    public final void init() {
        this.f365696a.init();
    }

    private VideoFeedProviderDelegate() {
        IVideoFeedProvider r100 = (IVideoFeedProvider) ServiceManager.get().getService(IVideoFeedProvider.class);
        if (r100 != null) goto L5;
        r100 = new VideoFeedProviderNoop();
    L5:
        this.f365696a = r100;
    }
}
