package xb5;

import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes16.dex */
public final class e {
    public static String a(boolean r100, String r101, String r102) {
        if (r100 == false) goto L6;
        return UIHelper.mustacheFormat(R.string.Lark_Docs_ChatDocPermSetText, "permission", r102);
    L6:
        return r101 + " " + r102.toLowerCase();
    }
}
