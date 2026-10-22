package com.larus.login.impl;

import android.content.Context;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class w implements n38.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f358368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f358369b;

    @Override // n38.m
    public final void onSuccess(String r100) {
        AccountUtils r101 = AccountUtils.f357130a;
        Context r102 = this.f358368a;
        AccountUtils.t(r102, r102.getString(R.string.larus_change_phone_new_number), r100, this.f358369b, "show_popup_change_phone");
    }

    public w(Context r100, boolean r101) {
        this.f358368a = r100;
        this.f358369b = r101;
    }

    @Override // n38.m
    public final void a(int r100, String r101, String r102, String r103) {
        AccountUtils r104 = AccountUtils.f357130a;
        Context r105 = this.f358368a;
        AccountUtils.t(r105, r105.getString(R.string.larus_change_phone_current_number), null, this.f358369b, "show_popup_change_phone");
    }
}
