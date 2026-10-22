package com.ss.android.lark.passportc.impl.v2;

import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import com.ss.android.lark.passportc.impl.v2.state.AllUserState;
import h0c.f;

/* JADX INFO: loaded from: classes37.dex */
public interface d extends f<UpdateUserContext, UserState, j0c.a> {
    void a(UpdateUserContext r100, UserState r101, UserState r102, boolean r103);

    void b(UpdateUserContext r100, UserState r101, UserState r102, boolean r103);

    void c(UpdateUserRequest r100, com.ss.android.lark.passportc.api.d r101);

    void e(AllUserState r100, AllUserState r101);

    void g(UpdateUserContext r100, UserState r101, UserState r102, h0c.b<j0c.a> r103);

    void h(UpdateUserRequest r100, com.ss.android.lark.passportc.api.d r101, com.ss.android.lark.passportc.impl.v2.entity.c r102);

    void i(UpdateUserRequest r100, com.ss.android.lark.passportc.api.d r101);

    void j(UpdateUserRequest r100, com.ss.android.lark.passportc.api.d r101, Throwable r102);

    void k(UpdateUserContext r100, UserState r101, UserState r102, h0c.b.c r103);

    void m(UpdateUserContext r100, UserState r101, UserState r102);

    void n(UpdateUserContext r100, UserState r101, UserState r102, boolean r103);

    void o(UpdateUserContext r100, UserState r101, UserState r102, boolean r103);

    void p(UpdateUserContext r100, UserState r101, UserState r102);

    void q(com.ss.android.lark.passportc.impl.v2.entity.a r100);

    void r(UpdateUserRequest r100, com.ss.android.lark.passportc.api.d r101);
}
