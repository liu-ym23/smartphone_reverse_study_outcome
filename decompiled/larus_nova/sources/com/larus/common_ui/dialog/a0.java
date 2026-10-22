package com.larus.common_ui.dialog;

import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class a0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonDialog f327291a;

    public /* synthetic */ a0(CommonDialog r100) {
        this.f327291a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        CommonDialog r100 = this.f327291a;
        int r101 = CommonDialog.N;
        r100.setStyle(0, R.style.Theme_OApp_CommonDialog);
        return Unit.INSTANCE;
    }
}
