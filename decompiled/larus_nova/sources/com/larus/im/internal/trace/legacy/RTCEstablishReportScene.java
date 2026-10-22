package com.larus.im.internal.trace.legacy;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/trace/legacy/RTCEstablishReportScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", EffectConstants.NORMAL, "TIMEOUT", "USER_LEAVE", "BOT_LEAVE", "DESTROY", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RTCEstablishReportScene extends Enum<RTCEstablishReportScene> {
    public static final RTCEstablishReportScene BOT_LEAVE = null;
    public static final RTCEstablishReportScene DESTROY = null;
    public static final RTCEstablishReportScene NORMAL = null;
    public static final RTCEstablishReportScene TIMEOUT = null;
    public static final RTCEstablishReportScene USER_LEAVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RTCEstablishReportScene[] f350141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350142b = null;
    private final String scene;

    public static EnumEntries<RTCEstablishReportScene> getEntries() {
        return f350142b;
    }

    static {
        RTCEstablishReportScene r100 = new RTCEstablishReportScene(EffectConstants.NORMAL, 0, "normal");
        NORMAL = r100;
        RTCEstablishReportScene r101 = new RTCEstablishReportScene("TIMEOUT", 1, "timeout");
        TIMEOUT = r101;
        RTCEstablishReportScene r102 = new RTCEstablishReportScene("USER_LEAVE", 2, "user_leave");
        USER_LEAVE = r102;
        RTCEstablishReportScene r103 = new RTCEstablishReportScene("BOT_LEAVE", 3, "bot_leave");
        BOT_LEAVE = r103;
        RTCEstablishReportScene r104 = new RTCEstablishReportScene("DESTROY", 4, MapMonitorConst.EVENT_DESTROY);
        DESTROY = r104;
        RTCEstablishReportScene[] r105 = {r100, r101, r102, r103, r104};
        f350141a = r105;
        f350142b = EnumEntriesKt.enumEntries(r105);
    }

    public static RTCEstablishReportScene[] values() {
        return (RTCEstablishReportScene[]) f350141a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static RTCEstablishReportScene valueOf(String r100) {
        return (RTCEstablishReportScene) a.a(RTCEstablishReportScene.class, r100);
    }

    public RTCEstablishReportScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
