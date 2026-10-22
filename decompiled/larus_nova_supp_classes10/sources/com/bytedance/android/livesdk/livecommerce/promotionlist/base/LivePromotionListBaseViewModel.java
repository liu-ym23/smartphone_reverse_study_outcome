package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.livesdk.livecommerce.iron.ui.i;
import com.bytedance.android.livesdk.livecommerce.room.utils.g;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0011\u0012\b\b\u0002\u0010$\u001a\u00020\u0003¢\u0006\u0004\b-\u0010.J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0005J\u0011\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001R\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8$X¤\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/LivePromotionListBaseViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/QStateViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/c;", "Lcom/bytedance/android/ec/core/async/b;", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/i;", "", "show", "", "updateDialogShowing", "onDestroy", "onCleared", "Ljava/lang/Runnable;", "runnable", "postRunnable", "isDialogShowing", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "remove", "Z", "Lcom/bytedance/android/livesdk/livecommerce/room/utils/g;", "scatterManager", "Lcom/bytedance/android/livesdk/livecommerce/room/utils/g;", "getScatterManager", "()Lcom/bytedance/android/livesdk/livecommerce/room/utils/g;", "Lil/a;", "eventMap", "Lil/a;", "getEventMap", "()Lil/a;", "", "pendingRunnableList", "Ljava/util/List;", "disposableScope", "Lcom/bytedance/android/ec/core/async/b;", "getDisposableScope", "()Lcom/bytedance/android/ec/core/async/b;", "", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/b;", "getSubViewModels", "()Ljava/util/List;", "subViewModels", "<init>", "(Lcom/bytedance/android/ec/core/async/b;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LivePromotionListBaseViewModel extends QStateViewModel<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.c> implements com.bytedance.android.ec.core.async.b, i {
    private final com.bytedance.android.ec.core.async.b disposableScope;
    private final il.a eventMap;
    private boolean isDialogShowing;
    private List<Runnable> pendingRunnableList;
    private final g scatterManager;

    public LivePromotionListBaseViewModel() {
        com.bytedance.android.ec.core.async.b r0 = null;
        this(r0, 1, r0);
    }

    public Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.disposableScope.add(r2);
    }

    public void clearDisposable() {
        this.disposableScope.clearDisposable();
    }

    public CompositeDisposable compositeDisposable() {
        return this.disposableScope.compositeDisposable();
    }

    public abstract List<b> getSubViewModels();

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.disposableScope.remove(r2);
    }

    public void onCleared() {
        super/*com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel*/.onCleared();
        clearDisposable();
        Iterator<T> r0 = getSubViewModels().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).a();
        goto L4
    L6:
        this.scatterManager.a();
        il.a.a(this.eventMap);
        this.pendingRunnableList.clear();
    }

    public final com.bytedance.android.ec.core.async.b getDisposableScope() {
        return this.disposableScope;
    }

    public final il.a getEventMap() {
        return this.eventMap;
    }

    public final g getScatterManager() {
        return this.scatterManager;
    }

    public final boolean isDialogShowing() {
        return this.isDialogShowing;
    }

    public final void onDestroy() {
        onCleared();
    }

    public LivePromotionListBaseViewModel(com.bytedance.android.ec.core.async.b r3) {
        Intrinsics.checkNotNullParameter(r3, "disposableScope");
        super(new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.c(0));
        this.disposableScope = r3;
        this.scatterManager = new g();
        this.eventMap = new il.a();
        this.pendingRunnableList = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.i
    public void postRunnable(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        if (isDialogShowing() == false) goto L8;
        r2.run();
    L6:
        if ((!this.pendingRunnableList.isEmpty()) == false) goto L11;
        ((Runnable) ListProtector.remove(this.pendingRunnableList, 0)).run();
        goto L6
    L11:
        return;
    L8:
        this.pendingRunnableList.add(r2);
    }

    public final void updateDialogShowing(boolean r3) {
        this.isDialogShowing = r3;
        Iterator<T> r0 = getSubViewModels().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).a = r3;
        goto L4
    }

    public /* synthetic */ LivePromotionListBaseViewModel(com.bytedance.android.ec.core.async.b r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new DisposableScope();
    L5:
        this(r1);
    }
}
