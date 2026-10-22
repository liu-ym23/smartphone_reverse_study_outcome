package com.bytedance.awemeopen.apps.framework.profile.works;

import android.app.Application;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.FeedRecyclerListViewModel;
import com.bytedance.awemeopen.apps.framework.utils.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 62\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b4\u00105J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\fH\u0016J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00122\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00101\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!¨\u00069"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/works/UserProfileWorksFragmentViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/FeedRecyclerListViewModel;", "Lh04/d;", "Ljz3/a;", "callback", "", "doRefresh", "doLoadMore", "", "count", "setPageCount", "resetPageCount2Default", "", "openId", "setUserOpenId", "getUserOpenId", "", "maxCursor", "", "hasMore", "sceneId", "refresh", "loadData", "pageCount", "I", "J", "Z", "mUserOpenId", "Ljava/lang/String;", "enterAid", "getEnterAid", "()Ljava/lang/String;", "setEnterAid", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "hostExtraParams", "Lorg/json/JSONObject;", "getHostExtraParams", "()Lorg/json/JSONObject;", "setHostExtraParams", "(Lorg/json/JSONObject;)V", "enterIsLive", "getEnterIsLive", "()Z", "setEnterIsLive", "(Z)V", "hideLongPressTab", "getHideLongPressTab", "setHideLongPressTab", "hostEnterFrom", "getHostEnterFrom", "setHostEnterFrom", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserProfileWorksFragmentViewModel extends FeedRecyclerListViewModel {
    public static final a Companion = null;
    public static final int DEFAULT_PAGE_COUNT = 20;
    private String enterAid;
    private boolean enterIsLive;
    private boolean hasMore;
    private boolean hideLongPressTab;
    private String hostEnterFrom;
    private JSONObject hostExtraParams;
    private String mUserOpenId;
    private long maxCursor;
    private int pageCount;

    public static final class a {
        public a() {
        }
    }

    public final class b implements m24.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f197566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m24.a f197567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UserProfileWorksFragmentViewModel f197568c;

        @Override // m24.a
        public final void onFail(Exception r100) {
            if (Intrinsics.areEqual(this.f197566a, UserProfileWorksFragmentViewModel.access$getMUserOpenId$p(this.f197568c)) == false) goto L8;
            m24.a r101 = this.f197567b;
            if (r101 == null) goto L9;
            r101.onFail(r100);
            return;
        L9:
            return;
        }

        public b(UserProfileWorksFragmentViewModel r100, String r101, m24.a r102) {
            Intrinsics.checkNotNullParameter(r101, "inputUserOpenId");
            this.f197568c = r100;
            this.f197566a = r101;
            this.f197567b = r102;
        }

        @Override // m24.a
        public final void a(List<r14.c> r100, long r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            if (Intrinsics.areEqual(this.f197566a, UserProfileWorksFragmentViewModel.access$getMUserOpenId$p(this.f197568c)) == false) goto L8;
            m24.a r103 = this.f197567b;
            if (r103 == null) goto L9;
            r103.a(r100, r101, r102);
            return;
        L9:
            return;
        }
    }

    public static final class c implements m24.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserProfileWorksFragmentViewModel f197569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h04.d<jz3.a> f197570b;

        @Override // m24.a
        public final void onFail(Exception r100) {
            this.f197570b.onFail();
        }

        public c(UserProfileWorksFragmentViewModel r100, h04.d<jz3.a> r101) {
            this.f197569a = r100;
            this.f197570b = r101;
        }

        @Override // m24.a
        public final void a(List<r14.c> r100, long r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            List<r14.c> r103 = r100;
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
            Iterator<T> r105 = r103.iterator();
        L4:
            if (r105.hasNext() == false) goto L6;
            r104.add(new jz3.a((r14.c) r105.next(), null, 14));
            goto L4
        L6:
            UserProfileWorksFragmentViewModel.access$setMaxCursor$p(this.f197569a, r101);
            UserProfileWorksFragmentViewModel.access$setHasMore$p(this.f197569a, r102);
            this.f197570b.onSuccess(r104, r102);
        }
    }

    public static final class d implements m24.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserProfileWorksFragmentViewModel f197571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h04.d<jz3.a> f197572b;

        @Override // m24.a
        public final void onFail(Exception r100) {
            this.f197572b.onFail();
        }

        public d(UserProfileWorksFragmentViewModel r100, h04.d<jz3.a> r101) {
            this.f197571a = r100;
            this.f197572b = r101;
        }

        @Override // m24.a
        public final void a(List<r14.c> r100, long r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            List<r14.c> r103 = r100;
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
            Iterator<T> r105 = r103.iterator();
        L4:
            if (r105.hasNext() == false) goto L6;
            r104.add(new jz3.a((r14.c) r105.next(), null, 14));
            goto L4
        L6:
            UserProfileWorksFragmentViewModel.access$setMaxCursor$p(this.f197571a, r101);
            UserProfileWorksFragmentViewModel.access$setHasMore$p(this.f197571a, r102);
            this.f197572b.onSuccess(r104, r102);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.FeedRecyclerListViewModel
    public String sceneId() {
        return "profile_works";
    }

    public final void resetPageCount2Default() {
        this.pageCount = 20;
    }

    public UserProfileWorksFragmentViewModel() {
        this.pageCount = 20;
        this.mUserOpenId = "";
        this.enterAid = "";
        this.hostExtraParams = new JSONObject();
        this.hostEnterFrom = "";
    }

    public final String getEnterAid() {
        return this.enterAid;
    }

    public final boolean getEnterIsLive() {
        return this.enterIsLive;
    }

    public final boolean getHideLongPressTab() {
        return this.hideLongPressTab;
    }

    public final String getHostEnterFrom() {
        return this.hostEnterFrom;
    }

    public final JSONObject getHostExtraParams() {
        return this.hostExtraParams;
    }

    public final String getUserOpenId() {
        return this.mUserOpenId;
    }

    public final boolean hasMore() {
        return this.hasMore;
    }

    public final long maxCursor() {
        return this.maxCursor;
    }

    public static final /* synthetic */ String access$getMUserOpenId$p(UserProfileWorksFragmentViewModel r100) {
        return r100.mUserOpenId;
    }

    private final void doLoadMore(h04.d<jz3.a> r100) {
        d14.a r101 = b14.a.f16924a;
        m24.c r102 = (m24.c) b14.a.a(m24.c.class);
        Application r103 = getApplication();
        m24.b r104 = new m24.b();
        String r105 = this.mUserOpenId;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f511657a = r105;
        r104.f511658b = this.pageCount;
        r104.f511659c = this.maxCursor;
        List<? extends u24.b> r106 = q.a();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r104.f511660d = r106;
        Unit r107 = Unit.INSTANCE;
        r102.r3(r103, r104, new b(this, this.mUserOpenId, new c(this, r100)));
    }

    private final void doRefresh(h04.d<jz3.a> r100) {
        d14.a r101 = b14.a.f16924a;
        m24.c r102 = (m24.c) b14.a.a(m24.c.class);
        Application r103 = getApplication();
        m24.b r104 = new m24.b();
        String r105 = this.mUserOpenId;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f511657a = r105;
        r104.f511658b = this.pageCount;
        r104.f511659c = 0;
        List<? extends u24.b> r106 = q.a();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r104.f511660d = r106;
        Unit r107 = Unit.INSTANCE;
        r102.r3(r103, r104, new b(this, this.mUserOpenId, new d(this, r100)));
    }

    public final void setEnterAid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterAid = r100;
    }

    public final void setEnterIsLive(boolean r100) {
        this.enterIsLive = r100;
    }

    public final void setHideLongPressTab(boolean r100) {
        this.hideLongPressTab = r100;
    }

    public final void setHostEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostEnterFrom = r100;
    }

    public final void setHostExtraParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostExtraParams = r100;
    }

    public final void setPageCount(int r100) {
        this.pageCount = r100;
    }

    public final void setUserOpenId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.mUserOpenId = r100;
    }

    public static final /* synthetic */ void access$setHasMore$p(UserProfileWorksFragmentViewModel r100, boolean r101) {
        r100.hasMore = r101;
    }

    public static final /* synthetic */ void access$setMaxCursor$p(UserProfileWorksFragmentViewModel r100, long r101) {
        r100.maxCursor = r101;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListViewModel
    public void loadData(boolean r100, h04.d<jz3.a> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100 == false) goto L5;
        doRefresh(r101);
        return;
    L5:
        doLoadMore(r101);
    }
}
