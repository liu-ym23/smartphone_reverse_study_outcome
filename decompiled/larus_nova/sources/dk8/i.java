package dk8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ComplexTaskBlock;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pair<Integer, Integer> f469035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f469036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ComplexTaskBlock f469037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f469038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f469039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f469040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f469041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f469042h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f469035a, r101.f469035a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f469036b, r101.f469036b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f469037c, r101.f469037c) == true) goto L18;
        return false;
    L18:
        if (this.f469038d == r101.f469038d) goto L21;
        return false;
    L21:
        if (this.f469039e == r101.f469039e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f469040f, r101.f469040f) == true) goto L27;
        return false;
    L27:
        if (this.f469041g == r101.f469041g) goto L30;
        return false;
    L30:
        if (this.f469042h == r101.f469042h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Pair<Integer, Integer> r100 = this.f469035a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Message r104 = this.f469036b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ComplexTaskBlock r107 = this.f469037c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.f469038d == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f469039e) * 31;
        Integer r113 = this.f469040f;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.f469041g == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f469042h == true) goto L31;
        r110 = 1237;
    L31:
        return r116 + r110;
    L25:
        r115 = 1237;
        goto L26
    L17:
        r111 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ComplexTaskVMData(topAndBottomMarginPair=" + this.f469035a + ", message=" + this.f469036b + ", complexTaskBlock=" + this.f469037c + ", isInterrupted=" + this.f469038d + ", cardPosition=" + this.f469039e + ", backgroundRes=" + this.f469040f + ", showArrow=" + this.f469041g + ", enableClick=" + this.f469042h + ')';
    }

    public i(Pair<Integer, Integer> r100, Message r101, ComplexTaskBlock r102, boolean r103, int r104, Integer r105, boolean r106, boolean r107) {
        this.f469035a = r100;
        this.f469036b = r101;
        this.f469037c = r102;
        this.f469038d = r103;
        this.f469039e = r104;
        this.f469040f = r105;
        this.f469041g = r106;
        this.f469042h = r107;
    }
}
