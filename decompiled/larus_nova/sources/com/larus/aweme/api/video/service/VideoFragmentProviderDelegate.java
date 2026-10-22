package com.larus.aweme.api.video.service;

import androidx.fragment.app.Fragment;
import com.larus.home.impl.route.k;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096\u0001J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/larus/aweme/api/video/service/VideoFragmentProviderDelegate;", "Lcom/larus/aweme/api/video/service/IVideoFragmentProvider;", "<init>", "()V", "createAwemeDoublePostFragment", "Landroidx/fragment/app/Fragment;", "createDouYinBotWrapperFragment", "onBackFromChat", "Lkotlin/Function0;", "", "createDouYinFragment", "createVideoFragment", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoFragmentProviderDelegate implements IVideoFragmentProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final VideoFragmentProviderDelegate f294747b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IVideoFragmentProvider f294748a;

    static {
        f294747b = new VideoFragmentProviderDelegate();
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "onBackFromChat");
        return this.f294748a.a(r100);
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment b() {
        return this.f294748a.b();
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment c() {
        return this.f294748a.c();
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment d() {
        return this.f294748a.d();
    }

    private VideoFragmentProviderDelegate() {
        Object r100 = ServiceManager.get().getService(IVideoFragmentProvider.class);
        Intrinsics.checkNotNull(r100);
        this.f294748a = (IVideoFragmentProvider) r100;
    }
}
