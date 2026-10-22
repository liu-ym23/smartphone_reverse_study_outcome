package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.home.api.GetSpacePuller;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0002'(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001e\u001a\u00020\u0012J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0018\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListViewModel;", "Landroidx/lifecycle/ViewModel;", "spaceType", "", "<init>", "(I)V", "getSpaceType", "()I", "spaceList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "getSpaceList", "()Landroidx/lifecycle/MutableLiveData;", "failure", "", "getFailure", "value", "", "hasmore", "getHasmore", "()Z", "fromDb", "getFromDb", "lastLabel", "", "puller", "Lcom/bytedance/ee/bear/wikiv2/home/api/GetSpacePuller;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "hasData", "load", "", "loadmore", "doPull", "replace", "saveDb", "doLoadFromDb", "onCleared", "Companion", "Factory", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceListViewModel extends ViewModel {
    public static final a Companion = null;
    public static final int DEFAULT_NUM = 40;
    private static final String TAG = "WikiSpaceListViewModel";
    private final CompositeDisposable disposable;
    private final MutableLiveData<Throwable> failure;
    private boolean fromDb;
    private boolean hasmore;
    private String lastLabel;
    private final GetSpacePuller puller;
    private final MutableLiveData<List<SpaceBean>> spaceList;
    private final int spaceType;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f240757a;

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        public b(int r100) {
            this.f240757a = r100;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            return new WikiSpaceListViewModel(this.f240757a);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiSpaceListViewModel f240758a;

        public c(WikiSpaceListViewModel r100) {
            this.f240758a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            WikiSpaceListViewModel.access$setFromDb$p(this.f240758a, true);
            MutableLiveData<List<SpaceBean>> r101 = this.f240758a.getSpaceList();
            r101.setValue((List) r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiSpaceListViewModel f240759a;

        public d(WikiSpaceListViewModel r100) {
            this.f240759a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e(WikiSpaceListViewModel.TAG, "doLoadFromDb fail. ", r101, false);
            this.f240759a.getFailure().setValue(r101);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiSpaceListViewModel f240760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f240761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f240762c;

        public e(WikiSpaceListViewModel r100, boolean r101, boolean r102) {
            this.f240760a = r100;
            this.f240761b = r101;
            this.f240762c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            GetSpacePuller.Result r101 = (GetSpacePuller.Result) r100;
            WikiSpaceListViewModel.access$setLastLabel$p(this.f240760a, r101.last_label);
            WikiSpaceListViewModel.access$setHasmore$p(this.f240760a, r101.has_more);
            WikiSpaceListViewModel.access$setFromDb$p(this.f240760a, false);
            if (this.f240761b == false) goto L5;
            ArrayList r102 = new ArrayList();
        L11:
            List r103 = r101.spaces;
            if (r103 != null) goto L14;
            r103 = new ArrayList();
        L14:
            r102.addAll(r103);
            this.f240760a.getSpaceList().setValue(r102);
            if (this.f240762c == false) goto L18;
            int r104 = zp5.f.f573192a;
            zp5.f.b(r103, new ce5.a());
            return;
        L18:
            return;
        L5:
            List<SpaceBean> r105 = this.f240760a.getSpaceList().getValue();
            if ((r105 instanceof ArrayList) == false) goto L8;
            r102 = (ArrayList) r105;
        L9:
            if (r102 != null) goto L11;
            r102 = new ArrayList();
            goto L11
        L8:
            r102 = null;
            goto L9
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiSpaceListViewModel f240763a;

        public f(WikiSpaceListViewModel r100) {
            this.f240763a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.e(WikiSpaceListViewModel.TAG, "doPull space list fail. ", r101, false);
            this.f240763a.getFailure().setValue(r101);
        }
    }

    static {
        Companion = new a();
    }

    private final void doLoadFromDb() {
        CompositeDisposable r100 = this.disposable;
        int r101 = zp5.f.f573192a;
        r100.add(zp5.f.a(this.spaceType, new ce5.a()).observeOn(fo5.d.d()).subscribe(new c(this), new d(this)));
    }

    public final boolean hasData() {
        return !hu5.a.d(this.spaceList.getValue());
    }

    public final void load() {
        tt5.a.h(TAG, "load. ");
        this.lastLabel = "";
        this.hasmore = false;
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == false) goto L6;
        doPull(true, true);
        return;
    L6:
        if (hu5.a.d(this.spaceList.getValue()) == false) goto L10;
        doLoadFromDb();
        return;
    }

    public final void loadmore() {
        tt5.a.h(TAG, "loadmore. ");
        doPull(false, false);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.disposable.clear();
    }

    public final MutableLiveData<Throwable> getFailure() {
        return this.failure;
    }

    public final boolean getFromDb() {
        return this.fromDb;
    }

    public final boolean getHasmore() {
        return this.hasmore;
    }

    public final MutableLiveData<List<SpaceBean>> getSpaceList() {
        return this.spaceList;
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    public WikiSpaceListViewModel(int r100) {
        this.spaceType = r100;
        this.spaceList = new MutableLiveData();
        this.failure = new MutableLiveData();
        this.lastLabel = "";
        this.puller = new GetSpacePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        this.disposable = new CompositeDisposable();
        load();
    }

    public static final /* synthetic */ void access$setFromDb$p(WikiSpaceListViewModel r100, boolean r101) {
        r100.fromDb = r101;
    }

    public static final /* synthetic */ void access$setHasmore$p(WikiSpaceListViewModel r100, boolean r101) {
        r100.hasmore = r101;
    }

    public static final /* synthetic */ void access$setLastLabel$p(WikiSpaceListViewModel r100, String r101) {
        r100.lastLabel = r101;
    }

    private final void doPull(boolean r100, boolean r101) {
        GetSpacePuller.Params r102 = new GetSpacePuller.Params();
        int r103 = this.spaceType;
        if (r103 != (-1)) goto L5;
        Integer r104 = null;
    L6:
        r102.type = r104;
        r102.size = 40;
        r102.last_label = this.lastLabel;
        this.disposable.add(this.puller.c(r102).subscribe(new e(this, r100, r101), new f(this)));
        return;
    L5:
        r104 = Integer.valueOf(r103);
        goto L6
    }

    @JvmStatic
    public static final WikiSpaceListViewModel newInstance(ViewModelStoreOwner r100, int r101) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (WikiSpaceListViewModel) new ViewModelProvider(r100, new b(r101)).get(WikiSpaceListViewModel.class);
    }
}
