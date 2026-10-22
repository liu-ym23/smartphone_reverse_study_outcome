package com.larus.login.impl;

import androidx.fragment.app.FragmentActivity;
import com.larus.network.HttpConst;
import com.larus.search.api.IBrowserService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Triple;

/* JADX INFO: loaded from: classes30.dex */
public final class y3 implements n38.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerificationCodeFragment f358384a;

    @Override // n38.o
    public final void onFailed() {
        FragmentActivity r100 = this.f358384a.getActivity();
        if (r100 == null) goto L7;
        IBrowserService r101 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r101 == null) goto L7;
        HttpConst.f359979a.getClass();
        r101.j(r100, HttpConst.I);
    L7:
        VerificationCodeFragment r102 = this.f358384a;
        r102.da0(r102.getActivity(), this.f358384a.f357226g);
    }

    public y3(VerificationCodeFragment r100) {
        this.f358384a = r100;
    }

    @Override // n38.o
    public final void onSuccess(boolean r100, boolean r101, String r102) {
        VerificationCodeFragment r103 = this.f358384a;
        r103.D = new Triple(Boolean.valueOf(r100), Boolean.valueOf(r101), r102);
        this.f358384a.ca0(r100, r101, r102);
    }
}
