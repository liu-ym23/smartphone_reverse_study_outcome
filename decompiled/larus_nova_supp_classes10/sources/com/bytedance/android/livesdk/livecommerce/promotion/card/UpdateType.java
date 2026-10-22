package com.bytedance.android.livesdk.livecommerce.promotion.card;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/UpdateType;", "", "UPDATE_ALL", "VIEW_RECYCLED", "HOT_ATMOSPHERE", "UPDATE_EXPOSE", "UPDATE_BUTTON_INFO", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum UpdateType extends Enum<UpdateType> {
    public static final UpdateType HOT_ATMOSPHERE = null;
    public static final UpdateType UPDATE_ALL = null;
    public static final UpdateType UPDATE_BUTTON_INFO = null;
    public static final UpdateType UPDATE_EXPOSE = null;
    public static final UpdateType VIEW_RECYCLED = null;
    public static final /* synthetic */ UpdateType[] a = null;

    static {
        UpdateType r1 = new UpdateType("UPDATE_ALL", 0);
        UPDATE_ALL = r1;
        UpdateType r2 = new UpdateType("VIEW_RECYCLED", 1);
        VIEW_RECYCLED = r2;
        UpdateType r3 = new UpdateType("HOT_ATMOSPHERE", 2);
        HOT_ATMOSPHERE = r3;
        UpdateType r4 = new UpdateType("UPDATE_EXPOSE", 3);
        UPDATE_EXPOSE = r4;
        UpdateType r5 = new UpdateType("UPDATE_BUTTON_INFO", 4);
        UPDATE_BUTTON_INFO = r5;
        a = new UpdateType[]{r1, r2, r3, r4, r5};
    }

    public static UpdateType valueOf(String r1) {
        return (UpdateType) r27.a.a(UpdateType.class, r1);
    }

    public static UpdateType[] values() {
        return (UpdateType[]) a.clone();
    }

    public UpdateType(String r1, int r2) {
        super(r1, r2);
    }
}
