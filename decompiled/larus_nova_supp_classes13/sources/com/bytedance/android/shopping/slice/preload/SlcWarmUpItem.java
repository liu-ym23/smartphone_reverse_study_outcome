package com.bytedance.android.shopping.slice.preload;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00124\b\u0002\u0010\u0006\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0014\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n\u0018\u00010\u0007HÆ\u0003JW\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u000524\b\u0002\u0010\u0006\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001RB\u0010\u0006\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/slice/preload/SlcWarmUpItem;", "Ljava/io/Serializable;", "templateName", "", "template", "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "dataList", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;Ljava/util/List;)V", "getDataList", "()Ljava/util/List;", "getTemplate", "()Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "getTemplateName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcWarmUpItem implements Serializable {

    @SerializedName("data_list")
    private final List<HashMap<String, Object>> dataList;

    @SerializedName("template")
    private final SlcElement template;

    @SerializedName("template_name")
    private final String templateName;

    public SlcWarmUpItem() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlcWarmUpItem copy$default(SlcWarmUpItem r0, String r1, SlcElement r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.templateName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.template;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.dataList;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.templateName;
    }

    public final SlcElement component2() {
        return this.template;
    }

    public final List<HashMap<String, Object>> component3() {
        return this.dataList;
    }

    public final SlcWarmUpItem copy(String r2, SlcElement r3, List<? extends HashMap<String, Object>> r4) {
        return new SlcWarmUpItem(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SlcWarmUpItem) == false) goto L12;
        SlcWarmUpItem r4 = (SlcWarmUpItem) r3;
        if (Intrinsics.areEqual(this.templateName, r4.templateName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.template, r4.template) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dataList, r4.dataList) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.templateName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        SlcElement r4 = this.template;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<HashMap<String, Object>> r7 = this.dataList;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SlcWarmUpItem(templateName=" + this.templateName + ", template=" + this.template + ", dataList=" + this.dataList + ")";
    }

    public final List<HashMap<String, Object>> getDataList() {
        return this.dataList;
    }

    public final SlcElement getTemplate() {
        return this.template;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SlcWarmUpItem(String r1, SlcElement r2, List<? extends HashMap<String, Object>> r3) {
        this.templateName = r1;
        this.template = r2;
        this.dataList = r3;
    }

    public /* synthetic */ SlcWarmUpItem(String r2, SlcElement r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
