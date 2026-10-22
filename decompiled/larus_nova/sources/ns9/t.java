package ns9;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.reach.api.ReachType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f520408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f520409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f520410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f520411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f520412e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f520408a, r101.f520408a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520409b, r101.f520409b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520410c, r101.f520410c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f520411d, r101.f520411d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f520412e, r101.f520412e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f520408a.hashCode() * 31) + this.f520409b.hashCode()) * 31) + this.f520410c.hashCode()) * 31) + this.f520411d.hashCode()) * 31) + this.f520412e.hashCode();
    }

    public final String toString() {
        return "ReachRequest(meta=" + this.f520408a + ", target=" + this.f520409b + ", policy=" + this.f520410c + ", content=" + this.f520411d + ", payload=" + this.f520412e + ')';
    }

    public final ReachType getType() {
        return this.f520408a.getType();
    }

    public /* synthetic */ t(l r110, a r111, s r112, f r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        a r100 = new a(0);
    L7:
        if ((r114 & 8) == 0) goto L9;
        f r101 = new f(null, null, null, null, null, 63);
    L11:
        if ((r114 & 16) == 0) goto L13;
        r r102 = new r(null, null, 3);
    L14:
        this(r110, r100, r112, r101, r102);
        return;
    L13:
        r102 = null;
        goto L14
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public t(l r100, v r101, s r102, f r103, r r104) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "policy");
        Intrinsics.checkNotNullParameter(r103, "content");
        Intrinsics.checkNotNullParameter(r104, WsConstants.KEY_PAYLOAD);
        this.f520408a = r100;
        this.f520409b = r101;
        this.f520410c = r102;
        this.f520411d = r103;
        this.f520412e = r104;
    }
}
