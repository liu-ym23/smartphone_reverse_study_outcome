package com.obric.assistant.interaction.impl.window.helpers;

import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;

/* JADX INFO: loaded from: classes33.dex */
public class BottomSheetDialogLancet {
    public BottomSheetDialogLancet() {
    }

    public void onStart() {
        Object r100 = This.get();
        Origin.callVoid();
        DialogLancet.handleDialogPreAddViewOnStart(r100, "bottomSheetDialog:onStart");
    }
}
