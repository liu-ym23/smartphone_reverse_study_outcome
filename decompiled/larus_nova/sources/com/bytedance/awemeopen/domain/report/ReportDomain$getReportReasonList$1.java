package com.bytedance.awemeopen.domain.report;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "token", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ReportDomain$getReportReasonList$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ e $config;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $lang;
    final /* synthetic */ int $reportType;
    final /* synthetic */ c this$0;

    public static final class a implements q34.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f198432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f198433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f198434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f198435d;

        @Override // q34.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "token");
            c r101 = this.f198432a;
            Context r102 = this.f198433b;
            int r103 = this.f198434c;
            String r104 = this.f198435d;
            int r105 = c.f198450a;
            r101.getClass();
            AoPool.a(new ReportDomain$getReportReasonListInner$1(r102, r103, r104, r100, null, null));
        }

        public a(c r100, Context r101, int r102, String r103) {
            this.f198432a = r100;
            this.f198433b = r101;
            this.f198434c = r102;
            this.f198435d = r103;
        }
    }

    public ReportDomain$getReportReasonList$1(e r100, c r101, Context r102, int r103, String r104) {
        this.this$0 = r101;
        this.$context = r102;
        this.$reportType = r103;
        this.$lang = r104;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L12;
        c r102 = this.this$0;
        Context r103 = this.$context;
        int r104 = this.$reportType;
        String r105 = this.$lang;
        a r106 = new a(r102, r103, r104, r105);
        int r107 = c.f198450a;
        r102.getClass();
        AoPool.a(new ReportDomain$getReportReasonListInner$1(r103, r104, r105, r100, null, r106));
        return;
    L12:
        throw null;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
