package com.bytedance.ee.bear.document.chatdraftdoc;

import androidx.lifecycle.ViewModel;
import com.ss.android.lark.widget.utils.SingleLiveEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0006J\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/chatdraftdoc/ChatDraftDocViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Lcom/ss/android/lark/widget/utils/SingleLiveEvent;", "", "updateActive", "", "getActive", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatDraftDocViewModel extends ViewModel {
    private final SingleLiveEvent<Boolean> active;

    public ChatDraftDocViewModel() {
        this.active = new SingleLiveEvent();
    }

    public final SingleLiveEvent<Boolean> getActive() {
        return this.active;
    }

    public final void updateActive(boolean r100) {
        this.active.setValue(Boolean.valueOf(r100));
    }
}
