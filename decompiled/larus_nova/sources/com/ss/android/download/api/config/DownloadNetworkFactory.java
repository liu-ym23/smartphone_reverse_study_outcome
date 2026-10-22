package com.ss.android.download.api.config;

import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadNetworkFactory {

    public interface CompressType {
        public static final int DEFLATER = 2;
        public static final int GZIP = 1;
        public static final int NONE = 0;
    }

    public interface ContentType {
        public static final String JSON = "application/json; charset=utf-8";
        public static final String TT_DATA = "application/octet-stream;tt-data=a";
    }

    void execute(String r100, String r101, Map<String, Object> r102, IHttpCallback r103);

    void postBody(String r100, byte[] r101, String r102, int r103, IHttpCallback r104);
}
