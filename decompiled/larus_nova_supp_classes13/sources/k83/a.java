package k83;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static float a(int r1, int r2) {
        if (r1 != 1) goto L5;
    L13:
        return 0.618f;
    L5:
        if (r1 != 2) goto L7;
        return 0.461f;
    L7:
        if (r1 == 3) goto L9;
        return 1.0f;
    L9:
        if (r2 == 0) goto L13;
        return 0.301f;
    }

    static {
    }

    public static int b(boolean r0, float r1, int r2) {
        if (r0 == false) goto L4;
        float r3 = (r2 * r1) + com.bytedance.android.shopping.extensions.b.b(48);
        int r4 = com.bytedance.android.shopping.extensions.b.b(44);
    L6:
        return (int) (r3 + r4);
    L4:
        r3 = (r2 * r1) + com.bytedance.android.shopping.extensions.b.b(12);
        r4 = com.bytedance.android.shopping.extensions.b.b(12);
        goto L6
    }
}
