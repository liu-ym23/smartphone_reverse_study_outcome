package com.bytedance.android.shopping.searchsimilar.viewmodel;

import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.async.b;
import com.bytedance.android.shopping.feed.utils.m;
import com.bytedance.android.shopping.searchsimilar.model.DislikeType;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fh3.a;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0006\u0010\u0007\u001a\u00020\u0005J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001bJ\u0012\u0010 \u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u0011\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0096\u0001J\t\u0010&\u001a\u00020\u0005H\u0096\u0001J\t\u0010(\u001a\u00020'H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0096\u0001R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00103R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u00103R\u0016\u00104\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00100R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00103R\u0016\u0010;\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00100R\u0016\u0010<\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00100R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010=R\u0016\u0010>\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00103R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/viewmodel/SimilarProductVM;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/searchsimilar/viewmodel/SimilarProductState;", "Lcom/bytedance/android/ec/core/async/b;", "defaultState", "", "onCleared", "loadSimilarProduct", "", "Lcom/bytedance/android/shopping/searchsimilar/model/DislikeType;", "getFeedbackList", "Lcom/bytedance/android/shopping/searchsimilar/model/SimilarProductParam;", "similarProductParam", "setSimilarProductParam", "getSimilarProductParam", "", "productFrameId", "setProductFrameId", "getProductFrameId", "", "position", "setFrameRank", "getFrameRank", "getRequestId", "insertPosition", "setProductCardInsertPosition", "getProductCardInsertPosition", "", "getIsFirstBind", "isFirstBind", "setIsFirstBind", "sortRule", "resetRequestParams", "clearSimilarProduct", "deleteDislikeProduct", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "remove", "", "Lrd3/a;", "similarProductList", "Ljava/util/List;", "feedbackList", "cursor", "I", "Lcom/bytedance/android/shopping/searchsimilar/model/SimilarProductParam;", "penetrateData", "Ljava/lang/String;", "count", "Lfh3/a;", "similarProductFetcher", "Lfh3/a;", "similarProductDisposable", "Lio/reactivex/disposables/Disposable;", "requestId", "productCardInsertPosition", "frameRank", "Z", "mCurMonitorName", "Lcom/bytedance/android/shopping/feed/utils/m;", "similarProductFiltersHelper", "Lcom/bytedance/android/shopping/feed/utils/m;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductVM extends JediViewModel<SimilarProductState> implements b {
    private final /* synthetic */ DisposableScope $$delegate_0;
    private int count;
    private int cursor;
    private List<DislikeType> feedbackList;
    private int frameRank;
    private boolean isFirstBind;
    private String mCurMonitorName;
    private String penetrateData;
    private int productCardInsertPosition;
    private String productFrameId;
    private String requestId;
    private Disposable similarProductDisposable;
    private final a similarProductFetcher;
    private final m similarProductFiltersHelper;
    private List<rd3.a> similarProductList;
    private SimilarProductParam similarProductParam;
    private String sortRule;

    public Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.$$delegate_0.add(r2);
        return r2;
    }

    public void clearDisposable() {
        this.$$delegate_0.clearDisposable();
    }

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.$$delegate_0.remove(r2);
    }

    public final void clearSimilarProduct() {
        this.similarProductList.clear();
        this.productCardInsertPosition = 0;
        setState(AnonymousClass1.INSTANCE);
    }

    public CompositeDisposable compositeDisposable() {
        return this.$$delegate_0.a();
    }

    public SimilarProductState defaultState() {
        return new SimilarProductState(0);
    }

    public final void loadSimilarProduct() {
        withState(new C03271(this));
    }

    public SimilarProductVM() {
        this.$$delegate_0 = new DisposableScope();
        this.similarProductList = new ArrayList();
        this.feedbackList = new ArrayList();
        this.count = 10;
        this.similarProductFetcher = new a();
        this.frameRank = 1;
        this.isFirstBind = true;
        this.mCurMonitorName = "";
        this.similarProductFiltersHelper = new m();
    }

    public void onCleared() {
        super.onCleared();
        clearDisposable();
    }

    public final List<DislikeType> getFeedbackList() {
        return this.feedbackList;
    }

    public final int getFrameRank() {
        return this.frameRank;
    }

    public final boolean getIsFirstBind() {
        return this.isFirstBind;
    }

    public final int getProductCardInsertPosition() {
        return this.productCardInsertPosition;
    }

    public final String getProductFrameId() {
        return this.productFrameId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final SimilarProductParam getSimilarProductParam() {
        return this.similarProductParam;
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ State m2719defaultState() {
        return defaultState();
    }

    public static final /* synthetic */ int access$getCount$p(SimilarProductVM r0) {
        return r0.count;
    }

    public static final /* synthetic */ int access$getCursor$p(SimilarProductVM r0) {
        return r0.cursor;
    }

    public static final /* synthetic */ List access$getFeedbackList$p(SimilarProductVM r0) {
        return r0.feedbackList;
    }

    public static final /* synthetic */ String access$getMCurMonitorName$p(SimilarProductVM r0) {
        return r0.mCurMonitorName;
    }

    public static final /* synthetic */ String access$getPenetrateData$p(SimilarProductVM r0) {
        return r0.penetrateData;
    }

    public static final /* synthetic */ String access$getProductFrameId$p(SimilarProductVM r0) {
        return r0.productFrameId;
    }

    public static final /* synthetic */ String access$getRequestId$p(SimilarProductVM r0) {
        return r0.requestId;
    }

    public static final /* synthetic */ Disposable access$getSimilarProductDisposable$p(SimilarProductVM r0) {
        return r0.similarProductDisposable;
    }

    public static final /* synthetic */ a access$getSimilarProductFetcher$p(SimilarProductVM r0) {
        return r0.similarProductFetcher;
    }

    public static final /* synthetic */ m access$getSimilarProductFiltersHelper$p(SimilarProductVM r0) {
        return r0.similarProductFiltersHelper;
    }

    public static final /* synthetic */ List access$getSimilarProductList$p(SimilarProductVM r0) {
        return r0.similarProductList;
    }

    public static final /* synthetic */ SimilarProductParam access$getSimilarProductParam$p(SimilarProductVM r0) {
        return r0.similarProductParam;
    }

    public static final /* synthetic */ String access$getSortRule$p(SimilarProductVM r0) {
        return r0.sortRule;
    }

    public final void deleteDislikeProduct(int r2) {
        ListProtector.remove(this.similarProductList, r2);
    }

    public final void resetRequestParams(String r1) {
        if (r1 == null) goto L4;
        this.sortRule = r1;
    L4:
        this.cursor = 0;
        this.penetrateData = null;
        this.similarProductFiltersHelper.b.clear();
        setState(AnonymousClass2.INSTANCE);
    }

    public final void setFrameRank(int r1) {
        this.frameRank = r1 + 1;
    }

    public final void setIsFirstBind(boolean r1) {
        this.isFirstBind = r1;
    }

    public final void setProductCardInsertPosition(int r1) {
        this.productCardInsertPosition = r1;
    }

    public final void setProductFrameId(String r1) {
        this.productFrameId = r1;
    }

    public final void setSimilarProductParam(SimilarProductParam r2) {
        Intrinsics.checkNotNullParameter(r2, "similarProductParam");
        this.similarProductParam = r2;
        this.mCurMonitorName = r2.getMonitorName();
    }

    public static final /* synthetic */ void access$setCount$p(SimilarProductVM r0, int r1) {
        r0.count = r1;
    }

    public static final /* synthetic */ void access$setCursor$p(SimilarProductVM r0, int r1) {
        r0.cursor = r1;
    }

    public static final /* synthetic */ void access$setFeedbackList$p(SimilarProductVM r0, List r1) {
        r0.feedbackList = r1;
    }

    public static final /* synthetic */ void access$setMCurMonitorName$p(SimilarProductVM r0, String r1) {
        r0.mCurMonitorName = r1;
    }

    public static final /* synthetic */ void access$setPenetrateData$p(SimilarProductVM r0, String r1) {
        r0.penetrateData = r1;
    }

    public static final /* synthetic */ void access$setProductFrameId$p(SimilarProductVM r0, String r1) {
        r0.productFrameId = r1;
    }

    public static final /* synthetic */ void access$setRequestId$p(SimilarProductVM r0, String r1) {
        r0.requestId = r1;
    }

    public static final /* synthetic */ void access$setSimilarProductDisposable$p(SimilarProductVM r0, Disposable r1) {
        r0.similarProductDisposable = r1;
    }

    public static final /* synthetic */ void access$setSimilarProductList$p(SimilarProductVM r0, List r1) {
        r0.similarProductList = r1;
    }

    public static final /* synthetic */ void access$setSimilarProductParam$p(SimilarProductVM r0, SimilarProductParam r1) {
        r0.similarProductParam = r1;
    }

    public static final /* synthetic */ void access$setSortRule$p(SimilarProductVM r0, String r1) {
        r0.sortRule = r1;
    }

    public static final /* synthetic */ void access$setState(SimilarProductVM r0, Function1 r1) {
        r0.setState(r1);
    }

    public static /* synthetic */ void resetRequestParams$default(SimilarProductVM r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.resetRequestParams(r1);
    }
}
