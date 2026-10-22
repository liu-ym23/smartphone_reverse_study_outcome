package com.bytedance.awemeopen.apps.framework.profile.works;

import android.app.Application;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.FeedRecyclerListViewModel;
import com.bytedance.awemeopen.apps.framework.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 62\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b4\u00105J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\fH\u0016J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00122\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00101\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!¨\u00069"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/works/UserProfileWorksFragmentViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/FeedRecyclerListViewModel;", "Lh04/d;", "Ljz3/a;", "callback", "", "doRefresh", "doLoadMore", "", UploadTypeInf.COUNT, "setPageCount", "resetPageCount2Default", "", "openId", "setUserOpenId", "getUserOpenId", "", "maxCursor", "", "hasMore", "sceneId", "refresh", "loadData", "pageCount", "I", "J", "Z", "mUserOpenId", "Ljava/lang/String;", "enterAid", "getEnterAid", "()Ljava/lang/String;", "setEnterAid", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "hostExtraParams", "Lorg/json/JSONObject;", "getHostExtraParams", "()Lorg/json/JSONObject;", "setHostExtraParams", "(Lorg/json/JSONObject;)V", "enterIsLive", "getEnterIsLive", "()Z", "setEnterIsLive", "(Z)V", "hideLongPressTab", "getHideLongPressTab", "setHideLongPressTab", "hostEnterFrom", "getHostEnterFrom", "setHostEnterFrom", "<init>", "()V", "Companion", "a", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
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
        public final String a;
        public final m24.a b;
        public final /* synthetic */ UserProfileWorksFragmentViewModel c;

        public final void onFail(Exception r3) {
            if (Intrinsics.areEqual(this.a, UserProfileWorksFragmentViewModel.access$getMUserOpenId$p(this.c)) == false) goto L8;
            m24.a r0 = this.b;
            if (r0 == null) goto L9;
            r0.onFail(r3);
            return;
        L9:
            return;
        }

        public b(UserProfileWorksFragmentViewModel r2, String r3, m24.a r4) {
            Intrinsics.checkNotNullParameter(r3, "inputUserOpenId");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }

        public final void a(List<r14.c> r3, long r4, boolean r6) {
            Intrinsics.checkNotNullParameter(r3, "data");
            if (Intrinsics.areEqual(this.a, UserProfileWorksFragmentViewModel.access$getMUserOpenId$p(this.c)) == false) goto L8;
            m24.a r0 = this.b;
            if (r0 == null) goto L9;
            r0.a(r3, r4, r6);
            return;
        L9:
            return;
        }
    }

    public static final class c implements m24.a {
        public final /* synthetic */ UserProfileWorksFragmentViewModel a;
        public final /* synthetic */ h04.d<jz3.a> b;

        public final void onFail(Exception r1) {
            this.b.onFail();
        }

        public c(UserProfileWorksFragmentViewModel r1, h04.d<jz3.a> r2) {
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
            UserProfileWorksFragmentViewModel.access$setMaxCursor$p(this.a, r7);
            UserProfileWorksFragmentViewModel.access$setHasMore$p(this.a, r9);
            this.b.onSuccess(r0, r9);
        }
    }

    public static final class d implements m24.a {
        public final /* synthetic */ UserProfileWorksFragmentViewModel a;
        public final /* synthetic */ h04.d<jz3.a> b;

        public final void onFail(Exception r1) {
            this.b.onFail();
        }

        public d(UserProfileWorksFragmentViewModel r1, h04.d<jz3.a> r2) {
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
            UserProfileWorksFragmentViewModel.access$setMaxCursor$p(this.a, r7);
            UserProfileWorksFragmentViewModel.access$setHasMore$p(this.a, r9);
            this.b.onSuccess(r0, r9);
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

    public static final /* synthetic */ String access$getMUserOpenId$p(UserProfileWorksFragmentViewModel r0) {
        return r0.mUserOpenId;
    }

    private final void doLoadMore(h04.d<jz3.a> r8) {
        d14.a r0 = b14.a.a;
        m24.c r1 = b14.a.a(m24.c.class);
        Application r2 = getApplication();
        m24.b r3 = new m24.b();
        String r4 = this.mUserOpenId;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.a = r4;
        r3.b = this.pageCount;
        r3.c = this.maxCursor;
        List r5 = q.a();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.d = r5;
        Unit r6 = Unit.INSTANCE;
        r1.r3(r2, r3, new b(this, this.mUserOpenId, new c(this, r8)));
    }

    private final void doRefresh(h04.d<jz3.a> r8) {
        d14.a r0 = b14.a.a;
        m24.c r1 = b14.a.a(m24.c.class);
        Application r2 = getApplication();
        m24.b r3 = new m24.b();
        String r4 = this.mUserOpenId;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.a = r4;
        r3.b = this.pageCount;
        r3.c = 0;
        List r5 = q.a();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.d = r5;
        Unit r6 = Unit.INSTANCE;
        r1.r3(r2, r3, new b(this, this.mUserOpenId, new d(this, r8)));
    }

    public final void setEnterAid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterAid = r2;
    }

    public final void setEnterIsLive(boolean r1) {
        this.enterIsLive = r1;
    }

    public final void setHideLongPressTab(boolean r1) {
        this.hideLongPressTab = r1;
    }

    public final void setHostEnterFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.hostEnterFrom = r2;
    }

    public final void setHostExtraParams(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.hostExtraParams = r2;
    }

    public final void setPageCount(int r1) {
        this.pageCount = r1;
    }

    public final void setUserOpenId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.mUserOpenId = r1;
    }

    public static final /* synthetic */ void access$setHasMore$p(UserProfileWorksFragmentViewModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setMaxCursor$p(UserProfileWorksFragmentViewModel r0, long r1) {
        r0.maxCursor = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListViewModel
    public void loadData(boolean r2, h04.d<jz3.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (r2 == false) goto L5;
        doRefresh(r3);
        return;
    L5:
        doLoadMore(r3);
    }
}
