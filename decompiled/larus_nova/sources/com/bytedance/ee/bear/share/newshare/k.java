package com.bytedance.ee.bear.share.newshare;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareFolderFragment f237232a;

    public k(ShareFolderFragment r100) {
        this.f237232a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ShareFolderPermission r101 = (ShareFolderPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        ShareFolderFragment r102 = this.f237232a;
        int r103 = ShareFolderFragment.C;
        return r102.Ua0(r101);
    }
}
