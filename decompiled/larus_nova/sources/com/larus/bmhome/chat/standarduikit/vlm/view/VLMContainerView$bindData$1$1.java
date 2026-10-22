package com.larus.bmhome.chat.standarduikit.vlm.view;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class VLMContainerView$bindData$1$1 extends FunctionReferenceImpl implements Function1<Integer, List<? extends Pair<? extends Integer, ? extends View>>> {
    public VLMContainerView$bindData$1$1(Object r100) {
        super(1, r100, VLMContainerView.class, "dynamicGetRestoreView", "dynamicGetRestoreView(I)Ljava/util/List;", 0);
    }

    public final List<Pair<Integer, View>> invoke(int r100) {
        VLMContainerView r101 = (VLMContainerView) this.receiver;
        int r102 = VLMContainerView.f309880k;
        return r101.x(r100, true);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends Pair<? extends Integer, ? extends View>> invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
