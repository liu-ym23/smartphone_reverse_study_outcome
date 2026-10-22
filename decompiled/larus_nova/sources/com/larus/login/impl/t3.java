package com.larus.login.impl;

import android.app.Application;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.autofill.HintConstants;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.SeparatedEditText;
import com.larus.login.impl.databinding.LarusAccountVerificationCodePageBinding;
import com.larus.nova.R;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes30.dex */
public final class t3 implements n38.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerificationCodeFragment f358274a;

    public t3(VerificationCodeFragment r100) {
        this.f358274a = r100;
    }

    @Override // n38.m
    public final void onSuccess(String r100) {
        com.bytedance.router.i r101 = SmartRouter.buildRoute(this.f358274a.getContext(), "//flow/phone_login");
        Pair[] r102 = new Pair[5];
        r102[0] = TuplesKt.to("phoneLoginTitle", this.f358274a.getString(R.string.larus_change_phone_new_number));
        r102[1] = TuplesKt.to("phoneTicket", r100);
        StringBuilder r103 = new StringBuilder(Marker.ANY_NON_NULL_MARKER);
        String r104 = this.f358274a.f357227h;
        String r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneCodeNumber");
        r104 = null;
    L5:
        r103.append(r104);
        String r106 = this.f358274a.f357228i;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
    L9:
        r103.append(r105);
        r102[2] = TuplesKt.to("currentBindPhoneNumber", r103.toString());
        Bundle r107 = this.f358274a.getArguments();
        if (r107 == null) goto L13;
        String r108 = r107.getString("key_trigger_app_id");
        if (r108 == null) goto L13;
    L14:
        r102[3] = TuplesKt.to("key_trigger_app_id", r108);
        r102[4] = TuplesKt.to("key_bind_phone_from_h5", Boolean.valueOf(this.f358274a.f357238s));
        r101.f267554c.putExtras(com.larus.utils.f.c(r102));
        r101.f267555d = R.anim.larus_router_slide_in_right;
        r101.f267556e = R.anim.larus_router_no_anim;
        r101.d();
        LarusAccountVerificationCodePageBinding r109 = this.f358274a.f357224e;
        if (r109 == null) goto L19;
        SeparatedEditText r110 = r109.f357472c;
        if (r110 == null) goto L19;
        r110.c();
    L19:
        CountDownTimer r111 = this.f358274a.f357225f;
        if (r111 == null) goto L22;
        r111.cancel();
    L22:
        VerificationCodeFragment r112 = this.f358274a;
        r112.da0(r112.getActivity(), this.f358274a.f357226g);
        return;
    L13:
        r108 = "";
        goto L14
    L8:
        r105 = r106;
        goto L9
    }

    @Override // n38.m
    public final void a(int r100, String r101, String r102, String r103) {
        VerificationCodeFragment r104 = this.f358274a;
        r104.da0(r104.getActivity(), this.f358274a.f357226g);
        t19.s r105 = t19.s.f544207a;
        Application r106 = AppHost.f326268a.getApplication();
        if (r101 != null) goto L5;
        r101 = this.f358274a.getString(R.string.larus_log_in_internet_error);
    L5:
        r105.getClass();
        t19.s.t(r106, r101);
    }
}
