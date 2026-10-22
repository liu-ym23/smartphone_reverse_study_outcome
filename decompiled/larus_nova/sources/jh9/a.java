package jh9;

import java.util.Set;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f499103a = 0;

    static {
    }

    public static boolean a(Set r100, String r101) {
        if (r101 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.contains(r101) == false) goto L6;
        return true;
    }
}
