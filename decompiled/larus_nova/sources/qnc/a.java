package qnc;

import android.os.Bundle;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f534124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f534125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f534126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f534127e;

    /* JADX INFO: renamed from: qnc.a$a, reason: collision with other inner class name */
    public static final class C7370a {
    }

    static {
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("NavBackRequest(route=");
        r100.append(this.f534123a);
        r100.append(", inclusive=");
        r100.append(this.f534124b);
        r100.append(", requestKey=");
        r100.append(this.f534125c);
        r100.append(", resultCode=");
        r100.append(this.f534126d);
        r100.append(", result=");
        if (this.f534127e == null) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        r100.append(')');
        return r100.toString();
    L5:
        r101 = false;
        goto L6
    }

    public /* synthetic */ a(String r100) {
        this(r100, true, null, -1000, null);
    }

    public a(String r100, boolean r101, String r102, int r103, Bundle r104) {
        this.f534123a = r100;
        this.f534124b = r101;
        this.f534125c = r102;
        this.f534126d = r103;
        this.f534127e = r104;
    }
}
