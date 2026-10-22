package com.bytedance.ee.bear.more.pageview2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.more.PageViewResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tj5.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/more/pageview2/PageViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pageViewResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/more/PageViewResult;", "pageViewServiceExecutor", "Lcom/bytedance/ee/bear/more/pageview2/PageviewServiceExecutor;", "getPageViewResult", "Landroidx/lifecycle/LiveData;", "getPageView", "", ResourceData.KEY_TYPE, "", ResourceData.KEY_TOKEN, "", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "PageViewModel";
    private final MutableLiveData<PageViewResult> pageViewResult;
    private final k pageViewServiceExecutor;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PageViewModel a;

        public b(PageViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData r0 = PageViewModel.access$getPageViewResult$p(this.a);
            r0.setValue((PageViewResult) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PageViewModel a;

        public c(PageViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            PageViewModel.access$getPageViewResult$p(this.a).setValue(null);
            tt5.a.e(PageViewModel.TAG, "pullPageViewResult err.", (Throwable) r4, false);
        }
    }

    static {
        Companion = new a();
    }

    public PageViewModel() {
        this.pageViewResult = new MutableLiveData();
        this.pageViewServiceExecutor = new k();
    }

    public final LiveData<PageViewResult> getPageViewResult() {
        return this.pageViewResult;
    }

    public static final /* synthetic */ MutableLiveData access$getPageViewResult$p(PageViewModel r0) {
        return r0.pageViewResult;
    }

    public final void getPageView(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        NetService.d<PageViewResult> r1 = this.pageViewServiceExecutor.a;
        String r7 = String.valueOf(r5);
        NetService.f r2 = new NetService.f("/api/obj_stats/get/");
        r2.b("obj_type", r7);
        r2.b(ResourceData.KEY_TOKEN, r6);
        r1.a(r2).subscribe(new b(this), new c(this));
    }
}
