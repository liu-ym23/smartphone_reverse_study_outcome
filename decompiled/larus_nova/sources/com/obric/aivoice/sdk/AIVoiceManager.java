package com.obric.aivoice.sdk;

import com.obric.aivoice.AIVoiceListener;
import com.obric.aivoice.core.AIVoiceManagerInner;
import com.obric.aivoice.core.log.AIVoiceLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u000bJ&\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceManager;", "", "()V", "TAG", "", "WORK_MODE_ALL", "", "WORK_MODE_NOT_STARTED", "WORK_MODE_ONLY_ASR", "WORK_MODE_ONLY_TTS", "offlineStopping", "", "enableOfflineServer", "", "enable", "type", "getOfflineServerStatus", "getOfflineStopping", "init", "config", "Lcom/obric/aivoice/sdk/AIVoiceConfig;", "connectListener", "Lcom/obric/aivoice/sdk/IConnectListener;", "statusListener", "Lcom/obric/aivoice/sdk/IOfflineServerListener;", "registerOfflineServerListener", "listener", "Lcom/obric/aivoice/AIVoiceListener;", "unregisterOfflineServerListener", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceManager {
    public static final AIVoiceManager INSTANCE = null;
    public static final String TAG = "AIVoiceManager";
    public static final int WORK_MODE_ALL = 0;
    public static final int WORK_MODE_NOT_STARTED = -1;
    public static final int WORK_MODE_ONLY_ASR = 1;
    public static final int WORK_MODE_ONLY_TTS = 2;
    private static boolean offlineStopping;

    static {
        INSTANCE = new AIVoiceManager();
    }

    private AIVoiceManager() {
    }

    public final boolean getOfflineStopping() {
        return offlineStopping;
    }

    public final int getOfflineServerStatus(int r100) {
        int r101 = AIVoiceManagerInner.INSTANCE.getOfflineServerStatus(r100);
        AIVoiceLog.INSTANCE.d(TAG, "getOfflineServerStatus type:" + r100 + " result:" + r101);
        return r101;
    }

    public final void registerOfflineServerListener(AIVoiceListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        AIVoiceLog.INSTANCE.d(TAG, "registerOfflineServerListener");
        AIVoiceManagerInner.INSTANCE.registerOfflineServerListener(r100);
    }

    public final void unregisterOfflineServerListener(AIVoiceListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        AIVoiceLog.INSTANCE.d(TAG, "unregisterOfflineServerListener");
        AIVoiceManagerInner.INSTANCE.unregisterOfflineServerListener(r100);
    }

    public final void enableOfflineServer(boolean r100, int r101) {
        AIVoiceLog.INSTANCE.d(TAG, "enableOfflineServer enable:" + r100 + " type:" + r101);
        if (r101 != 1) goto L6;
        if (r100 == true) goto L6;
        offlineStopping = true;
    L6:
        AIVoiceManagerInner.INSTANCE.enableOfflineServer(r100, r101);
    }

    public final void init(AIVoiceConfig r100, IConnectListener r101, IOfflineServerListener r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        AIVoiceManagerInner.INSTANCE.init(r100, r101, r102);
    }

    public static /* synthetic */ void init$default(AIVoiceManager r100, AIVoiceConfig r101, IConnectListener r102, IOfflineServerListener r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.init(r101, r102, r103);
    }
}
