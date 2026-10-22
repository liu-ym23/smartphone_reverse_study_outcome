package com.bytedance.android.shopping.commentv3.action.handler.tracker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/action/handler/tracker/CommentBtmId;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "SKU_PANEL", "SKU_PANEL_RESET", "SKU_PANEL_CONFIRM", "SKU_PANEL_CLOSE", "FLOAT_TO_TOP", "FLOAT_MULTI_SWITCH", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentBtmId extends Enum<CommentBtmId> {
    public static final CommentBtmId FLOAT_MULTI_SWITCH = null;
    public static final CommentBtmId FLOAT_TO_TOP = null;
    public static final CommentBtmId SKU_PANEL = null;
    public static final CommentBtmId SKU_PANEL_CLOSE = null;
    public static final CommentBtmId SKU_PANEL_CONFIRM = null;
    public static final CommentBtmId SKU_PANEL_RESET = null;
    public static final /* synthetic */ CommentBtmId[] a = null;
    private final String id;

    static {
        CommentBtmId r1 = new CommentBtmId("SKU_PANEL", 0, "c67220.d0");
        SKU_PANEL = r1;
        CommentBtmId r2 = new CommentBtmId("SKU_PANEL_RESET", 1, "c67220.d95115");
        SKU_PANEL_RESET = r2;
        CommentBtmId r3 = new CommentBtmId("SKU_PANEL_CONFIRM", 2, "c67220.d10589");
        SKU_PANEL_CONFIRM = r3;
        CommentBtmId r4 = new CommentBtmId("SKU_PANEL_CLOSE", 3, "c67220.d88817");
        SKU_PANEL_CLOSE = r4;
        CommentBtmId r5 = new CommentBtmId("FLOAT_TO_TOP", 4, "c49811.d0");
        FLOAT_TO_TOP = r5;
        CommentBtmId r6 = new CommentBtmId("FLOAT_MULTI_SWITCH", 5, "c20822.d0");
        FLOAT_MULTI_SWITCH = r6;
        a = new CommentBtmId[]{r1, r2, r3, r4, r5, r6};
    }

    public static CommentBtmId valueOf(String r1) {
        return (CommentBtmId) a.a(CommentBtmId.class, r1);
    }

    public static CommentBtmId[] values() {
        return (CommentBtmId[]) a.clone();
    }

    public final String getId() {
        return this.id;
    }

    public CommentBtmId(String r1, int r2, String r3) {
        super(r1, r2);
        this.id = r3;
    }
}
