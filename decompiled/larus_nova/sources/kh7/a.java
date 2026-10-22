package kh7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements mh7.a<com.bytedance.timonbase.apicache.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f503461a = null;

    public a() {
    }

    static {
        f503461a = new a();
    }

    @Override // mh7.a
    public final boolean a(com.bytedance.timonbase.apicache.a r100) {
        Object[] r101 = r100.f270797e;
        if (r101 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return false;
    L14:
        if (r101.length >= 2) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(r101[1], "android_id") == false) goto L21;
        return true;
    L21:
        return false;
    L5:
        if (r101.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r103 = false;
        goto L8
    }
}
