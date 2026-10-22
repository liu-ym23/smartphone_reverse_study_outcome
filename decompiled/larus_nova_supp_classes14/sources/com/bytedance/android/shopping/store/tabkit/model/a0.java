package com.bytedance.android.shopping.store.tabkit.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR2\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/a0;", "", "", "Lcom/bytedance/android/shopping/store/tabkit/model/b0;", "showEvents", "Ljava/util/List;", "c", "()Ljava/util/List;", "setShowEvents", "(Ljava/util/List;)V", "clickEvents", "a", "setClickEvents", "", "", "commonParams", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setCommonParams", "(Ljava/util/Map;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("click_events")
    private List<b0> clickEvents;

    @SerializedName("common_params")
    private Map<String, String> commonParams;

    @SerializedName("show_events")
    private List<b0> showEvents;

    public a0() {
    }

    public final List<b0> a() {
        return this.clickEvents;
    }

    public final Map<String, String> b() {
        return this.commonParams;
    }

    public final List<b0> c() {
        return this.showEvents;
    }
}
