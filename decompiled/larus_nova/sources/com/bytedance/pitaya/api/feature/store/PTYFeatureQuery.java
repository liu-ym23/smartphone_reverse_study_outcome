package com.bytedance.pitaya.api.feature.store;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureQuery;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "returnFeatureName", "", "featureName", "subFeatureName", OfficeSDKRequestTag.KEY_NEW_USER, "", "queryType", "returnType", "extParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;)V", "getExtParams", "()Ljava/lang/String;", "getFeatureName", "getN", "()I", "getQueryType", "getReturnFeatureName", "getReturnType", "getSubFeatureName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYFeatureQuery implements ReflectionCall {
    private final String extParams;
    private final String featureName;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f266545n;
    private final int queryType;
    private final String returnFeatureName;
    private final int returnType;
    private final String subFeatureName;

    public static /* synthetic */ PTYFeatureQuery copy$default(PTYFeatureQuery r100, String r101, String r102, String r103, int r104, int r110, int r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.returnFeatureName;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.featureName;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.subFeatureName;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.f266545n;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.queryType;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.returnType;
    L20:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.extParams;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.returnFeatureName;
    }

    public final String component2() {
        return this.featureName;
    }

    public final String component3() {
        return this.subFeatureName;
    }

    public final int component4() {
        return this.f266545n;
    }

    public final int component5() {
        return this.queryType;
    }

    public final int component6() {
        return this.returnType;
    }

    public final String component7() {
        return this.extParams;
    }

    public final PTYFeatureQuery copy(String r110, String r111, String r112, int r113, int r114, int r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "returnFeatureName");
        Intrinsics.checkNotNullParameter(r111, "featureName");
        return new PTYFeatureQuery(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYFeatureQuery) == true) goto L8;
        return false;
    L8:
        PTYFeatureQuery r101 = (PTYFeatureQuery) r100;
        if (Intrinsics.areEqual(this.returnFeatureName, r101.returnFeatureName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.featureName, r101.featureName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subFeatureName, r101.subFeatureName) == true) goto L18;
        return false;
    L18:
        if (this.f266545n == r101.f266545n) goto L21;
        return false;
    L21:
        if (this.queryType == r101.queryType) goto L24;
        return false;
    L24:
        if (this.returnType == r101.returnType) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extParams, r101.extParams) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.returnFeatureName.hashCode() * 31) + this.featureName.hashCode()) * 31;
        String r101 = this.subFeatureName;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((r100 + r103) * 31) + this.f266545n) * 31) + this.queryType) * 31) + this.returnType) * 31;
        String r105 = this.extParams;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PTYFeatureQuery(returnFeatureName=" + this.returnFeatureName + ", featureName=" + this.featureName + ", subFeatureName=" + this.subFeatureName + ", n=" + this.f266545n + ", queryType=" + this.queryType + ", returnType=" + this.returnType + ", extParams=" + this.extParams + ')';
    }

    public final String getExtParams() {
        return this.extParams;
    }

    public final String getFeatureName() {
        return this.featureName;
    }

    public final int getN() {
        return this.f266545n;
    }

    public final int getQueryType() {
        return this.queryType;
    }

    public final String getReturnFeatureName() {
        return this.returnFeatureName;
    }

    public final int getReturnType() {
        return this.returnType;
    }

    public final String getSubFeatureName() {
        return this.subFeatureName;
    }

    public PTYFeatureQuery(String r100, String r101, String r102, int r103, int r104, int r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "returnFeatureName");
        Intrinsics.checkNotNullParameter(r101, "featureName");
        this.returnFeatureName = r100;
        this.featureName = r101;
        this.subFeatureName = r102;
        this.f266545n = r103;
        this.queryType = r104;
        this.returnType = r105;
        this.extParams = r106;
    }

    public /* synthetic */ PTYFeatureQuery(String r110, String r111, String r112, int r113, int r114, int r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r117 & 8) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r117 & 64) == 0) goto L13;
        String r102 = null;
    L14:
        this(r110, r111, r100, r101, r114, r115, r102);
        return;
    L13:
        r102 = r116;
        goto L14
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
