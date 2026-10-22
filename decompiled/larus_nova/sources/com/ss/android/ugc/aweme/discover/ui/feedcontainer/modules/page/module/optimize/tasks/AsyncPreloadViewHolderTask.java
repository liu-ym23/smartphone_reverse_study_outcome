package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async.IAsyncLoad;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.Mode;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/tasks/AsyncPreloadViewHolderTask;", "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/tasks/AsyncTask;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "d", "I", "getType", "()I", "type", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsyncPreloadViewHolderTask extends AsyncTask<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Future<?> f450719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f450720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f450721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f450722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f450723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f450724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AsyncTaskExecutor<RecyclerView.ViewHolder> f450725h;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncPreloadViewHolderTask$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return true;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }
    }

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncPreloadViewHolderTask$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    @Override // com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncTask
    public final RecyclerView.ViewHolder d() {
        this.f450722e.post(new AsyncPreloadViewHolderTask$run$1(this));
        return null;
    }

    public final int getType() {
        return this.f450721d;
    }

    @Override // com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncTask
    public final void c(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r100, "e");
        this.f450722e.post(new AsyncPreloadViewHolderTask$onException$1(this));
    }

    public AsyncPreloadViewHolderTask(IAsyncLoad r100, int r101, RecyclerView r102, Function0 r103, Function0 r104, AsyncTaskExecutor r105, Mode r106) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        Intrinsics.checkNotNullParameter(r102, "recyclerView");
        Intrinsics.checkNotNullParameter(r103, "canContinue");
        Intrinsics.checkNotNullParameter(r104, "onComplete");
        Intrinsics.checkNotNullParameter(r105, "createTaskExecutor");
        Intrinsics.checkNotNullParameter(r106, "viewHolderCreateMode");
        this.f450720c = r100;
        this.f450721d = r101;
        this.f450722e = r102;
        this.f450723f = r103;
        this.f450724g = r104;
        this.f450725h = r105;
    }
}
