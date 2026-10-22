package com.larus.livetutor.impl.rtc.interfaces;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/livetutor/impl/rtc/interfaces/RTCNetworkQuality;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "BAD", "FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RTCNetworkQuality extends Enum<RTCNetworkQuality> {
    public static final RTCNetworkQuality BAD = null;
    public static final RTCNetworkQuality FAIL = null;
    public static final RTCNetworkQuality NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RTCNetworkQuality[] f356388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f356389b = null;

    public static EnumEntries<RTCNetworkQuality> getEntries() {
        return f356389b;
    }

    static {
        RTCNetworkQuality r100 = new RTCNetworkQuality(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        RTCNetworkQuality r101 = new RTCNetworkQuality("BAD", 1);
        BAD = r101;
        RTCNetworkQuality r102 = new RTCNetworkQuality("FAIL", 2);
        FAIL = r102;
        RTCNetworkQuality[] r103 = {r100, r101, r102};
        f356388a = r103;
        f356389b = EnumEntriesKt.enumEntries(r103);
    }

    public static RTCNetworkQuality[] values() {
        return (RTCNetworkQuality[]) f356388a.clone();
    }

    public static RTCNetworkQuality valueOf(String r100) {
        return (RTCNetworkQuality) a.a(RTCNetworkQuality.class, r100);
    }

    public RTCNetworkQuality(String r100, int r101) {
        super(r100, r101);
    }
}
