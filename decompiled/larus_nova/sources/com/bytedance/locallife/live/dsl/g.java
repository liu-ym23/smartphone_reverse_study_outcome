package com.bytedance.locallife.live.dsl;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class g<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f259458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f259459b;

    public g(String r100, long r101) {
        this.f259458a = r100;
        this.f259459b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        String r100 = UriProtector.getQueryParameter(UriProtector.parse(this.f259458a), "biz_tag");
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        if (r100.length() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        int r102 = qv6.e.f534905a;
        qv6.e.a("local_live_image_monitor", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(SystemClock.elapsedRealtime() - this.f259459b)), TuplesKt.to("biz_tag", r100)}), true, null);
        return;
    L12:
        return;
    L8:
        r101 = false;
        goto L9
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
