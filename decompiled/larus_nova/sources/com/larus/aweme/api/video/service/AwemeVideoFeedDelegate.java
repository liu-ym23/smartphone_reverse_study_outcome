package com.larus.aweme.api.video.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000bH\u0097\u0001J\t\u0010\u000e\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/larus/aweme/api/video/service/AwemeVideoFeedDelegate;", "Lcom/larus/aweme/api/video/service/IAwemeVideoFeedService;", "<init>", "()V", "getPushEntranceType", "", "()Ljava/lang/Integer;", "getSceneId", "", "getSearchSceneId", "isEnableDouYinSdk", "", "isEnableDouyinFeedBotEntrance", "isEnableDouyinFeedBottomTabEntrance", "isEnableDouyinFeedCocoEntrance", "updateDataCache", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeVideoFeedDelegate implements IAwemeVideoFeedService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AwemeVideoFeedDelegate f294745b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAwemeVideoFeedService f294746a;

    static {
        f294745b = new AwemeVideoFeedDelegate();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final String a() {
        return this.f294746a.a();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final boolean b() {
        return this.f294746a.b();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final void c() {
        this.f294746a.c();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final boolean d() {
        return this.f294746a.d();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final boolean e() {
        return this.f294746a.e();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    @Deprecated(message = "tab style not use user/launch to config, use tabbar/config api", replaceWith = @ReplaceWith(expression = "BottomTabConfigManager", imports = {}))
    public final boolean f() {
        return this.f294746a.f();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final String getSceneId() {
        return this.f294746a.getSceneId();
    }

    private AwemeVideoFeedDelegate() {
        Object r100 = ServiceManager.get().getService(IAwemeVideoFeedService.class);
        Intrinsics.checkNotNull(r100);
        this.f294746a = (IAwemeVideoFeedService) r100;
    }
}
