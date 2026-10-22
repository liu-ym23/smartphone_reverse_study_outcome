package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0015Jv\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u000eHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/ProductFormat;", "Ljava/io/Serializable;", "name", "", "message", "", "Lcom/bytedance/android/shopping/feed/repository/dto/AttrItem;", "logo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "picUrls", "context", "type", "pageTitle", "maxLines", "", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContext", "()Ljava/lang/String;", "getLogo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getMaxLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/util/List;", "getName", "getPageTitle", "getPicUrls", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/feed/repository/dto/ProductFormat;", "equals", "", "other", "", "hashCode", "toString", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFormat implements Serializable {

    @SerializedName("context")
    private final String context;

    @SerializedName("logo")
    private final ECUrlModel logo;

    @SerializedName("max_lines")
    private final Integer maxLines;

    @SerializedName("message")
    private final List<AttrItem> message;

    @SerializedName("name")
    private final String name;

    @SerializedName("page_title")
    private final String pageTitle;

    @SerializedName("pic_urls")
    private final List<ECUrlModel> picUrls;

    @SerializedName("type")
    private final String type;

    public ProductFormat() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductFormat copy$default(ProductFormat r9, String r10, List r11, ECUrlModel r12, List r13, String r14, String r15, String r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.name;
    L7:
        if ((r18 & 2) == 0) goto L9;
        List r3 = r9.message;
    L11:
        if ((r18 & 4) == 0) goto L13;
        ECUrlModel r4 = r9.logo;
    L15:
        if ((r18 & 8) == 0) goto L17;
        List r5 = r9.picUrls;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.context;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.type;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.pageTitle;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Integer r1 = r9.maxLines;
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

    public final String component1() {
        return this.name;
    }

    public final List<AttrItem> component2() {
        return this.message;
    }

    public final ECUrlModel component3() {
        return this.logo;
    }

    public final List<ECUrlModel> component4() {
        return this.picUrls;
    }

    public final String component5() {
        return this.context;
    }

    public final String component6() {
        return this.type;
    }

    public final String component7() {
        return this.pageTitle;
    }

    public final Integer component8() {
        return this.maxLines;
    }

    public final ProductFormat copy(String r11, List<AttrItem> r12, ECUrlModel r13, List<? extends ECUrlModel> r14, String r15, String r16, String r17, Integer r18) {
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "message");
        return new ProductFormat(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ProductFormat) == false) goto L22;
        ProductFormat r4 = (ProductFormat) r3;
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r4.message) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.logo, r4.logo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picUrls, r4.picUrls) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.context, r4.context) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pageTitle, r4.pageTitle) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.maxLines, r4.maxLines) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<AttrItem> r4 = this.message;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECUrlModel r7 = this.logo;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<ECUrlModel> r10 = this.picUrls;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.context;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.type;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.pageTitle;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.maxLines;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
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
        return "ProductFormat(name=" + this.name + ", message=" + this.message + ", logo=" + this.logo + ", picUrls=" + this.picUrls + ", context=" + this.context + ", type=" + this.type + ", pageTitle=" + this.pageTitle + ", maxLines=" + this.maxLines + ")";
    }

    public final String getContext() {
        return this.context;
    }

    public final ECUrlModel getLogo() {
        return this.logo;
    }

    public final Integer getMaxLines() {
        return this.maxLines;
    }

    public final List<AttrItem> getMessage() {
        return this.message;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final List<ECUrlModel> getPicUrls() {
        return this.picUrls;
    }

    public final String getType() {
        return this.type;
    }

    public ProductFormat(String r2, List<AttrItem> r3, ECUrlModel r4, List<? extends ECUrlModel> r5, String r6, String r7, String r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "message");
        this.name = r2;
        this.message = r3;
        this.logo = r4;
        this.picUrls = r5;
        this.context = r6;
        this.type = r7;
        this.pageTitle = r8;
        this.maxLines = r9;
    }

    public /* synthetic */ ProductFormat(String r10, List r11, ECUrlModel r12, List r13, String r14, String r15, String r16, Integer r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r18 & 2) == 0) goto L9;
        List r2 = CollectionsKt.emptyList();
    L10:
        Integer r4 = null;
        if ((r18 & 4) == 0) goto L13;
        ECUrlModel r3 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r4 = r17;
    L34:
        this(r1, r2, r3, r5, r6, r7, r8, r4);
        return;
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
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L10
    L5:
        r1 = r10;
        goto L7
    }
}
