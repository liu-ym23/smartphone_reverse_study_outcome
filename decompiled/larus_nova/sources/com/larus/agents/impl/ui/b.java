package com.larus.agents.impl.ui;

import android.content.DialogInterface;
import com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class b implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExpandedTaskBottomSheetFragment f286772a;

    public /* synthetic */ b(ExpandedTaskBottomSheetFragment r100) {
        this.f286772a = r100;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        ExpandedTaskBottomSheetFragment r101 = this.f286772a;
        int r102 = ExpandedTaskBottomSheetFragment.f286715e;
        ((PaneAwareBottomSheetController) r101.f286716d.getValue()).d();
    }
}
