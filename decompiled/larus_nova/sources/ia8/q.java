package ia8;

import com.larus.avlink.n1;

/* JADX INFO: loaded from: classes25.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f488959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f488960b = null;

    public q() {
    }

    static {
        f488959a = new q();
        f488960b = "MusicCoverUtils";
    }

    public static String a(String r100, String r101, String r102) {
        boolean r103 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
    L23:
        n1.b(f488960b, "coverImage: error coverUrl:" + r100 + ",coverUri:" + r101 + ",coverPrefix:" + r102);
        return null;
    L11:
        if (r101.length() != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L23;
        if (r102.length() == 0) goto L19;
        r103 = false;
    L19:
        if (r103 == true) goto L23;
        return r100 + r101 + '~' + r102 + "-crop-center:100:100.jpg";
    L13:
        r105 = false;
        goto L14
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
