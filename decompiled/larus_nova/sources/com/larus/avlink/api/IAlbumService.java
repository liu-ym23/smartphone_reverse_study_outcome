package com.larus.avlink.api;

import androidx.fragment.app.Fragment;
import com.larus.platform.api.x0;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u000e\u0010\b\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/api/IAlbumService;", "", "albumFragment", "Landroidx/fragment/app/Fragment;", "albumEnable", "", "getCurrentAlbumFragment", "Lcom/larus/platform/api/IMineAlbumFragment;", "hasCompletedMedia", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAlbumService {
    Fragment a();

    x0 b();

    boolean c();

    Object d(Continuation<? super Boolean> r100);
}
