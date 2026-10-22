package com.ss.ugc.effectplatform.task;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class DownloadEffectListTask$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $downloadedEffectList;
    final /* synthetic */ u this$0;

    public DownloadEffectListTask$onSuccess$1(u r100, List r101) {
        this.this$0 = r100;
        this.$downloadedEffectList = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        u r100 = this.this$0;
        IEffectPlatformBaseListener r101 = r100.f457953l.N.a(r100.f457955n);
        if (r101 == null) goto L5;
        r101.onSuccess(this.$downloadedEffectList);
    L5:
        u r102 = this.this$0;
        r102.f457953l.N.c(r102.f457955n);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
