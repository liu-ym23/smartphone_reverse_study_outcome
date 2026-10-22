package com.ss.android.lark.keyboard.edittext2.list;

import android.text.Editable;
import android.text.Selection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class EditorListApplier$innerSpanWatcher$1 extends FunctionReferenceImpl implements Function2<Editable, Object, Unit> {
    public EditorListApplier$innerSpanWatcher$1(Object r100) {
        super(2, r100, EditorListApplier.class, "handleSpanChange", "handleSpanChange(Landroid/text/Editable;Ljava/lang/Object;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        EditorListApplier r102 = (EditorListApplier) this.receiver;
        int r103 = EditorListApplier.f429112o;
        r102.getClass();
        Object r104 = Selection.SELECTION_START;
        Object r105 = Selection.SELECTION_END;
        if (Intrinsics.areEqual(r101, r104) == false) goto L5;
    L7:
        r102.f429124l.c(r100, Selection.getSelectionStart(r100), Selection.getSelectionEnd(r100));
        return;
    L5:
        if (Intrinsics.areEqual(r101, r105) == true) goto L7;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Editable r100, Object r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
