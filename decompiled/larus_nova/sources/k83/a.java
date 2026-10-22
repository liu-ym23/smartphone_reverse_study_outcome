package k83;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f502092a = 0;

    public static float a(int r100, int r101) {
        if (r100 != 1) goto L5;
    L13:
        return 0.618f;
    L5:
        if (r100 != 2) goto L7;
        return 0.461f;
    L7:
        if (r100 == 3) goto L9;
        return 1.0f;
    L9:
        if (r101 == 0) goto L13;
        return 0.301f;
    }

    static {
    }

    public static int b(boolean r100, float r101, int r102) {
        if (r100 == false) goto L4;
        float r103 = (r102 * r101) + com.bytedance.android.shopping.extensions.b.b(48);
        int r104 = com.bytedance.android.shopping.extensions.b.b(44);
    L6:
        return (int) (r103 + r104);
    L4:
        r103 = (r102 * r101) + com.bytedance.android.shopping.extensions.b.b(12);
        r104 = com.bytedance.android.shopping.extensions.b.b(12);
        goto L6
    }
}
