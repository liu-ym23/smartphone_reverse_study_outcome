package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.shopping.store.hybrid.entity.ComponentsWrapper;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020\u001aR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bRF\u0010\t\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r`\u000e\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabData;", "Ljava/io/Serializable;", "()V", "block", "Lcom/google/gson/JsonObject;", "getBlock", "()Lcom/google/gson/JsonObject;", "setBlock", "(Lcom/google/gson/JsonObject;)V", "components", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getComponents", "()Ljava/util/List;", "setComponents", "(Ljava/util/List;)V", "cursor", "", "getCursor", "()J", "setCursor", "(J)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "hybridList", "Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;", "getHybridList", "()Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;", "setHybridList", "(Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;)V", "raw", "getRaw", "()Ljava/lang/String;", "setRaw", "(Ljava/lang/String;)V", "containsHybridTabData", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreDynamicTabData implements Serializable {

    @SerializedName("block")
    private JsonObject block;

    @SerializedName("components")
    private List<? extends HashMap<String, Object>> components;

    @SerializedName("cursor")
    private long cursor;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("hybrid_list")
    private HybridListDTO hybridList;

    @SerializedName("raw")
    private String raw;

    public ECStoreDynamicTabData() {
    }

    public final boolean containsHybridTabData() {
        if (new ComponentsWrapper(this.components, this.block).hasComponents() == true) goto L17;
        String r0 = this.raw;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
    L15:
        return false;
    L13:
        if ((!Intrinsics.areEqual(this.raw, "{}")) == false) goto L15;
        return true;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
        goto L11
    L17:
        return true;
    }

    public final JsonObject getBlock() {
        return this.block;
    }

    public final List<HashMap<String, Object>> getComponents() {
        return this.components;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final HybridListDTO getHybridList() {
        return this.hybridList;
    }

    public final String getRaw() {
        return this.raw;
    }

    public final void setBlock(JsonObject r1) {
        this.block = r1;
    }

    public final void setComponents(List<? extends HashMap<String, Object>> r1) {
        this.components = r1;
    }

    public final void setCursor(long r1) {
        this.cursor = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setHybridList(HybridListDTO r1) {
        this.hybridList = r1;
    }

    public final void setRaw(String r1) {
        this.raw = r1;
    }
}
