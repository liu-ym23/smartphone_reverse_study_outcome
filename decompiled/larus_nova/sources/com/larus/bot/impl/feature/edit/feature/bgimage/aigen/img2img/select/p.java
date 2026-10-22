package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

/* JADX INFO: loaded from: classes26.dex */
public final class p extends uu8.a {
    public final String d() {
        String r100 = this.f551780a.getString("description_status");
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        r100 = null;
    L11:
        return r100;
    L7:
        r101 = false;
        goto L8
    }

    public final String e() {
        String r100 = this.f551780a.getString("visual_style_status");
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        r100 = null;
    L11:
        return r100;
    L7:
        r101 = false;
        goto L8
    }

    public p() {
    }
}
