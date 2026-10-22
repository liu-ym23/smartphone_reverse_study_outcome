package com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SelectedUserAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a, View.OnFocusChangeListener, TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f233614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f233615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f233616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f233617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f233618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f233619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f233620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f233621h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f233622i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f233623j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SelectedUserAdapter f233624k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC3348a f233625l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f233626m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final gh5.d f233627n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f233628a;

        public b(c r100) {
            this.f233628a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC3348a r101 = this.f233628a.f233625l;
            if (r101 == null) goto L6;
            r101.X5();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.c$c, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC3350c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f233629a;

        public ViewOnClickListenerC3350c(c r100) {
            this.f233629a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC3348a r101 = this.f233629a.f233625l;
            if (r101 == null) goto L5;
            r101.D2();
        L5:
            ((SpaceEditText) this.f233629a.f233615b.findViewById(R.id.share_input_edit)).setText("");
        }
    }

    public static final class d extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f233630c;

        public d(c r100) {
            this.f233630c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC3348a r101 = this.f233630c.f233625l;
            if (r101 == null) goto L6;
            r101.p();
            return;
        }
    }

    public static final class e implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f233631a;

        public e(c r100) {
            this.f233631a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm_mindnote_mobile.screen_view_horizental") == true) goto L5;
            return false;
        L5:
            if (this.f233631a.f233615b.getContext() == null) goto L14;
            c r103 = this.f233631a;
            if (r103.f233614a.getResources().getConfiguration().orientation == 2) goto L9;
            return false;
        L9:
            if (r101 != 3) goto L16;
            rcb.c.d(r103.f233615b.findViewById(R.id.share_input_edit));
            return true;
        L16:
            return false;
        L14:
            return false;
        }
    }

    public static final class f implements BaseQuickAdapter.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f233632a;

        public f(c r100) {
            this.f233632a = r100;
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public final void onItemClick(BaseQuickAdapter r100, View r101, int r102) {
            if (r102 >= this.f233632a.f233624k.getData().size()) goto L8;
            c r103 = this.f233632a;
            com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC3348a r104 = r103.f233625l;
            if (r104 == null) goto L9;
            r104.O3((UserInfo) ListProtector.get(r103.f233624k.getData(), r102));
            return;
        L9:
            return;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f233633a;

        public g(c r100) {
            this.f233633a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CharSequence r101 = (CharSequence) r100;
            c r102 = this.f233633a;
            if (r101 == null) goto L6;
            String r103 = r101.toString();
            if (r103 == null) goto L6;
        L7:
            com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC3348a r104 = r102.f233625l;
            if (r104 == null) goto L10;
            r104.B2(r103);
        L10:
            boolean r105 = TextUtils.isEmpty(r103);
            ImageView r106 = (ImageView) r102.f233615b.findViewById(R.id.share_search_clear_icon);
            if (r105 == false) goto L13;
            int r107 = 8;
        L14:
            r106.setVisibility(r107);
            return;
        L13:
            r107 = 0;
        L6:
            r103 = "";
            goto L7
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h<T> f233634a = null;

        static {
            f233634a = new h();
        }

        public h() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("TopbarView", (Throwable) r100, false);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a
    public final void P5() {
        RecyclerView r100 = (RecyclerView) this.f233615b.findViewById(R.id.permSearchUserSelectedView);
        if (r100.getVisibility() != 8) goto L6;
        r100.setVisibility(0);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a
    public final void X6() {
        RecyclerView r100 = (RecyclerView) this.f233615b.findViewById(R.id.permSearchUserSelectedView);
        if (r100.getVisibility() != 0) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        if (this.f233622i == false) goto L5;
        int r100 = R.drawable.ud_icon_left_outlined;
    L6:
        ((ImageView) this.f233615b.findViewById(R.id.permSearchUserTitleBack)).setImageResource(r100);
        ((ImageView) this.f233615b.findViewById(R.id.permSearchUserTitleBack)).setOnClickListener(new b(this));
        ((TextView) this.f233615b.findViewById(R.id.permSearchUserTitle)).setText(this.f233616c);
        ((ImageView) this.f233615b.findViewById(R.id.share_search_clear_icon)).setOnClickListener(new ViewOnClickListenerC3350c(this));
        ((SpaceEditText) this.f233615b.findViewById(R.id.share_input_edit)).setOnFocusChangeListener(this);
        ((SpaceEditText) this.f233615b.findViewById(R.id.share_input_edit)).setOnClickListener(new d(this));
        ((SpaceEditText) this.f233615b.findViewById(R.id.share_input_edit)).setOnEditorActionListener(new e(this));
        if (this.f233621h == false) goto L9;
        int r101 = R.string.LarkCCM_ChatShare_SearchUserGroupDeptUsergroupAgent_Placeholder;
    L28:
        ((SpaceEditText) this.f233615b.findViewById(R.id.share_input_edit)).setHint(r101);
        ((RecyclerView) this.f233615b.findViewById(R.id.permSearchUserSelectedView)).setAdapter(this.f233624k);
        ((RecyclerView) this.f233615b.findViewById(R.id.permSearchUserSelectedView)).setLayoutManager(new LinearLayoutManager(this.f233614a, 0, false));
        this.f233624k.setOnItemClickListener(new f(this));
        this.f233626m = vu5.b.a((TextView) this.f233615b.findViewById(R.id.share_input_edit)).debounce(300, TimeUnit.MILLISECONDS, fo5.d.a()).observeOn(fo5.d.d()).subscribe(new g(this), h.f233634a);
        if (this.f233623j == false) goto L32;
        ((SpaceEditText) this.f233615b.findViewById(R.id.share_input_edit)).postDelayed(this.f233627n, 50);
        return;
    L32:
        return;
    L9:
        int r102 = this.f233620g;
        if (r102 != 113) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        r101 = R.string.LarkCCM_Share_Spark_Search_Placeholder;
        goto L28
    L16:
        if (sbb.g.a(r102) == false) goto L19;
        r101 = R.string.LarkCCM_Share_Spark_SearchUserGroup_Placeholder;
        goto L28
    L19:
        if (this.f233619f == false) goto L22;
        r101 = R.string.LarkCCM_Docs_Share_SearchForEmailUserGroup_Placeholder;
        goto L28
    L22:
        if (this.f233618e == false) goto L25;
        r101 = R.string.LarkCCM_Workspace_Search_UserGroup_Placeholder;
        goto L28
    L25:
        if (this.f233617d == false) goto L27;
        r101 = R.string.Doc_Permission_AddUserHint;
        goto L28
    L27:
        r101 = R.string.Doc_Facade_CollaboratorsSearchHint;
        goto L28
    L12:
        r103 = false;
        goto L13
    L5:
        r100 = R.drawable.ud_icon_close_small_outlined;
        goto L6
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        Disposable r100 = this.f233626m;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L12;
        Disposable r102 = this.f233626m;
        if (r102 == null) goto L12;
        r102.dispose();
    L12:
        ((SpaceEditText) this.f233615b.findViewById(R.id.share_input_edit)).removeCallbacks(this.f233627n);
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a
    public final void R0(ArrayList<UserInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfos");
        this.f233624k.setNewData(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a
    public final void W(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        int r101 = this.f233624k.getData().indexOf(r100);
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (r101 >= this.f233624k.getData().size()) goto L9;
        this.f233624k.remove(r101);
        return;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f233625l = (com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC3348a) r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a
    public final void u5(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        this.f233624k.addData(r100);
        ((RecyclerView) this.f233615b.findViewById(R.id.permSearchUserSelectedView)).scrollToPosition(this.f233624k.getData().size() - 1);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC3348a r102 = this.f233625l;
        if (r102 == null) goto L6;
        r102.C2(r101);
        return;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 3) goto L5;
    L8:
        rcb.c.c(this.f233614a);
        return true;
    L5:
        if (r101 == 6) goto L8;
        return false;
    }

    public c(FragmentActivity r100, View r101, String r102, boolean r103, boolean r104, boolean r105, int r106, boolean r107, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f233614a = r100;
        this.f233615b = r101;
        this.f233616c = r102;
        this.f233617d = r103;
        this.f233618e = r104;
        this.f233619f = r105;
        this.f233620g = r106;
        this.f233621h = r107;
        this.f233622i = r110;
        this.f233623j = r111;
        this.f233624k = new SelectedUserAdapter();
        this.f233627n = new gh5.d(this);
    }
}
