package com.larus.bmhome.chat.service.action;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class j implements com.larus.common_ui.dialog.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wc9.e f308772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wh8.a f308773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.chat.api.i f308774c;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        int r100 = com.larus.bmhome.chat.trace.i0.f310221a;
        int r101 = c.f308736a;
        wc9.e r102 = this.f308772a;
        wh8.a r103 = this.f308773b;
        com.larus.bmhome.chat.api.i r104 = this.f308774c;
        JSONObject r105 = c.c(r102, r103, r104.f297211d, r104.f297212e, r104.f297210c);
        by7.e r106 = this.f308774c.f297209b;
        Intrinsics.checkNotNullParameter(r105, "params");
        com.larus.bmhome.chat.trace.i0.a("cancel_edit_chat_name", r105, r106);
    }

    public j(wc9.e r100, wh8.a r101, com.larus.bmhome.chat.api.i r102) {
        this.f308772a = r100;
        this.f308773b = r101;
        this.f308774c = r102;
    }
}
