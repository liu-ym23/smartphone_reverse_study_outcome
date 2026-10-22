package com.ivy.ivykit.plugin.impl.applet;

import android.os.FileObserver;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.bullet.service.base.d1;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f278367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, FileObserver> f278368b = null;

    static {
        f278368b = new ConcurrentHashMap();
    }

    public static void a(d1 r100, d1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        r100.f247859b = r101.f247859b;
        r100.f247860c = r101.getType();
        r100.f247861d = r101.f247861d;
        r100.f247862e = r101.f247862e;
        r100.f247863f = r101.f247863f;
        r100.f247864g = r101.f247864g;
        r100.D = r101.D;
        r100.f247866i = r101.f247866i;
        r100.f247870m = r101.f247870m;
        r100.f247871n = r101.f247871n;
        String r102 = r101.f247877t;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f247877t = r102;
        String r103 = r101.f247867j;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r100.f247867j = r103;
        r100.f247868k = r101.f247868k;
        String r104 = r101.f247881x;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r100.f247881x = r104;
        b26.d r105 = r101.A;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r100.A = r105;
        b26.d r106 = r101.f247883z;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r100.f247883z = r106;
    }
}
