package com.bytedance.locallife.photo.photopage.view;

import com.bytedance.locallife.cube.api.config.CubeInitConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/locallife/cube/api/config/CubeInitConfig;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class PoiAlbumPageActivity$initBottomLynxView$cubeConfig$1 extends Lambda implements Function1<CubeInitConfig, Unit> {
    public static final PoiAlbumPageActivity$initBottomLynxView$cubeConfig$1 INSTANCE = null;

    static {
        INSTANCE = new PoiAlbumPageActivity$initBottomLynxView$cubeConfig$1();
    }

    public PoiAlbumPageActivity$initBottomLynxView$cubeConfig$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CubeInitConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateCubeInitConfig");
        r100.setEnterFrom("bottom_lynx");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CubeInitConfig r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
