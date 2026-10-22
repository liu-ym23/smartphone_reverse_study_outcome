package com.ss.android.lark.create.groupchat.impl.service;

import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<InterceptorType, Provider<c>> f420196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<InterceptorType> f420197b;

    public static final class a {
    }

    static {
    }

    @Inject
    public b(Map<InterceptorType, Provider<c>> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f420196a = r100;
        this.f420197b = CollectionsKt.listOf(new InterceptorType[]{InterceptorType.HIT_POINT, InterceptorType.GROUP_MEMBER_LIMIT, InterceptorType.EXCEED_GROUP_LIMIT, InterceptorType.EXCEED_GROUP_LIMIT_NEED_APPLY, InterceptorType.BILLING, InterceptorType.DLP, InterceptorType.STRANGER, InterceptorType.DEFAULT});
    }
}
