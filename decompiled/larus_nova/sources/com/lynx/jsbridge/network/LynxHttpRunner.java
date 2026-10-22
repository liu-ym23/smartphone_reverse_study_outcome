package com.lynx.jsbridge.network;

import com.lynx.react.bridge.Callback;
import com.lynx.tasm.service.ILynxHttpService;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import i8a.i;
import i8a.n;

/* JADX INFO: loaded from: classes32.dex */
public class LynxHttpRunner {

    public static class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callback f381379a;

        public a(Callback r100) {
            this.f381379a = r100;
        }

        @Override // i8a.i
        public final void a(HttpResponse r100) {
            this.f381379a.invoke(new Object[]{r100});
        }
    }

    public LynxHttpRunner() {
    }

    public static boolean isHttpServiceRegistered() {
        if (((ILynxHttpService) n.c().a(ILynxHttpService.class)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void request(HttpRequest r100, Callback r101) {
        ILynxHttpService r102 = (ILynxHttpService) n.c().a(ILynxHttpService.class);
        if (r102 != null) goto L6;
        HttpResponse r103 = new HttpResponse();
        r103.f381373a = TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK;
        r103.f381374b = "Lynx Http Service not registered";
        r101.invoke(new Object[]{r103});
        return;
    L6:
        r102.request(r100, new a(r101));
    }
}
