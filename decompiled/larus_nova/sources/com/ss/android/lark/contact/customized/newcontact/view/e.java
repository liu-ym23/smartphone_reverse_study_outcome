package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeNewContactAdapter f419374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NewContactView.a f419375b;

    public e(OfficeNewContactAdapter r100, NewContactView.a r101) {
        this.f419374a = r100;
        this.f419375b = r101;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        OfficeNewContactAdapter.a r101 = this.f419374a.f419356b;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        r101.a(r100, this.f419375b);
        return true;
    L7:
        return true;
    }
}
