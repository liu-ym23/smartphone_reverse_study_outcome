package com.bytedance.android.shopping.order.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/order/dto/Product;", "Ljava/io/Serializable;", "name", "", "img", "(Ljava/lang/String;Ljava/lang/String;)V", "getImg", "()Ljava/lang/String;", "getName", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Product implements Serializable {

    @SerializedName("img")
    private final String img;

    @SerializedName("name")
    private final String name;

    public Product() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public final String getImg() {
        return this.img;
    }

    public final String getName() {
        return this.name;
    }

    public Product(String r1, String r2) {
        this.name = r1;
        this.img = r2;
    }

    public /* synthetic */ Product(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3);
    }
}
