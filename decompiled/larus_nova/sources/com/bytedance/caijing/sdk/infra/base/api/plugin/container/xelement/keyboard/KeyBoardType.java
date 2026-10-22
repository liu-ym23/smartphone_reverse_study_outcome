package com.bytedance.caijing.sdk.infra.base.api.plugin.container.xelement.keyboard;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/xelement/keyboard/KeyBoardType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "NUM", "AMOUNT", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum KeyBoardType extends Enum<KeyBoardType> {
    public static final KeyBoardType AMOUNT = null;
    public static final KeyBoardType NUM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyBoardType[] f202239a = null;
    private final String type;

    public static KeyBoardType valueOf(String r100) {
        return (KeyBoardType) a.a(KeyBoardType.class, r100);
    }

    public static KeyBoardType[] values() {
        return (KeyBoardType[]) f202239a.clone();
    }

    static {
        KeyBoardType r100 = new KeyBoardType("NUM", 0, "number");
        NUM = r100;
        KeyBoardType r101 = new KeyBoardType("AMOUNT", 1, "amount");
        AMOUNT = r101;
        f202239a = new KeyBoardType[]{r100, r101};
    }

    public final String getType() {
        return this.type;
    }

    public KeyBoardType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
