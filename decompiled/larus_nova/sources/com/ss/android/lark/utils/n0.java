package com.ss.android.lark.utils;

import com.bytedance.supervisor.token.Token;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class n0 implements g0 {
    @Inject
    public n0() {
    }

    @Override // com.ss.android.lark.utils.g0
    public void requestPermissions(Token r100, String[] r101, Function1<? super g0.a, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "callback");
    }
}
