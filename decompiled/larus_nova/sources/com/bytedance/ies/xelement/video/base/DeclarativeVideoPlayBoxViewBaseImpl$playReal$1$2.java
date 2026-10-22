package com.bytedance.ies.xelement.video.base;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeclarativeVideoPlayBoxViewBaseImpl$playReal$1$2 extends Lambda implements Function2<Throwable, Boolean, Unit> {
    final /* synthetic */ String $originUrl;
    final /* synthetic */ Function0<Unit> $playCB;
    final /* synthetic */ DeclarativeVideoPlayBoxViewBaseImpl this$0;

    public DeclarativeVideoPlayBoxViewBaseImpl$playReal$1$2(DeclarativeVideoPlayBoxViewBaseImpl r100, String r101, Function0<Unit> r102) {
        this.this$0 = r100;
        this.$originUrl = r101;
        this.$playCB = r102;
        super(2);
    }

    public final void invoke(Throwable r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
        DeclarativeVideoPlayBoxViewBaseImpl.access$setMVideoUrl$p(this.this$0, this.$originUrl);
        DeclarativeVideoPlayBoxViewBaseImpl.access$initVideoContainer(this.this$0);
        DeclarativeVideoPlayBoxViewBaseImpl.access$legacyPlay(this.this$0, this.$playCB);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }
}
