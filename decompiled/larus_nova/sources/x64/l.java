package x64;

import com.bytedance.badger.monitor.TriggerStage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TriggerStage f562628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f562629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f562630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.badger.C.a f562631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f562632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f562633f;

    public l(TriggerStage r100, int r101, boolean r102, com.bytedance.badger.C.a r103, String r104, String r105) {
        this.f562628a = r100;
        this.f562629b = r101;
        this.f562630c = r102;
        this.f562631d = r103;
        this.f562632e = r104;
        this.f562633f = r105;
    }

    public /* synthetic */ l(TriggerStage r100, int r101, boolean r110, com.bytedance.badger.C.a r111, String r112, String r113, int r114) {
        if ((r114 & 4) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r114 & 8) == 0) goto L9;
        r111 = com.bytedance.badger.C.a.f199018b;
    L9:
        com.bytedance.badger.C.a r103 = r111;
        if ((r114 & 16) == 0) goto L12;
        String r104 = "";
    L14:
        if ((r114 & 32) == 0) goto L16;
        String r105 = "";
    L17:
        this(r100, r101, r102, r103, r104, r105);
        return;
    L16:
        r105 = r113;
        goto L17
    L12:
        r104 = r112;
        goto L14
    L5:
        r102 = r110;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L26:
        return true;
    L5:
        if ((r100 instanceof l) == false) goto L25;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f562628a, r101.f562628a) == false) goto L25;
        if (this.f562629b != r101.f562629b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L25;
        if (this.f562630c != r101.f562630c) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L25;
        if (Intrinsics.areEqual(this.f562631d, r101.f562631d) == false) goto L25;
        if (Intrinsics.areEqual(this.f562632e, r101.f562632e) == false) goto L25;
        if (Intrinsics.areEqual(this.f562633f, r101.f562633f) == false) goto L25;
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
    L25:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    public final int hashCode() {
        TriggerStage r100 = this.f562628a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f562629b) * 31;
        boolean r104 = this.f562630c;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        com.bytedance.badger.C.a r107 = this.f562631d;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f562632e;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f562633f;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UnifiedReportContext(triggerStage=" + this.f562628a + ", sceneId=" + this.f562629b + ", isFirstReport=" + this.f562630c + ", compensateType=" + this.f562631d + ", triggerPath=" + this.f562632e + ", triggerLogid=" + this.f562633f + ")";
    }
}
