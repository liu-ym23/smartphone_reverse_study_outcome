package xma;

import androidx.core.util.ObjectsCompat;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f564552a;

    public final int hashCode() {
        Object r100 = this.f564552a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f564552a + i.f25855d;
    }

    public a(Object r100) {
        this.f564552a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (a.class == r100.getClass()) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.f564552a, ((a) r100).f564552a);
    }
}
