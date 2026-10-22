package com.bytedance.awemeopen.domain.report;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "token", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ReportDomain$report$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ b $config;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $objectId;
    final /* synthetic */ String $ownerOpenId;
    final /* synthetic */ int $reason;
    final /* synthetic */ Integer $reasonDecCode;
    final /* synthetic */ String $reportDesc;
    final /* synthetic */ int $reportType;
    final /* synthetic */ c this$0;

    public static final class a implements q34.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f198436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f198437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f198438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f198439d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f198440e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f198441f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Integer f198442g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f198443h;

        @Override // q34.b
        public final void a(String r110) {
            Intrinsics.checkNotNullParameter(r110, "token");
            c.a(this.f198436a, this.f198437b, this.f198438c, this.f198439d, this.f198440e, this.f198441f, this.f198442g, this.f198443h, r110, null);
        }

        public a(c r100, Context r101, int r102, String r103, String r104, int r105, Integer r106, String r107) {
            this.f198436a = r100;
            this.f198437b = r101;
            this.f198438c = r102;
            this.f198439d = r103;
            this.f198440e = r104;
            this.f198441f = r105;
            this.f198442g = r106;
            this.f198443h = r107;
        }
    }

    public ReportDomain$report$1(b r100, c r101, Context r102, int r103, String r104, String r105, int r106, Integer r107, String r108) {
        this.this$0 = r101;
        this.$context = r102;
        this.$reportType = r103;
        this.$ownerOpenId = r104;
        this.$objectId = r105;
        this.$reason = r106;
        this.$reasonDecCode = r107;
        this.$reportDesc = r108;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r210) {
        if (r210 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L13;
        c r101 = this.this$0;
        Context r110 = this.$context;
        int r111 = this.$reportType;
        String r112 = this.$ownerOpenId;
        String r113 = this.$objectId;
        int r114 = this.$reason;
        Integer r102 = this.$reasonDecCode;
        String r103 = this.$reportDesc;
        c.a(r101, r110, r111, r112, r113, r114, r102, r103, r210, new a(r101, r110, r111, r112, r113, r114, r102, r103));
        return;
    L13:
        throw null;
    L5:
        if (r210.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
