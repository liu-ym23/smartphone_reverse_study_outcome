package com.ss.android.lark.keyboard.classicinput;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class TextInputSupportPlugin$setupHint$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CharSequence $hint;
    final /* synthetic */ int $hintColor;
    final /* synthetic */ a this$0;

    public TextInputSupportPlugin$setupHint$1(int r100, a r101, CharSequence r102) {
        this.$hintColor = r100;
        this.this$0 = r101;
        this.$hint = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$hintColor == 0) goto L8;
        KeyboardFunctionEditText r100 = this.this$0.f428650o;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r100 = null;
    L7:
        r100.setHintTextColor(this.$hintColor);
    L8:
        this.this$0.z(this.$hint);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
