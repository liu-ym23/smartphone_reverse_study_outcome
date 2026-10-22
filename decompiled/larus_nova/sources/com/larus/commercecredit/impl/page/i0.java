package com.larus.commercecredit.impl.page;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class i0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommerceInviteFriendsFragment f325769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f325770b;

    public /* synthetic */ i0(CommerceInviteFriendsFragment r100, Function1 r101) {
        this.f325769a = r100;
        this.f325770b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        CommerceInviteFriendsFragment r101 = this.f325769a;
        Function1 r102 = this.f325770b;
        qz8.l r103 = (qz8.l) r100;
        r101.f325740h = r103;
        r102.invoke(r103);
        return Unit.INSTANCE;
    }
}
