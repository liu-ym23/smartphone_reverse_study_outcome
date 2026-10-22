package wf9;

import com.larus.im.j;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f559488a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        return j.f(r100);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
