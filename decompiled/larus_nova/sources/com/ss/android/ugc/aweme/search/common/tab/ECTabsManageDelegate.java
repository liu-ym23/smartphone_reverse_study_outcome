package com.ss.android.ugc.aweme.search.common.tab;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.framework.tab.TabFeedModel;
import com.ss.android.ugc.aweme.search.common.mob.ECSearchDynamicTabMonitorEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/tab/ECTabsManageDelegate;", "", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabsManageDelegate {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f452211d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends TabFeedModel> f452212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends TabFeedModel> f452213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECTabSource f452214c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/tab/ECTabsManageDelegate$Companion;", "", "", "SEARCH_DYNAMIC_TAB", "Ljava/lang/String;", "SEARCH_TAB_MANAGER", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        f452211d = new Companion(0);
    }

    public final List<TabFeedModel> a() {
        List<? extends TabFeedModel> r100 = this.f452212a;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        if (r100.size() <= 0) goto L9;
        List r101 = this.f452212a;
        Intrinsics.checkNotNull(r101);
        return r101;
    L9:
        return this.f452214c.a();
    }

    public final List<TabFeedModel> b() {
        List r100 = this.f452213b;
        if (r100 == null) goto L8;
        if (r100.size() <= 0) goto L8;
        return r100;
    L8:
        return a();
    }

    public final void c() {
        this.f452212a = this.f452214c.b();     // Catch: Throwable -> L4
    L5:
        this.f452213b = a();
        return;
    L4:
        ECSearchDynamicTabMonitorEvent r100 = new ECSearchDynamicTabMonitorEvent();
        r100.e("crash_catch");
        r100.d();
        goto L5
    }

    public ECTabsManageDelegate() {
        this.f452214c = new ECCommodityTabSource();
        c();
    }

    public final boolean d(List<? extends TabFeedModel> r100) {
        List<? extends TabFeedModel> r101 = this.f452213b;
        if (r101 != null) goto L5;
    L19:
        this.f452213b = r100;
        return true;
    L5:
        if (r101.size() != r100.size()) goto L13;
        int r102 = r101.size();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        if ((!Intrinsics.areEqual((TabFeedModel) ListProtector.get(r101, r103), (TabFeedModel) ListProtector.get(r100, r103))) == true) goto L13;
        r103 = r103 + 1;
        goto L7
    L12:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L17;
        r101 = null;
    L17:
        if (r101 == null) goto L19;
        return false;
    L13:
        r104 = false;
        goto L14
    }
}
