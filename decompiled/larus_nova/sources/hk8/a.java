package hk8;

import com.larus.im.bean.message.Message;
import kc8.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f485587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f485588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f485589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f485590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f485591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f485592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f485593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f485594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f485595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f485596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f485597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f485598l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Boolean> f485599m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f485600n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Boolean f485601o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f485587a, r101.f485587a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f485588b, r101.f485588b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f485589c, r101.f485589c) == true) goto L18;
        return false;
    L18:
        if (this.f485590d == r101.f485590d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f485591e, r101.f485591e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f485592f, r101.f485592f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f485593g, r101.f485593g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f485594h, r101.f485594h) == true) goto L33;
        return false;
    L33:
        if (this.f485595i == r101.f485595i) goto L36;
        return false;
    L36:
        if (this.f485596j == r101.f485596j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f485597k, r101.f485597k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f485598l, r101.f485598l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f485599m, r101.f485599m) == true) goto L48;
        return false;
    L48:
        if (this.f485600n == r101.f485600n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f485601o, r101.f485601o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f485587a.hashCode() * 31) + this.f485588b.hashCode()) * 31;
        y r101 = this.f485589c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((((((((r100 + r103) * 31) + this.f485590d) * 31) + this.f485591e.hashCode()) * 31) + this.f485592f.hashCode()) * 31) + this.f485593g.hashCode()) * 31) + this.f485594h.hashCode()) * 31) + this.f485595i) * 31;
        int r105 = 1231;
        if (this.f485596j == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f485597k.hashCode()) * 31) + this.f485598l.hashCode()) * 31;
        Function0<Boolean> r108 = this.f485599m;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f485600n == true) goto L18;
        r105 = 1237;
    L18:
        int r111 = (r110 + r105) * 31;
        Boolean r112 = this.f485601o;
        if (r112 == null) goto L23;
        r102 = r112.hashCode();
    L23:
        return r111 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ComputerUseToolResultVMData(dataIdentifier=" + this.f485587a + ", message=" + this.f485588b + ", globalConfig=" + this.f485589c + ", startIndex=" + this.f485590d + ", title=" + this.f485591e + ", content=" + this.f485592f + ", imageUri=" + this.f485593g + ", imageUrl=" + this.f485594h + ", status=" + this.f485595i + ", isDeepThinkArea=" + this.f485596j + ", leftDarkIcon=" + this.f485597k + ", leftLightIcon=" + this.f485598l + ", interceptClickCard=" + this.f485599m + ", disableFoldExpandClick=" + this.f485600n + ", initialFoldState=" + this.f485601o + ')';
    }

    public a(String r110, Message r111, y r112, int r113, String r114, String r115, String r116, String r117, int r118, boolean r210, String r211, String r212, fk8.c r213, boolean r214, Boolean r215) {
        Intrinsics.checkNotNullParameter(r110, "dataIdentifier");
        Intrinsics.checkNotNullParameter(r111, "message");
        Intrinsics.checkNotNullParameter(r114, "title");
        Intrinsics.checkNotNullParameter(r115, "content");
        Intrinsics.checkNotNullParameter(r116, "imageUri");
        Intrinsics.checkNotNullParameter(r117, "imageUrl");
        Intrinsics.checkNotNullParameter(r211, "leftDarkIcon");
        Intrinsics.checkNotNullParameter(r212, "leftLightIcon");
        this.f485587a = r110;
        this.f485588b = r111;
        this.f485589c = r112;
        this.f485590d = r113;
        this.f485591e = r114;
        this.f485592f = r115;
        this.f485593g = r116;
        this.f485594h = r117;
        this.f485595i = r118;
        this.f485596j = r210;
        this.f485597k = r211;
        this.f485598l = r212;
        this.f485599m = r213;
        this.f485600n = r214;
        this.f485601o = r215;
    }
}
