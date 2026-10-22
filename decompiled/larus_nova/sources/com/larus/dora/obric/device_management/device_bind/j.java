package com.larus.dora.obric.device_management.device_bind;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingDialogFragment;
import com.larus.dora.obric.device_v2.ObricDoraGOnboardingDialogFragmentV2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import v19.o5;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class j implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricDeviceBindFragment f339008a;

    public /* synthetic */ j(DoraObricDeviceBindFragment r100) {
        this.f339008a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        final DoraObricDeviceBindFragment r100 = this.f339008a;
        BottomSheetDialogFragment r101 = r100.f338940g;
        if (r101 != null) goto L58;
    L10:
        Integer r102 = r100.f338945l;
        boolean r103 = false;
        if (r102 == null) goto L13;
        int r104 = r102.intValue();
    L14:
        Bundle r105 = r100.getArguments();
        if (r105 != null) goto L17;
    L19:
        boolean r106 = false;
    L21:
        if (r104 != ProductNameType.DORA_G.f204375id) goto L24;
        if (r106 == true) goto L24;
        r103 = true;
    L24:
        g49.d.d("DoraObricDeviceBindFragment", "launchOnboarding: productId=" + r104 + ", autoConnect=" + r106 + ", scanAllGlassesProducts=" + r103);
        if (r104 != ProductNameType.DORA_LITE.f204375id) goto L28;
        BottomSheetDialogFragment r107 = new DoraLiteOnboardingDialogFragment();
    L31:
        if (r107 == null) goto L53;
        Bundle r108 = r100.getArguments();
        if (r108 != null) goto L35;
        r108 = new Bundle();
    L35:
        Bundle r109 = new Bundle(r108);
        r109.putBoolean("key_dora_is_new_multi_device", true);
        r109.putInt("key_dora_product_id", r104);
        r109.putString("key_dora_onboarding_origin_from", r100.f338941h);
        r109.putString("bury_point_source", r100.f338946m);
        if (r103 == false) goto L38;
        r109.putIntArray("key_dora_scan_product_ids", DoraObricDeviceBindFragment.f338938o);
    L39:
        r107.setArguments(r109);
        FragmentManager r110 = r100.getParentFragmentManager();     // Catch: Exception -> L51
        LandscapeRestrictionOperation r111 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L51
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r107, "DoraObricDeviceBindFragment", r111);     // Catch: Exception -> L51
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r110, r107, r111) == false) goto L56;
    L45:
        r100.f338940g = r107;     // Catch: Exception -> L51
        if (r106 == false) goto L53;
        Bundle r112 = r100.getArguments();     // Catch: Exception -> L51
        if (r112 == null) goto L53;
        r112.remove("key_dora_onboarding_auto_connect");     // Catch: Exception -> L51
        goto L53
    L56:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55
    L44:
        r107.show(r110, "DoraObricDeviceBindFragment");     // Catch: Exception -> L51
    L51:
        e = move-exception;
        g49.d.c("DoraObricDeviceBindFragment", "launchOnboarding show dialog exception", e);
        goto L53
    L38:
        r109.remove("key_dora_scan_product_ids");
    L53:
        o5.b(r100, "fragment_request_key_onboarding_start", new k(r100));
        return Unit.INSTANCE;
    L28:
        if (DoraObricDeviceBindFragment.Y90(Integer.valueOf(r104)) == false) goto L30;
        r107 = new ObricDoraGOnboardingDialogFragmentV2();
        goto L31
    L30:
        r107 = null;
        goto L31
    L17:
        if (r105.getBoolean("key_dora_onboarding_auto_connect") != true) goto L19;
        r106 = true;
        goto L21
    L13:
        r104 = 0;
        goto L14
    L58:
        r101.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r113 = DialogFragmentLancet.sLastShowStack;
        if (r113 == null) goto L10;
        com.bytedance.crash.d.d(r113, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
