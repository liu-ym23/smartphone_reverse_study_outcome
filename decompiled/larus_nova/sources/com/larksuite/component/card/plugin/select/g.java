package com.larksuite.component.card.plugin.select;

import android.view.Window;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g implements UDBaseDialogBuilder.c {
    public g() {
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
    public final void a(UDDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
    public final void beforeCreate(UDDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Window r101 = r100.getWindow();
        if (r101 == null) goto L6;
        r101.addFlags(512);
        return;
    }
}
