package ijc;

import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C6277a f490157a;

    /* JADX INFO: renamed from: ijc.a$a, reason: collision with other inner class name */
    public class C6277a {
        public C6277a() {
        }
    }

    public a() {
        this.f490157a = new C6277a();
    }

    public static float a(a r100, View r101) {
        r100.getClass();
        return r101.getTranslationX();
    }

    public static int b(int r100, hjc.b r101) {
        if ((r100 & 1) == 0) goto L6;
        return r101.getWidth();
    L6:
        if ((r100 & 2) == 0) goto L9;
        int r102 = r101.getWidth();
    L15:
        return -r102;
    L9:
        if ((r100 & 4) == 0) goto L12;
        return r101.getHeight();
    L12:
        if ((r100 & 8) == 0) goto L17;
        r102 = r101.getHeight();
        goto L15
    L17:
        throw new IllegalArgumentException("illegal directFrom: " + Integer.toBinaryString(r100));
    }

    public static int c(a r100, int r101, int r102) {
        r100.getClass();
        if (r101 > 0) goto L7;
        return 0;
    L7:
        return r101;
    }
}
