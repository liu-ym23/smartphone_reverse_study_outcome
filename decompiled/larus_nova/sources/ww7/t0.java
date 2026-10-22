package ww7;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f561711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f561712b;

    public final int hashCode() {
        return this.f561712b;
    }

    public t0(String r100) {
        this.f561711a = r100;
        this.f561712b = Arrays.hashCode(new Object[]{r100});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (t0.class == r100.getClass()) goto L10;
        return false;
    L10:
        return TextUtils.equals(this.f561711a, ((t0) r100).f561711a);
    }
}
