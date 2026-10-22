package com.bytedance.ee.bear.list.recent;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.recent.subordinate.SubordinateRecentView;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uc5.j2;
import uc5.q2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0005\u0011\u0012\u0013\u0014\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/list/recent/SubordinateRecentDocumentFragment;", "Lcom/bytedance/ee/bear/list/folder/MyRootFolderFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "ownerId", "", "mTitleBar", "Lcom/bytedance/ee/bear/list/homepage/title/ITitleBar;", "initMVP", "", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getUserDisplayName", "user", "Lorg/json/JSONObject;", "parseData", "Companion", "SubordinateRecentDocumentViewModel", "SubordinateRecentCache", "SubordinateRecentDocumentPresenter", "SubordinateDocumentParser", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubordinateRecentDocumentFragment extends Hilt_SubordinateRecentDocumentFragment {
    public static final /* synthetic */ int p = 0;
    public String n;
    public com.bytedance.ee.bear.list.homepage.title.b o;

    public final class SubordinateRecentDocumentViewModel extends q2 {
        public final String l;
        public final /* synthetic */ SubordinateRecentDocumentFragment m;

        @Override // com.bytedance.ee.bear.list.list.a
        public final String D() {
            return "40";
        }

        @Override // uc5.q2, com.bytedance.ee.bear.list.list.a
        public final String L() {
            return "subordinate_recent";
        }

        @Override // uc5.q2, com.bytedance.ee.bear.list.list.a
        public final String k() {
            return "/space/api/bff/workspace/recent/team";
        }

        @Override // uc5.q2, com.bytedance.ee.bear.list.list.a
        public final com.bytedance.ee.bear.list.u o() {
            return new b(this.m);
        }

        @Override // uc5.q2
        public final j2 x0() {
            return new c(this.m);
        }

        @Override // uc5.q2, com.bytedance.ee.bear.list.list.e
        public final LiveData<ArrayList<Document>> X() {
            lc5.x.c().a("load_db_data");
            return Transformations.map(((mc5.j) this.k.a(mc5.j.class)).zd(this.l), SubordinateRecentDocumentFragment$SubordinateRecentDocumentViewModel$getListLiveData$1.INSTANCE);
        }

        @Override // uc5.q2, com.bytedance.ee.bear.list.list.a
        public final NetService.f h() {
            NetService.f r0 = super.h();
            Map r1 = ((NetService.e) r0).e;
            if (r1 == null) goto L5;
            String r2 = (String) ((HashMap) r1).remove("asc");
        L5:
            r0.b("asc", "1");
            String r3 = this.l;
            if (r3 == null) goto L8;
            r0.b("owner_id", r3);
        L8:
            return r0;
        }

        @Override // uc5.q2, com.bytedance.ee.bear.list.list.a
        public final /* bridge */ /* synthetic */ mc5.k p() {
            return x0();
        }

        public SubordinateRecentDocumentViewModel(SubordinateRecentDocumentFragment r2, ce5.a r3, LifeCycleFragment r4, Context r5, String r6) {
            Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
            this.m = r2;
            super(r4, r5, r3);
            this.l = r6;
        }
    }

    public static final class a {
    }

    public final class b extends g {
        public final /* synthetic */ SubordinateRecentDocumentFragment c;

        public static final class a implements Runnable {
            public final /* synthetic */ SubordinateRecentDocumentFragment a;
            public final /* synthetic */ String b;

            public a(SubordinateRecentDocumentFragment r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SubordinateRecentDocumentFragment r0 = this.a;     // Catch: Throwable -> L9
                com.bytedance.ee.bear.list.homepage.title.b r1 = r0.o;     // Catch: Throwable -> L9
                if (r1 == null) goto L12;
                Context r2 = r0.getContext();     // Catch: Throwable -> L9
                if (r2 != null) goto L7;
                r2 = eu5.b.a;     // Catch: Throwable -> L9
            L7:
                r1.setTitle(xo5.a.c(r2, 2131888784, "user", this.b));     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public b(SubordinateRecentDocumentFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.list.u
        public final void g(JSONObject r5) {
            if (r5 == null) goto L4;
            JSONObject r6 = r5.optJSONObject(this.c.n);
        L5:
            if (r6 == null) goto L8;
            SubordinateRecentDocumentFragment r0 = this.c;
            int r1 = SubordinateRecentDocumentFragment.p;
            r0.getClass();
            String r2 = Locale.CHINESE.getLanguage();
            String r3 = r6.optString("display_name");
            String r7 = r6.optString("cn_name");
            com.bytedance.ee.util.ui.j.c(new a(r0, ou5.a.d(r2, r3, r7, r7)));
            return;
        L8:
            return;
        L4:
            r6 = null;
            goto L5
        }

        @Override // com.bytedance.ee.bear.list.recent.g, com.bytedance.ee.bear.list.u
        public final Document d(JSONObject r1, JSONObject r2, JSONObject r3, boolean r4) {
            Document r5 = super.d(r1, r2, r3, true);
            if (r5 == null) goto L5;
            r5.G2 = this.c.n;
        L5:
            return r5;
        }
    }

    public final class c extends j2 {
        @Override // uc5.g
        public final int c() {
            return 18;
        }

        @Override // uc5.j2, mc5.k
        public final FolderSortStrategy getFilter() {
            return new FolderSortStrategy("subordinate_recent", FilterType.ALL.getType(), "", "", RecentSort.MODIFIED.getRank(), true);
        }

        public c(SubordinateRecentDocumentFragment r2) {
            super(new ce5.a(r2));
        }
    }

    public final class d extends com.bytedance.ee.bear.list.folder.f {
        @Override // com.bytedance.ee.bear.list.folder.f, com.bytedance.ee.bear.list.list.b
        public final String J8() {
            return "subordinate_recent";
        }

        public d(com.bytedance.ee.bear.list.folder.d r10, SubordinateRecentDocumentViewModel r11, Context r12, LifeCycleFragment r13, ce5.a r14) {
            Intrinsics.checkNotNullParameter(r14, "userComponentAbility");
            super(r10, r11, r12, r13, r14, null, "MINE");
        }
    }

    static {
    }

    public SubordinateRecentDocumentFragment() {
        this.n = "";
    }

    @Override // com.bytedance.ee.bear.list.folder.MyRootFolderFragment
    public final void V90() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L8;
        Intent r1 = r0.getIntent();
        if (r1 == null) goto L8;
        String r2 = r1.getStringExtra("owner_id");
        if (r2 == null) goto L8;
    L9:
        this.n = r2;
        ce5.a r3 = new ce5.a(this);
        SubordinateRecentDocumentViewModel r7 = new SubordinateRecentDocumentViewModel(this, r3, this, getContext(), this.n);
        SubordinateRecentView r8 = new SubordinateRecentView(getContext(), this.g, this, this, r3);
        this.i = r8;
        this.h = new d(r8, r7, getContext(), this, r3);
        if ((getActivity() instanceof wc5.g) == false) goto L16;
        wc5.g r4 = getActivity();
        if (r4 == null) goto L14;
        com.bytedance.ee.bear.list.homepage.title.b r5 = r4.getTitleBar();
    L15:
        this.o = r5;
        goto L16
    L14:
        r5 = null;
    L16:
        this.h.create();
        return;
    L8:
        r2 = "";
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.folder.MyRootFolderFragment
    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L5;
        d0c.c r0 = getActivity();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");     // Catch: Exception -> L7
        UserSession r1 = r0.e9();     // Catch: Exception -> L7
    L9:
        return r1;
    L5:
        r1 = PassportcConvention.b(this);     // Catch: Exception -> L7
    L12:
        return new ce5.a().b;
    }
}
