package ep4;

import android.text.TextUtils;
import eq4.e;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f473433a;

    public final boolean a() {
        e r100 = this.f473433a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.f467804a) == true) goto L7;
        return true;
    }

    public a() {
    }

    public a(e r100) {
        this.f473433a = r100;
    }
}
