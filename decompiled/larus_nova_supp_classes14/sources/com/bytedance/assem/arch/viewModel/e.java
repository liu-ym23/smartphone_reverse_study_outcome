package com.bytedance.assem.arch.viewModel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import com.bytedance.assem.arch.extensions.HostInjector;
import com.bytedance.tiktok.proxy.a;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface e<RECEIVER extends com.bytedance.tiktok.proxy.a> {

    public static final class a {
        public static void b(e r3, RenderStateVM r4, Function2 r5) {
            boolean r0 = r4.getUsedInReusedScene();
            i r1 = new i();
            r1.a = !r0;
            r1.b = true;
            r3.vT(r4, r1, null, r5);
        }

        public static void a(final e r10, final RenderStateVM r11, final i r12, final Function1 r13, final Function2 r14) {
            if (r11.getUsedInReusedScene() == false) goto L13;
            final com.bytedance.tiktok.proxy.c<RECEIVER> r3 = r10.pF();
            r10.NY().hashCode();
            r12.getClass();
            f r0 = r11.getVmDispatcher();
            LifecycleOwner r9 = r10.NY().aM();
            boolean r2 = r11.getUsedInReusedScene();
            boolean r4 = r11.isHolderVM();
            if (r12.b == true) goto L10;
            if (r2 == false) goto L8;
            boolean r5 = false;
        L9:
            r12.a = r5;
            r12.b = true;
            goto L10
        L8:
            r10.F60();
            r5 = true;
        L10:
            if (r4 == false) goto L12;
            Lazy r1 = HostInjector.a;
        L12:
            Function1<Object, Unit> r6 = new IConfigurableVMSubscriber$subscribe$$inlined$let$lambda$1(r3, r10, r11, r12, r13, r14);
            IVMDispatcher$subscribeInternal$1 r15 = IVMDispatcher$subscribeInternal$1.INSTANCE;
            r0.d(r9, r12, r13, r6);
            return;
        L13:
            LifecycleOwner r7 = r10.Tm();
            if (r7 != null) goto L16;
        L21:
            r7 = r10.fr();
        L22:
            f r8 = r11.getVmDispatcher();
            if (r7 != null) goto L26;
            r7 = r10.NY().aM();
        L26:
            boolean r16 = r11.isHolderVM();
            if (r12.b == true) goto L29;
            r10.F60();
            r12.a = true;
            r12.b = true;
        L29:
            if (r16 == false) goto L32;
            Lazy r17 = HostInjector.a;
        L32:
            if (r10.dh() == null) goto L34;
            new IConfigurableVMSubscriber$getActiveFetcher$1(r10);
        L35:
            r8.d(r7, r12, r13, new IConfigurableVMSubscriber$subscribe$2(r10, r14));
            return;
        L34:
            IConfigurableVMSubscriber$getActiveFetcher$2 r18 = IConfigurableVMSubscriber$getActiveFetcher$2.INSTANCE;
            goto L35
        L16:
            if (r11.getUseOwnerLifecycle() == true) goto L19;
            r7 = null;
        L19:
            if (r7 == null) goto L21;
            goto L21
        }
    }

    void F60();

    com.bytedance.tiktok.proxy.b NY();

    LifecycleOwner Tm();

    RECEIVER dh();

    LifecycleOwner fr();

    com.bytedance.tiktok.proxy.c<RECEIVER> pF();

    void vT(RenderStateVM r1, i r2, Function1 r3, Function2 r4);
}
