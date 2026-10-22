package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import com.tencent.connect.common.Constants;
import de9.a1;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0087\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVLocalEventType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "unknown", "disconnectedRetringToast", "retrySuccessToast", "networkChange", "roomIdFetched", "networkQualityChange", "multiPathWork", "rtcLocalUserJoined", "rtcRemoteUserJoined", "selfScreenShareStart", "selfScreenShareEnd", "selfVideoCaptureStopped", "videoFirstFrameCaptured", "deviceError", "uplinkAudioVolume", "downlinkAudioVolume", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OMNIAVLocalEventType extends Enum<OMNIAVLocalEventType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OMNIAVLocalEventType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName(Constants.VIA_REPORT_TYPE_CHAT_AUDIO)
    public static final OMNIAVLocalEventType deviceError = null;

    @SerialName("1")
    public static final OMNIAVLocalEventType disconnectedRetringToast = null;

    @SerialName("42")
    public static final OMNIAVLocalEventType downlinkAudioVolume = null;

    @SerialName("6")
    public static final OMNIAVLocalEventType multiPathWork = null;

    @SerialName("3")
    public static final OMNIAVLocalEventType networkChange = null;

    @SerialName("5")
    public static final OMNIAVLocalEventType networkQualityChange = null;

    @SerialName("2")
    public static final OMNIAVLocalEventType retrySuccessToast = null;

    @SerialName("4")
    public static final OMNIAVLocalEventType roomIdFetched = null;

    @SerialName("7")
    public static final OMNIAVLocalEventType rtcLocalUserJoined = null;

    @SerialName("8")
    public static final OMNIAVLocalEventType rtcRemoteUserJoined = null;

    @SerialName("22")
    public static final OMNIAVLocalEventType selfScreenShareEnd = null;

    @SerialName("21")
    public static final OMNIAVLocalEventType selfScreenShareStart = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR)
    public static final OMNIAVLocalEventType selfVideoCaptureStopped = null;

    @SerialName("0")
    public static final OMNIAVLocalEventType unknown = null;

    @SerialName("41")
    public static final OMNIAVLocalEventType uplinkAudioVolume = null;

    @SerialName("24")
    public static final OMNIAVLocalEventType videoFirstFrameCaptured = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVLocalEventType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OMNIAVLocalEventType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OMNIAVLocalEventType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OMNIAVLocalEventType> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OMNIAVLocalEventType findByValue(int r100) {
            if (r100 == 41) goto L25;
            if (r100 == 42) goto L41;
            switch(r100) {
                case 0: goto L40;
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L37;
                case 4: goto L36;
                case 5: goto L35;
                case 6: goto L34;
                case 7: goto L33;
                case 8: goto L32;
                default: goto L7;
            };
        L7:
            switch(r100) {
                case 21: goto L31;
                case 22: goto L30;
                case 23: goto L29;
                case 24: goto L28;
                case 25: goto L27;
                default: goto L8;
            };
        L8:
            d1.f348206b.b("enum", "OMNIAVLocalEventType unknown value: " + r100);
            return OMNIAVLocalEventType.unknown;
        L27:
            return OMNIAVLocalEventType.deviceError;
        L28:
            return OMNIAVLocalEventType.videoFirstFrameCaptured;
        L29:
            return OMNIAVLocalEventType.selfVideoCaptureStopped;
        L30:
            return OMNIAVLocalEventType.selfScreenShareEnd;
        L31:
            return OMNIAVLocalEventType.selfScreenShareStart;
        L32:
            return OMNIAVLocalEventType.rtcRemoteUserJoined;
        L33:
            return OMNIAVLocalEventType.rtcLocalUserJoined;
        L34:
            return OMNIAVLocalEventType.multiPathWork;
        L35:
            return OMNIAVLocalEventType.networkQualityChange;
        L36:
            return OMNIAVLocalEventType.roomIdFetched;
        L37:
            return OMNIAVLocalEventType.networkChange;
        L38:
            return OMNIAVLocalEventType.retrySuccessToast;
        L39:
            return OMNIAVLocalEventType.disconnectedRetringToast;
        L40:
            return OMNIAVLocalEventType.unknown;
        L41:
            return OMNIAVLocalEventType.downlinkAudioVolume;
        L25:
            return OMNIAVLocalEventType.uplinkAudioVolume;
        }
    }

    private static final /* synthetic */ OMNIAVLocalEventType[] $values() {
        return new OMNIAVLocalEventType[]{unknown, disconnectedRetringToast, retrySuccessToast, networkChange, roomIdFetched, networkQualityChange, multiPathWork, rtcLocalUserJoined, rtcRemoteUserJoined, selfScreenShareStart, selfScreenShareEnd, selfVideoCaptureStopped, videoFirstFrameCaptured, deviceError, uplinkAudioVolume, downlinkAudioVolume};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OMNIAVLocalEventType findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OMNIAVLocalEventType> getEntries() {
        return $ENTRIES;
    }

    static {
        unknown = new OMNIAVLocalEventType("unknown", 0, 0);
        disconnectedRetringToast = new OMNIAVLocalEventType("disconnectedRetringToast", 1, 1);
        retrySuccessToast = new OMNIAVLocalEventType("retrySuccessToast", 2, 2);
        networkChange = new OMNIAVLocalEventType("networkChange", 3, 3);
        roomIdFetched = new OMNIAVLocalEventType("roomIdFetched", 4, 4);
        networkQualityChange = new OMNIAVLocalEventType("networkQualityChange", 5, 5);
        multiPathWork = new OMNIAVLocalEventType("multiPathWork", 6, 6);
        rtcLocalUserJoined = new OMNIAVLocalEventType("rtcLocalUserJoined", 7, 7);
        rtcRemoteUserJoined = new OMNIAVLocalEventType("rtcRemoteUserJoined", 8, 8);
        selfScreenShareStart = new OMNIAVLocalEventType("selfScreenShareStart", 9, 21);
        selfScreenShareEnd = new OMNIAVLocalEventType("selfScreenShareEnd", 10, 22);
        selfVideoCaptureStopped = new OMNIAVLocalEventType("selfVideoCaptureStopped", 11, 23);
        videoFirstFrameCaptured = new OMNIAVLocalEventType("videoFirstFrameCaptured", 12, 24);
        deviceError = new OMNIAVLocalEventType("deviceError", 13, 25);
        uplinkAudioVolume = new OMNIAVLocalEventType("uplinkAudioVolume", 14, 41);
        downlinkAudioVolume = new OMNIAVLocalEventType("downlinkAudioVolume", 15, 42);
        OMNIAVLocalEventType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new a1());
    }

    public static OMNIAVLocalEventType[] values() {
        return (OMNIAVLocalEventType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OMNIAVLocalEventType", values(), new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "21", "22", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "24", Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "41", "42"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OMNIAVLocalEventType valueOf(String r100) {
        return (OMNIAVLocalEventType) a.a(OMNIAVLocalEventType.class, r100);
    }

    private OMNIAVLocalEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
