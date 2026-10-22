package com.bytedance.android.shopping.sku.inner.container;

import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.repo.SkuYataQueryFetcher;
import com.bytedance.android.shopping.sku.inner.repo.SkuYataQueryFetcherHolder;
import com.bytedance.android.shopping.sku.inner.tracker.SkuYataTracker;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0014J0\u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0006\u0010\u0016\u001a\u00020\u0005R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R(\u0010(\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0013\u0010/\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u00103\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/container/SkuYataViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/sku/inner/container/SkuYataState;", "Lcom/bytedance/android/shopping/sku/inner/repo/b;", "firstScreenQuery", "", "showPageState", "defaultState", "Lcom/bytedance/android/ec/model/sku/SkuParams;", "skuParams", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaParams;", "skuSchemaParams", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "", "sessionId", "Landroidx/fragment/app/Fragment;", "skuYataFragment", "init", "Lcom/bytedance/android/shopping/sku/inner/container/SkuYataQueryFrom;", "queryFrom", "requestQuery", "release", "Lcom/bytedance/android/ec/model/sku/SkuParams;", "getSkuParams", "()Lcom/bytedance/android/ec/model/sku/SkuParams;", "setSkuParams", "(Lcom/bytedance/android/ec/model/sku/SkuParams;)V", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaParams;", "getSkuSchemaParams", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaParams;", "setSkuSchemaParams", "(Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaParams;)V", "Lcom/bytedance/android/shopping/sku/inner/container/h0;", "staticState", "Lcom/bytedance/android/shopping/sku/inner/container/h0;", "getStaticState", "()Lcom/bytedance/android/shopping/sku/inner/container/h0;", "Lcom/bytedance/android/shopping/sku/inner/repo/SkuYataQueryFetcher;", "<set-?>", "queryFetcher", "Lcom/bytedance/android/shopping/sku/inner/repo/SkuYataQueryFetcher;", "getQueryFetcher", "()Lcom/bytedance/android/shopping/sku/inner/repo/SkuYataQueryFetcher;", "Lmh3/a;", "getMonitorManager", "()Lmh3/a;", "monitorManager", "Lcom/bytedance/android/shopping/sku/inner/tracker/SkuYataTracker;", "getTracker", "()Lcom/bytedance/android/shopping/sku/inner/tracker/SkuYataTracker;", "tracker", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuYataViewModel extends JediViewModel<SkuYataState> {
    private SkuYataQueryFetcher queryFetcher;
    private SkuParams skuParams;
    private SkuSchemaParams skuSchemaParams;
    private final h0 staticState;

    public SkuYataViewModel() {
        this.skuParams = new SkuParams(null, null, null, null, null, 0, null, null, null, false, false, null, null, false, "", "", null, false, null, null, null, null, null, null, null, false, 0, 101, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, null, null, null, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, 0, "SkuYataViewModel", null, null, null, null, null, false, null, null, null, null, null, null, null, 0, 0, false, null, null, null, false, null, null, null, null, null, null, null, null, -134266881, -1, -257, 31, null);
        this.staticState = new h0(0);
    }

    public SkuYataState defaultState() {
        return new SkuYataState(null, null);
    }

    public final mh3.a getMonitorManager() {
        SkuYataQueryFetcher r0 = this.queryFetcher;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final SkuYataTracker getTracker() {
        SkuYataQueryFetcher r0 = this.queryFetcher;
        if (r0 == null) goto L7;
        SkuYataTracker r1 = r0.b;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new SkuYataTracker(this.skuParams);
    }

    public final void release() {
        SkuYataQueryFetcher r0 = this.queryFetcher;
        if (r0 == null) goto L9;
        r0.d = null;
        Disposable r1 = r0.e;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        SkuYataQueryFetcherHolder r2 = SkuYataQueryFetcherHolder.INSTANCE;
        r2.remove(r0.i);
        Lazy r3 = SkuCommonLog.a;
        SkuCommonLog.c("SkuYataQueryFetcher", "fetchers size: " + r2.size());
        return;
    }

    public final SkuYataQueryFetcher getQueryFetcher() {
        return this.queryFetcher;
    }

    public final SkuParams getSkuParams() {
        return this.skuParams;
    }

    public final SkuSchemaParams getSkuSchemaParams() {
        return this.skuSchemaParams;
    }

    public final h0 getStaticState() {
        return this.staticState;
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ State m2857defaultState() {
        return defaultState();
    }

    public static final /* synthetic */ SkuYataQueryFetcher access$getQueryFetcher$p(SkuYataViewModel r0) {
        return r0.queryFetcher;
    }

    private final void showPageState(com.bytedance.android.shopping.sku.inner.repo.b r3) {
        o r0 = r3.b;
        if (r0 == null) goto L5;
        SkuYataSkeletonLoadingStatus r1 = r0.a;
    L6:
        if (r1 == null) goto L14;
        int r2 = i0.a[r1.ordinal()];
        if (r2 != 1) goto L11;
        setState(new AnonymousClass1(this));
        return;
    L11:
        if (r2 != 2) goto L13;
        final f0 r4 = r3.a;
        if (r4 == null) goto L23;
        setState(new SkuYataViewModel$showPageState$2$1(r4));
        return;
    L23:
        return;
    L13:
        if (r2 != 3) goto L14;
        setState(AnonymousClass3.INSTANCE);
        return;
    L14:
        SkuCommonLog.c("SkuYataViewModel", "errorStatus");
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void requestQuery(SkuYataQueryFrom r2) {
        Intrinsics.checkNotNullParameter(r2, "queryFrom");
        SkuYataQueryFetcher r0 = this.queryFetcher;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void setSkuParams(SkuParams r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.skuParams = r2;
    }

    public final void setSkuSchemaParams(SkuSchemaParams r1) {
        this.skuSchemaParams = r1;
    }

    public static final /* synthetic */ void access$setQueryFetcher$p(SkuYataViewModel r0, SkuYataQueryFetcher r1) {
        r0.queryFetcher = r1;
    }

    public static final /* synthetic */ void access$showPageState(SkuYataViewModel r0, com.bytedance.android.shopping.sku.inner.repo.b r1) {
        r0.showPageState(r1);
    }

    public final void init(SkuParams r2, SkuSchemaParams r3, PageFinder r4, String r5, Fragment r6) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        Intrinsics.checkNotNullParameter(r4, "pageFinder");
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "skuYataFragment");
        this.skuParams = r2;
        this.skuSchemaParams = r3;
        SkuYataQueryFetcher r0 = (SkuYataQueryFetcher) SkuYataQueryFetcherHolder.INSTANCE.get(r5);
        if (r0 != null) goto L5;
        r0 = new SkuYataQueryFetcher(r5, r2, r4, r3);
    L5:
        this.queryFetcher = r0;
        Intrinsics.checkNotNullParameter(r6, "btmNode");
        r0.g = new WeakReference(r6);
        SkuYataQueryFetcher r7 = this.queryFetcher;
        if (r7 == null) goto L10;
        com.bytedance.android.shopping.sku.inner.repo.b r8 = r7.h;
        if (r8 == null) goto L10;
        showPageState(r8);
    L10:
        SkuYataQueryFetcher r9 = this.queryFetcher;
        if (r9 == null) goto L14;
        r9.d = new AnonymousClass2(this);
        return;
    }
}
