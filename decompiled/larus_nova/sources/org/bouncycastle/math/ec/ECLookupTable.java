package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes42.dex */
public interface ECLookupTable {
    int getSize();

    ECPoint lookup(int r100);

    ECPoint lookupVar(int r100);
}
