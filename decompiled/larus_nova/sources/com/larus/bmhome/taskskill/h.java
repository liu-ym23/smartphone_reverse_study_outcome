package com.larus.bmhome.taskskill;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f314297a = 0;

    static {
    }

    public static bs8.h a(wc9.e r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f559198a;
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        bs8.a.C0354a r103 = bs8.a.f20295h;
        if (r100 == null) goto L11;
        r101 = r100.f559215r;
    L11:
        r103.getClass();
        bs8.a r104 = bs8.a.C0354a.a(r101);
        if (r104 == null) goto L16;
        boolean r105 = true;
        if (r104.c() != true) goto L16;
    L17:
        if (r105 == false) goto L20;
        FLogger.f375446a.i("PcLocalConversationGate", "[getState] pc local hit, conversationId=" + r102 + ", runtimeType=" + r104.f20298c);
    L20:
        return new bs8.h(r102, r104);
    L16:
        r105 = false;
        goto L17
    L5:
        r102 = null;
        goto L6
    }
}
