package com.bytedance.sdk.open.aweme.core.net;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class OpenNetHeaders {
    public static final OpenNetHeaders empty = null;
    private List<Header> headers;

    public static class Builder {
        private List<Header> headers;

        public Builder() {
            this.headers = new ArrayList();
        }

        public Builder(OpenNetHeaders r100) {
            this.headers = OpenNetHeaders.access$200(r100);
        }

        public Builder addHeader(String r100, String r101) {
            this.headers.add(new Header(r100, r101));
            return this;
        }

        public Builder addHeader(Map<String, String> r100) {
            Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            Map.Entry<String, String> r102 = r101.next();
            addHeader(r102.getKey(), r102.getValue());
            goto L4
        L6:
            return this;
        }

        public Builder addHeaderIfNotNull(String r100, String r101) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
        L8:
            return this;
        L5:
            if (TextUtils.isEmpty(r101) == true) goto L8;
            this.headers.add(new Header(r100, r101));
            goto L8
        }

        public OpenNetHeaders build() {
            return new OpenNetHeaders(this.headers);
        }

        public List<String> getHeader(String r100) {
            ArrayList r101 = new ArrayList();
            Iterator<Header> r102 = this.headers.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Header r103 = r102.next();
            if (TextUtils.equals(r103.getName().toLowerCase(), r100.toLowerCase()) == false) goto L4;
            r101.add(Header.access$100(r103));
            goto L4
        L8:
            return r101;
        }

        public Builder removeHeader(String r100) {
            Iterator<Header> r101 = this.headers.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            if (TextUtils.equals(Header.access$000(r101.next()).toLowerCase(), r100.toLowerCase()) == false) goto L4;
            r101.remove();
            goto L4
        L8:
            return this;
        }

        public Builder replaceHeader(String r100, String r101) {
            removeHeader(r100);
            addHeader(r100, r101);
            return this;
        }

        public Builder setHeaders(List<Header> r100) {
            if (r100 != null) goto L4;
            return this;
        L4:
            this.headers.clear();
            this.headers.addAll(r100);
            return this;
        }

        public Builder setHeaders(Map<String, String> r100) {
            if (r100 != null) goto L4;
            return this;
        L4:
            this.headers.clear();
            Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
        L6:
            if (r101.hasNext() == false) goto L8;
            Map.Entry<String, String> r102 = r101.next();
            addHeader(r102.getKey(), r102.getValue());
            goto L6
        L8:
            return this;
        }

        public Builder setHeaders(JSONObject r100) {
            if (r100 != null) goto L4;
            return this;
        L4:
            this.headers.clear();
            Iterator<String> r101 = r100.keys();
        L6:
            if (r101.hasNext() == false) goto L8;
            String r102 = r101.next();
            String r103 = r100.optString(r102);
            this.headers.add(new Header(r102, r103));
            goto L6
        L8:
            return this;
        }
    }

    public static class Header {
        private String name;
        private String value;

        public Header(String r100, String r101) {
            this.name = r100;
            this.value = r101;
        }

        public static /* synthetic */ String access$000(Header r100) {
            return r100.name;
        }

        public static /* synthetic */ String access$100(Header r100) {
            return r100.value;
        }

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.value;
        }
    }

    static {
        empty = new Builder().build();
    }

    public OpenNetHeaders(List<Header> r100) {
        this.headers = r100;
    }

    public static /* synthetic */ List access$200(OpenNetHeaders r100) {
        return r100.headers;
    }

    public String firstHeaderString(String r100) {
        Iterator<Header> r101 = this.headers.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Header r102 = r101.next();
        if (TextUtils.equals(r102.getName().toLowerCase(), r100.toLowerCase()) == false) goto L4;
        return r102.getValue();
    L9:
        return null;
    }

    public long getContentLength() {
        return CastLongProtector.parseLong(firstHeaderString("Content-Length"));
    L4:
        return -1;
    }

    public List<String> getCookies() {
        ArrayList r100 = new ArrayList();
        Iterator<Header> r101 = this.headers.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Header r102 = r101.next();
        if (TextUtils.equals(r102.getName().toLowerCase(), "Cookies".toLowerCase()) == false) goto L4;
        r100.add(r102.getValue());
        goto L4
    L8:
        return r100;
    }

    public List<Header> getHeaderList() {
        return this.headers;
    }

    public String getHeaderString(String r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator<Header> r102 = this.headers.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Header r103 = r102.next();
        if (TextUtils.equals(r103.getName().toLowerCase(), r100.toLowerCase()) == false) goto L4;
        r101.append(r103.getValue());
        r101.append(",");
        goto L4
    L9:
        if (r101.length() <= 1) goto L12;
        r101.deleteCharAt(r101.length() - 1);
    L12:
        return r101.toString();
    }

    public String getLogId() {
        return firstHeaderString(NetResponse.HEADER_KEY_LOG_ID);
    }

    public boolean isExist(String r100) {
        Iterator<Header> r101 = this.headers.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (TextUtils.equals(r101.next().getName().toLowerCase(), r100.toLowerCase()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public int size() {
        return this.headers.size();
    }

    public JSONObject toJson(boolean r100) {
        JSONObject r101 = new JSONObject();
        Iterator<Header> r102 = this.headers.iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        Header r103 = r102.next();
        String r104 = Header.access$000(r103).toLowerCase(Locale.getDefault());     // Catch: Throwable -> L14
        String r105 = r101.optString(r104);     // Catch: Throwable -> L14
        if (r100 == true) goto L9;
    L11:
        String r106 = Header.access$100(r103);     // Catch: Throwable -> L14
    L12:
        r101.put(r104, r106);     // Catch: Throwable -> L14
        goto L4
    L9:
        if (TextUtils.isEmpty(r105) == true) goto L11;
        r106 = r105 + "," + Header.access$100(r103);     // Catch: Throwable -> L14
        goto L12
    L15:
        return r101;
    }

    public String toString() {
        return this.headers.toString();
    }
}
