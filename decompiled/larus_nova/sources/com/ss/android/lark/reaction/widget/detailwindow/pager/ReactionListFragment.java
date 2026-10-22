package com.ss.android.lark.reaction.widget.detailwindow.pager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.nova.R;
import com.ss.android.lark.reaction.widget.detailwindow.ReactionPopupFacade;
import com.ss.android.lark.reaction.widget.detailwindow.bean.DetailUserInfo;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionListFragment extends Fragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f439239n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f439240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f439241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f439242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ReactionListAdapter f439243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ReactionPopupFacade.c f439244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ReactionPopupFacade.b f439245i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f439246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f439247k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LKUIStatus f439248l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CallbackManager f439249m;

    public ReactionListFragment() {
        this.f439247k = UIHelper.dp2px(56.0f);
        this.f439249m = new CallbackManager();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        LKUIStatus r100 = this.f439248l;
        if (r100 != null) goto L5;
    L10:
        this.f439249m.cancelCallbacks();
        return;
    L5:
        if (r100.f284252i != 2) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        r100.b();
        goto L10
    L7:
        r101 = false;
        goto L8
    }

    public final void T90(ReactionDetailViewModel r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f439243g != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r100.getTipText()) == true) goto L10;
        ReactionListAdapter r101 = this.f439243g;
        r101.f439238e = r100.getTipText();
        return;
    L10:
        this.f439243g.f439238e = "";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f439240d = new e(this.f439245i);
        if (getArguments() == null) goto L8;
        ReactionDetailViewModel r101 = (ReactionDetailViewModel) getArguments().getSerializable("reaction_info");
        this.f439246j = getArguments().getBoolean("need_loading");
        this.f439247k = getArguments().getInt("bottom_padding", this.f439247k);
        if (r101 == null) goto L9;
        this.f439240d.f439267b = r101;
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        this.f439242f = (RecyclerView) this.f439241e.findViewById(R.id.vp_reaction_list);
        int r102 = 0;
        this.f439242f.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        Context r103 = getContext();
        ReactionDetailViewModel r104 = this.f439240d.f439267b;
        if (r104 != null) goto L5;
        List<DetailUserInfo> r105 = new ArrayList();
    L6:
        this.f439243g = new ReactionListAdapter(r103, r105);
        T90(this.f439240d.f439267b);
        this.f439242f.setAdapter(this.f439243g);
        ViewGroup r106 = this.f439241e;
        LKUIStatus.b r107 = new LKUIStatus.b(r106);
        r107.f284260e = v2c.a.a(r106.getContext(), 100.0f);
        this.f439248l = new LKUIStatus(r107);
        if (this.f439246j == false) goto L18;
        ReactionDetailViewModel r108 = this.f439240d.f439267b;
        if (r108 != null) goto L11;
        List<DetailUserInfo> r109 = new ArrayList();
    L12:
        int r110 = r109.size();
        ReactionDetailViewModel r111 = this.f439240d.f439267b;
        if (r111 == null) goto L16;
        r102 = r111.getTotalCount();
    L16:
        if (r110 >= r102) goto L18;
        this.f439248l.e();
        final e r112 = this.f439240d;
        final UIGetDataCallback r113 = new UIGetDataCallback((IGetDataCallback) this.f439249m.wrapAndAddCallback(new AnonymousClass1(this)));
        r112.getClass();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new d(r112, r113));
        goto L18
    L11:
        r109 = r108.getUserInfoList();
    L18:
        this.f439243g.f439236c = new a(this);
        return;
    L5:
        r105 = r104.getUserInfoList();
        goto L6
    }

    public static ReactionListFragment S90(ReactionDetailViewModel r100, boolean r101, int r102) {
        ReactionListFragment r103 = new ReactionListFragment();
        Bundle r104 = new Bundle();
        r104.putSerializable("reaction_info", r100);
        r104.putSerializable("need_loading", Boolean.valueOf(r101));
        r104.putInt("bottom_padding", r102);
        r103.setArguments(r104);
        return r103;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        ViewGroup r103 = (ViewGroup) r100.inflate(R.layout.fragment_reaction_list_pager, r101, false);
        this.f439241e = r103;
        r103.setPadding(r103.getPaddingLeft(), this.f439241e.getPaddingTop(), this.f439241e.getPaddingRight(), this.f439247k);
        return this.f439241e;
    }
}
