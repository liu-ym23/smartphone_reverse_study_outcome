package com.ttnet.org.chromium.net.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class UrlResponseInfoImpl extends UrlResponseInfo {
    private final HeaderBlockImpl mHeaders;
    private final int mHttpStatusCode;
    private final String mHttpStatusText;
    private final String mNegotiatedProtocol;
    private final String mProxyServer;
    private final AtomicLong mReceivedByteCount;
    private final List<String> mResponseInfoUrlChain;
    private final boolean mWasCached;

    public static final class HeaderBlockImpl extends UrlResponseInfo.HeaderBlock {
        private final List<Map.Entry<String, String>> mAllHeadersList;
        private Map<String, List<String>> mHeadersMap;

        @Override // com.ttnet.org.chromium.net.UrlResponseInfo.HeaderBlock
        public Map<String, List<String>> getAsMap() {
            Map<String, List<String>> r100 = this.mHeadersMap;
            if (r100 == null) goto L5;
            return r100;
        L5:
            TreeMap r101 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator<Map.Entry<String, String>> r102 = this.mAllHeadersList.iterator();
        L7:
            if (r102.hasNext() == false) goto L12;
            Map.Entry<String, String> r103 = r102.next();
            ArrayList r104 = new ArrayList();
            if (r101.containsKey(r103.getKey()) == false) goto L11;
            r104.addAll((Collection) r101.get(r103.getKey()));
        L11:
            r104.add(r103.getValue());
            r101.put(r103.getKey(), Collections.unmodifiableList(r104));
            goto L7
        L12:
            Map<String, List<String>> r105 = Collections.unmodifiableMap(r101);
            this.mHeadersMap = r105;
            return r105;
        }

        @Override // com.ttnet.org.chromium.net.UrlResponseInfo.HeaderBlock
        public List<Map.Entry<String, String>> getAsList() {
            return this.mAllHeadersList;
        }

        public HeaderBlockImpl(List<Map.Entry<String, String>> r100) {
            this.mAllHeadersList = r100;
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public Map<String, List<String>> getAllHeaders() {
        return this.mHeaders.getAsMap();
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public List<Map.Entry<String, String>> getAllHeadersAsList() {
        return this.mHeaders.getAsList();
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public long getReceivedByteCount() {
        return this.mReceivedByteCount.get();
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public String getUrl() {
        List<String> r100 = this.mResponseInfoUrlChain;
        return (String) ListProtector.get(r100, r100.size() - 1);
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", new Object[]{Integer.toHexString(System.identityHashCode(this)), getUrl(), getUrlChain().toString(), Integer.valueOf(getHttpStatusCode()), getHttpStatusText(), getAllHeadersAsList().toString(), Boolean.valueOf(wasCached()), getNegotiatedProtocol(), getProxyServer(), Long.valueOf(getReceivedByteCount())});
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public String getHttpStatusText() {
        return this.mHttpStatusText;
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public String getNegotiatedProtocol() {
        return this.mNegotiatedProtocol;
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public String getProxyServer() {
        return this.mProxyServer;
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public List<String> getUrlChain() {
        return this.mResponseInfoUrlChain;
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public boolean wasCached() {
        return this.mWasCached;
    }

    public void setReceivedByteCount(long r100) {
        this.mReceivedByteCount.set(r100);
    }

    public UrlResponseInfoImpl(List<String> r110, int r111, String r112, List<Map.Entry<String, String>> r113, boolean r114, String r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, 0);
    }

    public UrlResponseInfoImpl(List<String> r100, int r101, String r102, List<Map.Entry<String, String>> r103, boolean r104, String r105, String r106, long r107) {
        this.mResponseInfoUrlChain = Collections.unmodifiableList(r100);
        this.mHttpStatusCode = r101;
        this.mHttpStatusText = r102;
        this.mHeaders = new HeaderBlockImpl(Collections.unmodifiableList(r103));
        this.mWasCached = r104;
        this.mNegotiatedProtocol = r105;
        this.mProxyServer = r106;
        this.mReceivedByteCount = new AtomicLong(r107);
    }
}
