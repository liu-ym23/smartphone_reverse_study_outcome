package lx5;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class a implements b {
    public a() {
    }

    public static String getContentBaseType(String r2) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return XmlPullParser.NO_NAMESPACE;
    L4:
        if (StringUtils.isEmpty(r2) == true) goto L12;
        return new MimeType(r2).getBaseType();
    L12:
        return XmlPullParser.NO_NAMESPACE;
    }
}
