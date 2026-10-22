package kl8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.GenericToolBlock;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pair<Integer, Integer> f503855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f503856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GenericToolBlock f503857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f503858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f503859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f503860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f503861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f503862h;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f503855a, r101.f503855a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503856b, r101.f503856b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f503857c, r101.f503857c) == true) goto L18;
        return false;
    L18:
        if (this.f503858d == r101.f503858d) goto L21;
        return false;
    L21:
        if (this.f503859e == r101.f503859e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f503860f, r101.f503860f) == true) goto L27;
        return false;
    L27:
        if (this.f503861g == r101.f503861g) goto L30;
        return false;
    L30:
        if (this.f503862h == r101.f503862h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Pair<Integer, Integer> r100 = this.f503855a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Message r104 = this.f503856b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        GenericToolBlock r107 = this.f503857c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.f503858d == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f503859e) * 31;
        Integer r113 = this.f503860f;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.f503861g == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f503862h == true) goto L31;
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
        return "GenericToolVMData(topAndBottomMarginPair=" + this.f503855a + ", message=" + this.f503856b + ", genericToolBlock=" + this.f503857c + ", isFinish=" + this.f503858d + ", cardPosition=" + this.f503859e + ", backgroundRes=" + this.f503860f + ", showArrow=" + this.f503861g + ", enableClick=" + this.f503862h + ')';
    }

    public a(Pair r100, Message r101, GenericToolBlock r102, boolean r103, int r104, Integer r105) {
        this.f503855a = r100;
        this.f503856b = r101;
        this.f503857c = r102;
        this.f503858d = r103;
        this.f503859e = r104;
        this.f503860f = r105;
        this.f503861g = false;
        this.f503862h = false;
    }
}
