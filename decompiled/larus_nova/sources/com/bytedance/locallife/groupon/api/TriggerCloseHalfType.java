package com.bytedance.locallife.groupon.api;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/groupon/api/TriggerCloseHalfType;", "", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "CLICK_CLOSE", "CLICK_MASK", "CLICK_FULL_CLOSE", "CLICK_BACK", "KEY_BACK", "OTHER_ANIM", "OTHER_NORMAL", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum TriggerCloseHalfType extends Enum<TriggerCloseHalfType> {
    public static final TriggerCloseHalfType CLICK_BACK = null;
    public static final TriggerCloseHalfType CLICK_CLOSE = null;
    public static final TriggerCloseHalfType CLICK_FULL_CLOSE = null;
    public static final TriggerCloseHalfType CLICK_MASK = null;
    public static final TriggerCloseHalfType KEY_BACK = null;
    public static final TriggerCloseHalfType OTHER_ANIM = null;
    public static final TriggerCloseHalfType OTHER_NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerCloseHalfType[] f258785a = null;
    private final String description;

    public static TriggerCloseHalfType valueOf(String r100) {
        return (TriggerCloseHalfType) a.a(TriggerCloseHalfType.class, r100);
    }

    public static TriggerCloseHalfType[] values() {
        return (TriggerCloseHalfType[]) f258785a.clone();
    }

    static {
        TriggerCloseHalfType r100 = new TriggerCloseHalfType("CLICK_CLOSE", 0, "close_btn");
        CLICK_CLOSE = r100;
        TriggerCloseHalfType r101 = new TriggerCloseHalfType("CLICK_MASK", 1, BuyNowCloseMethod.MASK);
        CLICK_MASK = r101;
        TriggerCloseHalfType r102 = new TriggerCloseHalfType("CLICK_FULL_CLOSE", 2, "full_close_btn");
        CLICK_FULL_CLOSE = r102;
        TriggerCloseHalfType r103 = new TriggerCloseHalfType("CLICK_BACK", 3, "back_float");
        CLICK_BACK = r103;
        TriggerCloseHalfType r104 = new TriggerCloseHalfType("KEY_BACK", 4, "default");
        KEY_BACK = r104;
        TriggerCloseHalfType r105 = new TriggerCloseHalfType("OTHER_ANIM", 5, "default");
        OTHER_ANIM = r105;
        TriggerCloseHalfType r110 = new TriggerCloseHalfType("OTHER_NORMAL", 6, "default");
        OTHER_NORMAL = r110;
        f258785a = new TriggerCloseHalfType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final String getDescription() {
        return this.description;
    }

    public TriggerCloseHalfType(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
