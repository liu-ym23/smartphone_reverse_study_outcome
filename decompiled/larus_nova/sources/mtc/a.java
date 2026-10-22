package mtc;

import com.alipay.sdk.m.u.i;
import itc.g;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f515701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f515702f;

    public final int hashCode() {
        String r100 = this.f515701e;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return ((r101 ^ 1000003) * 1000003) ^ this.f515702f.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "Resource{schemaUrl=" + this.f515701e + ", attributes=" + this.f515702f + i.f25855d;
    }

    @Override // mtc.c
    public final g b() {
        return this.f515702f;
    }

    @Override // mtc.c
    @Nullable
    public final String c() {
        return this.f515701e;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == false) goto L19;
        c r101 = (c) r100;
        String r102 = this.f515701e;
        if (r102 != null) goto L13;
        if (r101.c() == null) goto L15;
    L17:
        return false;
    L15:
        if (this.f515702f.equals(r101.b()) == false) goto L17;
        return true;
    L13:
        if (r102.equals(r101.c()) == false) goto L17;
    L19:
        return false;
    }

    public a(@Nullable String r100, itc.b r101) {
        this.f515701e = r100;
        if (r101 == null) goto L7;
        this.f515702f = r101;
        return;
    L7:
        throw new NullPointerException("Null attributes");
    }
}
