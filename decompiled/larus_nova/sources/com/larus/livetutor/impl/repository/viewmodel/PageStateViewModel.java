package com.larus.livetutor.impl.repository.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0096\u0001\u0010\u0010\u001a\u00020\u00072\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005J\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000fJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/livetutor/impl/repository/viewmodel/PageStateViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "loadSuccess", "Lkotlin/Function1;", "Lcom/larus/livetutor/impl/repository/viewmodel/PageChildState;", "", "loadLoading", "loadNoData", "loadNoNetwork", "loadError", "loadLocalRefresh", "mLoadingStatusLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/livetutor/impl/repository/viewmodel/PageStateViewModel$RefreshStatus;", "onPageState", "observeLiveDataLoadingStatus", "notifyPageRefreshStatus", "state", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "pageStateLog", "info", "", "RefreshStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PageStateViewModel extends ViewModel {
    private Function1<? super l0, Unit> loadError;
    private Function1<? super l0, Unit> loadLoading;
    private Function1<? super l0, Unit> loadLocalRefresh;
    private Function1<? super l0, Unit> loadNoData;
    private Function1<? super l0, Unit> loadNoNetwork;
    private Function1<? super l0, Unit> loadSuccess;
    private final MutableLiveData<RefreshStatus> mLoadingStatusLiveData;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/livetutor/impl/repository/viewmodel/PageStateViewModel$RefreshStatus;", "", "pageChildState", "Lcom/larus/livetutor/impl/repository/viewmodel/PageChildState;", "<init>", "(Ljava/lang/String;ILcom/larus/livetutor/impl/repository/viewmodel/PageChildState;)V", "getPageChildState", "()Lcom/larus/livetutor/impl/repository/viewmodel/PageChildState;", "setPageChildState", "(Lcom/larus/livetutor/impl/repository/viewmodel/PageChildState;)V", "LOADING", "SUCCESS", "NO_DATA", "NO_NETWORK", "API_ERROR", "LOCAL_REFRESH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RefreshStatus extends Enum<RefreshStatus> {
        public static final RefreshStatus API_ERROR = null;
        public static final RefreshStatus LOADING = null;
        public static final RefreshStatus LOCAL_REFRESH = null;
        public static final RefreshStatus NO_DATA = null;
        public static final RefreshStatus NO_NETWORK = null;
        public static final RefreshStatus SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RefreshStatus[] f356192a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f356193b = null;
        private l0 pageChildState;

        public static EnumEntries<RefreshStatus> getEntries() {
            return f356193b;
        }

        static {
            RefreshStatus r100 = new RefreshStatus("LOADING", 0, new com.larus.livetutor.impl.repository.viewmodel.a("loading"));
            LOADING = r100;
            RefreshStatus r101 = new RefreshStatus("SUCCESS", 1, new com.larus.livetutor.impl.repository.viewmodel.a("success"));
            SUCCESS = r101;
            RefreshStatus r102 = new RefreshStatus("NO_DATA", 2, new com.larus.livetutor.impl.repository.viewmodel.a("no data"));
            NO_DATA = r102;
            RefreshStatus r103 = new RefreshStatus("NO_NETWORK", 3, new com.larus.livetutor.impl.repository.viewmodel.a("no network"));
            NO_NETWORK = r103;
            RefreshStatus r104 = new RefreshStatus("API_ERROR", 4, new com.larus.livetutor.impl.repository.viewmodel.a("api error"));
            API_ERROR = r104;
            RefreshStatus r105 = new RefreshStatus("LOCAL_REFRESH", 5, new com.larus.livetutor.impl.repository.viewmodel.a("local refresh"));
            LOCAL_REFRESH = r105;
            RefreshStatus[] r110 = {r100, r101, r102, r103, r104, r105};
            f356192a = r110;
            f356193b = EnumEntriesKt.enumEntries(r110);
        }

        public static RefreshStatus[] values() {
            return (RefreshStatus[]) f356192a.clone();
        }

        public final l0 getPageChildState() {
            return this.pageChildState;
        }

        public static RefreshStatus valueOf(String r100) {
            return (RefreshStatus) r27.a.a(RefreshStatus.class, r100);
        }

        public final void setPageChildState(l0 r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.pageChildState = r100;
        }

        public RefreshStatus(String r100, int r101, com.larus.livetutor.impl.repository.viewmodel.a r102) {
            super(r100, r101);
            this.pageChildState = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f356194a = null;

        static {
            int[] r100 = new int[RefreshStatus.values().length];
            r100[RefreshStatus.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[RefreshStatus.API_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[RefreshStatus.NO_DATA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[RefreshStatus.NO_NETWORK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[RefreshStatus.SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[RefreshStatus.LOCAL_REFRESH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f356194a = r100;
        }
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f356195a;

        public b(m0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f356195a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f356195a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f356195a.invoke(r100);
        }
    }

    public static /* synthetic */ Unit yo(PageStateViewModel r100, RefreshStatus r101) {
        return observeLiveDataLoadingStatus$lambda$2$lambda$1(r100, r101);
    }

    public LifecycleOwner getLifecycleOwner() {
        return null;
    }

    public void pageStateLog(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
    }

    public PageStateViewModel() {
        this.mLoadingStatusLiveData = new MutableLiveData();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.livetutor.impl.repository.viewmodel.m0] */
    public final void observeLiveDataLoadingStatus() {
        if (getLifecycleOwner() == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L12;
        LifecycleOwner r101 = getLifecycleOwner();
        if (r101 == null) goto L13;
        this.mLoadingStatusLiveData.removeObservers(r101);
        this.mLoadingStatusLiveData.observe(r101, new b(new m0(this)));
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("No initialized lifecycle!".toString());
    L5:
        r100 = false;
        goto L6
    }

    public final void notifyPageRefreshStatus(RefreshStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.mLoadingStatusLiveData.postValue(r100);
    }

    private static final Unit observeLiveDataLoadingStatus$lambda$2$lambda$1(PageStateViewModel r100, RefreshStatus r101) {
        r100.pageStateLog("observeLiveDataLoadingStatus state:" + r101 + " pageChildState=" + r101.getPageChildState());
        switch(a.f356194a[r101.ordinal()]) {
            case 1: goto L22;
            case 2: goto L19;
            case 3: goto L16;
            case 4: goto L13;
            case 5: goto L10;
            case 6: goto L7;
            default: goto L4;
        };
    L4:
        Function1<? super l0, Unit> r102 = r100.loadError;
        if (r102 == null) goto L26;
        r102.invoke(r101.getPageChildState());
    L26:
        return Unit.INSTANCE;
    L7:
        Function1<? super l0, Unit> r103 = r100.loadLocalRefresh;
        if (r103 == null) goto L26;
        r103.invoke(r101.getPageChildState());
        goto L26
    L10:
        Function1<? super l0, Unit> r104 = r100.loadSuccess;
        if (r104 == null) goto L26;
        r104.invoke(r101.getPageChildState());
        goto L26
    L13:
        Function1<? super l0, Unit> r105 = r100.loadNoNetwork;
        if (r105 == null) goto L26;
        r105.invoke(r101.getPageChildState());
        goto L26
    L16:
        Function1<? super l0, Unit> r106 = r100.loadNoData;
        if (r106 == null) goto L26;
        r106.invoke(r101.getPageChildState());
        goto L26
    L19:
        Function1<? super l0, Unit> r107 = r100.loadError;
        if (r107 == null) goto L26;
        r107.invoke(r101.getPageChildState());
        goto L26
    L22:
        Function1<? super l0, Unit> r108 = r100.loadLoading;
        if (r108 == null) goto L26;
        r108.invoke(r101.getPageChildState());
        goto L26
    }

    public final void onPageState(Function1<? super l0, Unit> r100, Function1<? super l0, Unit> r101, Function1<? super l0, Unit> r102, Function1<? super l0, Unit> r103, Function1<? super l0, Unit> r104, Function1<? super l0, Unit> r105) {
        this.loadSuccess = r100;
        this.loadLoading = r101;
        this.loadNoData = r102;
        this.loadNoNetwork = r104;
        this.loadError = r103;
        this.loadLocalRefresh = r105;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onPageState$default(PageStateViewModel r100, Function1 r101, Function1 r102, Function1 r103, Function1 r104, Function1 r105, Function1 r106, int r107, Object r108) {
        if (r108 != null) goto L24;
        if ((r107 & 1) == 0) goto L7;
        r101 = null;
    L7:
        if ((r107 & 2) == 0) goto L10;
        r102 = null;
    L10:
        if ((r107 & 4) == 0) goto L13;
        r103 = null;
    L13:
        if ((r107 & 8) == 0) goto L16;
        r104 = null;
    L16:
        if ((r107 & 16) == 0) goto L19;
        r105 = null;
    L19:
        if ((r107 & 32) == 0) goto L21;
        r106 = null;
    L21:
        r100.onPageState(r101, r102, r103, r104, r105, r106);
        return;
    L24:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPageState");
    }
}
