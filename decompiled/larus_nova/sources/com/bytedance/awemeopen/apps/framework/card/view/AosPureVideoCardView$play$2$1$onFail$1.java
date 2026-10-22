package com.bytedance.awemeopen.apps.framework.card.view;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosPureVideoCardView$play$2$1$onFail$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $aid;
    final /* synthetic */ Exception $e;
    final /* synthetic */ int $errorCode;
    final /* synthetic */ d this$0;

    public AosPureVideoCardView$play$2$1$onFail$1(d r100, int r101, Exception r102, String r103) {
        this.this$0 = r100;
        this.$errorCode = r101;
        this.$e = r102;
        this.$aid = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        d r100 = this.this$0;
        int r101 = d.f193908a;
        r100.getClass();
        Object[] r102 = new Object[1];
        StringBuilder r103 = new StringBuilder("api failed, errorCode:");
        r103.append(this.$errorCode);
        r103.append(", errMsg:");
        Exception r104 = this.$e;
        if (r104 == null) goto L5;
        String r105 = r104.getMessage();
    L6:
        r103.append(r105);
        r102[0] = r103.toString();
        AoLogger.b(null, r102);
        this.this$0.getClass();
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
