package nh0;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f519113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f519114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f519115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f519116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Integer> f519117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Integer> f519118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Long> f519119h;

    public e() {
        this(0, 0, null, 0, 0, null, null, null, 255);
    }

    public final String toString() {
        return "LinkmicDynamicLinkmicChangeEvent(scene=" + this.f519112a + ", uiLayout=" + this.f519113b + ", playmode=" + this.f519114c + ", fromScene=" + this.f519115d + ", fromUILayout=" + this.f519116e + ", fromPlayMode=" + this.f519117f + ')';
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof e) == true) goto L5;
        return false;
    L5:
        e r101 = (e) r100;
        if (r101.f519112a == this.f519112a) goto L8;
    L13:
        return false;
    L8:
        if (Intrinsics.areEqual(r101.f519114c, this.f519114c) == false) goto L13;
        if (r101.f519113b != this.f519113b) goto L13;
        return true;
    }

    public e(int r100, int r101, List<Integer> r102, int r103, int r104, List<Integer> r105, List<Integer> r106, List<Long> r107) {
        Intrinsics.checkNotNullParameter(r102, "playmode");
        this.f519112a = r100;
        this.f519113b = r101;
        this.f519114c = r102;
        this.f519115d = r103;
        this.f519116e = r104;
        this.f519117f = r105;
        this.f519118g = r106;
        this.f519119h = r107;
    }

    public /* synthetic */ e(int r100, int r110, List r111, int r112, int r113, List r114, List r115, List r116, int r117) {
        int r101 = 0;
        if ((r117 & 1) == 0) goto L5;
        int r102 = 0;
    L7:
        if ((r117 & 2) != 0) goto L11;
        r101 = r110;
    L11:
        if ((r117 & 4) == 0) goto L13;
        List r103 = CollectionsKt.emptyList();
    L14:
        int r104 = -1;
        if ((r117 & 8) == 0) goto L17;
        int r105 = -1;
    L19:
        if ((r117 & 16) != 0) goto L23;
        r104 = r113;
    L23:
        if ((r117 & 32) == 0) goto L25;
        List r106 = CollectionsKt.emptyList();
    L27:
        if ((r117 & 64) == 0) goto L29;
        List r107 = CollectionsKt.emptyList();
    L31:
        if ((r117 & 128) == 0) goto L33;
        List r108 = CollectionsKt.emptyList();
    L34:
        this(r102, r101, r103, r105, r104, r106, r107, r108);
        return;
    L33:
        r108 = r116;
        goto L34
    L29:
        r107 = r115;
        goto L31
    L25:
        r106 = r114;
        goto L27
    L17:
        r105 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L14
    L5:
        r102 = r100;
        goto L7
    }
}
