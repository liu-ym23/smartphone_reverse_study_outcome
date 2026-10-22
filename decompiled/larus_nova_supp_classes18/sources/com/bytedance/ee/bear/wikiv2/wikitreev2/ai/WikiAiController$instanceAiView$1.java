package com.bytedance.ee.bear.wikiv2.wikitreev2.ai;

import android.content.Context;
import com.ss.android.lark.myai.export.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "ctx", "Landroid/content/Context;", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "Lcom/ss/android/lark/myai/export/MyAIChatModeParams;", "Lcom/ss/android/lark/myai/export/MyAIPageControl;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class WikiAiController$instanceAiView$1 extends Lambda implements Function2<Context, Function1<? super Result<? extends com.ss.android.lark.myai.export.b>, ? extends d>, Unit> {
    final /* synthetic */ b $params;
    final /* synthetic */ WikiAiController this$0;

    public WikiAiController$instanceAiView$1(WikiAiController r1, b r2) {
        this.this$0 = r1;
        this.$params = r2;
        super(2);
    }

    public final void invoke(Context r3, Function1<? super Result<com.ss.android.lark.myai.export.b>, ? extends d> r4) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r4, "callback");
        tt5.a.h("WikiAiController", "providerLaunchParams callback=" + r4);
        if (this.this$0.d.a() == false) goto L6;
        tt5.a.h("WikiAiController", "providerLaunchParams debounce return");
        return;
    L6:
        WikiAiController r0 = this.this$0;
        r0.c = r4;
        b r5 = this.$params;
        r0.getClass();
        r0.a(r3, r5, new a(r0, r5, r3));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Context) r1, (Function1) r2);
        return Unit.INSTANCE;
    }
}
