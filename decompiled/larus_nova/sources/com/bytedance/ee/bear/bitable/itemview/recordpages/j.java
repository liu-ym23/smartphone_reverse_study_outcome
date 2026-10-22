package com.bytedance.ee.bear.bitable.itemview.recordpages;

import androidx.lifecycle.Observer;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterChild4 f214207a;

    public j(ItemViewRecordFooterChild4 r100) {
        this.f214207a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        this.f214207a.getBinding().f210907e.setText(this.f214207a.getContext().getString(R.string.Bitable_Comment_AddCmt_Placeholder_Mob));
        return;
    L5:
        this.f214207a.getBinding().f210907e.setText(this.f214207a.getContext().getString(R.string.Bitable_Comment_NoPermToCmt_Desc));
    }
}
