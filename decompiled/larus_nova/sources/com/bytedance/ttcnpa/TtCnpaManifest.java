package com.bytedance.ttcnpa;

import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b2\u00103J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003JO\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001b\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001f¨\u00064"}, d2 = {"Lcom/bytedance/ttcnpa/TtCnpaManifest;", "", "Ltt_cnpa_sdk/proto/TtCnpaManifest;", "into", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "label", "contentProducer", "produceId", "reservedCode1", "contentPropagator", "propagateId", "reservedCode2", "copy", "toString", "", "hashCode", "other", "", "equals", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "b", "getContentProducer", "setContentProducer", "c", "getProduceId", "setProduceId", "d", "getReservedCode1", "setReservedCode1", "e", "getContentPropagator", "setContentPropagator", "f", "getPropagateId", "setPropagateId", ce.f26391f, "getReservedCode2", "setReservedCode2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
public final class TtCnpaManifest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f271045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f271046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f271047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f271048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f271049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f271050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f271051g;

    public static /* synthetic */ TtCnpaManifest copy$default(TtCnpaManifest r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.f271045a;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.f271046b;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.f271047c;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.f271048d;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.f271049e;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.f271050f;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.f271051g;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.f271045a;
    }

    public final String component2() {
        return this.f271046b;
    }

    public final String component3() {
        return this.f271047c;
    }

    public final String component4() {
        return this.f271048d;
    }

    public final String component5() {
        return this.f271049e;
    }

    public final String component6() {
        return this.f271050f;
    }

    public final String component7() {
        return this.f271051g;
    }

    public final TtCnpaManifest copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "label");
        Intrinsics.checkNotNullParameter(r111, "contentProducer");
        Intrinsics.checkNotNullParameter(r112, "produceId");
        Intrinsics.checkNotNullParameter(r113, "reservedCode1");
        Intrinsics.checkNotNullParameter(r114, "contentPropagator");
        Intrinsics.checkNotNullParameter(r115, "propagateId");
        Intrinsics.checkNotNullParameter(r116, "reservedCode2");
        return new TtCnpaManifest(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TtCnpaManifest) == true) goto L8;
        return false;
    L8:
        TtCnpaManifest r101 = (TtCnpaManifest) r100;
        if (Intrinsics.areEqual(this.f271045a, r101.f271045a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f271046b, r101.f271046b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f271047c, r101.f271047c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f271048d, r101.f271048d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f271049e, r101.f271049e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f271050f, r101.f271050f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f271051g, r101.f271051g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.f271045a.hashCode() * 31) + this.f271046b.hashCode()) * 31) + this.f271047c.hashCode()) * 31) + this.f271048d.hashCode()) * 31) + this.f271049e.hashCode()) * 31) + this.f271050f.hashCode()) * 31) + this.f271051g.hashCode();
    }

    public String toString() {
        return "TtCnpaManifest(label=" + this.f271045a + ", contentProducer=" + this.f271046b + ", produceId=" + this.f271047c + ", reservedCode1=" + this.f271048d + ", contentPropagator=" + this.f271049e + ", propagateId=" + this.f271050f + ", reservedCode2=" + this.f271051g + ')';
    }

    public final tt_cnpa_sdk.proto.TtCnpaManifest into() {
        return new tt_cnpa_sdk.proto.TtCnpaManifest(this.f271045a, this.f271046b, this.f271047c, this.f271048d, this.f271049e, this.f271050f, this.f271051g);
    }

    public final String getContentProducer() {
        return this.f271046b;
    }

    public final String getContentPropagator() {
        return this.f271049e;
    }

    public final String getLabel() {
        return this.f271045a;
    }

    public final String getProduceId() {
        return this.f271047c;
    }

    public final String getPropagateId() {
        return this.f271050f;
    }

    public final String getReservedCode1() {
        return this.f271048d;
    }

    public final String getReservedCode2() {
        return this.f271051g;
    }

    public final void setContentProducer(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271046b = r100;
    }

    public final void setContentPropagator(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271049e = r100;
    }

    public final void setLabel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271045a = r100;
    }

    public final void setProduceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271047c = r100;
    }

    public final void setPropagateId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271050f = r100;
    }

    public final void setReservedCode1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271048d = r100;
    }

    public final void setReservedCode2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271051g = r100;
    }

    public TtCnpaManifest(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "contentProducer");
        Intrinsics.checkNotNullParameter(r102, "produceId");
        Intrinsics.checkNotNullParameter(r103, "reservedCode1");
        Intrinsics.checkNotNullParameter(r104, "contentPropagator");
        Intrinsics.checkNotNullParameter(r105, "propagateId");
        Intrinsics.checkNotNullParameter(r106, "reservedCode2");
        this.f271045a = r100;
        this.f271046b = r101;
        this.f271047c = r102;
        this.f271048d = r103;
        this.f271049e = r104;
        this.f271050f = r105;
        this.f271051g = r106;
    }
}
