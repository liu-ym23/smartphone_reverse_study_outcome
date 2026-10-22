package com.ss.android.lark.contact.customized.externalcontact.repository;

import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements com.ss.android.lark.sdk.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f419137a = null;

    static {
        f419137a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.sdk.f.a
    public final void a() {
        Lazy r100 = OfficeExternalContactRepository.f419134a;
        NewFriendBadgeRepository.a r101 = NewFriendBadgeRepository.f419130b;
        Intrinsics.checkNotNullParameter(r101, "listener");
        com.ss.android.lark.sdk.f.a((List) OfficeExternalContactRepository.f419134a.getValue(), r101, f.f419141a);
    }
}
