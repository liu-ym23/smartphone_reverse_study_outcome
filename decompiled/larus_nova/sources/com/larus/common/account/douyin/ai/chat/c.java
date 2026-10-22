package com.larus.common.account.douyin.ai.chat;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAiChatOpenDouyinAuthService.c f326043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f326044b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.f326043a.onResult(false);
        e.f326049c = null;
        FLogger.f375446a.i("AiChatDouyinAuthPreDialogHelper", "Douyin auth pre-asking dialog is cancelled");
        w0.b(this.f326044b.optString("enter_method"), this.f326044b.optString("content_type"), this.f326044b.optString("scene"), "later", this.f326044b.optString(MusicAppletPage.KEY_MESSAGE_ID), this.f326044b.optString("sec_enter_method"));
    }

    public c(IAiChatOpenDouyinAuthService.c r100, JSONObject r101) {
        this.f326043a = r100;
        this.f326044b = r101;
    }
}
