package q53;

import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f531726a = 0;

    static {
    }

    public static String a(Map r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return "0";
    L10:
        return "1";
    L4:
        if (r100.isEmpty() == true) goto L7;
        r101 = false;
        goto L8
    }
}
