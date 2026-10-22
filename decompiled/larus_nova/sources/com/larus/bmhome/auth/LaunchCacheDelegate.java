package com.larus.bmhome.auth;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/auth/LaunchCacheDelegate;", "Lcom/larus/bmhome/auth/ILaunchCacheService;", "<init>", "()V", "getColdStartTtsType", "", "lastCachedConversationInfo", "Lcom/larus/im/bean/conversation/Conversation;", "getLastCachedConversationInfo", "()Lcom/larus/im/bean/conversation/Conversation;", "lastCachedLaunchInfo", "Lcom/larus/bmhome/auth/LaunchInfo;", "getLastCachedLaunchInfo", "()Lcom/larus/bmhome/auth/LaunchInfo;", "lastTouristModeInfo", "Lcom/larus/bmhome/auth/TouristModeInfo;", "getLastTouristModeInfo", "()Lcom/larus/bmhome/auth/TouristModeInfo;", "originCachedLaunchInfo", "getOriginCachedLaunchInfo", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchCacheDelegate implements ILaunchCacheService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LaunchCacheDelegate f295726b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILaunchCacheService f295727a;

    static {
        f295726b = new LaunchCacheDelegate();
    }

    @Override // com.larus.bmhome.auth.ILaunchCacheService
    public final int a() {
        return this.f295727a.a();
    }

    @Override // com.larus.bmhome.auth.ILaunchCacheService
    public final wc9.e b() {
        return this.f295727a.b();
    }

    @Override // com.larus.bmhome.auth.ILaunchCacheService
    public final LaunchInfo c() {
        return this.f295727a.c();
    }

    @Override // com.larus.bmhome.auth.ILaunchCacheService
    public final LaunchInfo d() {
        return this.f295727a.d();
    }

    @Override // com.larus.bmhome.auth.ILaunchCacheService
    public final i1 e() {
        return this.f295727a.e();
    }

    private LaunchCacheDelegate() {
        ILaunchCacheService r100 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r100 != null) goto L5;
        r100 = new LaunchCacheServiceNoop();
    L5:
        this.f295727a = r100;
    }
}
