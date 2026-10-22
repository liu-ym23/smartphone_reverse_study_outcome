package com.bytedance.ee.bear.document.sharewords;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsData;
import com.ss.android.lark.widget.utils.SingleLiveEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/ShareWordsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "shareWordsData", "Lcom/ss/android/lark/widget/utils/SingleLiveEvent;", "Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsData;", "getShareWordsData", "updateShareWordsData", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareWordsViewModel extends ViewModel {
    private final SingleLiveEvent<ShareWordsData> shareWordsData;

    public ShareWordsViewModel() {
        this.shareWordsData = new SingleLiveEvent();
    }

    public final SingleLiveEvent<ShareWordsData> getShareWordsData() {
        return this.shareWordsData;
    }

    public final void updateShareWordsData(ShareWordsData r100) {
        this.shareWordsData.setValue(r100);
    }
}
