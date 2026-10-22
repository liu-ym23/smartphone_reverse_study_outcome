package com.ttnetuploader.uploader.request_protocol;

import android.content.Context;
import com.ttnetuploader.uploader.slice_task.SliceConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class UploaderRequestAliyun {
    static final String DRIVE_ID = "drive_id";
    static final String FILE_ID = "file_id";
    static final String SIZE = "size";
    static final String UPLOAD_ID = "upload_id";

    public UploaderRequestAliyun() {
    }

    public static String getCompletedMethod() {
        return "POST";
    }

    public static String getPostDataMethod(int r100) {
        return "PUT";
    }

    public static String getQueryMethod() {
        return "POST";
    }

    public static Map<String, String> getCompletedHeaders(SliceConfig r100) {
        HashMap r101 = new HashMap();
        r101.put("Content-Type", "application/json; charset=utf-8");
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

    public static String getCompletedMsgBody(SliceConfig r100) {
        JSONObject r101 = new JSONObject();
        r101.put(DRIVE_ID, r100.getParam().getUserDriveId());     // Catch: Exception -> L5
        r101.put("file_id", r100.getParam().getUserFileId());     // Catch: Exception -> L5
        r101.put(UPLOAD_ID, r100.getParam().getUserUploadId());     // Catch: Exception -> L5
    L8:
        return r101.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static String getCompletedMsgUrl(SliceConfig r100) {
        return r100.getParam().getUrl() + "/adrive/v1.0/openFile/complete";
    }

    public static Map<String, String> getPostDataHeaders(SliceConfig r100) {
        if (r100.getParam().getUserHeaders() == null) goto L7;
        return r100.getParam().getUserHeaders();
    L7:
        return new HashMap();
    }

    public static String getPostDataUrl(SliceConfig r100) {
        return r100.getSliceUrl();
    }

    public static String getQueryBody(SliceConfig r100) {
        JSONObject r101 = new JSONObject();
        r101.put(DRIVE_ID, r100.getParam().getUserDriveId());     // Catch: Exception -> L5
        r101.put("file_id", r100.getParam().getUserFileId());     // Catch: Exception -> L5
        r101.put(UPLOAD_ID, r100.getParam().getUserUploadId());     // Catch: Exception -> L5
        r101.put("size", r100.getParam().getFileLength());     // Catch: Exception -> L5
    L8:
        return r101.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static String getQueryUrl(SliceConfig r100) {
        return r100.getParam().getUrl() + "/adrive/v1.0/openFile/listUploadedParts";
    }

    public static Map<String, String> getQueryHeaders(SliceConfig r100, Context r101) {
        HashMap r102 = new HashMap();
        r102.put("Content-Type", "application/json; charset=utf-8");
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
}
