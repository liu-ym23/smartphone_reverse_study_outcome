package z05;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public Long h;
    public Long i;

    public g() {
    }

    public final int hashCode() {
        return (this.a.hashCode() + this.g.hashCode()) + this.f.hashCode();
    }

    public final String toString() {
        return "VersionMetadata{token='" + this.a + "', name='" + TextUtils.isEmpty(this.b) + "', displayName='" + TextUtils.isEmpty(this.e) + "', version='" + this.f + "', parentToken='" + this.g + "', createTime=" + this.h + ", updateTime=" + this.i + '}';
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (this != r5) goto L9;
        return true;
    L9:
        if (g.class == r5.getClass()) goto L11;
        return false;
    L11:
        g r2 = (g) r5;
        if (TextUtils.equals(this.a, r2.a) == true) goto L15;
        return false;
    L15:
        if (TextUtils.equals(this.g, r2.g) == true) goto L18;
        return false;
    L18:
        if (TextUtils.equals(this.f, r2.f) == true) goto L21;
        return false;
    L21:
        if (TextUtils.equals(this.e, r2.e) == true) goto L24;
        return false;
    L24:
        if (Objects.equals(this.h, r2.h) == true) goto L27;
        return false;
    L27:
        return super.equals(r5);
    }
}
