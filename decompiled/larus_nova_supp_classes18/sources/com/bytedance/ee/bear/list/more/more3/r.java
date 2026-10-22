package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ SpaceFolderMoreProvider.b a;

    public r(SpaceFolderMoreProvider.b r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        IDocUserPermission r5 = (IDocUserPermission) r4;
        Intrinsics.checkNotNullParameter(r5, "shortcutPermission");
        tt5.a.h("SpaceFolderMoreProvider", "shortcutUserPermissionFlow ok");
        oj5.b r1 = this.a.c();
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r5, "shortcutPermission");
        r1.u = r5;
    L5:
        SpaceFolderMoreProvider.b r6 = this.a;
        r6.e(r6.c());
    }
}
