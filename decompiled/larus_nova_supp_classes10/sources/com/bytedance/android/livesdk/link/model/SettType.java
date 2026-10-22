package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/SettType;", "", "UnDeFined", "Accept", "RefuseByTimeOut", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SettType extends Enum<SettType> {
    public static final SettType Accept = null;
    public static final SettType RefuseByTimeOut = null;
    public static final SettType UnDeFined = null;
    public static final /* synthetic */ SettType[] a = null;

    static {
        SettType r1 = new SettType("UnDeFined", 0);
        UnDeFined = r1;
        SettType r2 = new SettType("Accept", 1);
        Accept = r2;
        SettType r3 = new SettType("RefuseByTimeOut", 2);
        RefuseByTimeOut = r3;
        a = new SettType[]{r1, r2, r3};
    }

    public static SettType valueOf(String r1) {
        return (SettType) r27.a.a(SettType.class, r1);
    }

    public static SettType[] values() {
        return (SettType[]) a.clone();
    }

    public SettType(String r1, int r2) {
        super(r1, r2);
    }
}
