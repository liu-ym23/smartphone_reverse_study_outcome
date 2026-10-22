package com.larus.login.impl;

import android.content.Context;
import com.larus.login.api.AccountTrackService;
import com.larus.login.api.IAccountTrackApi;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class b4 implements n38.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerificationCodeFragment f357368a;

    @Override // n38.z
    public final void onSendSuccess() {
        VerificationCodeFragment r100 = this.f357368a;
        r100.da0(r100.getActivity(), this.f357368a.f357226g);
        t19.s r101 = t19.s.f544207a;
        Context r102 = this.f357368a.getContext();
        r101.getClass();
        t19.s.o(r102, R.string.larus_verify_with_phone_call_note, false);
        AccountTrackService r103 = AccountTrackService.f356934a;
        IAccountTrackApi.a.d(r103, 0);
        r103.i(1, null, null, null, null);
    }

    public b4(VerificationCodeFragment r100) {
        this.f357368a = r100;
    }

    @Override // n38.z
    public final void a(int r110, String r111, Integer r112, String r113) {
        VerificationCodeFragment r100 = this.f357368a;
        r100.da0(r100.getActivity(), this.f357368a.f357226g);
        AccountUtils r101 = AccountUtils.f357130a;
        if (AccountUtils.e(this.f357368a) == true) goto L5;
        return;
    L5:
        t19.s r102 = t19.s.f544207a;
        Context r103 = this.f357368a.requireContext();
        if (r111 != null) goto L8;
        String r104 = this.f357368a.getString(R.string.larus_log_in_internet_error);
    L9:
        r102.getClass();
        t19.s.c(r103, r104);
        AccountTrackService r105 = AccountTrackService.f356934a;
        r105.o(0, 0, Integer.valueOf(r110), r111);
        r105.i(0, Integer.valueOf(r110), r111, r112, r113);
        return;
    L8:
        r104 = r111;
        goto L9
    }
}
