package com.bytedance.ies.bullet.service.receiver.headset;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/receiver/headset/HeadSetType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "BLUETOOTH", "WIRED", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum HeadSetType extends Enum<HeadSetType> {
    public static final HeadSetType BLUETOOTH = null;
    public static final HeadSetType UNKNOWN = null;
    public static final HeadSetType WIRED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HeadSetType[] f248111a = null;
    private final String value;

    public static HeadSetType valueOf(String r100) {
        return (HeadSetType) a.a(HeadSetType.class, r100);
    }

    public static HeadSetType[] values() {
        return (HeadSetType[]) f248111a.clone();
    }

    static {
        HeadSetType r100 = new HeadSetType("BLUETOOTH", 0, "bluetooth");
        BLUETOOTH = r100;
        HeadSetType r101 = new HeadSetType("WIRED", 1, "wired");
        WIRED = r101;
        HeadSetType r102 = new HeadSetType("UNKNOWN", 2, "unknown");
        UNKNOWN = r102;
        f248111a = new HeadSetType[]{r100, r101, r102};
    }

    public final String getValue() {
        return this.value;
    }

    public HeadSetType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
