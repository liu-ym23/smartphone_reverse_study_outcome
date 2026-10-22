package ltc;

import com.alipay.sdk.m.u.i;
import itc.g;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f510755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f510756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f510757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f510758e;

    public final int hashCode() {
        int r100 = (this.f510755b.hashCode() ^ 1000003) * 1000003;
        String r101 = this.f510756c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 ^ r103) * 1000003;
        String r105 = this.f510757d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 ^ r102) * 1000003) ^ this.f510758e.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InstrumentationScopeInfo{name=" + this.f510755b + ", version=" + this.f510756c + ", schemaUrl=" + this.f510757d + ", attributes=" + this.f510758e + i.f25855d;
    }

    @Override // ltc.e
    public final g b() {
        return this.f510758e;
    }

    @Override // ltc.e
    public final String c() {
        return this.f510755b;
    }

    @Override // ltc.e
    @Nullable
    public final String d() {
        return this.f510757d;
    }

    @Override // ltc.e
    @Nullable
    public final String e() {
        return this.f510756c;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == false) goto L28;
        e r101 = (e) r100;
        if (this.f510755b.equals(r101.c()) == false) goto L26;
        String r102 = this.f510756c;
        if (r102 != null) goto L15;
        if (r101.e() != null) goto L26;
    L16:
        String r103 = this.f510757d;
        if (r103 != null) goto L22;
        if (r101.d() != null) goto L26;
    L24:
        if (this.f510758e.equals(r101.b()) == false) goto L26;
        return true;
    L22:
        if (r103.equals(r101.d()) == false) goto L26;
    L15:
        if (r102.equals(r101.e()) == true) goto L16;
    L26:
        return false;
    L28:
        return false;
    }

    public a(String r100, @Nullable String r101, @Nullable String r102, g r103) {
        if (r100 == null) goto L11;
        this.f510755b = r100;
        this.f510756c = r101;
        this.f510757d = r102;
        if (r103 == null) goto L9;
        this.f510758e = r103;
        return;
    L9:
        throw new NullPointerException("Null attributes");
    L11:
        throw new NullPointerException("Null name");
    }
}
