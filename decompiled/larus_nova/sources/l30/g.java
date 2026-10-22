package l30;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f507222a = 0;

    static {
    }

    public static void a(Map r100, String r101, String r102) {
        HashMap r103 = (HashMap) r100;
        if (r103.containsKey(r101) == true) goto L5;
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r103.put(r101, r102);
        return;
    L5:
        if (TextUtils.isEmpty((CharSequence) r103.get(r101)) == true) goto L6;
    }
}
