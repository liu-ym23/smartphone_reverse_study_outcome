package iv7;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes23.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f495950a = null;

    static {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        byte[] r101 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.".getBytes("US-ASCII");     // Catch: UnsupportedEncodingException -> L10
        int r102 = 0;
    L6:
        if (r102 >= 135) goto L8;
        r100.write(r101, 0, r102);
        r102 = r102 + 1;
        goto L6
    L8:
        f495950a = r100.toByteArray();
        return;
    L10:
        e = move-exception;
        throw new RuntimeException("System doesn't support ASCII", e);
    }
}
