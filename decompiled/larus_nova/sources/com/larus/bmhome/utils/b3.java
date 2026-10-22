package com.larus.bmhome.utils;

import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class b3 implements com.larus.common_ui.dialog.u {
    public b3() {
    }

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        com.larus.platform.service.o r100 = com.larus.platform.service.o.f365780a;
        JSONObject r101 = new JSONObject();
        r101.put("click_type", 0);
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent("external_domain_jumper", r101);
    }
}
