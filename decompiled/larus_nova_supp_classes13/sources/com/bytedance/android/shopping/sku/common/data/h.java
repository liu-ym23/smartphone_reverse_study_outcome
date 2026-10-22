package com.bytedance.android.shopping.sku.common.data;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/data/h;", "", "", "Lcom/bytedance/android/shopping/sku/common/data/Spec;", "specs", "Ljava/util/List;", "g", "()Ljava/util/List;", "", "", "Lcom/bytedance/android/shopping/sku/common/data/SpecState;", "specsState", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "Lcom/bytedance/android/shopping/sku/common/data/i;", "specItemsState", "f", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    @SerializedName("spec_items_state")
    private final Map<String, i> specItemsState;

    @SerializedName("specs")
    private final List<Spec> specs;

    @SerializedName("specs_state")
    private final Map<String, SpecState> specsState;

    public h() {
        List<Spec> r0 = CollectionsKt.emptyList();
        Map<String, SpecState> r1 = MapsKt.emptyMap();
        Map<String, i> r2 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r0, "specs");
        Intrinsics.checkNotNullParameter(r1, "specsState");
        Intrinsics.checkNotNullParameter(r2, "specItemsState");
        this.specs = r0;
        this.specsState = r1;
        this.specItemsState = r2;
        this.a = LazyKt.lazy(new SkuYataSpecFieldVO$nextSkuId$2(this));
        this.b = LazyKt.lazy(new SkuYataSpecFieldVO$nextSpecsContent$2(this));
        this.c = LazyKt.lazy(new SkuYataSpecFieldVO$nextSpecsContentOpt$2(this));
        this.d = LazyKt.lazy(new SkuYataSpecFieldVO$nextPicSpecItemId$2(this));
        this.e = LazyKt.lazy(new SkuYataSpecFieldVO$nextPossibleHeadImg$2(this));
    }

    public final Map<String, i> f() {
        return this.specItemsState;
    }

    public final List<Spec> g() {
        return this.specs;
    }

    public final Map<String, SpecState> h() {
        return this.specsState;
    }

    public static final String a(h r7) {
        r7.getClass();
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r1 = r7.specs.iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L25;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        SpecState r6 = r7.specsState.get(((Spec) r4).getSpecIndex());
        if (r6 == null) goto L11;
        String r8 = r6.getSelectedSpecItemId();
    L12:
        if (r3 == 0) goto L14;
        r0.append("_");
    L14:
        if (r8 != null) goto L16;
    L19:
        boolean r9 = true;
    L20:
        if (r9 == false) goto L22;
        r0.append("null");
    L23:
        r3 = r5;
        goto L4
    L22:
        r0.append(r8.toString());
        goto L23
    L16:
        if (StringsKt.isBlank(r8) == true) goto L19;
        r9 = false;
        goto L20
    L11:
        r8 = null;
        goto L12
    L25:
        return r0.toString();
    }

    public static final String b(h r4) {
        Iterator<T> r0 = r4.specs.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Spec r1 = (Spec) r0.next();
        Boolean r2 = r1.getCanShowBigPic();
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == true) goto L9;
        if (Intrinsics.areEqual(r1.getCanShowSmallPic(), r3) == false) goto L4;
    L9:
        SpecState r5 = r4.specsState.get(r1.getSpecIndex());
        if (r5 == null) goto L13;
        String r6 = r5.getSelectedSpecItemId();
        if (r6 == null) goto L13;
        return r6;
    L13:
        return "";
    }

    public static final String c(h r6) {
        Spec r0 = (Spec) CollectionsKt.firstOrNull(r6.specs);
        if (r0 == null) goto L22;
        List<SpecItem> r1 = r0.getSpecItemList();
        if (r1 == null) goto L22;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L20;
        Object r3 = r2.next();
        String r4 = ((SpecItem) r3).getSpecItemId();
        Map<String, SpecState> r5 = r6.specsState;
        Spec r7 = (Spec) CollectionsKt.firstOrNull(r6.specs);
        if (r7 == null) goto L12;
        String r8 = r7.getSpecIndex();
    L13:
        SpecState r9 = r5.get(r8);
        if (r9 == null) goto L16;
        String r10 = r9.getSelectedSpecItemId();
    L18:
        if (Intrinsics.areEqual(r4, r10) == false) goto L8;
    L21:
        SpecItem r11 = (SpecItem) r3;
    L23:
        if (r11 == null) goto L25;
        String r12 = r11.getBigPic();
    L26:
        boolean r13 = true;
        if (r12 != null) goto L29;
    L32:
        boolean r14 = true;
    L33:
        if (r14 == true) goto L36;
        if (r11 != null) goto L53;
        return null;
    L53:
        return r11.getBigPic();
    L36:
        if (r11 == null) goto L38;
        String r15 = r11.getSmallPic();
    L39:
        if (r15 != null) goto L41;
    L44:
        if (r13 == true) goto L47;
        if (r11 != null) goto L55;
        return null;
    L55:
        return r11.getSmallPic();
    L47:
        return "";
    L41:
        if (StringsKt.isBlank(r15) == true) goto L44;
        r13 = false;
        goto L44
    L38:
        r15 = null;
        goto L39
    L29:
        if (StringsKt.isBlank(r12) == true) goto L32;
        r14 = false;
        goto L33
    L25:
        r12 = null;
        goto L26
    L16:
        r10 = null;
        goto L18
    L12:
        r8 = null;
        goto L13
    L20:
        r3 = null;
    L22:
        r11 = null;
        goto L23
    }

    public static final String d(h r12) {
        r12.getClass();
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = new StringBuilder();
        Iterator<T> r2 = r12.specs.iterator();
        boolean r4 = false;
    L4:
        if (r2.hasNext() == false) goto L31;
        Spec r5 = (Spec) r2.next();
        SpecState r6 = r12.specsState.get(r5.getSpecIndex());
        Object r7 = null;
        if (r6 == null) goto L8;
        String r8 = r6.getSelectedSpecItemId();
    L10:
        if (r8 != null) goto L12;
    L15:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L30;
        Iterator<T> r10 = r5.getSpecItemList().iterator();
    L20:
        if (r10.hasNext() == false) goto L24;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((SpecItem) r11).getSpecItemId(), r8) == false) goto L20;
        r7 = r11;
    L24:
        SpecItem r13 = (SpecItem) r7;
        if (r13 == null) goto L28;
        String r14 = r13.getName();
        if (r14 == null) goto L28;
    L29:
        r1.append(" ".concat(r14));
        r4 = true;
    L28:
        r14 = "";
    L30:
        r0.append(" " + r5.getName());
        goto L4
    L12:
        if (StringsKt.isBlank(r8) == true) goto L15;
        r9 = false;
        goto L17
    L8:
        r8 = null;
        goto L10
    L31:
        StringBuilder r15 = new StringBuilder();
        if (r4 == false) goto L34;
        String r3 = "已选择";
    L35:
        r15.append(r3);
        if (r4 == false) goto L38;
        r0 = r1;
    L38:
        r15.append(r0);
        return r15.toString();
    L34:
        r3 = "请选择";
        goto L35
    }

    public static final String e(h r12) {
        r12.getClass();
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = new StringBuilder();
        Iterator<T> r2 = r12.specs.iterator();
        boolean r4 = false;
    L4:
        if (r2.hasNext() == false) goto L31;
        Spec r5 = (Spec) r2.next();
        SpecState r6 = r12.specsState.get(r5.getSpecIndex());
        Object r7 = null;
        if (r6 == null) goto L8;
        String r8 = r6.getSelectedSpecItemId();
    L10:
        if (r8 != null) goto L12;
    L15:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L30;
        Iterator<T> r10 = r5.getSpecItemList().iterator();
    L20:
        if (r10.hasNext() == false) goto L24;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((SpecItem) r11).getSpecItemId(), r8) == false) goto L20;
        r7 = r11;
    L24:
        SpecItem r13 = (SpecItem) r7;
        if (r13 == null) goto L28;
        String r14 = r13.getName();
        if (r14 == null) goto L28;
    L29:
        r1.append(" ".concat(r14));
        r4 = true;
    L28:
        r14 = "";
    L30:
        r0.append(" " + r5.getName());
        goto L4
    L12:
        if (StringsKt.isBlank(r8) == true) goto L15;
        r9 = false;
        goto L17
    L8:
        r8 = null;
        goto L10
    L31:
        StringBuilder r15 = new StringBuilder();
        if (r4 == false) goto L34;
        String r3 = "已选";
    L35:
        r15.append(r3);
        if (r4 == false) goto L38;
        r0 = r1;
    L38:
        r15.append(r0);
        return r15.toString();
    L34:
        r3 = "请选";
        goto L35
    }
}
