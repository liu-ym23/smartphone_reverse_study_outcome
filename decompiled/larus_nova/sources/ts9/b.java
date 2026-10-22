package ts9;

import android.os.Bundle;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f547427a = 0;

    static {
    }

    public static String a(Bundle r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString("link_url");
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L17;
        if (r100 == null) goto L16;
        r101 = r100.getString("url");
    L16:
        return r101;
    L17:
        return r102;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
