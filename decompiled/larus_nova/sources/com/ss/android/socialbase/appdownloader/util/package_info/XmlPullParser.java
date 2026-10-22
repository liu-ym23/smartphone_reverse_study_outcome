package com.ss.android.socialbase.appdownloader.util.package_info;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public interface XmlPullParser {
    public static final int END_DOCUMENT = 1;
    public static final int START_TAG = 2;
    public static final String[] TYPES = null;

    int getAttributeCount();

    String getAttributeName(int r100);

    String getAttributeValue(int r100);

    int getColumnNumber();

    int getEventType() throws XmlPullParserException;

    int getLineNumber();

    String getName();

    String getNamespace();

    String getPositionDescription();

    String getText();

    boolean isWhitespace() throws XmlPullParserException;

    int next() throws XmlPullParserException, IOException;

    static {
        TYPES = new String[]{"START_DOCUMENT", "END_DOCUMENT", "START_TAG", "END_TAG", CardAdapter.TEXT, "CDSECT", "ENTITY_REF", "IGNORABLE_WHITESPACE", "PROCESSING_INSTRUCTION", "COMMENT", "DOCDECL"};
    }
}
