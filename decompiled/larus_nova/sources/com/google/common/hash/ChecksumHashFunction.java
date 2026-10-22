package com.google.common.hash;

import com.google.common.base.m;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes23.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class ChecksumHashFunction extends b implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final g<? extends Checksum> checksumSupplier;
    private final String toString;

    public final class a extends com.google.common.hash.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Checksum f275559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChecksumHashFunction f275560c;

        @Override // com.google.common.hash.f
        public final HashCode a() {
            long r100 = this.f275559b.getValue();
            if (ChecksumHashFunction.access$100(this.f275560c) != 32) goto L7;
            return HashCode.fromInt((int) r100);
        L7:
            return HashCode.fromLong(r100);
        }

        @Override // com.google.common.hash.a
        public void update(byte r100) {
            this.f275559b.update(r100);
        }

        public a(ChecksumHashFunction r100, Checksum r101) {
            this.f275560c = r100;
            r101.getClass();
            this.f275559b = r101;
        }

        @Override // com.google.common.hash.a
        public void update(byte[] r100, int r101, int r102) {
            this.f275559b.update(r100, r101, r102);
        }
    }

    @Override // com.google.common.hash.e
    public f newHasher() {
        return new a(this, this.checksumSupplier.get());
    }

    public int bits() {
        return this.bits;
    }

    public String toString() {
        return this.toString;
    }

    public static /* synthetic */ int access$100(ChecksumHashFunction r100) {
        return r100.bits;
    }

    public ChecksumHashFunction(g<? extends Checksum> r100, int r101, String r102) {
        r100.getClass();
        this.checksumSupplier = r100;
        if (r101 != 32) goto L5;
    L8:
        boolean r103 = true;
    L9:
        m.d(r103, "bits (%s) must be either 32 or 64", r101);
        this.bits = r101;
        r102.getClass();
        this.toString = r102;
        return;
    L5:
        if (r101 == 64) goto L8;
        r103 = false;
        goto L9
    }
}
