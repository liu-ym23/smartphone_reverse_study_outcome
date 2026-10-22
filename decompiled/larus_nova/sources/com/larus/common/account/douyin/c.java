package com.larus.common.account.douyin;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import n38.q;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f326057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IAiChatOpenDouyinAuthService.b f326058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f326059c;

    public c(JSONObject r100, a r101, JSONObject r102) {
        this.f326057a = r100;
        this.f326058b = r101;
        this.f326059c = r102;
    }

    @Override // n38.q
    public final void a(boolean r110, Integer r111, String r112, String r210, String r211, String r212) {
        if (this.f326057a == null) goto L29;
        JSONObject r100 = this.f326059c;
        String r101 = null;
        if (r100 == null) goto L7;
        String r102 = r100.optString("scene");
    L8:
        if (r100 == null) goto L10;
        String r103 = r100.optString("page_type");
    L11:
        if (r100 == null) goto L13;
        String r104 = r100.optString("enter_method");
    L14:
        if (r100 == null) goto L16;
        String r105 = r100.optString(MusicAppletPage.KEY_MESSAGE_ID);
    L17:
        if (r100 == null) goto L19;
        String r113 = r100.optString("sec_enter_method");
    L20:
        if (r100 == null) goto L22;
        String r114 = r100.optString("action");
    L23:
        if (r100 == null) goto L25;
        String r115 = r100.optString("bot_id");
    L26:
        if (r100 == null) goto L28;
        r101 = r100.optString("authorize_scopes");
    L28:
        w0.d(r102, r103, r104, r110 ? 1 : 0, r212, r105, r113, r101, r115, r114, null, 3072);
        goto L29
    L25:
        r115 = null;
        goto L26
    L22:
        r114 = null;
        goto L23
    L19:
        r113 = null;
        goto L20
    L16:
        r105 = null;
        goto L17
    L13:
        r104 = null;
        goto L14
    L10:
        r103 = null;
        goto L11
    L7:
        r102 = null;
    L29:
        IAiChatOpenDouyinAuthService.b r106 = this.f326058b;
        if (r106 == null) goto L33;
        r106.a(r110, r111);
        return;
    }
}
