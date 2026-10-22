package gz5;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f483407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f483408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f483409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<f> f483410e;

    public x() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L16;
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f483406a, r101.f483406a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f483407b, r101.f483407b) == true) goto L10;
        return false;
    L10:
        if (this.f483408c == r101.f483408c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483409d, r101.f483409d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f483410e, r101.f483410e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        String r100 = this.f483406a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.f483407b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f483408c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        List<Integer> r110 = this.f483409d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        List<f> r113 = this.f483410e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SceneRuleInfo(name=" + this.f483406a + ", blockApiIds=" + this.f483407b + ", enabled=" + this.f483408c + ", monitorApiIds=" + this.f483409d + ", apiConfig=" + this.f483410e + ")";
    }

    public x(String r100, List r101, List r102, List r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        if ((r104 & 8) == 0) goto L9;
        r102 = CollectionsKt.emptyList();
    L9:
        if ((r104 & 16) == 0) goto L11;
        r103 = new ArrayList();
    L11:
        this.f483406a = r100;
        this.f483407b = r101;
        this.f483408c = false;
        this.f483409d = r102;
        this.f483410e = r103;
    }
}
