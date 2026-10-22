package com.bytedance.ee.bear.more.protocol3.checker;

import android.view.View;
import com.bytedance.ee.bear.more.protocol3.j;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends j {
    @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.a
    public final View.OnClickListener a() {
        return null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final int c() {
        return R.string.Doc_List_OperateFailedNoNet;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        return com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
    }

    public d() {
    }
}
