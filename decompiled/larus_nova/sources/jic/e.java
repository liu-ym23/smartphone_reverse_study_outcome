package jic;

import android.view.Surface;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f499270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f499271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f499272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.vesdk.b<f> f499273d;

    public e(int r100) {
        this.f499273d = new com.ss.android.vesdk.b();
        this.f499270a = 0;
        this.f499271b = 0;
    }

    @Override // jic.f
    public final void a(Surface r100) {
        this.f499272c = r100;
        Iterator<f> r101 = this.f499273d.c().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a(r100);
        goto L4
    }

    @Override // jic.f
    public final void c(Surface r100) {
        Iterator<f> r101 = this.f499273d.c().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().c(r100);
        goto L4
    }

    @Override // jic.f
    public final void b(Surface r100, int r101, int r102, int r103) {
        if (this.f499270a == r103) goto L5;
    L8:
        this.f499270a = r102;
        this.f499271b = r103;
    L9:
        Iterator<f> r104 = this.f499273d.c().iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        r104.next().b(r100, r101, r102, r103);
        goto L11
    L13:
        return;
    L5:
        if (this.f499271b != r103) goto L8;
        if (r100 == this.f499272c) goto L9;
        goto L8
    }
}
