package com.ss.bduploader;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class BDVideoInfo {
    public String mCallbackArgs;
    public String mCoverUri;
    public String mEncryptionMeta;
    public long mErrorCode;
    public String mErrorMsg;
    public long mFileIndex;
    public JSONObject mLog;
    public String mMid;
    public long mProgress;
    public String mTosKey;
    public String mVideoId;
    public String mVideoMediaInfo;

    public static class AIGCMeta {
        public String ContentProducer;
        public String ContentPropagator;
        public String Label;

        public AIGCMeta(String r100, String r101, String r102) {
            this.Label = r100;
            this.ContentProducer = r101;
            this.ContentPropagator = r102;
        }
    }

    public BDVideoInfo(String r110, String r111, long r112, String r113, String r114, String r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, null);
    }

    public BDVideoInfo(String r100, String r101, long r102, String r103, String r104, String r105, String r110, String r111) {
        this.mFileIndex = 0;
        this.mVideoId = r100;
        this.mCoverUri = r101;
        this.mProgress = r102;
        this.mErrorCode = r102;
        this.mErrorMsg = r103;
        this.mTosKey = r104;
        this.mVideoMediaInfo = r105;
        this.mEncryptionMeta = r110;
        this.mCallbackArgs = r111;
        this.mLog = null;
    }

    public BDVideoInfo(String r100, String r101, long r102, int r103, String r104, String r105, String r106, String r107, String r110) {
        this.mVideoId = r100;
        this.mCoverUri = r101;
        long r108 = r103;
        this.mProgress = r108;
        this.mFileIndex = r102;
        this.mErrorCode = r108;
        this.mErrorMsg = r104;
        this.mTosKey = r105;
        this.mVideoMediaInfo = r106;
        this.mEncryptionMeta = r107;
        this.mCallbackArgs = r110;
        this.mLog = null;
    }
}
