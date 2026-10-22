package com.ss.android.lark.contact.customized.search.view;

import android.view.View;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchViewLayoutBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeInviteExternalSearchFragment f419428a;

    public i(OfficeInviteExternalSearchFragment r100) {
        this.f419428a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ContactDbInviteSearchViewLayoutBinding r101 = this.f419428a.f419412d;
        ContactDbInviteSearchViewLayoutBinding r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r101 = null;
    L5:
        r101.f419078j.setText("");
        ContactDbInviteSearchViewLayoutBinding r103 = this.f419428a.f419412d;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L9:
        r102.f419077i.setVisibility(8);
        return;
    L8:
        r102 = r103;
        goto L9
    }
}
