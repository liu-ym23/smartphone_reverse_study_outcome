package fr2;

/* JADX INFO: loaded from: classes11.dex */
public final class c0 {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L12;
        c0 r101 = (c0) r100;
        r101.getClass();
        if (Float.compare(0.0f, 0.0f) != 0) goto L16;
        r101.getClass();
        if (Float.compare(0.0f, 0.0f) != 0) goto L17;
        r101.getClass();
        if (Float.compare(0.0f, 0.0f) == 0) goto L19;
        return false;
    L19:
        return true;
    L17:
        return false;
    L16:
        return false;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(0.0f) * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f);
    }

    public final String toString() {
        return "IRTCSpatialAudioOrientationParams(x=0.0, y=0.0, z=0.0)";
    }
}
