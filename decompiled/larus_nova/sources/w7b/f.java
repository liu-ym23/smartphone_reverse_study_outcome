package w7b;

import java.util.Objects;
import v7b.x;

/* JADX INFO: loaded from: classes35.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f558606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f558607b;

    public f(CharSequence r100, x r101) {
        Objects.requireNonNull(r100, "content must not be null");
        this.f558606a = r100;
        this.f558607b = r101;
    }

    public final f a(int r100, int r101) {
        CharSequence r102 = this.f558606a.subSequence(r100, r101);
        x r103 = this.f558607b;
        if (r103 == null) goto L7;
        int r104 = r103.f553579b + r100;
        int r105 = r101 - r100;
        if (r105 == 0) goto L7;
        x r106 = new x(r103.f553578a, r104, r105);
    L9:
        return new f(r102, r106);
    L7:
        r106 = null;
        goto L9
    }
}
