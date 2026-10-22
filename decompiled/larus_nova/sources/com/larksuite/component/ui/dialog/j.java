package com.larksuite.component.ui.dialog;

import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class j implements UDBaseDialogBuilder.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.a<LKUIDialog> f284138a;

    public j(d.a<LKUIDialog> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f284138a = r100;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
    public final void a(UDDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        this.f284138a.b((LKUIDialog) r100);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
    public final void beforeCreate(UDDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        this.f284138a.a((LKUIDialog) r100);
    }
}
