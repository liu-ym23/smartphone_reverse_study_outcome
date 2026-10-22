package com.ttnetuploader.uploader.response_protocol;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.net.INetResponse;
import com.ttnetuploader.uploader.slice_task.Range;
import com.ttnetuploader.uploader.utils.CommonTools;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class ServerResponseAliyun extends ServerResponseBase {
    static final String DOWNLOAD_URL = "download_url";
    static final String NAME = "name";
    static final String PART_NUMBER = "part_number";
    static final String PART_SIZE = "part_size";
    static final String SIZE = "size";
    static final String THUMBNAIL = "thumbnail";
    static final String TYPE = "type";
    static final String UPLOADED_PARTS = "uploaded_parts";
    static final String UPLOAD_URL = "upload_url";
    static final String URL = "url";

    public ServerResponseAliyun(INetResponse r100, Parameters r110) {
        super(r100, r110);
        this.mErrorLog = r100.getRequestLog();
        this.mIsQueryResponse = true;
        this.mIsQueryTotal = true;
    L53:
        e = move-exception;
        this.mErrorLog += r100.getRequestLog();
        e.printStackTrace();
        return;
    L4:
        if (CommonTools.isSuccess(r100.getCode()) == false) goto L48;
        this.mIsSuccess = true;     // Catch: Exception -> L53
        this.mIsSingleSliceSucceed = true;     // Catch: Exception -> L53
        JSONObject r111 = r100.getBodyJson();     // Catch: Exception -> L53
        if (r111 != null) goto L8;
    L49:
        ArrayList<Range> r112 = this.mNeedUploadRangeArray;     // Catch: Exception -> L53
        if (r112 == null) goto L58;
        this.mUnuploadedLength = CommonTools.getUnuploadLen(r112);     // Catch: Exception -> L53
        return;
    L58:
        return;
    L8:
        if (r111.has(UPLOADED_PARTS) == false) goto L11;
        this.mNeedUploadRangeArray = getNeedRangeList(this.mParam, JSONObjectProtectorUtils.getJSONArray(r111, UPLOADED_PARTS));     // Catch: Exception -> L53
    L11:
        if (r111.has("thumbnail") == false) goto L16;
        String r101 = r111.optString("thumbnail");     // Catch: Exception -> L53
        if (r101.isEmpty() == true) goto L16;
        this.mThumbnailUrl = r101;     // Catch: Exception -> L53
    L16:
        if (r111.has("url") == false) goto L23;
        String r102 = r111.optString("url");     // Catch: Exception -> L53
        if (r102 == null) goto L23;
        if (r102.length() <= 0) goto L23;
        this.mPreviewUrl = r102;     // Catch: Exception -> L53
    L23:
        if (r111.has("download_url") == false) goto L30;
        String r103 = r111.optString("download_url");     // Catch: Exception -> L53
        if (r103 == null) goto L30;
        if (r103.length() <= 0) goto L30;
        this.mDownloadUrl = r103;     // Catch: Exception -> L53
    L30:
        if (r111.has("name") == false) goto L37;
        String r104 = r111.optString("name");     // Catch: Exception -> L53
        if (r104 == null) goto L37;
        if (r104.length() <= 0) goto L37;
        this.mServerFileName = r104;     // Catch: Exception -> L53
    L37:
        if (r111.has("size") == false) goto L42;
        long r105 = r111.optLong("size");     // Catch: Exception -> L53
        if (r105 <= 0) goto L42;
        this.mServerFileSize = r105;     // Catch: Exception -> L53
    L42:
        if (r111.has("type") == false) goto L49;
        String r113 = r111.optString("type");     // Catch: Exception -> L53
        if (r113 == null) goto L49;
        if (r113.length() <= 0) goto L49;
        this.mServerFileType = r113;     // Catch: Exception -> L53
        goto L49
    L48:
        this.mErrorLog = r100.getRequestLog();     // Catch: Exception -> L53
        goto L49
    }

    private static ArrayList<Range> getNeedRangeList(Parameters r100, JSONArray r110) {
        ArrayList<Range> r101 = new ArrayList();
        if (r110 != null) goto L6;
        return r101;
    L6:
        if (r110.length() != 0) goto L9;
        Range r111 = new Range(0, r100.getFileLength() - 1);
        r111.rangeUrl = r100.getUserUploadUrl();
        r101.add(r111);
        return r101;
    L9:
        int r102 = 0;
    L17:
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        return r101;
    L11:
        if (r102 >= r110.length()) goto L16;
        int r103 = JSONObjectProtectorUtils.getInt(JSONArrayProtectorUtils.getJSONObject(r110, r102), PART_NUMBER);     // Catch: Exception -> L14
        long r104 = JSONObjectProtectorUtils.getLong(JSONArrayProtectorUtils.getJSONObject(r110, r102), PART_SIZE);     // Catch: Exception -> L14
        String r105 = JSONObjectProtectorUtils.getString(JSONArrayProtectorUtils.getJSONObject(r110, r102), UPLOAD_URL);     // Catch: Exception -> L14
        long r106 = ((long) r103) * r104;     // Catch: Exception -> L14
        Range r107 = new Range(r106, (r104 + r106) - 1);     // Catch: Exception -> L14
        r107.rangeUrl = r105;     // Catch: Exception -> L14
        r101.add(r107);     // Catch: Exception -> L14
        r102 = r102 + 1;
        goto L17
    }
}
