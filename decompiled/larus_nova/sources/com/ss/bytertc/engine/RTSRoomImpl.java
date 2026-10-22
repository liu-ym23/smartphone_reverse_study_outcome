package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.handler.IRTSRoomEventHandler;
import com.ss.bytertc.engine.handler.RTCRoomEventHandlerRts;
import com.ss.bytertc.engine.type.MessageConfig;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class RTSRoomImpl extends RTSRoom {
    protected static final String TAG = "RTSRoom";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    protected long mNativeRtcRoom;
    private long mNativeRtcRoomEventHandlerRts;
    private final ReentrantReadWriteLock mReadWriteLock;
    private String mRoom;
    private RTCRoomEventHandlerRts mRtcRoomEventHandlerRts;
    private IRTSRoomEventHandler mRtcRoomHandlerRts;
    private String mUser;

    @Override // com.ss.bytertc.engine.RTSRoom
    public void destroy() {
        LogUtil.d(TAG, "Destroy ");
        this.mJniWriteLock.lock();
        long r100 = this.mNativeRtcRoom;     // Catch: Throwable -> L13
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native rtcroom is invalid, Destroy failed.");     // Catch: Throwable -> L13
        this.mJniWriteLock.unlock();
        return;
    L8:
        this.mNativeRtcRoom = 0;     // Catch: Throwable -> L13
        this.mJniWriteLock.unlock();
        NativeRTCRoomFunctions.nativeDestroyRTSRoom(r100);
        long r101 = this.mNativeRtcRoomEventHandlerRts;
        if (r101 == 0) goto L17;
        NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerRts(r101);
        this.mNativeRtcRoomEventHandlerRts = 0;
        return;
    L17:
        return;
    L13:
        th = move-exception;
        this.mJniWriteLock.unlock();
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
        r101 = NativeRTCRoomFunctions.nativeLeaveRTSRoom(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    public long getNativeHandle() {
        return this.mNativeRtcRoom;
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
        long r102 = NativeRTCRoomFunctions.nativeSendRTSRoomBinaryMessage(r101, r100);     // Catch: Throwable -> L11
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
        long r102 = NativeRTCRoomFunctions.nativeSendRTSRoomMessage(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.RTSRoom
    public int setRTSRoomEventHandler(IRTSRoomEventHandler r100) {
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
        this.mRtcRoomHandlerRts = r100;     // Catch: Throwable -> L13
        RTCRoomEventHandlerRts r102 = new RTCRoomEventHandlerRts(this);     // Catch: Throwable -> L13
        this.mRtcRoomEventHandlerRts = r102;     // Catch: Throwable -> L13
        long r103 = this.mNativeRtcRoomEventHandlerRts;     // Catch: Throwable -> L13
        this.mNativeRtcRoomEventHandlerRts = NativeRTCRoomFunctions.nativeSetRTCRoomEventHandlerRts(this.mNativeRtcRoom, r102);     // Catch: Throwable -> L13
        if (r103 == 0) goto L11;
        NativeRTCRoomFunctions.nativeReleaseRTCRoomEventHandlerRts(r103);     // Catch: Throwable -> L13
    L11:
        this.mJniReadLock.unlock();
        return 0;
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
        r102 = NativeRTCRoomFunctions.nativeUpdateRTSToken(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    public RTSRoomImpl(String r100, long r101) {
        this.mNativeRtcRoom = 0;
        this.mNativeRtcRoomEventHandlerRts = 0;
        ReentrantReadWriteLock r102 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r102;
        this.mJniReadLock = r102.readLock();
        this.mJniWriteLock = r102.writeLock();
        this.mNativeRtcRoom = r101;
        this.mRoom = r100;
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
        r104 = NativeRTCRoomFunctions.nativeJoinRTSRoom(this.mNativeRtcRoom, r100, r101);     // Catch: Throwable -> L18
        goto L10
    L5:
        r103 = r101.getUid();
        goto L6
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
        long r104 = NativeRTCRoomFunctions.nativeSendRTSUserBinaryMessage(r103, r100, r101, r102.value());     // Catch: Throwable -> L11
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
        long r104 = NativeRTCRoomFunctions.nativeSendRTSUserMessage(r103, r100, r101, r102.value());     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r104;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }
}
