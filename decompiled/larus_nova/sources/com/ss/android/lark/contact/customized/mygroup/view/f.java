package com.ss.android.lark.contact.customized.mygroup.view;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeMyJoinGroupFragment f419316a;

    public f(OfficeMyJoinGroupFragment r100) {
        this.f419316a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Context r101 = this.f419316a.getContext();
        if (r101 == null) goto L6;
        OfficeContactPageUtils.a(r101);
        return;
    }
}
