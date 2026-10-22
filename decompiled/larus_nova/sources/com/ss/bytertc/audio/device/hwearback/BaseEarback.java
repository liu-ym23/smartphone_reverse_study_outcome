package com.ss.bytertc.audio.device.hwearback;

import android.content.Context;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public abstract class BaseEarback implements IHardWareEarback {
    public static final int RESULT_INVALID_STATE = -2;
    public static final int RESULT_OP_FAILED = -1;
    public static final int RESULT_SUCCESS = 0;
    private static final String TAG = "BaseEarback";
    protected final Context context;
    private volatile EarbackState state;
    protected final WebRtcAudioEarBack webRtcAudioEarBack;

    public static final enum EarbackState extends Enum<EarbackState> {
        private static final /* synthetic */ EarbackState[] $VALUES = null;
        public static final EarbackState IDLE = null;
        public static final EarbackState INITIALIZED = null;
        public static final EarbackState INITIALIZING = null;
        public static final EarbackState RUNNING = null;

        static {
            EarbackState r100 = new EarbackState("IDLE", 0);
            IDLE = r100;
            EarbackState r101 = new EarbackState("INITIALIZING", 1);
            INITIALIZING = r101;
            EarbackState r102 = new EarbackState("INITIALIZED", 2);
            INITIALIZED = r102;
            EarbackState r103 = new EarbackState("RUNNING", 3);
            RUNNING = r103;
            $VALUES = new EarbackState[]{r100, r101, r102, r103};
        }

        public static EarbackState[] values() {
            return (EarbackState[]) $VALUES.clone();
        }

        public static EarbackState valueOf(String r100) {
            return (EarbackState) a.a(EarbackState.class, r100);
        }

        private EarbackState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract boolean onClose();

    public abstract void onInit();

    public abstract boolean onIsSupportCall();

    public abstract boolean onOpen();

    public abstract void onRelease();

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public synchronized int close() {
        monitor-enter(this);
        RXLogging.i(TAG, "close() with state: " + this.state);     // Catch: Throwable -> L18
        if (this.state == EarbackState.RUNNING) goto L10;
        monitor-exit(this);
        return -2;
    L10:
        if (onClose() == false) goto L15;
        changeState(EarbackState.INITIALIZED);     // Catch: Throwable -> L18
        monitor-exit(this);
        return 0;
    L15:
        monitor-exit(this);
        return -1;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public synchronized int init() {
        monitor-enter(this);
        RXLogging.i(TAG, "init() with state: " + this.state);     // Catch: Throwable -> L14
        if (this.state.ordinal() < EarbackState.INITIALIZED.ordinal()) goto L8;
        this.webRtcAudioEarBack.onHardwareEarbackSupported(isSupport());     // Catch: Throwable -> L14
    L11:
        changeState(EarbackState.INITIALIZING);     // Catch: Throwable -> L14
        onInit();     // Catch: Throwable -> L14
        monitor-exit(this);
        return 0;
    L8:
        if (this.state != EarbackState.INITIALIZING) goto L11;
        monitor-exit(this);
        return 0;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public boolean isSupport() {
        if (this.state.ordinal() >= EarbackState.INITIALIZED.ordinal()) goto L7;
        return false;
    L7:
        return onIsSupportCall();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public synchronized int open() {
        monitor-enter(this);
        RXLogging.i(TAG, "open() with state: " + this.state);     // Catch: Throwable -> L25
        EarbackState r100 = this.state;     // Catch: Throwable -> L25
        EarbackState r101 = EarbackState.RUNNING;     // Catch: Throwable -> L25
        if (r100 != r101) goto L10;
        monitor-exit(this);
        return 0;
    L10:
        if (this.state == EarbackState.INITIALIZED) goto L12;
    L22:
        monitor-exit(this);
        return -2;
    L12:
        if (isSupport() == false) goto L22;
        if (onOpen() == false) goto L19;
        changeState(r101);     // Catch: Throwable -> L25
        monitor-exit(this);
        return 0;
    L19:
        monitor-exit(this);
        return -1;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public synchronized int release() {
        monitor-enter(this);
        RXLogging.i(TAG, "release() with state: " + this.state);     // Catch: Throwable -> L12
        EarbackState r100 = this.state;     // Catch: Throwable -> L12
        EarbackState r101 = EarbackState.IDLE;     // Catch: Throwable -> L12
        if (r100 != r101) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        onRelease();     // Catch: Throwable -> L12
        changeState(r101);     // Catch: Throwable -> L12
        monitor-exit(this);
        return 0;
    L12:
        th = move-exception;
        throw th;
    }

    public EarbackState getState() {
        return this.state;
    }

    private void changeState(EarbackState r100) {
        RXLogging.i(TAG, "changeState: " + this.state + " -> " + r100);
        EarbackState r101 = this.state;
        this.state = r100;
        if (r101 == r100) goto L6;
        onStateChanged(r101, r100);
        return;
    }

    public synchronized void onInitResult(boolean r100) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.state != EarbackState.INITIALIZING) goto L15;
        if (r100 == false) goto L7;
        EarbackState r101 = EarbackState.INITIALIZED;     // Catch: Throwable -> L17
    L8:
        this.state = r101;     // Catch: Throwable -> L17
        WebRtcAudioEarBack r102 = this.webRtcAudioEarBack;     // Catch: Throwable -> L17
        if (r100 == true) goto L11;
    L13:
        boolean r103 = false;
    L14:
        r102.onHardwareEarbackSupported(r103);     // Catch: Throwable -> L17
        goto L15
    L11:
        if (isSupport() == false) goto L13;
        r103 = true;
        goto L14
    L7:
        r101 = EarbackState.IDLE;     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
    }

    public BaseEarback(Context r100, WebRtcAudioEarBack r101) {
        this.context = r100;
        this.webRtcAudioEarBack = r101;
        this.state = EarbackState.IDLE;
    }

    public synchronized void onStateChanged(EarbackState r100, EarbackState r101) {
        monitor-enter(this);
        monitor-exit(this);
    }
}
