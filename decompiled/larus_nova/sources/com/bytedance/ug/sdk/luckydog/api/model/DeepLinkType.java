package com.bytedance.ug.sdk.luckydog.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/model/DeepLinkType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "TYPE_RECEIVE", "TYPE_HANDLE", "TYPE_FORBIDDEN", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum DeepLinkType extends Enum<DeepLinkType> {
    public static final DeepLinkType TYPE_FORBIDDEN = null;
    public static final DeepLinkType TYPE_HANDLE = null;
    public static final DeepLinkType TYPE_RECEIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeepLinkType[] f271589a = null;
    private final String value;

    static {
        DeepLinkType r100 = new DeepLinkType("TYPE_RECEIVE", 0, "receive");
        TYPE_RECEIVE = r100;
        DeepLinkType r101 = new DeepLinkType("TYPE_HANDLE", 1, "handle");
        TYPE_HANDLE = r101;
        DeepLinkType r102 = new DeepLinkType("TYPE_FORBIDDEN", 2, "forbidden");
        TYPE_FORBIDDEN = r102;
        f271589a = new DeepLinkType[]{r100, r101, r102};
    }

    public static DeepLinkType valueOf(String r100) {
        return (DeepLinkType) a.a(DeepLinkType.class, r100);
    }

    public static DeepLinkType[] values() {
        return (DeepLinkType[]) f271589a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public DeepLinkType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
