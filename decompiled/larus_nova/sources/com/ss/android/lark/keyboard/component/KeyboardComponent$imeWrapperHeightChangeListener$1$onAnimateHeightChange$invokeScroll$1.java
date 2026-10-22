package com.ss.android.lark.keyboard.component;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollAlign;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class KeyboardComponent$imeWrapperHeightChangeListener$1$onAnimateHeightChange$invokeScroll$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ KeyboardComponent this$0;

    public KeyboardComponent$imeWrapperHeightChangeListener$1$onAnimateHeightChange$invokeScroll$1(KeyboardComponent r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getClass();
        ScrollScene r100 = ScrollScene.KEYBOARD;
        Intrinsics.checkNotNullParameter(r100, "scene");
        Function1<RecyclerView, Integer> r101 = ScrollEvent.f410222j;
        Intrinsics.checkNotNullParameter(r101, "value");
        ScrollAlign r102 = ScrollAlign.BOTTOM;
        Intrinsics.checkNotNullParameter(r102, "value");
        new ScrollEvent(r100, r101, null, r102, false, 0, new b(null));
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
