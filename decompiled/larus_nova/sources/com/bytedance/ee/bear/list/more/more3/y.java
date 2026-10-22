package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ V1SpaceFolderMoreProvider.b f228802a;

    public y(V1SpaceFolderMoreProvider.b r100) {
        this.f228802a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IDocUserPermission r101 = (IDocUserPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "shortcutPermission");
        tt5.a.h("V1SpaceFolderMoreProvider", "shortcutUserPermissionFlow ok");
        oj5.b r102 = this.f228802a.c();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r101, "shortcutPermission");
        r102.f523576u = r101;
    L5:
        V1SpaceFolderMoreProvider.b r103 = this.f228802a;
        r103.e(r103.c());
    }
}
