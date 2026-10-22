package dk8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ComplexTaskBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f469027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComplexTaskBlock f469028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f469029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f469030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f469031e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f469027a, r101.f469027a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f469028b, r101.f469028b) == true) goto L15;
        return false;
    L15:
        if (this.f469029c == r101.f469029c) goto L18;
        return false;
    L18:
        if (this.f469030d == r101.f469030d) goto L21;
        return false;
    L21:
        if (this.f469031e == r101.f469031e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f469027a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ComplexTaskBlock r104 = this.f469028b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.f469029c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f469030d == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f469031e == true) goto L23;
        r106 = 1237;
    L23:
        return r110 + r106;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ComplexTaskNormalVMData(message=" + this.f469027a + ", complexTaskBlock=" + this.f469028b + ", isInterrupted=" + this.f469029c + ", showArrow=" + this.f469030d + ", enableClick=" + this.f469031e + ')';
    }

    public e(Message r100, ComplexTaskBlock r101, boolean r102, boolean r103, boolean r104) {
        this.f469027a = r100;
        this.f469028b = r101;
        this.f469029c = r102;
        this.f469030d = r103;
        this.f469031e = r104;
    }
}
