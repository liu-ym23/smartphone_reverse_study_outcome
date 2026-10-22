package com.bytedance.caijing.sdk.infra.base.api.container;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/SilentType;", "", "", "type", "I", "getType", "()I", "TYPE0", "TYPE1", "TYPE2", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum SilentType extends Enum<SilentType> {
    public static final SilentType TYPE0 = null;
    public static final SilentType TYPE1 = null;
    public static final SilentType TYPE2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SilentType[] f202210a = null;
    private final int type;

    public static SilentType valueOf(String r100) {
        return (SilentType) a.a(SilentType.class, r100);
    }

    public static SilentType[] values() {
        return (SilentType[]) f202210a.clone();
    }

    static {
        SilentType r100 = new SilentType("TYPE0", 0, 0);
        TYPE0 = r100;
        SilentType r101 = new SilentType("TYPE1", 1, 1);
        TYPE1 = r101;
        SilentType r102 = new SilentType("TYPE2", 2, 2);
        TYPE2 = r102;
        f202210a = new SilentType[]{r100, r101, r102};
    }

    public final int getType() {
        return this.type;
    }

    public SilentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
