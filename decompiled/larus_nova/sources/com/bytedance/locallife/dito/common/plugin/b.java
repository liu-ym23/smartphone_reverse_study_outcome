package com.bytedance.locallife.dito.common.plugin;

import android.net.Uri;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f257550c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f257551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CubeConfig f257552b;

    public static final class a {
    }

    static {
    }

    public b(String r100, Uri r101, CubeConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "originUrl");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "cubeConfig");
        Intrinsics.checkNotNullParameter("config", "host");
        this.f257551a = r101;
        this.f257552b = r102;
    }
}
