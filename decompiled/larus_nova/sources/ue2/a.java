package ue2;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f549793a = 0;

    static {
    }

    public static String a(long r100) {
        TimeUnit r101 = TimeUnit.MILLISECONDS;
        long r102 = r101.toMinutes(r100);
        long r103 = r101.toSeconds(r100) % ((long) 60);
        long r104 = 10;
        if (r102 >= r104) goto L5;
        String r105 = "0" + r102;
    L7:
        if (r103 >= r104) goto L9;
        String r106 = "0" + r103;
    L11:
        return (r105 + ":") + r106;
    L9:
        r106 = String.valueOf(r103);
        goto L11
    L5:
        r105 = String.valueOf(r102);
        goto L7
    }
}
