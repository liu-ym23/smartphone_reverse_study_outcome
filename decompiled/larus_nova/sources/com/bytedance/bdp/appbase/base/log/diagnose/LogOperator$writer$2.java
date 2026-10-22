package com.bytedance.bdp.appbase.base.log.diagnose;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/bdp/appbase/base/log/diagnose/a;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/bdp/appbase/base/log/diagnose/a;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class LogOperator$writer$2 extends Lambda implements Function0<a> {
    public static final LogOperator$writer$2 INSTANCE = null;

    static {
        INSTANCE = new LogOperator$writer$2();
    }

    public LogOperator$writer$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        Lazy r100 = DiagnoseSettings.f200597c;
        ((Number) r100.getValue()).intValue();
        ((Number) r100.getValue()).intValue();
        return new a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
