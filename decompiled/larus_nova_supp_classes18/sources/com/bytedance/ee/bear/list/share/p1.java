package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p1 extends i3 implements i0 {
    @Override // com.bytedance.ee.bear.list.share.i3
    public final ArrayList<Document> M3(ArrayList<Document> r1) {
        return r1;
    }

    @Override // com.bytedance.ee.bear.list.share.i3, com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return "hidden_shared_folder";
    }

    @Override // com.bytedance.ee.bear.list.share.i0
    public final void a8(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.list.share.i3, com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "NewShareHiddenFolderView";
    }

    @Override // com.bytedance.ee.bear.list.share.i3, com.bytedance.ee.bear.list.list.c
    public final void B2() {
        super.B2();
        this.E.setTitle(this.b.getString(2131887923));
        this.I.setMainTitle(null);
        this.H.setVisibility(8);
    }

    public p1(Context r1, View r2, LifeCycleFragment r3, ce5.a r4) {
        super(r1, r2, r3, r4);
    }
}
