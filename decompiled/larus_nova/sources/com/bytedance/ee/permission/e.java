package com.bytedance.ee.permission;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T, R> f243043a = null;

    static {
        f243043a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ShareFolderUserPermission r101 = (ShareFolderUserPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Integer.valueOf(r101.getPermissions());
    }
}
