package com.bytedance.awemeopen.domain.dislike;

import android.content.Context;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.domain.base.repo.d;
import com.bytedance.awemeopen.domain.base.repo.e;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DislikeDomain$dislikeInner$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a $config;
    final /* synthetic */ Context $context;
    final /* synthetic */ q34.b $continuable;
    final /* synthetic */ List<b> $dislikeModelDms;
    final /* synthetic */ String $token;
    final /* synthetic */ DislikeDomain this$0;

    public DislikeDomain$dislikeInner$2(Context r100, List<b> r101, String r102, DislikeDomain r103, a r104, q34.b r105) {
        this.$context = r100;
        this.$dislikeModelDms = r101;
        this.$token = r102;
        this.this$0 = r103;
        this.$config = r104;
        this.$continuable = r105;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String r100 = c.f198321a;
        Context r101 = this.$context;
        List<b> r102 = this.$dislikeModelDms;
        String r103 = this.$token;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "dislikeModelDms");
        String r104 = c.f198322b;
        Pair[] r105 = new Pair[2];
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r105[0] = TuplesKt.to("access-token", r103);
        r105[1] = TuplesKt.to("ao-app-id", AoEnv.d());
        Map r106 = MapsKt.mapOf(r105);
        JSONObject r107 = new JSONObject();
        JSONArray r108 = new JSONArray();
        Iterator<T> r109 = r102.iterator();
    L7:
        if (r109.hasNext() == false) goto L9;
        b r110 = (b) r109.next();
        JSONObject r111 = new JSONObject();
        r111.put("author_open_id", r110.f198319a);
        r111.put("item_id", CastLongProtector.parseLong(r110.f198320b));
        r108.put(r111);
        goto L7
    L9:
        Unit r112 = Unit.INSTANCE;
        r107.put("items", r108);
        p14.a r113 = null;
        Function0<String> r114 = AoNet.f198669a;     // Catch: Exception -> L25
        AoNetResponse r115 = AoNet.e(r104, r106, r107);     // Catch: Exception -> L25
        Throwable r116 = r115.getThrowable();     // Catch: Exception -> L25
        String r117 = d.a(r115);     // Catch: Exception -> L25
    L22:
        e = e;
    L23:
        Exception e100 = e;
    L24:
        String r118 = null;
    L27:
        int r119 = com.bytedance.awemeopen.domain.base.repo.a.f198239a;
        com.bytedance.awemeopen.domain.base.repo.a.a(d.b(c.f198322b), r113, r117, r118, e100);
        e r120 = new e(r113, e100);
        DislikeDomain r121 = this.this$0;
        a r122 = this.$config;
        q34.b r123 = this.$continuable;
        r121.getClass();
        AoPool.g(new DislikeDomain$dealResultWithConfig$1(r120, r122, r123));
        return;
    L12:
        if (r115.isSuccessful() == false) goto L18;
        r118 = r115.stringBody();     // Catch: Exception -> L22
        e100 = null;
        r113 = (p14.a) GsonHolder.a().fromJson(r118, p14.a.class);     // Catch: Exception -> L16
    L16:
        e100 = e;
        goto L27
    L18:
        if (r116 == null) goto L20;
        e = d.c(r116);     // Catch: Exception -> L22
        goto L23
    L20:
        e100 = new RuntimeException("code=" + r115.getCode() + ", logId=" + r117);     // Catch: Exception -> L22
    L25:
        e = move-exception;
        e100 = e;
        r118 = null;
        r117 = null;
        goto L27
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
