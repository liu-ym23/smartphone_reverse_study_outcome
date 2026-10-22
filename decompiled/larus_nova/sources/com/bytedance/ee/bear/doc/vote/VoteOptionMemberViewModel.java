package com.bytedance.ee.bear.doc.vote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.empty.EmptyStateSource;
import com.larksuite.framework.utils.CollectionUtils;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f218391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f218392b;

        public @interface LoadMoreState {
        }

        public LoadingMoreState(int r100, Throwable r101) {
            this.f218391a = r100;
            this.f218392b = r101;
        }
    }

    public static /* synthetic */ void Mo(VoteOptionMemberViewModel r100, e r101, Throwable r102) {
        r100.lambda$pull$3(r101, r102);
    }

    public static /* synthetic */ void No(VoteOptionMemberViewModel r100, String r101) {
        r100.lambda$pull$0(r101);
    }

    public static /* synthetic */ void Oo(Throwable r100) {
        lambda$pull$1(r100);
    }

    public static /* synthetic */ void yo(VoteOptionMemberViewModel r100, e r101, VoteOptionMembersFetcher.VoteOptionMemberResult r102) {
        r100.lambda$pull$2(r101, r102);
    }

    public void pull() {
        Disposable r100 = this.mPullDisposable;
        if (r100 == null) goto L6;
        r100.dispose();
        this.mPullDisposable = null;
    L6:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L16;
        if (this.mOffset == "1") goto L10;
        LoadingMoreState r101 = new LoadingMoreState(2, new IOException("no network"));
        this.mLoadingMoreState.setValue(r101);
        return;
    L10:
        EmptyStateSource r102 = this.mEmptySource;
        if (r102 == null) goto L13;
        r102.fail(new IOException("no network"));
        return;
    L13:
        tt5.a.d(TAG, "mEmptySource is null");
        return;
    L16:
        if (this.mOffset == "1") goto L18;
        LoadingMoreState r103 = new LoadingMoreState(1, null);
        this.mLoadingMoreState.setValue(r103);
    L23:
        if (this.mVoteOptionMembers.getValue() != null) goto L25;
        final e r104 = new e();
    L26:
        final VoteOptionMembersFetcher r105 = this.mFetcher;
        String r106 = this.mOffset;
        boolean r107 = this.mIsVoteDesc;
        r105.getClass();
        NetService r108 = (NetService) org.koin.java.a.a(NetService.class);
        NetService.f r109 = new NetService.f("space/api/docx/poll/option/data");
        r109.f216906c = 2;
        r109.b(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r105.f218407a);
        r109.b(BitableResourceData.KEY_BLOCK_ID, r105.f218408b);
        r109.b("option_id", r105.f218409c);
        r109.b("offset", r106);
        if (r107 == false) goto L29;
        r109.b("sort", "vote_time_desc");
    L29:
        this.mPullDisposable = r108.Vc(new p(r105)).a(r109).subscribe(new h(this, r104), new i(this, r104));
        return;
    L25:
        r104 = this.mVoteOptionMembers.getValue();
        goto L26
    L18:
        EmptyStateSource r110 = this.mEmptySource;
        if (r110 == null) goto L21;
        r110.data(1);
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

    private /* synthetic */ void lambda$pull$0(String r100) throws Exception {
        if (this.mPullDisposable == null) goto L8;
        EmptyStateSource r101 = this.mEmptySource;
        if (r101 == null) goto L9;
        r101.loading();
        return;
    L9:
        return;
    }

    private static void lambda$pull$1(Throwable r100) throws Exception {
        tt5.a.e(TAG, "accept: delay failed", r100, false);
    }

    public void attach(c r100) {
        this.mEmptySource = r100.f218435a;
        this.mOffset = r100.f218439e;
        String r101 = r100.f218436b;
        this.mPageId = r101;
        String r102 = r100.f218437c;
        this.mBlockId = r102;
        String r103 = r100.f218438d;
        this.mOptionId = r103;
        this.mFetcher = new VoteOptionMembersFetcher(r101, r102, r103);
        this.mVoteOptionMembers.setValue(new e());
        LoadingMoreState r104 = new LoadingMoreState(0, null);
        this.mLoadingMoreState.setValue(r104);
        this.mIsVoteDesc = r100.f218440f;
        pull();
    }

    private void lambda$pull$2(e r100, VoteOptionMembersFetcher.VoteOptionMemberResult r101) throws Exception {
        this.mCount.setValue(Integer.valueOf(r101.totalCount));
        ((ArrayList) r100.f218443a).addAll(r101.members);
        if (r101.totalCount <= ((ArrayList) r100.f218443a).size()) goto L5;
        boolean r102 = true;
    L6:
        r100.f218444b = r102;
        this.mVoteOptionMembers.setValue(r100);
        if (this.mOffset == "1") goto L9;
        this.mLoadingMoreState.setValue(new LoadingMoreState(3, null));
    L9:
        this.mOffset = r101.nextOffset;
        EmptyStateSource r103 = this.mEmptySource;
        if (r103 == null) goto L12;
        r103.data(((ArrayList) r100.f218443a).size());
    L12:
        this.mPullDisposable = null;
        tt5.a.h(TAG, "pull finish count = " + ((ArrayList) r100.f218443a).size() + ", hasMore = " + r100.f218444b);
        return;
    L5:
        r102 = false;
        goto L6
    }

    private void lambda$pull$3(e r100, Throwable r101) throws Exception {
        this.mVoteOptionMembers.setValue(r100);
        if (CollectionUtils.isEmpty(r100.f218443a) == false) goto L7;
        EmptyStateSource r102 = this.mEmptySource;
        if (r102 == null) goto L7;
        r102.fail(r101);
    L8:
        this.mPullDisposable = null;
        tt5.a.e(TAG, "accept: pull more error", r101, false);
        return;
    L7:
        LoadingMoreState r103 = new LoadingMoreState(2, r101);
        this.mLoadingMoreState.setValue(r103);
        goto L8
    }
}
