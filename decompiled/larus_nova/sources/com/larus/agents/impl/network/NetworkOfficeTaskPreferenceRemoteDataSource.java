package com.larus.agents.impl.network;

import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes24.dex */
public final class NetworkOfficeTaskPreferenceRemoteDataSource implements com.larus.agents.impl.settings.d {

    public static final class a {
    }

    static {
    }

    public NetworkOfficeTaskPreferenceRemoteDataSource() {
    }

    @Override // com.larus.agents.impl.settings.d
    public final Object a(Continuation<? super Result<com.larus.agents.impl.settings.b>> r100) {
        if ((r100 instanceof NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1) == false) goto L7;
        NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1 r101 = (NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        String r106 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        dm9.a r107 = (dm9.a) r103;
        if ((r107 instanceof dm9.a.b) == false) goto L29;
        BizResponse<T> r108 = ((dm9.a.b) r107).f469231a;
        if (r108.isSuccess() == false) goto L27;
        Result.Companion r109 = Result.Companion;
        d r110 = (d) r108.getData();
        if (r110 == null) goto L24;
        r106 = r110.a();
    L24:
        if (r106 != null) goto L37;
        r106 = "";
    L37:
        return Result.m9449constructorimpl(new com.larus.agents.impl.settings.b(r106, 0));
    L27:
        FLogger.f375446a.w("AgentsMdRemoteDataSource", "get agents.md failed, code=" + r108.getCode());
        Result.Companion r111 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("get agents.md failed")));
    L29:
        if ((r107 instanceof dm9.a.C5690a) == false) goto L36;
        FLogger r112 = FLogger.f375446a;
        StringBuilder r113 = new StringBuilder("get agents.md error, code=");
        dm9.a.C5690a r114 = (dm9.a.C5690a) r107;
        r113.append(r114.f469228a);
        r112.w("AgentsMdRemoteDataSource", r113.toString());
        Result.Companion r115 = Result.Companion;
        Throwable r116 = r114.f469230c;
        if (r116 != null) goto L34;
        r116 = new IllegalStateException("get agents.md request error");
    L34:
        return Result.m9449constructorimpl(ResultKt.createFailure(r116));
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        AgentsMdApi.a r117 = AgentsMdApi.f286697a;
        NetworkOfficeTaskPreferenceRemoteDataSource$fetch$result$1 r118 = new NetworkOfficeTaskPreferenceRemoteDataSource$fetch$result$1(null);
        r101.label = 1;
        r117.getClass();
        r103 = BuildersKt.withContext(Dispatchers.getIO(), new AgentsMdApi$Companion$safeCall$2(r118, "/alice/generaltask/memory/get_agentsmd", null), r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1(this, r100);
        goto L8
    }

    @Override // com.larus.agents.impl.settings.d
    public final Object b(com.larus.agents.impl.settings.b r100, Continuation<? super OfficeTaskPreferenceSaveResult> r101) {
        if ((r101 instanceof NetworkOfficeTaskPreferenceRemoteDataSource$save$1) == false) goto L7;
        NetworkOfficeTaskPreferenceRemoteDataSource$save$1 r102 = (NetworkOfficeTaskPreferenceRemoteDataSource$save$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        dm9.a r107 = (dm9.a) r104;
        if ((r107 instanceof dm9.a.b) == false) goto L30;
        dm9.a.b r108 = (dm9.a.b) r107;
        long r109 = r108.f469231a.getCode();
        if (r109 != 0) goto L23;
        OfficeTaskPreferenceSaveResult r110 = OfficeTaskPreferenceSaveResult.SUCCESS;
    L27:
        if (r110 == OfficeTaskPreferenceSaveResult.SUCCESS) goto L35;
        FLogger.f375446a.w("AgentsMdRemoteDataSource", "set agents.md failed, code=" + r108.f469231a.getCode());
        return r110;
    L35:
        return r110;
    L23:
        if (r109 != 671020000) goto L25;
        r110 = OfficeTaskPreferenceSaveResult.SECURITY_RISK;
        goto L27
    L25:
        r110 = OfficeTaskPreferenceSaveResult.FAILURE;
        goto L27
    L30:
        if ((r107 instanceof dm9.a.C5690a) == false) goto L34;
        FLogger.f375446a.w("AgentsMdRemoteDataSource", "set agents.md error, code=" + ((dm9.a.C5690a) r107).f469228a);
        return OfficeTaskPreferenceSaveResult.FAILURE;
    L34:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        AgentsMdApi.a r111 = AgentsMdApi.f286697a;
        NetworkOfficeTaskPreferenceRemoteDataSource$save$result$1 r112 = new NetworkOfficeTaskPreferenceRemoteDataSource$save$result$1(r100, null);
        r102.label = 1;
        r111.getClass();
        r104 = BuildersKt.withContext(Dispatchers.getIO(), new AgentsMdApi$Companion$safeCall$2(r112, "/alice/generaltask/memory/set_agentsmd", null), r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new NetworkOfficeTaskPreferenceRemoteDataSource$save$1(this, r101);
        goto L8
    }
}
