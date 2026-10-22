package yv7;

import java.util.ArrayList;
import java.util.Arrays;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f569302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f569303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f569304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f569305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f569306e;

    public c(a r100) {
        this.f569302a = r100;
        this.f569303b = 0;
        this.f569306e = -1;
        int[] r101 = new int[128];
        this.f569304c = r101;
        this.f569305d = new int[128];
        Arrays.fill(r101, -1);
    }

    public final int a(int r100) {
        int r101 = this.f569304c[r100];
        if (r101 == (-1)) goto L5;
        return r101;
    L5:
        int r102 = this.f569302a.a(r100).getItemCount();
        this.f569304c[r100] = r102;
        if (r100 != this.f569303b) goto L8;
        int[] r103 = this.f569305d;
        int r104 = r100 + 1;
        r103[r104] = r103[r100] + r102;
        this.f569303b = r104;
    L8:
        return r102;
    }

    public final int b(int r100) {
        if (r100 <= this.f569303b) goto L5;
        ((ArrayList) this.f569302a.f569300c).size();
        int r101 = this.f569303b;
        int r102 = this.f569305d[r101];
    L7:
        if (r101 >= r100) goto L9;
        r102 = r102 + a(r101);
        r101 = r101 + 1;
        goto L7
    L9:
        return r102;
    L5:
        return this.f569305d[r100];
    }

    public final long c(int r100) {
        int r101 = -1;
        if (r100 != (-1)) goto L5;
        return -1;
    L5:
        int r102 = 0;
        int r103 = Arrays.binarySearch(this.f569305d, 0, this.f569303b, r100);
        if (r103 < 0) goto L8;
        r101 = r103;
    L9:
        int r104 = ((ArrayList) this.f569302a.f569300c).size();
        int r105 = this.f569305d[r103];
    L10:
        if (r103 >= r104) goto L15;
        int r106 = a(r103) + r105;
        if (r106 > r100) goto L13;
        r103 = r103 + 1;
        r105 = r106;
        goto L10
    L13:
        r102 = r100 - r105;
        r101 = r103;
    L15:
        if (r101 >= 0) goto L17;
        return -1;
    L17:
        return (((long) r101) << 32) | (((long) r102) & BodyPartID.bodyIdMax);
    L8:
        r103 = Math.max(0, (~r103) - 1);
        r102 = -1;
        goto L9
    }

    public final void d(int r100) {
        this.f569306e = -1;
        this.f569303b = Math.min(this.f569303b, r100);
        this.f569304c[r100] = -1;
    }
}
