package org.xmlpull.v1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public interface XmlSerializer {
    XmlSerializer attribute(String r100, String r101, String r102) throws IOException, IllegalArgumentException, IllegalStateException;

    void endDocument() throws IOException, IllegalArgumentException, IllegalStateException;

    XmlSerializer endTag(String r100, String r101) throws IOException, IllegalArgumentException, IllegalStateException;

    void flush() throws IOException;

    void setFeature(String r100, boolean r101) throws IllegalArgumentException, IllegalStateException;

    void setOutput(OutputStream r100, String r101) throws IOException, IllegalArgumentException, IllegalStateException;

    void setOutput(Writer r100) throws IOException, IllegalArgumentException, IllegalStateException;

    void setPrefix(String r100, String r101) throws IOException, IllegalArgumentException, IllegalStateException;

    void startDocument(String r100, Boolean r101) throws IOException, IllegalArgumentException, IllegalStateException;

    XmlSerializer startTag(String r100, String r101) throws IOException, IllegalArgumentException, IllegalStateException;

    XmlSerializer text(String r100) throws IOException, IllegalArgumentException, IllegalStateException;
}
