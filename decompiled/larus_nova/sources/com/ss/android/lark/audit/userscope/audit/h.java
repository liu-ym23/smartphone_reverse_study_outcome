package com.ss.android.lark.audit.userscope.audit;

import com.ss.android.lark.audit.http.AuditResponseData;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements kwa.d<AuditResponseData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kwa.d<Boolean> f409494a;

    public h(iwa.f.a.C6362a r100) {
        this.f409494a = r100;
    }

    @Override // kwa.d
    public final void a(kwa.c r100) {
        Intrinsics.checkNotNullParameter(r100, "errorResult");
        this.f409494a.onResponse(Boolean.FALSE);
        Log.e("AuditRecordService", " processRecordsV2 error " + r100);
    }

    @Override // kwa.d
    public final void onResponse(AuditResponseData r100) {
        AuditResponseData r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f409494a.onResponse(Boolean.TRUE);
        StringBuilder r102 = new StringBuilder("processRecordsV2 success: ");
        StringBuilder r103 = new StringBuilder();
        r103.append(r101.successNum);
        r103.append('/');
        r103.append(r101.totalNum);
        r102.append(r103.toString());
        Log.i("AuditRecordService", r102.toString());
    }
}
