package com.bytedance.ies.argus.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f246060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f246061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f246062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f246063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f246064f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/bean/x$a;", "", "", "expr", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "exprMd5", "c", "byteCodeMd5", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("b_md5")
        private final String byteCodeMd5;

        @SerializedName("expr")
        private final String expr;

        @SerializedName("expr_md5")
        private final String exprMd5;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.expr, r101.expr) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.exprMd5, r101.exprMd5) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.byteCodeMd5, r101.byteCodeMd5) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.expr;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.exprMd5;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.byteCodeMd5;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "StrategyRuleInfo(expr=" + this.expr + ", exprMd5=" + this.exprMd5 + ", byteCodeMd5=" + this.byteCodeMd5 + ')';
        }

        public a() {
            this.expr = null;
            this.exprMd5 = null;
            this.byteCodeMd5 = null;
        }

        public final String a() {
            return this.byteCodeMd5;
        }

        public final String b() {
            return this.expr;
        }

        public final String c() {
            return this.exprMd5;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f246059a, r101.f246059a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246060b, r101.f246060b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f246061c, r101.f246061c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f246062d, r101.f246062d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f246063e, r101.f246063e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f246059a.hashCode() * 31) + this.f246060b.hashCode()) * 31;
        String r101 = this.f246061c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f246062d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f246063e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "key=" + this.f246059a + ", ver=" + this.f246060b + ", exprMd5=" + this.f246062d + ", bMd5=" + this.f246063e;
    }

    public x(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "version");
        this.f246059a = r100;
        this.f246060b = r101;
        this.f246061c = r102;
        this.f246062d = r103;
        this.f246063e = r104;
    }
}
