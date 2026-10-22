package com.bytedance.ee.bear.document.member;

import android.view.View;
import com.bytedance.ee.bear.docshost.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ MemberListData.MemberData a;

    public a(MemberListData.MemberData r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ((k) org.koin.java.a.c(k.class, null, null, 6)).e(this.a.getId(), null);
    }
}
