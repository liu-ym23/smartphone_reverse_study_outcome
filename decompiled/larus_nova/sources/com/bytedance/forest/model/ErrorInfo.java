package com.bytedance.forest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f244212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f244213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f244214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f244215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f244216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f244217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f244218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f244219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f244220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f244221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f244222k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f244223l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f244224m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f244225n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f244226o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/forest/model/ErrorInfo$Type;", "", "Pipeline", "Memory", "Gecko", "Builtin", "CDN", "PostProcess", "CustomFetcher", "forest_release"}, k = 1, mv = {1, 4, 0})
    public static final enum Type extends Enum<Type> {
        public static final Type Builtin = null;
        public static final Type CDN = null;
        public static final Type CustomFetcher = null;
        public static final Type Gecko = null;
        public static final Type Memory = null;
        public static final Type Pipeline = null;
        public static final Type PostProcess = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f244227a = null;

        static {
            Type r100 = new Type("Pipeline", 0);
            Pipeline = r100;
            Type r101 = new Type("Memory", 1);
            Memory = r101;
            Type r102 = new Type("Gecko", 2);
            Gecko = r102;
            Type r103 = new Type("Builtin", 3);
            Builtin = r103;
            Type r104 = new Type("CDN", 4);
            CDN = r104;
            Type r105 = new Type("PostProcess", 5);
            PostProcess = r105;
            Type r106 = new Type("CustomFetcher", 6);
            CustomFetcher = r106;
            f244227a = new Type[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f244227a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ErrorInfo() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ErrorInfo) == false) goto L20;
        ErrorInfo r101 = (ErrorInfo) r100;
        if (Intrinsics.areEqual(this.f244220i, r101.f244220i) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f244221j, r101.f244221j) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f244222k, r101.f244222k) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f244223l, r101.f244223l) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f244224m, r101.f244224m) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f244225n, r101.f244225n) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f244226o, r101.f244226o) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f244220i;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f244221j;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f244222k;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f244223l;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f244224m;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f244225n;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f244226o;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        if ((!StringsKt.isBlank(this.f244224m)) == false) goto L5;
        String r100 = "pipelineError:" + this.f244224m + ' ';
    L7:
        if ((!StringsKt.isBlank(this.f244220i)) == false) goto L10;
        r100 = r100 + "memoryError:" + this.f244220i + ' ';
    L10:
        if ((!StringsKt.isBlank(this.f244221j)) == false) goto L13;
        r100 = r100 + "geckoError:" + this.f244221j + ' ';
    L13:
        if ((!StringsKt.isBlank(this.f244222k)) == false) goto L16;
        r100 = r100 + "builtinError:" + this.f244222k + ' ';
    L16:
        if ((!StringsKt.isBlank(this.f244223l)) == false) goto L19;
        r100 = r100 + "cdnError:" + this.f244223l + ' ';
    L19:
        if ((!StringsKt.isBlank(this.f244225n)) == false) goto L22;
        r100 = r100 + "postProcessError:" + this.f244225n;
    L22:
        if ((!StringsKt.isBlank(this.f244226o)) == true) goto L24;
        return r100;
    L24:
        return r100 + "customFetcherError:" + this.f244226o;
    L5:
        r100 = "";
        goto L7
    }

    public ErrorInfo(int r100) {
        this.f244220i = "";
        this.f244221j = "";
        this.f244222k = "";
        this.f244223l = "";
        this.f244224m = "";
        this.f244225n = "";
        this.f244226o = "";
        this.f244217f = "";
        this.f244219h = "";
    }

    public final void a(ErrorInfo r100, Type... r101) {
        this.f244212a = r100.f244212a;
        this.f244213b = r100.f244213b;
        this.f244216e = r100.f244216e;
        this.f244218g = r100.f244218g;
        this.f244214c = r100.f244214c;
        this.f244215d = r100.f244215d;
        this.f244220i = r100.f244220i;
        this.f244221j = r100.f244221j;
        this.f244217f = r100.f244217f;
        this.f244219h = r100.f244219h;
        this.f244222k = r100.f244222k;
        this.f244223l = r100.f244223l;
        this.f244225n = r100.f244224m;
        this.f244225n = r100.f244225n;
        this.f244226o = r100.f244226o;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r104 = b(r101[r103], 1, "");
        int r105 = this.f244212a;
        int r106 = r104 * 10;
        this.f244212a = ((r105 / r106) * r106) + (r105 % r104);
        r103 = r103 + 1;
        goto L3
    }

    public final int b(Type r100, int r101, String r102) {
        switch(g.f244336a[r100.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        this.f244224m = r102;
        return r101;
    L5:
        this.f244226o = r102;
        int r103 = 1000000;
    L14:
        return r101 * r103;
    L6:
        this.f244225n = r102;
        r103 = 100000;
        goto L14
    L8:
        this.f244223l = r102;
        return r101 * 10000;
    L9:
        this.f244222k = r102;
        return r101 * 1000;
    L10:
        this.f244213b = r101;
        this.f244221j = r102;
        return r101 * 100;
    L11:
        this.f244220i = r102;
        return r101 * 10;
    }

    public final void c(Type r100, int r101, String r102) {
        this.f244212a += b(r100, r101, r102);
    }
}
