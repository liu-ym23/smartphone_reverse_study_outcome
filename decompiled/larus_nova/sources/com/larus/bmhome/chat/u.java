package com.larus.bmhome.chat;

import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;

/* JADX INFO: loaded from: classes25.dex */
public final class u implements zs8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f310300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TemplateInfo$TemplateInfo f310301b;

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
    public final String getChatType() {
        return "other_default";
    }

    @Override // zs8.a
    public final String getClickFrom() {
        return "use_template";
    }

    @Override // zs8.a
    public final String getEnterMethod() {
        return "use_template";
    }

    @Override // zs8.a
    public final String h() {
        return "action_bar_template";
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
    public final String d() {
        UserCreation r100 = this.f310301b.f365425j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return zp9.d.c(r100);
    }

    @Override // zs8.a
    public final String getTemplateType() {
        UserCreation r100 = this.f310301b.f365425j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return zp9.d.d(r100);
    }

    @Override // zs8.a
    public final String getBotId() {
        return this.f310300a;
    }

    public u(String r100, TemplateInfo$TemplateInfo r101) {
        this.f310300a = r100;
        this.f310301b = r101;
    }
}
