package com.bytedance.awemeopen.apps.framework.card.view;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosPureVideoCardView$play$2$1$onFail$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $aid;
    final /* synthetic */ Exception $e;
    final /* synthetic */ int $errorCode;
    final /* synthetic */ d this$0;

    public AosPureVideoCardView$play$2$1$onFail$1(d r1, int r2, Exception r3, String r4) {
        this.this$0 = r1;
        this.$errorCode = r2;
        this.$e = r3;
        this.$aid = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1243invoke() {
        d r0 = this.this$0;
        int r1 = d.a;
        r0.getClass();
        Object[] r2 = new Object[1];
        StringBuilder r3 = new StringBuilder("api failed, errorCode:");
        r3.append(this.$errorCode);
        r3.append(", errMsg:");
        Exception r4 = this.$e;
        if (r4 == null) goto L5;
        String r5 = r4.getMessage();
    L6:
        r3.append(r5);
        r2[0] = r3.toString();
        AoLogger.b(null, r2);
        this.this$0.getClass();
        return;
    L5:
        r5 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1243invoke();
        return Unit.INSTANCE;
    }
}
