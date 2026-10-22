package com.huawei.secure.android.common.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/* JADX INFO: loaded from: classes23.dex */
public class DocumentBuilderFactorySecurity {
    public static DocumentBuilderFactory getInstance() throws ParserConfigurationException, NullPointerException {
        DocumentBuilderFactory r100 = DocumentBuilderFactory.newInstance();
        r100.setFeature("http://xml.org/sax/features/namespaces", true);
        r100.setFeature("http://xml.org/sax/features/validation", false);
        r100.setExpandEntityReferences(false);
        return r100;
    }

    public DocumentBuilderFactorySecurity() {
    }
}
