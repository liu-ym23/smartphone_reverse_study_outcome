package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes22.dex */
public final class j {

    public interface a {
    }

    public static void a(Activity r100, String r101, boolean r102, hj7.i.a r103) {
        if (r100 != null) goto L5;
    L24:
        r103.a(false);
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L24;
        String[] r104 = r101.split(",");
        if (r104.length == 2) goto L10;
    L22:
        r103.a(false);
        return;
    L10:
        if (r104[0].startsWith("data") == false) goto L22;
        if (r104[0].endsWith(TTVideoEngineInterface.PLAY_API_KEY_BASE64) == false) goto L22;
        if (Build.VERSION.SDK_INT < 29) goto L17;
        rj7.c.a(new i(r104[1], r100, r103, r102));
        return;
    L17:
        String[] r105 = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        com.bytedance.ug.sdk.luckycat.impl.manager.m r106 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        if (r106.l(r100, r105) == false) goto L20;
        rj7.c.a(new i(r104[1], r100, r103, r102));
        return;
    L20:
        r106.requestPermissions(r100, r105, new h());
    }
}
