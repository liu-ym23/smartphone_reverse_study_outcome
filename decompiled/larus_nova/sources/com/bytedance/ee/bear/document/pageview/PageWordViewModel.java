package com.bytedance.ee.bear.document.pageview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.PageviewResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/document/pageview/PageWordViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pageWordResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/PageviewResult;", "setPageWord", "", "pageWord", "getPageWordResult", "Landroidx/lifecycle/LiveData;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageWordViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "PageWordViewModel";
    private final MutableLiveData<PageviewResult> pageWordResult;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PageWordViewModel() {
        this.pageWordResult = new MutableLiveData();
    }

    public final LiveData<PageviewResult> getPageWordResult() {
        return this.pageWordResult;
    }

    public final void setPageWord(PageviewResult r100) {
        Intrinsics.checkNotNullParameter(r100, "pageWord");
        this.pageWordResult.setValue(r100);
    }
}
