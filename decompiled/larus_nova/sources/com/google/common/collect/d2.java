package com.google.common.collect;

import java.util.Arrays;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class d2<K> extends c2<K> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient long[] f275457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient int f275458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public transient int f275459k;

    @Override // com.google.common.collect.c2
    public final int c() {
        int r100 = this.f275458j;
        if (r100 != (-2)) goto L6;
        return -1;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.c2
    public final void a() {
        super.a();
        this.f275458j = -2;
        this.f275459k = -2;
    }

    public d2(int r100) {
        super(r100, 0);
    }

    @Override // com.google.common.collect.c2
    public final void g(int r100) {
        super.g(r100);
        this.f275458j = -2;
        this.f275459k = -2;
        long[] r101 = new long[r100];
        this.f275457i = r101;
        Arrays.fill(r101, -1);
    }

    @Override // com.google.common.collect.c2
    public final void i(int r100) {
        int r101 = this.f275440c - 1;
        long r102 = this.f275457i[r100];
        q((int) (r102 >>> 32), (int) r102);
        if (r100 >= r101) goto L5;
        q((int) (this.f275457i[r101] >>> 32), r100);
        q(r100, (int) this.f275457i[r101]);
    L5:
        super.i(r100);
    }

    @Override // com.google.common.collect.c2
    public final int j(int r100) {
        int r101 = (int) this.f275457i[r100];
        if (r101 != (-2)) goto L6;
        return -1;
    L6:
        return r101;
    }

    @Override // com.google.common.collect.c2
    public final void o(int r100) {
        super.o(r100);
        long[] r101 = this.f275457i;
        int r102 = r101.length;
        long[] r103 = Arrays.copyOf(r101, r100);
        this.f275457i = r103;
        Arrays.fill(r103, r102, r100, -1);
    }

    @Override // com.google.common.collect.c2
    public final int k(int r100, int r101) {
        if (r100 == this.f275440c) goto L5;
        return r100;
    L5:
        return r101;
    }

    public final void q(int r100, int r110) {
        if (r100 != (-2)) goto L5;
        this.f275458j = r110;
    L6:
        if (r110 != (-2)) goto L8;
        this.f275459k = r100;
        return;
    L8:
        long[] r101 = this.f275457i;
        r101[r110] = (BodyPartID.bodyIdMax & r101[r110]) | (((long) r100) << 32);
        return;
    L5:
        long[] r102 = this.f275457i;
        r102[r100] = (r102[r100] & (-4294967296L)) | (((long) r110) & BodyPartID.bodyIdMax);
        goto L6
    }

    @Override // com.google.common.collect.c2
    public final void h(int r100, @ParametricNullness K r101, int r102, int r103) {
        super.h(r100, r101, r102, r103);
        q(this.f275459k, r100);
        q(r100, -2);
    }
}
