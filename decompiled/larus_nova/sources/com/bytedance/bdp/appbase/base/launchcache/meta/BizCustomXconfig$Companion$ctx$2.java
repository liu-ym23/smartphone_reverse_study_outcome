package com.bytedance.bdp.appbase.base.launchcache.meta;

import android.app.Application;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/app/Application;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
public final class BizCustomXconfig$Companion$ctx$2 extends Lambda implements Function0<Application> {
    public static final BizCustomXconfig$Companion$ctx$2 INSTANCE = null;

    static {
        INSTANCE = new BizCustomXconfig$Companion$ctx$2();
    }

    public BizCustomXconfig$Companion$ctx$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Application invoke() {
        return ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Application invoke() {
        return invoke();
    }
}
