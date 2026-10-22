package com.ss.videoarch.strategy.dataCenter.strategyData.model;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class SessionCacheInfos implements Serializable {
    String TAG;
    public boolean isValid;
    public int m302;
    public long mAudioBuffer;
    public ConcurrentLinkedQueue<Long> mAudioBufferList;
    public int mBitrate;
    public int mBufferDataSeconds;
    public int mChannel;
    public int mConnectCost;
    public String mCreate;
    public String mDomain;
    public int mDoubleBufferDataSeconds;
    public long mDownloadSpeed;
    public long mDuration;
    public long mEndTs;
    public String mEnterAction;
    public String mEnterMethod;
    public long mEstimatedBandwidth;
    public float mFPS;
    public long mFirstFrame;
    public long mFirstFrameAudioBuffer;
    public long mFirstFrameDownloadSpeed;
    public long mFirstFrameVideoBuffer;
    public int mGop;
    public int mHeight;
    public int mIsPreview;
    public String mNeptuneName;
    public String mNetwork;
    public long mPlayTime;
    public String mProtocol;
    public ConcurrentLinkedQueue<Long> mRenderAudioSeries;
    public ConcurrentLinkedQueue<Long> mRenderVideoSeries;
    public int mRetryTotalCount;
    public int mSampleRate;
    public String mSessionId;
    public JSONObject mSession_time_series;
    public ConcurrentLinkedQueue<Long> mStallSeries;
    public long mStallTime;
    public int mStallTotalCount;
    public long mStallTotalTime;
    public int mStallType;
    public long mStartTs;
    public long mStopTimestamp;
    public String mStreamSuffix;
    public int mSuccess;
    public String mUpdate;
    public long mVideoBuffer;
    public ConcurrentLinkedQueue<Long> mVideoBufferList;
    public int mWidth;

    public String toString() {
        return "SessionCacheInfos{mSessionId='" + this.mSessionId + "', mDomain='" + this.mDomain + "', mPlayTime=" + this.mPlayTime + ", mDownloadSpeed=" + this.mDownloadSpeed + ", mNetwork='" + this.mNetwork + "', mUpdate='" + this.mUpdate + "', mCreate='" + this.mCreate + "'}";
    }

    public SessionCacheInfos() {
        this.TAG = "SessionCacheInfos";
        this.isValid = false;
        this.mSessionId = "";
        this.mDomain = "";
        this.mPlayTime = 0;
        this.mDownloadSpeed = 0;
        this.mNetwork = "";
        this.mUpdate = "";
        this.mCreate = "";
        this.mRetryTotalCount = 0;
        this.mStopTimestamp = 0;
        this.mSession_time_series = null;
        this.mFirstFrameAudioBuffer = 0;
        this.mFirstFrameVideoBuffer = 0;
        this.mFirstFrameDownloadSpeed = 0;
        this.mFirstFrame = 0;
        this.mSuccess = 0;
        this.m302 = 0;
        this.mConnectCost = 0;
        this.mStallType = 0;
        this.mStallTime = 0;
        this.mStartTs = 0;
        this.mStallTotalCount = 0;
        this.mStallTotalTime = 0;
        this.mEndTs = 0;
        this.mDuration = 0;
        this.mEnterMethod = "none";
        this.mEnterAction = "none";
        this.mIsPreview = 0;
        this.mBitrate = 0;
        this.mNeptuneName = "";
        this.mFPS = 0.0f;
        this.mGop = 0;
        this.mSampleRate = 0;
        this.mChannel = 0;
        this.mHeight = 0;
        this.mWidth = 0;
        this.mStreamSuffix = "";
        this.mProtocol = "";
        this.mVideoBuffer = 0;
        this.mAudioBuffer = 0;
        this.mEstimatedBandwidth = 0;
        this.mVideoBufferList = new ConcurrentLinkedQueue();
        this.mAudioBufferList = new ConcurrentLinkedQueue();
        this.mRenderAudioSeries = new ConcurrentLinkedQueue();
        this.mRenderVideoSeries = new ConcurrentLinkedQueue();
        this.mStallSeries = new ConcurrentLinkedQueue();
        this.mBufferDataSeconds = 0;
        this.mDoubleBufferDataSeconds = 0;
    }

    public <T> T getValue(String r100, T r101) {
    L163:
        e = move-exception;
        e.printStackTrace();
        return r101;
    L3:
        switch(r100.hashCode()) {
            case -1927368268: goto L117;
            case -1754979095: goto L114;
            case -1683202543: goto L111;
            case -1656530148: goto L108;
            case -1348421033: goto L105;
            case -1266030831: goto L102;
            case -1231353099: goto L99;
            case -1157606636: goto L96;
            case -924519752: goto L93;
            case -903626825: goto L90;
            case -786828786: goto L87;
            case -747805892: goto L84;
            case -709528236: goto L81;
            case -589160937: goto L78;
            case -304489875: goto L75;
            case -304474406: goto L72;
            case -232532383: goto L69;
            case -202516509: goto L66;
            case 50549: goto L63;
            case 69833: goto L60;
            case 67098778: goto L57;
            case 84113122: goto L54;
            case 278230227: goto L51;
            case 568537785: goto L48;
            case 819629183: goto L45;
            case 888094667: goto L42;
            case 1106004766: goto L39;
            case 1169152926: goto L36;
            case 1193711374: goto L33;
            case 1539107257: goto L30;
            case 1809510589: goto L27;
            case 1830263953: goto L24;
            case 1943403585: goto L21;
            case 2052636900: goto L18;
            case 2073378034: goto L15;
            case 2105319413: goto L12;
            case 2131714852: goto L9;
            case 2139694009: goto L6;
            default: goto L119;
        };     // Catch: Exception -> L163
    L119:
        byte r102 = -1;
    L120:
        switch(r102) {
            case 0: goto L160;
            case 1: goto L159;
            case 2: goto L158;
            case 3: goto L157;
            case 4: goto L156;
            case 5: goto L155;
            case 6: goto L154;
            case 7: goto L153;
            case 8: goto L152;
            case 9: goto L151;
            case 10: goto L150;
            case 11: goto L149;
            case 12: goto L148;
            case 13: goto L147;
            case 14: goto L146;
            case 15: goto L145;
            case 16: goto L144;
            case 17: goto L143;
            case 18: goto L142;
            case 19: goto L141;
            case 20: goto L140;
            case 21: goto L138;
            case 22: goto L137;
            case 23: goto L136;
            case 24: goto L135;
            case 25: goto L134;
            case 26: goto L133;
            case 27: goto L132;
            case 28: goto L131;
            case 29: goto L130;
            case 30: goto L129;
            case 31: goto L128;
            case 32: goto L127;
            case 33: goto L126;
            case 34: goto L125;
            case 35: goto L124;
            case 36: goto L123;
            case 37: goto L122;
            default: goto L168;
        };     // Catch: Exception -> L163
    L122:
        Object r103 = Integer.valueOf(this.mDoubleBufferDataSeconds);     // Catch: Exception -> L163
    L167:
        return (T) r103;
    L123:
        r103 = Integer.valueOf(this.mBufferDataSeconds);     // Catch: Exception -> L163
        goto L167
    L124:
        r103 = Long.valueOf(this.mEstimatedBandwidth);     // Catch: Exception -> L163
        goto L167
    L125:
        r103 = this.mDomain;     // Catch: Exception -> L163
        goto L167
    L126:
        r103 = this.mUpdate;     // Catch: Exception -> L163
        goto L167
    L127:
        r103 = this.mNetwork;     // Catch: Exception -> L163
        goto L167
    L128:
        r103 = this.mProtocol;     // Catch: Exception -> L163
        goto L167
    L129:
        r103 = this.mSessionId;     // Catch: Exception -> L163
        goto L167
    L130:
        r103 = this.mEnterMethod;     // Catch: Exception -> L163
        goto L167
    L131:
        r103 = this.mEnterAction;     // Catch: Exception -> L163
        goto L167
    L132:
        r103 = this.mStreamSuffix;     // Catch: Exception -> L163
        goto L167
    L133:
        r103 = this.mNeptuneName;     // Catch: Exception -> L163
        goto L167
    L134:
        r103 = this.mRenderAudioSeries;     // Catch: Exception -> L163
        goto L167
    L135:
        r103 = this.mRenderVideoSeries;     // Catch: Exception -> L163
        goto L167
    L136:
        r103 = this.mAudioBufferList;     // Catch: Exception -> L163
        goto L167
    L137:
        r103 = this.mVideoBufferList;     // Catch: Exception -> L163
        goto L167
    L138:
        r103 = this.mStallSeries;     // Catch: Exception -> L163
        goto L167
    L140:
        r103 = Float.valueOf(this.mFPS);     // Catch: Exception -> L163
        goto L167
    L141:
        r103 = Long.valueOf(this.mDownloadSpeed);     // Catch: Exception -> L163
        goto L167
    L142:
        r103 = Long.valueOf(this.mPlayTime);     // Catch: Exception -> L163
        goto L167
    L143:
        r103 = Long.valueOf(this.mStopTimestamp);     // Catch: Exception -> L163
        goto L167
    L144:
        r103 = Long.valueOf(this.mFirstFrame);     // Catch: Exception -> L163
        goto L167
    L145:
        r103 = Long.valueOf(this.mFirstFrameDownloadSpeed);     // Catch: Exception -> L163
        goto L167
    L146:
        r103 = Long.valueOf(this.mFirstFrameVideoBuffer);     // Catch: Exception -> L163
        goto L167
    L147:
        r103 = Long.valueOf(this.mFirstFrameAudioBuffer);     // Catch: Exception -> L163
        goto L167
    L148:
        r103 = Long.valueOf(this.mStallTotalTime);     // Catch: Exception -> L163
        goto L167
    L149:
        r103 = Long.valueOf(this.mDuration);     // Catch: Exception -> L163
        goto L167
    L150:
        r103 = Long.valueOf(this.mEndTs);     // Catch: Exception -> L163
        goto L167
    L151:
        r103 = Long.valueOf(this.mStallTime);     // Catch: Exception -> L163
        goto L167
    L152:
        r103 = Long.valueOf(this.mStartTs);     // Catch: Exception -> L163
        goto L167
    L153:
        r103 = Integer.valueOf(this.mIsPreview);     // Catch: Exception -> L163
        goto L167
    L154:
        r103 = Integer.valueOf(this.mRetryTotalCount);     // Catch: Exception -> L163
        goto L167
    L155:
        r103 = Integer.valueOf(this.mStallTotalCount);     // Catch: Exception -> L163
        goto L167
    L156:
        r103 = Integer.valueOf(this.mStallType);     // Catch: Exception -> L163
        goto L167
    L157:
        r103 = Integer.valueOf(this.mConnectCost);     // Catch: Exception -> L163
        goto L167
    L158:
        r103 = Integer.valueOf(this.m302);     // Catch: Exception -> L163
        goto L167
    L159:
        r103 = Integer.valueOf(this.mSuccess);     // Catch: Exception -> L163
        goto L167
    L160:
        r103 = Boolean.valueOf(this.isValid);     // Catch: Exception -> L163
        goto L167
    L168:
        return r101;
    L6:
        if (r100.equals("VideoBufferList") == false) goto L119;
        r102 = 22;
        goto L120
    L9:
        if (r100.equals("DoubleBufferDataSeconds") == false) goto L119;
        r102 = 37;
        goto L120
    L12:
        if (r100.equals("EstimatedBandwidth") == false) goto L119;
        r102 = 35;
        goto L120
    L15:
        if (r100.equals("isValid") == false) goto L119;
        r102 = 0;
        goto L120
    L18:
        if (r100.equals("Domain") == false) goto L119;
        r102 = 34;
        goto L120
    L21:
        if (r100.equals("PlayTime") == false) goto L119;
        r102 = 18;
        goto L120
    L24:
        if (r100.equals("StallTotalTime") == false) goto L119;
        r102 = 12;
        goto L120
    L27:
        if (r100.equals("FirstFrame") == false) goto L119;
        r102 = 16;
        goto L120
    L30:
        if (r100.equals("EnterMethod") == false) goto L119;
        r102 = 29;
        goto L120
    L33:
        if (r100.equals("EnterAction") == false) goto L119;
        r102 = 28;
        goto L120
    L36:
        if (r100.equals("FirstFrameVideoBuffer") == false) goto L119;
        r102 = 14;
        goto L120
    L39:
        if (r100.equals("IsPreview") == false) goto L119;
        r102 = 7;
        goto L120
    L42:
        if (r100.equals("StallTotalCount") == false) goto L119;
        r102 = 5;
        goto L120
    L45:
        if (r100.equals("DownloadSpeed") == false) goto L119;
        r102 = 19;
        goto L120
    L48:
        if (r100.equals("FirstFrameAudioBuffer") == false) goto L119;
        r102 = HTTP.CR;
        goto L120
    L51:
        if (r100.equals("RetryTotalCount") == false) goto L119;
        r102 = 6;
        goto L120
    L54:
        if (r100.equals("FirstFrameDownloadSpeed") == false) goto L119;
        r102 = 15;
        goto L120
    L57:
        if (r100.equals("EndTs") == false) goto L119;
        r102 = 10;
        goto L120
    L60:
        if (r100.equals("FPS") == false) goto L119;
        r102 = 20;
        goto L120
    L63:
        if (r100.equals("302") == false) goto L119;
        r102 = 2;
        goto L120
    L66:
        if (r100.equals("Success") == false) goto L119;
        r102 = 1;
        goto L120
    L69:
        if (r100.equals("StartTs") == false) goto L119;
        r102 = 8;
        goto L120
    L72:
        if (r100.equals("StallType") == false) goto L119;
        r102 = 4;
        goto L120
    L75:
        if (r100.equals("StallTime") == false) goto L119;
        r102 = 9;
        goto L120
    L78:
        if (r100.equals("StallSeries") == false) goto L119;
        r102 = 21;
        goto L120
    L81:
        if (r100.equals("AudioBufferList") == false) goto L119;
        r102 = 23;
        goto L120
    L84:
        if (r100.equals("RenderVideoSeries") == false) goto L119;
        r102 = 24;
        goto L120
    L87:
        if (r100.equals("Network") == false) goto L119;
        r102 = 32;
        goto L120
    L90:
        if (r100.equals("ConnectCost") == false) goto L119;
        r102 = 3;
        goto L120
    L93:
        if (r100.equals("Protocol") == false) goto L119;
        r102 = 31;
        goto L120
    L96:
        if (r100.equals("StopTimestamp") == false) goto L119;
        r102 = 17;
        goto L120
    L99:
        if (r100.equals("BufferDataSeconds") == false) goto L119;
        r102 = 36;
        goto L120
    L102:
        if (r100.equals("StreamSuffix") == false) goto L119;
        r102 = 27;
        goto L120
    L105:
        if (r100.equals("RenderAudioSeries") == false) goto L119;
        r102 = 25;
        goto L120
    L108:
        if (r100.equals("NeptuneName") == false) goto L119;
        r102 = 26;
        goto L120
    L111:
        if (r100.equals("SessionID") == false) goto L119;
        r102 = 30;
        goto L120
    L114:
        if (r100.equals(UserChangedCallback.CHANGE_TYPE_UPDATE) == false) goto L119;
        r102 = 33;
        goto L120
    L117:
        if (r100.equals("Duration") == false) goto L119;
        r102 = 11;
        goto L120
    }
}
