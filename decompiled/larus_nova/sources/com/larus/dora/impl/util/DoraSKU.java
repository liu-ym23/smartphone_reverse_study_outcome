package com.larus.dora.impl.util;

import com.bytedance.android.ec.model.response.ECPromotion;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/util/DoraSKU;", "", "skuName", "", ECPromotion.SKU, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getSkuName", "()Ljava/lang/String;", "getSku", "()I", "BLACK", "WHITE", "SILVER", "PURPLE", "ROUND_BLACK", "ROUND_WHITE", "ROUND_SILVER", "ROUND_PURPLE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraSKU extends Enum<DoraSKU> {
    public static final DoraSKU BLACK = null;
    public static final a Companion = null;
    public static final DoraSKU PURPLE = null;
    public static final DoraSKU ROUND_BLACK = null;
    public static final DoraSKU ROUND_PURPLE = null;
    public static final DoraSKU ROUND_SILVER = null;
    public static final DoraSKU ROUND_WHITE = null;
    public static final DoraSKU SILVER = null;
    public static final DoraSKU WHITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraSKU[] f338116a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f338117b = null;
    private final int sku;
    private final String skuName;

    public static final class a {
        public a() {
        }

        public static DoraSKU a(Integer r100, DoraSKU r101) {
            Intrinsics.checkNotNullParameter(r101, "default");
            DoraSKU[] r102 = DoraSKU.values();
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L14;
            DoraSKU r105 = r102[r104];
            int r106 = r105.getSku();
            if (r100 != null) goto L8;
        L10:
            boolean r107 = false;
        L11:
            if (r107 == true) goto L15;
            r104 = r104 + 1;
        L15:
            if (r105 != null) goto L18;
            return r101;
        L18:
            return r105;
        L8:
            if (r106 != r100.intValue()) goto L10;
            r107 = true;
            goto L11
        L14:
            r105 = null;
            goto L15
        }

        public static /* synthetic */ DoraSKU b(a r100, Integer r101) {
            DoraSKU r102 = DoraSKU.SILVER;
            r100.getClass();
            return a(r101, r102);
        }
    }

    public static EnumEntries<DoraSKU> getEntries() {
        return f338117b;
    }

    static {
        DoraSKU r100 = new DoraSKU("BLACK", 0, "black", 1);
        BLACK = r100;
        DoraSKU r101 = new DoraSKU("WHITE", 1, "white", 2);
        WHITE = r101;
        DoraSKU r102 = new DoraSKU("SILVER", 2, "silver", 3);
        SILVER = r102;
        DoraSKU r103 = new DoraSKU("PURPLE", 3, "purple", 4);
        PURPLE = r103;
        DoraSKU r104 = new DoraSKU("ROUND_BLACK", 4, "round_black", 9);
        ROUND_BLACK = r104;
        DoraSKU r105 = new DoraSKU("ROUND_WHITE", 5, "round_white", 10);
        ROUND_WHITE = r105;
        DoraSKU r110 = new DoraSKU("ROUND_SILVER", 6, "round_silver", 11);
        ROUND_SILVER = r110;
        DoraSKU r111 = new DoraSKU("ROUND_PURPLE", 7, "round_purple", 12);
        ROUND_PURPLE = r111;
        DoraSKU[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f338116a = r112;
        f338117b = EnumEntriesKt.enumEntries(r112);
        Companion = new a();
    }

    public static DoraSKU[] values() {
        return (DoraSKU[]) f338116a.clone();
    }

    public final int getSku() {
        return this.sku;
    }

    public final String getSkuName() {
        return this.skuName;
    }

    public static DoraSKU valueOf(String r100) {
        return (DoraSKU) r27.a.a(DoraSKU.class, r100);
    }

    public DoraSKU(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.skuName = r102;
        this.sku = r103;
    }
}
