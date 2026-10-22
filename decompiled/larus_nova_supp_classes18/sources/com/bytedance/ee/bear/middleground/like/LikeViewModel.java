package com.bytedance.ee.bear.middleground.like;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.empty.EmptyStateSource;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LikeViewModel extends ViewModel {
    private static final int COUNT_PER_PAGE = 20;
    private static final String TAG = "LikeViewModel";
    private AccountService.Account mAccount;
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
        public final int a;
        public final Throwable b;

        public @interface LoadMoreState {
        }

        public LoadingMoreState(int r1, Throwable r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static /* synthetic */ void Mo(LikeViewModel r0, String r1) {
        r0.lambda$pull$0(r1);
    }

    public static /* synthetic */ void No(LikeViewModel r0, b r1, Throwable r2) {
        r0.lambda$pull$3(r1, r2);
    }

    public static /* synthetic */ void Oo(LikeViewModel r0, LikeListPuller.LikeCountResult r1) {
        r0.lambda$pullCount$4(r1);
    }

    public static /* synthetic */ void Po(Throwable r0) {
        lambda$pull$1(r0);
    }

    public static /* synthetic */ void Qo(LikeViewModel r0, b r1, String r2, LikeListPuller.LikeResult r3) {
        r0.lambda$pull$2(r1, r2, r3);
    }

    public static /* synthetic */ void yo(Throwable r0) {
        lambda$pullCount$5(r0);
    }

    private void pullCount() {
        int r0 = p.a;
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L5;
        return;
    L5:
        Disposable r1 = this.mPullCountDisposable;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        tt5.a.h(TAG, "pullCount: begin pull count for like list");
        LikeListPuller r2 = this.mPuller;
        r2.getClass();
        NetService r3 = (NetService) org.koin.java.a.a(NetService.class);
        NetService.f r4 = new NetService.f("api/like/count/");
        ((NetService.e) r4).c = 2;
        r4.b(ResourceData.KEY_TOKEN, r2.a);
        r4.b("refer_type", String.valueOf(r2.b));
        this.mPullCountDisposable = r3.Vc(new l()).a(r4).subscribe(new v(this), new w());
    }

    private void syncEmptyState() {
        b r0 = (b) this.mLikeList.getValue();
        if (this.mPullDisposable == null) goto L8;
        if (r0 != null) goto L6;
    L7:
        this.mEmptySource.loading();
        return;
    L6:
        if (((ArrayList) r0.a).isEmpty() == true) goto L7;
    L8:
        if (r0 == null) goto L12;
        this.mEmptySource.data(((ArrayList) r0.a).size());
        return;
    }

    public void pull() {
        Disposable r0 = this.mPullDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
        this.mPullDisposable = null;
    L5:
        final b r1 = (b) this.mLikeList.getValue();
        if (r1 != null) goto L8;
    L10:
        final String r4 = "0";
    L11:
        int r5 = p.a;
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L19;
        if (TextUtils.equals(r4, "0") == true) goto L16;
        this.mLoadingMoreState.setValue(new LoadingMoreState(2, new IOException("no network")));
        return;
    L16:
        this.mEmptySource.fail(new IOException("no network"));
        return;
    L19:
        if (TextUtils.equals(r4, "0") == true) goto L21;
        this.mLoadingMoreState.setValue(new LoadingMoreState(1, null));
    L22:
        if (r1 != null) goto L24;
        r1 = new b();
    L24:
        tt5.a.h(TAG, "pull: begin pull like list start id = " + r4);
        LikeListPuller r2 = this.mPuller;
        r2.getClass();
        NetService r3 = (NetService) org.koin.java.a.a(NetService.class);
        NetService.f r6 = new NetService.f("/api/like/data/");
        ((NetService.e) r6).c = 2;
        r6.b(ResourceData.KEY_TOKEN, r2.a);
        r6.b("refer_type", String.valueOf(r2.b));
        r6.b("last_like_id", r4);
        r6.b("page_size", String.valueOf(20));
        this.mPullDisposable = r3.Vc(new m()).a(r6).subscribe(new t(this, r1, r4), new u(this, r1));
        return;
    L21:
        this.mEmptySource.data(1);
        Flowable.just("").delay(300, TimeUnit.MILLISECONDS).subscribe(new q(this), new s());
        goto L22
    L8:
        if (((ArrayList) r1.a).isEmpty() == true) goto L10;
        List<b.a> r7 = r1.a;
        r4 = ((b.a) ListProtector.get(r7, ((ArrayList) r7).size() - 1)).a;
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

    private int calculateCount(LikeListPuller.LikeCountResult r4) {
        if (this.mCount.getValue() != null) goto L5;
        int r0 = 0;
    L7:
        if (r4 == null) goto L9;
        r0 = r4.count;
        tt5.a.b(TAG, "calculateCount: result count = " + r0);
    L9:
        b r5 = (b) this.mLikeList.getValue();
        if (r5 != null) goto L12;
        return r0;
    L12:
        if (r5.b == true) goto L16;
        int r1 = ((ArrayList) r5.a).size();
        tt5.a.b(TAG, "calculateCount: list count = " + r1);
        return r1;
    L16:
        return r0;
    L5:
        r0 = ((Integer) this.mCount.getValue()).intValue();
        goto L7
    }

    private /* synthetic */ void lambda$pull$0(String r1) throws Exception {
        if (this.mPullDisposable == null) goto L6;
        this.mEmptySource.loading();
        return;
    }

    private static void lambda$pull$1(Throwable r3) throws Exception {
        tt5.a.e(TAG, "accept: delay failed", r3, false);
    }

    private /* synthetic */ void lambda$pullCount$4(LikeListPuller.LikeCountResult r3) throws Exception {
        StringBuilder r0 = new StringBuilder("pullCount: result = ");
        if (r3 == null) goto L5;
        Object r1 = Integer.valueOf(r3.count);
    L6:
        r0.append(r1);
        tt5.a.h(TAG, r0.toString());
        int r4 = calculateCount(r3);
        this.mCount.setValue(Integer.valueOf(r4));
        return;
    L5:
        r1 = "";
        goto L6
    }

    private static void lambda$pullCount$5(Throwable r3) throws Exception {
        tt5.a.e(TAG, "accept: pull count fail", r3, false);
    }

    private void lambda$pull$3(b r3, Throwable r4) throws Exception {
        this.mLikeList.setValue(r3);
        if (((ArrayList) r3.a).isEmpty() == false) goto L5;
        this.mEmptySource.fail(r4);
    L6:
        this.mPullDisposable = null;
        tt5.a.e(TAG, "accept: pull more error", r4, false);
        return;
    L5:
        LoadingMoreState r5 = new LoadingMoreState(2, r4);
        this.mLoadingMoreState.setValue(r5);
        this.mLoadingMoreState.setValue(r5);
        goto L6
    }

    public void fillLikeList(LikeListPuller.LikeResult r6, b r7) {
        List<LikeListPuller.a> r0 = r6.getLikeUsers();
        if (r0 == null) goto L13;
        Iterator<LikeListPuller.a> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        LikeListPuller.a r2 = r1.next();
        b.a r3 = new b.a();
        r3.a = r2.a;
        r3.e = r2.d;
        r3.g = r2.f;
        r3.h = r2.g;
        r3.f = r2.e;
        r3.c = r2.c;
        r3.d = r2.h;
        r3.i = r2.i;
        String r4 = r2.b;
        r3.b = r4;
        r3.j = r2.j;
        AccountService.Account r5 = this.mAccount;
        if (r5 == null) goto L12;
        if (r4.equals(r5.uid) == false) goto L12;
        ListProtector.add(r7.a, 0, r3);
    L12:
        ((ArrayList) r7.a).add(r3);
    L13:
        r7.b = r6.hasMore();
    }

    private /* synthetic */ void lambda$pull$2(b r2, String r3, LikeListPuller.LikeResult r4) throws Exception {
        fillLikeList(r4, r2);
        this.mLikeList.setValue(r2);
        this.mEmptySource.data(((ArrayList) r2.a).size());
        if (TextUtils.equals("0", r3) == true) goto L5;
        this.mLoadingMoreState.setValue(new LoadingMoreState(3, null));
    L5:
        this.mCount.setValue(Integer.valueOf(calculateCount(null)));
        this.mPullDisposable = null;
        tt5.a.h(TAG, "pull: end pull like list count = " + ((ArrayList) r2.a).size() + ", hasMore = " + r2.b);
    }

    public void attach(EmptyStateSource r3, String r4, int r5) {
        this.mAccount = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (TextUtils.equals(this.mDocToken, r4) == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.mEmptySource = r3;
        if (r0 == false) goto L12;
        this.mDocToken = r4;
        this.mRefType = r5;
        this.mPuller = new LikeListPuller(r4, r5);
        this.mLikeList.setValue(new b());
        LoadingMoreState r6 = new LoadingMoreState(0, null);
        this.mLoadingMoreState.setValue(r6);
        pull();
        pullCount();
        return;
    L12:
        syncEmptyState();
        return;
    L5:
        if (this.mRefType != r5) goto L8;
        r0 = false;
        goto L9
    }
}
