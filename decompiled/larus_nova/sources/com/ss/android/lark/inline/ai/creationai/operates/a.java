package com.ss.android.lark.inline.ai.creationai.operates;

import android.view.View;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ButtonGroupsLinearLayout f427200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MenuItem f427201b;

    public a(ButtonGroupsLinearLayout r100, MenuItem r101) {
        this.f427200a = r100;
        this.f427201b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ButtonGroupsLinearLayout.b r101 = this.f427200a.f427185a;
        if (r101 == null) goto L6;
        r101.a(this.f427201b);
        return;
    }
}
