package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.entity.dto.SSRDataDecodingFormat;
import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import com.bytedance.android.window.shop.repository.dto.v0;
import com.bytedance.android.window.shop.repository.dto.w0;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v extends f {
    public static final /* synthetic */ int n = 0;
    public String j;
    public b k;
    public boolean l;
    public d m;

    public static final class a {
        public static v a(v0 r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "dto");
            if (r5.e() == true) goto L6;
            return null;
        L6:
            v r1 = new v(r6);
            r1.j = r5.b();
            w0 r7 = r5.d();
            if (r7 == null) goto L9;
            int r2 = d.a;
            Intrinsics.checkNotNullParameter(r7, "dto");
            r1.m = new d(r7.c(), r7.a(), r7.b(), r7.d());
        L9:
            String r8 = r5.a();
            if (r8 == null) goto L12;
            r1.k = (b) u0.b(r8, b.class);
        L12:
            return r1;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/v$b;", "", "", "lynxSchema", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setLynxSchema", "(Ljava/lang/String;)V", "", "predictHeight", "I", "getPredictHeight", "()I", "setPredictHeight", "(I)V", "fixedHeight", "getFixedHeight", "setFixedHeight", "", "spanRatio", "F", "d", "()F", "setSpanRatio", "(F)V", "", "formModifiable", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setFormModifiable", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/window/shop/repository/tab/entity/v$c;", "edge", "Lcom/bytedance/android/window/shop/repository/tab/entity/v$c;", "a", "()Lcom/bytedance/android/window/shop/repository/tab/entity/v$c;", "setEdge", "(Lcom/bytedance/android/window/shop/repository/tab/entity/v$c;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("edge")
        private c edge;

        @SerializedName("fixed_height")
        private int fixedHeight;

        @SerializedName("form_modifiable")
        private Boolean formModifiable;

        @SerializedName("lynx_schema")
        private String lynxSchema;

        @SerializedName("predict_height")
        private int predictHeight;

        @SerializedName("span_ratio")
        private float spanRatio;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L18;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.lynxSchema, r4.lynxSchema) == true) goto L8;
            return false;
        L8:
            if (this.predictHeight == r4.predictHeight) goto L10;
            return false;
        L10:
            if (this.fixedHeight == r4.fixedHeight) goto L12;
            return false;
        L12:
            if (Float.compare(this.spanRatio, r4.spanRatio) == 0) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.formModifiable, r4.formModifiable) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.edge, r4.edge) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            String r0 = this.lynxSchema;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((((((r2 * 31) + this.predictHeight) * 31) + this.fixedHeight) * 31) + Float.floatToIntBits(this.spanRatio)) * 31;
            Boolean r4 = this.formModifiable;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            c r7 = this.edge;
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

        public final String toString() {
            return "ShopLynxItemConfigVO(lynxSchema=" + this.lynxSchema + ", predictHeight=" + this.predictHeight + ", fixedHeight=" + this.fixedHeight + ", spanRatio=" + this.spanRatio + ", formModifiable=" + this.formModifiable + ", edge=" + this.edge + ")";
        }

        public b() {
            Boolean r0 = Boolean.FALSE;
            this.lynxSchema = null;
            this.predictHeight = 0;
            this.fixedHeight = 0;
            this.spanRatio = 1.0f;
            this.formModifiable = r0;
            this.edge = null;
        }

        public final c a() {
            return this.edge;
        }

        public final Boolean b() {
            return this.formModifiable;
        }

        public final String c() {
            return this.lynxSchema;
        }

        public final float d() {
            return this.spanRatio;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/v$c;", "", "", ScrollPosition.POSITION_LEFT, "I", "b", "()I", "setLeft", "(I)V", ScrollPosition.POSITION_TOP, "d", "setTop", ScrollPosition.POSITION_RIGHT, "c", "setRight", ScrollPosition.POSITION_BOTTOM, "a", "setBottom", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName(ScrollPosition.POSITION_BOTTOM)
        private int bottom;

        @SerializedName(ScrollPosition.POSITION_LEFT)
        private int left;

        @SerializedName(ScrollPosition.POSITION_RIGHT)
        private int right;

        @SerializedName(ScrollPosition.POSITION_TOP)
        private int top;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L14;
            c r4 = (c) r3;
            if (this.left == r4.left) goto L8;
            return false;
        L8:
            if (this.top == r4.top) goto L10;
            return false;
        L10:
            if (this.right == r4.right) goto L12;
            return false;
        L12:
            if (this.bottom == r4.bottom) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
        }

        public final String toString() {
            return "ShopLynxPadding(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
        }

        public c() {
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
        }

        public final int a() {
            return this.bottom;
        }

        public final int b() {
            return this.left;
        }

        public final int c() {
            return this.right;
        }

        public final int d() {
            return this.top;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/v$d;", "", "", "ssrData", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "hydrateData", "a", "hydrateUrl", "b", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "ssrDataDecodingFormat", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "getSsrDataDecodingFormat", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {
        public static final /* synthetic */ int a = 0;

        @SerializedName("hydrate_data")
        private final String hydrateData;

        @SerializedName("hydrate_url")
        private final String hydrateUrl;

        @SerializedName("ssr_data")
        private final String ssrData;

        @SerializedName("ssr_data_decoding_format")
        private final SSRDataDecodingFormat ssrDataDecodingFormat;

        public static final class a {
        }

        static {
        }

        public d() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L14;
            d r4 = (d) r3;
            if (Intrinsics.areEqual(this.ssrData, r4.ssrData) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.hydrateData, r4.hydrateData) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.hydrateUrl, r4.hydrateUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ssrDataDecodingFormat, r4.ssrDataDecodingFormat) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r0 = this.ssrData;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.hydrateData;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.hydrateUrl;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            SSRDataDecodingFormat r10 = this.ssrDataDecodingFormat;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
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

        public final String toString() {
            return "ShopLynxSsrVO(ssrData=" + this.ssrData + ", hydrateData=" + this.hydrateData + ", hydrateUrl=" + this.hydrateUrl + ", ssrDataDecodingFormat=" + this.ssrDataDecodingFormat + ")";
        }

        public final String a() {
            return this.hydrateData;
        }

        public final String b() {
            return this.hydrateUrl;
        }

        public final String c() {
            return this.ssrData;
        }

        public d(String r1, String r2, String r3, SSRDataDecodingFormat r4) {
            this.ssrData = r1;
            this.hydrateData = r2;
            this.hydrateUrl = r3;
            this.ssrDataDecodingFormat = r4;
        }
    }

    static {
    }

    public final boolean e() {
        if (com.bytedance.android.shopping.extensions.k.c(this.j) == false) goto L20;
        b r0 = this.k;
        if (r0 == null) goto L16;
        String r1 = r0.c();
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L16;
        boolean r3 = false;
    L17:
        if (r3 == false) goto L21;
        return true;
    L21:
        return false;
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
    L16:
        r3 = true;
        goto L17
    L20:
        return false;
    }

    public v(int r1) {
        super(r1);
        this.l = true;
    }
}
