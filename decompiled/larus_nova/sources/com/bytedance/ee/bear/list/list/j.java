package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.b f228605a;

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final boolean t0() {
        return this.f228605a.t0();
    }

    public j(d.b r100) {
        this.f228605a = r100;
    }

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final void P(View r100, int r101, Document r102) {
        if (r102.f227871b2 == false) goto L6;
        Context r103 = r100.getContext();
        Toast.showText(r103, r103.getString(R.string.CreationDoc_Docs_KeyInvalidCanNotOperate), 0);
        return;
    L6:
        this.f228605a.P(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final void B0(View r100, int r101, Document r102, boolean r103) {
        if (r102.f227871b2 == false) goto L6;
        Context r104 = r100.getContext();
        Toast.showText(r104, r104.getString(R.string.CreationDoc_Docs_KeyInvalidCanNotOperate), 0);
        return;
    L6:
        this.f228605a.B0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r100, int r101, Document r102, boolean r103) {
        if (r102.f227871b2 == false) goto L6;
        Context r104 = r100.getContext();
        Toast.showText(r104, r104.getString(R.string.CreationDoc_Docs_KeyInvalidCanNotOperate), 0);
        return;
    L6:
        this.f228605a.Y(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r100, int r101, Document r102, boolean r103) {
        if (r102.f227871b2 == false) goto L6;
        Context r104 = r100.getContext();
        Toast.showText(r104, r104.getString(R.string.CreationDoc_Docs_KeyInvalidCanNotOperate), 0);
        return;
    L6:
        this.f228605a.x0(r100, r101, r102, r103);
    }
}
