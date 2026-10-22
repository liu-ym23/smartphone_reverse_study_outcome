package com.bytedance.caijing.sdk.biz.common.api;

import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/caijing/sdk/infra/base/api/env/CJHostService;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CJByteSync$hostService$2 extends Lambda implements Function0<CJHostService> {
    public static final CJByteSync$hostService$2 INSTANCE = null;

    static {
        INSTANCE = new CJByteSync$hostService$2();
    }

    public CJByteSync$hostService$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CJHostService invoke() {
        ve4.a.f554342a.getClass();
        return (CJHostService) ve4.a.a(CJHostService.class);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CJHostService invoke() {
        return invoke();
    }
}
