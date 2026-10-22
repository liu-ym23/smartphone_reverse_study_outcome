package fg6;

import com.bytedance.android.livesdk.link.model.bridge.u1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f476855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f476856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Integer> f476857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f476858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f476859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f476860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u1 f476861k;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public final int hashCode() {
        int r100 = ((this.f476855e * 31) + this.f476856f) * 31;
        List<Integer> r101 = this.f476857g;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f476858h;
        ?? r106 = r105;
        if (r105 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f476859i;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f476860j;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        u1 r114 = this.f476861k;
        if (r114 == null) goto L21;
        r102 = r114.hashCode();
    L21:
        return r113 + r102;
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "RtcSwitchSceneEventKt(scene=" + this.f476855e + ", uiLayout=" + this.f476856f + ", playModes=" + this.f476857g + ", isFromBroadcast=" + this.f476858h + ", rtcExtInfo=" + this.f476859i + ", liveCoreExtInfo=" + this.f476860j + ", multiLiveCoreInfo=" + this.f476861k + ")";
    }

    @Override // fg6.d
    public final int a() {
        return this.f476855e;
    }

    @Override // fg6.d
    public final int b() {
        return this.f476856f;
    }

    @Override // fg6.d
    public final boolean c() {
        return this.f476858h;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (this.f476855e == r101.f476855e) goto L8;
        return false;
    L8:
        if (this.f476856f == r101.f476856f) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f476857g, r101.f476857g) == true) goto L12;
        return false;
    L12:
        if (this.f476858h == r101.f476858h) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f476859i, r101.f476859i) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f476860j, r101.f476860j) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f476861k, r101.f476861k) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public c(int r100, int r101, List<Integer> r102, boolean r103, String r104, String r105, u1 r106) {
        Intrinsics.checkNotNullParameter(r104, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r105, "liveCoreExtInfo");
        super(r100, r101, r102, r103);
        this.f476855e = r100;
        this.f476856f = r101;
        this.f476857g = r102;
        this.f476858h = r103;
        this.f476859i = r104;
        this.f476860j = r105;
        this.f476861k = r106;
    }
}
