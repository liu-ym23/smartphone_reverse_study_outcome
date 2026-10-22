package com.bytedance.android.livesdk.livecommerce.room.controller.related;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"com/bytedance/android/livesdk/livecommerce/room/controller/related/IRelatedInfoManager$FromSource", "", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/related/IRelatedInfoManager$FromSource;", "", "priority", "I", "getPriority", "()I", "CLIENT_AI_PRODUCT_INFO", "ENTER_ECOM_LIVE_PARAMS", "ECOM_LIVE_PARAMS", "ENTER_ROOM_API", "RELATED_CARD", "JUMP_SCHEMA", "LIVE_LIST_TAB_RESORT_ABILITY", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IRelatedInfoManager$FromSource extends Enum<IRelatedInfoManager$FromSource> {
    public static final IRelatedInfoManager$FromSource CLIENT_AI_PRODUCT_INFO = null;
    public static final IRelatedInfoManager$FromSource ECOM_LIVE_PARAMS = null;
    public static final IRelatedInfoManager$FromSource ENTER_ECOM_LIVE_PARAMS = null;
    public static final IRelatedInfoManager$FromSource ENTER_ROOM_API = null;
    public static final IRelatedInfoManager$FromSource JUMP_SCHEMA = null;
    public static final IRelatedInfoManager$FromSource LIVE_LIST_TAB_RESORT_ABILITY = null;
    public static final IRelatedInfoManager$FromSource RELATED_CARD = null;
    public static final /* synthetic */ IRelatedInfoManager$FromSource[] a = null;
    private final int priority;

    static {
        IRelatedInfoManager$FromSource r1 = new IRelatedInfoManager$FromSource("CLIENT_AI_PRODUCT_INFO", 0, 0);
        CLIENT_AI_PRODUCT_INFO = r1;
        IRelatedInfoManager$FromSource r2 = new IRelatedInfoManager$FromSource("ENTER_ECOM_LIVE_PARAMS", 1, 1);
        ENTER_ECOM_LIVE_PARAMS = r2;
        IRelatedInfoManager$FromSource r3 = new IRelatedInfoManager$FromSource("ECOM_LIVE_PARAMS", 2, 2);
        ECOM_LIVE_PARAMS = r3;
        IRelatedInfoManager$FromSource r4 = new IRelatedInfoManager$FromSource("ENTER_ROOM_API", 3, 3);
        ENTER_ROOM_API = r4;
        IRelatedInfoManager$FromSource r5 = new IRelatedInfoManager$FromSource("RELATED_CARD", 4, 4);
        RELATED_CARD = r5;
        IRelatedInfoManager$FromSource r6 = new IRelatedInfoManager$FromSource("JUMP_SCHEMA", 5, 100);
        JUMP_SCHEMA = r6;
        IRelatedInfoManager$FromSource r7 = new IRelatedInfoManager$FromSource("LIVE_LIST_TAB_RESORT_ABILITY", 6, 200);
        LIVE_LIST_TAB_RESORT_ABILITY = r7;
        a = new IRelatedInfoManager$FromSource[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static IRelatedInfoManager$FromSource valueOf(String r1) {
        return (IRelatedInfoManager$FromSource) r27.a.a(IRelatedInfoManager$FromSource.class, r1);
    }

    public static IRelatedInfoManager$FromSource[] values() {
        return (IRelatedInfoManager$FromSource[]) a.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public IRelatedInfoManager$FromSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.priority = r3;
    }
}
