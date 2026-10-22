package com.larus.bmhome;

import com.baidu.platform.comapi.map.MapController;
import com.larus.platform.api.SocialIMData;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class v implements hza.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<SocialIMData, Unit> f315161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowLarkSocialServiceImpl f315162b;

    @Override // hza.b
    public final void a(pza.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Function1<SocialIMData, Unit> r101 = this.f315161a;
        this.f315162b.getClass();
        r101.invoke(FlowLarkSocialServiceImpl.a(r100));
    }

    public v(com.larus.bmhome.chat.reddot.g r100, FlowLarkSocialServiceImpl r101) {
        this.f315161a = r100;
        this.f315162b = r101;
    }
}
