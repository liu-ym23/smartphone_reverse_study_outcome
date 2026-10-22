package com.obric.assistant.view;

import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class j0 implements com.larus.common_ui.dialog.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f394300a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        IObricUpdateService r100 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r100 == null) goto L5;
        JSONObject r101 = new JSONObject();
        r101.put("source", "stop_download");
        r101.put("popup_type", "stop_download");
        r101.put("action_type", "click_background_download");
        Unit r102 = Unit.INSTANCE;
        r100.h("obric_upgrade_popup_click", r101);
    L5:
        Function0<Unit> r103 = this.f394300a;
        if (r103 == null) goto L9;
        r103.invoke();
        return;
    }

    public j0(g0 r100) {
        this.f394300a = r100;
    }
}
