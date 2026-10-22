package com.ss.android.lark.flow.feed.data;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.flow.feed.utils.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import f0c.h;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class DoubaoFeedMigrateStatus implements com.ss.android.lark.flow.feed.data.a, r {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus> f423362j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicBoolean f423363k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f423364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f423365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f423366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f423367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f423368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<hza.a> f423369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f423370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f423371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f423372i;

    public static final class a {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    static {
        f423362j = CollectionsKt.listOf(new com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus[]{com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus.MIGRATE_STATUS_PROCESSED_FIRST_SCREEN, com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus.MIGRATE_STATUS_FINISHED});
        f423363k = new AtomicBoolean(false);
    }

    public final void d() {
        Disposable r100 = (Disposable) this.f423372i.getValue();
        if (f().get() == false) goto L7;
        b.d("DoubaoFeedMigrateStatus", "not need to fetch migrate status");
        return;
    L7:
        if (this.f423370g.compareAndSet(false, true) == true) goto L10;
        b.d("DoubaoFeedMigrateStatus", "has already fetch migrate status");
        return;
    L10:
        BuildersKt.launch$default(this.f423371h, null, null, new DoubaoFeedMigrateStatus$ensureSubscribed$1(this, null), 3, null);
    }

    public final KVRepo e() {
        return (KVRepo) this.f423367d.getValue();
    }

    public final AtomicBoolean f() {
        return (AtomicBoolean) this.f423368e.getValue();
    }

    @Override // com.ss.android.lark.flow.feed.data.a
    public final boolean b() {
        d();
        boolean r100 = f().get();
        b.d("DoubaoFeedMigrateStatus", "isMigrateFinished value: " + r100 + ' ');
        return r100;
    }

    public final void g() {
        if (f().compareAndSet(false, true) == false) goto L12;
        e().putBoolean("mixed_feed_migrate", true);
        b.d("DoubaoFeedMigrateStatus", "migrate finished, notify " + ((CopyOnWriteArraySet) this.f423369f).size() + " listeners");
        Iterator<T> r100 = this.f423369f.iterator();
    L6:
        if (r100.hasNext() == false) goto L19;
        hza.a r101 = (hza.a) r100.next();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        r101.a(this.f423366c.getUser().userId);     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    L19:
        return;
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f423366c;
    }

    @Override // com.ss.android.lark.flow.feed.data.a
    public final void a(hza.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        b.d("DoubaoFeedMigrateStatus", "add migrate listener");
        d();
        ((CopyOnWriteArraySet) this.f423369f).add(r100);
        if (f().get() == false) goto L5;
        r100.a(this.f423366c.getUser().userId);
        return;
    L5:
        b.d("DoubaoFeedMigrateStatus", "migrate is not finished yet");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        if (f423363k.compareAndSet(true, false) == false) goto L14;
        b.d("DoubaoFeedMigrateStatus", "afterUserOnline consume pendingClearMigrateStatus, force clear migrate status");
        b.d("DoubaoFeedMigrateStatus", "clearMigrateStatusAndRefresh invoked");
        f().set(false);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        e().remove("mixed_feed_migrate");     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        Intrinsics.checkNotNullParameter("DoubaoFeedMigrateStatus", "tag");
        Log.e("DoubaoFeedMigrateStatus", "[FlowFeedLog] ".concat("clearMigrateStatus error"), r103, true);
    L12:
        this.f423370g.set(false);
        d();
        return;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L14:
        d();
    }

    @Override // com.ss.android.lark.flow.feed.data.a
    public final void c(hza.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        b.d("DoubaoFeedMigrateStatus", "remove migrate listener");
        ((CopyOnWriteArraySet) this.f423369f).remove(r100);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        ((Disposable) this.f423372i.getValue()).dispose();     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L13:
        CoroutineScopeKt.cancel$default(this.f423371h, null, 1, null);     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        ((CopyOnWriteArraySet) this.f423369f).clear();
        return;
    L9:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Inject
    public DoubaoFeedMigrateStatus(String r100, l r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userRustClient");
        Intrinsics.checkNotNullParameter(r102, "passport");
        this.f423364a = r100;
        this.f423365b = r101;
        this.f423366c = r102;
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.f423367d = LazyKt.lazy(r103, DoubaoFeedMigrateStatus$kvRepo$2.INSTANCE);
        this.f423368e = LazyKt.lazy(r103, new DoubaoFeedMigrateStatus$migrateFinished$2(this));
        this.f423369f = new CopyOnWriteArraySet();
        this.f423370g = new AtomicBoolean(false);
        this.f423371h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f423372i = LazyKt.lazy(r103, new DoubaoFeedMigrateStatus$pushDisposable$2(this));
        r102.d(this);
    }
}
