package com.ss.android.lark.security.compliance.infra.network.userscpoe;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.security.compliance.infra.network.h;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.videoarch.liveplayer.log.LiveError;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements com.ss.android.lark.security.compliance.infra.network.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.d<Object> f440459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.g f440460b;

    @Override // com.ss.android.lark.security.compliance.infra.network.e
    public final void a(NetworkErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "networkErrorResult");
        this.f440459a.a(r100);
        v4c.c.b(this.f440460b, Integer.valueOf(r100.getErrorCode()), r100.getErrorMessage(), null, null, r100.getLogId(), 24);
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.e
    public final void b(v4c.b r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        Map<String, String> r100 = r110.f553229c;
        if (r100 == null) goto L5;
        String r101 = r100.get(NetResponse.HEADER_KEY_LOG_ID);
    L23:
    L20:
        th = move-exception;
        int r102 = ScsLogger.f440428a;
        ScsLogger.c("RequestManager", ExceptionsKt.stackTraceToString(th));
        NetworkErrorResult r111 = new NetworkErrorResult(-6, "http code:" + r110.f553227a + ' ' + th.getMessage(), r101, 0, 8, null);
        v4c.c.b(this.f440460b, -11, "error msg parse response body fail", Integer.valueOf(LiveError.PARSE_JSON), null, r101, 16);
        this.f440459a.a(r111);
        return;
    L8:
        if (r110.f553227a == 200) goto L11;
        this.f440459a.a(new NetworkErrorResult(-2, "http status code:" + r110.f553227a, r101, 0, 8, null));     // Catch: Throwable -> L20
        v4c.c.b(this.f440460b, Integer.valueOf(r110.f553227a), "http code is not 200", null, Integer.valueOf(r110.f553227a), r101, 8);     // Catch: Throwable -> L20
        return;
    L11:
        h<Object> r103 = v4c.c.a(r110.f553228b, this.f440459a.b());     // Catch: Throwable -> L20
        int r104 = r103.f440445a;     // Catch: Throwable -> L20
        if (r104 != 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L18;
        NetworkErrorResult r112 = new NetworkErrorResult(r104, r103.f440446b, r101, 0, 8, null);     // Catch: Throwable -> L20
        r112.setBizCode(r103.f440445a);     // Catch: Throwable -> L20
        this.f440459a.a(r112);     // Catch: Throwable -> L20
        v4c.c.b(this.f440460b, -11, "error msg parse response body fail", Integer.valueOf(r103.f440445a), null, r101, 16);     // Catch: Throwable -> L20
        return;
    L18:
        this.f440459a.c(r103);     // Catch: Throwable -> L20
        return;
    L14:
        r105 = false;
        goto L15
    L5:
        r101 = null;
        goto L23
    }

    public c(com.ss.android.lark.security.compliance.infra.network.d<Object> r100, com.ss.android.lark.security.compliance.infra.network.g r101) {
        this.f440459a = r100;
        this.f440460b = r101;
    }
}
