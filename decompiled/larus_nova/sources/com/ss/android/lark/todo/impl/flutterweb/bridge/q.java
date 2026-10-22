package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.ss.android.lark.chameleon.Callback;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class q implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callback f444203a;

    public q(Callback r100) {
        this.f444203a = r100;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        this.f444203a.success(MapsKt.mapOf(TuplesKt.to("selectedIndex", Integer.valueOf(r100))));
    }
}
