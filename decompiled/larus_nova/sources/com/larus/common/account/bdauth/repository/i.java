package com.larus.common.account.bdauth.repository;

import com.larus.account.base.api.IMultiAccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes27.dex */
public final class i implements Function4<Boolean, String, Integer, String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<List<q38.b>> f325950a;

    public i(kotlinx.coroutines.j r100) {
        this.f325950a = r100;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Unit invoke(Boolean r100, String r101, Integer r102, String r103) {
        boolean r104 = r100.booleanValue();
        int r105 = r102.intValue();
        String r106 = r103;
        if (r104 == true) goto L7;
        FLogger.f375446a.w("BDAuthorizeRepository", "fetchServerAccountList failed, code=" + r105 + ", msg=" + r106);
        if (this.f325950a.isActive() == false) goto L11;
        kotlinx.coroutines.i<List<q38.b>> r107 = this.f325950a;
        Result.Companion r108 = Result.Companion;
        r107.resumeWith(Result.m9449constructorimpl(CollectionsKt.emptyList()));
    L11:
        return Unit.INSTANCE;
    L7:
        List<q38.b> r109 = IMultiAccountService.f286100a.g();
        if (this.f325950a.isActive() == false) goto L11;
        this.f325950a.resumeWith(Result.m9449constructorimpl(r109));
        goto L11
    }
}
