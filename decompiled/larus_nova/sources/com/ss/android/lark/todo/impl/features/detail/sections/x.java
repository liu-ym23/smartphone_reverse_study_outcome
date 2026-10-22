package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import com.ss.android.lark.widget.EllipsizeFrameLayout;

/* JADX INFO: loaded from: classes38.dex */
public final class x implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EllipsizeFrameLayout f443465a;

    public x(EllipsizeFrameLayout r100) {
        this.f443465a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f443465a.setEnableEllipsize(false);
    }
}
