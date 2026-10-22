package oo7;

import android.text.TextUtils;
import com.alibaba.gaiax.render.view.basic.GXImageView;

/* JADX INFO: loaded from: classes22.dex */
public final class g {
    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r100.startsWith(GXImageView.NET_HTTP_PREFIX) == false) goto L8;
    L11:
        return true;
    L8:
        if (r100.startsWith("ftp:") == true) goto L11;
        if (r100.startsWith(GXImageView.NET_HTTPS_PREFIX) == true) goto L11;
        return false;
    }
}
