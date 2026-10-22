package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class BarrageMaskInfo {
    public static final String KEY_MASK_BITRATE = "bitrate";
    public static final String KEY_MASK_FILE_HASH = "file_hash";
    public static final String KEY_MASK_FILE_ID = "file_id";
    public static final String KEY_MASK_FILE_SIZE = "file_size";
    public static final String KEY_MASK_HEAD_LEN = "head_len";
    public static final String KEY_MASK_UPDATED_AT = "updated_at";
    public static final String KEY_MASK_URL = "barrage_mask_url";
    public static final String KEY_MASK_VERSION = "version";
    public static final String KEY_VER4_MASK_BITRATE = "Bitrate";
    public static final String KEY_VER4_MASK_FILE_HASH = "FileHash";
    public static final String KEY_VER4_MASK_FILE_ID = "FileId";
    public static final String KEY_VER4_MASK_FILE_SIZE = "FileSize";
    public static final String KEY_VER4_MASK_HEAD_LEN = "HeadLen";
    public static final String KEY_VER4_MASK_UPDATED_AT = "UpdatedAt";
    public static final String KEY_VER4_MASK_URL = "BarrageMaskUrl";
    public static final String KEY_VER4_MASK_VERSION = "Version";
    public static final int VALUE_VIDEO_MASK_INFO_BITRATE = 6;
    public static final int VALUE_VIDEO_MASK_INFO_FILE_HASH = 3;
    public static final int VALUE_VIDEO_MASK_INFO_FILE_ID = 2;
    public static final int VALUE_VIDEO_MASK_INFO_FILE_SIZE = 4;
    public static final int VALUE_VIDEO_MASK_INFO_HEAD_LEN = 7;
    public static final int VALUE_VIDEO_MASK_INFO_UPDATED_AT = 5;
    public static final int VALUE_VIDEO_MASK_INFO_URL = 1;
    public static final int VALUE_VIDEO_MASK_INFO_VERSION = 0;
    public int mMaskBitrate;
    public String mMaskFileHash;
    public String mMaskFileId;
    public long mMaskFileSize;
    public int mMaskHeadLen;
    public long mMaskUpdatedAt;
    public String mMaskUrl;
    public String mMaskVersion;

    public Map<String, Object> getMediaInfo() {
        HashMap r100 = new HashMap();
        r100.put("file_id", getValueStr(2));
        r100.put(a.KEY_MEDIA_TYPE, BuyNowCloseMethod.MASK);
        r100.put("file_size", Long.valueOf(getValueLong(4)));
        r100.put("bitrate", Integer.valueOf(getValueInt(6)));
        String r101 = getValueStr(1);
        if (TextUtils.isEmpty(r101) == true) goto L5;
        r100.put("urls", new String[]{r101});
    L5:
        r100.put(KEY_MASK_FILE_HASH, getValueStr(3));
        return r100;
    }

    public BarrageMaskInfo() {
        this.mMaskFileSize = 0;
        this.mMaskUpdatedAt = 0;
        this.mMaskBitrate = 0;
        this.mMaskHeadLen = 0;
    }

    public void extractFields(JSONObject r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        this.mMaskVersion = r100.optString("version");     // Catch: Exception -> L6
        this.mMaskUrl = r100.optString(KEY_MASK_URL);     // Catch: Exception -> L6
        this.mMaskFileId = r100.optString("file_id");     // Catch: Exception -> L6
        this.mMaskFileHash = r100.optString(KEY_MASK_FILE_HASH);     // Catch: Exception -> L6
        this.mMaskFileSize = r100.optLong("file_size");     // Catch: Exception -> L6
        this.mMaskUpdatedAt = r100.optLong(KEY_MASK_UPDATED_AT);     // Catch: Exception -> L6
        this.mMaskBitrate = r100.optInt("bitrate");     // Catch: Exception -> L6
        this.mMaskHeadLen = r100.optInt(KEY_MASK_HEAD_LEN);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        TTVideoEngineLog.d(e);
    }

    public void extractFieldsV4(JSONObject r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        this.mMaskVersion = r100.optString("Version");     // Catch: Exception -> L6
        this.mMaskUrl = r100.optString(KEY_VER4_MASK_URL);     // Catch: Exception -> L6
        this.mMaskFileId = r100.optString(KEY_VER4_MASK_FILE_ID);     // Catch: Exception -> L6
        this.mMaskFileHash = r100.optString(KEY_VER4_MASK_FILE_HASH);     // Catch: Exception -> L6
        this.mMaskFileSize = r100.optLong(KEY_VER4_MASK_FILE_SIZE);     // Catch: Exception -> L6
        this.mMaskUpdatedAt = r100.optLong(KEY_VER4_MASK_UPDATED_AT);     // Catch: Exception -> L6
        this.mMaskBitrate = r100.optInt(KEY_VER4_MASK_BITRATE);     // Catch: Exception -> L6
        this.mMaskHeadLen = r100.optInt(KEY_VER4_MASK_HEAD_LEN);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        TTVideoEngineLog.d(e);
    }

    public int getValueInt(int r100) {
        if (r100 == 6) goto L11;
        if (r100 == 7) goto L9;
        return -1;
    L9:
        return this.mMaskHeadLen;
    L11:
        return this.mMaskBitrate;
    }

    public long getValueLong(int r100) {
        if (r100 == 4) goto L11;
        if (r100 == 5) goto L9;
        return 0;
    L9:
        return this.mMaskUpdatedAt;
    L11:
        return this.mMaskFileSize;
    }

    public String getValueStr(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return "";
    L12:
        return this.mMaskFileHash;
    L14:
        return this.mMaskFileId;
    L16:
        return this.mMaskUrl;
    L18:
        return this.mMaskVersion;
    }
}
