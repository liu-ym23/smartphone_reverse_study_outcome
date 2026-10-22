package com.bytedance.ee.bear.bitable.homepage.activity;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableMessageFragment f212314a;

    public g(BitableMessageFragment r100) {
        this.f212314a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Context r101 = this.f212314a.getContext();
        if (r101 == null) goto L6;
        UDToast.show(r101, R.string.Bitable_Workspace_Activities_Tooltip);
        return;
    }
}
