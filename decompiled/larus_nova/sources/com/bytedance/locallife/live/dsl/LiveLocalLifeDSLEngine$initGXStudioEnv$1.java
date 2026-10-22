package com.bytedance.locallife.live.dsl;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class LiveLocalLifeDSLEngine$initGXStudioEnv$1 extends Lambda implements Function0<Unit> {
    public static final LiveLocalLifeDSLEngine$initGXStudioEnv$1 INSTANCE = null;

    static {
        INSTANCE = new LiveLocalLifeDSLEngine$initGXStudioEnv$1();
    }

    public LiveLocalLifeDSLEngine$initGXStudioEnv$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Lazy<GXFastPreviewSource> r100 = GXFastPreviewSource.f259395f;
        GXFastPreviewSource r101 = GXFastPreviewSource.a.a();
        r101.getClass();
        if (LiveLifeSaaSUtil.A() == false) goto L11;
        LiveLifeSaaSUtil.d().b(r101.f259400e);
        LiveLifeSaaSUtil.t().d("GXFastPreviewSource", "GXFastPreviewSource registerEvent");
        it6.g r102 = r101.f259396a;
        if (r102 == null) goto L7;
        r102.init(LiveLifeSaaSUtil.p());
    L7:
        it6.g r103 = r101.f259396a;
        if (r103 == null) goto L12;
        r103.d(r101);
        return;
    L12:
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
