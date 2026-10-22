package com.larus.bmhome.bot;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements com.larus.bmhome.setting.b {
    public b() {
    }

    @Override // com.larus.bmhome.setting.b
    public final void d() {
        com.larus.platform.service.o.f365780a.b("click_change_language", com.larus.utils.f.c(new Pair[0]));
    }

    @Override // com.larus.bmhome.setting.b
    public final void e() {
        com.larus.platform.service.o.f365780a.b("cancel_edit_personality", com.larus.utils.f.c(new Pair[0]));
    }

    @Override // com.larus.bmhome.setting.b
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toLanguage");
        com.larus.platform.service.o.f365780a.b("change_language", com.larus.utils.f.c(new Pair[]{TuplesKt.to("to_language", r100)}));
    }

    @Override // com.larus.bmhome.setting.b
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "editMethod");
        com.larus.platform.service.o.f365780a.b("edit_personality", com.larus.utils.f.c(new Pair[]{TuplesKt.to("edit_method", r100)}));
    }

    @Override // com.larus.bmhome.setting.b
    public final void a(String r210, SpeakerVoice r211, String r212) {
        if (r211 != null) goto L4;
        return;
    L4:
        p2a.d.a.a(p2a.r.f527492b.a3(), r211, r210, true, null, r212, null, null, null, null, null, null, null, null, null, null, "change_language", null, null, null, null, null, 4128712);
    }

    @Override // com.larus.bmhome.setting.b
    public final void b(int r100, long r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "botId");
        Intrinsics.checkNotNullParameter(r103, "errTips");
        com.larus.platform.service.o.f365780a.b("setting_clear_context_result", com.larus.utils.f.c(new Pair[]{TuplesKt.to("success", Integer.valueOf(r100)), TuplesKt.to("err_code", Long.valueOf(r101)), TuplesKt.to("err_tips", r103), TuplesKt.to("bot_id", r102)}));
    }
}
