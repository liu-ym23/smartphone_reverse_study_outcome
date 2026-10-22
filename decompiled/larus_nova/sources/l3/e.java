package l3;

import e3.g;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f507204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f507205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f507206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<g> f507207e;

    public final int hashCode() {
        String r100 = this.f507203a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "aiBridgeEvent");
        String r101 = r100.f507199d;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
    L13:
        String r104 = r100.f507200e;
        if (r104 != null) goto L16;
    L19:
        if (r102 == false) goto L21;
    L23:
        g r105 = this.f507207e.get();
        if (r105 == null) goto L27;
        r105.b(r100.f507196a, r100.f507197b);
        return;
    L27:
        return;
    L21:
        if (Intrinsics.areEqual(r100.f507200e, this.f507203a) == true) goto L23;
        return;
    L16:
        if (r104.length() == 0) goto L19;
        r102 = false;
        goto L19
    L11:
        if (Intrinsics.areEqual(r100.f507199d, this.f507204b) == true) goto L13;
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f507203a, ((e) r100).f507203a) == false) goto L19;
        String r101 = this.f507203a;
        if (r101 != null) goto L13;
    L16:
        boolean r102 = true;
    L17:
        if (r102 == true) goto L19;
        return true;
    L13:
        if (r101.length() == 0) goto L16;
        r102 = false;
    L19:
        return false;
    }

    public /* synthetic */ e(g r110, String r111, String r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        long r114 = System.currentTimeMillis();
    L14:
        this(r110, r100, r101, r114, null);
        return;
    L13:
        r114 = 0;
        goto L14
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public e(g r100, String r101, String r102, long r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "jsEventDelegate");
        this.f507203a = r101;
        this.f507204b = r102;
        this.f507205c = r103;
        this.f507206d = r104;
        this.f507207e = new WeakReference(r100);
    }
}
