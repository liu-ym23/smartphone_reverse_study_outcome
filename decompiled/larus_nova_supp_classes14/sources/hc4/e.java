package hc4;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static void a(Context r3, String r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty("turing_live_detect_cfg") == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r4) == false) goto L15;
        return;
    L15:
        SharedPreferences.Editor r5 = r3.getSharedPreferences("turing_live_detect_cfg", 0).edit();     // Catch: Exception -> L12
        r5.putString(r4, CommentScene.COMMENTSCENE_NO_AWEME);     // Catch: Exception -> L12
        r5.commit();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }
}
