package com.bytedance.flow_audio.api.business.asr.session;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/flow_audio/api/business/asr/session/FlowAsrCancelReason;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "NEW_SESSION", "SOURCE_ERROR", "RELEASE", HTTP.SERVER, "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAsrCancelReason extends Enum<FlowAsrCancelReason> {
    public static final FlowAsrCancelReason NEW_SESSION = null;
    public static final FlowAsrCancelReason RELEASE = null;
    public static final FlowAsrCancelReason SERVER = null;
    public static final FlowAsrCancelReason SOURCE_ERROR = null;
    public static final FlowAsrCancelReason UNKNOWN = null;
    public static final FlowAsrCancelReason USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAsrCancelReason[] f243677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243678b = null;

    public static EnumEntries<FlowAsrCancelReason> getEntries() {
        return f243678b;
    }

    static {
        FlowAsrCancelReason r100 = new FlowAsrCancelReason("UNKNOWN", 0);
        UNKNOWN = r100;
        FlowAsrCancelReason r101 = new FlowAsrCancelReason(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1);
        USER = r101;
        FlowAsrCancelReason r102 = new FlowAsrCancelReason("NEW_SESSION", 2);
        NEW_SESSION = r102;
        FlowAsrCancelReason r103 = new FlowAsrCancelReason("SOURCE_ERROR", 3);
        SOURCE_ERROR = r103;
        FlowAsrCancelReason r104 = new FlowAsrCancelReason("RELEASE", 4);
        RELEASE = r104;
        FlowAsrCancelReason r105 = new FlowAsrCancelReason(HTTP.SERVER, 5);
        SERVER = r105;
        FlowAsrCancelReason[] r110 = {r100, r101, r102, r103, r104, r105};
        f243677a = r110;
        f243678b = EnumEntriesKt.enumEntries(r110);
    }

    public static FlowAsrCancelReason[] values() {
        return (FlowAsrCancelReason[]) f243677a.clone();
    }

    public static FlowAsrCancelReason valueOf(String r100) {
        return (FlowAsrCancelReason) a.a(FlowAsrCancelReason.class, r100);
    }

    public FlowAsrCancelReason(String r100, int r101) {
        super(r100, r101);
    }
}
