package s05;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final Map<String, qz4.c> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static qz4.c a(Fragment r4) {
        if (r4 != null) goto L5;
        tt5.a.k("DComponent_DocComponentFragmentManager", "extractDocComponentHostId no fragment");
        String r5 = "";
    L6:
        qz4.c r1 = (qz4.c) ((ConcurrentHashMap) a).get(r5);
        if (r1 != null) goto L9;
        tt5.a.d("DComponent_DocComponentFragmentManager", "extractDocComponentHost no host:" + r5);
    L9:
        return r1;
    L5:
        r5 = b(r4.getArguments());
        goto L6
    }

    public static String b(Bundle r3) {
        if (r3 != null) goto L6;
        tt5.a.d("DComponent_DocComponentFragmentManager", "extractDocComponentHostId no args");
        return "";
    L6:
        String r4 = r3.getString("argDocComponentApiHostId");
        if (TextUtils.isEmpty(r4) == false) goto L10;
        tt5.a.d("DComponent_DocComponentFragmentManager", "extractDocComponentHostId no host id");
        return "";
    L10:
        return r4;
    }
}
