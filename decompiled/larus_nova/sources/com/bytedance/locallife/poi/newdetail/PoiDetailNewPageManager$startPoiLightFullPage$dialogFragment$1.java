package com.bytedance.locallife.poi.newdetail;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "uid", "", "extBundle", "Landroid/os/Bundle;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class PoiDetailNewPageManager$startPoiLightFullPage$dialogFragment$1 extends Lambda implements Function2<String, Bundle, Unit> {
    final /* synthetic */ Intent $intent;
    final /* synthetic */ PoiBundle $poiBundle;
    final /* synthetic */ String $uuid;

    public PoiDetailNewPageManager$startPoiLightFullPage$dialogFragment$1(String r100, Intent r101, PoiBundle r102) {
        this.$uuid = r100;
        this.$intent = r101;
        this.$poiBundle = r102;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "extBundle");
        int r102 = bz6.c.f21879a;
        bz6.c.a(this.$uuid, this.$intent, this.$poiBundle, r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Bundle r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
