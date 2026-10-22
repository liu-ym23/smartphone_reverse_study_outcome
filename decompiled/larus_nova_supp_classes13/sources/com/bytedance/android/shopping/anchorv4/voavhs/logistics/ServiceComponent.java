package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003Jq\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\rHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\rHÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0011\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018¨\u00060"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/ServiceComponent;", "Ljava/io/Serializable;", "header", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "detailContent", "", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "additionalInfo", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/LogisticsAdditionalInfo;", "processItems", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "suffix", "space", "", "showEvent", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "serviceType", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/LogisticsAdditionalInfo;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;ILjava/util/List;I)V", "getAdditionalInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/LogisticsAdditionalInfo;", "getDetailContent", "()Ljava/util/List;", "getHeader", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getProcessItems", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "getServiceType", "()I", "getShowEvent", "getSpace", "getSuffix", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ServiceComponent implements Serializable {

    @SerializedName("additional_info")
    private final LogisticsAdditionalInfo additionalInfo;

    @SerializedName("detail_content")
    private final List<LongContentLabelComponent> detailContent;

    @SerializedName("header")
    private final TextWithOneIconElement header;

    @SerializedName("process_item")
    private final TagsScrollBoxComponent processItems;

    @SerializedName("service_type")
    private final int serviceType;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    @SerializedName("space")
    private final int space;

    @SerializedName("suffix")
    private final TextWithOneIconElement suffix;

    public ServiceComponent() {
        this(null, null, null, null, null, 0, null, 0, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServiceComponent copy$default(ServiceComponent r9, TextWithOneIconElement r10, List r11, LogisticsAdditionalInfo r12, TagsScrollBoxComponent r13, TextWithOneIconElement r14, int r15, List r16, int r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        TextWithOneIconElement r2 = r9.header;
    L7:
        if ((r18 & 2) == 0) goto L9;
        List r3 = r9.detailContent;
    L11:
        if ((r18 & 4) == 0) goto L13;
        LogisticsAdditionalInfo r4 = r9.additionalInfo;
    L15:
        if ((r18 & 8) == 0) goto L17;
        TagsScrollBoxComponent r5 = r9.processItems;
    L19:
        if ((r18 & 16) == 0) goto L21;
        TextWithOneIconElement r6 = r9.suffix;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.space;
    L27:
        if ((r18 & 64) == 0) goto L29;
        List r8 = r9.showEvent;
    L31:
        if ((r18 & 128) == 0) goto L33;
        int r1 = r9.serviceType;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final TextWithOneIconElement component1() {
        return this.header;
    }

    public final List<LongContentLabelComponent> component2() {
        return this.detailContent;
    }

    public final LogisticsAdditionalInfo component3() {
        return this.additionalInfo;
    }

    public final TagsScrollBoxComponent component4() {
        return this.processItems;
    }

    public final TextWithOneIconElement component5() {
        return this.suffix;
    }

    public final int component6() {
        return this.space;
    }

    public final List<ShowEvent> component7() {
        return this.showEvent;
    }

    public final int component8() {
        return this.serviceType;
    }

    public final ServiceComponent copy(TextWithOneIconElement r11, List<LongContentLabelComponent> r12, LogisticsAdditionalInfo r13, TagsScrollBoxComponent r14, TextWithOneIconElement r15, int r16, List<ShowEvent> r17, int r18) {
        return new ServiceComponent(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ServiceComponent) == false) goto L22;
        ServiceComponent r4 = (ServiceComponent) r3;
        if (Intrinsics.areEqual(this.header, r4.header) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.detailContent, r4.detailContent) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.additionalInfo, r4.additionalInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.processItems, r4.processItems) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.suffix, r4.suffix) == true) goto L16;
        return false;
    L16:
        if (this.space == r4.space) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showEvent, r4.showEvent) == true) goto L20;
        return false;
    L20:
        if (this.serviceType == r4.serviceType) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        TextWithOneIconElement r0 = this.header;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<LongContentLabelComponent> r4 = this.detailContent;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        LogisticsAdditionalInfo r7 = this.additionalInfo;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        TagsScrollBoxComponent r10 = this.processItems;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        TextWithOneIconElement r13 = this.suffix;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (((r12 + r14) * 31) + this.space) * 31;
        List<ShowEvent> r16 = this.showEvent;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return ((r15 + r1) * 31) + this.serviceType;
    L21:
        r14 = 0;
        goto L22
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
        return "ServiceComponent(header=" + this.header + ", detailContent=" + this.detailContent + ", additionalInfo=" + this.additionalInfo + ", processItems=" + this.processItems + ", suffix=" + this.suffix + ", space=" + this.space + ", showEvent=" + this.showEvent + ", serviceType=" + this.serviceType + ")";
    }

    public final LogisticsAdditionalInfo getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final List<LongContentLabelComponent> getDetailContent() {
        return this.detailContent;
    }

    public final TextWithOneIconElement getHeader() {
        return this.header;
    }

    public final TagsScrollBoxComponent getProcessItems() {
        return this.processItems;
    }

    public final int getServiceType() {
        return this.serviceType;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public final int getSpace() {
        return this.space;
    }

    public final TextWithOneIconElement getSuffix() {
        return this.suffix;
    }

    public ServiceComponent(TextWithOneIconElement r1, List<LongContentLabelComponent> r2, LogisticsAdditionalInfo r3, TagsScrollBoxComponent r4, TextWithOneIconElement r5, int r6, List<ShowEvent> r7, int r8) {
        this.header = r1;
        this.detailContent = r2;
        this.additionalInfo = r3;
        this.processItems = r4;
        this.suffix = r5;
        this.space = r6;
        this.showEvent = r7;
        this.serviceType = r8;
    }

    public /* synthetic */ ServiceComponent(TextWithOneIconElement r11, List r12, LogisticsAdditionalInfo r13, TagsScrollBoxComponent r14, TextWithOneIconElement r15, int r16, List r17, int r18, int r19, DefaultConstructorMarker r20) {
        List r2 = null;
        if ((r19 & 1) == 0) goto L5;
        TextWithOneIconElement r1 = null;
    L7:
        if ((r19 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r19 & 4) == 0) goto L13;
        LogisticsAdditionalInfo r4 = null;
    L15:
        if ((r19 & 8) == 0) goto L17;
        TagsScrollBoxComponent r5 = null;
    L19:
        if ((r19 & 16) == 0) goto L21;
        TextWithOneIconElement r6 = null;
    L22:
        int r8 = 0;
        if ((r19 & 32) == 0) goto L25;
        int r7 = 0;
    L27:
        if ((r19 & 64) != 0) goto L31;
        r2 = r17;
    L31:
        if ((r19 & 128) != 0) goto L34;
        r8 = r18;
    L34:
        this(r1, r3, r4, r5, r6, r7, r2, r8);
        return;
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L22
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
