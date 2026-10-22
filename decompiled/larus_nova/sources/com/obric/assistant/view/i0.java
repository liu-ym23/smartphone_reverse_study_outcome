package com.obric.assistant.view;

import com.larus.common_ui.dialog.p0;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class i0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f394294a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        IObricUpdateService r100 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r100 == null) goto L5;
        JSONObject r101 = new JSONObject();
        r101.put("source", "stop_download");
        r101.put("popup_type", "stop_download");
        r101.put("action_type", "click_stop_download");
        Unit r102 = Unit.INSTANCE;
        r100.h("obric_upgrade_popup_click", r101);
    L5:
        Function0<Unit> r103 = this.f394294a;
        if (r103 == null) goto L9;
        r103.invoke();
        return;
    }

    public i0(f0 r100) {
        this.f394294a = r100;
    }
}
