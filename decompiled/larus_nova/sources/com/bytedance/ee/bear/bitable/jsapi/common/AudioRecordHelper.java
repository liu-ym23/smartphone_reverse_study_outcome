package com.bytedance.ee.bear.bitable.jsapi.common;

import android.app.Activity;
import android.media.AudioManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.model.GXAnimation;
import com.byted.cast.common.bean.State;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.supervisor.token.Token;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.nova.R;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.lark.audio.recorder.AudioRecordConfigBuilder;
import com.ss.android.lark.audio.recorder.ErrorInfo;
import com.ss.android.lark.audio.recorder.LarkAudioRecorder;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.Scene;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class AudioRecordHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AudioRecordHelper f214330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static LarkAudioRecorder f214331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f214332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f214333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f214334e = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/AudioRecordHelper$AudioErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NO_PERMISSION", "IN_MEETING", "IN_CALLING", "DATA_EMPTY", "START_FAILED", "TRY_LOCK_FAILED", FlowDoraWifiScene.OTHER, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AudioErrorType extends Enum<AudioErrorType> {
        public static final AudioErrorType DATA_EMPTY = null;
        public static final AudioErrorType IN_CALLING = null;
        public static final AudioErrorType IN_MEETING = null;
        public static final AudioErrorType NO_PERMISSION = null;
        public static final AudioErrorType OTHER = null;
        public static final AudioErrorType START_FAILED = null;
        public static final AudioErrorType TRY_LOCK_FAILED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AudioErrorType[] f214335a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f214336b = null;
        private final String value;

        public static EnumEntries<AudioErrorType> getEntries() {
            return f214336b;
        }

        static {
            AudioErrorType r100 = new AudioErrorType("NO_PERMISSION", 0, "noPermission");
            NO_PERMISSION = r100;
            AudioErrorType r101 = new AudioErrorType("IN_MEETING", 1, "inMeeting");
            IN_MEETING = r101;
            AudioErrorType r102 = new AudioErrorType("IN_CALLING", 2, "inCalling");
            IN_CALLING = r102;
            AudioErrorType r103 = new AudioErrorType("DATA_EMPTY", 3, "dataEmpty");
            DATA_EMPTY = r103;
            AudioErrorType r104 = new AudioErrorType("START_FAILED", 4, "startFailed");
            START_FAILED = r104;
            AudioErrorType r105 = new AudioErrorType("TRY_LOCK_FAILED", 5, "tryLockFailed");
            TRY_LOCK_FAILED = r105;
            AudioErrorType r110 = new AudioErrorType(FlowDoraWifiScene.OTHER, 6, "other");
            OTHER = r110;
            AudioErrorType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f214335a = r111;
            f214336b = EnumEntriesKt.enumEntries(r111);
        }

        public static AudioErrorType[] values() {
            return (AudioErrorType[]) f214335a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AudioErrorType valueOf(String r100) {
            return (AudioErrorType) r27.a.a(AudioErrorType.class, r100);
        }

        public AudioErrorType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/AudioRecordHelper$AudioRecordData;", "Lcom/bytedance/ee/util/io/NonProguard;", "state", "", "data", "", "errorType", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getState", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Ljava/lang/String;", "getErrorType", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ee/bear/bitable/jsapi/common/AudioRecordHelper$AudioRecordData;", "equals", "", "other", "", "hashCode", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AudioRecordData implements NonProguard {
        private final String data;
        private final String errorType;
        private final Integer state;

        public static /* synthetic */ AudioRecordData copy$default(AudioRecordData r100, Integer r101, String r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.state;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.data;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.errorType;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final Integer component1() {
            return this.state;
        }

        public final String component2() {
            return this.data;
        }

        public final String component3() {
            return this.errorType;
        }

        public final AudioRecordData copy(Integer r100, String r101, String r102) {
            return new AudioRecordData(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AudioRecordData) == true) goto L8;
            return false;
        L8:
            AudioRecordData r101 = (AudioRecordData) r100;
            if (Intrinsics.areEqual(this.state, r101.state) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.data, r101.data) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.errorType, r101.errorType) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            Integer r100 = this.state;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.data;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.errorType;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "AudioRecordData(state=" + this.state + ", data=" + this.data + ", errorType=" + this.errorType + ')';
        }

        public final String getData() {
            return this.data;
        }

        public final String getErrorType() {
            return this.errorType;
        }

        public final Integer getState() {
            return this.state;
        }

        public AudioRecordData(Integer r100, String r101, String r102) {
            this.state = r100;
            this.data = r101;
            this.errorType = r102;
        }

        public /* synthetic */ AudioRecordData(Integer r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/AudioRecordHelper$AudioRecordState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TOO_SHORT", "PREPARE", GXAnimation.STATE_START, "CANCEL", "FAILED", "SUCCESS", State.RECORDING, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AudioRecordState extends Enum<AudioRecordState> {
        public static final AudioRecordState CANCEL = null;
        public static final AudioRecordState FAILED = null;
        public static final AudioRecordState PREPARE = null;
        public static final AudioRecordState RECORDING = null;
        public static final AudioRecordState START = null;
        public static final AudioRecordState SUCCESS = null;
        public static final AudioRecordState TOO_SHORT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AudioRecordState[] f214337a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f214338b = null;
        private final int value;

        public static EnumEntries<AudioRecordState> getEntries() {
            return f214338b;
        }

        static {
            AudioRecordState r100 = new AudioRecordState("TOO_SHORT", 0, 0);
            TOO_SHORT = r100;
            AudioRecordState r101 = new AudioRecordState("PREPARE", 1, 1);
            PREPARE = r101;
            AudioRecordState r102 = new AudioRecordState(GXAnimation.STATE_START, 2, 2);
            START = r102;
            AudioRecordState r103 = new AudioRecordState("CANCEL", 3, 3);
            CANCEL = r103;
            AudioRecordState r104 = new AudioRecordState("FAILED", 4, 4);
            FAILED = r104;
            AudioRecordState r105 = new AudioRecordState("SUCCESS", 5, 5);
            SUCCESS = r105;
            AudioRecordState r110 = new AudioRecordState(State.RECORDING, 6, 6);
            RECORDING = r110;
            AudioRecordState[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f214337a = r111;
            f214338b = EnumEntriesKt.enumEntries(r111);
        }

        public static AudioRecordState[] values() {
            return (AudioRecordState[]) f214337a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AudioRecordState valueOf(String r100) {
            return (AudioRecordState) r27.a.a(AudioRecordState.class, r100);
        }

        public AudioRecordState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/AudioRecordHelper$AudioStartRecordRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "preferredDataCallbackInterval", "", "<init>", "(Ljava/lang/Double;)V", "getPreferredDataCallbackInterval", "()Ljava/lang/Double;", "Ljava/lang/Double;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AudioStartRecordRequest implements NonProguard {
        private final Double preferredDataCallbackInterval;

        /* JADX WARN: Multi-variable type inference failed */
        public AudioStartRecordRequest() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Double getPreferredDataCallbackInterval() {
            return this.preferredDataCallbackInterval;
        }

        public AudioStartRecordRequest(Double r100) {
            this.preferredDataCallbackInterval = r100;
        }

        public /* synthetic */ AudioStartRecordRequest(Double r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = Double.valueOf(0.1d);
        L5:
            this(r100);
        }
    }

    public static final class a implements com.ss.android.lark.audio.recorder.j {
        public a() {
        }

        @Override // com.ss.android.lark.audio.recorder.j
        public final byte[] a(boolean r100) {
            return null;
        }

        @Override // com.ss.android.lark.audio.recorder.j
        public final void c() {
        }

        @Override // com.ss.android.lark.audio.recorder.j
        public final int d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "encodeFilePath");
            return 1;
        }

        @Override // com.ss.android.lark.audio.recorder.j
        public final long b(ByteBuffer r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "buffer");
            int r102 = RangesKt.coerceAtMost(r101, r100.remaining());
            if (r102 <= 0) goto L7;
            r100.position(r100.position() + r102);
            return 0;
        L7:
            return 0;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f214339a = null;

        static {
            int[] r100 = new int[ErrorInfo.values().length];
            r100[ErrorInfo.ERR_NO_PERMISSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[ErrorInfo.ERR_INTERRUPT_BY_PHONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[ErrorInfo.ERR_INTERRUPT_BY_VC_MEETING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ErrorInfo.ERR_PCM_SIZE_ZERO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[ErrorInfo.ERR_INVALID_RECORD_TASK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[ErrorInfo.ERR_INIT_AUDIO_RECORD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[ErrorInfo.ERR_INIT_AUDIO_ENCODE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[ErrorInfo.ERR_PSDA_CHECK.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f214339a = r100;
        }
    }

    public static final class c implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f214340a = null;

        static {
            f214340a = new c();
        }

        public c() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "<unused var>");
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101 != Lifecycle.Event.ON_STOP) goto L6;
            tt5.a.h("AudioRecordHelper", "app enter background, stop record");
            AudioRecordHelper.f214330a.h();
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f214341a = null;

        static {
            f214341a = new d();
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ProcessLifecycleOwner.Companion.get().getLifecycle().removeObserver(AudioRecordHelper.f214334e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AudioRecordHelper() {
    }

    public final synchronized void d() {
        monitor-enter(this);
        f214332c = false;     // Catch: Throwable -> L7
        f214333d = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void e() {
        monitor-enter(this);
        f214332c = true;     // Catch: Throwable -> L7
        f214333d = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void f() {
        monitor-enter(this);
        tt5.a.h("AudioRecordHelper", "release");     // Catch: Throwable -> L9
        d();     // Catch: Throwable -> L9
        UIThreadUtils.runOnUiThread(d.f214341a);     // Catch: Throwable -> L9
        LarkAudioRecorder r100 = f214331b;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        r100.a();     // Catch: Throwable -> L9
    L6:
        f214331b = null;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void h() {
        monitor-enter(this);
        tt5.a.h("AudioRecordHelper", "stopRecord");     // Catch: Throwable -> L15
        if (f214331b != null) goto L10;
        if (f214332c == true) goto L10;
        monitor-exit(this);
        return;
    L10:
        f214333d = true;     // Catch: Throwable -> L15
        LarkAudioRecorder r100 = f214331b;     // Catch: Throwable -> L15
        if (r100 == null) goto L13;
        r100.f();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    static {
        f214330a = new AudioRecordHelper();
        f214334e = c.f214340a;
    }

    public static void c(Activity r100, com.ss.android.lark.utils.h.e r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "callback");
        tt5.a.h("AudioRecordHelper", "checkAudioPermission");
        com.ss.android.lark.utils.h.a(r100, new Token("LARK-PSDA-base_form_request_audio_record_permission"), r101);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.bytedance.ee.bear.bitable.jsapi.common.AudioRecordHelper$AudioErrorType] */
    public static final void a(Ref.BooleanRef r100, Ref.ObjectRef r101, Function1 r102, Ref.BooleanRef r103) {
        r100.element = true;
        ?? r104 = AudioErrorType.DATA_EMPTY;
        r101.element = r104;
        AudioRecordHelper r105 = f214330a;
        AudioRecordState r106 = AudioRecordState.FAILED;
        r102.invoke(b(r105, r106, null, r104, 2));
        if (r103.element == true) goto L6;
        r102.invoke(b(r105, r106, null, AudioErrorType.OTHER, 2));
        r105.h();
        return;
    }

    public final synchronized boolean g(FragmentActivity r110, VFSPath r111, int r112, Function1 r113) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L49
        Intrinsics.checkNotNullParameter(r111, "audioVfsPath");     // Catch: Throwable -> L49
        Intrinsics.checkNotNullParameter(r113, "callback");     // Catch: Throwable -> L49
        boolean r100 = false;
        f214332c = false;     // Catch: Throwable -> L49
        if (f214333d == false) goto L9;
        tt5.a.h("AudioRecordHelper", "startRecord canceled: stopRecord was called before recorder.startRecord");     // Catch: Throwable -> L49
        f214333d = false;     // Catch: Throwable -> L49
        monitor-exit(this);
        return false;
    L9:
        if (f214331b == null) goto L13;
        tt5.a.k("AudioRecordHelper", "startRecord failed: recorder is not released");     // Catch: Throwable -> L49
        r113.invoke(b(this, AudioRecordState.FAILED, null, AudioErrorType.START_FAILED, 2));     // Catch: Throwable -> L49
        monitor-exit(this);
        return false;
    L13:
        List<Scene> r101 = MediaMutex.f431631r.a();     // Catch: Throwable -> L49
        if (r101 == null) goto L16;
        boolean r102 = r101.contains(Scene.VC_MEETING);     // Catch: Throwable -> L49
    L17:
        if (r102 == false) goto L52;
        tt5.a.h("AudioRecordHelper", "startRecord failed: in meeting");     // Catch: Throwable -> L49
        UIThreadUtils.runOnUiThread(new com.bytedance.ee.bear.bitable.jsapi.common.b(r110, r110.getResources().getString(R.string.View_G_InMeetingTryLater_Toast)));     // Catch: Throwable -> L49
        r113.invoke(b(this, AudioRecordState.FAILED, null, AudioErrorType.IN_MEETING, 2));     // Catch: Throwable -> L49
        monitor-exit(this);
        return false;
    L52:
        Object r103 = r110.getSystemService("audio");     // Catch: Throwable -> L32
        if ((r103 instanceof AudioManager) == false) goto L25;
        AudioManager r104 = (AudioManager) r103;     // Catch: Throwable -> L32
    L26:
        if (r104 == null) goto L34;
        int r105 = r104.getMode();     // Catch: Throwable -> L32
        if (r105 == 1) goto L31;
        if (r105 != 2) goto L34;
    L31:
        boolean r106 = true;
    L35:
        if (r106 == false) goto L39;
        tt5.a.h("AudioRecordHelper", "startRecord failed: in calling");     // Catch: Throwable -> L49
        UIThreadUtils.runOnUiThread(new com.bytedance.ee.bear.bitable.jsapi.common.b(r110, r110.getResources().getString(R.string.View_G_InCallTryLater_Toast)));     // Catch: Throwable -> L49
        r113.invoke(b(this, AudioRecordState.FAILED, null, AudioErrorType.IN_CALLING, 2));     // Catch: Throwable -> L49
        monitor-exit(this);
        return false;
    L39:
        com.ss.android.lark.audio.recorder.c r114 = AudioRecordConfigBuilder.BASE_FORM.getAudioRecordConfig();     // Catch: Throwable -> L49
        if (r112 > 0) goto L43;
        r112 = r114.f409112d;     // Catch: Throwable -> L49
    L43:
        com.ss.android.lark.audio.recorder.c r115 = com.ss.android.lark.audio.recorder.c.a(r114, r112, new a());     // Catch: Throwable -> L49
        LarkAudioRecorder r116 = new LarkAudioRecorder();     // Catch: Throwable -> L49
        r116.c(r115);     // Catch: Throwable -> L49
        UIThreadUtils.runOnUiThread(com.bytedance.ee.bear.bitable.jsapi.common.c.f214391a);     // Catch: Throwable -> L49
        if (r116.e(r111.getAbsolutePath(), new com.bytedance.ee.bear.bitable.jsapi.common.d(r113, new Ref.BooleanRef(), new Ref.BooleanRef(), new Ref.BooleanRef(), new Ref.IntRef(), new Ref.ObjectRef())) == false) goto L46;
        f214331b = r116;     // Catch: Throwable -> L49
        r100 = true;
    L47:
        monitor-exit(this);
        return r100;
    L46:
        tt5.a.d("AudioRecordHelper", "recorder.startRecord failed");     // Catch: Throwable -> L49
        r113.invoke(b(this, AudioRecordState.FAILED, null, AudioErrorType.START_FAILED, 2));     // Catch: Throwable -> L49
        r116.a();     // Catch: Throwable -> L49
        f();     // Catch: Throwable -> L49
        goto L47
    L34:
        r106 = false;
        goto L35
    L25:
        r104 = null;
    L32:
        th = move-exception;
        tt5.a.k("AudioRecordHelper", "isCallingNow error: " + th);     // Catch: Throwable -> L49
        goto L34
    L16:
        r102 = false;
    L49:
        th = move-exception;
        throw th;
    }

    public static JSONObject b(AudioRecordHelper r100, AudioRecordState r101, String r102, AudioErrorType r103, int r104) {
        String r105 = null;
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "state");
        Integer r106 = Integer.valueOf(r101.getValue());
        if (r103 == null) goto L11;
        r105 = r103.getValue();
    L11:
        AudioRecordData r107 = new AudioRecordData(r106, r102, r105);
        tt5.a.h("AudioRecordHelper", "buildStateJson, recordData=" + r107 + ", result=" + JSON.parseObject(JSON.toJSONString(r107)));
        return JSON.parseObject(JSON.toJSONString(r107));
    }
}
