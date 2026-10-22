package nv4;

import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.g;
import okhttp3.h;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements h {
    public a() {
    }

    @Override // okhttp3.h
    public final List<g> a(HttpUrl r100) {
        tt5.a.d("DocsCookieJarProvider", "not setup CookieJarFactory");
        return new ArrayList();
    }

    @Override // okhttp3.h
    public final void b(HttpUrl r100, List<g> r101) {
        tt5.a.d("DocsCookieJarProvider", "not setup CookieJarFactory");
    }
}
