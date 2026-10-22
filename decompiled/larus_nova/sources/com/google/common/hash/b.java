package com.google.common.hash;

import com.google.common.base.m;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes23.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public abstract class b implements e {
    public b() {
    }

    public HashCode hashBytes(ByteBuffer r100) {
        return newHasher(r100.remaining()).c(r100).a();
    }

    public HashCode hashInt(int r100) {
        return newHasher(4).putInt(r100).a();
    }

    public HashCode hashLong(long r100) {
        return newHasher(8).putLong(r100).a();
    }

    public HashCode hashUnencodedChars(CharSequence r100) {
        c r101 = (c) newHasher(r100.length() * 2);
        r101.getClass();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.h(r100.charAt(r103));
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.a();
    }

    public f newHasher(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        m.d(r101, "expectedInputSize must be >= 0 but was %s", r100);
        return newHasher();
    L4:
        r101 = false;
        goto L5
    }

    public HashCode hashBytes(byte[] r100) {
        return hashBytes(r100, 0, r100.length);
    }

    @Override // com.google.common.hash.e
    public <T> HashCode hashObject(@ParametricNullness T r100, Funnel<? super T> r101) {
        c r102 = (c) newHasher();
        r102.getClass();
        r101.funnel(r100, r102);
        return r102.a();
    }

    public HashCode hashString(CharSequence r100, Charset r101) {
        return newHasher().d(r100, r101).a();
    }

    public HashCode hashBytes(byte[] r100, int r101, int r102) {
        m.n(r101, r101 + r102, r100.length);
        return newHasher(r102).b(r100, r101, r102).a();
    }
}
