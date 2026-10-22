package com.bytedance.bdp.appbase.adsite.contextservice;

import com.bytedance.bdp.appbase.base.event.f;
import com.bytedance.bdp.appbase.base.ipc.BdpIpcService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/base/event/f;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/bdp/appbase/base/event/f;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AdSiteService$callHostEvent$2 extends Lambda implements Function0<f> {
    public static final AdSiteService$callHostEvent$2 INSTANCE = null;

    static {
        INSTANCE = new AdSiteService$callHostEvent$2();
    }

    public AdSiteService$callHostEvent$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final f invoke() {
        return (f) ((BdpIpcService) BdpManager.getInst().getService(BdpIpcService.class)).getMainBdpIPC().f(f.class);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ f invoke() {
        return invoke();
    }
}
