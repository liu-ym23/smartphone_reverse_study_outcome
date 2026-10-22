package com.bytedance.android.shopping.infeed.data.idl;

import com.google.gson.annotations.SerializedName;
import he3.n0;
import he3.p0;
import ie3.a;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductPackDataElements;", "Ljava/io/Serializable;", "", "Lhe3/p0;", "products", "Ljava/util/List;", "getProducts", "()Ljava/util/List;", "Lhe3/n0;", "sliceCard", "Lhe3/n0;", "getSliceCard", "()Lhe3/n0;", "Lie3/a;", "ad", "Lie3/a;", "getAd", "()Lie3/a;", "setAd", "(Lie3/a;)V", "Lhe3/a;", "author", "Lhe3/a;", "getAuthor", "()Lhe3/a;", "<init>", "(Ljava/util/List;Lhe3/n0;Lie3/a;Lhe3/a;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFeedProductPackDataElements implements Serializable {

    @SerializedName("ad")
    private a ad;

    @SerializedName("author")
    private final he3.a author;

    @SerializedName("products")
    private final List<p0> products;

    @SerializedName("slice_card")
    private final n0 sliceCard;

    public InFeedProductPackDataElements() {
        this(null, null, null, null, 15, null);
    }

    public final a getAd() {
        return this.ad;
    }

    public final he3.a getAuthor() {
        return this.author;
    }

    public final List<p0> getProducts() {
        return this.products;
    }

    public final n0 getSliceCard() {
        return this.sliceCard;
    }

    public final void setAd(a r1) {
        this.ad = r1;
    }

    public InFeedProductPackDataElements(List<p0> r1, n0 r2, a r3, he3.a r4) {
        this.products = r1;
        this.sliceCard = r2;
        this.ad = r3;
        this.author = r4;
    }

    public /* synthetic */ InFeedProductPackDataElements(List r2, n0 r3, a r4, he3.a r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
