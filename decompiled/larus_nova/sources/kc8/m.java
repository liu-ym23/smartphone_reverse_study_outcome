package kc8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ComplexTaskBlock;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f502525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f502526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Message, ComplexTaskBlock, Unit> f502527c;

    public m() {
        this(false, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f502525a == r101.f502525a) goto L12;
        return false;
    L12:
        if (this.f502526b == r101.f502526b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502527c, r101.f502527c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f502525a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f502526b;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Function2<Message, ComplexTaskBlock, Unit> r103 = this.f502527c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ComplexTaskBlockConfig(useCapsuleStyle=" + this.f502525a + ", timeoutMs=" + this.f502526b + ", onClickBlock=" + this.f502527c + ')';
    }

    public m(boolean r100, Function2 r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        this.f502525a = r100;
        this.f502526b = 0;
        this.f502527c = r101;
    }
}
