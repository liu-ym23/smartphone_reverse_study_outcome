package com.ss.android.lark.keyboard.editor;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FlowTextInputPlugin$setupHint$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CharSequence $hint;
    final /* synthetic */ int $hintColor;
    final /* synthetic */ i this$0;

    public FlowTextInputPlugin$setupHint$1(int r100, i r101, CharSequence r102) {
        this.$hintColor = r100;
        this.$hint = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$hintColor == 0) goto L6;
        int r100 = i.f428775a;
        throw null;
    L6:
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
