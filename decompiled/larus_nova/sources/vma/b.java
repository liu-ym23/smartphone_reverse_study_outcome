package vma;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f556350a = 0;

    static {
    }

    @JvmStatic
    public static final float a(float r100, float r101, float r102) {
        if (r101 != r102) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        return 0.0f;
    L10:
        return (r100 - r101) / (r102 - r101);
    L5:
        r103 = false;
        goto L6
    }
}
