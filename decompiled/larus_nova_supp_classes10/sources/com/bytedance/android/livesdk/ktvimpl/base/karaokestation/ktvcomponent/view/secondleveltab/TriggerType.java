package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/view/secondleveltab/TriggerType;", "", "Manual", "Bind", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TriggerType extends Enum<TriggerType> {
    public static final TriggerType Bind = null;
    public static final TriggerType Manual = null;
    public static final /* synthetic */ TriggerType[] a = null;

    static {
        TriggerType r1 = new TriggerType("Manual", 0);
        Manual = r1;
        TriggerType r2 = new TriggerType("Bind", 1);
        Bind = r2;
        a = new TriggerType[]{r1, r2};
    }

    public static TriggerType valueOf(String r1) {
        return (TriggerType) r27.a.a(TriggerType.class, r1);
    }

    public static TriggerType[] values() {
        return (TriggerType[]) a.clone();
    }

    public TriggerType(String r1, int r2) {
        super(r1, r2);
    }
}
