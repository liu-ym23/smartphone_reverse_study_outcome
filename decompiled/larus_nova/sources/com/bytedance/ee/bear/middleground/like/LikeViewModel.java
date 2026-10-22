package com.bytedance.ee.bear.middleground.like;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.empty.EmptyStateSource;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes18.dex */
public class LikeViewModel extends ViewModel {
    private static final int COUNT_PER_PAGE = 20;
    private static final String TAG = "LikeViewModel";
    private AccountService$Account mAccount;
    private MutableLiveData<Integer> mCount;
    private String mDocToken;
    private EmptyStateSource mEmptySource;
    private MutableLiveData<b> mLikeList;
    private MutableLiveData<LoadingMoreState> mLoadingMoreState;
    private Disposable mPullCountDisposable;
    private Disposable mPullDisposable;
    private LikeListPuller mPuller;
    private int mRefType;

    public static class LoadingMoreState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f232747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f232748b;

        public @interface LoadMoreState {
        }

        public LoadingMoreState(int r100, Throwable r101) {
            this.f232747a = r100;
            this.f232748b = r101;
        }
    }

    public static /* synthetic */ void Mo(LikeViewModel r100, String r101) {
        r100.lambda$pull$0(r101);
    }

    public static /* synthetic */ void No(LikeViewModel r100, b r101, Throwable r102) {
        r100.lambda$pull$3(r101, r102);
    }

    public static /* synthetic */ void Oo(LikeViewModel r100, LikeListPuller.LikeCountResult r101) {
        r100.lambda$pullCount$4(r101);
    }

    public static /* synthetic */ void Po(Throwable r100) {
        lambda$pull$1(r100);
    }

    public static /* synthetic */ void Qo(LikeViewModel r100, b r101, String r102, LikeListPuller.LikeResult r103) {
        r100.lambda$pull$2(r101, r102, r103);
    }

    public static /* synthetic */ void yo(Throwable r100) {
        lambda$pullCount$5(r100);
    }

    private void pullCount() {
        int r100 = p.f232814a;
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L5;
        return;
    L5:
        Disposable r101 = this.mPullCountDisposable;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        tt5.a.h(TAG, "pullCount: begin pull count for like list");
        LikeListPuller r102 = this.mPuller;
        r102.getClass();
        NetService r103 = (NetService) org.koin.java.a.a(NetService.class);
        NetService.f r104 = new NetService.f("api/like/count/");
        r104.f216906c = 2;
        r104.b("token", r102.f232733a);
        r104.b("refer_type", String.valueOf(r102.f232734b));
        this.mPullCountDisposable = r103.Vc(new l()).a(r104).subscribe(new v(this), new w());
    }

    private void syncEmptyState() {
        b r100 = this.mLikeList.getValue();
        if (this.mPullDisposable == null) goto L8;
        if (r100 != null) goto L6;
    L7:
        this.mEmptySource.loading();
        return;
    L6:
        if (((ArrayList) r100.f232758a).isEmpty() == true) goto L7;
    L8:
        if (r100 == null) goto L12;
        this.mEmptySource.data(((ArrayList) r100.f232758a).size());
        return;
    }

    public void pull() {
        Disposable r100 = this.mPullDisposable;
        if (r100 == null) goto L5;
        r100.dispose();
        this.mPullDisposable = null;
    L5:
        final b r101 = this.mLikeList.getValue();
        if (r101 != null) goto L8;
    L10:
        final String r102 = "0";
    L11:
        int r103 = p.f232814a;
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L19;
        if (TextUtils.equals(r102, "0") == true) goto L16;
        this.mLoadingMoreState.setValue(new LoadingMoreState(2, new IOException("no network")));
        return;
    L16:
        this.mEmptySource.fail(new IOException("no network"));
        return;
    L19:
        if (TextUtils.equals(r102, "0") == true) goto L21;
        this.mLoadingMoreState.setValue(new LoadingMoreState(1, null));
    L22:
        if (r101 != null) goto L24;
        r101 = new b();
    L24:
        tt5.a.h(TAG, "pull: begin pull like list start id = " + r102);
        LikeListPuller r104 = this.mPuller;
        r104.getClass();
        NetService r105 = (NetService) org.koin.java.a.a(NetService.class);
        NetService.f r106 = new NetService.f("/api/like/data/");
        r106.f216906c = 2;
        r106.b("token", r104.f232733a);
        r106.b("refer_type", String.valueOf(r104.f232734b));
        r106.b("last_like_id", r102);
        r106.b("page_size", String.valueOf(20));
        this.mPullDisposable = r105.Vc(new m()).a(r106).subscribe(new t(this, r101, r102), new u(this, r101));
        return;
    L21:
        this.mEmptySource.data(1);
        Flowable.just("").delay(300, TimeUnit.MILLISECONDS).subscribe(new q(this), new s());
        goto L22
    L8:
        if (((ArrayList) r101.f232758a).isEmpty() == true) goto L10;
        List<b.a> r107 = r101.f232758a;
        r102 = ((b.a) ListProtector.get(r107, ((ArrayList) r107).size() - 1)).f232760a;
        goto L11
    }

    public LikeViewModel() {
        this.mLikeList = new MutableLiveData();
        this.mLoadingMoreState = new MutableLiveData();
        this.mCount = new MutableLiveData();
        this.mRefType = -1;
    }

    public LiveData<Integer> count() {
        return this.mCount;
    }

    public LiveData<b> items() {
        return this.mLikeList;
    }

    public LiveData<LoadingMoreState> loadMoreState() {
        return this.mLoadingMoreState;
    }

    private int calculateCount(LikeListPuller.LikeCountResult r100) {
        if (this.mCount.getValue() != null) goto L5;
        int r101 = 0;
    L7:
        if (r100 == null) goto L9;
        r101 = r100.count;
        tt5.a.b(TAG, "calculateCount: result count = " + r101);
    L9:
        b r102 = this.mLikeList.getValue();
        if (r102 != null) goto L12;
        return r101;
    L12:
        if (r102.f232759b == true) goto L16;
        int r103 = ((ArrayList) r102.f232758a).size();
        tt5.a.b(TAG, "calculateCount: list count = " + r103);
        return r103;
    L16:
        return r101;
    L5:
        r101 = this.mCount.getValue().intValue();
        goto L7
    }

    private /* synthetic */ void lambda$pull$0(String r100) throws Exception {
        if (this.mPullDisposable == null) goto L6;
        this.mEmptySource.loading();
        return;
    }

    private static void lambda$pull$1(Throwable r100) throws Exception {
        tt5.a.e(TAG, "accept: delay failed", r100, false);
    }

    private /* synthetic */ void lambda$pullCount$4(LikeListPuller.LikeCountResult r100) throws Exception {
        StringBuilder r101 = new StringBuilder("pullCount: result = ");
        if (r100 == null) goto L5;
        Object r102 = Integer.valueOf(r100.count);
    L6:
        r101.append(r102);
        tt5.a.h(TAG, r101.toString());
        int r103 = calculateCount(r100);
        this.mCount.setValue(Integer.valueOf(r103));
        return;
    L5:
        r102 = "";
        goto L6
    }

    private static void lambda$pullCount$5(Throwable r100) throws Exception {
        tt5.a.e(TAG, "accept: pull count fail", r100, false);
    }

    private void lambda$pull$3(b r100, Throwable r101) throws Exception {
        this.mLikeList.setValue(r100);
        if (((ArrayList) r100.f232758a).isEmpty() == false) goto L5;
        this.mEmptySource.fail(r101);
    L6:
        this.mPullDisposable = null;
        tt5.a.e(TAG, "accept: pull more error", r101, false);
        return;
    L5:
        LoadingMoreState r102 = new LoadingMoreState(2, r101);
        this.mLoadingMoreState.setValue(r102);
        this.mLoadingMoreState.setValue(r102);
        goto L6
    }

    public void fillLikeList(LikeListPuller.LikeResult r100, b r101) {
        List<LikeListPuller.a> r102 = r100.getLikeUsers();
        if (r102 == null) goto L13;
        Iterator<LikeListPuller.a> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        LikeListPuller.a r104 = r103.next();
        b.a r105 = new b.a();
        r105.f232760a = r104.f232735a;
        r105.f232764e = r104.f232738d;
        r105.f232766g = r104.f232740f;
        r105.f232767h = r104.f232741g;
        r105.f232765f = r104.f232739e;
        r105.f232762c = r104.f232737c;
        r105.f232763d = r104.f232742h;
        r105.f232768i = r104.f232743i;
        String r106 = r104.f232736b;
        r105.f232761b = r106;
        r105.f232769j = r104.f232744j;
        AccountService$Account r107 = this.mAccount;
        if (r107 == null) goto L12;
        if (r106.equals(r107.uid) == false) goto L12;
        ListProtector.add(r101.f232758a, 0, r105);
    L12:
        ((ArrayList) r101.f232758a).add(r105);
    L13:
        r101.f232759b = r100.hasMore();
    }

    private /* synthetic */ void lambda$pull$2(b r100, String r101, LikeListPuller.LikeResult r102) throws Exception {
        fillLikeList(r102, r100);
        this.mLikeList.setValue(r100);
        this.mEmptySource.data(((ArrayList) r100.f232758a).size());
        if (TextUtils.equals("0", r101) == true) goto L5;
        this.mLoadingMoreState.setValue(new LoadingMoreState(3, null));
    L5:
        this.mCount.setValue(Integer.valueOf(calculateCount(null)));
        this.mPullDisposable = null;
        tt5.a.h(TAG, "pull: end pull like list count = " + ((ArrayList) r100.f232758a).size() + ", hasMore = " + r100.f232759b);
    }

    public void attach(EmptyStateSource r100, String r101, int r102) {
        this.mAccount = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (TextUtils.equals(this.mDocToken, r101) == true) goto L5;
    L8:
        boolean r103 = true;
    L9:
        this.mEmptySource = r100;
        if (r103 == false) goto L12;
        this.mDocToken = r101;
        this.mRefType = r102;
        this.mPuller = new LikeListPuller(r101, r102);
        this.mLikeList.setValue(new b());
        LoadingMoreState r104 = new LoadingMoreState(0, null);
        this.mLoadingMoreState.setValue(r104);
        pull();
        pullCount();
        return;
    L12:
        syncEmptyState();
        return;
    L5:
        if (this.mRefType != r102) goto L8;
        r103 = false;
        goto L9
    }
}
