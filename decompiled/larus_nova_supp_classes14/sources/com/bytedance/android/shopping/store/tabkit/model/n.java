package com.bytedance.android.shopping.store.tabkit.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/n;", "", "", "displayMode", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setDisplayMode", "(Ljava/lang/Integer;)V", "", "", "colors", "Ljava/util/List;", "a", "()Ljava/util/List;", "setColors", "(Ljava/util/List;)V", "width", "d", "setWidth", "height", "c", "setHeight", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("colors")
    private List<String> colors;

    @SerializedName("display_mode")
    private Integer displayMode;

    @SerializedName("height")
    private Integer height;

    @SerializedName("width")
    private Integer width;

    public n() {
    }

    public final List<String> a() {
        return this.colors;
    }

    public final Integer b() {
        return this.displayMode;
    }

    public final Integer c() {
        return this.height;
    }

    public final Integer d() {
        return this.width;
    }
}
