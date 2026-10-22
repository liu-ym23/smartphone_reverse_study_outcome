package com.larus.common.account.douyin.ai.chat;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common_ui.dialog.p0;
import com.larus.utils.logger.FLogger;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAiChatOpenDouyinAuthService.c f326045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f326046b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.f326045a.onResult(true);
        e.f326049c = null;
        w0.b(this.f326046b.optString("enter_method"), this.f326046b.optString("content_type"), this.f326046b.optString("scene"), "auth", this.f326046b.optString(MusicAppletPage.KEY_MESSAGE_ID), this.f326046b.optString("sec_enter_method"));
        FLogger.f375446a.i("AiChatDouyinAuthPreDialogHelper", "Douyin auth pre-asking dialog is confirmed");
    }

    public d(IAiChatOpenDouyinAuthService.c r100, JSONObject r101) {
        this.f326045a = r100;
        this.f326046b = r101;
    }
}
