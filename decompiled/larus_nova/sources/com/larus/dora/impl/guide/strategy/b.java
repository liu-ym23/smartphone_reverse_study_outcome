package com.larus.dora.impl.guide.strategy;

import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.util.b0;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f335987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f335988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f335989c;

    public static final class a {
    }

    static {
    }

    public final Object a() {
        if (this.f335989c == false) goto L18;
        g49.d.d("ChannelStrategy", "channel strategy blocked: already hit, key=" + this.f335987a);
        return Boxing.boxBoolean(false);
    L18:
        b0.f338123a.getClass();     // Catch: Exception -> L8
        boolean r100 = b0.j().getBoolean(this.f335987a, false);     // Catch: Exception -> L8
    L10:
        if (r100 == false) goto L13;
        g49.d.d("ChannelStrategy", "channel strategy blocked: already consumed, key=" + this.f335987a);
        return Boxing.boxBoolean(false);
    L13:
        List<String> r101 = this.f335988b;
        AppHost.Companion r102 = AppHost.f326268a;
        boolean r103 = r101.contains(r102.getBuildChannel());
        g49.d.d("ChannelStrategy", "channel check: channel=" + r102.getBuildChannel() + ", targets=" + this.f335988b + ", allowed=" + r103);
        if (r103 == false) goto L17;
        this.f335989c = true;
        g49.d.d("ChannelStrategy", "channel strategy hit set to true, key=" + this.f335987a);
    L17:
        return Boxing.boxBoolean(r103);
    L8:
        e = move-exception;
        g49.d.c("ChannelStrategy", "read consumed flag failed for key=" + this.f335987a + ", error=" + e.getMessage(), e);
        r100 = false;
        goto L10
    }

    public final Unit b() {
    L8:
        e = move-exception;
        g49.d.c("ChannelStrategy", "markAsShown failed for key=" + this.f335987a + ", error=" + e.getMessage(), e);
    L11:
        return Unit.INSTANCE;
    L4:
        if (this.f335989c == false) goto L6;
        b0.f338123a.getClass();     // Catch: Exception -> L8
        b0.j().storeBoolean(this.f335987a, true);     // Catch: Exception -> L8
        g49.d.d("ChannelStrategy", "markAsShown success, key=" + this.f335987a);     // Catch: Exception -> L8
    L12:
        goto L11
    L6:
        g49.d.d("ChannelStrategy", "markAsShown skipped: not consumed, key=" + this.f335987a);     // Catch: Exception -> L8
        goto L12
    }

    public b(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "kevaKey");
        Intrinsics.checkNotNullParameter(r101, "targetChannels");
        this.f335987a = r100;
        this.f335988b = r101;
    }
}
