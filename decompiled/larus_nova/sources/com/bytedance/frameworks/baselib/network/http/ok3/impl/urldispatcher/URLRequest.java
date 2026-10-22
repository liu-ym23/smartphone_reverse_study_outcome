package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import com.bytedance.retrofit2.client.Header;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class URLRequest {
    private int mDispatchPriority;
    private final List<Header> mHeaders;
    private String mMethod;
    private String mOriginUrl;

    public int getDispatchPriority() {
        return this.mDispatchPriority;
    }

    public List<Header> getHeaders() {
        return this.mHeaders;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    public void setDispatchPriority(int r100) {
        this.mDispatchPriority = r100;
    }

    public void setMethod(String r100) {
        this.mMethod = r100;
    }

    public void setOriginUrl(String r100) {
        this.mOriginUrl = r100;
    }

    public URLRequest(String r100, String r101) {
        this.mOriginUrl = r100;
        this.mMethod = r101;
        this.mDispatchPriority = 0;
        this.mHeaders = null;
    }

    public URLRequest(String r100, String r101, List<Header> r102) {
        this.mOriginUrl = r100;
        this.mMethod = r101;
        this.mDispatchPriority = 0;
        this.mHeaders = r102;
    }
}
