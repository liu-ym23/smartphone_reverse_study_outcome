package com.bytedance.apm.impl;

import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements TypedOutput {
    public final TypedFile a;
    public final Map<String, String> b;

    public final String fileName() {
        StringBuilder r0 = new StringBuilder(this.a.fileName());
        r0.append("\"");
        Iterator<Map.Entry<String, String>> r2 = this.b.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<String, String> r3 = r2.next();
        String r4 = r3.getKey();
        String r5 = r3.getValue();
        r0.append("; ");
        r0.append(r4);
        r0.append("=\"");
        r0.append(r5);
        r0.append("\"");
        goto L4
    L6:
        r0.deleteCharAt(r0.length() - 1);
        return r0.toString();
    }

    public final long length() {
        return this.a.length();
    }

    public final String md5Stub() {
        return this.a.md5Stub();
    }

    public final String mimeType() {
        return this.a.mimeType();
    }

    public final void writeTo(OutputStream r2) throws IOException {
        this.a.writeTo(r2);
    }

    public b(Map<String, String> r1, TypedFile r2) {
        this.b = r1;
        this.a = r2;
    }
}
