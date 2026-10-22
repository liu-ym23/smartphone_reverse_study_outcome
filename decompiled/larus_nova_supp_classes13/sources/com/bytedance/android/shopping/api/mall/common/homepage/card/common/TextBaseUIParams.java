package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "", "content", "", "style", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;)V", "getContent", "()Ljava/lang/String;", "getStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextBaseUIParams {

    @SerializedName("content")
    private final String content;

    @SerializedName("client_style")
    private final ProductStyle style;

    /* JADX WARN: Multi-variable type inference failed */
    public TextBaseUIParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TextBaseUIParams copy$default(TextBaseUIParams r0, String r1, ProductStyle r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.content;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.style;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.content;
    }

    public final ProductStyle component2() {
        return this.style;
    }

    public final TextBaseUIParams copy(String r2, ProductStyle r3) {
        return new TextBaseUIParams(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof TextBaseUIParams) == false) goto L10;
        TextBaseUIParams r4 = (TextBaseUIParams) r3;
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.style, r4.style) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.content;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ProductStyle r4 = this.style;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "TextBaseUIParams(content=" + this.content + ", style=" + this.style + ")";
    }

    public final String getContent() {
        return this.content;
    }

    public final ProductStyle getStyle() {
        return this.style;
    }

    public TextBaseUIParams(String r1, ProductStyle r2) {
        this.content = r1;
        this.style = r2;
    }

    public /* synthetic */ TextBaseUIParams(String r2, ProductStyle r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
