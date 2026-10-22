package com.larus.dora.api.h;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.facebook.keyframes.model.KFFeatureEffect;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/api/h/HSKU;", "", "skuName", "", ECPromotion.SKU, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getSkuName", "()Ljava/lang/String;", "getSku", "()I", "SILVER", "WHITE", "BLACK", "BLUE", "GRADIENT", "PURPLE", "ORANGE", "BLACKENED", "HORSE_YEAR_WHITE", "GOLD", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HSKU extends Enum<HSKU> {
    public static final HSKU BLACK = null;
    public static final HSKU BLACKENED = null;
    public static final HSKU BLUE = null;
    public static final a Companion = null;
    public static final HSKU GOLD = null;
    public static final HSKU GRADIENT = null;
    public static final HSKU HORSE_YEAR_WHITE = null;
    public static final HSKU ORANGE = null;
    public static final HSKU PURPLE = null;
    public static final HSKU SILVER = null;
    public static final HSKU WHITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HSKU[] f331741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331742b = null;
    private final int sku;
    private final String skuName;

    public static final class a {
        public a() {
        }

        public static HSKU a(Integer r100) {
            if (r100 == null) goto L16;
            HSKU[] r101 = HSKU.values();
            int r102 = r101.length;
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L13;
            HSKU r104 = r101[r103];
            if (r104.getSku() != r100.intValue()) goto L9;
            boolean r105 = true;
        L10:
            if (r105 == true) goto L14;
            r103 = r103 + 1;
        L14:
            if (r104 == null) goto L16;
            return r104;
        L9:
            r105 = false;
            goto L10
        L13:
            r104 = null;
        L16:
            return HSKU.WHITE;
        }
    }

    public static EnumEntries<HSKU> getEntries() {
        return f331742b;
    }

    static {
        HSKU r100 = new HSKU("SILVER", 0, "silver", 0);
        SILVER = r100;
        HSKU r101 = new HSKU("WHITE", 1, "white", 1);
        WHITE = r101;
        HSKU r102 = new HSKU("BLACK", 2, "black", 2);
        BLACK = r102;
        HSKU r103 = new HSKU("BLUE", 3, "blue", 5);
        BLUE = r103;
        HSKU r104 = new HSKU("GRADIENT", 4, KFFeatureEffect.GRADIENT_JSON_FIELD, 6);
        GRADIENT = r104;
        HSKU r105 = new HSKU("PURPLE", 5, "purple", 7);
        PURPLE = r105;
        HSKU r110 = new HSKU("ORANGE", 6, "orange", 9);
        ORANGE = r110;
        HSKU r111 = new HSKU("BLACKENED", 7, "blackened", 14);
        BLACKENED = r111;
        HSKU r106 = new HSKU("HORSE_YEAR_WHITE", 8, "horse_year_white", 20);
        HORSE_YEAR_WHITE = r106;
        HSKU r107 = new HSKU("GOLD", 9, "gold", 23);
        GOLD = r107;
        HSKU[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111, r106, r107};
        f331741a = r112;
        f331742b = EnumEntriesKt.enumEntries(r112);
        Companion = new a();
    }

    public static HSKU[] values() {
        return (HSKU[]) f331741a.clone();
    }

    public final int getSku() {
        return this.sku;
    }

    public final String getSkuName() {
        return this.skuName;
    }

    public static HSKU valueOf(String r100) {
        return (HSKU) r27.a.a(HSKU.class, r100);
    }

    public HSKU(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.skuName = r102;
        this.sku = r103;
    }
}
