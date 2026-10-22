package com.larus.drive.sdk.impl.utils;

import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements mbb.d {
    public d() {
    }

    @Override // mbb.d
    public final Integer a(int r100, Long r101) {
        int r102 = f.f342018a;
        if (r100 != 8) goto L6;
        int r103 = R.drawable.ud_icon_logo_gradient_base_colorful;
    L33:
        return Integer.valueOf(r103);
    L6:
        if (r100 != 113) goto L13;
        if (r101 == null) goto L13;
        if (r101.longValue() != 147) goto L13;
        r103 = R.drawable.ud_icon_file_website_v2_colorful;
    L13:
        if (r100 != 2) goto L15;
    L30:
        CommonFileIconType r104 = CommonFileIconType.AI_DOC;
    L31:
        h19.b.f483542a.getClass();
        r103 = h19.b.a(r104);
        goto L33
    L15:
        if (r100 != 3) goto L17;
        r104 = CommonFileIconType.AI_SHEET;
        goto L31
    L17:
        if (r100 != 11) goto L19;
        r104 = CommonFileIconType.MINDNOTE;
        goto L31
    L19:
        if (r100 == 22) goto L30;
        if (r100 == 30) goto L27;
        if (r100 != 113) goto L24;
    L26:
        r104 = CommonFileIconType.MIAODA;
        goto L31
    L24:
        if (r100 == 114) goto L26;
        r104 = CommonFileIconType.UNKNOWN;
        goto L31
    L27:
        r104 = CommonFileIconType.AI_SLIDES;
        goto L31
    }
}
