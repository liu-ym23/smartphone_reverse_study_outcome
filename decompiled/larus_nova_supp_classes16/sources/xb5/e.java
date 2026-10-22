package xb5;

import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static String a(boolean r0, String r1, String r2) {
        if (r0 == false) goto L6;
        return UIHelper.mustacheFormat(2131890664, "permission", r2);
    L6:
        return r1 + " " + r2.toLowerCase();
    }
}
