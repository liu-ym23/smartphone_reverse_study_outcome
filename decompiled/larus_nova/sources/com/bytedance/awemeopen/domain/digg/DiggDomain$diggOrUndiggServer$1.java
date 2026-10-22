package com.bytedance.awemeopen.domain.digg;

import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DiggDomain$diggOrUndiggServer$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $aid;
    final /* synthetic */ a $config;
    final /* synthetic */ q34.b $continuable;
    final /* synthetic */ boolean $digg;
    final /* synthetic */ String $openId;
    final /* synthetic */ String $token;
    final /* synthetic */ DiggDomain this$0;

    public DiggDomain$diggOrUndiggServer$1(String r100, String r101, boolean r102, DiggDomain r103, String r104, a r105, q34.b r106) {
        this.$aid = r100;
        this.$token = r101;
        this.$digg = r102;
        this.this$0 = r103;
        this.$openId = r104;
        this.$config = r105;
        this.$continuable = r106;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final com.bytedance.awemeopen.domain.base.repo.e<d> r100 = e.f198304a.update(this.$aid, this.$token, this.$digg);
        final boolean r101 = this.$digg;
        final DiggDomain r102 = this.this$0;
        final String r103 = this.$openId;
        final String r104 = this.$aid;
        final a r110 = this.$config;
        final q34.b r111 = this.$continuable;
        AoPool.g(new AnonymousClass1(r100, r101, r102, r103, r104, r110, r111));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
