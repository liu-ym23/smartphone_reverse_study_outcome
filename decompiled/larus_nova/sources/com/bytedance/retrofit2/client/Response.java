package com.bytedance.retrofit2.client;

import com.bytedance.retrofit2.mime.TypedInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Response {
    private final TypedInput body;
    private Object extraInfo;
    private final List<Header> headers;
    private String message;
    private final String reason;
    private final int status;
    private String traceCode;
    private final String url;

    public boolean isSuccessful() {
        int r100 = this.status;
        if (r100 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 300) goto L7;
        return true;
    }

    public TypedInput getBody() {
        return this.body;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getReason() {
        return this.reason;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTraceCode() {
        return this.traceCode;
    }

    public String getUrl() {
        return this.url;
    }

    public String message() {
        return this.message;
    }

    public Header getFirstHeader(String r100) {
        if (r100 == null) goto L13;
        List<Header> r101 = this.headers;
        if (r101 == null) goto L13;
        Iterator<Header> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Header r103 = r102.next();
        if (r100.equalsIgnoreCase(r103.getName()) == false) goto L9;
        return r103;
    L13:
        return null;
    }

    public List<Header> headers(String r100) {
        ArrayList r101 = null;
        if (r100 == null) goto L15;
        List<Header> r102 = this.headers;
        if (r102 == null) goto L15;
        Iterator<Header> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L15;
        Header r104 = r103.next();
        if (r100.equalsIgnoreCase(r104.getName()) == false) goto L9;
        if (r101 != null) goto L14;
        r101 = new ArrayList();
    L14:
        r101.add(r104);
    L15:
        return r101;
    }

    public void setExtraInfo(Object r100) {
        this.extraInfo = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setTraceCode(String r100) {
        this.traceCode = r100;
    }

    public Response(String r100, int r101, String r102, List<Header> r103, TypedInput r104) {
        if (r100 == null) goto L17;
        if (r101 < 200) goto L15;
        if (r102 == null) goto L13;
        if (r103 == null) goto L11;
        this.url = r100;
        this.status = r101;
        this.reason = r102;
        this.headers = Collections.unmodifiableList(new ArrayList(r103));
        this.body = r104;
        return;
    L11:
        throw new IllegalArgumentException("headers == null");
    L13:
        throw new IllegalArgumentException("reason == null");
    L15:
        throw new IllegalArgumentException("Invalid status code: " + r101);
    L17:
        throw new IllegalArgumentException("url == null");
    }
}
