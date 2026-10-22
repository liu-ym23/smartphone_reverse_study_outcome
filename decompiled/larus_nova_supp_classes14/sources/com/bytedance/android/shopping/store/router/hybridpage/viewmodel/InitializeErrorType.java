package com.bytedance.android.shopping.store.router.hybridpage.viewmodel;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/InitializeErrorType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "CONFIG_JSON_ERROR", "PAGE_CARD_ERROR", "SLICED_ERROR", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InitializeErrorType extends Enum<InitializeErrorType> {
    public static final InitializeErrorType CONFIG_JSON_ERROR = null;
    public static final InitializeErrorType PAGE_CARD_ERROR = null;
    public static final InitializeErrorType SLICED_ERROR = null;
    public static final /* synthetic */ InitializeErrorType[] a = null;
    private final String type;

    static {
        InitializeErrorType r1 = new InitializeErrorType("CONFIG_JSON_ERROR", 0, "config_json_error");
        CONFIG_JSON_ERROR = r1;
        InitializeErrorType r2 = new InitializeErrorType("PAGE_CARD_ERROR", 1, "page_card_error");
        PAGE_CARD_ERROR = r2;
        InitializeErrorType r3 = new InitializeErrorType("SLICED_ERROR", 2, "slice_page_error");
        SLICED_ERROR = r3;
        a = new InitializeErrorType[]{r1, r2, r3};
    }

    public static InitializeErrorType valueOf(String r1) {
        return (InitializeErrorType) a.a(InitializeErrorType.class, r1);
    }

    public static InitializeErrorType[] values() {
        return (InitializeErrorType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public InitializeErrorType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
