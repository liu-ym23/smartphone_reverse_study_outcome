package com.bytedance.live.livelink.kmp.api.base.sei;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/sei/SeiDataType;", "", "SEI_TYPE_NORMAL", "SEI_TYPE_CHORUS", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeiDataType extends Enum<SeiDataType> {
    public static final SeiDataType SEI_TYPE_CHORUS = null;
    public static final SeiDataType SEI_TYPE_NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SeiDataType[] f255225a = null;

    static {
        SeiDataType r100 = new SeiDataType("SEI_TYPE_NORMAL", 0);
        SEI_TYPE_NORMAL = r100;
        SeiDataType r101 = new SeiDataType("SEI_TYPE_CHORUS", 1);
        SEI_TYPE_CHORUS = r101;
        f255225a = new SeiDataType[]{r100, r101};
    }

    public static SeiDataType valueOf(String r100) {
        return (SeiDataType) a.a(SeiDataType.class, r100);
    }

    public static SeiDataType[] values() {
        return (SeiDataType[]) f255225a.clone();
    }

    public SeiDataType(String r100, int r101) {
        super(r100, r101);
    }
}
