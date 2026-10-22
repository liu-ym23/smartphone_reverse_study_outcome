package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.Mode;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core.IPreloadResultListener;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncTaskExecutor;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/async/AsyncCreateManager;", "", "Config", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsyncCreateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Integer, Boolean, RecyclerView.ViewHolder> f450629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IAsyncLoad<?> f450630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f450631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Integer> f450632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f450633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Mode f450634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AsyncTaskExecutor<RecyclerView.ViewHolder> f450635g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/async/AsyncCreateManager$Config;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Config {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView f450636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IAsyncLoad<?> f450637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function2<Integer, Boolean, RecyclerView.ViewHolder> f450638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ExecutorService f450639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Set<Integer> f450640e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final IPreloadResultListener f450641f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Mode f450642g;

        public Config(RecyclerView r100, IAsyncLoad r101, Function2 r102, ExecutorService r103, Mode r104) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "loader");
            Intrinsics.checkNotNullParameter(r102, "createViewHolder");
            Intrinsics.checkNotNullParameter(r103, "executor");
            Intrinsics.checkNotNullParameter(r104, "viewHolderCreateMode");
            this.f450636a = r100;
            this.f450637b = r101;
            this.f450638c = r102;
            this.f450639d = r103;
            this.f450640e = null;
            this.f450641f = null;
            this.f450642g = r104;
        }
    }

    public AsyncCreateManager(Config r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f450629a = r100.f450638c;
        this.f450630b = r100.f450637b;
        ExecutorService r101 = r100.f450639d;
        this.f450631c = r101;
        this.f450632d = r100.f450640e;
        this.f450633e = r100.f450636a;
        this.f450634f = r100.f450642g;
        this.f450635g = new AsyncTaskExecutor(new AsyncTaskExecutor.Companion.Config(r101));
    }
}
