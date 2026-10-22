package h50;

import k50.f;
import kotlin.jvm.internal.Intrinsics;
import m50.d;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements l50.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f483860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f483861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f483862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f483863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f483864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f483865f;

    @Override // l50.b
    public final boolean isFinished() {
        return this.f483863d;
    }

    public b(int[] r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "textureIds");
        this.f483864e = r100;
        this.f483865f = r101;
        this.f483860a = true;
        this.f483862c = -1;
    }

    @Override // l50.b
    public final boolean a(f r100, d r101, n50.b r102) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        Intrinsics.checkNotNullParameter(r101, "modelParams");
        Intrinsics.checkNotNullParameter(r102, "sceneParams");
        boolean r103 = this.f483863d;
        if (r103 == false) goto L5;
        return r103;
    L5:
        long r104 = r100.f501813d;
        if ((r104 - this.f483862c) < this.f483865f) goto L15;
        int r105 = this.f483861b + 1;
        this.f483861b = r105;
        int[] r106 = this.f483864e;
        if (r105 >= r106.length) goto L10;
    L13:
        r101.f512075a = r106[this.f483861b];
        this.f483862c = r104;
        goto L15
    L10:
        if (this.f483860a == false) goto L12;
        this.f483861b = 0;
        goto L13
    L12:
        this.f483861b = r106.length - 1;
        this.f483863d = true;
    L15:
        return this.f483863d;
    }
}
