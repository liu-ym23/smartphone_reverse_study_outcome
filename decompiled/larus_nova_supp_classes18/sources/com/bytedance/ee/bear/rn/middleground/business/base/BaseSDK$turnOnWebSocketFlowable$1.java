package com.bytedance.ee.bear.rn.middleground.business.base;

import com.bytedance.ee.bear.rn.RnSyncManager;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import vl5.b;
import wl5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lio/reactivex/Flowable;", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseSDK$turnOnWebSocketFlowable$1 extends Lambda implements Function0<Flowable<String>> {
    final /* synthetic */ String $jsonString;

    public BaseSDK$turnOnWebSocketFlowable$1(String r1) {
        this.$jsonString = r1;
        super(0);
    }

    public final Flowable<String> invoke() {
        RnSyncManager r0 = RnSyncManager.a;
        String r1 = this.$jsonString;
        Intrinsics.checkNotNullParameter(r1, "message");
        f r2 = RnSyncManager.j;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.c(new b(), r1, 4000);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m477invoke() {
        return invoke();
    }
}
