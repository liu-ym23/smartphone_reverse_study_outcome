package com.ss.ttvideoengine.log;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.SieveCacheKt;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.vcloud.networkpredictor.ISpeedPredictor;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.strategrycenter.StrategyCenter;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.HashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoEventAbrEvent {
    private static final String TAG = "VideoEventAbrEvent";
    public static final String monitorName = "videoplayer_abrswitch";
    public VideoEventBase mEventBase;
    private ArrayList<EventContext> mEventContexts;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.log.VideoEventAbrEvent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AsyncGetLogDataRunnable implements Runnable {
        private Context rContext;
        private VideoEventAbrEvent rEvent;
        private VideoEventBase rEventBase;
        private EventContext rEventContext;
        private Handler rHandler;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_log_VideoEventAbrEvent$AsyncGetLogDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_log_VideoEventAbrEvent$AsyncGetLogDataRunnable__run$___twin___() {
            VideoEventAbrEvent r100 = this.rEvent;
            if (r100 != null) goto L5;
            return;
        L5:
            VideoEventBase r101 = this.rEventBase;
            if (r101 != null) goto L8;
        L10:
            final boolean r102 = false;
        L11:
            final JSONObject r103 = VideoEventAbrEvent.access$100(r100, this.rEventContext, r101);
            Handler r104 = this.rHandler;
            if (r104 != null) goto L14;
        L18:
            VideoEventManager.instance.addEventV2(r102, r103, VideoEventAbrEvent.monitorName);
            return;
        L14:
            if (r104.getLooper() == null) goto L18;
            this.rHandler.post(new AnonymousClass1(this, r102, r103));
            return;
        L8:
            if (r101.isUploadLogEnabled == false) goto L10;
            r102 = true;
            goto L11
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_log_VideoEventAbrEvent$AsyncGetLogDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(AsyncGetLogDataRunnable r100) {
            r100.com_ss_ttvideoengine_log_VideoEventAbrEvent$AsyncGetLogDataRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public AsyncGetLogDataRunnable(Context r100, VideoEventAbrEvent r101, VideoEventBase r102, EventContext r103) {
            this.rEvent = r101;
            this.rEventBase = r102;
            this.rContext = r100;
            this.rEventContext = r103;
            this.rHandler = new Handler(Looper.getMainLooper());
        }
    }

    public class EventContext {
        public String mAbrV;
        public long mAudioBufferLen;
        public long mCostTime;
        public long mDelayTime;
        public String mEndType;
        public long mEventTime;
        public long mMaxBufferLen;
        public long mNewBr;
        public long mOldBr;
        public int mReason;
        public float mSpeed;
        public int mSwitch2new;
        public long mVideoBufferLen;
        public long mWasteByte;
        final /* synthetic */ VideoEventAbrEvent this$0;

        private EventContext(VideoEventAbrEvent r100) {
            this.this$0 = r100;
            this.mEventTime = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mCostTime = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mEndType = "";
            this.mAbrV = "";
            this.mOldBr = -1;
            this.mNewBr = -1;
            this.mMaxBufferLen = -1;
            this.mAudioBufferLen = -1;
            this.mVideoBufferLen = -1;
            this.mSpeed = -1.0f;
            this.mDelayTime = -1;
            this.mWasteByte = -1;
            this.mSwitch2new = 0;
            this.mReason = -1;
        }

        public /* synthetic */ EventContext(VideoEventAbrEvent r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public void reset() {
        this.mEventContexts.clear();
    }

    public VideoEventAbrEvent(VideoEventBase r100) {
        this.mEventContexts = new ArrayList();
        this.mEventBase = r100;
    }

    public void abrSwitchEnd(long r100) {
        if (this.mEventContexts != null) goto L5;
        return;
    L5:
        EventContext r101 = null;
    L7:
        if (this.mEventContexts.isEmpty() == true) goto L12;
        r101 = (EventContext) ListProtector.remove(this.mEventContexts, 0);
        if (r101 == null) goto L7;
        if (r101.mNewBr != r100) goto L7;
    L12:
        if (r101 != null) goto L14;
        return;
    L14:
        TTVideoEngineLog.d(TAG, "abrSwitchEnd");
        r101.mSwitch2new = (int) this.mEventBase.mDataSource.getLogValueLong(106);
        r101.mDelayTime = this.mEventBase.mDataSource.getLogValueLong(107);
        r101.mCostTime = System.currentTimeMillis() - r101.mEventTime;
        sendAbrSwitchEvent(r101);
    }

    public void sendAbrSwitchEvent(EventContext r100) {
        this.mEventBase.updateVideoInfo(null);
        VideoEventBase r101 = this.mEventBase;
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(r101.mContext, this, r101, r100));
    }

    private JSONObject toJsonObject(EventContext r100, VideoEventBase r101) {
        HashMap r102 = new HashMap();
        if (r101 == null) goto L5;
        LoggerUtils.putToMap(r102, "player_sessionid", r101.mSessionID);
        LoggerUtils.putToMap(r102, BaseSwitches.V, r101.mVid);
        LoggerUtils.putToMap(r102, BackupSeiMessage.SOURCE_PC, r101.f457072pc);
        LoggerUtils.putToMap(r102, com.alipay.sdk.m.s.a.f25762t, r101.f457074sv);
        LoggerUtils.putToMap(r102, "sdk_version", r101.sdk_version);
        LoggerUtils.putToMap(r102, "vtype", r101.vtype);
    L5:
        LoggerUtils.putToMap(r102, "abrv", r100.mAbrV);
        LoggerUtils.putToMap(r102, HiAnalyticsConstant.BI_KEY_COST_TIME, r100.mCostTime);
        LoggerUtils.putToMap(r102, "pr_time", r100.mEventTime);
        LoggerUtils.putToMap(r102, "end_type", r100.mEndType);
        LoggerUtils.putToMap(r102, "old_br", r100.mOldBr);
        LoggerUtils.putToMap(r102, "new_br", r100.mNewBr);
        LoggerUtils.putToMap(r102, "max_buf", r100.mMaxBufferLen);
        LoggerUtils.putToMap(r102, "abuf", r100.mAudioBufferLen);
        LoggerUtils.putToMap(r102, "vbuf", r100.mVideoBufferLen);
        LoggerUtils.putToMap(r102, "netspeed", r100.mSpeed);
        LoggerUtils.putToMap(r102, "delaytime", r100.mDelayTime);
        LoggerUtils.putToMap(r102, "tonew", r100.mSwitch2new);
        LoggerUtils.putToMap(r102, "reason", r100.mReason);
        TTVideoEngineLog.d(TAG, "AbrSwitch:" + r102.toString());
        return new JSONObject(r102);
    }

    public void abrSwitchStart(long r100, long r101) {
        TTVideoEngineLog.d(TAG, "abrSwitchStart");
        EventContext r102 = new EventContext(this, null);
        r102.mEventTime = System.currentTimeMillis();
        r102.mAbrV = this.mEventBase.mDataSource.getLogValueStr(102);
        r102.mOldBr = r100;
        r102.mNewBr = r101;
        r102.mMaxBufferLen = this.mEventBase.mDataSource.getLogValueInt(103);
        r102.mAudioBufferLen = this.mEventBase.mDataSource.getLogValueLong(104);
        r102.mVideoBufferLen = this.mEventBase.mDataSource.getLogValueLong(105);
        r102.mReason = this.mEventBase.mDataSource.getLogValueInt(109);
        ISpeedPredictor r103 = StrategyCenter.sNetAbrSpeedPredictor;
        if (r103 == null) goto L5;
        r102.mSpeed = r103.getPredictSpeed(0);
    L5:
        this.mEventContexts.add(r102);
    }

    public static /* synthetic */ JSONObject access$100(VideoEventAbrEvent r100, EventContext r101, VideoEventBase r102) {
        return r100.toJsonObject(r101, r102);
    }
}
