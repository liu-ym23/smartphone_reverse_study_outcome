package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/AIIMSchemaScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "AI_IM", "PRODUCT_DETAIL", "ORDER_PAGE", "SKU", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AIIMSchemaScene extends Enum<AIIMSchemaScene> {
    public static final AIIMSchemaScene AI_IM = null;
    public static final a Companion = null;
    public static final AIIMSchemaScene ORDER_PAGE = null;
    public static final AIIMSchemaScene PRODUCT_DETAIL = null;
    public static final AIIMSchemaScene SKU = null;
    public static final /* synthetic */ AIIMSchemaScene[] a = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    static {
        AIIMSchemaScene r1 = new AIIMSchemaScene("AI_IM", 0, "ai_im");
        AI_IM = r1;
        AIIMSchemaScene r2 = new AIIMSchemaScene("PRODUCT_DETAIL", 1, "product_detail");
        PRODUCT_DETAIL = r2;
        AIIMSchemaScene r3 = new AIIMSchemaScene("ORDER_PAGE", 2, "order_page");
        ORDER_PAGE = r3;
        AIIMSchemaScene r4 = new AIIMSchemaScene("SKU", 3, "sku");
        SKU = r4;
        a = new AIIMSchemaScene[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static AIIMSchemaScene valueOf(String r1) {
        return (AIIMSchemaScene) r27.a.a(AIIMSchemaScene.class, r1);
    }

    public static AIIMSchemaScene[] values() {
        return (AIIMSchemaScene[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public AIIMSchemaScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
