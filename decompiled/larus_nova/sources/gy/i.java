package gy;

import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f483315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f483316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f483317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MultiChannelInfo f483318d;

    public i() {
        this(null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (this.f483315a == r101.f483315a) goto L8;
        return false;
    L8:
        if (this.f483316b == r101.f483316b) goto L10;
        return false;
    L10:
        if (this.f483317c == r101.f483317c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483318d, r101.f483318d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f483315a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f483316b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f483317c;
        if (r107 == true) goto L12;
        r101 = r107;
    L12:
        int r108 = (r106 + r101) * 31;
        MultiChannelInfo r109 = this.f483318d;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L17:
        return r108 + r110;
    L15:
        r110 = 0;
        goto L17
    }

    public final String toString() {
        return "StartEngineParams(needPushStream=" + this.f483315a + ", enableAllRemoteRender=" + this.f483316b + ", startForwardStream=" + this.f483317c + ", multiChannelInfo=" + this.f483318d + ")";
    }

    public i(MultiChannelInfo r100, int r101) {
        boolean r102 = false;
        if ((r101 & 1) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r101 & 2) == 0) goto L9;
        boolean r104 = true;
    L11:
        if ((r101 & 4) == 0) goto L14;
        r102 = true;
    L14:
        if ((r101 & 8) == 0) goto L16;
        r100 = null;
    L16:
        this.f483315a = r103;
        this.f483316b = r104;
        this.f483317c = r102;
        this.f483318d = r100;
        return;
    L9:
        r104 = false;
        goto L11
    L5:
        r103 = false;
        goto L7
    }
}
