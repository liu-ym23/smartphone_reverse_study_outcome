package com.larus.bmhome.chat.trace;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f310242a = 0;

    static {
    }

    public static void a(String r100, String r101, wc9.e r102, by7.e r103) {
        Intrinsics.checkNotNullParameter(r100, "reeditType");
        by7.a r104 = new by7.a("click_re_edit");
        if (r101 == null) goto L5;
        r104.d("bot_id", r101);
    L5:
        String r105 = null;
        if (r102 == null) goto L8;
        String r106 = ic8.n.f(r102);
    L9:
        if (r106 == null) goto L11;
        r104.d("chat_type", r106);
    L11:
        r104.d("click_from", "answer");
        if (r102 == null) goto L14;
        r105 = r102.f559198a;
    L14:
        r104.d("conversation_id", r105);
        r104.d("edit_type", r100);
        if (r103 == null) goto L17;
        r104.f21464b = r103;
    L17:
        r104.b();
        return;
    L8:
        r106 = null;
        goto L9
    }
}
