package com.bytedance.live.bizlink.api.platform.rtc.rtcinfo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/live/bizlink/api/platform/rtc/rtcinfo/MultiLinkInfoType;", "", "", "value", "I", "getValue", "()I", "KTV_COMPONENT", "multi-biz-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkInfoType extends Enum<MultiLinkInfoType> {
    public static final MultiLinkInfoType KTV_COMPONENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkInfoType[] f254863a = null;
    private final int value;

    static {
        MultiLinkInfoType r100 = new MultiLinkInfoType();
        KTV_COMPONENT = r100;
        f254863a = new MultiLinkInfoType[]{r100};
    }

    public static MultiLinkInfoType valueOf(String r100) {
        return (MultiLinkInfoType) a.a(MultiLinkInfoType.class, r100);
    }

    public static MultiLinkInfoType[] values() {
        return (MultiLinkInfoType[]) f254863a.clone();
    }

    public MultiLinkInfoType() {
        super("KTV_COMPONENT", 0);
        this.value = 1;
    }

    public final int getValue() {
        return this.value;
    }
}
