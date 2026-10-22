package com.larus.office.plugins.alert;

import androidx.fragment.app.DialogFragment;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common_ui.dialog.p0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import tb5.m;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertPlugin f362334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f362335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<AlertModel.ButtonsBean> f362336c;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DialogFragment r100 = AlertPlugin.access$getDialog$p(this.f362334a);
        if (r100 != null) goto L18;
    L10:
        m r101 = this.f362335b;
        if (r101 == null) goto L20;
        JSONObject r102 = new JSONObject();
        AlertModel.ButtonsBean r103 = (AlertModel.ButtonsBean) ListProtector.get(this.f362336c, 1);
        if (r103 == null) goto L15;
        String r104 = r103.getId();
    L16:
        r102.put2("id", r104);
        r101.b(r102);
        return;
    L15:
        r104 = null;
        goto L16
    L20:
        return;
    L18:
        r100.dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L10;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public b(AlertPlugin r100, m r101, List<AlertModel.ButtonsBean> r102) {
        this.f362334a = r100;
        this.f362335b = r101;
        this.f362336c = r102;
    }
}
