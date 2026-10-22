package com.bytedance.awemeopen.domain.mix;

import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import r14.q;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class MixDomain$dislikeInner$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $accessToken;
    final /* synthetic */ c $config;
    final /* synthetic */ q34.b $continuable;
    final /* synthetic */ boolean $isCollect;
    final /* synthetic */ String $mixId;
    final /* synthetic */ MixDomain this$0;

    public MixDomain$dislikeInner$1(String r100, String r101, boolean r102, MixDomain r103, c r104, q34.b r105) {
        this.$accessToken = r100;
        this.$mixId = r101;
        this.$isCollect = r102;
        this.this$0 = r103;
        this.$config = r104;
        this.$continuable = r105;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.bytedance.awemeopen.domain.collect.c r100 = com.bytedance.awemeopen.domain.collect.c.f198254a;
        String r101 = this.$accessToken;
        int r102 = q.f535645a;
        String r103 = this.$mixId;
        boolean r104 = this.$isCollect;
        r100.getClass();
        final com.bytedance.awemeopen.domain.base.repo.e r105 = com.bytedance.awemeopen.domain.collect.c.a(r101, 6, r103, r104);
        final MixDomain r106 = this.this$0;
        final String r107 = this.$mixId;
        final boolean r108 = this.$isCollect;
        final c r109 = this.$config;
        final q34.b r110 = this.$continuable;
        AoPool.g(new AnonymousClass1(r105, r106, r107, r108, r109, r110));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
