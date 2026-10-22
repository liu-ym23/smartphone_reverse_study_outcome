package com.bytedance.locallife.live.dsl;

import android.graphics.Typeface;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.bytedance.locallife.live.util.FontUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements GXRegisterCenterApi.GXIExtensionFontFamily {
    public d() {
    }

    @Override // com.alibaba.gaiax.api.GXRegisterCenterApi.GXIExtensionFontFamily
    public final Typeface fontFamily(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fontFamilyName");
        switch(r100.hashCode()) {
            case -1461481587: goto L22;
            case -1273197556: goto L18;
            case -983957665: goto L14;
            case -981614931: goto L10;
            case -253872891: goto L6;
            default: goto L26;
        };
    L6:
        if (r100.equals("DouyinNumber-Medium") == false) goto L26;
        Typeface r101 = FontUtil.f260647a;
        return FontUtil.f260647a;
    L10:
        if (r100.equals("DouyinNumberABC-Bold") == false) goto L26;
        Typeface r102 = FontUtil.f260647a;
        return FontUtil.f260648b;
    L14:
        if (r100.equals("Douyin Sans") == false) goto L26;
        Typeface r103 = FontUtil.f260647a;
        return (Typeface) FontUtil.f260650d.getValue();
    L18:
        if (r100.equals("PingFangSC-Medium") == false) goto L26;
        return Typeface.create("sans-serif-medium", 0);
    L22:
        if (r100.equals("DouyinNumberABC-ExtraBold") == false) goto L26;
        Typeface r104 = FontUtil.f260647a;
        return FontUtil.f260649c;
    L26:
        return Typeface.create(r100, 0);
    }
}
