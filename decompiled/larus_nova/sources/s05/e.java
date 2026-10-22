package s05;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, qz4.c> f540020a = null;

    static {
        f540020a = new ConcurrentHashMap();
    }

    public static qz4.c a(Fragment r100) {
        if (r100 != null) goto L5;
        tt5.a.k("DComponent_DocComponentFragmentManager", "extractDocComponentHostId no fragment");
        String r101 = "";
    L6:
        qz4.c r102 = (qz4.c) ((ConcurrentHashMap) f540020a).get(r101);
        if (r102 != null) goto L9;
        tt5.a.d("DComponent_DocComponentFragmentManager", "extractDocComponentHost no host:" + r101);
    L9:
        return r102;
    L5:
        r101 = b(r100.getArguments());
        goto L6
    }

    public static String b(Bundle r100) {
        if (r100 != null) goto L6;
        tt5.a.d("DComponent_DocComponentFragmentManager", "extractDocComponentHostId no args");
        return "";
    L6:
        String r101 = r100.getString("argDocComponentApiHostId");
        if (TextUtils.isEmpty(r101) == false) goto L10;
        tt5.a.d("DComponent_DocComponentFragmentManager", "extractDocComponentHostId no host id");
        return "";
    L10:
        return r101;
    }
}
