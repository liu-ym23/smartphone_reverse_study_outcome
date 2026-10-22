package com.larus.bmhome.chat;

import com.larus.platform.kmp.chat.TemplateInfo$DefaultTab;

/* JADX INFO: loaded from: classes25.dex */
public final class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f302997a = 0;

    static {
    }

    public static int a(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L11:
        if (r100 != null) goto L14;
    L15:
        if (r100 == null) goto L24;
        if (r100.intValue() != 4) goto L24;
    L22:
        return TemplateInfo$DefaultTab.TEMPLATE.ordinal();
    L24:
        return TemplateInfo$DefaultTab.CHAT.ordinal();
    L14:
        if (r100.intValue() == 3) goto L22;
    L10:
        if (r100.intValue() == 2) goto L22;
    L5:
        if (r100.intValue() != 1) goto L7;
        return TemplateInfo$DefaultTab.CHAT.ordinal();
    }
}
