package k89;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f502118a = 0;

    static {
    }

    public static String a(String r100) {
        if (r100 == null) goto L11;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L11;
        if (r101.length() <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return r101;
    L8:
        r102 = false;
    L11:
        return null;
    }
}
