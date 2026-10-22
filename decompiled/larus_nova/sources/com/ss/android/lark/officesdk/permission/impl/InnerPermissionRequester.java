package com.ss.android.lark.officesdk.permission.impl;

import com.bytedance.supervisor.token.Token;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.officesdk.permission.api.IPermissionRequester;
import com.ss.android.lark.utils.g0;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class InnerPermissionRequester implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IPermissionRequester f437127a;

    public static final class a {
    }

    static {
    }

    @Inject
    public InnerPermissionRequester(IPermissionRequester r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f437127a = r100;
    }

    @Override // com.ss.android.lark.utils.g0
    public void requestPermissions(Token r100, String[] r101, final Function1<? super g0.a, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f437127a.requestPermissions(ArraysKt.toList(r101), new AnonymousClass1(r102));
    }
}
