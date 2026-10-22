package com.larus.office.base.plugins.toolbar.submenu;

import com.larus.office.base.plugins.toolbar.model.Item;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements DocSubToolbarAdapter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsSubToolbarFragment f360968a;

    public a(AbsSubToolbarFragment r100) {
        this.f360968a = r100;
    }

    @Override // com.larus.office.base.plugins.toolbar.submenu.DocSubToolbarAdapter.b
    public final void a(Item r100, boolean r101) {
        Intrinsics.checkNotNull(r100);     // Catch: Exception -> L4
        JSONObject r102 = new JSONObject(r100.getValue());     // Catch: Exception -> L4
        r102.put("openPanel", r101);     // Catch: Exception -> L4
        this.f360968a.Y90(r100, r102.toString());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        FLogger.f375446a.e("SDKSubToolbarFragment", e.getMessage());
    }
}
