package com.ss.android.lark.contact.base.contact_mobile_invite.invite;

import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> implements ApiUtils.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f418675a = null;

    static {
        f418675a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.utils.ApiUtils.a
    public final void consume(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNull(r101);
        InvHitPoint.d(r101.booleanValue());
    }
}
