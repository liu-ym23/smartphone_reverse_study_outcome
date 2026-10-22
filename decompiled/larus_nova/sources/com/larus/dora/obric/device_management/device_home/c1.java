package com.larus.dora.obric.device_management.device_home;

import android.content.Context;
import android.os.Bundle;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class c1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricDeviceHomeFragment f339195a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f339196a = null;

        static {
            int[] r100 = new int[DoraObricEnvironmentMemoryUiMessage.values().length];
            r100[DoraObricEnvironmentMemoryUiMessage.ENABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[DoraObricEnvironmentMemoryUiMessage.TEMPORARY_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[DoraObricEnvironmentMemoryUiMessage.UNAVAILABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[DoraObricEnvironmentMemoryUiMessage.NETWORK_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f339196a = r100;
        }
    }

    public c1(DoraObricDeviceHomeFragment r100) {
        this.f339195a = r100;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.larus.dora.obric.device_management.device_home.z0] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        i r102 = (i) r100;
        if ((r102 instanceof i.a) == false) goto L6;
        DoraObricDeviceHomeFragment r103 = this.f339195a;
        i.a r104 = (i.a) r102;
        String r105 = r104.f339259a;
        Bundle r106 = r104.f339260b;
        int r107 = DoraObricDeviceHomeFragment.R;
        r103.ka0(r105, r106);
    L41:
        return Unit.INSTANCE;
    L6:
        if ((r102 instanceof i.b) == false) goto L12;
        final DoraObricDeviceHomeFragment r108 = this.f339195a;
        i.b r109 = (i.b) r102;
        final String r110 = r109.f339261a;
        final long r111 = r109.f339262b;
        int r112 = DoraObricDeviceHomeFragment.R;
        r108.getClass();
        r108.f339039k = TuplesKt.to(r110, Long.valueOf(r111));
        if (com.larus.dora.obric.onboarding.m.a.a(com.larus.dora.obric.onboarding.m.f340884j, r108.requireContext(), r110, new z0(r108, r110, r111), 4) == true) goto L41;
        Bundle r113 = new Bundle();
        r113.putString("mac", r110);
        Unit r114 = Unit.INSTANCE;
        r108.ka0("//flow/dora/obric_g_env_observe", r113);
        goto L41
    L12:
        if ((r102 instanceof i.c) == false) goto L43;
        int r115 = l2.f339293a;
        DoraObricEnvironmentMemoryToastType r116 = ((i.c) r102).getType();
        Intrinsics.checkNotNullParameter(r116, "toastType");
        int r117 = l2.a.f339294a[r116.ordinal()];
        if (r117 == 1) goto L26;
        if (r117 == 2) goto L25;
        if (r117 == 3) goto L24;
        if (r117 != 4) goto L19;
        DoraObricEnvironmentMemoryUiMessage r118 = DoraObricEnvironmentMemoryUiMessage.NETWORK_ERROR;
    L27:
        if (r118 == null) goto L41;
        DoraObricDeviceHomeFragment r119 = this.f339195a;
        WeakReference<com.obric.oui.toast.f> r120 = DoraObricToastUtils.f340969a;
        Context r121 = r119.requireContext();
        int r122 = a.f339196a[r118.ordinal()];
        if (r122 == 1) goto L38;
        if (r122 == 2) goto L37;
        if (r122 == 3) goto L36;
        if (r122 != 4) goto L35;
        int r123 = R.string.larus_dora_obric_environment_memory_network_fail_cn;
    L39:
        Intrinsics.checkNotNullParameter(r121, PerfLog.PARAM_KEY_CONTEXT_ID);
        DoraObricToastUtils.c(r121, r121.getString(r123), null);
        goto L41
    L35:
        throw new NoWhenBranchMatchedException();
    L36:
        r123 = R.string.larus_dora_obric_environment_memory_unavailable_toast_cn;
        goto L39
    L37:
        r123 = R.string.larus_dora_obric_environment_memory_temporary_toast_cn;
        goto L39
    L38:
        r123 = R.string.larus_dora_obric_environment_memory_enabled_toast_cn;
        goto L39
    L19:
        if (r117 != 5) goto L22;
        r118 = null;
        goto L27
    L22:
        throw new NoWhenBranchMatchedException();
    L24:
        r118 = DoraObricEnvironmentMemoryUiMessage.UNAVAILABLE;
        goto L27
    L25:
        r118 = DoraObricEnvironmentMemoryUiMessage.TEMPORARY_OVERRIDE;
        goto L27
    L26:
        r118 = DoraObricEnvironmentMemoryUiMessage.ENABLED;
        goto L27
    L43:
        throw new NoWhenBranchMatchedException();
    }
}
