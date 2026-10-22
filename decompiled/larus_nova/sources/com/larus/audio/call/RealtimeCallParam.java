package com.larus.audio.call;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAudioKitMode;
import com.larus.im.service.audio.h1;
import com.larus.im.service.audio.y0;
import com.obric.capabilitykit.common.ErrorCode;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.model.SubInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: classes24.dex */
public final class RealtimeCallParam {
    public boolean A;
    public m B;
    public ve9.c C;
    public String D;
    public boolean E;
    public boolean F;
    public String G;
    public String H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f288736J;
    public String K;
    public com.larus.audio.call.n L;
    public l M;
    public g N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public String R;
    public boolean S;
    public boolean T;
    public int U;
    public int V;
    public boolean W;
    public Boolean X;
    public Boolean Y;
    public Boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f288737a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Boolean f288738a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f288739b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f288740b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f288741c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f288742c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f288743d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public String f288744d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f288745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f288746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f288747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f288748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f288749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f288750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h f288751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f288752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o f288753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j f288754n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p f288755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public k f288756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d0 f288757q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d0 f288758r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AudioSessionType f288759s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f288760t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f288761u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f288762v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f288763w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AvAudioKitMode f288764x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f288765y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f288766z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/audio/call/RealtimeCallParam$BusinessType;", "", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BusinessType {
        public static final a Companion = null;
        public static final int DORA_E = 8;
        public static final int DORA_G = 9;
        public static final int DORA_LITE = 6;
        public static final int DOUBAO_PHONE = 2;
        public static final int DOU_BAO = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f288767a = null;

            static {
                f288767a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f288767a;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/call/RealtimeCallParam$DoraEndType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "VOICE_CONTROL", "TOUCHPAD", "EIGHT_TIMEOUT", FlowDoraWifiScene.OTHER, "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DoraEndType extends Enum<DoraEndType> {
        public static final DoraEndType EIGHT_TIMEOUT = null;
        public static final DoraEndType OTHER = null;
        public static final DoraEndType TOUCHPAD = null;
        public static final DoraEndType VOICE_CONTROL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DoraEndType[] f288768a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f288769b = null;
        private final String type;

        public static EnumEntries<DoraEndType> getEntries() {
            return f288769b;
        }

        static {
            DoraEndType r100 = new DoraEndType("VOICE_CONTROL", 0, "voice_control");
            VOICE_CONTROL = r100;
            DoraEndType r101 = new DoraEndType("TOUCHPAD", 1, "touchpad");
            TOUCHPAD = r101;
            DoraEndType r102 = new DoraEndType("EIGHT_TIMEOUT", 2, "8s_timeout");
            EIGHT_TIMEOUT = r102;
            DoraEndType r103 = new DoraEndType(FlowDoraWifiScene.OTHER, 3, "other");
            OTHER = r103;
            DoraEndType[] r104 = {r100, r101, r102, r103};
            f288768a = r104;
            f288769b = EnumEntriesKt.enumEntries(r104);
        }

        public static DoraEndType[] values() {
            return (DoraEndType[]) f288768a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static DoraEndType valueOf(String r100) {
            return (DoraEndType) r27.a.a(DoraEndType.class, r100);
        }

        public DoraEndType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/audio/call/RealtimeCallParam$EventConfig;", "", "enable", "", "frequency", "", "<init>", "(ZF)V", "getEnable$annotations", "()V", "getEnable", "()Z", "getFrequency$annotations", "getFrequency", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EventConfig {
        public static final int $stable = 0;
        private final boolean enable;
        private final float frequency;

        public EventConfig() {
            boolean r100 = false;
            float r101 = 0.0f;
            this(r100, r101, 3, null);
        }

        public static /* synthetic */ EventConfig copy$default(EventConfig r100, boolean r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.enable;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.frequency;
        L9:
            return r100.copy(r101, r102);
        }

        @SerialName("enable")
        public static /* synthetic */ void getEnable$annotations() {
        }

        @SerialName("frequency")
        public static /* synthetic */ void getFrequency$annotations() {
        }

        public final boolean component1() {
            return this.enable;
        }

        public final float component2() {
            return this.frequency;
        }

        public final EventConfig copy(boolean r100, float r101) {
            return new EventConfig(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof EventConfig) == true) goto L8;
            return false;
        L8:
            EventConfig r101 = (EventConfig) r100;
            if (this.enable == r101.enable) goto L12;
            return false;
        L12:
            if (Float.compare(this.frequency, r101.frequency) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            if (this.enable == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + Float.floatToIntBits(this.frequency);
        L5:
            r100 = 1237;
            goto L7
        }

        public String toString() {
            return "EventConfig(enable=" + this.enable + ", frequency=" + this.frequency + ')';
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final float getFrequency() {
            return this.frequency;
        }

        public EventConfig(boolean r100, float r101) {
            this.enable = r100;
            this.frequency = r101;
        }

        public /* synthetic */ EventConfig(boolean r100, float r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 0.0f;
        L8:
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/larus/audio/call/RealtimeCallParam$RealtimeCallAddEventConfig;", "", "helloEvent", "Lcom/larus/audio/call/RealtimeCallParam$EventConfig;", "waitingEvent", "Lcom/larus/audio/call/RealtimeCallParam$WaitingEventConfig;", "hangUpEvent", "<init>", "(Lcom/larus/audio/call/RealtimeCallParam$EventConfig;Lcom/larus/audio/call/RealtimeCallParam$WaitingEventConfig;Lcom/larus/audio/call/RealtimeCallParam$EventConfig;)V", "getHelloEvent$annotations", "()V", "getHelloEvent", "()Lcom/larus/audio/call/RealtimeCallParam$EventConfig;", "getWaitingEvent$annotations", "getWaitingEvent", "()Lcom/larus/audio/call/RealtimeCallParam$WaitingEventConfig;", "getHangUpEvent$annotations", "getHangUpEvent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RealtimeCallAddEventConfig {
        public static final int $stable = 0;
        private final EventConfig hangUpEvent;
        private final EventConfig helloEvent;
        private final WaitingEventConfig waitingEvent;

        public RealtimeCallAddEventConfig() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ RealtimeCallAddEventConfig copy$default(RealtimeCallAddEventConfig r100, EventConfig r101, WaitingEventConfig r102, EventConfig r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.helloEvent;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.waitingEvent;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.hangUpEvent;
        L12:
            return r100.copy(r101, r102, r103);
        }

        @SerialName("audio_realtime_call_hang_up")
        public static /* synthetic */ void getHangUpEvent$annotations() {
        }

        @SerialName("audio_realtime_call_hello")
        public static /* synthetic */ void getHelloEvent$annotations() {
        }

        @SerialName("audio_realtime_call_waiting")
        public static /* synthetic */ void getWaitingEvent$annotations() {
        }

        public final EventConfig component1() {
            return this.helloEvent;
        }

        public final WaitingEventConfig component2() {
            return this.waitingEvent;
        }

        public final EventConfig component3() {
            return this.hangUpEvent;
        }

        public final RealtimeCallAddEventConfig copy(EventConfig r100, WaitingEventConfig r101, EventConfig r102) {
            return new RealtimeCallAddEventConfig(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RealtimeCallAddEventConfig) == true) goto L8;
            return false;
        L8:
            RealtimeCallAddEventConfig r101 = (RealtimeCallAddEventConfig) r100;
            if (Intrinsics.areEqual(this.helloEvent, r101.helloEvent) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.waitingEvent, r101.waitingEvent) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.hangUpEvent, r101.hangUpEvent) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            EventConfig r100 = this.helloEvent;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            WaitingEventConfig r104 = this.waitingEvent;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            EventConfig r107 = this.hangUpEvent;
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
            return "RealtimeCallAddEventConfig(helloEvent=" + this.helloEvent + ", waitingEvent=" + this.waitingEvent + ", hangUpEvent=" + this.hangUpEvent + ')';
        }

        public final EventConfig getHangUpEvent() {
            return this.hangUpEvent;
        }

        public final EventConfig getHelloEvent() {
            return this.helloEvent;
        }

        public final WaitingEventConfig getWaitingEvent() {
            return this.waitingEvent;
        }

        public RealtimeCallAddEventConfig(EventConfig r100, WaitingEventConfig r101, EventConfig r102) {
            this.helloEvent = r100;
            this.waitingEvent = r101;
            this.hangUpEvent = r102;
        }

        public /* synthetic */ RealtimeCallAddEventConfig(EventConfig r110, WaitingEventConfig r111, EventConfig r112, int r113, DefaultConstructorMarker r114) {
            DefaultConstructorMarker r100 = null;
            int r101 = 3;
            float r102 = 0.0f;
            boolean r103 = false;
            if ((r113 & 1) == 0) goto L5;
            EventConfig r104 = new EventConfig(r103, r102, r101, r100);
        L7:
            if ((r113 & 2) == 0) goto L9;
            WaitingEventConfig r105 = new WaitingEventConfig(false, 0.0f, 0, 0, 15, null);
        L11:
            if ((r113 & 4) == 0) goto L13;
            EventConfig r106 = new EventConfig(r103, r102, r101, r100);
        L14:
            this(r104, r105, r106);
            return;
        L13:
            r106 = r112;
            goto L14
        L9:
            r105 = r111;
            goto L11
        L5:
            r104 = r110;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/audio/call/RealtimeCallParam$WaitingEventConfig;", "", "enable", "", "frequency", "", "limitStart", "", "limitEnd", "<init>", "(ZFII)V", "getEnable$annotations", "()V", "getEnable", "()Z", "getFrequency$annotations", "getFrequency", "()F", "getLimitStart$annotations", "getLimitStart", "()I", "getLimitEnd$annotations", "getLimitEnd", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WaitingEventConfig {
        public static final int $stable = 0;
        private final boolean enable;
        private final float frequency;
        private final int limitEnd;
        private final int limitStart;

        public WaitingEventConfig() {
            this(false, 0.0f, 0, 0, 15, null);
        }

        public static /* synthetic */ WaitingEventConfig copy$default(WaitingEventConfig r100, boolean r101, float r102, int r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.enable;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.frequency;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.limitStart;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.limitEnd;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        @SerialName("enable")
        public static /* synthetic */ void getEnable$annotations() {
        }

        @SerialName("frequency")
        public static /* synthetic */ void getFrequency$annotations() {
        }

        @SerialName("time_limit_end")
        public static /* synthetic */ void getLimitEnd$annotations() {
        }

        @SerialName("time_limit_start")
        public static /* synthetic */ void getLimitStart$annotations() {
        }

        public final boolean component1() {
            return this.enable;
        }

        public final float component2() {
            return this.frequency;
        }

        public final int component3() {
            return this.limitStart;
        }

        public final int component4() {
            return this.limitEnd;
        }

        public final WaitingEventConfig copy(boolean r100, float r101, int r102, int r103) {
            return new WaitingEventConfig(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof WaitingEventConfig) == true) goto L8;
            return false;
        L8:
            WaitingEventConfig r101 = (WaitingEventConfig) r100;
            if (this.enable == r101.enable) goto L12;
            return false;
        L12:
            if (Float.compare(this.frequency, r101.frequency) == 0) goto L15;
            return false;
        L15:
            if (this.limitStart == r101.limitStart) goto L18;
            return false;
        L18:
            if (this.limitEnd == r101.limitEnd) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            if (this.enable == false) goto L5;
            int r100 = 1231;
        L7:
            return (((((r100 * 31) + Float.floatToIntBits(this.frequency)) * 31) + this.limitStart) * 31) + this.limitEnd;
        L5:
            r100 = 1237;
            goto L7
        }

        public String toString() {
            return "WaitingEventConfig(enable=" + this.enable + ", frequency=" + this.frequency + ", limitStart=" + this.limitStart + ", limitEnd=" + this.limitEnd + ')';
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final float getFrequency() {
            return this.frequency;
        }

        public final int getLimitEnd() {
            return this.limitEnd;
        }

        public final int getLimitStart() {
            return this.limitStart;
        }

        public WaitingEventConfig(boolean r100, float r101, int r102, int r103) {
            this.enable = r100;
            this.frequency = r101;
            this.limitStart = r102;
            this.limitEnd = r103;
        }

        public /* synthetic */ WaitingEventConfig(boolean r100, float r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = 0.0f;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = 0;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = 0;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Serializable
    public static final class a {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f288770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f288771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f288772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f288773d;

        /* JADX INFO: renamed from: com.larus.audio.call.RealtimeCallParam$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class C3958a implements m0<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C3958a f288774a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f288775b = null;

            public C3958a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                v2 r100 = v2.f520790a;
                return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(w0.f520792a)};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f288775b;
            }

            static {
                C3958a r100 = new C3958a();
                f288774a = r100;
                g2 r101 = new g2("com.larus.audio.call.RealtimeCallParam.ASTChannelInfo", r100, 4);
                r101.j("channel", true);
                r101.j("src_lang", true);
                r101.j("dest_lang", true);
                r101.j("speaker_mode", true);
                f288775b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f288775b;
                muc.c r101 = r110.beginStructure(r100);
                String r102 = null;
                if (r101.decodeSequentially() == false) goto L5;
                v2 r103 = v2.f520790a;
                String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
                String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
                String r111 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
                Integer r112 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, null);
                String r113 = r104;
                String r114 = r105;
                int r115 = 15;
            L21:
                r101.endStructure(r100);
                return new a(r115, r113, r114, r111, r112);
            L5:
                String r106 = null;
                String r107 = null;
                Integer r116 = null;
                int r108 = 0;
                boolean r117 = true;
            L6:
                if (r117 == false) goto L20;
                int r118 = r101.decodeElementIndex(r100);
                if (r118 != (-1)) goto L9;
                r117 = false;
                goto L6
            L9:
                if (r118 != 0) goto L10;
                r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
                r108 = r108 | 1;
                goto L6
            L10:
                if (r118 != 1) goto L11;
                r106 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r106);
                r108 = r108 | 2;
                goto L6
            L11:
                if (r118 != 2) goto L12;
                r107 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r107);
                r108 = r108 | 4;
                goto L6
            L12:
                if (r118 != 3) goto L15;
                r116 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r116);
                r108 = r108 | 8;
                goto L6
            L15:
                throw new UnknownFieldException(r118);
            L20:
                r115 = r108;
                r113 = r102;
                r114 = r106;
                r111 = r107;
                r112 = r116;
                goto L21
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                a r102 = (a) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f288775b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = a.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f288770a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f288771b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f288772c);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == true) goto L37;
                Integer r110 = r102.f288773d;
                if (r110 == null) goto L37;
                if (r110.intValue() != 0) goto L37;
            L38:
                if (r106 == false) goto L40;
                r104.encodeNullableSerializableElement(r103, 3, w0.f520792a, r102.f288773d);
            L40:
                r104.endStructure(r103);
                return;
            L37:
                r106 = true;
                goto L38
            L24:
                if (Intrinsics.areEqual(r102.f288772c, "") == false) goto L25;
                r109 = false;
                goto L27
            L15:
                if (Intrinsics.areEqual(r102.f288771b, "") == false) goto L16;
                r108 = false;
                goto L18
            L6:
                if (Intrinsics.areEqual(r102.f288770a, "") == false) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<a> serializer() {
                return C3958a.f288774a;
            }
        }

        public a() {
            this("", "", "", 0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f288770a, r101.f288770a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f288771b, r101.f288771b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f288772c, r101.f288772c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f288773d, r101.f288773d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f288770a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f288771b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f288772c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.f288773d;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ASTChannelInfo(channel=" + this.f288770a + ", srcLanguage=" + this.f288771b + ", destLanguage=" + this.f288772c + ", speakerMode=" + this.f288773d + ')';
        }

        static {
            Companion = new b();
        }

        public a(String r100, String r101, String r102, Integer r103) {
            this.f288770a = r100;
            this.f288771b = r101;
            this.f288772c = r102;
            this.f288773d = r103;
        }

        public a(int r100, String r101, String r102, String r103, Integer r104) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, C3958a.f288775b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f288770a = "";
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f288771b = "";
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f288772c = "";
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f288773d = 0;
            return;
        L19:
            this.f288773d = r104;
            return;
        L15:
            this.f288772c = r103;
            goto L17
        L11:
            this.f288771b = r102;
            goto L13
        L7:
            this.f288770a = r101;
            goto L9
        }
    }

    @Serializable
    public static final class b {
        public static final C3959b Companion = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<juc.d<Object>>[] f288776b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<a> f288777a;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements m0<b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f288778a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f288779b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f288779b;
            }

            static {
                a r100 = new a();
                f288778a = r100;
                g2 r101 = new g2("com.larus.audio.call.RealtimeCallParam.ASTConfig", r100, 1);
                r101.j("channels", true);
                f288779b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{kuc.a.d(b.f288776b[0].getValue())};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r100) {
                Intrinsics.checkNotNullParameter(r100, "decoder");
                g2 r101 = f288779b;
                muc.c r102 = r100.beginStructure(r101);
                Lazy<juc.d<Object>>[] r103 = b.f288776b;
                int r104 = 1;
                List r105 = null;
                if (r102.decodeSequentially() == false) goto L5;
                List r106 = (List) r102.decodeNullableSerializableElement(r101, 0, r103[0].getValue(), null);
            L15:
                r102.endStructure(r101);
                return new b(r104, r106);
            L5:
                int r107 = 0;
            L6:
                if (r104 == 0) goto L14;
                int r108 = r102.decodeElementIndex(r101);
                if (r108 != (-1)) goto L9;
                r104 = 0;
                goto L6
            L9:
                if (r108 != 0) goto L12;
                r105 = (List) r102.decodeNullableSerializableElement(r101, 0, r103[0].getValue(), r105);
                r107 = r107 | 1;
                goto L6
            L12:
                throw new UnknownFieldException(r108);
            L14:
                r104 = r107;
                r106 = r105;
                goto L15
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                b r102 = (b) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f288779b;
                muc.d r104 = r100.beginStructure(r103);
                Lazy<juc.d<Object>>[] r105 = b.f288776b;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r106 = true;
            L9:
                if (r106 == false) goto L11;
                r104.encodeNullableSerializableElement(r103, 0, r105[0].getValue(), r102.f288777a);
            L11:
                r104.endStructure(r103);
                return;
            L6:
                if (Intrinsics.areEqual(r102.f288777a, CollectionsKt.emptyList()) == false) goto L7;
                r106 = false;
                goto L9
            }
        }

        /* JADX INFO: renamed from: com.larus.audio.call.RealtimeCallParam$b$b, reason: collision with other inner class name */
        public static final class C3959b {
            public C3959b() {
            }

            public final juc.d<b> serializer() {
                return a.f288778a;
            }
        }

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f288777a, ((b) r100).f288777a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<a> r100 = this.f288777a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ASTConfig(channelList=" + this.f288777a + ')';
        }

        static {
            Companion = new C3959b();
            f288776b = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new com.larus.audio.call.m())};
        }

        public b(Object r100) {
            this.f288777a = CollectionsKt.emptyList();
        }

        public b(int r100, List r101) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f288779b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f288777a = CollectionsKt.emptyList();
            return;
        L7:
            this.f288777a = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f288780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f288781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f288782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f288783d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f288780a, r101.f288780a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f288781b, r101.f288781b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f288782c, r101.f288782c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f288783d, r101.f288783d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f288780a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f288781b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f288782c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f288783d;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "actionBarKey=" + this.f288783d + " actionBarItemId:" + this.f288780a + ",actionBarRecommendRequestId:" + this.f288781b + ",actionBarRecommendFrom:" + this.f288782c;
        }

        public c(String r100, String r101, String r102, String r103) {
            this.f288780a = r100;
            this.f288781b = r101;
            this.f288782c = r102;
            this.f288783d = r103;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final /* synthetic */ int f288784v = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f288785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f288786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f288787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f288788d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f288789e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f288790f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f288791g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f288792h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f288793i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f288794j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f288795k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f288796l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f288797m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f288798n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f288799o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f288800p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f288801q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f288802r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final String f288803s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f288804t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f288805u;

        public static final class a {
        }

        static {
        }

        public d() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f288785a, r101.f288785a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f288786b, r101.f288786b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f288787c, r101.f288787c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f288788d, r101.f288788d) == true) goto L21;
            return false;
        L21:
            if (this.f288789e == r101.f288789e) goto L24;
            return false;
        L24:
            if (this.f288790f == r101.f288790f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f288791g, r101.f288791g) == true) goto L30;
            return false;
        L30:
            if (this.f288792h == r101.f288792h) goto L33;
            return false;
        L33:
            if (this.f288793i == r101.f288793i) goto L36;
            return false;
        L36:
            if (this.f288794j == r101.f288794j) goto L39;
            return false;
        L39:
            if (this.f288795k == r101.f288795k) goto L42;
            return false;
        L42:
            if (this.f288796l == r101.f288796l) goto L45;
            return false;
        L45:
            if (this.f288797m == r101.f288797m) goto L48;
            return false;
        L48:
            if (this.f288798n == r101.f288798n) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.f288799o, r101.f288799o) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.f288800p, r101.f288800p) == true) goto L57;
            return false;
        L57:
            if (this.f288801q == r101.f288801q) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.f288802r, r101.f288802r) == true) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.f288803s, r101.f288803s) == true) goto L66;
            return false;
        L66:
            if (this.f288804t == r101.f288804t) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.f288805u, r101.f288805u) == true) goto L71;
            return false;
        L71:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((((((((((((((this.f288785a.hashCode() * 31) + this.f288786b.hashCode()) * 31) + this.f288787c.hashCode()) * 31) + this.f288788d.hashCode()) * 31) + this.f288789e) * 31) + this.f288790f) * 31) + this.f288791g.hashCode()) * 31) + this.f288792h) * 31) + this.f288793i) * 31) + this.f288794j) * 31) + this.f288795k) * 31) + this.f288796l) * 31;
            int r101 = 1231;
            if (this.f288797m == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f288798n == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (((((r103 + r104) * 31) + this.f288799o.hashCode()) * 31) + this.f288800p.hashCode()) * 31;
            if (this.f288801q == false) goto L13;
            int r106 = 1231;
        L14:
            int r107 = (((((r105 + r106) * 31) + this.f288802r.hashCode()) * 31) + this.f288803s.hashCode()) * 31;
            if (this.f288804t == true) goto L19;
            r101 = 1237;
        L19:
            return ((r107 + r101) * 31) + this.f288805u.hashCode();
        L13:
            r106 = 1237;
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "taskId:" + this.f288785a + ",sessionId:" + this.f288786b + ",conversationId:" + this.f288787c + ",language:" + this.f288788d + ",sampleRate:" + this.f288789e + ",channel:" + this.f288790f + ",format:" + this.f288791g + ",interruptType:" + this.f288792h + ",enablePunctuation:" + this.f288793i + ",enableAudioCache:" + this.f288794j + ",audioCacheSize:" + this.f288795k + ",enableRemoveFirstAudioData:" + this.f288796l + ",enablePreQuery:" + this.f288797m + ",enableChatComfort:" + this.f288798n + ",extra:" + this.f288799o + ",model:" + this.f288800p + ",isDoraOnboarding:" + this.f288801q + ",isNewDoraOnboarding:" + this.f288802r + ",isNewUser:" + this.f288803s + ",nonStreamModel:" + this.f288805u;
        }

        public /* synthetic */ d(int r210) {
            this("", "", "", "", 16000, 1, "pcm", 1, 1, 1, 1920000, 0, false, false, "", "", false, "0", "", false, "");
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f288799o = r100;
        }

        public d(String r110, String r111, String r112, String r113, int r114, int r115, String r116, int r210, int r211, int r212, int r213, int r214, boolean r215, boolean r216, String r217, String r218, boolean r219, String r310, String r311, boolean r312, String r313) {
            Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r111, "sessionId");
            Intrinsics.checkNotNullParameter(r112, "conversationId");
            Intrinsics.checkNotNullParameter(r113, "language");
            Intrinsics.checkNotNullParameter(r116, SubInfo.KEY_FORMAT);
            Intrinsics.checkNotNullParameter(r217, "extra");
            Intrinsics.checkNotNullParameter(r218, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r310, "isNewDoraOnboarding");
            Intrinsics.checkNotNullParameter(r311, "isNewUser");
            Intrinsics.checkNotNullParameter(r313, "asrTwoPassNonStreamModel");
            this.f288785a = r110;
            this.f288786b = r111;
            this.f288787c = r112;
            this.f288788d = r113;
            this.f288789e = r114;
            this.f288790f = r115;
            this.f288791g = r116;
            this.f288792h = r210;
            this.f288793i = r211;
            this.f288794j = r212;
            this.f288795k = r213;
            this.f288796l = r214;
            this.f288797m = r215;
            this.f288798n = r216;
            this.f288799o = r217;
            this.f288800p = r218;
            this.f288801q = r219;
            this.f288802r = r310;
            this.f288803s = r311;
            this.f288804t = r312;
            this.f288805u = r313;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f288806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f288807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f288808c;

        public e(boolean r100, int r101, int[] r102) {
            this.f288806a = r100;
            this.f288807b = r101;
            this.f288808c = r102;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f288809a;

        public f() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f288809a, ((f) r100).f288809a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            e r100 = this.f288809a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "AudioRetransmitStrategy(data=" + this.f288809a + ')';
        }

        public /* synthetic */ f(int r100) {
            this(new e(true, 0, new int[]{200, 400, 800, 1600, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT}));
        }

        public f(e r100) {
            this.f288809a = r100;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f288810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f288811b;

        public g() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f288810a, r101.f288810a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f288811b, r101.f288811b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.f288810a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Long r104 = this.f288811b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "BackTraceParams(historyLengthMs=" + this.f288810a + ", wakeupTimeStamp=" + this.f288811b + ')';
        }

        public g(Long r100, Long r101) {
            this.f288810a = r100;
            this.f288811b = r101;
        }
    }

    public static final class h {
        public boolean A;
        public boolean B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f288812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f288813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f288814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f288815d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f288816e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f288817f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f288818g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f288819h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f288820i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f288821j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f288822k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public f f288823l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f288824m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f288825n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f288826o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f288827p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f288828q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f288829r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f288830s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f288831t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Integer f288832u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f288833v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f288834w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f288835x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f288836y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f288837z;

        public h() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.f288812a, r101.f288812a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f288813b, r101.f288813b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f288814c, r101.f288814c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f288815d, r101.f288815d) == true) goto L21;
            return false;
        L21:
            if (this.f288816e == r101.f288816e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f288817f, r101.f288817f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f288818g, r101.f288818g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f288819h, r101.f288819h) == true) goto L33;
            return false;
        L33:
            if (this.f288820i == r101.f288820i) goto L36;
            return false;
        L36:
            if (this.f288821j == r101.f288821j) goto L39;
            return false;
        L39:
            if (this.f288822k == r101.f288822k) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f288823l, r101.f288823l) == true) goto L45;
            return false;
        L45:
            if (this.f288824m == r101.f288824m) goto L48;
            return false;
        L48:
            if (this.f288825n == r101.f288825n) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.f288826o, r101.f288826o) == true) goto L54;
            return false;
        L54:
            if (this.f288827p == r101.f288827p) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.f288828q, r101.f288828q) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.f288829r, r101.f288829r) == true) goto L63;
            return false;
        L63:
            if (this.f288830s == r101.f288830s) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.f288831t, r101.f288831t) == true) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.f288832u, r101.f288832u) == true) goto L72;
            return false;
        L72:
            if (this.f288833v == r101.f288833v) goto L75;
            return false;
        L75:
            if (this.f288834w == r101.f288834w) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.f288835x, r101.f288835x) == true) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.f288836y, r101.f288836y) == true) goto L84;
            return false;
        L84:
            if (Intrinsics.areEqual(this.f288837z, r101.f288837z) == true) goto L87;
            return false;
        L87:
            if (this.A == r101.A) goto L90;
            return false;
        L90:
            if (this.B == r101.B) goto L92;
            return false;
        L92:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((((((((((((((((((((this.f288812a.hashCode() * 31) + this.f288813b.hashCode()) * 31) + this.f288814c.hashCode()) * 31) + this.f288815d.hashCode()) * 31) + this.f288816e) * 31) + this.f288817f.hashCode()) * 31) + this.f288818g.hashCode()) * 31) + this.f288819h.hashCode()) * 31) + this.f288820i) * 31) + this.f288821j) * 31) + this.f288822k) * 31) + this.f288823l.hashCode()) * 31) + this.f288824m) * 31) + this.f288825n) * 31) + this.f288826o.hashCode()) * 31;
            int r101 = 1231;
            if (this.f288827p == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (((((((((r100 + r102) * 31) + this.f288828q.hashCode()) * 31) + this.f288829r.hashCode()) * 31) + this.f288830s) * 31) + this.f288831t.hashCode()) * 31;
            Integer r104 = this.f288832u;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            if (this.f288833v == false) goto L13;
            int r107 = 1231;
        L14:
            int r108 = (r106 + r107) * 31;
            if (this.f288834w == false) goto L17;
            int r109 = 1231;
        L18:
            int r110 = (((((((r108 + r109) * 31) + this.f288835x.hashCode()) * 31) + this.f288836y.hashCode()) * 31) + this.f288837z.hashCode()) * 31;
            if (this.A == false) goto L21;
            int r111 = 1231;
        L22:
            int r112 = (r110 + r111) * 31;
            if (this.B == true) goto L27;
            r101 = 1237;
        L27:
            return r112 + r101;
        L21:
            r111 = 1237;
            goto L22
        L17:
            r109 = 1237;
            goto L18
        L13:
            r107 = 1237;
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String a() {
            String r100 = this.f288831t;
            switch(r100.hashCode()) {
                case -1449454789: goto L16;
                case -450882357: goto L12;
                case 407405714: goto L9;
                case 785611651: goto L6;
                default: goto L17;
            };
        L17:
            return NotificationCompat.CATEGORY_CALL;
        L6:
            if (r100.equals("dora_call") == false) goto L17;
            return "dora_call";
        L9:
            if (r100.equals("radio_single_turn_conversation") == false) goto L17;
            return "dora_radio";
        L12:
            if (r100.equals("assistant_scene_mode_click_talk") == false) goto L17;
            return "obric_click_talk";
        L16:
            if (r100.equals("radio_multi_turn_conversation") == false) goto L17;
            return "dora_radio";
        }

        public final String toString() {
            return "url:" + this.f288812a + ",appKey:" + this.f288813b + ",token:" + this.f288814c + ",header:" + this.f288815d + ",connectTimeout:" + this.f288816e + ",appVersion:" + this.f288819h + ",appVersionCode:" + this.f288820i + ",appUpdateVersionCode:" + this.f288821j + ",maxDuration:" + this.f288822k + "isMockChat:" + this.f288824m + ",business:" + this.f288825n + ",requestType:" + this.f288826o + ",subConvFirstMetType:" + this.f288828q + ",subConvSourceMessage:" + this.f288829r + ",sceneMode:" + this.f288831t;
        }

        public /* synthetic */ h(int r310) {
            this("", "", "", "", 10000, "", "", "", 0, 0, 5400, new f(0), 0, 1, "", false, "", "", 0, NotificationCompat.CATEGORY_CALL, null, false, false, "VoiceGenie", "", "", false, false);
        }

        public h(String r110, String r111, String r112, String r210, int r211, String r212, String r213, String r214, int r215, int r216, int r217, f r218, int r219, @BusinessType int r310, String r311, boolean r312, String r313, String r314, int r315, String r316, Integer r317, boolean r318, boolean r319, String r410, String r411, String r412, boolean r413, boolean r414) {
            Intrinsics.checkNotNullParameter(r110, "url");
            Intrinsics.checkNotNullParameter(r111, com.heytap.mcssdk.constant.b.f276376z);
            Intrinsics.checkNotNullParameter(r112, "token");
            Intrinsics.checkNotNullParameter(r210, "header");
            Intrinsics.checkNotNullParameter(r212, "uid");
            Intrinsics.checkNotNullParameter(r213, com.bytedance.android.ec.core.event.a.KEY_DID);
            Intrinsics.checkNotNullParameter(r214, "appVersion");
            Intrinsics.checkNotNullParameter(r218, "retransmitStrategy");
            Intrinsics.checkNotNullParameter(r311, "requestType");
            Intrinsics.checkNotNullParameter(r313, "subConvFirstMetType");
            Intrinsics.checkNotNullParameter(r314, "subConvSourceMessage");
            Intrinsics.checkNotNullParameter(r316, "sceneMode");
            Intrinsics.checkNotNullParameter(r410, "namespace");
            Intrinsics.checkNotNullParameter(r411, PlayerResolution.SDKKEY.ORIGIN);
            Intrinsics.checkNotNullParameter(r412, "streamApp");
            this.f288812a = r110;
            this.f288813b = r111;
            this.f288814c = r112;
            this.f288815d = r210;
            this.f288816e = r211;
            this.f288817f = r212;
            this.f288818g = r213;
            this.f288819h = r214;
            this.f288820i = r215;
            this.f288821j = r216;
            this.f288822k = r217;
            this.f288823l = r218;
            this.f288824m = r219;
            this.f288825n = r310;
            this.f288826o = r311;
            this.f288827p = r312;
            this.f288828q = r313;
            this.f288829r = r314;
            this.f288830s = r315;
            this.f288831t = r316;
            this.f288832u = r317;
            this.f288833v = r318;
            this.f288834w = r319;
            this.f288835x = r410;
            this.f288836y = r411;
            this.f288837z = r412;
            this.A = r413;
            this.B = r414;
        }
    }

    public static final class i {
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f288838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f288839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f288840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f288841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f288842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public h1 f288843f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f288844g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f288845h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f288846i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f288847j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f288848k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f288849l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Map<String, String> f288850m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Map<String, Object> f288851n;

        public j() {
            this.f288844g = "zh";
            this.f288845h = "en";
            this.f288846i = "FaceToFace";
            this.f288848k = "";
            this.f288849l = "";
            this.f288850m = new LinkedHashMap();
            this.f288851n = new LinkedHashMap();
        }
    }

    public static final class k {
        public Boolean A;
        public final boolean B;
        public DoraEndType C;
        public boolean D;
        public boolean E;
        public boolean F;
        public boolean G;
        public String H;
        public String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public String f288852J;
        public Boolean K;
        public Integer L;
        public String M;
        public final String N;
        public String O;
        public String P;
        public Long Q;
        public boolean R;
        public final String S;
        public boolean T;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f288853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f288854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f288855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f288856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f288857e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f288858f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f288859g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public n f288860h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f288861i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f288862j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f288863k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f288864l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f288865m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f288866n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public c f288867o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f288868p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f288869q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f288870r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f288871s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f288872t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f288873u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f288874v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f288875w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f288876x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f288877y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f288878z;

        public k() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (Intrinsics.areEqual(this.f288853a, r101.f288853a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f288854b, r101.f288854b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f288855c, r101.f288855c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f288856d, r101.f288856d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f288857e, r101.f288857e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f288858f, r101.f288858f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f288859g, r101.f288859g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f288860h, r101.f288860h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f288861i, r101.f288861i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f288862j, r101.f288862j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f288863k, r101.f288863k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f288864l, r101.f288864l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.f288865m, r101.f288865m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.f288866n, r101.f288866n) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.f288867o, r101.f288867o) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.f288868p, r101.f288868p) == true) goto L57;
            return false;
        L57:
            if (this.f288869q == r101.f288869q) goto L60;
            return false;
        L60:
            if (this.f288870r == r101.f288870r) goto L63;
            return false;
        L63:
            if (this.f288871s == r101.f288871s) goto L66;
            return false;
        L66:
            if (this.f288872t == r101.f288872t) goto L69;
            return false;
        L69:
            if (this.f288873u == r101.f288873u) goto L72;
            return false;
        L72:
            if (Intrinsics.areEqual(this.f288874v, r101.f288874v) == true) goto L75;
            return false;
        L75:
            if (Intrinsics.areEqual(this.f288875w, r101.f288875w) == true) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.f288876x, r101.f288876x) == true) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.f288877y, r101.f288877y) == true) goto L84;
            return false;
        L84:
            if (Intrinsics.areEqual(this.f288878z, r101.f288878z) == true) goto L87;
            return false;
        L87:
            if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
            return false;
        L90:
            if (this.B == r101.B) goto L93;
            return false;
        L93:
            if (this.C == r101.C) goto L96;
            return false;
        L96:
            if (this.D == r101.D) goto L99;
            return false;
        L99:
            if (this.E == r101.E) goto L102;
            return false;
        L102:
            if (this.F == r101.F) goto L105;
            return false;
        L105:
            if (this.G == r101.G) goto L108;
            return false;
        L108:
            if (Intrinsics.areEqual(this.H, r101.H) == true) goto L111;
            return false;
        L111:
            if (Intrinsics.areEqual(this.I, r101.I) == true) goto L114;
            return false;
        L114:
            if (Intrinsics.areEqual(this.f288852J, r101.f288852J) == true) goto L117;
            return false;
        L117:
            if (Intrinsics.areEqual(this.K, r101.K) == true) goto L120;
            return false;
        L120:
            if (Intrinsics.areEqual(this.L, r101.L) == true) goto L123;
            return false;
        L123:
            if (Intrinsics.areEqual(this.M, r101.M) == true) goto L126;
            return false;
        L126:
            if (Intrinsics.areEqual(this.N, r101.N) == true) goto L129;
            return false;
        L129:
            if (Intrinsics.areEqual(this.O, r101.O) == true) goto L132;
            return false;
        L132:
            if (Intrinsics.areEqual(this.P, r101.P) == true) goto L135;
            return false;
        L135:
            if (Intrinsics.areEqual(this.Q, r101.Q) == true) goto L138;
            return false;
        L138:
            if (this.R == r101.R) goto L141;
            return false;
        L141:
            if (Intrinsics.areEqual(this.S, r101.S) == true) goto L144;
            return false;
        L144:
            if (this.T == r101.T) goto L146;
            return false;
        L146:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f288853a.hashCode() * 31) + this.f288854b.hashCode()) * 31) + this.f288855c.hashCode()) * 31) + this.f288856d.hashCode()) * 31;
            String r101 = this.f288857e;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f288858f;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f288859g;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            n r111 = this.f288860h;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            String r114 = this.f288861i;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f288862j;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            String r120 = this.f288863k;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            String r123 = this.f288864l;
            if (r123 != null) goto L33;
            int r124 = 0;
        L34:
            int r125 = (r122 + r124) * 31;
            String r126 = this.f288865m;
            if (r126 != null) goto L37;
            int r127 = 0;
        L38:
            int r128 = (r125 + r127) * 31;
            String r129 = this.f288866n;
            if (r129 != null) goto L41;
            int r130 = 0;
        L42:
            int r131 = (r128 + r130) * 31;
            c r132 = this.f288867o;
            if (r132 != null) goto L45;
            int r133 = 0;
        L46:
            int r134 = (r131 + r133) * 31;
            String r135 = this.f288868p;
            if (r135 != null) goto L49;
            int r136 = 0;
        L50:
            int r137 = (r134 + r136) * 31;
            int r138 = 1231;
            if (this.f288869q == false) goto L53;
            int r139 = 1231;
        L54:
            int r140 = (r137 + r139) * 31;
            if (this.f288870r == false) goto L57;
            int r141 = 1231;
        L58:
            long r142 = this.f288871s;
            int r143 = (((r140 + r141) * 31) + ((int) (r142 ^ (r142 >>> 32)))) * 31;
            if (this.f288872t == false) goto L61;
            int r144 = 1231;
        L62:
            int r145 = (r143 + r144) * 31;
            if (this.f288873u == false) goto L65;
            int r146 = 1231;
        L66:
            int r147 = (r145 + r146) * 31;
            String r148 = this.f288874v;
            if (r148 != null) goto L69;
            int r149 = 0;
        L70:
            int r150 = (r147 + r149) * 31;
            String r151 = this.f288875w;
            if (r151 != null) goto L73;
            int r152 = 0;
        L74:
            int r153 = (r150 + r152) * 31;
            String r154 = this.f288876x;
            if (r154 != null) goto L77;
            int r155 = 0;
        L78:
            int r156 = (r153 + r155) * 31;
            String r157 = this.f288877y;
            if (r157 != null) goto L81;
            int r158 = 0;
        L82:
            int r159 = (r156 + r158) * 31;
            String r160 = this.f288878z;
            if (r160 != null) goto L85;
            int r161 = 0;
        L86:
            int r162 = (r159 + r161) * 31;
            Boolean r163 = this.A;
            if (r163 != null) goto L89;
            int r164 = 0;
        L90:
            int r165 = (r162 + r164) * 31;
            if (this.B == false) goto L93;
            int r166 = 1231;
        L94:
            int r167 = (r165 + r166) * 31;
            DoraEndType r168 = this.C;
            if (r168 != null) goto L97;
            int r169 = 0;
        L98:
            int r170 = (r167 + r169) * 31;
            if (this.D == false) goto L101;
            int r171 = 1231;
        L102:
            int r172 = (r170 + r171) * 31;
            if (this.E == false) goto L105;
            int r173 = 1231;
        L106:
            int r174 = (r172 + r173) * 31;
            if (this.F == false) goto L109;
            int r175 = 1231;
        L110:
            int r176 = (r174 + r175) * 31;
            if (this.G == false) goto L113;
            int r177 = 1231;
        L114:
            int r178 = (r176 + r177) * 31;
            String r179 = this.H;
            if (r179 != null) goto L117;
            int r180 = 0;
        L118:
            int r181 = (r178 + r180) * 31;
            String r182 = this.I;
            if (r182 != null) goto L121;
            int r183 = 0;
        L122:
            int r184 = (r181 + r183) * 31;
            String r185 = this.f288852J;
            if (r185 != null) goto L125;
            int r186 = 0;
        L126:
            int r187 = (r184 + r186) * 31;
            Boolean r188 = this.K;
            if (r188 != null) goto L129;
            int r189 = 0;
        L130:
            int r190 = (r187 + r189) * 31;
            Integer r191 = this.L;
            if (r191 != null) goto L133;
            int r192 = 0;
        L134:
            int r193 = (((r190 + r192) * 31) + this.M.hashCode()) * 31;
            String r194 = this.N;
            if (r194 != null) goto L137;
            int r195 = 0;
        L138:
            int r196 = (r193 + r195) * 31;
            String r197 = this.O;
            if (r197 != null) goto L141;
            int r198 = 0;
        L142:
            int r199 = (r196 + r198) * 31;
            String r200 = this.P;
            if (r200 != null) goto L145;
            int r201 = 0;
        L146:
            int r202 = (r199 + r201) * 31;
            Long r203 = this.Q;
            if (r203 != null) goto L149;
            int r204 = 0;
        L150:
            int r205 = (r202 + r204) * 31;
            if (this.R == false) goto L153;
            int r206 = 1231;
        L154:
            int r207 = (r205 + r206) * 31;
            String r208 = this.S;
            if (r208 == null) goto L158;
            r102 = r208.hashCode();
        L158:
            int r209 = (r207 + r102) * 31;
            if (this.T == true) goto L163;
            r138 = 1237;
        L163:
            return r209 + r138;
        L153:
            r206 = 1237;
            goto L154
        L149:
            r204 = r203.hashCode();
            goto L150
        L145:
            r201 = r200.hashCode();
            goto L146
        L141:
            r198 = r197.hashCode();
            goto L142
        L137:
            r195 = r194.hashCode();
            goto L138
        L133:
            r192 = r191.hashCode();
            goto L134
        L129:
            r189 = r188.hashCode();
            goto L130
        L125:
            r186 = r185.hashCode();
            goto L126
        L121:
            r183 = r182.hashCode();
            goto L122
        L117:
            r180 = r179.hashCode();
            goto L118
        L113:
            r177 = 1237;
            goto L114
        L109:
            r175 = 1237;
            goto L110
        L105:
            r173 = 1237;
            goto L106
        L101:
            r171 = 1237;
            goto L102
        L97:
            r169 = r168.hashCode();
            goto L98
        L93:
            r166 = 1237;
            goto L94
        L89:
            r164 = r163.hashCode();
            goto L90
        L85:
            r161 = r160.hashCode();
            goto L86
        L81:
            r158 = r157.hashCode();
            goto L82
        L77:
            r155 = r154.hashCode();
            goto L78
        L73:
            r152 = r151.hashCode();
            goto L74
        L69:
            r149 = r148.hashCode();
            goto L70
        L65:
            r146 = 1237;
            goto L66
        L61:
            r144 = 1237;
            goto L62
        L57:
            r141 = 1237;
            goto L58
        L53:
            r139 = 1237;
            goto L54
        L49:
            r136 = r135.hashCode();
            goto L50
        L45:
            r133 = r132.hashCode();
            goto L46
        L41:
            r130 = r129.hashCode();
            goto L42
        L37:
            r127 = r126.hashCode();
            goto L38
        L33:
            r124 = r123.hashCode();
            goto L34
        L29:
            r121 = r120.hashCode();
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "previousPage:" + this.f288854b + ",enterFrom:" + this.f288855c + ",currentPage:" + this.f288856d + ",recommendFromScene:" + this.f288857e + ",recommendFromReqId:" + this.f288858f + ",chatType:" + this.f288859g + ",searchMobParam:" + this.f288860h + ",enterMethod:" + this.f288861i + ",endMethod:" + this.f288862j + ",secScene:" + this.f288863k + ",fromActivityName:" + this.f288864l + ",fromActivityModule:" + this.f288865m + ",isCallBot:" + this.f288866n + ",actionBarInfo:" + this.f288867o + ",botSayHelloTextKey:" + this.f288868p + ",isContinuousTalk:" + this.f288869q + ",enableSilenceTimeout:" + this.f288870r + ",silenceTimeoutMs:" + this.f288871s + ",openVlmOnStart:" + this.f288872t + ",avatar:" + this.f288874v + ",summaryId:" + this.f288875w + ",summaryScene:" + this.f288876x;
        }

        public k(int r100) {
            Boolean r101 = Boolean.FALSE;
            Intrinsics.checkNotNullParameter("", "pushMsgId");
            Intrinsics.checkNotNullParameter("", "previousPage");
            Intrinsics.checkNotNullParameter("", "enterFrom");
            Intrinsics.checkNotNullParameter("", "currentPage");
            Intrinsics.checkNotNullParameter("", "doraRtosVersionCode");
            this.f288853a = "";
            this.f288854b = "";
            this.f288855c = "";
            this.f288856d = "";
            this.f288857e = null;
            this.f288858f = null;
            this.f288859g = null;
            this.f288860h = null;
            this.f288861i = null;
            this.f288862j = null;
            this.f288863k = null;
            this.f288864l = null;
            this.f288865m = null;
            this.f288866n = null;
            this.f288867o = null;
            this.f288868p = null;
            this.f288869q = false;
            this.f288870r = false;
            this.f288871s = 0;
            this.f288872t = false;
            this.f288873u = false;
            this.f288874v = null;
            this.f288875w = null;
            this.f288876x = null;
            this.f288877y = null;
            this.f288878z = null;
            this.A = null;
            this.B = false;
            this.C = null;
            this.D = false;
            this.E = false;
            this.F = false;
            this.G = false;
            this.H = null;
            this.I = null;
            this.f288852J = null;
            this.K = r101;
            this.L = 0;
            this.M = "";
            this.N = null;
            this.O = null;
            this.P = null;
            this.Q = null;
            this.R = false;
            this.S = null;
            this.T = false;
        }
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f288879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f288880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f288881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f288882d;

        public l() {
            this(false, null, 0, 15);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L8;
            return false;
        L8:
            l r101 = (l) r100;
            if (this.f288879a == r101.f288879a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f288880b, r101.f288880b) == true) goto L15;
            return false;
        L15:
            if (this.f288881c == r101.f288881c) goto L18;
            return false;
        L18:
            if (this.f288882d == r101.f288882d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f288879a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = ((r101 * 31) + this.f288880b.hashCode()) * 31;
            long r103 = this.f288881c;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            if (this.f288882d == true) goto L11;
            r100 = 1237;
        L11:
            return r104 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "OneshotParams(enable=" + this.f288879a + ", keyword=" + this.f288880b + ", offset=" + this.f288881c + ", breathWakeup=" + this.f288882d + ')';
        }

        public /* synthetic */ l(boolean r100, String r101, long r102, int r110) {
            if ((r110 & 1) == 0) goto L5;
            boolean r103 = false;
        L7:
            if ((r110 & 2) == 0) goto L9;
            r101 = "";
        L9:
            String r104 = r101;
            if ((r110 & 4) == 0) goto L12;
            r102 = -1;
        L12:
            this(r103, r104, r102, false);
            return;
        L5:
            r103 = r100;
            goto L7
        }

        public l(boolean r100, String r101, long r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "keyword");
            this.f288879a = r100;
            this.f288880b = r101;
            this.f288881c = r102;
            this.f288882d = r103;
        }
    }

    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f288883a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f288883a, ((m) r100).f288883a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f288883a.hashCode();
        }

        public final String toString() {
            return "RTCConfig(rtcAppId=" + this.f288883a + ')';
        }

        public m(String r100) {
            Intrinsics.checkNotNullParameter(r100, "rtcAppId");
            this.f288883a = r100;
        }
    }

    public static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f288884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f288885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f288886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f288887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f288888e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f288889f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f288890g;

        public n() {
            this(null, null, null, null, null, null, 127);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L8;
            return false;
        L8:
            n r101 = (n) r100;
            if (Intrinsics.areEqual(this.f288884a, r101.f288884a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f288885b, r101.f288885b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f288886c, r101.f288886c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f288887d, r101.f288887d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f288888e, r101.f288888e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f288889f, r101.f288889f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f288890g, r101.f288890g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f288884a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f288885b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f288886c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f288887d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f288888e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f288889f;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.f288890g;
            if (r119 == null) goto L31;
            r101 = r119.hashCode();
        L31:
            return r118 + r101;
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "SearchMobParam(query=" + this.f288884a + ", queryId=" + this.f288885b + ", searchId=" + this.f288886c + ", searchRequestId=" + this.f288887d + ", searchResultId=" + this.f288888e + ", rank=" + this.f288889f + ", recommendFrom=" + this.f288890g + ')';
        }

        public n(String r100, String r101, String r102, String r103, String r104, String r105, int r106) {
            if ((r106 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r106 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r106 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r106 & 16) == 0) goto L15;
            r103 = null;
        L15:
            if ((r106 & 32) == 0) goto L18;
            r104 = null;
        L18:
            if ((r106 & 64) == 0) goto L20;
            r105 = null;
        L20:
            this.f288884a = r100;
            this.f288885b = r101;
            this.f288886c = r102;
            this.f288887d = null;
            this.f288888e = r103;
            this.f288889f = r104;
            this.f288890g = r105;
        }
    }

    public static final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f288891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f288892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f288893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f288894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f288895e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f288896f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f288897g;

        public o() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L8;
            return false;
        L8:
            o r101 = (o) r100;
            if (Intrinsics.areEqual(this.f288891a, r101.f288891a) == true) goto L12;
            return false;
        L12:
            if (this.f288892b == r101.f288892b) goto L15;
            return false;
        L15:
            if (this.f288893c == r101.f288893c) goto L18;
            return false;
        L18:
            if (this.f288894d == r101.f288894d) goto L21;
            return false;
        L21:
            if (this.f288895e == r101.f288895e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f288896f, r101.f288896f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f288897g, r101.f288897g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((this.f288891a.hashCode() * 31) + this.f288892b) * 31) + this.f288893c) * 31) + this.f288894d) * 31) + this.f288895e) * 31;
            String r101 = this.f288896f;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f288897g;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            e0 r100 = new e0();
            ouc.j.c(r100, SubInfo.KEY_FORMAT, this.f288891a);
            ouc.j.b(r100, "decoderLength", Integer.valueOf(this.f288892b));
            ouc.j.b(r100, "sampleRate", Integer.valueOf(this.f288893c));
            ouc.j.b(r100, "bitrate", Integer.valueOf(this.f288895e));
            ouc.j.b(r100, "channel", Integer.valueOf(this.f288894d));
            d0 r101 = r100.a();
            e0 r102 = new e0();
            r102.b("wakeup_audio_config", r101);
            ouc.j.c(r102, "model_path", this.f288896f);
            ouc.j.c(r102, "model_md5", this.f288897g);
            return r102.a().toString();
        }

        public o(int r100) {
            Intrinsics.checkNotNullParameter("speech_opus", SubInfo.KEY_FORMAT);
            this.f288891a = "speech_opus";
            this.f288892b = 80;
            this.f288893c = 16000;
            this.f288894d = 1;
            this.f288895e = 32000;
            this.f288896f = "";
            this.f288897g = "";
        }
    }

    public static final class p {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final /* synthetic */ int f288898x = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f288899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f288900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f288901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f288902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f288903e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f288904f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f288905g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f288906h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f288907i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f288908j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f288909k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f288910l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f288911m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f288912n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f288913o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f288914p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f288915q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f288916r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Map<String, String> f288917s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f288918t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f288919u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f288920v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f288921w;

        public static final class a {
        }

        public p() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L8;
            return false;
        L8:
            p r101 = (p) r100;
            if (Intrinsics.areEqual(this.f288899a, r101.f288899a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f288900b, r101.f288900b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f288901c, r101.f288901c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f288902d, r101.f288902d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f288903e, r101.f288903e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f288904f, r101.f288904f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f288905g, r101.f288905g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f288906h, r101.f288906h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f288907i, r101.f288907i) == true) goto L36;
            return false;
        L36:
            if (this.f288908j == r101.f288908j) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f288909k, r101.f288909k) == true) goto L42;
            return false;
        L42:
            if (this.f288910l == r101.f288910l) goto L45;
            return false;
        L45:
            if (this.f288911m == r101.f288911m) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.f288912n, r101.f288912n) == true) goto L51;
            return false;
        L51:
            if (this.f288913o == r101.f288913o) goto L54;
            return false;
        L54:
            if (this.f288914p == r101.f288914p) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.f288915q, r101.f288915q) == true) goto L60;
            return false;
        L60:
            if (this.f288916r == r101.f288916r) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.f288917s, r101.f288917s) == true) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.f288918t, r101.f288918t) == true) goto L69;
            return false;
        L69:
            if (Float.compare(this.f288919u, r101.f288919u) == 0) goto L72;
            return false;
        L72:
            if (this.f288920v == r101.f288920v) goto L74;
            return false;
        L74:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((((((((((((this.f288899a.hashCode() * 31) + this.f288900b.hashCode()) * 31) + this.f288901c.hashCode()) * 31) + this.f288902d.hashCode()) * 31) + this.f288903e.hashCode()) * 31) + this.f288904f.hashCode()) * 31) + this.f288905g.hashCode()) * 31) + this.f288906h.hashCode()) * 31) + this.f288907i.hashCode()) * 31) + this.f288908j) * 31) + this.f288909k.hashCode()) * 31;
            int r101 = 1231;
            if (this.f288910l == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (((((r100 + r102) * 31) + this.f288911m) * 31) + this.f288912n.hashCode()) * 31;
            if (this.f288913o == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            if (this.f288914p == false) goto L13;
            int r106 = 1231;
        L14:
            int r107 = (((r105 + r106) * 31) + this.f288915q.hashCode()) * 31;
            if (this.f288916r == true) goto L18;
            r101 = 1237;
        L18:
            int r108 = (r107 + r101) * 31;
            Map<String, String> r109 = this.f288917s;
            if (r109 != null) goto L21;
            int r110 = 0;
        L23:
            return ((((((r108 + r110) * 31) + this.f288918t.hashCode()) * 31) + Float.floatToIntBits(this.f288919u)) * 31) + this.f288920v;
        L21:
            r110 = r109.hashCode();
            goto L23
        L13:
            r106 = 1237;
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        static {
            int r100 = com.larus.audio.call.common.a.f289093a;
        }

        public final String toString() {
            return "taskId:" + this.f288899a + ",sessionId:" + this.f288900b + ",conversationId:" + this.f288901c + ",styleName:" + this.f288902d + ",llModelName:" + this.f288903e + ",voiceId:" + this.f288904f + ",speakerName:" + this.f288905g + ",botId:" + this.f288906h + ",botName:" + this.f288907i + ",sampleRate:" + this.f288908j + ",format:" + this.f288909k + ",enableNetTransportCompress:" + this.f288910l + ",bitRate:" + this.f288911m + ",extra:" + this.f288912n + ",enableAudioInput:" + this.f288913o + ",enableTextReading:" + this.f288914p + ",sessionExtra:" + this.f288915q + ",newCvs:" + this.f288916r + ",ext:" + this.f288917s + ",audioMetrics:" + this.f288918t + ",targetLufs:" + this.f288919u + ",loudNormAlgoType:" + this.f288920v;
        }

        public /* synthetic */ p(int r210) {
            this("", "", "", "", "", "", "", "", "", 24000, "pcm", false, 32000, "", false, false, "", false, null, "", 0.0f, 0);
        }

        public p(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, int r215, String r216, boolean r217, int r218, String r219, boolean r310, boolean r311, String r312, boolean r313, Map<String, String> r314, String r315, float r316, int r317) {
            Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r111, "sessionId");
            Intrinsics.checkNotNullParameter(r112, "conversationId");
            Intrinsics.checkNotNullParameter(r113, "styleName");
            Intrinsics.checkNotNullParameter(r210, "llModelName");
            Intrinsics.checkNotNullParameter(r211, "voiceId");
            Intrinsics.checkNotNullParameter(r212, "speakerName");
            Intrinsics.checkNotNullParameter(r213, "botId");
            Intrinsics.checkNotNullParameter(r214, "botName");
            Intrinsics.checkNotNullParameter(r216, SubInfo.KEY_FORMAT);
            Intrinsics.checkNotNullParameter(r219, "extra");
            Intrinsics.checkNotNullParameter(r312, "sessionExtra");
            Intrinsics.checkNotNullParameter(r315, "audioMetrics");
            this.f288899a = r110;
            this.f288900b = r111;
            this.f288901c = r112;
            this.f288902d = r113;
            this.f288903e = r210;
            this.f288904f = r211;
            this.f288905g = r212;
            this.f288906h = r213;
            this.f288907i = r214;
            this.f288908j = r215;
            this.f288909k = r216;
            this.f288910l = r217;
            this.f288911m = r218;
            this.f288912n = r219;
            this.f288913o = r310;
            this.f288914p = r311;
            this.f288915q = r312;
            this.f288916r = r313;
            this.f288917s = r314;
            this.f288918t = r315;
            this.f288919u = r316;
            this.f288920v = r317;
        }
    }

    static {
    }

    public final String toString() {
        return "roomId=" + this.f288743d + " callId:" + this.f288745e + ",llmModel:" + this.f288749i + ",commonConfig:" + this.f288751k + ",asrConfig:" + this.f288752l + ",wakeupInfo:" + this.f288753m + ",ttsConfig:" + this.f288755o + ",extra:" + this.f288756p + ",sessionExtra:" + this.f288757q + ",isRtc:" + y0.e(this.f288759s) + ", avSessionType:" + this.f288759s + ", isImmersiveBackgroundString:" + this.f288763w;
    }

    public RealtimeCallParam() {
        this.f288743d = "";
        this.f288745e = "";
        this.f288746f = "";
        this.f288748h = -1;
        this.f288749i = "";
        this.f288750j = new b(null);
        int r100 = 0;
        this.f288751k = new h(r100);
        this.f288752l = new d(r100);
        this.f288753m = new o(0);
        this.f288754n = new j();
        this.f288755o = new p(r100);
        this.f288756p = new k(0);
        this.f288757q = new d0(MapsKt.emptyMap());
        this.f288758r = new d0(MapsKt.emptyMap());
        this.f288759s = AudioSessionType.SAMI;
        this.f288763w = "0";
        this.f288764x = AvAudioKitMode.PURE_BIZ;
        this.f288765y = true;
        this.G = "";
        this.H = "";
        this.I = -1;
        this.f288736J = "";
        this.K = "";
        this.R = "";
    }

    public final void a(AvAudioKitMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f288764x = r100;
    }
}
