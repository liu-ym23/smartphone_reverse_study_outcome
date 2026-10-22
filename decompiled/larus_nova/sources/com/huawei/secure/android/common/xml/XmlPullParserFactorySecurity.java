package com.huawei.secure.android.common.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes23.dex */
public class XmlPullParserFactorySecurity {
    public static XmlPullParserFactory getInstance() throws XmlPullParserException {
        XmlPullParserFactory r100 = XmlPullParserFactory.newInstance();
        r100.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
        r100.setFeature(XmlPullParser.FEATURE_REPORT_NAMESPACE_ATTRIBUTES, false);
        r100.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, false);
        r100.setFeature(XmlPullParser.FEATURE_VALIDATION, false);
        return r100;
    }

    public XmlPullParserFactorySecurity() {
    }
}
