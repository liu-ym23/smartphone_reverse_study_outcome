package com.larus.bmhome.utils;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.j5;

/* JADX INFO: loaded from: classes26.dex */
public final class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f315158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f315159b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f315160a = null;

        static {
            int[] r100 = new int[ExternalRedirectPromptFrequencyConfig.values().length];
            r100[ExternalRedirectPromptFrequencyConfig.NEVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ExternalRedirectPromptFrequencyConfig.FIRST_USE_ONLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ExternalRedirectPromptFrequencyConfig.EACH_DOMAIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f315160a = r100;
        }
    }

    static {
        f315158a = Keva.getRepo("safety_domain_confirm_cache", 0);
        f315159b = Keva.getRepo("safety_permission_confirm_cache", 0);
    }

    public static ExternalRedirectPromptFrequencyConfig a() {
        String r100 = com.larus.platform.service.z2.f365865a.Z3();
        if (r100 != null) goto L14;
        r100 = oo8.a.f524649c;
    L14:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(ExternalRedirectPromptFrequencyConfig.valueOf(r100));     // Catch: Throwable -> L7
    L9:
        ExternalRedirectPromptFrequencyConfig r103 = ExternalRedirectPromptFrequencyConfig.FIRST_USE_ONLY;
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = r103;
    L13:
        return (ExternalRedirectPromptFrequencyConfig) r102;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static void b(String r210, Function0 r211) {
        String r100 = r210;
        Intrinsics.checkNotNullParameter(r211, "onConfirm");
        if (r100 != null) goto L6;
        return;
    L6:
        if (com.larus.utils.y0.e(r210) == false) goto L8;
        String r101 = r100;
    L9:
        String r102 = com.larus.utils.y0.h(r101).getHost();
        if (r102 == null) goto L17;
        List r103 = StringsKt.split$default(r102, new char[]{'.'}, false, 0, 6, null);
        if (r103 == null) goto L17;
        if (r103.size() <= 2) goto L22;
        r102 = CollectionsKt.joinToString$default(CollectionsKt.takeLast(r103, 2), ".", null, null, 0, null, null, 62, null);
    L22:
        if (AppHost.f326268a.isOversea() == false) goto L69;
        String r104 = sx5.b.g().f543817a;
        Intrinsics.checkNotNull(r104);
        FLogger.f375446a.i("SafetyOpenLinkManager", "shouldUrlSafeCheck currentRegion: " + r104);
        List<String> r105 = com.larus.platform.service.z2.f365865a.Z0();
        if (r105 != null) goto L27;
        r105 = oo8.a.f524648b;
    L27:
        List<String> r106 = r105;
        if ((r106 instanceof Collection) == true) goto L30;
    L32:
        Iterator<T> r107 = r106.iterator();
    L34:
        if (r107.hasNext() == false) goto L38;
        if (StringsKt.equals(r104, (String) r107.next(), true) == false) goto L34;
        boolean r108 = true;
    L39:
        if (r108 == false) goto L69;
        FLogger.f375446a.i("SafetyOpenLinkManager", "tryUrlSafeCheck domain: " + r102);
        List<String> r109 = com.larus.platform.service.z2.f365865a.T0();
        if (r109 != null) goto L44;
        r109 = oo8.a.f524647a;
    L44:
        List<String> r110 = r109;
        if ((r110 instanceof Collection) == true) goto L47;
    L49:
        Iterator<T> r111 = r110.iterator();
    L51:
        if (r111.hasNext() == false) goto L55;
        if (StringsKt.equals(r102, (String) r111.next(), true) == false) goto L51;
        boolean r112 = true;
    L56:
        if (r112 == false) goto L58;
        FLogger.f375446a.i("SafetyOpenLinkManager", "isDomainInWhitelist");
        goto L69
    L58:
        int r113 = a.f315160a[a().ordinal()];
        if (r113 == 1) goto L68;
        if (r113 != 2) goto L62;
        FLogger.f375446a.i("SafetyOpenLinkManager", "promptFrequency FIRST_USE_ONLY");
        boolean r114 = f315159b.getBoolean("safety_domain_confirm_permission", false);
    L67:
        boolean r115 = !r114;
    L70:
        if (r115 == true) goto L73;
        r211.invoke();
        return;
    L73:
        FLogger.f375446a.i("SafetyOpenLinkManager", "showSafetyConfirmDialog");
        AppHost.Companion r116 = AppHost.f326268a;
        Activity r117 = r116.a().getCurrentActivity();
        if ((r117 instanceof FragmentActivity) == false) goto L76;
        FragmentActivity r118 = (FragmentActivity) r117;
    L77:
        if (r118 == null) goto L97;
        CommonDialog.a r119 = new CommonDialog.a();
        if (r116.isOversea() == false) goto L81;
        String r120 = j5.a(r116.getApplication(), R.string.app_string_name, R.string.larus_dola_mob_popupDesc_openExternalLink_global);
    L82:
        r119.i(r120);
        r119.f327184m = true;
        a3 r121 = new a3(r102, r211);
        int r122 = com.larus.utils.j0.f375426a;
        CommonDialog.a.f(r119, r121, com.larus.utils.j0.d(R.string.larus_mob_popupBtn_continue), false, 12);
        CommonDialog.a.e(r119, new b3(), com.larus.utils.j0.d(R.string.larus_mob_popupBtn_cancel), 4);
        CommonDialog r123 = r119.d(ContextCompat.getColor(r118, v19.c.b(R.attr.larus_neutral_100, r118, R.color.larus_neutral_100)));
        FragmentManager r124 = r118.getSupportFragmentManager();
        LandscapeRestrictionOperation r125 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r123, null, r125);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r124, r123, r125) == true) goto L98;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L88
    L86:
        r123.show(r124, null);
        return;
    L98:
        return;
    L81:
        int r126 = com.larus.utils.j0.f375426a;
        r120 = com.larus.utils.j0.d(R.string.larus_mob_popupDesc_openExternalLink);
        goto L82
    L97:
        return;
    L76:
        r118 = null;
        goto L77
    L62:
        if (r113 != 3) goto L65;
        FLogger.f375446a.i("SafetyOpenLinkManager", "promptFrequency EACH_DOMAIN");
        r114 = f315158a.getBoolean(r102, false);
        goto L67
    L65:
        throw new NoWhenBranchMatchedException();
    L68:
        FLogger.f375446a.i("SafetyOpenLinkManager", "promptFrequency NEVER");
    L55:
        r112 = false;
        goto L56
    L47:
        if (r110.isEmpty() == false) goto L49;
    L38:
        r108 = false;
        goto L39
    L30:
        if (r106.isEmpty() == false) goto L32;
    L69:
        r115 = false;
    L17:
        if (r102 == null) goto L20;
        r100 = r102;
    L20:
        r102 = r100;
        goto L22
    L8:
        r101 = "https://".concat(r100);
        goto L9
    }
}
