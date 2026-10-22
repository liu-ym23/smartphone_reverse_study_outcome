package com.bytedance.android.shopping.store.tabkit.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/e;", "", "", "Lcom/bytedance/android/shopping/store/tabkit/model/f;", "rightItems", "Ljava/util/List;", "c", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "Lcom/bytedance/android/shopping/store/tabkit/model/g;", "itemConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/g;", "b", "()Lcom/bytedance/android/shopping/store/tabkit/model/g;", "e", "(Lcom/bytedance/android/shopping/store/tabkit/model/g;)V", "", "hidden", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "d", "(Ljava/lang/Boolean;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("hidden")
    private Boolean hidden;

    @SerializedName("item_config")
    private g itemConfig;

    @SerializedName("right_items")
    private List<f> rightItems;

    public e() {
    }

    public final Boolean a() {
        return this.hidden;
    }

    public final g b() {
        return this.itemConfig;
    }

    public final List<f> c() {
        return this.rightItems;
    }

    public final void d(Boolean r1) {
        this.hidden = r1;
    }

    public final void e(g r1) {
        this.itemConfig = r1;
    }

    public final void f(List<f> r1) {
        this.rightItems = r1;
    }
}
