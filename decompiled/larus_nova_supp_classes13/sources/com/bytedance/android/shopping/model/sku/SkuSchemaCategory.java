package com.bytedance.android.shopping.model.sku;

import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/model/sku/SkuSchemaCategory;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "KEY_PRODUCT_INFO", "KEY_BIZ_CONTEXT", "KEY_CHAIN_INFO", "KEY_USER_INFO", "KEY_CUSTOM_PARAMS", "KEY_CLIENT_PARAMS", "KEY_PLATFORM_PARAMS", "KEY_PASS_THROUGH", "KEY_EXTRA_PARAMS", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum SkuSchemaCategory extends Enum<SkuSchemaCategory> {
    public static final a Companion = null;
    public static final SkuSchemaCategory KEY_BIZ_CONTEXT = null;
    public static final SkuSchemaCategory KEY_CHAIN_INFO = null;
    public static final SkuSchemaCategory KEY_CLIENT_PARAMS = null;
    public static final SkuSchemaCategory KEY_CUSTOM_PARAMS = null;
    public static final SkuSchemaCategory KEY_EXTRA_PARAMS = null;
    public static final SkuSchemaCategory KEY_PASS_THROUGH = null;
    public static final SkuSchemaCategory KEY_PLATFORM_PARAMS = null;
    public static final SkuSchemaCategory KEY_PRODUCT_INFO = null;
    public static final SkuSchemaCategory KEY_USER_INFO = null;
    public static final /* synthetic */ SkuSchemaCategory[] a = null;
    public static final HashSet<String> b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static SkuSchemaCategory valueOf(String r1) {
        return (SkuSchemaCategory) r27.a.a(SkuSchemaCategory.class, r1);
    }

    public static SkuSchemaCategory[] values() {
        return (SkuSchemaCategory[]) a.clone();
    }

    static {
        int r3 = 0;
        SkuSchemaCategory r1 = new SkuSchemaCategory("KEY_PRODUCT_INFO", 0, "product_info");
        KEY_PRODUCT_INFO = r1;
        SkuSchemaCategory r2 = new SkuSchemaCategory("KEY_BIZ_CONTEXT", 1, "biz_context");
        KEY_BIZ_CONTEXT = r2;
        SkuSchemaCategory r4 = new SkuSchemaCategory("KEY_CHAIN_INFO", 2, "chain_info");
        KEY_CHAIN_INFO = r4;
        SkuSchemaCategory r5 = new SkuSchemaCategory("KEY_USER_INFO", 3, "user_info");
        KEY_USER_INFO = r5;
        SkuSchemaCategory r6 = new SkuSchemaCategory("KEY_CUSTOM_PARAMS", 4, "custom_params");
        KEY_CUSTOM_PARAMS = r6;
        SkuSchemaCategory r7 = new SkuSchemaCategory("KEY_CLIENT_PARAMS", 5, "client_params");
        KEY_CLIENT_PARAMS = r7;
        SkuSchemaCategory r8 = new SkuSchemaCategory("KEY_PLATFORM_PARAMS", 6, "platform_params");
        KEY_PLATFORM_PARAMS = r8;
        SkuSchemaCategory r9 = new SkuSchemaCategory("KEY_PASS_THROUGH", 7, "pass_through");
        KEY_PASS_THROUGH = r9;
        SkuSchemaCategory r10 = new SkuSchemaCategory("KEY_EXTRA_PARAMS", 8, "extra_params");
        KEY_EXTRA_PARAMS = r10;
        a = new SkuSchemaCategory[]{r1, r2, r4, r5, r6, r7, r8, r9, r10};
        Companion = new a();
        SkuSchemaCategory[] r0 = values();
        ArrayList r11 = new ArrayList(r0.length);
        int r12 = r0.length;
    L3:
        if (r3 >= r12) goto L5;
        r11.add(r0[r3].value);
        r3 = r3 + 1;
        goto L3
    L5:
        b = CollectionsKt.toHashSet(r11);
    }

    public static final /* synthetic */ HashSet access$getKeysSet$cp() {
        return b;
    }

    public final String getValue() {
        return this.value;
    }

    public SkuSchemaCategory(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
