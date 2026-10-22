package com.ss.bytertc.engine;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.bytertc.engine.aigc.IRTCRoomEventHandlerAIGC;
import com.ss.bytertc.engine.audio.IRangeAudio;
import com.ss.bytertc.engine.audio.ISpatialAudio;
import com.ss.bytertc.engine.data.ForwardStreamInfo;
import com.ss.bytertc.engine.data.RemoteVideoConfig;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.data.SimulcastStreamType;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandler;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandlerEx;
import com.ss.bytertc.engine.handler.IRTSRoomEventHandler;
import com.ss.bytertc.engine.handler.RTCRoomEventHandler;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerAIGC;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerEx;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerRts;
import com.ss.bytertc.engine.type.AudioSelectionPriority;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.MessageConfig;
import com.ss.bytertc.engine.type.SubtitleConfig;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IPanoramicVideo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class RTCRoomImpl extends RTCRoomEx {
    protected static final String TAG = "RtcRoom";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    protected long mNativeRtcRoom;
    private long mNativeRtcRoomEventHandler;
    private long mNativeRtcRoomEventHandlerAIGC;
    private long mNativeRtcRoomEventHandlerEx;
    private long mNativeRtcRoomEventHandlerRts;
    private NativePanoramicVideo mPanoramicVideo;
    private NativeRangeAudio mRangeAudio;
    private final ReentrantReadWriteLock mReadWriteLock;
    private String mRoom;
    protected int mRtcRoomCount;
    private RTCRoomEventHandler mRtcRoomEventHandler;
    private RTCRoomEventHandlerAIGC mRtcRoomEventHandlerAIGC;
    private RTCRoomEventHandlerEx mRtcRoomEventHandlerEx;
    private RTCRoomEventHandlerRts mRtcRoomEventHandlerRts;
    private IRTCRoomEventHandler mRtcRoomHandler;
    private IRTCRoomEventHandlerAIGC mRtcRoomHandlerAIGC;
    private IRTCRoomEventHandlerEx mRtcRoomHandlerEx;
    private IRTSRoomEventHandler mRtcRoomHandlerRts;
    private NativeSpatialAudio mSpatialAudio;
    private String mUser;

    public void addRtcRoomCount() {
        this.mRtcRoomCount++;
    }

    @Override // com.ss.bytertc.engine.RTCRoom, com.ss.bytertc.engine.RTSRoom
    public void destroy() {
        LogUtil.d(TAG, "Destroy ");
        this.mJniWriteLock.lock();
        int r100 = this.mRtcRoomCount - 1;
        this.mRtcRoomCount = r100;
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L28
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, Destroy failed.");     // Catch: Throwable -> L28
        this.mJniWriteLock.unlock();
        return;
    L8:
        if (r100 > 0) goto L10;
        this.mNativeRtcRoom = 0;     // Catch: Throwable -> L28
    L10:
        NativeRangeAudio r102 = this.mRangeAudio;     // Catch: Throwable -> L28
        if ((r102 instanceof NativeRangeAudio) == false) goto L13;
        r102.destroy();     // Catch: Throwable -> L28
    L13:
        NativeSpatialAudio r103 = this.mSpatialAudio;     // Catch: Throwable -> L28
        if ((r103 instanceof NativeSpatialAudio) == false) goto L16;
        r103.destroy();     // Catch: Throwable -> L28
    L16:
        this.mJniWriteLock.unlock();
        NativeRTCRoomFunctions.nativeDestory(r101);
        if (this.mRtcRoomCount > 0) goto L32;
        long r104 = this.mNativeRtcRoomEventHandlerEx;
        if (r104 == 0) goto L21;
        NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerEx(r104);
        this.mNativeRtcRoomEventHandlerEx = 0;
    L21:
        long r105 = this.mNativeRtcRoomEventHandler;
        if (r105 == 0) goto L24;
        NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandler(r105);
        this.mNativeRtcRoomEventHandler = 0;
    L24:
        long r106 = this.mNativeRtcRoomEventHandlerAIGC;
        if (r106 == 0) goto L33;
        NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerAIGC(r106);
        this.mNativeRtcRoomEventHandlerAIGC = 0;
        return;
    L33:
        return;
    L32:
        return;
    L28:
        th = move-exception;
        this.mJniWriteLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public IPanoramicVideo getPanoramicVideo() {
        LogUtil.d(TAG, "getPanoramicVideo...");
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L17
        NativePanoramicVideo r101 = null;
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, getPanoramicVideo failed.");     // Catch: Throwable -> L17
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        NativePanoramicVideo r102 = this.mPanoramicVideo;     // Catch: Throwable -> L17
        if (r102 == null) goto L12;
        this.mJniReadLock.unlock();
        return r102;
    L12:
        long r103 = NativeRTCRoomFunctions.nativeGetPanoramicVideo(r100);     // Catch: Throwable -> L17
        if (r103 != 0) goto L15;
        LogUtil.e(TAG, "getPanoramicVideo failed");     // Catch: Throwable -> L17
        goto L6
    L15:
        r101 = new NativePanoramicVideo(r103);     // Catch: Throwable -> L17
        this.mPanoramicVideo = r101;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public IRangeAudio getRangeAudio() {
        LogUtil.d(TAG, "getRangeAudio...");
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L17
        NativeRangeAudio r101 = null;
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, getRangeAudio failed.");     // Catch: Throwable -> L17
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        NativeRangeAudio r102 = this.mRangeAudio;     // Catch: Throwable -> L17
        if (r102 == null) goto L12;
        this.mJniReadLock.unlock();
        return r102;
    L12:
        long r103 = NativeRTCRoomFunctions.nativeGetRangeAudio(r100);     // Catch: Throwable -> L17
        if (r103 != 0) goto L15;
        LogUtil.e(TAG, "getRangeAudio failed");     // Catch: Throwable -> L17
        goto L6
    L15:
        r101 = new NativeRangeAudio(r103);     // Catch: Throwable -> L17
        this.mRangeAudio = r101;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public String getRoomId() {
        LogUtil.d(TAG, "getRoomId");
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, getRoomId failed.");     // Catch: Throwable -> L10
        String r101 = "";
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeRTCRoomFunctions.nativeGetRoomId(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public ISpatialAudio getSpatialAudio() {
        LogUtil.d(TAG, "getSpatialAudio...");
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L17
        NativeSpatialAudio r101 = null;
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, getSpatialAudio failed.");     // Catch: Throwable -> L17
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        NativeSpatialAudio r102 = this.mSpatialAudio;     // Catch: Throwable -> L17
        if (r102 == null) goto L12;
        this.mJniReadLock.unlock();
        return r102;
    L12:
        long r103 = NativeRTCRoomFunctions.nativeGetSpatialAudio(r100);     // Catch: Throwable -> L17
        if (r103 != 0) goto L15;
        LogUtil.e(TAG, "getSpatialAudio failed");     // Catch: Throwable -> L17
        goto L6
    L15:
        r101 = new NativeSpatialAudio(r103);     // Catch: Throwable -> L17
        this.mSpatialAudio = r101;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int leaveRoom() {
        LogUtil.d(TAG, "leaveChannel");
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, leaveChannel failed.");     // Catch: Throwable -> L10
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        this.mRoom = "";     // Catch: Throwable -> L10
        this.mUser = "";     // Catch: Throwable -> L10
        r101 = NativeRTCRoomFunctions.nativeLeaveRoom(r100, "");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int pauseForwardStreamToAllRooms() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, pauseForwardStreamToAllRooms failed.");     // Catch: Throwable -> L10
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeRTCRoomFunctions.nativePauseForwardStreamToAllRooms(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int resumeForwardStreamToAllRooms() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, resumeForwardStreamToAllRooms failed.");     // Catch: Throwable -> L10
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeRTCRoomFunctions.nativeResumeForwardStreamToAllRooms(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int stopForwardStreamToRooms() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, stopForwardStreamToRooms failed.");     // Catch: Throwable -> L10
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeRTCRoomFunctions.nativeStopForwardStreamToRooms(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int stopSubtitle() {
        this.mJniReadLock.lock();
        LogUtil.d(TAG, "stopSubtitle");     // Catch: Throwable -> L10
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, stopSubtitle failed.");     // Catch: Throwable -> L10
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeRTCRoomFunctions.nativeStopSubtitle(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int pauseAllSubscribedStreamAudio() {
        LogUtil.d(TAG, "pauseAllSubscribedStreamAudio...");
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, pauseAllSubscribedStreamAudio failed.");     // Catch: Throwable -> L10
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeRTCRoomFunctions.nativePauseAllSubscribedStreamAudio(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int pauseAllSubscribedStreamVideo() {
        LogUtil.d(TAG, "pauseAllSubscribedStreamVideo...");
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, pauseAllSubscribedStreamVideo failed.");     // Catch: Throwable -> L10
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeRTCRoomFunctions.nativePauseAllSubscribedStreamVideo(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int resumeAllSubscribedStreamAudio() {
        LogUtil.d(TAG, "resumeAllSubscribedStreamAudio...");
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, resumeAllSubscribedStreamAudio failed.");     // Catch: Throwable -> L10
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeRTCRoomFunctions.nativeResumeAllSubscribedStreamAudio(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int resumeAllSubscribedStreamVideo() {
        LogUtil.d(TAG, "resumeAllSubscribedStreamVideo...");
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, resumeAllSubscribedStreamVideo failed.");     // Catch: Throwable -> L10
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeRTCRoomFunctions.nativeResumeAllSubscribedStreamVideo(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    public long getNativeHandle() {
        return this.mNativeRtcRoom;
    }

    public IRTCRoomEventHandler getRtcRoomHandler() {
        return this.mRtcRoomHandler;
    }

    public IRTCRoomEventHandlerAIGC getRtcRoomHandlerAIGC() {
        return this.mRtcRoomHandlerAIGC;
    }

    public IRTCRoomEventHandlerEx getRtcRoomHandlerEx() {
        return this.mRtcRoomHandlerEx;
    }

    public IRTSRoomEventHandler getRtcRoomHandlerRts() {
        return this.mRtcRoomHandlerRts;
    }

    public String getmRoom() {
        return this.mRoom;
    }

    public String getmUser() {
        return this.mUser;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int enableSubscribeLocalStream(boolean r100) {
        LogUtil.d(TAG, "enableSubscribeLocalStream: " + r100);
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, EnableSubscribeLocalStream failed.");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativeEnableSubscribeLocalStream(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int leaveRoom(String r100) {
        LogUtil.d(TAG, "leaveChannel");
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, leaveChannel failed.");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        this.mRoom = "";     // Catch: Throwable -> L10
        this.mUser = "";     // Catch: Throwable -> L10
        r102 = NativeRTCRoomFunctions.nativeLeaveRoom(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int publishScreenAudio(boolean r100) {
        LogUtil.d(TAG, "publishScreenAudio");
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid,publishScreenAudio failed.\"");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativePublishScreenAudio(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int publishScreenVideo(boolean r100) {
        LogUtil.d(TAG, "publishScreenVideo");
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid,publishScreenVideo failed.\"");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativePublishScreenVideo(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int publishStreamAudio(boolean r100) {
        LogUtil.d(TAG, "publishStreamAudio");
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid,publishStreamAudio failed.\"");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativePublishStreamAudio(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int publishStreamVideo(boolean r100) {
        LogUtil.d(TAG, "publishStreamVideo");
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid,publishStreamVideo failed.\"");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativePublishStreamVideo(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public long sendRoomBinaryMessage(byte[] r100) {
        LogUtil.d(TAG, "SendRoomBinaryMessage ");
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, SendRoomBinaryMessage failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        long r102 = NativeRTCRoomFunctions.nativeSendRoomBinaryMessage(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public long sendRoomMessage(String r100) {
        LogUtil.d(TAG, "SendRoomMessage ");
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, SendRoomMessage failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        long r102 = NativeRTCRoomFunctions.nativeSendRoomMessage(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setAudioSelectionConfig(AudioSelectionPriority r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, setAudioSelectionConfig failed.");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativeSetAudioSelectionConfig(r101, r100.value());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setMultiDeviceAVSync(String r100) {
        LogUtil.d(TAG, "setMultiDeviceAVSync ");
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, setMultiDeviceAVSync failed.");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativeSetMultiDeviceAVSync(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setRTCRoomEventHandler(IRTCRoomEventHandler r100) {
        this.mJniReadLock.lock();
    L13:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeRtcRoom != 0) goto L8;
        LogUtil.e(TAG, "native room is invalid, setRTCRoomEventHandler failed.");     // Catch: Throwable -> L13
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L13
        this.mJniReadLock.unlock();
        return r101;
    L8:
        this.mRtcRoomHandler = r100;     // Catch: Throwable -> L13
        RTCRoomEventHandler r102 = new RTCRoomEventHandler(this);     // Catch: Throwable -> L13
        this.mRtcRoomEventHandler = r102;     // Catch: Throwable -> L13
        long r103 = this.mNativeRtcRoomEventHandler;     // Catch: Throwable -> L13
        this.mNativeRtcRoomEventHandler = NativeRTCRoomFunctions.nativeSetRTCRoomEventHandler(this.mNativeRtcRoom, r102);     // Catch: Throwable -> L13
        if (r103 == 0) goto L11;
        NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandler(r103);     // Catch: Throwable -> L13
    L11:
        this.mJniReadLock.unlock();
        return 0;
    }

    public int setRTCRoomEventHandlerAIGC(IRTCRoomEventHandlerAIGC r100) {
        this.mJniReadLock.lock();
    L13:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeRtcRoom != 0) goto L8;
        LogUtil.e(TAG, "native room is invalid, setRTCRoomEventHandlerAIGC failed.");     // Catch: Throwable -> L13
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L13
        this.mJniReadLock.unlock();
        return r101;
    L8:
        this.mRtcRoomHandlerAIGC = r100;     // Catch: Throwable -> L13
        RTCRoomEventHandlerAIGC r102 = new RTCRoomEventHandlerAIGC(this);     // Catch: Throwable -> L13
        this.mRtcRoomEventHandlerAIGC = r102;     // Catch: Throwable -> L13
        long r103 = this.mNativeRtcRoomEventHandlerAIGC;     // Catch: Throwable -> L13
        this.mNativeRtcRoomEventHandlerAIGC = NativeRTCRoomFunctions.nativeSetRTCRoomEventHandlerAIGC(this.mNativeRtcRoom, r102);     // Catch: Throwable -> L13
        if (r103 == 0) goto L11;
        NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerAIGC(r103);     // Catch: Throwable -> L13
    L11:
        this.mJniReadLock.unlock();
        return 0;
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int setRTCRoomEventHandlerEx(IRTCRoomEventHandlerEx r100) {
        this.mJniReadLock.lock();
    L13:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeRtcRoom != 0) goto L8;
        LogUtil.e(TAG, "native room is invalid, setRTCRoomEventHandler failed.");     // Catch: Throwable -> L13
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L13
        this.mJniReadLock.unlock();
        return r101;
    L8:
        this.mRtcRoomHandlerEx = r100;     // Catch: Throwable -> L13
        RTCRoomEventHandlerEx r102 = new RTCRoomEventHandlerEx(this);     // Catch: Throwable -> L13
        this.mRtcRoomEventHandlerEx = r102;     // Catch: Throwable -> L13
        long r103 = this.mNativeRtcRoomEventHandlerEx;     // Catch: Throwable -> L13
        this.mNativeRtcRoomEventHandlerEx = NativeRTCRoomFunctions.nativeSetRTCRoomEventHandlerEx(this.mNativeRtcRoom, r102);     // Catch: Throwable -> L13
        if (r103 == 0) goto L11;
        NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerEx(r103);     // Catch: Throwable -> L13
    L11:
        this.mJniReadLock.unlock();
        return 0;
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int setRTSRoomEventHandler(IRTSRoomEventHandler r100) {
        this.mJniReadLock.lock();
        return 0;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setRemoteRoomAudioPlaybackVolume(int r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, setRemoteRoomAudioPlaybackVolume failed.");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativeSetRemoteRoomAudioPlaybackVolume(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setUserVisibility(boolean r100) {
        LogUtil.d(TAG, "setUserVisibility. enable : " + r100);
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native engine is invalid, setUserVisibility failed.");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativeSetUserVisibility(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int startForwardStreamToRooms(List<ForwardStreamInfo> r100) {
        this.mJniReadLock.lock();
    L16:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeRtcRoom != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, startForwardStreamToRooms failed.");     // Catch: Throwable -> L16
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L16
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        if (r100 != null) goto L10;
        r101 = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();     // Catch: Throwable -> L16
        goto L6
    L10:
        LinkedList r102 = new LinkedList();     // Catch: Throwable -> L16
        Iterator<ForwardStreamInfo> r103 = r100.iterator();     // Catch: Throwable -> L16
    L12:
        if (r103.hasNext() == false) goto L14;
        r102.add(new InternalForwardStreamInfo(r103.next()));     // Catch: Throwable -> L16
        goto L12
    L14:
        r101 = NativeRTCRoomFunctions.nativeStartForwardStreamToRooms(this.mNativeRtcRoom, r102);     // Catch: Throwable -> L16
        goto L6
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int startSubtitle(SubtitleConfig r100) {
        this.mJniReadLock.lock();
        LogUtil.d(TAG, "startSubtitle");     // Catch: Throwable -> L12
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L12
        if (r101 == 0) goto L10;
        if (r100 == null) goto L10;
        int r102 = NativeRTCRoomFunctions.nativeStartSubtitle(r101, r100.mode.value(), r100.targetLanguage);     // Catch: Throwable -> L12
    L8:
        this.mJniReadLock.unlock();
        return r102;
    L10:
        LogUtil.e(TAG, "native rtcroom or config is invalid, startSubtitle failed.");     // Catch: Throwable -> L12
        r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeAllStreamsAudio(boolean r100) {
        LogUtil.d(TAG, "subscribeAllStreamsAudio, subscribe:" + r100);
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native engine is invalid, subscribeAllStreamsAudio failed.");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativeSubscribeAllStreamsAudio(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeAllStreamsVideo(boolean r100) {
        LogUtil.d(TAG, "subscribeAllStreamsVideo, subscribe:" + r100);
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native engine is invalid, subscribeAllStreamsVideo failed.");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativeSubscribeAllStreamsVideo(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int updateForwardStreamToRooms(List<ForwardStreamInfo> r100) {
        this.mJniReadLock.lock();
    L16:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeRtcRoom != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, updateForwardStreamToRooms failed.");     // Catch: Throwable -> L16
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L16
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        if (r100 != null) goto L10;
        r101 = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();     // Catch: Throwable -> L16
        goto L6
    L10:
        LinkedList r102 = new LinkedList();     // Catch: Throwable -> L16
        Iterator<ForwardStreamInfo> r103 = r100.iterator();     // Catch: Throwable -> L16
    L12:
        if (r103.hasNext() == false) goto L14;
        r102.add(new InternalForwardStreamInfo(r103.next()));     // Catch: Throwable -> L16
        goto L12
    L14:
        r101 = NativeRTCRoomFunctions.nativeUpdateForwardStreamToRooms(this.mNativeRtcRoom, r102);     // Catch: Throwable -> L16
        goto L6
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int updateToken(String r100) {
        LogUtil.d(TAG, "updateToken. token : " + r100);
        this.mJniReadLock.lock();
        long r101 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, updateToken failed.");     // Catch: Throwable -> L10
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeRTCRoomFunctions.nativeUpdateToken(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    public RTCRoomImpl(String r100, long r101) {
        this.mNativeRtcRoom = 0;
        this.mRtcRoomCount = 0;
        this.mRtcRoomHandlerAIGC = null;
        this.mRtcRoomEventHandlerAIGC = null;
        this.mNativeRtcRoomEventHandler = 0;
        this.mNativeRtcRoomEventHandlerEx = 0;
        this.mNativeRtcRoomEventHandlerRts = 0;
        this.mNativeRtcRoomEventHandlerAIGC = 0;
        this.mRangeAudio = null;
        this.mSpatialAudio = null;
        this.mPanoramicVideo = null;
        ReentrantReadWriteLock r102 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r102;
        this.mJniReadLock = r102.readLock();
        this.mJniWriteLock = r102.writeLock();
        this.mNativeRtcRoom = r101;
        this.mRoom = r100;
        this.mRtcRoomCount = 1;
    }

    public static String getCloudRenderingInfo(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("action", r100);     // Catch: Exception -> L6
        r102.put("externalService", ChameleonOpenTracker.Stage.RENDER);     // Catch: Exception -> L6
        r102.put("renderMeta", r101);     // Catch: Exception -> L6
        return r102.toString();
    L6:
        e = move-exception;
        LogUtil.e(TAG, "getCloudRenderingInfo catch exception , e : " + e.getMessage());
        return null;
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int joinRTSRoom(String r100, UserInfo r101) {
        StringBuilder r102 = new StringBuilder("joinRoom with token: ");
        r102.append(r100);
        r102.append(",room");
        r102.append(this.mRoom);
        r102.append(" and uid: ");
        if (r101 != null) goto L5;
        String r103 = "";
    L6:
        r102.append(r103);
        LogUtil.d(TAG, r102.toString());
        this.mJniReadLock.lock();
        return -1;
    L5:
        r103 = r101.getUid();
        goto L6
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int publishStream(StreamIndex r100, MediaStreamType r101) {
        LogUtil.d(TAG, "publishStream: " + r100);
        this.mJniReadLock.lock();
        long r102 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, publishStream failed.\"");     // Catch: Throwable -> L10
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r103;
    L8:
        r103 = NativeRTCRoomFunctions.nativePublishStreamEx(r102, r100.value(), r101.value);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int setRemoteSimulcastStreamType(String r100, SimulcastStreamType r101) {
        LogUtil.d(TAG, "setRemoteSimulcastStreamType");
        this.mJniReadLock.lock();
        long r102 = this.mNativeRtcRoom;     // Catch: Throwable -> L12
        if (r102 == 0) goto L10;
        if (r101 == null) goto L10;
        int r103 = NativeRTCRoomFunctions.nativeSetRemoteSimulcastStreamType(r102, r100, r101.value());     // Catch: Throwable -> L12
    L8:
        this.mJniReadLock.unlock();
        return r103;
    L10:
        LogUtil.e(TAG, "native rtcroom is invalid,setRemoteSimulcastStreamType  failed.\"");     // Catch: Throwable -> L12
        r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public long setRoomExtraInfo(String r100, String r101) {
        this.mJniReadLock.lock();
        if (r100 != null) goto L6;
        this.mJniReadLock.unlock();
        return -2;
    L6:
        if (r101 != null) goto L20;
        this.mJniReadLock.unlock();
        return -3;
    L20:
        LogUtil.d(TAG, "setRoomExtraInfo,key : " + r100 + ", value" + r101);     // Catch: Throwable -> L17
        long r102 = this.mNativeRtcRoom;     // Catch: Throwable -> L17
        if (r102 != 0) goto L14;
        LogUtil.e(TAG, "native rtcroom is invalid, setRoomExtraInfo failed.");     // Catch: Throwable -> L17
        this.mJniReadLock.unlock();
        return -1;
    L14:
        long r103 = NativeRTCRoomFunctions.nativeSetRoomExtraInfo(r102, r100, r101);     // Catch: Throwable -> L17
        this.mJniReadLock.unlock();
        return r103;
    L17:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int startForwardStreamToRooms(List<ForwardStreamInfo> r100, String r101) {
        this.mJniReadLock.lock();
    L16:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeRtcRoom != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, startForwardStreamToRooms WithRoomGroupId failed.");     // Catch: Throwable -> L16
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L16
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        if (r100 != null) goto L10;
        r102 = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();     // Catch: Throwable -> L16
        goto L6
    L10:
        LinkedList r103 = new LinkedList();     // Catch: Throwable -> L16
        Iterator<ForwardStreamInfo> r104 = r100.iterator();     // Catch: Throwable -> L16
    L12:
        if (r104.hasNext() == false) goto L14;
        r103.add(new InternalForwardStreamInfo(r104.next()));     // Catch: Throwable -> L16
        goto L12
    L14:
        r102 = NativeRTCRoomFunctions.nativeStartForwardStreamToRoomsWithRoomGroupId(this.mNativeRtcRoom, r103, r101);     // Catch: Throwable -> L16
        goto L6
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeScreenAudio(String r100, boolean r101) {
        LogUtil.d(TAG, "subscribeScreenAudio: userId: " + r100 + ", subscribe: " + r101);
        this.mJniReadLock.lock();
        long r102 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, subscribeScreenAudio failed.\"");     // Catch: Throwable -> L10
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r103;
    L8:
        r103 = NativeRTCRoomFunctions.nativeSubscribeScreenAudio(r102, r100, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeScreenVideo(String r100, boolean r101) {
        LogUtil.d(TAG, "subscribeScreenVideo: userId: " + r100 + ", subscribe: " + r101);
        this.mJniReadLock.lock();
        long r102 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, subscribeScreenVideo failed.\"");     // Catch: Throwable -> L10
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r103;
    L8:
        r103 = NativeRTCRoomFunctions.nativeSubscribeScreenVideo(r102, r100, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeStreamAudio(String r100, boolean r101) {
        LogUtil.d(TAG, "subscribeStreamAudio: userId: " + r100 + ", subscribe: " + r101);
        this.mJniReadLock.lock();
        long r102 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, subscribeStreamAudio failed.\"");     // Catch: Throwable -> L10
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r103;
    L8:
        r103 = NativeRTCRoomFunctions.nativeSubscribeStreamAudio(r102, r100, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int subscribeStreamVideo(String r100, boolean r101) {
        LogUtil.d(TAG, "subscribeStreamVideo: userId: " + r100 + ", subscribe: " + r101);
        this.mJniReadLock.lock();
        long r102 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, subscribeStreamVideo failed.\"");     // Catch: Throwable -> L10
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r103;
    L8:
        r103 = NativeRTCRoomFunctions.nativeSubscribeStreamVideo(r102, r100, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int unpublishStream(StreamIndex r100, MediaStreamType r101) {
        LogUtil.d(TAG, "unpublishStream: " + r100);
        this.mJniReadLock.lock();
        long r102 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, unpublishStream failed.\"");     // Catch: Throwable -> L10
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r103;
    L8:
        r103 = NativeRTCRoomFunctions.nativeUnpublishStreamEx(r102, r100.value(), r101.value);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int updateForwardStreamToRooms(List<ForwardStreamInfo> r100, String r101) {
        this.mJniReadLock.lock();
    L16:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeRtcRoom != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, updateForwardStreamToRooms  WithRoomGroupId failed.");     // Catch: Throwable -> L16
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L16
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        if (r100 != null) goto L10;
        r102 = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();     // Catch: Throwable -> L16
        goto L6
    L10:
        LinkedList r103 = new LinkedList();     // Catch: Throwable -> L16
        Iterator<ForwardStreamInfo> r104 = r100.iterator();     // Catch: Throwable -> L16
    L12:
        if (r104.hasNext() == false) goto L14;
        r103.add(new InternalForwardStreamInfo(r104.next()));     // Catch: Throwable -> L16
        goto L12
    L14:
        r102 = NativeRTCRoomFunctions.nativeUpdateForwardStreamToRoomsWithRoomGroupId(this.mNativeRtcRoom, r103, r101);     // Catch: Throwable -> L16
        goto L6
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public long sendControlBinaryMessage(String r100, String r101, byte[] r102) {
        LogUtil.d(TAG, "sendControlBinaryMessage. type : " + r100 + ", action : " + r101 + ", message length:" + r102.length);
        this.mJniReadLock.lock();
        long r103 = this.mNativeRtcRoom;     // Catch: Throwable -> L11
        if (r103 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, sendControlBinaryMessage failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        long r104 = NativeRTCRoomFunctions.nativeSendControlBinaryMessage(r103, r100, r101, r102);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r104;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public long sendUserBinaryMessage(String r100, byte[] r101, MessageConfig r102) {
        LogUtil.d(TAG, "SendUserBinaryMessage. uid : " + r100 + ", message length:" + r101.length);
        this.mJniReadLock.lock();
        long r103 = this.mNativeRtcRoom;     // Catch: Throwable -> L11
        if (r103 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, SendUserBinaryMessage failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        long r104 = NativeRTCRoomFunctions.nativeSendUserBinaryMessage(r103, r100, r101, r102.value());     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r104;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public long sendUserMessage(String r100, String r101, MessageConfig r102) {
        LogUtil.d(TAG, "SendUserMessage. uid : " + r100 + ", message" + r101);
        this.mJniReadLock.lock();
        long r103 = this.mNativeRtcRoom;     // Catch: Throwable -> L11
        if (r103 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, SendUserMessage failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        long r104 = NativeRTCRoomFunctions.nativeSendUserMessage(r103, r100, r101, r102.value());     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r104;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int setRemoteVideoConfig(String r110, StreamIndex r111, RemoteVideoConfig r112) {
        LogUtil.d(TAG, "setRemoteVideoConfig: userId: " + r110 + ", streamIndex: " + r111);
        this.mJniReadLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, setRemoteVideoConfig failed.\"");     // Catch: Throwable -> L10
        int r113 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r113;
    L8:
        r113 = NativeRTCRoomFunctions.nativeSetRemoteVideoConfigEx(r100, r110, r111.value(), r112.getWidth(), r112.getHeight(), r112.getFrameRate());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int subscribeStream(String r100, StreamIndex r101, MediaStreamType r102) {
        LogUtil.d(TAG, "subscribeStream: userId: " + r100 + ", streamIndex: " + r101);
        this.mJniReadLock.lock();
        long r103 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r103 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, subscribeStream failed.\"");     // Catch: Throwable -> L10
        int r104 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r104;
    L8:
        r104 = NativeRTCRoomFunctions.nativeSubscribeStreamEx(r103, r100, r101.value(), r102.value);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoomEx
    public int unsubscribeStream(String r100, StreamIndex r101, MediaStreamType r102) {
        LogUtil.d(TAG, "unsubscribeStream: userId: " + r100 + ", streamIndex: " + r101);
        this.mJniReadLock.lock();
        long r103 = this.mNativeRtcRoom;     // Catch: Throwable -> L10
        if (r103 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, unsubscribeStream failed.\"");     // Catch: Throwable -> L10
        int r104 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r104;
    L8:
        r104 = NativeRTCRoomFunctions.nativeUnsubscribeStreamEx(r103, r100, r101.value(), r102.value);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTCRoom
    public int joinRoom(String r100, UserInfo r101, boolean r110, RTCRoomConfig r111) {
        StringBuilder r102 = new StringBuilder("joinRoom with token: ");
        r102.append(r100);
        r102.append(",room");
        r102.append(this.mRoom);
        r102.append(" and uid: ");
        if (r101 != null) goto L5;
        String r103 = "";
    L6:
        r102.append(r103);
        LogUtil.d(TAG, r102.toString());
        this.mJniReadLock.lock();
    L18:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L8:
        if (this.mNativeRtcRoom != 0) goto L12;
        LogUtil.e(TAG, "native room is invalid, joinRoom failed.");     // Catch: Throwable -> L18
        int r104 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L18
    L10:
        this.mJniReadLock.unlock();
        return r104;
    L12:
        if (r101 != null) goto L14;
        r104 = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();     // Catch: Throwable -> L18
        goto L10
    L14:
        if (r100 != null) goto L16;
        r104 = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();     // Catch: Throwable -> L18
        goto L10
    L16:
        this.mUser = r101.getUid();     // Catch: Throwable -> L18
        r104 = NativeRTCRoomFunctions.nativeJoinRoomWithRoomConfig(this.mNativeRtcRoom, r100, r101, r110, r111);     // Catch: Throwable -> L18
        goto L10
    L5:
        r103 = r101.getUid();
        goto L6
    }
}
