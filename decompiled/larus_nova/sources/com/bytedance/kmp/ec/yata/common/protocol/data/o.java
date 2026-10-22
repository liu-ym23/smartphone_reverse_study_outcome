package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/o;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/m;", "", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/g;", "success", "Ljava/util/List;", "b", "()Ljava/util/List;", "failed", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class o implements m<o> {

    @SerializedName("failed")
    private final List<g> failed;

    @SerializedName("success")
    private final List<g> success;

    public o() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.success, r101.success) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.failed, r101.failed) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<g> r100 = this.success;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<g> r104 = this.failed;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Next(success=" + this.success + ", failed=" + this.failed + ')';
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final Map<String, Object> f() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Pair[] r100 = new Pair[2];
        List<g> r101 = b();
        ArrayList r102 = null;
        if (r101 == null) goto L12;
        List<g> r103 = r101;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L13;
        g r106 = (g) r105.next();
        if (r106 == null) goto L10;
        Map<String, Object> r107 = r106.f();
    L11:
        r104.add(r107);
        goto L6
    L10:
        r107 = null;
    L13:
        r100[0] = TuplesKt.to("success", r104);
        List<g> r108 = a();
        if (r108 == null) goto L24;
        List<g> r109 = r108;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r111 = r109.iterator();
    L17:
        if (r111.hasNext() == false) goto L23;
        g r112 = (g) r111.next();
        if (r112 == null) goto L21;
        Map<String, Object> r113 = r112.f();
    L22:
        r110.add(r113);
        goto L17
    L21:
        r113 = null;
        goto L22
    L23:
        r102 = r110;
    L24:
        r100[1] = TuplesKt.to("failed", r102);
        return MapsKt.mapOf(r100);
    L12:
        r104 = null;
        goto L13
    }

    public final List<g> a() {
        return this.failed;
    }

    public final List<g> b() {
        return this.success;
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final o d(int r100) {
        return new o(this.success, this.failed);
    }

    public o(List<g> r100, List<g> r101) {
        this.success = r100;
        this.failed = r101;
    }
}
