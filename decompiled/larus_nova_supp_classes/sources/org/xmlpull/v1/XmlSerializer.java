package org.xmlpull.v1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface XmlSerializer {
    XmlSerializer attribute(String r1, String r2, String r3) throws IOException, IllegalArgumentException, IllegalStateException;

    void endDocument() throws IOException, IllegalArgumentException, IllegalStateException;

    XmlSerializer endTag(String r1, String r2) throws IOException, IllegalArgumentException, IllegalStateException;

    void flush() throws IOException;

    void setFeature(String r1, boolean r2) throws IllegalArgumentException, IllegalStateException;

    void setOutput(OutputStream r1, String r2) throws IOException, IllegalArgumentException, IllegalStateException;

    void setOutput(Writer r1) throws IOException, IllegalArgumentException, IllegalStateException;

    void setPrefix(String r1, String r2) throws IOException, IllegalArgumentException, IllegalStateException;

    void startDocument(String r1, Boolean r2) throws IOException, IllegalArgumentException, IllegalStateException;

    XmlSerializer startTag(String r1, String r2) throws IOException, IllegalArgumentException, IllegalStateException;

    XmlSerializer text(String r1) throws IOException, IllegalArgumentException, IllegalStateException;
}
