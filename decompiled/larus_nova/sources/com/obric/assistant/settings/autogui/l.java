package com.obric.assistant.settings.autogui;

import com.obric.assistant.spi.task.ObricTaskSkillDelegate;

/* JADX INFO: loaded from: classes33.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f391936a = 0;

    static {
    }

    public static k a() {
        com.obric.assistant.e r100 = com.obric.assistant.e.f389188a;
        String r101 = ObricTaskSkillDelegate.f392916b.i();
        r100.getClass();
        com.obric.assistant.e.a r102 = com.obric.assistant.e.a(r101);
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.f389190a;
    L6:
        String r105 = "";
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        if (r102 == null) goto L11;
        r103 = r102.f389191b;
    L11:
        if (r103 == null) goto L15;
        r105 = r103;
    L15:
        return new k(r104, r105);
    L5:
        r104 = null;
        goto L6
    }
}
