package com.ttnetuploader.uploader.response_protocol;

import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.net.INetResponse;
import com.ttnetuploader.uploader.slice_task.Range;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class ServerResponseBase {
    protected String mClientIpv4;
    protected int mCode;
    protected Map<String, String> mCompletedResponseMap;
    protected String mDownloadUrl;
    protected String mErrorLog;
    protected boolean mIsCancel;
    protected boolean mIsHadUploaded;
    protected boolean mIsNotLogin;
    protected boolean mIsOnlyLackCompletedMsg;
    protected boolean mIsQueryResponse;
    protected boolean mIsQueryTotal;
    protected boolean mIsSingleSliceSucceed;
    protected boolean mIsSuccess;
    protected String mMessage;
    protected ArrayList<Range> mNeedUploadRangeArray;
    protected Parameters mParam;
    protected long mPartSizeMin;
    protected String mPreviewUrl;
    protected String mServerFileName;
    protected long mServerFileSize;
    protected String mServerFileType;
    protected long mServerRemainDisk;
    protected long mServerTotalDisk;
    protected String mThumbnailUrl;
    protected long mUnuploadedLength;

    public boolean getIsOnlyLackCompletedMsg() {
        return false;
    }

    public String getClientIpv4() {
        return this.mClientIpv4;
    }

    public int getCode() {
        return this.mCode;
    }

    public Map<String, String> getCompletedResponseDic() {
        return this.mCompletedResponseMap;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public String getErrorLog() {
        return this.mErrorLog;
    }

    public boolean getIsCancel() {
        return this.mIsCancel;
    }

    public boolean getIsNotLogin() {
        return this.mIsNotLogin;
    }

    public boolean getIsQueryResponse() {
        return this.mIsQueryResponse;
    }

    public boolean getIsSingleSliceSucceed() {
        return this.mIsSingleSliceSucceed;
    }

    public boolean getIsSuccess() {
        return this.mIsSuccess;
    }

    public boolean getIsUploaded() {
        return this.mIsHadUploaded;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public ArrayList<Range> getNeedUploadRangeArray() {
        return this.mNeedUploadRangeArray;
    }

    public Parameters getParam() {
        return this.mParam;
    }

    public long getPartSizeMin() {
        return this.mPartSizeMin;
    }

    public String getPreviewUrl() {
        return this.mPreviewUrl;
    }

    public long getRemainDisk() {
        return this.mServerRemainDisk;
    }

    public String getServerFileName() {
        return this.mServerFileName;
    }

    public long getServerFileSize() {
        return this.mServerFileSize;
    }

    public String getServerFileType() {
        return this.mServerFileType;
    }

    public String getThumbnailUrl() {
        return this.mThumbnailUrl;
    }

    public long getTotalDisk() {
        return this.mServerTotalDisk;
    }

    public long getUnuploadedLen() {
        return this.mUnuploadedLength;
    }

    public ServerResponseBase(INetResponse r100, Parameters r101) {
        this.mIsSuccess = false;
        this.mIsSingleSliceSucceed = false;
        this.mIsOnlyLackCompletedMsg = false;
        this.mIsHadUploaded = false;
        this.mIsQueryResponse = false;
        this.mIsQueryTotal = false;
        this.mCode = -1;
        this.mMessage = null;
        this.mUnuploadedLength = 0;
        this.mPartSizeMin = 0;
        this.mNeedUploadRangeArray = null;
        this.mErrorLog = null;
        this.mIsCancel = false;
        this.mIsNotLogin = false;
        this.mCompletedResponseMap = null;
        this.mServerRemainDisk = 0;
        this.mServerTotalDisk = 0;
        this.mClientIpv4 = "";
        this.mThumbnailUrl = "";
        this.mPreviewUrl = "";
        this.mDownloadUrl = "";
        this.mServerFileName = "";
        this.mServerFileSize = 0;
        this.mServerFileType = "";
        this.mParam = r101;
    }

    public static ServerResponseBase getServerResponse(Parameters r100, INetResponse r101) {
        if (r100.getProtocol() != 1) goto L7;
        return new ServerResponseLan(r101, r100);
    L7:
        if (r100.getProtocol() != 2) goto L11;
        return new ServerResponseAliyun(r101, r100);
    L11:
        if (r100.getProtocol() == 0) goto L13;
        return null;
    L13:
        return new NormalResponse(r101, r100);
    }
}
