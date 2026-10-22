package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DubbedInfo {
    public String mBackupUrl1;
    public String mBackupUrl2;
    public String mBackupUrl3;
    public int mBitrate;
    public String mCheckInfo;
    public String mFileKey;
    public int mInfoId;
    public float mLoudness;
    public String mMainUrl;
    public int mMediaType;
    public float mPeak;

    public static class Builder {
        private String mBackupUrl1;
        private String mBackupUrl2;
        private String mBackupUrl3;
        private int mBitrate;
        private String mCheckInfo;
        private String mFileKey;
        private int mInfoId;
        private float mLoudness;
        private String mMainUrl;
        private int mMediaType;
        private float mPeak;

        public DubbedInfo build() {
            DubbedInfo r100 = new DubbedInfo();
            r100.mMediaType = this.mMediaType;
            r100.mMainUrl = this.mMainUrl;
            r100.mBackupUrl1 = this.mBackupUrl1;
            r100.mBackupUrl2 = this.mBackupUrl2;
            r100.mBackupUrl3 = this.mBackupUrl3;
            r100.mCheckInfo = this.mCheckInfo;
            r100.mInfoId = this.mInfoId;
            r100.mBitrate = this.mBitrate;
            r100.mLoudness = this.mLoudness;
            r100.mPeak = this.mPeak;
            r100.mFileKey = this.mFileKey;
            return r100;
        }

        public Builder() {
            this.mMediaType = 0;
            this.mMainUrl = null;
            this.mBackupUrl1 = null;
            this.mBackupUrl2 = null;
            this.mBackupUrl3 = null;
            this.mCheckInfo = null;
            this.mInfoId = -1;
            this.mBitrate = 0;
            this.mLoudness = 0.0f;
            this.mPeak = 0.0f;
            this.mFileKey = null;
        }

        public Builder backupUrl1(String r100) {
            this.mBackupUrl1 = r100;
            return this;
        }

        public Builder backupUrl2(String r100) {
            this.mBackupUrl2 = r100;
            return this;
        }

        public Builder backupUrl3(String r100) {
            this.mBackupUrl3 = r100;
            return this;
        }

        public Builder bitrate(int r100) {
            this.mBitrate = r100;
            return this;
        }

        public Builder checkInfo(String r100) {
            this.mCheckInfo = r100;
            return this;
        }

        public Builder fileKey(String r100) {
            this.mFileKey = r100;
            return this;
        }

        public Builder infoId(int r100) {
            this.mInfoId = r100;
            return this;
        }

        public Builder loudness(float r100) {
            this.mLoudness = r100;
            return this;
        }

        public Builder mainUrl(String r100) {
            this.mMainUrl = r100;
            return this;
        }

        public Builder mediaType(int r100) {
            this.mMediaType = r100;
            return this;
        }

        public Builder peak(float r100) {
            this.mPeak = r100;
            return this;
        }
    }

    public JSONObject toBashJsonObject() {
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(this.mMainUrl) == false) goto L6;
        return null;
    L6:
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L11
        r100.put("main_url", this.mMainUrl);     // Catch: Exception -> L11
        String r101 = this.mBackupUrl1;     // Catch: Exception -> L11
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        r100.put("backup_url_1", r101);     // Catch: Exception -> L11
        r100.put("check_info", this.mCheckInfo);     // Catch: Exception -> L11
        r100.put("info_id", this.mInfoId);     // Catch: Exception -> L11
        r100.put("bitrate", this.mBitrate);     // Catch: Exception -> L11
        r100.put("loudness", this.mLoudness);     // Catch: Exception -> L11
        r100.put("peak", this.mPeak);     // Catch: Exception -> L11
        return r100;
    }

    public JSONObject toStrategyPreloadJsonObject() {
    L21:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(this.mMainUrl) == false) goto L6;
        return null;
    L6:
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L21
        JSONArray r101 = new JSONArray();     // Catch: Exception -> L21
        r101.put(this.mMainUrl);     // Catch: Exception -> L21
        String r102 = this.mBackupUrl1;     // Catch: Exception -> L21
        if (r102 == null) goto L9;
        r101.put(r102);     // Catch: Exception -> L21
    L9:
        String r103 = this.mBackupUrl2;     // Catch: Exception -> L21
        if (r103 == null) goto L12;
        r101.put(r103);     // Catch: Exception -> L21
    L12:
        String r104 = this.mBackupUrl3;     // Catch: Exception -> L21
        if (r104 == null) goto L15;
        r101.put(r104);     // Catch: Exception -> L21
    L15:
        r100.put("urls", r101);     // Catch: Exception -> L21
        r100.put("info_id", this.mInfoId);     // Catch: Exception -> L21
        r100.put("bitrate", this.mBitrate);     // Catch: Exception -> L21
        r100.put(BarrageMaskInfo.KEY_MASK_FILE_HASH, this.mFileKey);     // Catch: Exception -> L21
        if (this.mMediaType != 0) goto L18;
        String r105 = "video";
    L19:
        r100.put(a.KEY_MEDIA_TYPE, r105);     // Catch: Exception -> L21
        return r100;
    L18:
        r105 = "audio";
        goto L19
    }

    public String[] getUrls() {
        ArrayList r100 = new ArrayList();
        if (TextUtils.isEmpty(this.mMainUrl) == true) goto L6;
        r100.add(this.mMainUrl);
    L6:
        if (TextUtils.isEmpty(this.mBackupUrl1) == true) goto L9;
        r100.add(this.mBackupUrl1);
    L15:
        if (r100.size() != 0) goto L18;
        return null;
    L18:
        String[] r101 = new String[r100.size()];
        r100.toArray(r101);
        return r101;
    L9:
        if (TextUtils.isEmpty(this.mBackupUrl2) == true) goto L12;
        r100.add(this.mBackupUrl2);
        goto L15
    L12:
        if (TextUtils.isEmpty(this.mBackupUrl3) == true) goto L15;
        r100.add(this.mBackupUrl3);
        goto L15
    }

    public DubbedInfo() {
        this.mMediaType = 0;
        this.mMainUrl = null;
        this.mBackupUrl1 = null;
        this.mBackupUrl2 = null;
        this.mBackupUrl3 = null;
        this.mCheckInfo = null;
        this.mInfoId = -1;
        this.mBitrate = 0;
        this.mLoudness = 0.0f;
        this.mPeak = 0.0f;
        this.mFileKey = null;
    }
}
