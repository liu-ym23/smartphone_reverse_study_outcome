package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class LensFacingUtil {
    private LensFacingUtil() {
    }

    public static int getCameraSelectorLensFacing(int r3) {
        if (r3 != 0) goto L4;
        return 0;
    L4:
        if (r3 != 1) goto L6;
        return 1;
    L6:
        if (r3 != 2) goto L9;
        return 2;
    L9:
        throw new IllegalArgumentException("The given lens facing integer: " + r3 + " can not be recognized.");
    }

    public static int getLensFacingInt(int r3) {
        if (r3 != 0) goto L4;
        return 0;
    L4:
        if (r3 != 1) goto L6;
        return 1;
    L6:
        if (r3 != 2) goto L9;
        return 2;
    L9:
        throw new IllegalArgumentException("The given lens facing: " + r3 + " can not be recognized.");
    }
}
