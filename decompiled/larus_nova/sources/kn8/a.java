package kn8;

import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f504261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f504262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f504263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f504264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f504265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SearchReferenceData f504266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f504267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f504268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f504269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f504270j;

    public a() {
        this(0, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f504261a == r101.f504261a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f504262b, r101.f504262b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f504263c, r101.f504263c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f504264d, r101.f504264d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f504265e, r101.f504265e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f504266f, r101.f504266f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f504267g, r101.f504267g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f504268h, r101.f504268h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f504269i, r101.f504269i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f504270j, r101.f504270j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f504261a * 31;
        Message r101 = this.f504262b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f504263c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f504264d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Function0<Boolean> r111 = this.f504265e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        SearchReferenceData r114 = this.f504266f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f504267g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Boolean r120 = this.f504268h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Boolean r123 = this.f504269i;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Boolean r126 = this.f504270j;
        if (r126 == null) goto L39;
        r102 = r126.hashCode();
    L39:
        return r125 + r102;
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchCotVMData(maxWidth=" + this.f504261a + ", message=" + this.f504262b + ", chatType=" + this.f504263c + ", cardPosition=" + this.f504264d + ", interceptClickCard=" + this.f504265e + ", searchReferenceData=" + this.f504266f + ", backGroundDrawableRes=" + this.f504267g + ", disableFoldExpandClick=" + this.f504268h + ", initialFoldState=" + this.f504269i + ", directRendFirstFrame=" + this.f504270j + ')';
    }

    public a(int r100, Message r101, String r102, Integer r103, Function0<Boolean> r104, SearchReferenceData r105, Integer r106, Boolean r107, Boolean r108, Boolean r110) {
        this.f504261a = r100;
        this.f504262b = r101;
        this.f504263c = r102;
        this.f504264d = r103;
        this.f504265e = r104;
        this.f504266f = r105;
        this.f504267g = r106;
        this.f504268h = r107;
        this.f504269i = r108;
        this.f504270j = r110;
    }
}
