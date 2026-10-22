package com.suite.lark.platform.feature.forward.doubao;

import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import com.ss.android.lark.picker.doubao.LarkPicker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DoubaoForwardPicker$applyConfig$1 extends FunctionReferenceImpl implements Function1<SearchResultAdapter, Unit> {
    public DoubaoForwardPicker$applyConfig$1(Object r100) {
        super(1, r100, LarkPicker.class, "attachSearchResultAdapter", "attachSearchResultAdapter(Lcom/ss/android/lark/picker/base/widget/SearchResultAdapter;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchResultAdapter r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SearchResultAdapter r100) {
        ((LarkPicker) this.receiver).attachSearchResultAdapter(r100);
    }
}
