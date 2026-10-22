package com.ss.android.lark.audit.utils;

import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum Trigger extends Enum<Trigger> {
    public static final Trigger BACK_TO_FRONT = null;
    public static final Trigger NETWORK = null;
    public static final Trigger NO_RESPONSE = null;
    public static final Trigger OTHER = null;
    public static final Trigger PUSH = null;
    public static final Trigger RETRY = null;
    public static final Trigger TIMER = null;
    public static final Trigger UID_CHANGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Trigger[] f409550a = null;
    public String type;

    static {
        Trigger r100 = new Trigger("NETWORK", 0, "network");
        NETWORK = r100;
        Trigger r101 = new Trigger("TIMER", 1, UploadTypeInf.TIMER);
        TIMER = r101;
        Trigger r102 = new Trigger(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 2, "push");
        PUSH = r102;
        Trigger r103 = new Trigger("NO_RESPONSE", 3, "noResponse");
        NO_RESPONSE = r103;
        Trigger r104 = new Trigger("RETRY", 4, EventConstant.Value.RETRY);
        RETRY = r104;
        Trigger r105 = new Trigger("BACK_TO_FRONT", 5, "backToFront");
        BACK_TO_FRONT = r105;
        Trigger r110 = new Trigger("UID_CHANGE", 6, "uidChange");
        UID_CHANGE = r110;
        Trigger r111 = new Trigger(FlowDoraWifiScene.OTHER, 7, "other");
        OTHER = r111;
        f409550a = new Trigger[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static Trigger[] values() {
        return (Trigger[]) f409550a.clone();
    }

    public static Trigger valueOf(String r100) {
        return (Trigger) a.a(Trigger.class, r100);
    }

    public Trigger(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
