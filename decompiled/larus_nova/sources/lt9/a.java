package lt9;

import android.content.Context;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f510713a = 0;

    static {
    }

    public static String a(Context r100) {
        StringBuilder r101 = new StringBuilder("&#160;<a href=\"pp\">");
        if (r100 == null) goto L5;
        String r102 = r100.getString(R.string.larus_privacy_model_desc_learnMore);
    L6:
        r101.append(r102);
        r101.append("</a>");
        return r101.toString();
    L5:
        r102 = null;
        goto L6
    }
}
