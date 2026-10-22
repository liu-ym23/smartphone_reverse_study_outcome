package com.bytedance.android.shopping.store.aggregate;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/AggregatePageTypes;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "FULL_DISCOUNT", "CLASSIFICATION", "FOLLOW_COUPON", "LIVE_STORE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AggregatePageTypes extends Enum<AggregatePageTypes> {
    public static final AggregatePageTypes CLASSIFICATION = null;
    public static final AggregatePageTypes FOLLOW_COUPON = null;
    public static final AggregatePageTypes FULL_DISCOUNT = null;
    public static final AggregatePageTypes LIVE_STORE = null;
    public static final /* synthetic */ AggregatePageTypes[] a = null;
    private final String type;

    static {
        AggregatePageTypes r1 = new AggregatePageTypes("FULL_DISCOUNT", 0, CommentScene.COMMENTSCENE_NO_AWEME);
        FULL_DISCOUNT = r1;
        AggregatePageTypes r2 = new AggregatePageTypes("CLASSIFICATION", 1, "2");
        CLASSIFICATION = r2;
        AggregatePageTypes r3 = new AggregatePageTypes("FOLLOW_COUPON", 2, "3");
        FOLLOW_COUPON = r3;
        AggregatePageTypes r4 = new AggregatePageTypes("LIVE_STORE", 3, "4");
        LIVE_STORE = r4;
        a = new AggregatePageTypes[]{r1, r2, r3, r4};
    }

    public static AggregatePageTypes valueOf(String r1) {
        return (AggregatePageTypes) r27.a.a(AggregatePageTypes.class, r1);
    }

    public static AggregatePageTypes[] values() {
        return (AggregatePageTypes[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public AggregatePageTypes(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
