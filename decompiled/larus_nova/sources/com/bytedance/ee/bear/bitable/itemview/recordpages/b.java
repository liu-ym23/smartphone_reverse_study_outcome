package com.bytedance.ee.bear.bitable.itemview.recordpages;

import androidx.lifecycle.Observer;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterChild1 f214196a;

    public b(ItemViewRecordFooterChild1 r100) {
        this.f214196a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        this.f214196a.getBinding().f210888c.setText(this.f214196a.getContext().getString(R.string.Bitable_Comment_AddCmt_Placeholder_Mob));
        return;
    L5:
        this.f214196a.getBinding().f210888c.setText(this.f214196a.getContext().getString(R.string.Bitable_Comment_NoPermToCmt_Desc));
    }
}
