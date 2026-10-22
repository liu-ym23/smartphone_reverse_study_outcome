package com.bytedance.awemeopen.domain.young.digg;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.domain.digg.a;
import com.bytedance.awemeopen.domain.digg.d;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import l44.e;
import q34.b;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class YoungDiggDomain$diggOrUndiggServer$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $aid;
    final /* synthetic */ a $config;
    final /* synthetic */ b $continuable;
    final /* synthetic */ boolean $digg;
    final /* synthetic */ String $token;
    final /* synthetic */ YoungDiggDomain this$0;

    public YoungDiggDomain$diggOrUndiggServer$1(String r100, String r101, boolean r102, YoungDiggDomain r103, a r104, b r105) {
        this.$aid = r100;
        this.$token = r101;
        this.$digg = r102;
        this.this$0 = r103;
        this.$config = r104;
        this.$continuable = r105;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String r100 = e.f507342a;
        String r101 = this.$aid;
        String r102 = this.$token;
        boolean r103 = this.$digg;
        Intrinsics.checkNotNullParameter(r101, "aid");
        Intrinsics.checkNotNullParameter(r102, "token");
        d r104 = null;
        int r105 = com.bytedance.awemeopen.domain.base.repo.b.f198240b;     // Catch: Exception -> L18
        String r106 = com.bytedance.awemeopen.domain.base.repo.b.a.a(e.f507343b, MapsKt.mapOf(new Pair[]{TuplesKt.to(SimilarProductParam.AWEME_ID, r101), TuplesKt.to("type", Integer.valueOf(r103 ? 1 : 0))}));     // Catch: Exception -> L18
        Function0<String> r107 = AoNet.f198669a;     // Catch: Exception -> L18
        AoNetResponse r108 = AoNet.f(r106, AoFromSource.f98default, MapsKt.mapOf(new Pair[]{TuplesKt.to("access-token", r102), TuplesKt.to("Content-Type", "application/json")}));     // Catch: Exception -> L18
        Throwable r109 = r108.getThrowable();     // Catch: Exception -> L18
        String r110 = com.bytedance.awemeopen.domain.base.repo.d.a(r108);     // Catch: Exception -> L18
    L16:
        e = move-exception;
        Exception e100 = e;
        String r111 = null;
    L20:
        Exception r112 = e100;
        String r113 = r111;
        Exception r114 = r112;
    L21:
        int r115 = com.bytedance.awemeopen.domain.base.repo.a.f198239a;
        String r116 = com.bytedance.awemeopen.domain.base.repo.d.b(e.f507343b);
        if (r104 == null) goto L27;
        String r117 = r104.e();
        if (r117 == null) goto L27;
        r110 = r117;
    L27:
        com.bytedance.awemeopen.domain.base.repo.a.a(r116, r104, r110, r113, r114);
        final com.bytedance.awemeopen.domain.base.repo.e r118 = new com.bytedance.awemeopen.domain.base.repo.e(r104, r114);
        final boolean r119 = this.$digg;
        final YoungDiggDomain r120 = this.this$0;
        final String r121 = this.$aid;
        final a r122 = this.$config;
        final b r123 = this.$continuable;
        AoPool.g(new AnonymousClass1(r118, r119, r120, r121, r122, r123));
        return;
    L5:
        if (r108.isSuccessful() == false) goto L11;
        r111 = r108.stringBody();     // Catch: Exception -> L16
        d r124 = (d) GsonHolder.a().fromJson(r111, d.class);     // Catch: Exception -> L9
        r113 = r111;
        r114 = null;
        r104 = r124;
    L9:
        e100 = e;
        goto L20
    L11:
        if (r109 == null) goto L14;
        r114 = com.bytedance.awemeopen.domain.base.repo.d.c(r109);     // Catch: Exception -> L16
    L15:
        r113 = null;
        goto L21
    L14:
        r114 = new RuntimeException("code=" + r108.getCode() + ", logId=" + r110);     // Catch: Exception -> L16
    L18:
        e = move-exception;
        e100 = e;
        r111 = null;
        r110 = null;
        goto L20
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
