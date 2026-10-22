package com.ss.ttvideoengine.httpdns;

import com.ss.mediakit.net.AVMDLCustomHTTPDNSParser;
import com.ss.mediakit.net.AVMDLCustomHTTPDNSParserResult;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* JADX INFO: loaded from: classes34.dex */
public class BytedanceHTTPDNSParser implements AVMDLCustomHTTPDNSParser {
    public static final int DNS_TYPE_CUSTOM_INNER_BYTEDANCE_HTTPDNS = 1;
    private static final String TAG = "BytedanceHTTPDNSParser";
    private final ByteDanceHttpDnsDepend mByteDanceHttpDnsDepend;

    public int start() {
        throw new UnsupportedOperationException("tob only");
    }

    public BytedanceHTTPDNSParser(ByteDanceHttpDnsDepend r100) {
        TTVideoEngineLog.d(TAG, "new parser " + r100);
        this.mByteDanceHttpDnsDepend = r100;
    }

    @Override // com.ss.mediakit.net.AVMDLCustomHTTPDNSParser
    public AVMDLCustomHTTPDNSParserResult parseHost(String r100) {
        throw new UnsupportedOperationException("tob only");
    }
}
