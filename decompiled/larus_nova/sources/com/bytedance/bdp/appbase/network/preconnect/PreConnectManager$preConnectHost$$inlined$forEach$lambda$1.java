package com.bytedance.bdp.appbase.network.preconnect;

import android.os.SystemClock;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.network.BdpFromSource;
import com.bytedance.bdp.appbase.network.wrapper.BdpHostCallWrapper;
import com.bytedance.bdp.serviceapi.defaults.network.BdpNetworkService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/bdp/appbase/network/preconnect/PreConnectManager$preConnectHost$1$1"}, k = 3, mv = {1, 1, 18})
final class PreConnectManager$preConnectHost$$inlined$forEach$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BdpAppContext $appContext$inlined;
    final /* synthetic */ BdpFromSource $from$inlined;
    final /* synthetic */ a.b $listener$inlined;
    final /* synthetic */ BdpNetworkService $networkService$inlined;
    final /* synthetic */ String $url;

    public PreConnectManager$preConnectHost$$inlined$forEach$lambda$1(String r100, BdpFromSource r101, BdpNetworkService r102, BdpAppContext r103, a.b r104) {
        this.$url = r100;
        this.$from$inlined = r101;
        this.$networkService$inlined = r102;
        this.$appContext$inlined = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SystemClock.elapsedRealtime();
        BdpHostCallWrapper.f200935e.getClass();     // Catch: Throwable -> L11
        if (((Boolean) BdpHostCallWrapper.f200934d.getValue()).booleanValue() == false) goto L9;
        BdpFromSource r100 = this.$from$inlined;     // Catch: Throwable -> L11
        if (r100 == BdpFromSource.preconnect_sdk) goto L9;
        BdpNetworkService r101 = this.$networkService$inlined;     // Catch: Throwable -> L11
        a.C2897a r102 = a.f200905a;     // Catch: Throwable -> L11
        a.b(this.$appContext$inlined, r100);     // Catch: Throwable -> L11
        r101.t1();     // Catch: Throwable -> L11
    L12:
        return;
    L9:
        this.$networkService$inlined.G0();     // Catch: Throwable -> L11
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
