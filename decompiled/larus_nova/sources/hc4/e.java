package hc4;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes14.dex */
public final class e {
    public static void a(Context r100, String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty("turing_live_detect_cfg") == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L15;
        return;
    L15:
        SharedPreferences.Editor r102 = r100.getSharedPreferences("turing_live_detect_cfg", 0).edit();     // Catch: Exception -> L12
        r102.putString(r101, "1");     // Catch: Exception -> L12
        r102.commit();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }
}
