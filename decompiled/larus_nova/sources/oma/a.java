package oma;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f524314a = 0;

    /* JADX INFO: renamed from: oma.a$a, reason: collision with other inner class name */
    public static final class C7071a {
        public static float a(float r100, float r101, float r102, float r103) {
            boolean r104 = false;
            if (r102 != r103) goto L5;
            boolean r105 = true;
        L6:
            if (r105 == false) goto L8;
        L30:
            return r102;
        L8:
            if (r102 != r101) goto L10;
            boolean r106 = true;
        L11:
            if (r106 == true) goto L30;
            if (r100 >= r101) goto L19;
            if (r103 >= r100) goto L19;
            return r103;
        L19:
            if (r100 > r101) goto L21;
        L23:
            float r107 = r101 - r100;
            int r108 = a.f524314a;
            float r109 = (((r103 - r100) * 1.0f) / r107) + 1.0f;
            if (r109 != 0.0f) goto L26;
            r104 = true;
        L26:
            if (r104 == false) goto L29;
            return 0.0f;
        L29:
            return r100 + ((1.0f - (1.0f / r109)) * r107);
        L21:
            if (r103 <= r100) goto L23;
            return r103;
        L10:
            r106 = false;
            goto L11
        L5:
            r105 = false;
            goto L6
        }
    }

    static {
    }
}
