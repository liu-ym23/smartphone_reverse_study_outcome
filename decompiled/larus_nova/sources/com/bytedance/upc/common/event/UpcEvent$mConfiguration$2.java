package com.bytedance.upc.common.event;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.upc.a;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/upc/a;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/upc/a;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class UpcEvent$mConfiguration$2 extends Lambda implements Function0<a> {
    public static final UpcEvent$mConfiguration$2 INSTANCE = null;

    static {
        INSTANCE = new UpcEvent$mConfiguration$2();
    }

    public UpcEvent$mConfiguration$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
