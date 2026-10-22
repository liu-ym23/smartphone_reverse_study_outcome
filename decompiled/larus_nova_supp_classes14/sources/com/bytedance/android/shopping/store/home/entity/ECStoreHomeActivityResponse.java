package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeActivityResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicModule;", "dynamicModule", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicModule;", "getDynamicModule", "()Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicModule;", "", "extraSchema", "Ljava/lang/String;", "getExtraSchema", "()Ljava/lang/String;", "", "Lij3/a;", "marqueeBubble", "Ljava/util/List;", "getMarqueeBubble", "()Ljava/util/List;", "Lij3/c;", "multiMarqueeBubble", "getMultiMarqueeBubble", "", "floatSchema", "Ljava/util/Map;", "getFloatSchema", "()Ljava/util/Map;", "Lcom/bytedance/android/shopping/store/home/entity/Blcok;", "block", "Lcom/bytedance/android/shopping/store/home/entity/Blcok;", "getBlock", "()Lcom/bytedance/android/shopping/store/home/entity/Blcok;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHomeActivityResponse extends CommerceBaseResponse {

    @SerializedName("activity_dynamic_block")
    private final Blcok block;

    @SerializedName("activity_dynamic_models")
    private final ECStoreDynamicModule dynamicModule;

    @SerializedName("extra_schema")
    private final String extraSchema;

    @SerializedName("float_schema")
    private final Map<String, String> floatSchema;

    @SerializedName("marquee_bubble")
    private final List<ij3.a> marqueeBubble;

    @SerializedName("multi_marquee_bubble")
    private final List<ij3.c> multiMarqueeBubble;

    public ECStoreHomeActivityResponse() {
    }

    public final Blcok getBlock() {
        return this.block;
    }

    public final ECStoreDynamicModule getDynamicModule() {
        return this.dynamicModule;
    }

    public final String getExtraSchema() {
        return this.extraSchema;
    }

    public final Map<String, String> getFloatSchema() {
        return this.floatSchema;
    }

    public final List<ij3.a> getMarqueeBubble() {
        return this.marqueeBubble;
    }

    public final List<ij3.c> getMultiMarqueeBubble() {
        return this.multiMarqueeBubble;
    }
}
