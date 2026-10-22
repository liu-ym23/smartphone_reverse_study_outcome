package com.huawei.secure.android.common.xml;

import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes23.dex */
public class XmlNewPullParserSecurity {
    public static XmlPullParser getInstance() throws XmlPullParserException {
        XmlPullParser r100 = Xml.newPullParser();
        r100.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, false);
        r100.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        return r100;
    }

    public XmlNewPullParserSecurity() {
    }
}
