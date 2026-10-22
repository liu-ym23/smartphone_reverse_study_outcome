package yqa;

import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c f568878a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L8;
        ((b) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "GetTokenCache(clientPkg=null)";
    }

    public final boolean a() {
        c r100 = this.f568878a;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.f568881c.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L16;
        long r102 = SystemClock.elapsedRealtime() - r100.f568884f;
        int r103 = zqa.a.f573356a;
        if (Intrinsics.areEqual("share_login", r100.f568886h) == false) goto L12;
        int r104 = 300000;
    L14:
        if (r102 >= r104) goto L16;
        boolean r105 = true;
    L17:
        if (r105 != true) goto L21;
        return true;
    L21:
        return false;
    L12:
        r104 = 30000;
    L16:
        r105 = false;
        goto L17
    L7:
        r101 = false;
        goto L8
    }

    public final void setResult(c r100) {
        this.f568878a = r100;
    }
}
