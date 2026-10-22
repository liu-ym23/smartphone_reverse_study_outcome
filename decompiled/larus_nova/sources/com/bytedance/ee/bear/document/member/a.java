package com.bytedance.ee.bear.document.member;

import android.view.View;
import com.bytedance.ee.bear.docshost.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MemberListData.MemberData f220247a;

    public a(MemberListData.MemberData r100) {
        this.f220247a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((k) org.koin.java.a.c(k.class, null, null, 6)).e(this.f220247a.getId(), null);
    }
}
