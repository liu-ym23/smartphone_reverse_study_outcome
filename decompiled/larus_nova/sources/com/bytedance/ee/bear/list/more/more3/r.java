package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpaceFolderMoreProvider.b f228794a;

    public r(SpaceFolderMoreProvider.b r100) {
        this.f228794a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IDocUserPermission r101 = (IDocUserPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "shortcutPermission");
        tt5.a.h("SpaceFolderMoreProvider", "shortcutUserPermissionFlow ok");
        oj5.b r102 = this.f228794a.c();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r101, "shortcutPermission");
        r102.f523576u = r101;
    L5:
        SpaceFolderMoreProvider.b r103 = this.f228794a;
        r103.e(r103.c());
    }
}
