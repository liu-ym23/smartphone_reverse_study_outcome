package ga3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f480548a = 0;

    static {
    }

    public static Object a(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        return r100;
    L5:
        if (((CharSequence) r100).length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
    L13:
        return "";
    L10:
        if (Intrinsics.areEqual("null", r100) == true) goto L13;
        return (String) r100;
    L7:
        r101 = false;
        goto L8
    }
}
