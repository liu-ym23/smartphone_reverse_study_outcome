package uy5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f552136a;

    public final void b() throws Throwable {
        this.f552136a.e();
    }

    public final void finalize() throws Throwable {
        super.finalize();
        GeckoLogger.d("gecko loader finalize lock");
        b();
    }

    public final String a(String r100) throws Throwable {
        d r101 = this.f552136a;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        a r102 = r101.b(r100.trim());
        b r103 = r102.b(true, r102.f552128c);
        String r104 = r100.substring(r102.f552128c.length() + 1);
        return r103.a(r103.f552133a, r104).getAbsolutePath();
    L7:
        throw new RuntimeException("relativePath is empty");
    }

    public c(Context r100, String r101) {
        if (r100 == null) goto L14;
        if (TextUtils.isEmpty(r101) == true) goto L12;
        AtomicBoolean r102 = GlobalManager.f250632a;
        String r103 = GlobalManager.b(r101);
        if (TextUtils.isEmpty(r103) == false) goto L9;
        this.f552136a = new d(r100, r101, new PolarisFileWrapper(r100.getFilesDir(), GeckoClient.GECKO_ROOT_DIR));
        return;
    L9:
        this.f552136a = new d(r100, r101, new PolarisFileWrapper(r103));
        return;
    L12:
        throw new RuntimeException("access key is empty");
    L14:
        throw new RuntimeException("context is null");
    }

    public c(Context r100, String r101, PolarisFileWrapper r102) {
        if (r100 == null) goto L11;
        if (TextUtils.isEmpty(r101) == true) goto L9;
        this.f552136a = new d(r100, r101, r102);
        return;
    L9:
        throw new RuntimeException("access key is empty");
    L11:
        throw new RuntimeException("context is null");
    }
}
