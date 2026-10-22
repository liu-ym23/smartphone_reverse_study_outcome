package com.bytedance.ee.bear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtCheckBoxViewModel;
import com.bytedance.ee.bear.atfinder.AtFinderResult;
import com.bytedance.ee.bear.atfinder.AtFinderViewModel;
import com.bytedance.ee.bear.atfinder.AtMentionListAdapter;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AtFinderView extends FrameLayout implements com.bytedance.ee.bear.atfinder.c.a {
    public static final Map<String, Boolean> n = null;
    public final String a;
    public com.bytedance.ee.bear.atfinder.c b;
    public c c;
    public AtMentionListAdapter d;
    public AtFinderViewModel e;
    public final List<AtObject> f;
    public String g;
    public a h;
    public com.bytedance.ee.bear.atfinder.f i;
    public LifecycleOwner j;
    public AtCheckBoxViewModel k;
    public b l;
    public bo4.c m;

    public static final class a implements Observer<AtFinderResult> {
        public final WeakReference<AtFinderView> a;
        public AtFinderResult b;

        public a(AtFinderView r2) {
            this.a = new WeakReference(r2);
        }

        public final void onChanged(Object r9) {
            AtFinderResult r10 = (AtFinderResult) r9;
            StringBuilder r0 = new StringBuilder("onChanged: hasResult:");
            boolean r1 = true;
            if (r10 == null) goto L9;
            List r3 = r10.list;
            if (r3 == null) goto L9;
            if (r3.isEmpty() == true) goto L9;
            boolean r4 = true;
        L10:
            r0.append(r4);
            tt5.a.h("AtFinderResultObserver", r0.toString());
            if (this.b == r10) goto L71;
            if (r10 == null) goto L71;
            this.b = r10;
            AtFinderView r2 = this.a.get();
            if (r2 == null) goto L73;
            tt5.a.b("AtFinderResultObserver", "mSearchResultList onChanged");
            ((ArrayList) r2.f).clear();
            c r5 = r2.c;
            tt5.a.h(r5.a, "hideSearchLoading() called");
            Disposable r6 = r5.o;
            if (r6 != null) goto L18;
        L20:
            Disposable r7 = r5.p;
            if (r7 == null) goto L26;
            if (r7.isDisposed() == true) goto L26;
            r5.p.dispose();
            tt5.a.b(r5.a, "disposeHideLoading");
        L26:
            if (r5.i.getVisibility() != 0) goto L28;
            boolean r8 = true;
        L29:
            if (r8 == false) goto L31;
            long r11 = System.currentTimeMillis() - r5.b;
            tt5.a.b(r5.a, "delay hideSearchLoading");
            r5.p = Observable.timer(Math.max(0, 500 - r11), TimeUnit.MILLISECONDS).subscribeOn(fo5.d.d()).observeOn(fo5.d.d()).doOnComplete(new v(r5)).subscribe();
        L31:
            List r12 = r10.list;
            if (r12 != null) goto L34;
        L36:
            r1 = false;
        L37:
            tt5.a.h(r2.a, "onRefreshSearchResult: hasResult=" + r1);
            if (r1 == false) goto L40;
            r2.c.a();
            tt5.a.b(r2.a, "AtFinderView.onRefreshSearchResult:147 ");
            ((ArrayList) r2.f).addAll(r10.list);
        L49:
            tt5.a.b(r2.a, "onRefreshSearchResult mSearchResultList = " + ((ArrayList) r2.f).size());
            r2.d.setNewData(r2.f);
            RecyclerView.LayoutManager r13 = r2.c.g.getLayoutManager();
            if (r13 == null) goto L56;
            List<AtObject> r14 = r2.f;
            if (r14 == null) goto L56;
            if (((ArrayList) r14).size() <= 0) goto L56;
            r13.scrollToPosition(0);
        L56:
            com.bytedance.ee.bear.atfinder.c r15 = r2.b;
            if (r15 != null) goto L59;
        L68:
            b r16 = r2.l;
            if (r16 == null) goto L74;
            r16.a();
            return;
        L74:
            return;
        L59:
            if (r1 == false) goto L64;
            String r17 = r10.keyword;
            r15.f = r17;
            com.bytedance.ee.bear.atfinder.d r18 = r15.d;
            if (r18 == null) goto L63;
            r18.c(r17);
            goto L68
        L63:
            tt5.a.h("AtFinderController", "sendExistResult: mAtFinderDataCallback is null");
            goto L68
        L64:
            String r19 = r10.keyword;
            r15.f = r19;
            com.bytedance.ee.bear.atfinder.d r20 = r15.d;
            if (r20 == null) goto L67;
            r20.d(r19);
            goto L68
        L67:
            tt5.a.h("AtFinderController", "sendEmptyResult: mAtFinderDataCallback is null");
            goto L68
        L40:
            c r21 = r2.c;
            int r22 = r2.getHeight();
            if (r21.t == false) goto L47;
            r21.e.setVisibility(0);
            View r23 = r21.f;
            if (r22 < r21.y) goto L45;
            int r24 = 0;
        L46:
            r23.setVisibility(r24);
        L48:
            r21.h.setVisibility(8);
            r21.u.setVisibility(8);
            goto L49
        L45:
            r24 = 8;
            goto L46
        L47:
            r21.d.setVisibility(0);
            goto L48
        L34:
            if (r12.isEmpty() == true) goto L36;
        L28:
            r8 = false;
            goto L29
        L18:
            if (r6.isDisposed() == true) goto L20;
            r5.o.dispose();
            tt5.a.b(r5.a, "disposeShowLoading");
            goto L20
        L73:
            return;
        L71:
            tt5.a.h("AtFinderResultObserver", "onChanged: result is null");
            return;
        L9:
            r4 = false;
            goto L10
        }
    }

    public interface b {
        void a();
    }

    public static final class c {
        public String a;
        public long b;
        public final View c;
        public View d;
        public View e;
        public View f;
        public RecyclerView g;
        public CommonActionPanelLayout h;
        public View i;
        public View j;
        public BearLottieView k;
        public View l;
        public View m;
        public View n;
        public Disposable o;
        public Disposable p;
        public w q;
        public ln4.j r;
        public boolean s;
        public boolean t;
        public View u;
        public UDCheckBox v;
        public TextView w;
        public a x;
        public final int y;

        public interface a {
        }

        static {
            Map<String, Boolean> r0 = AtFinderView.n;
            HashMap r2 = (HashMap) r0;
            r2.put("checkbox_selected_key_executor", Boolean.TRUE);
            HashMap r1 = (HashMap) r0;
            r1.put("checkbox_selected_key_notify_user", Boolean.FALSE);
        }

        public final void a() {
            if (this.t == false) goto L5;
            this.e.setVisibility(8);
            c();
            return;
        L5:
            this.d.setVisibility(8);
            this.h.setVisibility(0);
            b();
        }

        public final void b() {
            ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            if (this.r == null) goto L6;
            this.u.setVisibility(0);
            this.h.setVisibility(8);
            this.m.setVisibility(8);
            this.w.setText(this.r.b);
            this.v.setChecked(this.r.c);
            r0.topMargin = com.bytedance.ee.util.ui.n.d(4);
            r0.leftMargin = 0;
            r0.rightMargin = 0;
        L9:
            this.c.requestLayout();
            return;
        L6:
            if (this.s == false) goto L8;
            this.u.setVisibility(8);
            this.h.setVisibility(8);
            this.m.setVisibility(0);
            r0.topMargin = com.bytedance.ee.util.ui.n.d(4);
            r0.leftMargin = com.bytedance.ee.util.ui.n.d(4);
            r0.rightMargin = com.bytedance.ee.util.ui.n.d(4);
            goto L9
        L8:
            this.u.setVisibility(8);
            this.h.setVisibility(0);
            this.m.setVisibility(8);
            r0.topMargin = 0;
            r0.leftMargin = 0;
            r0.rightMargin = 0;
            goto L9
        }

        public final void c() {
            ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            if (this.r == null) goto L20;
            this.u.setVisibility(0);
            this.m.setVisibility(8);
            this.w.setText(this.r.b);
            Map<String, Boolean> r1 = AtFinderView.n;
            if (r1 == null) goto L13;
            int r2 = this.r.a;
            if (r2 != 1) goto L9;
            boolean r3 = Boolean.TRUE.equals(((HashMap) r1).get("checkbox_selected_key_executor"));
        L14:
            this.v.setChecked(r3);
            a r4 = this.x;
            if (r4 == null) goto L19;
            AtCheckBoxViewModel r5 = ((r) r4).a.k;
            if (r5 == null) goto L19;
            r5.setCheckboxSelected(r3);
        L19:
            r0.topMargin = com.bytedance.ee.util.ui.n.d(0);
            r0.leftMargin = 0;
            r0.rightMargin = 0;
        L21:
            this.c.requestLayout();
            return;
        L9:
            if (r2 != 2) goto L13;
            r3 = Boolean.TRUE.equals(((HashMap) r1).get("checkbox_selected_key_notify_user"));
        L13:
            r3 = false;
            goto L14
        L20:
            this.u.setVisibility(8);
            this.h.setVisibility(8);
            this.m.setVisibility(8);
            r0.topMargin = 0;
            r0.leftMargin = 0;
            r0.rightMargin = 0;
            goto L21
        }

        public c(View r3) {
            this.a = "ViewsHolder";
            this.b = 0;
            this.s = false;
            this.t = false;
            this.y = com.bytedance.ee.util.ui.n.d(120);
            this.c = r3;
            this.l = r3.findViewById(2131377625);
            this.m = r3.findViewById(2131377460);
            this.j = r3.findViewById(2131385567);
            this.d = r3.findViewById(2131385547);
            this.n = r3.findViewById(2131372554);
            this.e = r3.findViewById(2131385549);
            this.f = r3.findViewById(2131385550);
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mention.optimizing_authorizaiton") == false) goto L5;
            View r0 = r3.findViewById(2131377452);
            this.u = r0;
            this.v = r0.findViewById(2131363305);
            this.w = (TextView) this.u.findViewById(2131363306);
        L6:
            this.g = r3.findViewById(2131385573);
            this.i = r3.findViewById(2131385532);
            this.k = r3.findViewById(2131385530);
            CommonActionPanelLayout r4 = (CommonActionPanelLayout) r3.findViewById(2131385584);
            this.h = r4;
            r4.setOnActionListener(new t(this));
            com.bytedance.ee.util.ui.l.b(this.k, 2131100548);
            com.bytedance.ee.util.ui.l.b(this.d, 2131100548);
            com.bytedance.ee.util.ui.l.b(this.e, 2131100548);
            this.v.setOnCheckedChangeListener(new s(this));
            return;
        L5:
            View r1 = r3.findViewById(2131377454);
            this.u = r1;
            this.v = r1.findViewById(2131363308);
            this.w = (TextView) this.u.findViewById(2131363307);
            goto L6
        }
    }

    static {
        n = new HashMap();
    }

    public final void a() {
        tt5.a.h(this.a, "close() called");
        this.e.getSearchResultList(this.g).removeObserver(this.h);
        if (ForsetiHelper.h() == false) goto L5;
        this.e.getSearchResultList(this.g).setValue(null);
    L5:
        this.c.k.cancelAnimation();
        setVisibility(8);
    }

    public final void c() {
        tt5.a.b(this.a, "AtFinderView.initViews:82 ");
        c r1 = new c(LayoutInflater.from(getContext()).inflate(2131558729, this, true));
        this.c = r1;
        r1.a = this.a;
        this.d = new AtMentionListAdapter(this.f);
        this.c.g.setLayoutManager(new LinearLayoutManager(getContext()));
        this.c.g.setAdapter(this.d);
        c r0 = this.c;
        r0.x = new r(this);
        setVisibility(8);
        setBackground(null);
        this.c.d.setBackgroundColor(-1);
        this.c.d.setElevation(30.0f);
        this.c.e.setBackgroundColor(-1);
        this.c.e.setElevation(30.0f);
    }

    public final void e() {
        tt5.a.h(this.a, "showLoading");
        c r0 = this.c;
        Disposable r1 = r0.o;
        if (r1 != null) goto L5;
    L7:
        Disposable r2 = r0.p;
        if (r2 == null) goto L13;
        if (r2.isDisposed() == true) goto L13;
        r0.p.dispose();
        tt5.a.b(r0.a, "disposeHideLoading");
    L13:
        if (r0.i.getVisibility() != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L18;
        tt5.a.b(r0.a, "showSearchLoading delay");
        r0.o = Observable.timer(250, TimeUnit.MILLISECONDS).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).doOnComplete(new u(r0)).subscribe();
    L18:
        b r4 = this.l;
        if (r4 == null) goto L22;
        r4.a();
        return;
    L22:
        return;
    L15:
        r3 = false;
        goto L16
    L5:
        if (r1.isDisposed() == true) goto L7;
        r0.o.dispose();
        tt5.a.b(r0.a, "disposeShowLoading");
        goto L7
    }

    public AtFinderView(Context r2) {
        super(r2);
        String r3 = "AtFinderView#" + Integer.toHexString(hashCode());
        this.a = r3;
        this.f = new ArrayList();
        tt5.a.b(r3, "AtFinderView.AtFinderView:64 ");
        c();
    }

    public void setAtCommonConfig(bo4.c r4) {
        this.m = r4;
        if (r4 == null) goto L8;
        c r0 = this.c;
        boolean r5 = r4.c;
        r0.t = r5;
        if (r5 == false) goto L9;
        ViewGroup.LayoutParams r6 = r0.l.getLayoutParams();
        r6.height = -1;
        r0.l.setLayoutParams(r6);
        ViewGroup.LayoutParams r7 = r0.n.getLayoutParams();
        r7.height = -1;
        r0.n.setLayoutParams(r7);
        return;
    L9:
        return;
    }

    public void setAtFinderViewDelegate(w r2) {
        this.c.q = r2;
    }

    public void setCheckBoxData(ln4.j r2) {
        c r0 = this.c;
        if (r0 == null) goto L9;
        r0.r = r2;
        if (r0.t == false) goto L7;
        r0.c();
        return;
    L7:
        r0.b();
        return;
    }

    public void setCommentLandscape(boolean r2) {
        c r0 = this.c;
        if (r0 == null) goto L9;
        r0.s = r2;
        if (r0.t == false) goto L7;
        r0.c();
        return;
    L7:
        r0.b();
        return;
    }

    public void setContentHeightChangeCallback(b r1) {
        this.l = r1;
    }

    public void setSearchDelegate(com.bytedance.ee.bear.atfinder.f r1) {
        this.i = r1;
    }

    public void setTitle(String r2) {
        this.c.h.setTitle(r2);
    }

    public AtFinderView(Context r1, AttributeSet r2) {
        super(r1, r2);
        String r3 = "AtFinderView#" + Integer.toHexString(hashCode());
        this.a = r3;
        this.f = new ArrayList();
        tt5.a.b(r3, "AtFinderView.AtFinderView:69 ");
        c();
    }

    public final void b(List<String> r8, bo4.d r9) {
        this.e.setSearchDelegate(this.i);
        this.h = new a(this);
        com.bytedance.ee.bear.atfinder.c r0 = new com.bytedance.ee.bear.atfinder.c(this.e, r9, this.m, AtUtils.b(r8), this);
        this.b = r0;
        this.g = r0.e;
        r0.n = this.k;
        this.d.setOnItemClickListener(r0);
        int r10 = r9.b;
        AtMentionListAdapter r11 = this.d;
        if (r10 != 6) goto L5;
        boolean r12 = true;
    L6:
        r11.a = r12;
        return;
    L5:
        r12 = false;
        goto L6
    }

    public AtFinderView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        String r4 = "AtFinderView#" + Integer.toHexString(hashCode());
        this.a = r4;
        this.f = new ArrayList();
        tt5.a.b(r4, "AtFinderView.AtFinderView:74 ");
        c();
    }

    public final com.bytedance.ee.bear.atfinder.c d(FragmentActivity r4, List<String> r5, bo4.d r6) {
        tt5.a.b(this.a, "AtFinderView.makeAtFinderController:79token=" + du5.b.g(r6.a) + " source=" + r6.b);
        this.j = r4;
        this.e = ViewModelProviders.of(r4).get(AtFinderViewModel.class);
        this.k = ViewModelProviders.of(r4).get(AtCheckBoxViewModel.class);
        b(r5, r6);
        return this.b;
    }
}
