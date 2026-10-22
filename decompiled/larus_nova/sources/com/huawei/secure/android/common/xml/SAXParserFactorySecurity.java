package com.huawei.secure.android.common.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* JADX INFO: loaded from: classes23.dex */
public class SAXParserFactorySecurity {
    public static SAXParserFactory getInstance() throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException, NullPointerException {
        SAXParserFactory r100 = SAXParserFactory.newInstance();
        r100.setFeature("http://xml.org/sax/features/namespaces", true);
        r100.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
        r100.setFeature("http://xml.org/sax/features/validation", false);
        r100.setFeature("http://xml.org/sax/features/external-general-entities", false);
        r100.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        r100.setFeature("http://xml.org/sax/features/string-interning", true);
        return r100;
    }

    public SAXParserFactorySecurity() {
    }
}
