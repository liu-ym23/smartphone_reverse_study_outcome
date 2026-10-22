package com.ss.ugc.effectplatform.preload;

import bytekn.foundation.logger.Logger;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.util.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f457454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f457455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f457456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c0.b f457457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EffectConfig f457458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f457459f;

    public final void a() {
        long r100 = b0.a.a() - this.f457454a;
        Logger r101 = Logger.INSTANCE;
        StringBuilder r102 = new StringBuilder("[预加载][下载][全部][Mob][");
        r102.append(this.f457459f);
        r102.append("][");
        Object[] r103 = ((ArrayList) this.f457456c).toArray(new String[0]);
        if (r103 == null) goto L13;
        r102.append(s.a((String[]) r103));
        r102.append("][耗时:");
        r102.append(r100);
        r102.append("][大小:");
        r102.append(this.f457455b);
        r102.append(']');
        r101.w("JKL", r102.toString());
        klc.a r104 = this.f457458e.f457176v.f1239a;
        if (r104 == null) goto L11;
        String r105 = this.f457459f;
        Object[] r106 = ((ArrayList) this.f457456c).toArray(new String[0]);
        if (r106 == null) goto L10;
        r104.monitorStatusRate("resource_provider_preload", 0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("busi_key", r105), TuplesKt.to("resource_key_list", s.a((String[]) r106)), TuplesKt.to(ImageNetworkRequestsMonitor.KEY_IMAGE_LOAD, Long.valueOf(r100)), TuplesKt.to("size", Long.valueOf(this.f457455b))}));
        return;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L11:
        return;
    L13:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public e(EffectConfig r100, String r101) {
        this.f457458e = r100;
        this.f457459f = r101;
        this.f457454a = b0.a.a();
        this.f457456c = new ArrayList();
    }
}
