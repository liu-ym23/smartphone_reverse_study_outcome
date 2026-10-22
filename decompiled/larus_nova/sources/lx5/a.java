package lx5;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements b {
    public a() {
    }

    public static String getContentBaseType(String r100) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (StringUtils.isEmpty(r100) == true) goto L12;
        return new MimeType(r100).getBaseType();
    L12:
        return "";
    }
}
