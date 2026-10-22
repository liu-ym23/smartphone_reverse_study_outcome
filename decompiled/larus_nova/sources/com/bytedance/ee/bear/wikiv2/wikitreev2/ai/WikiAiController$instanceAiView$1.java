package com.bytedance.ee.bear.wikiv2.wikitreev2.ai;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.myai.export.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "ctx", "Landroid/content/Context;", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "Lcom/ss/android/lark/myai/export/MyAIChatModeParams;", "Lcom/ss/android/lark/myai/export/MyAIPageControl;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class WikiAiController$instanceAiView$1 extends Lambda implements Function2<Context, Function1<? super Result<? extends com.ss.android.lark.myai.export.b>, ? extends d>, Unit> {
    final /* synthetic */ b $params;
    final /* synthetic */ WikiAiController this$0;

    public WikiAiController$instanceAiView$1(WikiAiController r100, b r101) {
        this.this$0 = r100;
        this.$params = r101;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context r100, Function1<? super Result<com.ss.android.lark.myai.export.b>, ? extends d> r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "callback");
        tt5.a.h("WikiAiController", "providerLaunchParams callback=" + r101);
        if (this.this$0.f241357d.a() == false) goto L6;
        tt5.a.h("WikiAiController", "providerLaunchParams debounce return");
        return;
    L6:
        WikiAiController r102 = this.this$0;
        r102.f241356c = r101;
        b r103 = this.$params;
        r102.getClass();
        r102.a(r100, r103, new a(r102, r103, r100));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Context r100, Function1<? super Result<? extends com.ss.android.lark.myai.export.b>, ? extends d> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
