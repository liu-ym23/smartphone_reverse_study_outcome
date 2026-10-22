package kda;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.ss.android.cert.manager.constants.EventConstant;
import hda.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class g extends com.obric.assistant.cocreationreview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleKey f502982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f502983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f502984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f502985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f502986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f502987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e1 f502988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f502989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f502990j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f502981a, r101.f502981a) == true) goto L12;
        return false;
    L12:
        if (this.f502982b == r101.f502982b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502983c, r101.f502983c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502984d, r101.f502984d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f502985e, r101.f502985e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f502986f, r101.f502986f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f502987g, r101.f502987g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f502988h, r101.f502988h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f502989i, r101.f502989i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f502990j, r101.f502990j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f502981a.hashCode() * 31) + this.f502982b.hashCode()) * 31) + this.f502983c.hashCode()) * 31) + this.f502984d.hashCode()) * 31;
        String r101 = this.f502985e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((((r100 + r103) * 31) + this.f502986f.hashCode()) * 31) + this.f502987g.hashCode()) * 31) + this.f502988h.hashCode()) * 31) + this.f502989i.hashCode()) * 31;
        String r105 = this.f502990j;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ScreenMemoryUsageRecord(id=" + this.f502981a + ", module=" + this.f502982b + ", capturedAt=" + this.f502983c + ", memoryDomain=" + this.f502984d + ", screenScene=" + this.f502985e + ", memoryTitle=" + this.f502986f + ", memorySummary=" + this.f502987g + ", uiModel=" + this.f502988h + ", payload=" + this.f502989i + ", traceJson=" + this.f502990j + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.f502981a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.f502982b;
    }

    public g(String r100, ModuleKey r101, String r102, String r103, String r104, String r105, e1 r106, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "capturedAt");
        Intrinsics.checkNotNullParameter("屏幕内容", "memoryDomain");
        Intrinsics.checkNotNullParameter(r104, "memoryTitle");
        Intrinsics.checkNotNullParameter(r105, "memorySummary");
        Intrinsics.checkNotNullParameter(r106, "uiModel");
        Intrinsics.checkNotNullParameter(r110, WsConstants.KEY_PAYLOAD);
        this.f502981a = r100;
        this.f502982b = r101;
        this.f502983c = r102;
        this.f502984d = "屏幕内容";
        this.f502985e = r103;
        this.f502986f = r104;
        this.f502987g = r105;
        this.f502988h = r106;
        this.f502989i = r110;
        this.f502990j = r111;
    }
}
