package com.bytedance.awemeopen.infra.base.player;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f198743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f198744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, m> f198745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolarisFileWrapper f198746d;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f198745c = new LinkedHashMap();
        this.f198746d = new PolarisFileWrapper(y54.a.a().getCacheDir(), "video_thumb");
    }
}
