package com.bytedance.awemeopen.domain.report;

import android.content.Context;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ReportDomain$getReportReasonListInner$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ e $config;
    final /* synthetic */ Context $context;
    final /* synthetic */ q34.b $continuable;
    final /* synthetic */ String $lang;
    final /* synthetic */ int $reportType;
    final /* synthetic */ String $token;

    public ReportDomain$getReportReasonListInner$1(Context r100, int r101, String r102, String r103, e r104, q34.b r105) {
        this.$context = r100;
        this.$reportType = r101;
        this.$lang = r102;
        this.$token = r103;
        this.$continuable = r105;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String r100 = g.f198451a;
        Context r101 = this.$context;
        int r102 = this.$reportType;
        String r103 = this.$lang;
        String r104 = this.$token;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
        Intrinsics.checkNotNullParameter(r104, "token");
        int r105 = com.bytedance.awemeopen.domain.base.repo.b.f198240b;
        String r106 = com.bytedance.awemeopen.domain.base.repo.b.a.a(g.f198451a, MapsKt.mapOf(new Pair[]{TuplesKt.to("report_type", Integer.valueOf(r102)), TuplesKt.to(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, r103)}));
        Map r107 = MapsKt.mapOf(TuplesKt.to("access-token", r104));
        final e r108 = null;
        Function0<String> r109 = AoNet.f198669a;     // Catch: Exception -> L18
        AoNetResponse r110 = AoNet.a(r106, r107);     // Catch: Exception -> L18
        Throwable r111 = r110.getThrowable();     // Catch: Exception -> L18
        String r112 = com.bytedance.awemeopen.domain.base.repo.d.a(r110);     // Catch: Exception -> L18
    L15:
        e = e;
    L16:
        Exception e100 = e;
    L17:
        String r113 = null;
    L20:
        String r114 = r112;
        Exception r115 = e100;
        f r116 = null;
    L21:
        int r117 = com.bytedance.awemeopen.domain.base.repo.a.f198239a;
        com.bytedance.awemeopen.domain.base.repo.a.a(com.bytedance.awemeopen.domain.base.repo.d.b(g.f198451a), r116, r114, r113, r115);
        final com.bytedance.awemeopen.domain.base.repo.e r118 = new com.bytedance.awemeopen.domain.base.repo.e(r116, r115);
        final q34.b r119 = this.$continuable;
        AoPool.g(new AnonymousClass1(r118, r108, r119));
        return;
    L5:
        if (r110.isSuccessful() == false) goto L11;
        r113 = r110.stringBody();     // Catch: Exception -> L15
        r116 = (f) GsonHolder.a().fromJson(r113, f.class);     // Catch: Exception -> L9
        r114 = r112;
        r115 = null;
    L9:
        e100 = e;
        goto L20
    L11:
        if (r111 == null) goto L13;
        e = com.bytedance.awemeopen.domain.base.repo.d.c(r111);     // Catch: Exception -> L15
        goto L16
    L13:
        e100 = new RuntimeException("code=" + r110.getCode() + ", logId=" + r112);     // Catch: Exception -> L15
    L18:
        e = move-exception;
        e100 = e;
        r113 = null;
        r112 = null;
        goto L20
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
