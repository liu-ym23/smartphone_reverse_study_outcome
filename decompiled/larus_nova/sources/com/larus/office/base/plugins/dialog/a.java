package com.larus.office.base.plugins.dialog;

import androidx.fragment.app.DialogFragment;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common_ui.dialog.u;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import tb5.m;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertPluginV2 f360742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f360743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<AlertModel.ButtonsBean> f360744c;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        DialogFragment r100 = AlertPluginV2.access$getDialog$p(this.f360742a);
        if (r100 != null) goto L18;
    L10:
        m r101 = this.f360743b;
        if (r101 == null) goto L20;
        JSONObject r102 = new JSONObject();
        AlertModel.ButtonsBean r103 = (AlertModel.ButtonsBean) ListProtector.get(this.f360744c, 0);
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

    public a(AlertPluginV2 r100, m r101, List<AlertModel.ButtonsBean> r102) {
        this.f360742a = r100;
        this.f360743b = r101;
        this.f360744c = r102;
    }
}
