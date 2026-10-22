package com.bytedance.locallife.adapter.impl.host.poi;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;

/* JADX INFO: loaded from: classes20.dex */
public final class LifeSaasGeckoCdn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f256483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f256484b;

    public LifeSaasGeckoCdn() {
        this.f256483a = LazyKt.lazy(LifeSaasGeckoCdn$saasCdnUrlMappings$2.INSTANCE);
        this.f256484b = LazyKt.lazy(LifeSaasGeckoCdn$saasUrlReplaceChannels$2.INSTANCE);
    }

    public static Pair a(Uri r100) {
        String[] r101 = {"a_surl", "surl", "url"};
        int r102 = 0;
    L3:
        String r103 = null;
        if (r102 >= 3) goto L17;
        String r104 = r101[r102];
        r103 = UriProtector.getQueryParameter(r100, r104);     // Catch: Throwable -> L8
    L10:
        if (ap6.a.b(r103) == true) goto L12;
        r102 = r102 + 1;
        goto L3
    L12:
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        return new Pair(r104, r103);
    L17:
        return null;
    }
}
