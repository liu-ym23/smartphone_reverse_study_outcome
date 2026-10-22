package com.obric.assistant.dora;

import com.bytedance.router.SmartRouter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraBleProtocolService f389104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f389105b;

    public /* synthetic */ a(DoraBleProtocolService r100, i r101) {
        this.f389104a = r100;
        this.f389105b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraBleProtocolService r100 = this.f389104a;
        i r101 = this.f389105b;
        int r102 = DoraBleProtocolService.f389044j;
        com.bytedance.router.i r103 = SmartRouter.buildRoute(r100, "//flow/dora/bind_device");
        r103.f267554c.addFlags(335544320);
        r103.f267554c.putExtra("key_dora_onboarding_auto_connect", true);
        String r104 = "";
        if (r101.f389122c == false) goto L9;
        r103.j(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID, "4096");
        r103.j("product_id", "-1");
        String r105 = r101.f389121b.f389031a;
        if (r105 == null) goto L8;
        r104 = r105;
    L8:
        r103.j("extra_mac", r104);
        r103.h("extra_vendor_id", 4096);
        r103.j("extra_sku", Integer.toString(r101.f389121b.f389038h, CharsKt.checkRadix(16)));
    L26:
        r103.d();
        FLogger.f375446a.i("DoraBleProtocolService", "openOnboarding: route opened, requestId=" + r101.f389120a);
        return;
    L9:
        DoraBleDevice r106 = r101.f389121b;
        int r107 = d.a(r106.f389042l, r106.getType());
        r103.j(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID, "1");
        r103.j("product_id", String.valueOf(r107));
        String r108 = r101.f389121b.f389032b;
        if (r108 != null) goto L12;
        r108 = "";
    L12:
        r103.j("key_dora_onboarding_device_name", r108);
        String r109 = r101.f389121b.f389031a;
        if (r109 != null) goto L15;
        r109 = "";
    L15:
        r103.j("key_dora_onboarding_device_mac", r109);
        String r110 = r101.f389121b.f389037g;
        if (r110 == null) goto L19;
        r104 = r110;
    L19:
        r103.j("key_dora_onboarding_device_sn", r104);
        r103.h("key_dora_onboarding_device_sku", r101.f389121b.f389038h);
        int[] r111 = r101.f389121b.f389034d;
        if (r111 != null) goto L22;
        r111 = new int[]{-1, -1, -1};
    L22:
        r103.f267554c.putExtra("key_dora_onboarding_device_battery", r111);
        int[] r112 = r101.f389121b.f389033c;
        if (r112 != null) goto L25;
        r112 = new int[]{-1, -1, -1};
    L25:
        r103.f267554c.putExtra("key_dora_onboarding_device_charge", r112);
        goto L26
    }
}
