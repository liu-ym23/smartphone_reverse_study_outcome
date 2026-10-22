package com.bytedance.awemeopen.domain.dislike;

import com.bytedance.awemeopen.domain.base.repo.e;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DislikeDomain$dealResultWithConfig$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a $config;
    final /* synthetic */ q34.b $continuable;
    final /* synthetic */ e<p14.a> $repoResult;

    public DislikeDomain$dealResultWithConfig$1(e<p14.a> r100, a r101, q34.b r102) {
        this.$repoResult = r100;
        this.$config = r101;
        this.$continuable = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        e<p14.a> r100 = this.$repoResult;
        final a r101 = this.$config;
        Function1<p14.a, Unit> r102 = new AnonymousClass1(r101);
        final a r103 = this.$config;
        Function2<Exception, Integer, Unit> r104 = new AnonymousClass2(r103);
        final q34.b r105 = this.$continuable;
        final a r106 = this.$config;
        r100.b(r102, r104, new AnonymousClass3(r105, r106));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
