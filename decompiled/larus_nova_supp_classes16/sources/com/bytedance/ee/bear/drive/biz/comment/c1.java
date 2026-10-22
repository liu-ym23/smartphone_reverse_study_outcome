package com.bytedance.ee.bear.drive.biz.comment;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c1 implements com.bytedance.ee.bear.middleground.comment.export.v {
    public final /* synthetic */ u55.b a;
    public final /* synthetic */ a1 b;

    public final boolean a() {
        IDocUserPermission r0 = this.a.b.a;
        if (this.b.F.isTypeWiki() == false) goto L13;
        if (r0.isFullAccess() == false) goto L7;
    L10:
        return true;
    L7:
        if (r0.isSinglePageFullAccess() == true) goto L10;
        return false;
    L13:
        return r0.isFullAccess();
    }

    public final boolean canEdit() {
        return this.a.b.a.canEdit();
    }

    public final boolean isOwner() {
        return this.a.k();
    }

    public c1(a1 r1, u55.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
