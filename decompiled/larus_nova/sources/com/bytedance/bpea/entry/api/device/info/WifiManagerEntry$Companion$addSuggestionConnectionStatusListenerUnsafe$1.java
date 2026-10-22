package com.bytedance.bpea.entry.api.device.info;

import android.net.wifi.WifiManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class WifiManagerEntry$Companion$addSuggestionConnectionStatusListenerUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Executor $executor;
    final /* synthetic */ WifiManager.SuggestionConnectionStatusListener $listener;
    final /* synthetic */ WifiManager $this_addSuggestionConnectionStatusListenerUnsafe;

    public WifiManagerEntry$Companion$addSuggestionConnectionStatusListenerUnsafe$1(WifiManager r100, Executor r101, WifiManager.SuggestionConnectionStatusListener r102) {
        this.$this_addSuggestionConnectionStatusListenerUnsafe = r100;
        this.$executor = r101;
        this.$listener = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WifiManager r100 = this.$this_addSuggestionConnectionStatusListenerUnsafe;
        Executor r110 = this.$executor;
        WifiManager.SuggestionConnectionStatusListener r111 = this.$listener;
        ArrayList r112 = new ArrayList();
        Object[] r113 = {r110, r111};
        f06.b r114 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102303);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r115 = r105;
        int r210 = r104;
        f06.a[] r211 = r103;
        f06.d r107 = r106.preInvoke(102303, "android/net/wifi/WifiManager", "addSuggestionConnectionStatusListener", r100, r113, "void", r114);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r112.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == true) goto L27;
        r100.addSuggestionConnectionStatusListener(r110, r111);
        return;
    L27:
        return;
    L14:
        r105 = r115 + 1;
        r104 = r210;
        r103 = r211;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
