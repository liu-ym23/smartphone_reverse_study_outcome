package qv5;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f534893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager f534894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f534895c;

    @Override // qv5.c
    public final String a() {
        return "asset:///" + this.f534893a;
    }

    @Override // qv5.c
    public final Map<String, Long> b() {
        return Collections.emptyMap();
    }

    @Override // qv5.c
    public final InputStream getInputStream(String r100) throws Exception {
        if (this.f534895c.get() == true) goto L7;
        GeckoLogger.d("WebOffline-falcon", "AssetResLoader ready to load, file:" + r100);
        return this.f534894b.open(new PolarisFileWrapper(this.f534893a, r100).getPath());
    L7:
        throw new RuntimeException("released!");
    }

    public a(Context r100, PolarisFileWrapper r101) {
        this.f534895c = new AtomicBoolean(false);
        this.f534893a = r101;
        this.f534894b = r100.getAssets();
    }
}
