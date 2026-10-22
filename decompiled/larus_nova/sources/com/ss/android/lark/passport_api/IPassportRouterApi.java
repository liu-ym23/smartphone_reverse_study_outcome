package com.ss.android.lark.passport_api;

import android.content.Context;
import com.ss.android.lark.passport.signinsdk_api.base.network.bizflow.BizFlowPayload;
import dzb.d;
import kotlin.Result;
import kotlinx.coroutines.flow.i1;
import tzb.a;
import tzb.b;

/* JADX INFO: loaded from: classes37.dex */
public interface IPassportRouterApi {
    void doDoubaoLogin(Context r100, BizFlowPayload r101, d<Object> r102);

    void getABTestValue(d<Boolean> r100);

    void joinTeamByCode(Context r100, String r101, String r102, BizFlowPayload r103, a r104);

    i1<Result<Object>> preTenantCreate(BizFlowPayload r100, String r101);

    void registerRouterCallback(String r100, b r101);

    void routerNext(Context r100, String r101, BizFlowPayload r102, a r103);

    void ugLog(String r100);
}
