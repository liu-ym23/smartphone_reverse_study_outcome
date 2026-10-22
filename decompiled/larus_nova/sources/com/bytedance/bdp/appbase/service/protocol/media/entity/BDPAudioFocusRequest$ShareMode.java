package com.bytedance.bdp.appbase.service.protocol.media.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/bdp/appbase/service/protocol/media/entity/BDPAudioFocusRequest$ShareMode", "", "Lcom/bytedance/bdp/appbase/service/protocol/media/entity/BDPAudioFocusRequest$ShareMode;", "SHARE", "SELF_ONLY", "bdp-appbase-ext_release"}, k = 1, mv = {1, 4, 0})
public final enum BDPAudioFocusRequest$ShareMode extends Enum<BDPAudioFocusRequest$ShareMode> {
    public static final BDPAudioFocusRequest$ShareMode SELF_ONLY = null;
    public static final BDPAudioFocusRequest$ShareMode SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BDPAudioFocusRequest$ShareMode[] f200969a = null;

    static {
        BDPAudioFocusRequest$ShareMode r100 = new BDPAudioFocusRequest$ShareMode("SHARE", 0);
        SHARE = r100;
        BDPAudioFocusRequest$ShareMode r101 = new BDPAudioFocusRequest$ShareMode("SELF_ONLY", 1);
        SELF_ONLY = r101;
        f200969a = new BDPAudioFocusRequest$ShareMode[]{r100, r101};
    }

    public static BDPAudioFocusRequest$ShareMode valueOf(String r100) {
        return (BDPAudioFocusRequest$ShareMode) a.a(BDPAudioFocusRequest$ShareMode.class, r100);
    }

    public static BDPAudioFocusRequest$ShareMode[] values() {
        return (BDPAudioFocusRequest$ShareMode[]) f200969a.clone();
    }

    public BDPAudioFocusRequest$ShareMode(String r100, int r101) {
        super(r100, r101);
    }
}
