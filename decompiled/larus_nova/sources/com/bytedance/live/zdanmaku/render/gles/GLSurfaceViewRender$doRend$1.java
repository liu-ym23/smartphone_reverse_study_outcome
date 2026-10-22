package com.bytedance.live.zdanmaku.render.gles;

import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import qk6.b;
import qk6.c;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "Lcom/bytedance/live/artist/render/RenderEntity;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class GLSurfaceViewRender$doRend$1 extends Lambda implements Function1<RenderEntity, Unit> {
    final /* synthetic */ GLSurfaceViewRender.c $param;
    final /* synthetic */ boolean $sizeChanged;

    public GLSurfaceViewRender$doRend$1(boolean r100, GLSurfaceViewRender.c r101) {
        this.$sizeChanged = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderEntity r100) {
        final c r101 = (c) r100.e(c.class);
        final b r102 = (b) r100.e(b.class);
        final qk6.a r103 = (qk6.a) r100.e(qk6.a.class);
        r100.d(new AnonymousClass1(this, r101, r102, r103));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderEntity r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
