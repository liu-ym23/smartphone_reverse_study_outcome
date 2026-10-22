package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/TASMVerifyType;", "", "", "type", "I", "getType", "()I", "SIGN", "URL", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum TASMVerifyType extends Enum<TASMVerifyType> {
    public static final TASMVerifyType SIGN = null;
    public static final TASMVerifyType URL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TASMVerifyType[] f269831a = null;
    private final int type;

    public static TASMVerifyType valueOf(String r100) {
        return (TASMVerifyType) a.a(TASMVerifyType.class, r100);
    }

    public static TASMVerifyType[] values() {
        return (TASMVerifyType[]) f269831a.clone();
    }

    static {
        TASMVerifyType r100 = new TASMVerifyType("SIGN", 0, 978000000);
        SIGN = r100;
        TASMVerifyType r101 = new TASMVerifyType("URL", 1, 347294400);
        URL = r101;
        f269831a = new TASMVerifyType[]{r100, r101};
    }

    public final int getType() {
        return this.type;
    }

    public TASMVerifyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
