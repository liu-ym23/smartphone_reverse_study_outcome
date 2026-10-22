package r73;

import com.bytedance.android.shopping.anchorv4.experiment.e;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f536424a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Integer f536425b;

    static {
        int r100 = com.bytedance.android.ec.core.opt.ab.c.f45223a;
        f536424a = 7;
    }

    public static boolean b() {
        Integer r100 = f536425b;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        if (r101 <= 0) goto L16;
        Integer r102 = f536425b;
        if (r102 == null) goto L10;
        int r103 = r102.intValue();
    L12:
        if (r103 == 2) goto L16;
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == true) goto L16;
        return true;
    L10:
        r103 = f536424a;
    L16:
        return false;
    L5:
        r101 = f536424a;
        goto L6
    }

    public static boolean a() {
        if (b() == true) goto L5;
    L7:
        return false;
    L5:
        if (e.a() == false) goto L7;
        return true;
    }
}
