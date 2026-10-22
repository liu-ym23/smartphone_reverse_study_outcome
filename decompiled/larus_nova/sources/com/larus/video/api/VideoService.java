package com.larus.video.api;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.r2;
import com.larus.platform.api.z3;
import k2a.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/larus/video/api/VideoService;", "Lcom/larus/video/api/IVideoApi;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/video/api/IVideoApi;", "impl$delegate", "Lkotlin/Lazy;", "getNewInstance", "Lcom/larus/platform/api/IVideoController;", "tag", "", "enableUseSR", "", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/platform/api/IVideoController;", "clearAllCaches", "", "getAllCacheSize", "", "getExpiredCacheSize", "expireBeforeMs", "clearExpiredCaches", "getISdkHolderHandler", "Lcom/larus/platform/api/ISdkHolderHanlder;", "getAudioPlayController", "Lcom/larus/platform/api/IAudioPlayController;", "isDouyinVideoActivityInStack", "getTTVideoEngineStaticService", "Lcom/larus/platform/api/ITTVideoEngineStaticService;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoService implements IVideoApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VideoService f375656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f375657b = null;

    private VideoService() {
    }

    static {
        f375656a = new VideoService();
        f375657b = LazyKt.lazy(new a());
    }

    public static IVideoApi h() {
        return (IVideoApi) f375657b.getValue();
    }

    @Override // com.larus.video.api.IVideoApi
    public final z3 c() {
        IVideoApi r100 = h();
        if (r100 == null) goto L5;
        z3 r101 = r100.c();
    L6:
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.video.api.IVideoApi
    public final long d() {
        IVideoApi r100 = h();
        if (r100 == null) goto L7;
        return r100.d();
    L7:
        throw new IllegalArgumentException("IVideoApi service is unavailable".toString());
    }

    @Override // com.larus.video.api.IVideoApi
    public final void e() {
        IVideoApi r100 = h();
        if (r100 == null) goto L7;
        r100.e();
        return;
    L7:
        throw new IllegalArgumentException("IVideoApi service is unavailable".toString());
    }

    @Override // com.larus.video.api.IVideoApi
    public final r2 g() {
        IVideoApi r100 = h();
        if (r100 == null) goto L5;
        r2 r101 = r100.g();
    L6:
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.video.api.IVideoApi
    public final long a(long r100) {
        IVideoApi r101 = h();
        if (r101 == null) goto L7;
        return r101.a(r100);
    L7:
        throw new IllegalArgumentException("IVideoApi service is unavailable".toString());
    }

    @Override // com.larus.video.api.IVideoApi
    public final long b(long r100) {
        IVideoApi r101 = h();
        if (r101 == null) goto L7;
        return r101.b(r100);
    L7:
        throw new IllegalArgumentException("IVideoApi service is unavailable".toString());
    }

    @Override // com.larus.video.api.IVideoApi
    public final IVideoController f(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        IVideoApi r102 = h();
        if (r102 == null) goto L5;
        IVideoController r103 = IVideoApi.a.a(r102, r100);
    L6:
        Intrinsics.checkNotNull(r103);
        return r103;
    L5:
        r103 = null;
        goto L6
    }
}
