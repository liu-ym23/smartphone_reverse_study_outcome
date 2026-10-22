package com.bytedance.android.window.shop.repository.tab.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/a;", "", "Lcom/bytedance/android/window/shop/repository/tab/entity/b;", "selectedItem", "Lcom/bytedance/android/window/shop/repository/tab/entity/b;", "c", "()Lcom/bytedance/android/window/shop/repository/tab/entity/b;", "unselectedItem", "d", "", "selected", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "", "id", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("id")
    private final String id;

    @SerializedName("selected")
    private final Boolean selected;

    @SerializedName("selected_item")
    private final b selectedItem;

    @SerializedName("unselected_item")
    private final b unselectedItem;

    public final String a() {
        return this.id;
    }

    public final Boolean b() {
        return this.selected;
    }

    public final b c() {
        return this.selectedItem;
    }

    public final b d() {
        return this.unselectedItem;
    }
}
