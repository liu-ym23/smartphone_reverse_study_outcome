package com.bytedance.bdp.appbase.service.protocol.media.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/bdp/appbase/service/protocol/media/entity/BDPAudioFocusRequest$Result", "", "Lcom/bytedance/bdp/appbase/service/protocol/media/entity/BDPAudioFocusRequest$Result;", "FOCUS_REQUEST_FAILED", "FOCUS_REQUEST_GRANTED", "FOCUS_REQUEST_DELAYED", "bdp-appbase-ext_release"}, k = 1, mv = {1, 4, 0})
public final enum BDPAudioFocusRequest$Result extends Enum<BDPAudioFocusRequest$Result> {
    public static final BDPAudioFocusRequest$Result FOCUS_REQUEST_DELAYED = null;
    public static final BDPAudioFocusRequest$Result FOCUS_REQUEST_FAILED = null;
    public static final BDPAudioFocusRequest$Result FOCUS_REQUEST_GRANTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BDPAudioFocusRequest$Result[] f200968a = null;

    static {
        BDPAudioFocusRequest$Result r100 = new BDPAudioFocusRequest$Result("FOCUS_REQUEST_FAILED", 0);
        FOCUS_REQUEST_FAILED = r100;
        BDPAudioFocusRequest$Result r101 = new BDPAudioFocusRequest$Result("FOCUS_REQUEST_GRANTED", 1);
        FOCUS_REQUEST_GRANTED = r101;
        BDPAudioFocusRequest$Result r102 = new BDPAudioFocusRequest$Result("FOCUS_REQUEST_DELAYED", 2);
        FOCUS_REQUEST_DELAYED = r102;
        f200968a = new BDPAudioFocusRequest$Result[]{r100, r101, r102};
    }

    public static BDPAudioFocusRequest$Result valueOf(String r100) {
        return (BDPAudioFocusRequest$Result) a.a(BDPAudioFocusRequest$Result.class, r100);
    }

    public static BDPAudioFocusRequest$Result[] values() {
        return (BDPAudioFocusRequest$Result[]) f200968a.clone();
    }

    public BDPAudioFocusRequest$Result(String r100, int r101) {
        super(r100, r101);
    }
}
