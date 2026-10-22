package com.bytedance.ee.bear.share.externalshare.external;

import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FolderShareExternalPresenter f237055a;

    public e(FolderShareExternalPresenter r100) {
        this.f237055a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ShareFolderInfo r101 = (ShareFolderInfo) r100;
        FolderShareExternalPresenter r102 = this.f237055a;
        Intrinsics.checkNotNull(r101);
        r102.i(r101);
    }
}
