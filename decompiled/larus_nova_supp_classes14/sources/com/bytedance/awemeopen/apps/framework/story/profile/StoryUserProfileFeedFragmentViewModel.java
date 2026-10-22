package com.bytedance.awemeopen.apps.framework.story.profile;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import h04.d;
import h04.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b)\u0010*J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J:\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u001e\u0010\u001b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0016\u0010\u001c\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u0016\u0010\u001e\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0016R\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/story/profile/StoryUserProfileFeedFragmentViewModel;", "Lcom/bytedance/awemeopen/apps/framework/feed/profile/AosUserProfileFeedFragmentViewModel;", "Lh04/e;", "Ljz3/a;", "callback", "", "doRefresh", "Lh04/d;", "doLoadMore", "Landroid/content/Context;", "context", "", "userOpenId", "", UploadTypeInf.COUNT, "cursor", "Lm24/a;", "", "canRetry", "doLoadData", "", "Lr14/c;", "awemeList", "filterAweme", "copyFromTransientDataCache", "sceneId", "isFirst", "refreshData", "loadMoreData", "Lh04/c;", "loadForwardData", "pageCount", "J", "maxCursor", "hasMore", "Z", "", "cachedData", "Ljava/util/List;", "fromAweme", "Lr14/c;", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class StoryUserProfileFeedFragmentViewModel extends AosUserProfileFeedFragmentViewModel {
    public static final a Companion = null;
    private static final String TAG = "StoryUserProfileFeedFragmentViewModel";
    private List<r14.c> cachedData;
    private r14.c fromAweme;
    private boolean hasMore;
    private long maxCursor;
    private long pageCount;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements m24.a {
        public final /* synthetic */ StoryUserProfileFeedFragmentViewModel a;
        public final /* synthetic */ d<jz3.a> b;

        public final void onFail(Exception r1) {
            this.b.onFail();
        }

        public b(StoryUserProfileFeedFragmentViewModel r1, d<jz3.a> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(List<r14.c> r6, long r7, boolean r9) {
            Intrinsics.checkNotNullParameter(r6, "data");
            List<r14.c> r8 = r6;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r10 = r8.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r0.add(new jz3.a((r14.c) r10.next(), null, 14));
            goto L4
        L6:
            StoryUserProfileFeedFragmentViewModel.access$setMaxCursor$p(this.a, r7);
            StoryUserProfileFeedFragmentViewModel.access$setHasMore$p(this.a, r9);
            this.b.onSuccess(r0, r9);
        }
    }

    public static final class c implements m24.a {
        public final /* synthetic */ StoryUserProfileFeedFragmentViewModel a;
        public final /* synthetic */ e<jz3.a> b;

        public final void onFail(Exception r3) {
            this.b.a(r3, -1);
        }

        public c(StoryUserProfileFeedFragmentViewModel r1, e<jz3.a> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(List<r14.c> r6, long r7, boolean r9) {
            Intrinsics.checkNotNullParameter(r6, "data");
            List<r14.c> r8 = r6;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r10 = r8.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r0.add(new jz3.a((r14.c) r10.next(), null, 14));
            goto L4
        L6:
            StoryUserProfileFeedFragmentViewModel.access$setMaxCursor$p(this.a, r7);
            StoryUserProfileFeedFragmentViewModel.access$setHasMore$p(this.a, r9);
            this.b.b(r0, false, r9);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadForwardData(h04.c<jz3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String sceneId() {
        return "others_homepage";
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel
    public void copyFromTransientDataCache() {
        if (this.cachedData.size() != 0) goto L13;
        this.pageCount = com.bytedance.awemeopen.apps.framework.story.profile.a.a;
        this.maxCursor = 0;
        this.hasMore = false;
        setUserOpenId("");
        this.cachedData.clear();
        List<r14.c> r1 = this.cachedData;
        List<r14.c> r2 = com.bytedance.awemeopen.apps.framework.story.profile.a.b;
        r1.addAll(r2);
        setInitIndex(0);
        if (this.cachedData.size() > 0) goto L7;
    L11:
        com.bytedance.awemeopen.apps.framework.story.profile.a.a = 20;
        ((ArrayList) r2).clear();
        return;
    L7:
        if (getInitIndex() < 0) goto L11;
        if (getInitIndex() >= this.cachedData.size()) goto L11;
        this.fromAweme = (r14.c) ListProtector.get(this.cachedData, getInitIndex());
        goto L11
    }

    public StoryUserProfileFeedFragmentViewModel() {
        this.cachedData = new ArrayList();
    }

    public static final /* synthetic */ Application access$getApplication(StoryUserProfileFeedFragmentViewModel r0) {
        return r0.getApplication();
    }

    private final void doLoadMore(d<jz3.a> r12) {
        doLoadData$default(this, getApplication(), getUserOpenId(), this.pageCount, this.maxCursor, new b(this, r12), false, 32, null);
    }

    private final void doRefresh(e<jz3.a> r15) {
        if (this.cachedData.size() <= 0) goto L9;
        List<r14.c> r0 = this.cachedData;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.add(new jz3.a((r14.c) r2.next(), null, 14));
        goto L6
    L8:
        r15.b(r1, false, this.hasMore);
        return;
    L9:
        doLoadData$default(this, getApplication(), getUserOpenId(), this.pageCount, this.maxCursor, new c(this, r15), false, 32, null);
    }

    private final List<r14.c> filterAweme(List<r14.c> r9) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L16;
        Object r1 = r10.next();
        r14.c r2 = (r14.c) r1;
        d14.a r3 = b14.a.a;
        x24.a r4 = b14.a.a(x24.a.class);
        if (r4.W(r2) == false) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L14;
        AoLogger.g(TAG, new Object[]{"filtered by video type", r2.c(), r2.O(), r2.r().a, r2.r().c, r2.p()});
    L14:
        if (r5 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if (r4.v3(r2) == true) goto L11;
        r5 = false;
        goto L12
    L16:
        return r0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadMoreData(d<jz3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        doLoadMore(r2);
    }

    public static final /* synthetic */ List access$filterAweme(StoryUserProfileFeedFragmentViewModel r0, List r1) {
        return r0.filterAweme(r1);
    }

    public static final /* synthetic */ void access$setHasMore$p(StoryUserProfileFeedFragmentViewModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setMaxCursor$p(StoryUserProfileFeedFragmentViewModel r0, long r1) {
        r0.maxCursor = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void refreshData(e<jz3.a> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super.refreshData(r2, r3);
    }

    private final void doLoadData(final Context r13, final String r14, final long r15, final long r17, final m24.a r19, final boolean r20) {
        if (this.hasMore == true) goto L5;
        return;
    L5:
        AoPool.a(new AnonymousClass1(r14, r15, r17, this, r19, r20, r13));
    }

    public static final /* synthetic */ void access$doLoadData(StoryUserProfileFeedFragmentViewModel r0, Context r1, String r2, long r3, long r5, m24.a r7, boolean r8) {
        r0.doLoadData(r1, r2, r3, r5, r7, r8);
    }

    public static /* synthetic */ void doLoadData$default(StoryUserProfileFeedFragmentViewModel r10, Context r11, String r12, long r13, long r15, m24.a r17, boolean r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        boolean r9 = true;
    L6:
        r10.doLoadData(r11, r12, r13, r15, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }
}
