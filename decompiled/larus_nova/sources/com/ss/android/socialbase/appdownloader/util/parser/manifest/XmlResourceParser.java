package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes38.dex */
public interface XmlResourceParser extends XmlPullParser, AttributeSet {
    void close();

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ void defineEntityReplacementText(String r100, String r101) throws XmlPullParserException;

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    /* synthetic */ int getAttributeCount();

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    /* synthetic */ String getAttributeName(int r100);

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getAttributeNamespace(int r100);

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getAttributePrefix(int r100);

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getAttributeType(int r100);

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    /* synthetic */ String getAttributeValue(int r100);

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    /* synthetic */ String getAttributeValue(String r100, String r101);

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ int getColumnNumber();

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ int getDepth();

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ int getEventType() throws XmlPullParserException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ boolean getFeature(String r100);

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getInputEncoding();

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ int getLineNumber();

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getName();

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getNamespace();

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getNamespace(String r100);

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ int getNamespaceCount(int r100) throws XmlPullParserException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getNamespacePrefix(int r100) throws XmlPullParserException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getNamespaceUri(int r100) throws XmlPullParserException;

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    /* synthetic */ String getPositionDescription();

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getPrefix();

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ Object getProperty(String r100);

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String getText();

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ char[] getTextCharacters(int[] r100);

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ boolean isAttributeDefault(int r100);

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ boolean isEmptyElementTag() throws XmlPullParserException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ boolean isWhitespace() throws XmlPullParserException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ int next() throws XmlPullParserException, IOException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ int nextTag() throws XmlPullParserException, IOException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ String nextText() throws XmlPullParserException, IOException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ int nextToken() throws XmlPullParserException, IOException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ void require(int r100, String r101, String r102) throws XmlPullParserException, IOException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ void setFeature(String r100, boolean r101) throws XmlPullParserException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ void setInput(InputStream r100, String r101) throws XmlPullParserException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ void setInput(Reader r100) throws XmlPullParserException;

    @Override // org.xmlpull.v1.XmlPullParser
    /* synthetic */ void setProperty(String r100, Object r101) throws XmlPullParserException;
}
