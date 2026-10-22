package qv5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import uy5.d;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f534896a;

    @Override // qv5.c
    public final String a() {
        return this.f534896a.f552139c;
    }

    @Override // qv5.c
    public final Map<String, Long> b() {
        return this.f534896a.c();
    }

    public final void finalize() throws Throwable {
        super.finalize();
        this.f534896a.e();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        GeckoLogger.w("finalize:", e);
    }

    @Override // qv5.c
    public final InputStream getInputStream(String r100) throws Throwable {
        GeckoLogger.d("WebOffline-falcon", "GeckoResLoader ready to load, file:" + r100);
        return this.f534896a.d(r100);
    }

    public b(Context r100, String r101, File r102) {
        if (r100 == null) goto L14;
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (r102 == null) goto L10;
        this.f534896a = new d(r100, r101, r102);
        return;
    L10:
        throw new RuntimeException("resRootDir is null");
    L12:
        throw new RuntimeException("access key is empty");
    L14:
        throw new RuntimeException("context is null");
    }
}
