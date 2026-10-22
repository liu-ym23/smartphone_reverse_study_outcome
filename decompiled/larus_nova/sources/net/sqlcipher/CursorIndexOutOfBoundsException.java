package net.sqlcipher;

/* JADX INFO: loaded from: classes42.dex */
public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public CursorIndexOutOfBoundsException(String r100) {
        super(r100);
    }

    public CursorIndexOutOfBoundsException(int r100, int r101) {
        super("Index " + r100 + " requested, with a size of " + r101);
    }
}
