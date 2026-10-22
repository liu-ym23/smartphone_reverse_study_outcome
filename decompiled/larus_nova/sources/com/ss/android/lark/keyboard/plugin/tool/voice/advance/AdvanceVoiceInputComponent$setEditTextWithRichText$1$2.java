package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import android.text.SpannableStringBuilder;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AdvanceVoiceInputComponent$setEditTextWithRichText$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FunctionEditText $it;
    final /* synthetic */ Ref.ObjectRef<SpannableStringBuilder> $resultSpan;
    final /* synthetic */ b this$0;

    public AdvanceVoiceInputComponent$setEditTextWithRichText$1$2(FunctionEditText r100, Ref.ObjectRef<SpannableStringBuilder> r101, b r102) {
        this.$it = r100;
        this.$resultSpan = r101;
        this.this$0 = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$it.setText(this.$resultSpan.element);
        this.this$0.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
