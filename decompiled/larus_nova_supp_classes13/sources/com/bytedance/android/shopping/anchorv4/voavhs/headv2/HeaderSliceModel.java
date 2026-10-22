package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b.\u0010/J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JQ\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0013\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÖ\u0003R\"\u0010\u0019\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010$R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "component2", "", "", "component3", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "component4", "Lcom/bytedance/android/ecom/arch/slice/g;", "component5", "sliceId", "sliceTemplate", "sliceTemplateData", "showActions", "geckoSlice", "copy", "toString", "", "hashCode", "other", "", "equals", "hasReportedShowEvent", "Z", "getHasReportedShowEvent", "()Z", "setHasReportedShowEvent", "(Z)V", "Ljava/lang/String;", "getSliceId", "()Ljava/lang/String;", "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "getSliceTemplate", "()Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "Ljava/util/Map;", "getSliceTemplateData", "()Ljava/util/Map;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "getShowActions", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "Lcom/bytedance/android/ecom/arch/slice/g;", "getGeckoSlice", "()Lcom/bytedance/android/ecom/arch/slice/g;", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;Ljava/util/Map;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Lcom/bytedance/android/ecom/arch/slice/g;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderSliceModel implements Serializable {

    @SerializedName("slice")
    private final com.bytedance.android.ecom.arch.slice.g geckoSlice;
    private boolean hasReportedShowEvent;

    @SerializedName("show_actions")
    private final IAction showActions;

    @SerializedName("slice_id")
    private final String sliceId;

    @SerializedName("slice_template")
    private final SlcElement sliceTemplate;

    @SerializedName("slice_template_data")
    private final Map<String, Object> sliceTemplateData;

    public HeaderSliceModel() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderSliceModel copy$default(HeaderSliceModel r3, String r4, SlcElement r5, Map r6, IAction r7, com.bytedance.android.ecom.arch.slice.g r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.sliceId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.sliceTemplate;
    L8:
        SlcElement r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.sliceTemplateData;
    L11:
        Map r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.showActions;
    L14:
        IAction r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.geckoSlice;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.sliceId;
    }

    public final SlcElement component2() {
        return this.sliceTemplate;
    }

    public final Map<String, Object> component3() {
        return this.sliceTemplateData;
    }

    public final IAction component4() {
        return this.showActions;
    }

    public final com.bytedance.android.ecom.arch.slice.g component5() {
        return this.geckoSlice;
    }

    public final HeaderSliceModel copy(String r8, SlcElement r9, Map<String, ? extends Object> r10, IAction r11, com.bytedance.android.ecom.arch.slice.g r12) {
        return new HeaderSliceModel(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderSliceModel) == false) goto L16;
        HeaderSliceModel r4 = (HeaderSliceModel) r3;
        if (Intrinsics.areEqual(this.sliceId, r4.sliceId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sliceTemplate, r4.sliceTemplate) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sliceTemplateData, r4.sliceTemplateData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showActions, r4.showActions) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.geckoSlice, r4.geckoSlice) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.sliceId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        SlcElement r4 = this.sliceTemplate;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Object> r7 = this.sliceTemplateData;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        IAction r10 = this.showActions;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        com.bytedance.android.ecom.arch.slice.g r13 = this.geckoSlice;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HeaderSliceModel(sliceId=" + this.sliceId + ", sliceTemplate=" + this.sliceTemplate + ", sliceTemplateData=" + this.sliceTemplateData + ", showActions=" + this.showActions + ", geckoSlice=" + this.geckoSlice + ")";
    }

    public final com.bytedance.android.ecom.arch.slice.g getGeckoSlice() {
        return this.geckoSlice;
    }

    public final boolean getHasReportedShowEvent() {
        return this.hasReportedShowEvent;
    }

    public final IAction getShowActions() {
        return this.showActions;
    }

    public final String getSliceId() {
        return this.sliceId;
    }

    public final SlcElement getSliceTemplate() {
        return this.sliceTemplate;
    }

    public final Map<String, Object> getSliceTemplateData() {
        return this.sliceTemplateData;
    }

    public final void setHasReportedShowEvent(boolean r1) {
        this.hasReportedShowEvent = r1;
    }

    public HeaderSliceModel(String r1, SlcElement r2, Map<String, ? extends Object> r3, IAction r4, com.bytedance.android.ecom.arch.slice.g r5) {
        this.sliceId = r1;
        this.sliceTemplate = r2;
        this.sliceTemplateData = r3;
        this.showActions = r4;
        this.geckoSlice = r5;
    }

    public /* synthetic */ HeaderSliceModel(String r5, SlcElement r6, Map r7, IAction r8, com.bytedance.android.ecom.arch.slice.g r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        SlcElement r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        Map r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        IAction r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        com.bytedance.android.ecom.arch.slice.g r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
