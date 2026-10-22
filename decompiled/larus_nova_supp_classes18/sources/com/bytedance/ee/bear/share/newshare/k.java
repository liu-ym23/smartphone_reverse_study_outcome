package com.bytedance.ee.bear.share.newshare;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T, R> implements Function {
    public final /* synthetic */ ShareFolderFragment a;

    public k(ShareFolderFragment r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        ShareFolderPermission r4 = (ShareFolderPermission) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        ShareFolderFragment r0 = this.a;
        int r1 = ShareFolderFragment.C;
        return r0.Ua0(r4);
    }
}
