package com.bytedance.ee.lark.infra.network.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "key", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class EcoNetworkLogUtil$Companion$getStartRequestLogMsg$dataMsg$1$entries$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends String>> {
    final /* synthetic */ JSONObject $jsonObj;

    public EcoNetworkLogUtil$Companion$getStartRequestLogMsg$dataMsg$1$entries$1(JSONObject r100) {
        this.$jsonObj = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<String, String> invoke2(String r100) {
        String r101 = JSONObjectProtectorUtils.getString(this.$jsonObj, r100);
        Set<String> r102 = a.f242810a;
        return TuplesKt.to(r100, a.C3479a.a(r101));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pair<? extends String, ? extends String> invoke(String r100) {
        return invoke2(r100);
    }
}
