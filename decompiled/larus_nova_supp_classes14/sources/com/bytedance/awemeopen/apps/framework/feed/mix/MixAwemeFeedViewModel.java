package com.bytedance.awemeopen.apps.framework.feed.mix;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.bizmodels.feed.mix.MixStruct;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\bC\u0010DJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0016\u0010\u000e\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016J\u0016\u0010\u0010\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0016J2\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00188\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\"\u0010/\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010'\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\"\u00102\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010'\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010!\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006G"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeFeedViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/FeedPagerListViewModel;", "", "copyFromTemp", "", "sceneId", "", "shouldPreLoad", "Lh04/e;", "Ljz3/a;", "callback", "isFirst", "refreshData", "Lh04/d;", "loadMoreData", "Lh04/c;", "loadForwardData", "", "data", "oldData", "", "startIndex", "", "filterRefreshData", "Landroidx/lifecycle/MutableLiveData;", "loading", "Landroidx/lifecycle/MutableLiveData;", "getLoading", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStruct;", "mixInfoLiveData", "getMixInfoLiveData", "mixId", "Ljava/lang/String;", "getMixId", "()Ljava/lang/String;", "setMixId", "(Ljava/lang/String;)V", "currentEpisode", "I", "getCurrentEpisode", "()I", "setCurrentEpisode", "(I)V", "startCursor", "getStartCursor", "setStartCursor", "endCursor", "getEndCursor", "setEndCursor", "updatedEpisode", "getUpdatedEpisode", "setUpdatedEpisode", "Lr14/c;", "fromAweme", "Lr14/c;", "getFromAweme", "()Lr14/c;", "setFromAweme", "(Lr14/c;)V", "fromAwemeAid", "getFromAwemeAid", "setFromAwemeAid", "Z", "Lb34/a;", "mixService", "Lb34/a;", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MixAwemeFeedViewModel extends FeedPagerListViewModel {
    public static final a Companion = null;
    private static r14.c tempMixAweme;
    private int currentEpisode;
    private int endCursor;
    private r14.c fromAweme;
    private String fromAwemeAid;
    private final MutableLiveData<Boolean> loading;
    private String mixId;
    private final MutableLiveData<MixStruct> mixInfoLiveData;
    private final b34.a mixService;
    private boolean shouldPreLoad;
    private int startCursor;
    private int updatedEpisode;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String sceneId() {
        return "compilation_play";
    }

    public final void copyFromTemp() {
        r14.c r0 = tempMixAweme;
        this.fromAweme = r0;
        if (r0 == null) goto L5;
        String r1 = r0.c();
    L6:
        this.fromAwemeAid = r1;
        tempMixAweme = null;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public MixAwemeFeedViewModel() {
        MutableLiveData<Boolean> r0 = new MutableLiveData();
        r0.setValue(Boolean.TRUE);
        this.loading = r0;
        this.mixInfoLiveData = new MutableLiveData();
        this.mixId = "";
        this.startCursor = -1;
        this.endCursor = -1;
        this.updatedEpisode = -1;
        d14.a r1 = b14.a.a;
        this.mixService = b14.a.a(b34.a.class);
    }

    public static final /* synthetic */ r14.c access$getTempMixAweme$cp() {
        return tempMixAweme;
    }

    public final int getCurrentEpisode() {
        return this.currentEpisode;
    }

    public final int getEndCursor() {
        return this.endCursor;
    }

    public final r14.c getFromAweme() {
        return this.fromAweme;
    }

    public final String getFromAwemeAid() {
        return this.fromAwemeAid;
    }

    public final MutableLiveData<Boolean> getLoading() {
        return this.loading;
    }

    public final String getMixId() {
        return this.mixId;
    }

    public final MutableLiveData<MixStruct> getMixInfoLiveData() {
        return this.mixInfoLiveData;
    }

    public final int getStartCursor() {
        return this.startCursor;
    }

    public final int getUpdatedEpisode() {
        return this.updatedEpisode;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public boolean shouldPreLoad() {
        return this.shouldPreLoad;
    }

    public static final /* synthetic */ b34.a access$getMixService$p(MixAwemeFeedViewModel r0) {
        return r0.mixService;
    }

    public static final /* synthetic */ void access$setTempMixAweme$cp(r14.c r0) {
        tempMixAweme = r0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadForwardData(final h04.c<jz3.a> r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        if (this.mixInfoLiveData.getValue() != null) goto L5;
    L12:
        new RuntimeException("data not ready");
        r9.onFail();
        return;
    L5:
        if (this.updatedEpisode == (-1)) goto L12;
        int r0 = this.startCursor;
        if (r0 == (-1)) goto L12;
        if (this.endCursor == (-1)) goto L12;
        final int r5 = RangesKt.coerceAtLeast(r0 - 20, 0);
        this.mixService.Q1(y54.a.a(), this.mixId, r5, 20, new AnonymousClass1(r9, this, r5));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadMoreData(final h04.d<jz3.a> r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        if (this.mixInfoLiveData.getValue() != null) goto L5;
    L12:
        new RuntimeException("data not ready");
        r9.onFail();
        return;
    L5:
        if (this.updatedEpisode == (-1)) goto L12;
        if (this.startCursor == (-1)) goto L12;
        if (this.endCursor == (-1)) goto L12;
        this.mixService.Q1(y54.a.a(), this.mixId, this.endCursor, 20, new C02291(r9, this));
    }

    public final void setCurrentEpisode(int r1) {
        this.currentEpisode = r1;
    }

    public final void setEndCursor(int r1) {
        this.endCursor = r1;
    }

    public final void setFromAweme(r14.c r1) {
        this.fromAweme = r1;
    }

    public final void setFromAwemeAid(String r1) {
        this.fromAwemeAid = r1;
    }

    public final void setMixId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mixId = r2;
    }

    public final void setStartCursor(int r1) {
        this.startCursor = r1;
    }

    public final void setUpdatedEpisode(int r1) {
        this.updatedEpisode = r1;
    }

    public static final /* synthetic */ void access$setShouldPreLoad$p(MixAwemeFeedViewModel r0, boolean r1) {
        r0.shouldPreLoad = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void refreshData(final h04.e<jz3.a> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        r14.c r6 = this.fromAweme;
        if (r6 == null) goto L10;
        Intrinsics.checkNotNull(r6);
        List<? extends jz3.a> r7 = CollectionsKt.listOf(new jz3.a(r6, null, 14));
        if (this.currentEpisode <= 0) goto L7;
        boolean r0 = true;
    L8:
        r4.b(r7, r0, true);
        this.fromAweme = null;
        AoPool.e(new C02301(this), 10);
        return;
    L7:
        r0 = false;
        goto L8
    L10:
        if (this.mixInfoLiveData.getValue() != null) goto L12;
    L19:
        this.mixService.d2(y54.a.a(), this.mixId, new AnonymousClass2(this, r4));
        return;
    L12:
        if (this.updatedEpisode == (-1)) goto L19;
        if (this.startCursor == (-1)) goto L19;
        if (this.endCursor == (-1)) goto L19;
        r4.a(new RuntimeException("data not ready"), -1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public List<jz3.a> filterRefreshData(List<? extends jz3.a> r6, List<? extends jz3.a> r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "oldData");
        List<? extends jz3.a> r9 = r6;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r11.hasNext() == false) goto L9;
        Object r3 = r11.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        jz3.a r5 = (jz3.a) r3;
        r5.d = r2;
        r10.add(r5);
        r2 = r4;
        goto L4
    L9:
        List<jz3.a> r12 = CollectionsKt.toMutableList(r10);
        if (r12.isEmpty() == false) goto L13;
        return r12;
    L13:
        if (r7.isEmpty() == false) goto L15;
        return r12;
    L15:
        List<? extends jz3.a> r13 = r7;
        LinkedHashMap r0 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r13, 10)), 16));
        Iterator<T> r14 = r13.iterator();
    L17:
        if (r14.hasNext() == false) goto L19;
        Object r15 = r14.next();
        r0.put(((jz3.a) r15).a.c(), r15);
        goto L17
    L19:
        Map r16 = MapsKt.toMutableMap(r0);
        Iterator r17 = CollectionsKt.toMutableList(r12).iterator();
    L21:
        if (r17.hasNext() == false) goto L29;
        Object r18 = r17.next();
        int r19 = r1 + 1;
        if (r1 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        jz3.a r20 = (jz3.a) r16.remove(((jz3.a) r18).a.c());
        if (r20 == null) goto L28;
        r20.d = r1;
        ListProtector.set(r12, r1, r20);
    L28:
        r1 = r19;
        goto L21
    L29:
        return r12;
    }
}
