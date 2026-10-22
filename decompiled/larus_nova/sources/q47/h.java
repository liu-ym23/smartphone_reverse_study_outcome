package q47;

import android.os.Build;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f531676a = null;

    static {
        StringBuilder r100 = new StringBuilder("(Linux; Android ");
        r100.append(Build.VERSION.RELEASE);
        String r101 = Build.MODEL;
        if (r101.isEmpty() == false) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (Build.ID.isEmpty() == true) goto L13;
        if (r102 == true) goto L12;
        r100.append("; ");
    L12:
        r100.append(" Build/");
        r100.append(Build.ID);
    L13:
        r100.append(") Mobile PIA/2.6.0");
        f531676a = r100.toString();
        return;
    L5:
        if ("REL".equals(Build.VERSION.CODENAME) == false) goto L7;
        r100.append("; ");
        r100.append(r101);
        r102 = true;
        goto L9
    }
}
