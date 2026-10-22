package com.larus.drive.sdk.impl.utils;

import com.larus.common_ui.icon.CommonFileIconType;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements mbb.e {
    public e() {
    }

    @Override // mbb.e
    public final Integer a(int r100) {
        int r101 = f.f342018a;
        if (r100 != 2) goto L5;
    L24:
        CommonFileIconType r102 = CommonFileIconType.AI_DOC;
    L25:
        h19.b.f483542a.getClass();
        return h19.b.b(r102);
    L5:
        if (r100 != 3) goto L7;
        r102 = CommonFileIconType.AI_SHEET;
        goto L25
    L7:
        if (r100 != 8) goto L9;
        r102 = CommonFileIconType.BITABLE;
        goto L25
    L9:
        if (r100 != 11) goto L11;
        r102 = CommonFileIconType.MINDNOTE;
        goto L25
    L11:
        if (r100 == 22) goto L24;
        if (r100 != 30) goto L15;
        r102 = CommonFileIconType.AI_SLIDES;
        goto L25
    L15:
        if (r100 != 113) goto L17;
    L19:
        r102 = CommonFileIconType.MIAODA;
        goto L25
    L17:
        if (r100 == 114) goto L19;
        return null;
    }
}
