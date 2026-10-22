package guc;

/* JADX INFO: loaded from: classes42.dex */
public final class d {
    public static final boolean a(char r100) {
        if ('0' <= r100) goto L5;
        return false;
    L5:
        if (r100 >= ':') goto L9;
        return true;
    L9:
        return false;
    }
}
