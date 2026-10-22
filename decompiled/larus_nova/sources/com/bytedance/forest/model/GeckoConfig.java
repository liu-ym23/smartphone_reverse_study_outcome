package com.bytedance.forest.model;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class GeckoConfig {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f244238i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f244239j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f244240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f244241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f244242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f244243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f244244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f244245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f244246g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f244247h;

    public static final class a {
        public a() {
        }
    }

    static {
        f244239j = new a();
        f244238i = LazyKt.lazy(GeckoConfig$Companion$configByRegistry$2.INSTANCE);
    }

    public final PolarisFileWrapper a(Context r100) {
        if (this.f244247h == true) goto L6;
        return new PolarisFileWrapper(this.f244242c);
    L6:
        if (this.f244240a != null) goto L14;
        this.f244240a = r100.getFilesDir();
    L14:
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f244240a, this.f244242c);     // Catch: Exception -> L12
        if (r101.exists() == true) goto L17;
        r101.mkdirs();     // Catch: Exception -> L12
        return r101;
    L17:
        return r101;
    L13:
        return new PolarisFileWrapper(this.f244242c);
    }

    public /* synthetic */ GeckoConfig(String r110, String r111, long r112, String r113, String r114, String r115) {
        this(r110, r111, r112, r113, r114, r115, true);
    }

    public GeckoConfig(String r100, String r101, long r102, String r103, String r104, String r105, boolean r106) {
        this.f244241b = r100;
        this.f244242c = r101;
        this.f244243d = r102;
        this.f244244e = r103;
        this.f244245f = r104;
        this.f244246g = r105;
        this.f244247h = r106;
    }
}
