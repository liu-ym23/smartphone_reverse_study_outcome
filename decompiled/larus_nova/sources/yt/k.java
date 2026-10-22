package yt;

import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k {
    static {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        JsonElement r101 = GsonHelper.a.f57436d.parse(r100);     // Catch: Exception -> L14
        if (r101 == null) goto L6;
        JsonObject r102 = r101.getAsJsonObject();     // Catch: Exception -> L14
    L7:
        if (r102 == null) goto L10;
        int r103 = r102.size();     // Catch: Exception -> L14
    L11:
        if (r103 <= 0) goto L17;
        return true;
    L17:
        return false;
    L10:
        r103 = 0;
        goto L11
    L6:
        r102 = null;
    L18:
        return false;
    }
}
