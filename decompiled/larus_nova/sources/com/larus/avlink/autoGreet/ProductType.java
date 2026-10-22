package com.larus.avlink.autoGreet;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/avlink/autoGreet/ProductType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "OlaFriend", ExifInterface.LONGITUDE_EAST, "G", "LoryB", "DoraH", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProductType extends Enum<ProductType> {
    public static final a Companion = null;
    public static final ProductType DoraH = null;
    public static final ProductType E = null;
    public static final ProductType G = null;
    public static final ProductType LoryB = null;
    public static final ProductType OlaFriend = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProductType[] f291669a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291670b = null;
    private final int value;

    public static EnumEntries<ProductType> getEntries() {
        return f291670b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.avlink.autoGreet.ProductType$a] */
    static {
        ProductType r100 = new ProductType("OlaFriend", 0, 1);
        OlaFriend = r100;
        ProductType r101 = new ProductType(ExifInterface.LONGITUDE_EAST, 1, 2);
        E = r101;
        ProductType r102 = new ProductType("G", 2, 3);
        G = r102;
        ProductType r103 = new ProductType("LoryB", 3, 4);
        LoryB = r103;
        ProductType r104 = new ProductType("DoraH", 4, 5);
        DoraH = r104;
        ProductType[] r110 = {r100, r101, r102, r103, r104};
        f291669a = r110;
        f291670b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static ProductType[] values() {
        return (ProductType[]) f291669a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ProductType valueOf(String r100) {
        return (ProductType) r27.a.a(ProductType.class, r100);
    }

    public ProductType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
