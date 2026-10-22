package com.bytedance.ee.bear.share.newshare;

import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ ShareFolderFragment a;

    public o(ShareFolderFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ShareFolderInfo r3 = (ShareFolderInfo) r2;
        ShareFolderFragment r0 = this.a;
        r0.z = r3;
        Intrinsics.checkNotNull(r3);
        r0.Wa0(r3);
        this.a.Xa0(true);
        this.a.Ga0();
    }
}
