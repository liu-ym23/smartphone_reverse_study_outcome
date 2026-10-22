package com.bytedance.ies.xelement.video.base;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf76/c;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lf76/c;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class DeclarativeVideoPlayBoxViewBaseImpl$setSrc$1$1 extends Lambda implements Function1<f76.c, Unit> {
    final /* synthetic */ String $originUrl;
    final /* synthetic */ DeclarativeVideoPlayBoxViewBaseImpl this$0;

    public DeclarativeVideoPlayBoxViewBaseImpl$setSrc$1$1(String r100, DeclarativeVideoPlayBoxViewBaseImpl r101) {
        this.$originUrl = r100;
        this.this$0 = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f76.c r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (r100.f475770b == null) goto L5;
        String r101 = MSkiaImageRegionDecoder.FILE_PREFIX + r100.f475770b;
    L6:
        DeclarativeVideoPlayBoxViewBaseImpl r102 = this.this$0;
        DeclarativeVideoPlayBoxViewBaseImpl.access$setMNeedVideoReRender$p(r102, DeclarativeVideoPlayBoxViewBaseImpl.access$detect(r102, !Intrinsics.areEqual(r101, DeclarativeVideoPlayBoxViewBaseImpl.access$getMVideoUrl$p(r102))));
        DeclarativeVideoPlayBoxViewBaseImpl.access$setMVideoUrl$p(this.this$0, r101);
        DeclarativeVideoPlayBoxViewBaseImpl.access$renderOnceWithParams(this.this$0);
        return;
    L5:
        r101 = this.$originUrl;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(f76.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
