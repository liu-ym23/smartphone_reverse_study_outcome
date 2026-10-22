package wx5;

import java.util.Arrays;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f561819a;

    public a(String[] r100) {
        this.f561819a = r100;
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
        return Arrays.equals(this.f561819a, ((a) r100).f561819a);
    }
}
