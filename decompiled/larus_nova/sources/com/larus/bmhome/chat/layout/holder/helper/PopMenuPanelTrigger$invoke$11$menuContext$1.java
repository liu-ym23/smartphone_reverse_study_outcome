package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PopMenuPanelTrigger$invoke$11$menuContext$1 extends FunctionReferenceImpl implements Function0<Long> {
    public PopMenuPanelTrigger$invoke$11$menuContext$1(Object r100) {
        super(0, r100, v1.class, "getChatUniqueKey", "getChatUniqueKey(Landroid/view/View;)J", 1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(v1.c((View) this.receiver));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
