package com.bytedance.ee.bear.document.ai.citation;

import androidx.lifecycle.ViewModel;
import com.ss.android.lark.widget.utils.SingleLiveEvent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationCallbackBridgeViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "callbackEvent", "Lcom/ss/android/lark/widget/utils/SingleLiveEvent;", "Lkotlin/Pair;", "", "getCallbackEvent", "()Lcom/ss/android/lark/widget/utils/SingleLiveEvent;", "emit", "", "id", "type", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocAICitationCallbackBridgeViewModel extends ViewModel {
    private final SingleLiveEvent<Pair<String, String>> callbackEvent;

    public DocAICitationCallbackBridgeViewModel() {
        this.callbackEvent = new SingleLiveEvent();
    }

    public final SingleLiveEvent<Pair<String, String>> getCallbackEvent() {
        return this.callbackEvent;
    }

    public final void emit(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.callbackEvent.setValue(new Pair(r100, r101));
    }
}
