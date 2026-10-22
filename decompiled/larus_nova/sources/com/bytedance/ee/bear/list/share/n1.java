package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
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
    public final ArrayList<Document> M3(ArrayList<Document> r100) {
        ArrayList<Document> r101 = new ArrayList(r100);
        if (this.A == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        r101.add(new ViewHiddenDocument());
    L10:
        return r101;
    L5:
        if (this.P == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void W3(int r100) {
        if (this.A == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        r100 = r100 + 1;
    L10:
        v3(r100);
        return;
    L5:
        if (this.P == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.share.i0
    public final void a8(boolean r100) {
        this.P = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.list.share.m1] */
    @Override // com.bytedance.ee.bear.list.list.c
    public final void s2(com.bytedance.ee.bear.list.list.d r100) {
        super.s2(r100);
        if ((r100 instanceof l0) == false) goto L6;
        ((l0) r100).n1(new m1());
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void s3(boolean r100) {
        super.s3(true);
    }

    public n1(Context r100, View r101, LifeCycleFragment r102, ce5.a r103) {
        super(r100, r101, r102, r103);
    }
}
