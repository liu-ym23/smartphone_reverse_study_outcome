package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n1 extends i3 implements i0 {
    public boolean P;

    @Override // com.bytedance.ee.bear.list.share.i3, com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return "shared_folder_v2";
    }

    @Override // com.bytedance.ee.bear.list.share.i3, com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "NewShareFolderView";
    }

    @Override // com.bytedance.ee.bear.list.share.i3, com.bytedance.ee.bear.list.list.c
    public final void B2() {
        super.B2();
        this.H.setVisibility(8);
        super.s3(true);
    }

    @Override // com.bytedance.ee.bear.list.share.i3
    public final String J3() {
        qc5.a.j();
        return "ccm_space_drive_page_click";
    }

    @Override // com.bytedance.ee.bear.list.share.i3
    public final ArrayList<Document> M3(ArrayList<Document> r2) {
        ArrayList<Document> r0 = new ArrayList(r2);
        if (this.A == false) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        r0.add(new ViewHiddenDocument());
    L10:
        return r0;
    L5:
        if (this.P == false) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void W3(int r2) {
        if (this.A == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        r2 = r2 + 1;
    L10:
        v3(r2);
        return;
    L5:
        if (this.P == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.share.i0
    public final void a8(boolean r1) {
        this.P = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.list.share.m1] */
    @Override // com.bytedance.ee.bear.list.list.c
    public final void s2(com.bytedance.ee.bear.list.list.d r2) {
        super.s2(r2);
        if ((r2 instanceof l0) == false) goto L6;
        ((l0) r2).n1(new m1());
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void s3(boolean r1) {
        super.s3(true);
    }

    public n1(Context r1, View r2, LifeCycleFragment r3, ce5.a r4) {
        super(r1, r2, r3, r4);
    }
}
