package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/RandomMatchStrategy;", "", "Unknown", "Normal", "LargeMatch", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RandomMatchStrategy extends Enum<RandomMatchStrategy> {
    public static final RandomMatchStrategy LargeMatch = null;
    public static final RandomMatchStrategy Normal = null;
    public static final RandomMatchStrategy Unknown = null;
    public static final /* synthetic */ RandomMatchStrategy[] a = null;

    static {
        RandomMatchStrategy r1 = new RandomMatchStrategy("Unknown", 0);
        Unknown = r1;
        RandomMatchStrategy r2 = new RandomMatchStrategy("Normal", 1);
        Normal = r2;
        RandomMatchStrategy r3 = new RandomMatchStrategy("LargeMatch", 2);
        LargeMatch = r3;
        a = new RandomMatchStrategy[]{r1, r2, r3};
    }

    public static RandomMatchStrategy valueOf(String r1) {
        return (RandomMatchStrategy) r27.a.a(RandomMatchStrategy.class, r1);
    }

    public static RandomMatchStrategy[] values() {
        return (RandomMatchStrategy[]) a.clone();
    }

    public RandomMatchStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
