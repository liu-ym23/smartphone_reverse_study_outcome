package com.ss.android.lark.biz.core.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/core/api/VEScanStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "HW_SCAN", "qrcode-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VEScanStrategy extends Enum<VEScanStrategy> {
    public static final VEScanStrategy DEFAULT = null;
    public static final VEScanStrategy HW_SCAN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEScanStrategy[] f409794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409795b = null;

    public static EnumEntries<VEScanStrategy> getEntries() {
        return f409795b;
    }

    static {
        VEScanStrategy r100 = new VEScanStrategy("DEFAULT", 0);
        DEFAULT = r100;
        VEScanStrategy r101 = new VEScanStrategy("HW_SCAN", 1);
        HW_SCAN = r101;
        VEScanStrategy[] r102 = {r100, r101};
        f409794a = r102;
        f409795b = EnumEntriesKt.enumEntries(r102);
    }

    public static VEScanStrategy[] values() {
        return (VEScanStrategy[]) f409794a.clone();
    }

    public static VEScanStrategy valueOf(String r100) {
        return (VEScanStrategy) a.a(VEScanStrategy.class, r100);
    }

    public VEScanStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
