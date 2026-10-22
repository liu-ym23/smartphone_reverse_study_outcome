package com.bytedance.ee.bear.share.externalshare.external;

import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ FolderShareExternalPresenter a;

    public e(FolderShareExternalPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ShareFolderInfo r3 = (ShareFolderInfo) r2;
        FolderShareExternalPresenter r0 = this.a;
        Intrinsics.checkNotNull(r3);
        r0.i(r3);
    }
}
