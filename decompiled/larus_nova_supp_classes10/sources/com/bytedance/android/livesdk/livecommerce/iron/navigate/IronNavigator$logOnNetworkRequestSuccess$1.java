package com.bytedance.android.livesdk.livecommerce.iron.navigate;

import cl.d;
import com.bytedance.android.ec.sdk.helper.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 4, 3})
final class IronNavigator$logOnNetworkRequestSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $path;
    final /* synthetic */ Object $responseRawData;

    public IronNavigator$logOnNetworkRequestSuccess$1(String r1, Object r2) {
        this.$path = r1;
        this.$responseRawData = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m789invoke() {
        d r0 = k.a();
        if (r0 == null) goto L6;
        new Pair(this.$path, this.$responseRawData);
        r0.j("response");
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m789invoke();
        return Unit.INSTANCE;
    }
}
