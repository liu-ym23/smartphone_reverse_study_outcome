package h84;

import android.text.TextUtils;
import com.bytedance.bdinstall.c1;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements e.c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f484126a;

    @Override // h84.e.c
    public final String getCache() {
        return this.f484126a.a("serial_number");
    }

    public g(e r100) {
        this.f484126a = r100;
    }

    @Override // h84.e.c
    public final boolean a(String r100) {
        String r101 = r100;
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r101, "unknown") == true) goto L7;
        return true;
    }

    @Override // h84.e.c
    public final void c(String r100) {
        e r101 = this.f484126a;
        r101.c("serial_number", r100);
    }

    @Override // h84.e.c
    public final boolean b(String r100, String r101) {
        return c1.f(r100, r101);
    }

    @Override // h84.e.c
    public final String d(String r100, String r101, e r102) {
        return (String) r102.g(r100, r101, new g(r102));
    }
}
