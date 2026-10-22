package com.bytedance.android.window.shop.repository.tab.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/l0;", "", "", "Lcom/bytedance/android/ec/window/base/repository/dto/q;", "sorts", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "layoutType", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l0 {

    @SerializedName("layout_type")
    private final Integer layoutType;

    @SerializedName("sort_types")
    private final List<com.bytedance.android.ec.window.base.repository.dto.q> sorts;

    public l0() {
        this.sorts = null;
        this.layoutType = null;
    }

    public final Integer a() {
        return this.layoutType;
    }

    public final List<com.bytedance.android.ec.window.base.repository.dto.q> b() {
        return this.sorts;
    }
}
