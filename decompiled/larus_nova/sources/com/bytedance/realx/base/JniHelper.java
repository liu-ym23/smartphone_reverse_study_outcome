package com.bytedance.realx.base;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
class JniHelper {
    public JniHelper() {
    }

    public static Object getStringClass() {
        return String.class;
    }

    public static Object getKey(Map.Entry r100) {
        return r100.getKey();
    }

    public static byte[] getStringBytes(String r100) {
        return r100.getBytes(XML.CHARSET_UTF8);
    L5:
        throw new RuntimeException("utf-8 is unsupported");
    }

    public static Object getValue(Map.Entry r100) {
        return r100.getValue();
    }
}
