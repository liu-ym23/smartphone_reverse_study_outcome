package com.bytedance.locallife.poi.settings;

import com.ss.android.ugc.aweme.poi.settings.PoiSetting;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    static {
    }

    public static boolean a() {
        PoiSetting r100 = IPoiSetting.a();
        if (r100 == null) goto L5;
        int r101 = r100.i();
    L7:
        if ((r101 & 8) == 0) goto L10;
        return true;
    L10:
        return false;
    L5:
        r101 = 0;
        goto L7
    }
}
