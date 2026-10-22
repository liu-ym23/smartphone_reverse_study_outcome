package com.larus.login.impl.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.View;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.router.SmartRouter;
import com.larus.account.base.model.PhoneOneKeyPlatform;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.nova.R;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f358327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f358328b = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f358329a = null;

        static {
            int[] r100 = new int[PhoneOneKeyPlatform.values().length];
            r100[PhoneOneKeyPlatform.MOBILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PhoneOneKeyPlatform.UNICOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PhoneOneKeyPlatform.TELECOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f358329a = r100;
        }
    }

    public static final class b implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f358330a;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            this.f358330a.invoke();
        }

        public b(Function0<Unit> r100) {
            this.f358330a = r100;
        }
    }

    public static final class c implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f358331a;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            Function0<Unit> r100 = this.f358331a;
            if (r100 == null) goto L6;
            r100.invoke();
            return;
        }

        public c(Function0<Unit> r100) {
            this.f358331a = r100;
        }
    }

    static {
    }

    public m() {
    }

    public static final boolean a() {
        long r100 = System.currentTimeMillis();
        if ((r100 - f358327a) >= 500) goto L5;
        boolean r101 = true;
    L6:
        f358327a = r100;
        return r101;
    L5:
        r101 = false;
        goto L6
    }

    public static void b(Fragment r100, PhoneOneKeyPlatform r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "platform");
        int r102 = a.f358329a[r101.ordinal()];
        boolean r103 = true;
        if (r102 != 1) goto L5;
        String r104 = kb9.c.f502283e;
    L13:
        if (r104.length() == 0) goto L16;
        r103 = false;
    L16:
        if (r103 == false) goto L18;
        return;
    L18:
        c(r100, r104);
        return;
    L5:
        if (r102 != 2) goto L7;
        r104 = kb9.c.f502284f;
        goto L13
    L7:
        if (r102 == 3) goto L9;
        r104 = "";
        goto L13
    L9:
        r104 = kb9.c.f502285g;
        goto L13
    }

    public static void c(Fragment r100, String r101) {
        Context r102 = r100.getContext();
        if (r102 != null) goto L5;
        return;
    L5:
        com.bytedance.router.i r103 = SmartRouter.buildRoute(r102, "//flow/webview");
        r103.f267554c.putExtra("link_url", r101);
        r103.f267555d = R.anim.larus_router_slide_in_right;
        r103.f267556e = R.anim.larus_router_no_anim;
        r103.d();
    }

    public static void d(Fragment r110, PhoneOneKeyPlatform r111, Boolean r112, View r113, Function0 r210, Function0 r211) {
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r210, "onAgree");
        Context r100 = r110.getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r111 != null) goto L7;
        return;
    L7:
        int r101 = a.f358329a[r111.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 != 2) goto L11;
        String r102 = r110.getString(R.string.larus_doubao_login_tel_sdk_provider_china_mobile_china_unicom);
    L17:
        if (r102.length() != 0) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == false) goto L22;
        return;
    L22:
        int r104 = j.a(r100);
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        Spanned r106 = HtmlCompat.fromHtml(StringsKt.replace$default(String.format(r110.getString(R.string.larus_login_tel_sdk_agreement_new), Arrays.copyOf(new Object[]{r110.getResources().getString(R.string.app_name_replace), r102}, 2)), "\n", "<br/>", false, 4, null), 0);
        if ((r106 instanceof SpannableStringBuilder) == false) goto L25;
        SpannableStringBuilder r107 = (SpannableStringBuilder) r106;
    L26:
        SpannableString r108 = SpannableString.valueOf(r107);
        Iterator r109 = ArrayIteratorKt.iterator((URLSpan[]) r108.getSpans(0, r108.length(), URLSpan.class));
    L28:
        if (r109.hasNext() == false) goto L30;
        URLSpan r114 = (URLSpan) r109.next();
        int r115 = r108.getSpanStart(r114);
        int r116 = r108.getSpanEnd(r114);
        int r117 = r108.getSpanFlags(r114);
        r108.removeSpan(r114);
        r108.setSpan(new n(r114, r110, r111, r104), r115, r116, r117);
        goto L28
    L30:
        int r118 = com.larus.login.impl.utils.b.f358315a;
        FragmentManager r119 = r110.getChildFragmentManager();
        String r120 = r110.getString(R.string.larus_log_in_tos_confirmation_title);
        String r121 = r110.getString(R.string.larus_log_in_tos_confirmation_agree);
        b r122 = new b(r210);
        String r123 = r110.getString(R.string.larus_log_in_tos_confirmation_disagree);
        c r124 = new c(r211);
        if (r112 == null) goto L33;
        boolean r125 = r112.booleanValue();
    L34:
        com.larus.login.impl.utils.b.a(r100, r119, r120, r108, r121, r122, r123, r124, r113, r125);
        return;
    L33:
        r125 = true;
        goto L34
    L25:
        r107 = null;
        goto L26
    L19:
        r103 = false;
        goto L20
    L11:
        if (r101 == 3) goto L13;
        r102 = "";
        goto L17
    L13:
        r102 = r110.getString(R.string.larus_doubao_login_tel_sdk_provider_china_mobile_china_telecom);
        goto L17
    L15:
        r102 = r110.getString(R.string.larus_doubao_login_tel_sdk_provider_china_mobile);
        goto L17
    }
}
