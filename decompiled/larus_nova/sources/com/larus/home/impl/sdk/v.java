package com.larus.home.impl.sdk;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.larus.e_commerce.api.ECNotifyBinderDialogType;
import com.larus.e_commerce.api.IECommerceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class v implements com.larus.platform.api.l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f346251a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f346252a = null;

        static {
            int[] r100 = new int[ECNotifyBinderDialogType.values().length];
            r100[ECNotifyBinderDialogType.CheckNeedBinder.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ECNotifyBinderDialogType.NotifyBinder.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f346252a = r100;
        }
    }

    static {
        f346251a = new v();
    }

    public v() {
    }

    @Override // com.larus.platform.api.l2
    public final int getVersion() {
        IECommerceService r100 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getVersion();
    }

    @Override // com.larus.platform.api.l2
    public final boolean i() {
        IECommerceService r100 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.i();
    }

    @Override // com.larus.platform.api.l2
    public final void b(String r100, String r101) {
        IECommerceService r102 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.l2
    public final boolean c(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IECommerceService r102 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.c(r100, r101);
    }

    @Override // com.larus.platform.api.l2
    public final void f(String r100, uq9.l r101) {
        Intrinsics.checkNotNullParameter(r100, "initSource");
        Intrinsics.checkNotNullParameter(r101, "callBack");
        IECommerceService r102 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r102 == null) goto L6;
        r102.x(r100, new w(r101));
        return;
    }

    @Override // com.larus.platform.api.l2
    public final boolean h(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        IECommerceService r102 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.h(r100, r101);
    }

    @Override // com.larus.platform.api.l2
    public final void a(String r100, String r101, String r102) {
        IECommerceService r103 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.l2
    public final void e(uq9.d r110, final Function3<? super String, ? super String, ? super com.larus.platform.model.ecommerce.ECNotifyBinderDialogType, Unit> r111, final Function1<? super uq9.e, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        IECommerceService r100 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r100 == null) goto L10;
        com.larus.e_commerce.api.b r101 = new com.larus.e_commerce.api.b(r110.getActivity(), r110.f551335b, r110.f551336c, r110.f551337d, r110.f551338e, r110.f551339f);
        if (r111 != null) goto L7;
        Function3<? super String, ? super String, ? super ECNotifyBinderDialogType, Unit> r113 = null;
    L8:
        r100.r(r101, r113, new u(r112));
        return;
    L7:
        r113 = new t(r111);
        goto L8
    }

    @Override // com.larus.platform.api.l2
    public final void d(FragmentActivity r100, Integer r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        IECommerceService r104 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r104 == null) goto L6;
        r104.d(r100, r101, r102, r103);
        return;
    }
}
