package hda;

import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MemoryDataReviewModuleKey f484730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f484732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f484733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f484734e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (this.f484730a == r101.f484730a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484731b, r101.f484731b) == true) goto L15;
        return false;
    L15:
        if (this.f484732c == r101.f484732c) goto L18;
        return false;
    L18:
        if (this.f484733d == r101.f484733d) goto L21;
        return false;
    L21:
        if (this.f484734e == r101.f484734e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f484730a.hashCode() * 31;
        String r101 = this.f484731b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f484732c) * 31;
        long r104 = this.f484733d;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f484734e;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewPageRequestDto(module=" + this.f484730a + ", pageCursor=" + this.f484731b + ", pageSize=" + this.f484732c + ", observeFromTimeMillis=" + this.f484733d + ", windowEndTimeMillis=" + this.f484734e + ')';
    }

    public n0(MemoryDataReviewModuleKey r100, String r101, long r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        this.f484730a = r100;
        this.f484731b = r101;
        this.f484732c = 10;
        this.f484733d = r102;
        this.f484734e = r103;
    }
}
