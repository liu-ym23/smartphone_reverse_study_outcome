package com.bytedance.assem.arch.viewModel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import com.bytedance.assem.arch.extensions.HostInjector;
import com.bytedance.tiktok.proxy.a;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public interface e<RECEIVER extends com.bytedance.tiktok.proxy.a> {

    public static final class a {
        public static void b(e r100, RenderStateVM r101, Function2 r102) {
            boolean r103 = r101.getUsedInReusedScene();
            i r104 = new i();
            r104.f193087a = !r103;
            r104.f193088b = true;
            r100.vT(r101, r104, null, r102);
        }

        public static void a(final e r110, final RenderStateVM r111, final i r112, final Function1 r113, final Function2 r114) {
            if (r111.getUsedInReusedScene() == false) goto L13;
            final com.bytedance.tiktok.proxy.c<RECEIVER> r100 = r110.pF();
            r110.NY().hashCode();
            r112.getClass();
            f<i5.g> r101 = r111.getVmDispatcher();
            LifecycleOwner r102 = r110.NY().aM();
            boolean r103 = r111.getUsedInReusedScene();
            boolean r104 = r111.isHolderVM();
            if (r112.f193088b == true) goto L10;
            if (r103 == false) goto L8;
            boolean r105 = false;
        L9:
            r112.f193087a = r105;
            r112.f193088b = true;
            goto L10
        L8:
            r110.F60();
            r105 = true;
        L10:
            if (r104 == false) goto L12;
            Lazy r106 = HostInjector.f192919a;
        L12:
            Function1<Object, Unit> r107 = new IConfigurableVMSubscriber$subscribe$$inlined$let$lambda$1(r100, r110, r111, r112, r113, r114);
            IVMDispatcher$subscribeInternal$1 r115 = IVMDispatcher$subscribeInternal$1.INSTANCE;
            r101.d(r102, r112, r113, r107);
            return;
        L13:
            LifecycleOwner r108 = r110.Tm();
            if (r108 != null) goto L16;
        L21:
            r108 = r110.fr();
        L22:
            f<i5.g> r109 = r111.getVmDispatcher();
            if (r108 != null) goto L26;
            r108 = r110.NY().aM();
        L26:
            boolean r116 = r111.isHolderVM();
            if (r112.f193088b == true) goto L29;
            r110.F60();
            r112.f193087a = true;
            r112.f193088b = true;
        L29:
            if (r116 == false) goto L32;
            Lazy r117 = HostInjector.f192919a;
        L32:
            if (r110.dh() == null) goto L34;
            new IConfigurableVMSubscriber$getActiveFetcher$1(r110);
        L35:
            r109.d(r108, r112, r113, new IConfigurableVMSubscriber$subscribe$2(r110, r114));
            return;
        L34:
            IConfigurableVMSubscriber$getActiveFetcher$2 r118 = IConfigurableVMSubscriber$getActiveFetcher$2.INSTANCE;
            goto L35
        L16:
            if (r111.getUseOwnerLifecycle() == true) goto L19;
            r108 = null;
        L19:
            if (r108 == null) goto L21;
            goto L21
        }
    }

    void F60();

    com.bytedance.tiktok.proxy.b NY();

    LifecycleOwner Tm();

    RECEIVER dh();

    LifecycleOwner fr();

    com.bytedance.tiktok.proxy.c<RECEIVER> pF();

    void vT(RenderStateVM r100, i r101, Function1 r102, Function2 r103);
}
