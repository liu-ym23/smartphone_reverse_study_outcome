package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.utils.ApiUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u001b\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0014R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiViewModel;", "Landroidx/lifecycle/ViewModel;", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "_viewMode", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/api/bean/ForsetiViewMode;", "viewMode", "Landroidx/lifecycle/LiveData;", "getViewMode", "()Landroidx/lifecycle/LiveData;", "_secondNodeWidth", "", "secondNodeWidth", "getSecondNodeWidth", "listenerDisposeList", "", "Lkotlin/Function0;", "", "forsetiChainManager", "Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "getForsetiChainManager", "()Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "viewModeListener", "com/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiViewModel$viewModeListener$1", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiViewModel$viewModeListener$1;", "observeForsetiViewMode", "observeSecondNodeWidth", "onCleared", "Companion", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "ForsetiViewModel";
    private final MutableLiveData<Integer> _secondNodeWidth;
    private final MutableLiveData<ForsetiViewMode> _viewMode;
    private WeakReference<FragmentActivity> activityWeakReference;
    private final tua.b forsetiChainManager;
    private List<Function0<Unit>> listenerDisposeList;
    private final c viewModeListener;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.ss.android.lark.api.ui.f {
        public final /* synthetic */ ForsetiViewModel a;

        public final void b() {
        }

        public b(ForsetiViewModel r1) {
            this.a = r1;
        }

        public final void a(int r2) {
            ForsetiViewModel.access$get_secondNodeWidth$p(this.a).postValue(Integer.valueOf(r2));
        }
    }

    public static final class c implements com.ss.android.lark.api.ui.j {
        public final /* synthetic */ ForsetiViewModel a;

        public c(ForsetiViewModel r1) {
            this.a = r1;
        }

        public final void a(ForsetiViewMode r3) {
            Intrinsics.checkNotNullParameter(r3, "viewMode");
            tt5.a.h(ForsetiViewModel.TAG, "onForsetiViewModeChanged: viewMode:" + r3);
            ForsetiViewModel.access$get_viewMode$p(this.a).postValue(r3);
        }
    }

    static {
        Companion = new a();
    }

    private final void observeForsetiViewMode() {
        tua.b r0 = this.forsetiChainManager;
        if (r0 == null) goto L6;
        r0.P(this.viewModeListener);
        return;
    }

    private final void observeSecondNodeWidth() {
        final b r0 = new b(this);
        tua.b r1 = this.forsetiChainManager;
        if (r1 == null) goto L5;
        r1.O(r0);
    L5:
        this.listenerDisposeList.add(new AnonymousClass1(this, r0));
    }

    public void onCleared() {
        super.onCleared();
        tt5.a.h(TAG, "onCleared() called");
        Iterator<T> r0 = this.listenerDisposeList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function0) r0.next()).invoke();
        goto L4
    L6:
        this.listenerDisposeList.clear();
        WeakReference<FragmentActivity> r1 = this.activityWeakReference;
        if (r1 == null) goto L9;
        r1.clear();
    L9:
        this.activityWeakReference = null;
        tua.b r2 = this.forsetiChainManager;
        if (r2 == null) goto L14;
        r2.e(this.viewModeListener);
        return;
    }

    public final tua.b getForsetiChainManager() {
        return this.forsetiChainManager;
    }

    public final LiveData<Integer> getSecondNodeWidth() {
        return this._secondNodeWidth;
    }

    public final LiveData<ForsetiViewMode> getViewMode() {
        return this._viewMode;
    }

    public ForsetiViewModel(WeakReference<FragmentActivity> r3) {
        this.activityWeakReference = r3;
        this._viewMode = new MutableLiveData();
        this._secondNodeWidth = new MutableLiveData();
        this.listenerDisposeList = new ArrayList();
        sua.a r4 = (sua.a) ApiUtils.getApi(sua.a.class);
        WeakReference<FragmentActivity> r0 = this.activityWeakReference;
        tua.b r1 = null;
        if (r0 == null) goto L5;
        FragmentActivity r2 = r0.get();
    L6:
        tua.b r5 = r4.tryGetChainManager(r2);
        if (r5 == null) goto L9;
        r1 = r5;
    L9:
        this.forsetiChainManager = r1;
        this.viewModeListener = new c(this);
        observeForsetiViewMode();
        observeSecondNodeWidth();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final /* synthetic */ MutableLiveData access$get_secondNodeWidth$p(ForsetiViewModel r0) {
        return r0._secondNodeWidth;
    }

    public static final /* synthetic */ MutableLiveData access$get_viewMode$p(ForsetiViewModel r0) {
        return r0._viewMode;
    }
}
