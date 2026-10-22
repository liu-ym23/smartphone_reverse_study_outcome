package com.bytedance.android.shopping.slice.preload;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J:\u0010\u000e\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000fj\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`\u0011\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u0010J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/slice/preload/SlcWarmUpModel;", "Ljava/io/Serializable;", "items", "", "Lcom/bytedance/android/shopping/slice/preload/SlcWarmUpItem;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "getDataList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "templateName", "getTemplate", "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcWarmUpModel implements Serializable {

    @SerializedName("items")
    private final List<SlcWarmUpItem> items;

    public SlcWarmUpModel() {
        List r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlcWarmUpModel copy$default(SlcWarmUpModel r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.items;
    L6:
        return r0.copy(r1);
    }

    public final List<SlcWarmUpItem> component1() {
        return this.items;
    }

    public final SlcWarmUpModel copy(List<SlcWarmUpItem> r2) {
        return new SlcWarmUpModel(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof SlcWarmUpModel) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.items, ((SlcWarmUpModel) r2).items) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        List<SlcWarmUpItem> r0 = this.items;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "SlcWarmUpModel(items=" + this.items + ")";
    }

    public final List<SlcWarmUpItem> getItems() {
        return this.items;
    }

    public SlcWarmUpModel(List<SlcWarmUpItem> r1) {
        this.items = r1;
    }

    public final List<HashMap<String, Object>> getDataList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "templateName");
        List<SlcWarmUpItem> r0 = this.items;
        if (r0 == null) goto L15;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        SlcWarmUpItem r2 = (SlcWarmUpItem) r1.next();
        if (r2 == null) goto L10;
        String r3 = r2.getTemplateName();
    L12:
        if (Intrinsics.areEqual(r3, r5) == false) goto L6;
        return r2.getDataList();
    L10:
        r3 = null;
    L15:
        return null;
    }

    public final SlcElement getTemplate(String r5) {
        Intrinsics.checkNotNullParameter(r5, "templateName");
        List<SlcWarmUpItem> r0 = this.items;
        if (r0 == null) goto L15;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        SlcWarmUpItem r2 = (SlcWarmUpItem) r1.next();
        if (r2 == null) goto L10;
        String r3 = r2.getTemplateName();
    L12:
        if (Intrinsics.areEqual(r3, r5) == false) goto L6;
        return r2.getTemplate();
    L10:
        r3 = null;
    L15:
        return null;
    }

    public /* synthetic */ SlcWarmUpModel(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
