package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class LazilyParsedNumber extends Number {
    private final String value;

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return Integer.parseInt(this.value);
    L4:
        return (int) Long.parseLong(this.value);
    L8:
        return new BigDecimal(this.value).intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return Long.parseLong(this.value);
    L5:
        return new BigDecimal(this.value).longValue();
    }

    public String toString() {
        return this.value;
    }

    public LazilyParsedNumber(String r100) {
        this.value = r100;
    }

    private void readObject(ObjectInputStream r100) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LazilyParsedNumber) == false) goto L14;
        String r101 = this.value;
        String r102 = ((LazilyParsedNumber) r100).value;
        if (r101 != r102) goto L10;
        return true;
    L10:
        if (r101.equals(r102) == true) goto L16;
        return false;
    L16:
        return true;
    L14:
        return false;
    }
}
