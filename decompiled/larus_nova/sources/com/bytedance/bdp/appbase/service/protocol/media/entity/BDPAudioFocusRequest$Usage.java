package com.bytedance.bdp.appbase.service.protocol.media.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/bdp/appbase/service/protocol/media/entity/BDPAudioFocusRequest$Usage", "", "Lcom/bytedance/bdp/appbase/service/protocol/media/entity/BDPAudioFocusRequest$Usage;", "USAGE_MEDIA", "USAGE_ALARM", "bdp-appbase-ext_release"}, k = 1, mv = {1, 4, 0})
public final enum BDPAudioFocusRequest$Usage extends Enum<BDPAudioFocusRequest$Usage> {
    public static final BDPAudioFocusRequest$Usage USAGE_ALARM = null;
    public static final BDPAudioFocusRequest$Usage USAGE_MEDIA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BDPAudioFocusRequest$Usage[] f200970a = null;

    static {
        BDPAudioFocusRequest$Usage r100 = new BDPAudioFocusRequest$Usage("USAGE_MEDIA", 0);
        USAGE_MEDIA = r100;
        BDPAudioFocusRequest$Usage r101 = new BDPAudioFocusRequest$Usage("USAGE_ALARM", 1);
        USAGE_ALARM = r101;
        f200970a = new BDPAudioFocusRequest$Usage[]{r100, r101};
    }

    public static BDPAudioFocusRequest$Usage valueOf(String r100) {
        return (BDPAudioFocusRequest$Usage) a.a(BDPAudioFocusRequest$Usage.class, r100);
    }

    public static BDPAudioFocusRequest$Usage[] values() {
        return (BDPAudioFocusRequest$Usage[]) f200970a.clone();
    }

    public BDPAudioFocusRequest$Usage(String r100, int r101) {
        super(r100, r101);
    }
}
