package wx5;

import java.util.Objects;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f561829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f561830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f561831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f561832d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (c.class != r100.getClass()) goto L21;
        c r101 = (c) r100;
        if (this.f561829a == r101.f561829a) goto L13;
    L19:
        return false;
    L13:
        if (this.f561830b != r101.f561830b) goto L19;
        if (Objects.equals(this.f561831c, r101.f561831c) == false) goto L19;
        if (Objects.equals(this.f561832d, r101.f561832d) == false) goto L19;
        return true;
    }

    public c(int r100, b r101, a r102) {
        this.f561829a = r100;
        this.f561830b = 0;
        this.f561831c = r101;
        this.f561832d = r102;
    }
}
