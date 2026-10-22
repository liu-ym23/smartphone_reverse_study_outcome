package com.bytedance.ruler;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/express/util/a$a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/express/util/a$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class RulerSDK$init$1$log$1 extends Lambda implements Function1<com.bytedance.express.util.a.C3487a, Unit> {
    final /* synthetic */ String $msg;
    final /* synthetic */ String $tag;
    final /* synthetic */ Throwable $throwable;

    public RulerSDK$init$1$log$1(String r100, String r101, Throwable r102) {
        this.$tag = r100;
        this.$msg = r101;
        this.$throwable = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.express.util.a.C3487a r100) {
        r100.f243213b = this.$tag;
        r100.f243212a = this.$msg;
        r100.f243214c = this.$throwable;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.express.util.a.C3487a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
