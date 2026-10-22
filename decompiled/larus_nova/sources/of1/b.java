package of1;

import com.byted.cast.common.source.ServiceInfo;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f523066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f523067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f523068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f523069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f523070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ServiceInfo f523071g;

    public final int hashCode() {
        return (((((((((this.f523065a.hashCode() * 31) + this.f523066b.hashCode()) * 31) + this.f523067c.hashCode()) * 31) + this.f523068d) * 31) + this.f523069e.hashCode()) * 31) + this.f523070f.hashCode();
    }

    @Override // of1.a
    public final String getData() {
        return this.f523069e;
    }

    @Override // of1.a
    public final String getName() {
        return this.f523065a;
    }

    public b(ServiceInfo r100) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceInfoKey);
        this.f523071g = r100;
        String r101 = r100.name;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f523065a = r101;
        String r103 = r100.f33719ip;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f523066b = r103;
        String r104 = r100.manufacture;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        this.f523067c = r104;
        this.f523068d = r100.port;
        String r105 = r100.data;
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        this.f523069e = r105;
        String r106 = r100.protocols;
        if (r106 == null) goto L18;
        r102 = r106;
    L18:
        this.f523070f = r102;
    }

    @Override // of1.a
    public final boolean a(a r100) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceInfoKey);
        return Intrinsics.areEqual(this, r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(b.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L33;
        b r102 = (b) r100;
        if ((!Intrinsics.areEqual(this.f523065a, r102.f523065a)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.f523066b, r102.f523066b)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.f523067c, r102.f523067c)) == false) goto L23;
        return false;
    L23:
        if (this.f523068d == r102.f523068d) goto L26;
        return false;
    L26:
        if ((!Intrinsics.areEqual(this.f523069e, r102.f523069e)) == false) goto L29;
        return false;
    L29:
        if ((!Intrinsics.areEqual(this.f523070f, r102.f523070f)) == false) goto L31;
        return false;
    L31:
        return true;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.castscreen.pad.model.LiveServiceInfo");
    L8:
        r101 = null;
        goto L10
    }
}
