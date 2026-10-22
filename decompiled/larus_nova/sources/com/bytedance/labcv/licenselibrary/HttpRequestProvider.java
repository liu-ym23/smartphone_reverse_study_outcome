package com.bytedance.labcv.licenselibrary;

import java.util.HashMap;

/* JADX INFO: loaded from: classes19.dex */
public interface HttpRequestProvider {

    public static class RequestInfo {
        public int bodySize;
        public String bodydata;
        public HashMap<String, String> requestHead;
        public String url;
        public long userdata;

        public RequestInfo() {
            this.url = "";
            this.requestHead = new HashMap();
            this.bodydata = "";
            this.bodySize = 0;
            this.userdata = 0;
        }
    }

    public static class ResponseInfo {
        public int bodySize;
        public String bodydata;
        public boolean isSuc;
        public HashMap<String, String> responseHead;
        public int status_code;
        public long userdata;

        public ResponseInfo() {
            this.isSuc = false;
            this.status_code = 0;
            this.responseHead = new HashMap();
            this.bodydata = "";
            this.bodySize = 0;
            this.userdata = 0;
        }
    }

    ResponseInfo getRequest(RequestInfo r100);

    ResponseInfo postRequest(RequestInfo r100);
}
