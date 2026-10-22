package com.larus.avlink.api;

import androidx.fragment.app.Fragment;
import com.larus.platform.api.x0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u000e\u0010\n\u001a\u00020\u0005H\u0096A¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avlink/api/AlbumServiceDelegate;", "Lcom/larus/avlink/api/IAlbumService;", "<init>", "()V", "albumEnable", "", "albumFragment", "Landroidx/fragment/app/Fragment;", "getCurrentAlbumFragment", "Lcom/larus/platform/api/IMineAlbumFragment;", "hasCompletedMedia", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumServiceDelegate implements IAlbumService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AlbumServiceDelegate f291634b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAlbumService f291635a;

    static {
        f291634b = new AlbumServiceDelegate();
    }

    @Override // com.larus.avlink.api.IAlbumService
    public final Fragment a() {
        return this.f291635a.a();
    }

    @Override // com.larus.avlink.api.IAlbumService
    public final x0 b() {
        return this.f291635a.b();
    }

    @Override // com.larus.avlink.api.IAlbumService
    public final boolean c() {
        return this.f291635a.c();
    }

    @Override // com.larus.avlink.api.IAlbumService
    public final Object d(Continuation<? super Boolean> r100) {
        return this.f291635a.d(r100);
    }

    private AlbumServiceDelegate() {
        this.f291635a = (IAlbumService) ServiceManager.get().getService(IAlbumService.class);
    }
}
