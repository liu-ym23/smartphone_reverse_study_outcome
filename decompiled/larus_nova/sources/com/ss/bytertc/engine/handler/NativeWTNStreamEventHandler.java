package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IWTNStreamEventHandler;
import com.ss.bytertc.engine.InternalRemoteAudioStats;
import com.ss.bytertc.engine.InternalRemoteVideoStats;
import com.ss.bytertc.engine.WTNStream;
import com.ss.bytertc.engine.data.DataMessageSourceType;
import com.ss.bytertc.engine.data.VideoFrameInfo;
import com.ss.bytertc.engine.data.WTNSubscribeState;
import com.ss.bytertc.engine.data.WTNSubscribeStateChangeReason;
import com.ss.bytertc.engine.type.RemoteAudioStats;
import com.ss.bytertc.engine.type.RemoteVideoStats;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class NativeWTNStreamEventHandler {
    private static final String TAG = "NativeWTNStreamEventHandler";
    private WeakReference<WTNStream> mWTNStream;

    public NativeWTNStreamEventHandler(WTNStream r100) {
        this.mWTNStream = new WeakReference(r100);
    }

    public static ByteBuffer allocateDirectByteBuffer(int r100) {
        return ByteBuffer.allocateDirect(r100);
    }

    public void onWTNFirstRemoteAudioFrame(String r100) {
        LogUtil.d(TAG, "onWTNFirstRemoteAudioFrame...streamid: " + r100);
        WTNStream r101 = this.mWTNStream.get();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IWTNStreamEventHandler r102 = r101.getWTNStreamEventHandler();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onWTNFirstRemoteAudioFrame(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onWTNFirstRemoteAudioFrame callback catch exception.\n" + e.getMessage());
    }

    public void onWTNFirstRemoteVideoFrameDecoded(String r100, VideoFrameInfo r101) {
        LogUtil.d(TAG, "onWTNFirstRemoteVideoFrameDecoded...streamid: " + r100 + ", width: " + r101.getWidth() + ", height: " + r101.getHeight());
        WTNStream r102 = this.mWTNStream.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IWTNStreamEventHandler r103 = r102.getWTNStreamEventHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onWTNFirstRemoteVideoFrameDecoded(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onWTNFirstRemoteVideoFrameDecoded callback catch exception.\n" + e.getMessage());
    }

    public void onWTNRemoteAudioStats(String r100, InternalRemoteAudioStats r101) {
        LogUtil.d(TAG, "onWTNRemoteAudioStats, streamid" + r100);
        WTNStream r102 = this.mWTNStream.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IWTNStreamEventHandler r103 = r102.getWTNStreamEventHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onWTNRemoteAudioStats(r100, new RemoteAudioStats(r101));     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onWTNRemoteAudioStats callback catch exception.\n" + e.getMessage());
    }

    public void onWTNRemoteVideoStats(String r100, InternalRemoteVideoStats r101) {
        LogUtil.d(TAG, "onWTNRemoteVideoStats, streamid" + r100);
        WTNStream r102 = this.mWTNStream.get();     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IWTNStreamEventHandler r103 = r102.getWTNStreamEventHandler();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onWTNRemoteVideoStats(r100, new RemoteVideoStats(r101));     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onWTNRemoteVideoStats callback catch exception.\n" + e.getMessage());
    }

    public void onWTNAudioSubscribeStateChanged(String r100, WTNSubscribeState r101, WTNSubscribeStateChangeReason r102) {
        LogUtil.d(TAG, "onWTNAudioSubscribeStateChanged state(" + r101 + ") state(" + r102 + ") streamId:" + r100);
        WTNStream r103 = this.mWTNStream.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IWTNStreamEventHandler r104 = r103.getWTNStreamEventHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onWTNAudioSubscribeStateChanged(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onWTNAudioSubscribeStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onWTNDataMessageReceived(String r100, ByteBuffer r101, int r102) {
        WTNStream r103 = this.mWTNStream.get();     // Catch: Exception -> L8
        if (r103 == null) goto L13;
        IWTNStreamEventHandler r104 = r103.getWTNStreamEventHandler();     // Catch: Exception -> L8
        if (r104 == null) goto L14;
        r104.onWTNDataMessageReceived(r100, r101, DataMessageSourceType.fromId(r102));     // Catch: Exception -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        LogUtil.e(TAG, "onWTNDataMessageReceived callback catch exception.\n" + e.getMessage());
    }

    public void onWTNSEIMessageReceived(String r100, int r101, ByteBuffer r102) {
        WTNStream r103 = this.mWTNStream.get();     // Catch: Exception -> L8
        if (r103 == null) goto L13;
        IWTNStreamEventHandler r104 = r103.getWTNStreamEventHandler();     // Catch: Exception -> L8
        if (r104 == null) goto L14;
        r104.onWTNSEIMessageReceived(r100, r101, r102);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        LogUtil.e(TAG, "onWTNSEIMessageReceived callback catch exception.\n" + e.getMessage());
    }

    public void onWTNVideoSubscribeStateChanged(String r100, WTNSubscribeState r101, WTNSubscribeStateChangeReason r102) {
        LogUtil.d(TAG, "onWTNVideoSubscribeStateChanged state(" + r101 + ") state(" + r102 + ") streamId:" + r100);
        WTNStream r103 = this.mWTNStream.get();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IWTNStreamEventHandler r104 = r103.getWTNStreamEventHandler();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onWTNVideoSubscribeStateChanged(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.e(TAG, "onWTNVideoSubscribeStateChanged callback catch exception.\n" + e.getMessage());
    }
}
