package com.ttnetuploader.uploader.request_protocol;

import android.content.Context;
import com.ttnetuploader.uploader.slice_task.SliceConfig;
import com.ttnetuploader.uploader.utils.CommonTools;
import com.ttnetuploader.uploader.utils.UploadFileUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes41.dex */
public class UploaderRequestLan {
    public static final String HOST_KEY = "Host";
    public static final String HOST_VALUE = "www.picolocalhttpserver.com";
    public static final String KKEEP_ALIVE_PATH = "/v1/keepalive";
    public static final String LAN_DATA_PATH = "v1/Data";
    public static final String LAN_FILE_NAME = "t-u-l-n-file-name";
    public static final String LAN_HTTP = "http";
    public static final String LAN_HTTPS = "https";
    public static final String LAN_MD5 = "t-u-l-n-md5";
    public static final String LAN_MSG_TYPE = "t-u-l-n-msg-type";
    public static final String LAN_QUERY_PATH = "v1/query";
    public static final String LAN_RANGE = "t-u-l-n-range";
    public static final String LAN_SN = "t-u-l-n-sn";
    public static final String LAN_TOTAL = "t-u-l-n-total";
    public static final String POST_DATA_PATH = "/v1/Data";
    public static final String QUERY_PATH = "/v1/query";
    public static final String TTNET_ISOLATION_KEY = "x-ttnet-isolation-info";
    public static final String USER_KEY = "t-u-l-n-user-key";

    public UploaderRequestLan() {
    }

    public static String getCompletedMethod() {
        return "POST";
    }

    public static String getCompletedMsgBody(SliceConfig r100) {
        return "";
    }

    public static String getCompletedMsgUrl(SliceConfig r100) {
        return "";
    }

    public static String getPostDataMethod() {
        return "POST";
    }

    public static String getQueryBody(SliceConfig r100) {
        return "";
    }

    public static String getQueryMethod() {
        return "GET";
    }

    public static Map<String, String> getKeepAliveHeaders() {
        HashMap r100 = new HashMap();
        r100.put("Host", HOST_VALUE);
        r100.put(LAN_MSG_TYPE, "6");
        r100.put(LAN_MD5, "keepAlive");
        return r100;
    }

    public static Map<String, String> getCompletedHeaders(SliceConfig r100) {
        return new HashMap();
    }

    public static Map<String, String> getPostDataHeaders(SliceConfig r100) {
        HashMap r101 = new HashMap();
        r101.put(LAN_MD5, r100.getParam().getMd5());
        r101.put(LAN_SN, r100.getParam().getSN());
        r101.put(LAN_RANGE, r100.getStart() + "-" + r100.getEnd());
        r101.put("Content-Length", String.valueOf((r100.getEnd() - r100.getStart()) + 1));
        r101.put("Content-Type", "application/octet-stream");
        r101.put(USER_KEY, r100.getParam().getUserKey());
        r101.put("Host", HOST_VALUE);
        r101.put(TTNET_ISOLATION_KEY, String.valueOf(new Random().nextLong()));
        if (r100.getParam().getUserHeaders() == null) goto L12;
        Iterator<Map.Entry<String, String>> r102 = r100.getParam().getUserHeaders().entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, String> r103 = r102.next();
        if (r103.getKey() == null) goto L6;
        if (r103.getValue() == null) goto L6;
        r101.put(r103.getKey(), r103.getValue());
    L12:
        return r101;
    }

    public static String getPostDataUrl(SliceConfig r100) {
        return CommonTools.getUrl(r100.getParam()) + POST_DATA_PATH;
    }

    public static String getQueryUrl(SliceConfig r100) {
        return CommonTools.getUrl(r100.getParam()) + QUERY_PATH;
    }

    public static Map<String, String> getQueryHeaders(SliceConfig r100, Context r101) {
        HashMap r102 = new HashMap();
        r102.put(LAN_MD5, r100.getParam().getMd5());
        r102.put(LAN_TOTAL, "" + r100.getParam().getFileLength());
        r102.put(LAN_FILE_NAME, UploadFileUtils.getFileName(r100.getParam().getFilePath(), r100.getParam().getFileName(), r101));
        r102.put(LAN_SN, r100.getParam().getSN());
        r102.put(LAN_MSG_TYPE, "" + r100.getSliceType());
        r102.put("Content-Type", "application/octet-stream");
        r102.put(USER_KEY, r100.getParam().getUserKey());
        r102.put("Host", HOST_VALUE);
        r102.put(TTNET_ISOLATION_KEY, String.valueOf(new Random().nextLong()));
        if (r100.getParam().getUserHeaders() == null) goto L12;
        Iterator<Map.Entry<String, String>> r103 = r100.getParam().getUserHeaders().entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<String, String> r104 = r103.next();
        if (r104.getKey() == null) goto L6;
        if (r104.getValue() == null) goto L6;
        r102.put(r104.getKey(), r104.getValue());
    L12:
        return r102;
    }

    public static String getKeepAliveUrl(String r100, int r101, boolean r102) {
        StringBuilder r103 = new StringBuilder();
        if (r102 == false) goto L5;
        String r104 = "http";
    L6:
        r103.append(r104);
        r103.append("://");
        r103.append(r100);
        r103.append(":");
        r103.append(r101);
        r103.append(KKEEP_ALIVE_PATH);
        return r103.toString();
    L5:
        r104 = "https";
        goto L6
    }
}
