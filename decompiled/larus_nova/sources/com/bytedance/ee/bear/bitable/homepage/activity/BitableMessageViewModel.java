package com.bytedance.ee.bear.bitable.homepage.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.list.homepage.banner.BitableBannerConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n0\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0010H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/BitableMessageViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "homePageList", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/homepage/activity/HomePageData;", "Lkotlin/collections/ArrayList;", VideoThumbInfo.KEY_INTERVAL, "", "getHomePageListData", "Landroidx/lifecycle/LiveData;", "fetchHomePageData", "", "startTask", "clearTask", "onCleared", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMessageViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "BitableMessageViewModel";
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<ArrayList<HomePageData>> homePageList;
    private final long interval;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMessageViewModel f212289a;

        public b(BitableMessageViewModel r100) {
            this.f212289a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MutableLiveData r101 = BitableMessageViewModel.access$getHomePageList$p(this.f212289a);
            r101.postValue((ArrayList) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMessageViewModel f212290a;

        public c(BitableMessageViewModel r100) {
            this.f212290a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BitableMessageViewModel.access$getHomePageList$p(this.f212290a).postValue(null);
            tt5.a.e(BitableMessageViewModel.TAG, "fetch homepage data err", (Throwable) r100, false);
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMessageViewModel f212291a;

        public d(BitableMessageViewModel r100) {
            this.f212291a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Flowable r101 = (Flowable) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return r101.delay(BitableMessageViewModel.access$getInterval$p(this.f212291a), TimeUnit.MILLISECONDS);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMessageViewModel f212292a;

        public e(BitableMessageViewModel r100) {
            this.f212292a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MutableLiveData r101 = BitableMessageViewModel.access$getHomePageList$p(this.f212292a);
            r101.postValue((ArrayList) r100);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMessageViewModel f212293a;

        public f(BitableMessageViewModel r100) {
            this.f212293a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BitableMessageViewModel.access$getHomePageList$p(this.f212293a).postValue(null);
            tt5.a.e(BitableMessageViewModel.TAG, "err", (Throwable) r100, false);
        }
    }

    static {
        Companion = new a();
    }

    public final void clearTask() {
        this.compositeDisposable.clear();
    }

    public final void startTask() {
        if (this.interval <= 0) goto L6;
        Disposable r100 = com.bytedance.ee.bear.bitable.homepage.activity.a.a().repeatWhen(new d(this)).subscribe(new e(this), new f(this));
        this.compositeDisposable.add(r100);
        return;
    }

    public BitableMessageViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.homePageList = new MutableLiveData();
        BitableBannerConfig r100 = (BitableBannerConfig) SettingManager.getInstance().get(BitableBannerConfig.class);
        if (r100 == null) goto L7;
        Long r101 = r100.getActivityFetchInterval();
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        this.interval = r102;
        return;
    L7:
        r102 = -1;
        goto L8
    }

    public final void fetchHomePageData() {
        Disposable r100 = com.bytedance.ee.bear.bitable.homepage.activity.a.a().subscribe(new b(this), new c(this));
        this.compositeDisposable.add(r100);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
    }

    public final LiveData<ArrayList<HomePageData>> getHomePageListData() {
        return this.homePageList;
    }

    public static final /* synthetic */ MutableLiveData access$getHomePageList$p(BitableMessageViewModel r100) {
        return r100.homePageList;
    }

    public static final /* synthetic */ long access$getInterval$p(BitableMessageViewModel r100) {
        return r100.interval;
    }
}
