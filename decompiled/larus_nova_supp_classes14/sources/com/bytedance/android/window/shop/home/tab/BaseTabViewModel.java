package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\n\u001a\u00020\t2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\u0006J\"\u0010\u000b\u001a\u00020\t2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\u0006J\u0014\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u0016\u001a\u00020\u0006J9\u0010\u001b\u001a\u00020\u00022*\u0010\u001a\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0019\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/BaseTabViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "", "loadData", "Lfo/a;", "", "", "key", "id", "", "shouldReportEvent", "isIdFirstShowing", "Lkotlin/Function0;", "runnable", "runLowPriorityTask", "", "", "getVideoIdCache", "Lrp3/a;", "getAwemeInfoInterceptor", "Lpq3/a;", "getInterceptors", "currentProductId", "", "getExcludedList", "", "keys", "dropRecords", "([Lfo/a;)V", "Lcom/bytedance/android/window/shop/home/tab/a;", "taskMgr", "Lcom/bytedance/android/window/shop/home/tab/a;", "Lfo/b;", "uniqueKeyStoreMap", "Lfo/b;", "awemeInterceptor", "Lrp3/a;", "Lrp3/b;", "videoIdInterceptor", "Lrp3/b;", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseTabViewModel extends BaseViewModel {
    public static final a Companion = null;
    private static final int EXCLUDE_PRODUCT_ID_DISTANCE = 10;
    private final rp3.a awemeInterceptor;
    private final com.bytedance.android.window.shop.home.tab.a taskMgr;
    private final fo.b uniqueKeyStoreMap;
    private final rp3.b videoIdInterceptor;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BaseTabViewModel() {
        super(null, null, 3, null);
        this.taskMgr = new com.bytedance.android.window.shop.home.tab.a();
        fo.b r0 = new fo.b();
        r0.d(wn.a.g, new LinkedHashSet());
        Unit r1 = Unit.INSTANCE;
        this.uniqueKeyStoreMap = r0;
        this.awemeInterceptor = new rp3.a(new BaseTabViewModel$awemeInterceptor$1(this));
        this.videoIdInterceptor = new rp3.b();
    }

    public final List<pq3.a> getInterceptors() {
        return CollectionsKt.listOf(new pq3.a[]{this.awemeInterceptor, this.videoIdInterceptor});
    }

    public abstract void loadData();

    public final List<Long> getVideoIdCache() {
        return CollectionsKt.toList(this.videoIdInterceptor.a);
    }

    public final rp3.a getAwemeInfoInterceptor() {
        return this.awemeInterceptor;
    }

    public final void dropRecords(fo.a<Set<String>>... r5) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        fo.a<Set<String>> r2 = r5[r1];
        this.uniqueKeyStoreMap.c(r2);
        r1 = r1 + 1;
        goto L3
    }

    public final Set<String> getExcludedList(String r4) {
        Intrinsics.checkNotNullParameter(r4, "currentProductId");
        fo.b r0 = this.uniqueKeyStoreMap;
        fo.a r1 = wn.a.a;
        Set r2 = (Set) r0.a(wn.a.g);
        if (r2 == null) goto L14;
        List r3 = CollectionsKt.toList(r2);
        if (r3 == null) goto L14;
        int r5 = r3.indexOf(r4);
        if (r5 >= 0) goto L12;
        return SetsKt.emptySet();
    L12:
        return CollectionsKt.toSet(r3.subList(RangesKt.coerceAtLeast(r5 - 10, 0), RangesKt.coerceAtMost(r5 + 10, r3.size())));
    L14:
        return SetsKt.emptySet();
    }

    public final void runLowPriorityTask(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        this.taskMgr.a(r2);
    }

    public final boolean isIdFirstShowing(fo.a<Set<String>> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "id");
        Set r0 = (Set) this.uniqueKeyStoreMap.a(r3);
        if (r0 != null) goto L6;
        r0 = new HashSet();
        this.uniqueKeyStoreMap.b(r3, r0);
    L6:
        if (r0.contains(r4) == false) goto L9;
        return false;
    L9:
        r0.add(r4);
        return true;
    }

    public final boolean shouldReportEvent(fo.a<Set<String>> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "id");
        return isIdFirstShowing(r2, r3);
    }
}
