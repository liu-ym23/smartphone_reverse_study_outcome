package com.larus.bmhome.instruction.handler;

import com.larus.bmhome.chat.ChatParam;

/* JADX INFO: loaded from: classes26.dex */
public final class v implements zs8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f312131a;

    @Override // zs8.a
    public final String Y1() {
        return null;
    }

    @Override // zs8.a
    public final String a() {
        return null;
    }

    @Override // zs8.a
    public final String b() {
        return "chat";
    }

    @Override // zs8.a
    public final String c() {
        return null;
    }

    @Override // zs8.a
    public final String d() {
        return null;
    }

    @Override // zs8.a
    public final String e() {
        return null;
    }

    @Override // zs8.a
    public final String f() {
        return null;
    }

    @Override // zs8.a
    public final String g() {
        return null;
    }

    @Override // zs8.a
    public final String getClickFrom() {
        return "ai_generate_feed_image";
    }

    @Override // zs8.a
    public final String getTemplateType() {
        return null;
    }

    @Override // zs8.a
    public final String h() {
        return null;
    }

    @Override // zs8.a
    public final String i() {
        return null;
    }

    @Override // zs8.a
    public final String j() {
        return null;
    }

    @Override // zs8.a
    public final String k() {
        return null;
    }

    @Override // zs8.a
    public final boolean l() {
        return false;
    }

    @Override // zs8.a
    public final String m() {
        return null;
    }

    @Override // zs8.a
    public final String n() {
        return null;
    }

    @Override // zs8.a
    public final String o() {
        return null;
    }

    @Override // zs8.a
    public final String p() {
        return null;
    }

    @Override // zs8.a
    public final String getBotId() {
        ChatParam r100 = (ChatParam) this.f312131a.e().a(ChatParam.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f296890b;
    }

    @Override // zs8.a
    public final String getChatType() {
        ChatParam r100 = (ChatParam) this.f312131a.e().a(ChatParam.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f296893e;
    }

    @Override // zs8.a
    public final String getEnterMethod() {
        com.larus.bmhome.instruction.n r100 = this.f312131a.f312135m;
        if (r100 == null) goto L8;
        aq8.e r101 = r100.f312184b;
        if (r101 == null) goto L8;
        String r102 = r101.f15946g;
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    public v(w r100) {
        this.f312131a = r100;
    }
}
