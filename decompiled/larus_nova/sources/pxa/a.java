package pxa;

import com.ss.android.lark.biz.im.api.n0;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f530960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<n0> f530961c;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f530959a, this.f530960b});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L17;
        a r101 = (a) r100;
        if (Objects.equals(this.f530959a, r101.f530959a) == true) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.f530960b, r101.f530960b) == false) goto L15;
        return true;
    }

    public a(String r100, CharSequence r101, List<n0> r102) {
        this.f530959a = r100;
        this.f530960b = r101;
        this.f530961c = r102;
    }
}
