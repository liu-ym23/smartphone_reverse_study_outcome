package com.bytedance.sdk.open.aweme.core.net;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class OpenHostRequest {
    public static final long DEFAULT_TIMEOUT = 60000;
    private boolean addHostCommonParams;
    private String clientKey;
    private long connectTimeOut;
    private OpenNetHeaders headers;
    private String method;
    private long readTimeOut;
    private OpenRequestBody requestBody;
    private boolean responseStreaming;
    private String url;
    private int useTicketType;
    private long writeTimeOut;

    public static class Builder {
        private boolean addHostCommonParams;
        private String clientKey;
        private long connectTimeOut;
        private OpenNetHeaders.Builder headers;
        private String method;
        private long readTimeOut;
        private OpenRequestBody requestBody;
        private boolean responseStreaming;
        private String url;
        private int useTicketType;
        private long writeTimeOut;

        public Builder(OpenHostRequest r100) {
            this.useTicketType = 0;
            this.clientKey = "";
            this.url = OpenHostRequest.access$000(r100);
            this.method = OpenHostRequest.access$100(r100);
            this.connectTimeOut = OpenHostRequest.access$200(r100);
            this.writeTimeOut = OpenHostRequest.access$300(r100);
            this.readTimeOut = OpenHostRequest.access$400(r100);
            this.responseStreaming = OpenHostRequest.access$500(r100);
            this.addHostCommonParams = OpenHostRequest.access$600(r100);
            this.headers = new OpenNetHeaders.Builder(OpenHostRequest.access$700(r100));
            this.requestBody = OpenHostRequest.access$800(r100);
            this.clientKey = OpenHostRequest.access$900(r100);
            this.useTicketType = OpenHostRequest.access$1000(r100);
        }

        public Builder(String r100) {
            this.useTicketType = 0;
            this.clientKey = "";
            this.url = r100;
            this.method = "GET";
            this.connectTimeOut = 60000;
            this.writeTimeOut = 60000;
            this.readTimeOut = 60000;
            this.responseStreaming = false;
            this.addHostCommonParams = true;
            this.headers = new OpenNetHeaders.Builder();
            this.requestBody = null;
        }

        public Builder addHeader(String r100, String r101) {
            this.headers.addHeader(r100, r101);
            return this;
        }

        public Builder addHostCommonParams(boolean r100) {
            this.addHostCommonParams = r100;
            return this;
        }

        public OpenHostRequest build() {
            return new OpenHostRequest(this.url, this.method, this.responseStreaming, this.addHostCommonParams, this.headers.build(), this.requestBody, this.connectTimeOut, this.readTimeOut, this.writeTimeOut, this.useTicketType, this.clientKey);
        }

        public Builder connectTimeOut(long r100) {
            this.connectTimeOut = r100;
            return this;
        }

        public Builder delete(OpenRequestBody r100) {
            return method("DELETE", r100);
        }

        public Builder get() {
            return method("GET", null);
        }

        public List<String> getHeaders(String r100) {
            return this.headers.getHeader(r100);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder method(String r100, OpenRequestBody r101) {
            this.method = r100;
            this.requestBody = r101;
            return this;
        }

        public Builder patch(OpenRequestBody r100) {
            return method("PATCH", r100);
        }

        public Builder post(OpenRequestBody r100) {
            return method("POST", r100);
        }

        public Builder put(OpenRequestBody r100) {
            return method("PUT", r100);
        }

        public Builder readTimeOut(long r100) {
            this.readTimeOut = r100;
            return this;
        }

        public Builder removeHeader(String r100) {
            this.headers.removeHeader(r100);
            return this;
        }

        public Builder replaceHeader(String r100, String r101) {
            this.headers.replaceHeader(r100, r101);
            return this;
        }

        public Builder responseStreaming(boolean r100) {
            this.responseStreaming = r100;
            return this;
        }

        public Builder setClientKey(String r100) {
            this.clientKey = r100;
            return this;
        }

        public Builder setHeaders(OpenNetHeaders r100) {
            this.headers = new OpenNetHeaders.Builder(r100);
            return this;
        }

        public Builder setHeaders(Map<String, String> r100) {
            this.headers.setHeaders(r100);
            return this;
        }

        public Builder setUseTicketType(int r100) {
            this.useTicketType = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }

        public Builder writeTimeOut(long r100) {
            this.writeTimeOut = r100;
            return this;
        }
    }

    public OpenHostRequest(String r100, String r101, boolean r102, boolean r103, OpenNetHeaders r104, OpenRequestBody r105, long r106, long r107, long r110, int r111, String r112) {
        this.url = r100;
        this.method = r101;
        this.responseStreaming = r102;
        this.addHostCommonParams = r103;
        this.headers = r104;
        this.requestBody = r105;
        this.connectTimeOut = r106;
        this.readTimeOut = r107;
        this.writeTimeOut = r110;
        this.useTicketType = r111;
        this.clientKey = r112;
    }

    public static /* synthetic */ String access$000(OpenHostRequest r100) {
        return r100.url;
    }

    public static /* synthetic */ String access$100(OpenHostRequest r100) {
        return r100.method;
    }

    public static /* synthetic */ int access$1000(OpenHostRequest r100) {
        return r100.useTicketType;
    }

    public static /* synthetic */ long access$200(OpenHostRequest r100) {
        return r100.connectTimeOut;
    }

    public static /* synthetic */ long access$300(OpenHostRequest r100) {
        return r100.writeTimeOut;
    }

    public static /* synthetic */ long access$400(OpenHostRequest r100) {
        return r100.readTimeOut;
    }

    public static /* synthetic */ boolean access$500(OpenHostRequest r100) {
        return r100.responseStreaming;
    }

    public static /* synthetic */ boolean access$600(OpenHostRequest r100) {
        return r100.addHostCommonParams;
    }

    public static /* synthetic */ OpenNetHeaders access$700(OpenHostRequest r100) {
        return r100.headers;
    }

    public static /* synthetic */ OpenRequestBody access$800(OpenHostRequest r100) {
        return r100.requestBody;
    }

    public static /* synthetic */ String access$900(OpenHostRequest r100) {
        return r100.clientKey;
    }

    public boolean addHostCommonParams() {
        return this.addHostCommonParams;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public long getConnectTimeOut() {
        return this.connectTimeOut;
    }

    public OpenNetHeaders getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public long getReadTimeOut() {
        return this.readTimeOut;
    }

    public OpenRequestBody getRequestBody() {
        return this.requestBody;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUseTicketType() {
        return this.useTicketType;
    }

    public long getWriteTimeOut() {
        return this.writeTimeOut;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public String toString() {
        return "OpenHostRequest{url='" + this.url + "', method='" + this.method + "', responseStreaming=" + this.responseStreaming + ", addHostCommonParams=" + this.addHostCommonParams + ", headers=" + this.headers + ", connectTimeOut=" + this.connectTimeOut + ", readTimeOut=" + this.readTimeOut + ", writeTimeOut=" + this.writeTimeOut + '}';
    }
}
