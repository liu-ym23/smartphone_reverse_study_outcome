package com.larus.platform.api;

import com.bytedance.applet.aibridge.AIBridgePreloadMediaResourceMethod;
import com.larus.platform.constants.media.DataLoaderPreloadPriority;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public interface z3 {

    public static final class a {
        public static /* synthetic */ void a(z3 r100, com.larus.video.impl.sdk.a r110, String r111, long r112, k0 r113, int r114) {
            if ((r114 & 2) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r114 & 4) == 0) goto L9;
            r112 = LynxResourceModule.DEFAULT_MEDIA_SIZE;
        L9:
            long r102 = r112;
            if ((r114 & 8) == 0) goto L12;
            DataLoaderPreloadPriority r103 = DataLoaderPreloadPriority.DEFAULT;
        L14:
            if ((r114 & 16) == 0) goto L16;
            k0 r104 = null;
        L17:
            r100.l(r110, r101, r102, r103, r104);
            return;
        L16:
            r104 = r113;
            goto L17
        L12:
            r103 = null;
            goto L14
        L5:
            r101 = r111;
            goto L7
        }
    }

    int e(com.larus.video.impl.sdk.a r100);

    void f(String r100, l4 r101);

    yq9.a g(String r100);

    Object h(String r100, String r101, Continuation<? super String> r102);

    void i(yq9.d r100, AIBridgePreloadMediaResourceMethod.b r101);

    void j();

    void k(Function1<? super IVideoController, Boolean> r100);

    void l(com.larus.video.impl.sdk.a r100, String r101, long r102, DataLoaderPreloadPriority r103, k0 r104);

    com.larus.video.impl.sdk.o m(String r100, boolean r101, Integer r102);

    void n(Function1<? super IVideoController, Boolean> r100);

    void o();

    void switchToCellularNetwork();

    void switchToDefaultNetwork();
}
