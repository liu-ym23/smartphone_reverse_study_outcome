package com.bytedance.awemeopen.domain.dislike;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "token", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DislikeDomain$dislike$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ com.bytedance.awemeopen.domain.dislike.a $config;
    final /* synthetic */ Context $context;
    final /* synthetic */ List<b> $dislikeModelDms;
    final /* synthetic */ DislikeDomain this$0;

    public static final class a implements q34.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DislikeDomain f198310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f198311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<b> f198312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.awemeopen.domain.dislike.a f198313d;

        @Override // q34.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "token");
            DislikeDomain r101 = this.f198310a;
            Context r102 = this.f198311b;
            List<b> r103 = this.f198312c;
            com.bytedance.awemeopen.domain.dislike.a r104 = this.f198313d;
            r101.getClass();
            AoPool.a(new DislikeDomain$dislikeInner$2(r102, r103, r100, r101, r104, null));
        }

        public a(DislikeDomain r100, Context r101, List<b> r102, com.bytedance.awemeopen.domain.dislike.a r103) {
            this.f198310a = r100;
            this.f198311b = r101;
            this.f198312c = r102;
            this.f198313d = r103;
        }
    }

    public DislikeDomain$dislike$2(com.bytedance.awemeopen.domain.dislike.a r100, DislikeDomain r101, Context r102, List<b> r103) {
        this.$config = r100;
        this.this$0 = r101;
        this.$context = r102;
        this.$dislikeModelDms = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        Function1<? super Exception, Unit> r102 = this.$config.f198314a;
        if (r102 == null) goto L14;
        r102.invoke(null);
        return;
    L14:
        return;
    L12:
        DislikeDomain r103 = this.this$0;
        Context r104 = this.$context;
        List<b> r105 = this.$dislikeModelDms;
        com.bytedance.awemeopen.domain.dislike.a r106 = this.$config;
        a r107 = new a(r103, r104, r105, r106);
        r103.getClass();
        AoPool.a(new DislikeDomain$dislikeInner$2(r104, r105, r100, r103, r106, r107));
        return;
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
