package com.ss.android.lark.custom.repeat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements oab.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChooseCustomRepeatFragment f420292a;

    @Override // oab.e
    public final void f() {
        this.f420292a.f420265r.setRepeatType(10);
    }

    @Override // oab.e
    public final void i() {
        this.f420292a.f420265r.setRepeatType(9);
    }

    public a(ChooseCustomRepeatFragment r100) {
        this.f420292a = r100;
    }

    @Override // oab.e
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "weekDay");
        this.f420292a.f420265r.setCustomerByMonthWeekDay(r100);
    }

    @Override // oab.e
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "weekNo");
        this.f420292a.f420265r.setCustomerByMonthWeekNo(r100);
    }

    @Override // oab.e
    public final void c(int r100) {
        this.f420292a.f420265r.addWeekList(r100);
    }

    @Override // oab.e
    public final void d(int r100) {
        this.f420292a.f420265r.addMonthList(r100);
    }

    @Override // oab.e
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        ChooseCustomRepeatFragment r101 = this.f420292a;
        int r102 = ChooseCustomRepeatFragment.f420250u;
        r101.ba0();
    }

    @Override // oab.e
    public final void g(int r100) {
        this.f420292a.f420265r.removeMonthList(r100);
    }

    @Override // oab.e
    public final void h(int r100) {
        this.f420292a.f420265r.removeWeekList(r100);
    }
}
