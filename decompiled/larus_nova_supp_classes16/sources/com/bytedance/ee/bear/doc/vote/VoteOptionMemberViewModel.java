package com.bytedance.ee.bear.doc.vote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.empty.EmptyStateSource;
import com.larksuite.framework.utils.CollectionUtils;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VoteOptionMemberViewModel extends ViewModel {
    private static final String FIRST_PAGE_OFFSET = "1";
    private static final String TAG = "VoteOptionMemberViewModel";
    private String mBlockId;
    private MutableLiveData<Integer> mCount;
    private EmptyStateSource mEmptySource;
    private VoteOptionMembersFetcher mFetcher;
    private boolean mIsVoteDesc;
    private MutableLiveData<LoadingMoreState> mLoadingMoreState;
    private String mOffset;
    private String mOptionId;
    private String mPageId;
    private Disposable mPullDisposable;
    private MutableLiveData<e> mVoteOptionMembers;

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

    public static /* synthetic */ void Mo(VoteOptionMemberViewModel r0, e r1, Throwable r2) {
        r0.lambda$pull$3(r1, r2);
    }

    public static /* synthetic */ void No(VoteOptionMemberViewModel r0, String r1) {
        r0.lambda$pull$0(r1);
    }

    public static /* synthetic */ void Oo(Throwable r0) {
        lambda$pull$1(r0);
    }

    public static /* synthetic */ void yo(VoteOptionMemberViewModel r0, e r1, VoteOptionMembersFetcher.VoteOptionMemberResult r2) {
        r0.lambda$pull$2(r1, r2);
    }

    public void pull() {
        Disposable r0 = this.mPullDisposable;
        if (r0 == null) goto L6;
        r0.dispose();
        this.mPullDisposable = null;
    L6:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L16;
        if (this.mOffset == "1") goto L10;
        LoadingMoreState r1 = new LoadingMoreState(2, new IOException("no network"));
        this.mLoadingMoreState.setValue(r1);
        return;
    L10:
        EmptyStateSource r2 = this.mEmptySource;
        if (r2 == null) goto L13;
        r2.fail(new IOException("no network"));
        return;
    L13:
        tt5.a.d(TAG, "mEmptySource is null");
        return;
    L16:
        if (this.mOffset == "1") goto L18;
        LoadingMoreState r3 = new LoadingMoreState(1, null);
        this.mLoadingMoreState.setValue(r3);
    L23:
        if (this.mVoteOptionMembers.getValue() != null) goto L25;
        final e r4 = new e();
    L26:
        final VoteOptionMembersFetcher r5 = this.mFetcher;
        String r6 = this.mOffset;
        boolean r7 = this.mIsVoteDesc;
        r5.getClass();
        NetService r8 = (NetService) org.koin.java.a.a(NetService.class);
        NetService.f r9 = new NetService.f("space/api/docx/poll/option/data");
        r9.c = 2;
        r9.b("page_id", r5.a);
        r9.b("block_id", r5.b);
        r9.b("option_id", r5.c);
        r9.b("offset", r6);
        if (r7 == false) goto L29;
        r9.b(PanelData.TAB_SORT, "vote_time_desc");
    L29:
        this.mPullDisposable = r8.Vc(new p(r5)).a(r9).subscribe(new h(this, r4), new i(this, r4));
        return;
    L25:
        r4 = (e) this.mVoteOptionMembers.getValue();
        goto L26
    L18:
        EmptyStateSource r10 = this.mEmptySource;
        if (r10 == null) goto L21;
        r10.data(1);
    L21:
        Flowable.just("").delay(300, TimeUnit.MILLISECONDS).subscribe(new f(this), new g());
        goto L23
    }

    public VoteOptionMemberViewModel() {
        this.mVoteOptionMembers = new MutableLiveData();
        this.mLoadingMoreState = new MutableLiveData();
        this.mCount = new MutableLiveData();
        this.mOffset = "1";
        this.mIsVoteDesc = false;
    }

    public LiveData<Integer> count() {
        return this.mCount;
    }

    public LiveData<e> items() {
        return this.mVoteOptionMembers;
    }

    public LiveData<LoadingMoreState> loadMoreState() {
        return this.mLoadingMoreState;
    }

    private /* synthetic */ void lambda$pull$0(String r1) throws Exception {
        if (this.mPullDisposable == null) goto L8;
        EmptyStateSource r2 = this.mEmptySource;
        if (r2 == null) goto L9;
        r2.loading();
        return;
    L9:
        return;
    }

    private static void lambda$pull$1(Throwable r3) throws Exception {
        tt5.a.e(TAG, "accept: delay failed", r3, false);
    }

    public void attach(c r5) {
        this.mEmptySource = r5.a;
        this.mOffset = r5.e;
        String r0 = r5.b;
        this.mPageId = r0;
        String r1 = r5.c;
        this.mBlockId = r1;
        String r2 = r5.d;
        this.mOptionId = r2;
        this.mFetcher = new VoteOptionMembersFetcher(r0, r1, r2);
        this.mVoteOptionMembers.setValue(new e());
        LoadingMoreState r3 = new LoadingMoreState(0, null);
        this.mLoadingMoreState.setValue(r3);
        this.mIsVoteDesc = r5.f;
        pull();
    }

    private void lambda$pull$2(e r4, VoteOptionMembersFetcher.VoteOptionMemberResult r5) throws Exception {
        this.mCount.setValue(Integer.valueOf(r5.totalCount));
        ((ArrayList) r4.a).addAll(r5.members);
        if (r5.totalCount <= ((ArrayList) r4.a).size()) goto L5;
        boolean r0 = true;
    L6:
        r4.b = r0;
        this.mVoteOptionMembers.setValue(r4);
        if (this.mOffset == "1") goto L9;
        this.mLoadingMoreState.setValue(new LoadingMoreState(3, null));
    L9:
        this.mOffset = r5.nextOffset;
        EmptyStateSource r6 = this.mEmptySource;
        if (r6 == null) goto L12;
        r6.data(((ArrayList) r4.a).size());
    L12:
        this.mPullDisposable = null;
        tt5.a.h(TAG, "pull finish count = " + ((ArrayList) r4.a).size() + ", hasMore = " + r4.b);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void lambda$pull$3(e r3, Throwable r4) throws Exception {
        this.mVoteOptionMembers.setValue(r3);
        if (CollectionUtils.isEmpty(r3.a) == false) goto L7;
        EmptyStateSource r5 = this.mEmptySource;
        if (r5 == null) goto L7;
        r5.fail(r4);
    L8:
        this.mPullDisposable = null;
        tt5.a.e(TAG, "accept: pull more error", r4, false);
        return;
    L7:
        LoadingMoreState r6 = new LoadingMoreState(2, r4);
        this.mLoadingMoreState.setValue(r6);
        goto L8
    }
}
