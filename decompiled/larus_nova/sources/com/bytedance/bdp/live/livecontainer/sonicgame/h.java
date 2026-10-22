package com.bytedance.bdp.live.livecontainer.sonicgame;

import android.os.Bundle;
import com.bytedance.bdp.bdpbase.core.BdpError;
import com.bytedance.bdp.bdpbase.core.IBdpAppInstance;
import com.bytedance.bdp.bdpbase.core.container.BdpAppContainer;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.hostmethod.BdpHostMethodService;
import java.util.Map;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements na4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f201522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBdpAppInstance f201523b;

    @Override // na4.b
    public final void d() {
        Map<String, Object> r100 = ab4.a.f2473a;
        String r101 = this.f201522a;
        ab4.a.f2473a.remove(r101);
    }

    @Override // na4.b
    public final void destroy() {
        this.f201523b.finish();
        BdpAppContainer r100 = this.f201523b.getAppContainer();
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // na4.b
    public final void pause() {
        BdpAppContainer r100 = this.f201523b.getAppContainer();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f201088a != BdpAppContainer.StateEvent.ON_DESTROY) goto L7;
        new BdpError(-1, "can not dispatch pause on destroyed instance");
        return;
    L7:
        r100.b(BdpAppContainer.StateEvent.ON_PAUSE);
    }

    @Override // na4.b
    public final void resume() {
        BdpAppContainer r100 = this.f201523b.getAppContainer();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f201088a != BdpAppContainer.StateEvent.ON_DESTROY) goto L7;
        new BdpError(-1, "can not dispatch pause on destroyed BdpAppContainer");
        return;
    L7:
        r100.b(BdpAppContainer.StateEvent.ON_RESUME);
    }

    @Override // na4.b
    public final void c(JSONObject r100) {
        Map<String, Object> r101 = ab4.a.f2473a;
        ((BdpHostMethodService) BdpManager.getInst().getService(BdpHostMethodService.class)).O();
    }

    public final void e(t10.a r100) {
        Map<String, Object> r101 = ab4.a.f2473a;
        String r102 = this.f201522a;
        Map<String, Object> r103 = ab4.a.f2473a;
        if (r103.containsKey(r102) == true) goto L7;
        r103.put(r102, r100);
        return;
    }

    public h(String r100, IBdpAppInstance r101) {
        this.f201522a = r100;
        this.f201523b = r101;
    }

    @Override // na4.b
    public final Bundle a(String r100, Bundle r101) {
        return this.f201523b.executeCommand(r100, r101);
    }

    @Override // na4.b
    public final void b(Bundle r100, Function3 r101) {
        this.f201523b.executeCommandAsync("command_sonic_performance_timing", r100, new g(r101));
    }
}
