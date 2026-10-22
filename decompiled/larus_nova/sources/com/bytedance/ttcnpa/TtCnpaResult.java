package com.bytedance.ttcnpa;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\u0006HÆ\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!¨\u0006-"}, d2 = {"Lcom/bytedance/ttcnpa/TtCnpaResult;", "", "Ltt_cnpa_sdk/proto/TtCnpaResult;", "into", "", "component1", "", "component2", "Lcom/bytedance/ttcnpa/TtCnpaManifest;", "component3", "component4", "errorCode", "errorDesc", "resultManifest", "rawJsonManifest", "copy", "toString", "", "hashCode", "other", "", "equals", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "J", "getErrorCode", "()J", "setErrorCode", "(J)V", "b", "Ljava/lang/String;", "getErrorDesc", "()Ljava/lang/String;", "setErrorDesc", "(Ljava/lang/String;)V", "c", "Lcom/bytedance/ttcnpa/TtCnpaManifest;", "getResultManifest", "()Lcom/bytedance/ttcnpa/TtCnpaManifest;", "setResultManifest", "(Lcom/bytedance/ttcnpa/TtCnpaManifest;)V", "d", "getRawJsonManifest", "setRawJsonManifest", "<init>", "(JLjava/lang/String;Lcom/bytedance/ttcnpa/TtCnpaManifest;Ljava/lang/String;)V", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
public final class TtCnpaResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f271052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f271053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TtCnpaManifest f271054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f271055d;

    public static /* synthetic */ TtCnpaResult copy$default(TtCnpaResult r100, long r101, String r102, TtCnpaManifest r110, String r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f271052a;
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f271053b;
    L8:
        String r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.f271054c;
    L11:
        TtCnpaManifest r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = r100.f271055d;
    L15:
        return r100.copy(r103, r104, r105, r111);
    }

    public final long component1() {
        return this.f271052a;
    }

    public final String component2() {
        return this.f271053b;
    }

    public final TtCnpaManifest component3() {
        return this.f271054c;
    }

    public final String component4() {
        return this.f271055d;
    }

    public final TtCnpaResult copy(long r100, String r110, TtCnpaManifest r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "errorDesc");
        Intrinsics.checkNotNullParameter(r111, "resultManifest");
        Intrinsics.checkNotNullParameter(r112, "rawJsonManifest");
        return new TtCnpaResult(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TtCnpaResult) == true) goto L8;
        return false;
    L8:
        TtCnpaResult r101 = (TtCnpaResult) r100;
        if (this.f271052a == r101.f271052a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f271053b, r101.f271053b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f271054c, r101.f271054c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f271055d, r101.f271055d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.f271052a;
        return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f271053b.hashCode()) * 31) + this.f271054c.hashCode()) * 31) + this.f271055d.hashCode();
    }

    public String toString() {
        return "TtCnpaResult(errorCode=" + this.f271052a + ", errorDesc=" + this.f271053b + ", resultManifest=" + this.f271054c + ", rawJsonManifest=" + this.f271055d + ')';
    }

    public final tt_cnpa_sdk.proto.TtCnpaResult into() {
        return new tt_cnpa_sdk.proto.TtCnpaResult(Long.valueOf(this.f271052a), this.f271053b, this.f271054c.into(), this.f271055d);
    }

    public final long getErrorCode() {
        return this.f271052a;
    }

    public final String getErrorDesc() {
        return this.f271053b;
    }

    public final String getRawJsonManifest() {
        return this.f271055d;
    }

    public final TtCnpaManifest getResultManifest() {
        return this.f271054c;
    }

    public final void setErrorCode(long r100) {
        this.f271052a = r100;
    }

    public final void setErrorDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271053b = r100;
    }

    public final void setRawJsonManifest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271055d = r100;
    }

    public final void setResultManifest(TtCnpaManifest r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271054c = r100;
    }

    public TtCnpaResult(long r100, String r101, TtCnpaManifest r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "errorDesc");
        Intrinsics.checkNotNullParameter(r102, "resultManifest");
        Intrinsics.checkNotNullParameter(r103, "rawJsonManifest");
        this.f271052a = r100;
        this.f271053b = r101;
        this.f271054c = r102;
        this.f271055d = r103;
    }
}
