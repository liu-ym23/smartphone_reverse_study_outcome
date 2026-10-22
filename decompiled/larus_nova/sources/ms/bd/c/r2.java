package ms.bd.c;

import java.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public final class r2 extends RuntimeException {
    public r2(String r100, String[] r101, String[] r102) {
        super("Could not find '" + r100 + "'. Looked for: " + Arrays.toString(r101) + ", but only found: " + Arrays.toString(r102) + ".");
    }
}
