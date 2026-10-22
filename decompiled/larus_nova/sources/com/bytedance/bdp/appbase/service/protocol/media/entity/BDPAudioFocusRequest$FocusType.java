package com.bytedance.bdp.appbase.service.protocol.media.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/bdp/appbase/service/protocol/media/entity/BDPAudioFocusRequest$FocusType", "", "Lcom/bytedance/bdp/appbase/service/protocol/media/entity/BDPAudioFocusRequest$FocusType;", "GAIN", "GAIN_TRANSIENT", "GAIN_TRANSIENT_MAY_DUCK", "GAIN_TRANSIENT_EXCLUSIVE", "LOSS", "LOSS_TRANSIENT", "FOCUS_LOSS_TRANSIENT_CAN_DUCK", "FOCUS_NONE", "bdp-appbase-ext_release"}, k = 1, mv = {1, 4, 0})
public final enum BDPAudioFocusRequest$FocusType extends Enum<BDPAudioFocusRequest$FocusType> {
    public static final BDPAudioFocusRequest$FocusType FOCUS_LOSS_TRANSIENT_CAN_DUCK = null;
    public static final BDPAudioFocusRequest$FocusType FOCUS_NONE = null;
    public static final BDPAudioFocusRequest$FocusType GAIN = null;
    public static final BDPAudioFocusRequest$FocusType GAIN_TRANSIENT = null;
    public static final BDPAudioFocusRequest$FocusType GAIN_TRANSIENT_EXCLUSIVE = null;
    public static final BDPAudioFocusRequest$FocusType GAIN_TRANSIENT_MAY_DUCK = null;
    public static final BDPAudioFocusRequest$FocusType LOSS = null;
    public static final BDPAudioFocusRequest$FocusType LOSS_TRANSIENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BDPAudioFocusRequest$FocusType[] f200967a = null;

    static {
        BDPAudioFocusRequest$FocusType r100 = new BDPAudioFocusRequest$FocusType("GAIN", 0);
        GAIN = r100;
        BDPAudioFocusRequest$FocusType r101 = new BDPAudioFocusRequest$FocusType("GAIN_TRANSIENT", 1);
        GAIN_TRANSIENT = r101;
        BDPAudioFocusRequest$FocusType r102 = new BDPAudioFocusRequest$FocusType("GAIN_TRANSIENT_MAY_DUCK", 2);
        GAIN_TRANSIENT_MAY_DUCK = r102;
        BDPAudioFocusRequest$FocusType r103 = new BDPAudioFocusRequest$FocusType("GAIN_TRANSIENT_EXCLUSIVE", 3);
        GAIN_TRANSIENT_EXCLUSIVE = r103;
        BDPAudioFocusRequest$FocusType r104 = new BDPAudioFocusRequest$FocusType("LOSS", 4);
        LOSS = r104;
        BDPAudioFocusRequest$FocusType r105 = new BDPAudioFocusRequest$FocusType("LOSS_TRANSIENT", 5);
        LOSS_TRANSIENT = r105;
        BDPAudioFocusRequest$FocusType r106 = new BDPAudioFocusRequest$FocusType("FOCUS_LOSS_TRANSIENT_CAN_DUCK", 6);
        FOCUS_LOSS_TRANSIENT_CAN_DUCK = r106;
        BDPAudioFocusRequest$FocusType r107 = new BDPAudioFocusRequest$FocusType("FOCUS_NONE", 7);
        FOCUS_NONE = r107;
        f200967a = new BDPAudioFocusRequest$FocusType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static BDPAudioFocusRequest$FocusType valueOf(String r100) {
        return (BDPAudioFocusRequest$FocusType) a.a(BDPAudioFocusRequest$FocusType.class, r100);
    }

    public static BDPAudioFocusRequest$FocusType[] values() {
        return (BDPAudioFocusRequest$FocusType[]) f200967a.clone();
    }

    public BDPAudioFocusRequest$FocusType(String r100, int r101) {
        super(r100, r101);
    }
}
