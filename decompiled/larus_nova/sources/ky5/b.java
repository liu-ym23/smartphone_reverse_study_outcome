package ky5;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final List<String> b(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toStringList");
        ArrayList r101 = new ArrayList();
        if (r100.length() <= 0) goto L13;
        int r102 = r100.length();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        Object r104 = r100.get(r103);
        if ((r104 instanceof String) == true) goto L9;
        r104 = null;
    L9:
        String r105 = (String) r104;
        if (r105 == null) goto L12;
        r101.add(r105);
    L12:
        r103 = r103 + 1;
    L13:
        return r101;
    }

    public static final void a(a r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$extractOtherFields");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        r100.f506645j = r101.optString("compressed_download_url");
        r100.f506646k = r101.optString("micro_pkg_download_url");
        r100.f506647l = r101.optString("patch_download_url");
        JSONArray r102 = r101.optJSONArray("micro_pkg_backup_urls");
        List<String> r103 = null;
        if (r102 == null) goto L5;
        List<String> r104 = b(r102);
    L6:
        r100.f506650o = r104;
        JSONArray r105 = r101.optJSONArray("compressed_backup_urls");
        if (r105 == null) goto L9;
        List<String> r106 = b(r105);
    L10:
        r100.f506649n = r106;
        JSONArray r107 = r101.optJSONArray("patch_backup_urls");
        if (r107 == null) goto L13;
        r103 = b(r107);
    L13:
        r100.f506651p = r103;
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
