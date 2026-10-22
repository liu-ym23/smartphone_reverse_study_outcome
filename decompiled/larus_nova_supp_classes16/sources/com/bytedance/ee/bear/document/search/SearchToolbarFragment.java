package com.bytedance.ee.bear.document.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginInfoExtractException;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.g7;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.v;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.util.ui.n;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SearchToolbarFragment extends BaseFragment implements ocb.a, View.OnClickListener, com.bytedance.ee.bear.l {
    public static final /* synthetic */ int s = 0;
    public View e;
    public View f;
    public View g;
    public SpaceEditText h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public ImageView l;
    public b m;
    public SearchViewModel n;
    public final v o;
    public y3 p;
    public final a q;
    public boolean r;

    public class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ SearchToolbarFragment a;

        public a(SearchToolbarFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            SearchToolbarFragment r10 = this.a;
            int r11 = SearchToolbarFragment.s;
            r10.X90();
        }
    }

    public class b implements TextWatcher {
        public final /* synthetic */ SearchToolbarFragment a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(SearchToolbarFragment r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r3) {
            this.a.n.search(r3.toString(), false);
        }
    }

    public boolean Z90() {
        return true;
    }

    public final String V90() {
        y3 r0 = this.p;
        if (r0 != null) goto L7;
        return sbb.e.e.getType();
    L7:
        return r0.getBearUrl().a;
    }

    public final void X90() {
        View r0 = this.g;
        if (r0 != null) goto L5;
    L13:
        Y90(0);
        return;
    L5:
        if (r0.getVisibility() != 0) goto L13;
        int r1 = this.g.getHeight();
        if (r1 > 0) goto L10;
        r1 = this.g.getMeasuredHeight();
    L10:
        if (r1 <= 0) goto L15;
        Y90(n.E(r1));
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        this.n.setActive(false);
        return true;
    }

    public final void onDestroyView() {
        this.h.removeTextChangedListener(this.m);
        View r0 = this.f;
        if (r0 == null) goto L6;
        r0.removeOnLayoutChangeListener(this.q);
    L6:
        if (this.n.shouldCloseKeyboardOnDestroy() == false) goto L8;
        U90();
    L8:
        this.n.clearSearchResult();
        this.n.getTotal().setValue(-1);
        this.h.setOnFocusChangeListener(null);
        super.onDestroyView();
    }

    public SearchToolbarFragment() {
        this.o = new v();
        this.q = new a(this);
        this.r = false;
    }

    public final void U90() {
        if (getActivity() != null) goto L5;
    L13:
        tt5.a.h("SearchToolbarFragment", "closeKeyBoardIfNeed skip, activity or view is null");
        return;
    L5:
        if (isAdded() == false) goto L13;
        if (this.h == null) goto L13;
        if (pcb.a.a.b(getActivity()).getVisibleKeyboardHeight() <= 0) goto L15;
        rcb.c.d(this.h);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        if (getActivity() != null) goto L5;
    L7:
        super.onDestroy();
        return;
    L5:
        if (getActivity().getSupportFragmentManager().isDestroyed() == true) goto L7;
        pcb.a r0 = pcb.a.a.b(getActivity());
        r0.a(this);
        r0.a(this.n);
        goto L7
    }

    public Class<? extends SearchViewModel> W90() {
        return SearchViewModel.class;
    }

    public final void Y90(int r6) {
        tt5.a.h("SearchToolbarFragment", "notifySearchShow: height:" + r6);     // Catch: Throwable -> L12
        g7 r1 = (g7) PluginHost.fromFragment(this).getHostAbilityOrNull(g7.class);     // Catch: Throwable -> L12
        if (r1 != null) goto L6;
        vv4.k r2 = null;
    L7:
        if (r2 != null) goto L10;
        tt5.a.k("SearchToolbarFragment", "notifySearchShow: web is null");     // Catch: Throwable -> L12
        return;
    L10:
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L12
        r3.put("height", r6);     // Catch: Throwable -> L12
        r2.l("javascript:window.lark.biz.content.searchShow", r3, null);     // Catch: Throwable -> L12
        return;
    L6:
        r2 = r1.getWeb();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        tt5.a.e("SearchToolbarFragment", "notifySearchShow error", th, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        String r2 = "";
        if (r6.getId() != 2131385374) goto L6;
        this.n.setActive(false);
        r2 = "click_finish_find";
        String r7 = "";
    L25:
        HashMap r0 = new HashMap();
        r0.put("click", r2);
        r0.put("target", "none");
        r0.put("sub_click", r7);
        if (sbb.e.o.getType().equals(V90()) == false) goto L29;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).n("ccm_doc_find_replace_panel_click", r0);
        return;
    L29:
        return;
    L6:
        if (r6.getId() != 2131385558) goto L16;
        Integer r8 = (Integer) this.n.getCurrentIndex().getValue();
        Integer r1 = (Integer) this.n.getTotal().getValue();
        if (r8 == null) goto L13;
        if (r1 == null) goto L13;
        if (r1.intValue() <= 0) goto L13;
        Integer r9 = Integer.valueOf(((r8.intValue() + r1.intValue()) - 1) % r1.intValue());
        this.n.switchResult(r9.intValue());
        this.n.getCurrentIndex().setValue(r9);
    L13:
        U90();
        String r3 = "previous";
    L14:
        r7 = r3;
        r2 = "click_scroll_result";
        goto L25
    L16:
        if (r6.getId() != 2131385545) goto L24;
        Integer r10 = (Integer) this.n.getCurrentIndex().getValue();
        Integer r4 = (Integer) this.n.getTotal().getValue();
        if (r10 == null) goto L23;
        if (r4 == null) goto L23;
        if (r4.intValue() <= 0) goto L23;
        Integer r11 = Integer.valueOf(Integer.valueOf(r10.intValue() + 1).intValue() % r4.intValue());
        this.n.switchResult(r11.intValue());
        this.n.getCurrentIndex().setValue(r11);
    L23:
        U90();
        r3 = "next";
        goto L14
    L24:
        r7 = "";
        goto L25
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.m = new b(this);
        if (getActivity() == null) goto L13;
        this.n = (SearchViewModel) q.a(this, W90());
        this.p = (y3) PluginHost.fromFragment(this).getHostAbilityOrNull(y3.class);     // Catch: PluginInfoExtractException -> L7
    L9:
        pcb.a r5 = pcb.a.a.b(getActivity());
        r5.c(this.n);
        r5.c(this);
        return;
    L7:
        e = move-exception;
        tt5.a.e("SearchToolbarFragment", "analyticUrl, e: ", e, false);
        goto L9
    }

    public final void aa0(int r6, int r7) {
        if (r7 <= (-1)) goto L10;
        TextView r0 = this.i;
        Locale r1 = Locale.US;
        Object[] r2 = new Object[2];
        if (r7 <= 0) goto L7;
        int r8 = r6 + 1;
    L8:
        r2[0] = Integer.valueOf(r8);
        r2[1] = this.n.getTotal().getValue();
        r0.setText(String.format(r1, "%d/%d", r2));
        return;
    L7:
        r8 = 0;
        goto L8
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public void onViewCreated(View r12, Bundle r13) {
        this.e = r12.findViewById(2131369356);
        this.f = r12.findViewById(2131369352);
        this.g = r12.findViewById(2131369355);
        this.h = r12.findViewById(2131385429);
        this.i = (TextView) r12.findViewById(2131385364);
        this.j = (TextView) r12.findViewById(2131385374);
        this.k = (ImageView) r12.findViewById(2131385558);
        this.l = (ImageView) r12.findViewById(2131385545);
        this.n.getCurrentIndex().observe(this, new e(this));
        this.n.getTotal().observe(this, new f(this));
        this.h.setFilterMenuWhiteList(new g());
        this.h.addTextChangedListener(this.m);
        this.h.setOnEditorActionListener(new h(this));
        this.h.setOnFocusChangeListener(new i(this));
        if (this.p == null) goto L12;
        String r14 = V90();
        if (TextUtils.equals(r14, sbb.e.h.getType()) == false) goto L9;
        this.h.setHint(2131887823);
        this.j.setText(2131887682);
        goto L12
    L9:
        if (TextUtils.equals(r14, sbb.e.i.getType()) == false) goto L11;
        this.h.setHint(2131886814);
        this.j.setText(2131886350);
        goto L12
    L11:
        this.h.setHint(2131887822);
        this.j.setText(2131887682);
    L12:
        this.k.setEnabled(false);
        this.l.setEnabled(false);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.f.addOnLayoutChangeListener(this.q);
        this.f.post(new j(this));
        if (Z90() == false) goto L15;
        this.h.postDelayed(new k(this), 200);
    L15:
        this.e.setVisibility(0);
        TranslateAnimation r16 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        r16.setDuration(200);
        this.e.startAnimation(r16);
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L19;
        this.o.b(r17, new l(this));
        return;
    }

    public final Animation onCreateAnimation(int r10, boolean r11, int r12) {
        if (r11 == true) goto L6;
        this.f.setVisibility(8);
        Y90(0);
        TranslateAnimation r13 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        r13.setDuration(500);
        return r13;
    L6:
        return super.onCreateAnimation(r10, r11, r12);
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        String r6 = V90();
        if (sbb.e.o.getType().equals(r6) == false) goto L6;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).i("ccm_doc_find_replace_panel_view", new JSONObject());
    L6:
        return r3.inflate(2131560095, r4, false);
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        if (this.r == true) goto L8;
        View r4 = getView();
        if (r4 == null) goto L8;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        r5.bottomMargin = r2;
        r4.setLayoutParams(r5);
    L8:
        if (r2 != 0) goto L11;
        this.h.clearFocus();
        return;
    }
}
