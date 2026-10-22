package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.button.LKUIButton;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.profile.dto.ProfileFinishResult;
import com.ss.android.lark.profile.entity.Profile;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.item.BaseItemAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class b0 implements com.ss.android.lark.contact.base.contact_search.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f418775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.contact.base.contact_search.b.a f418776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintLayout f418777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommonTitleBar f418778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EditText f418779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f418780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f418781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f418782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.ss.android.lark.compose.foundation.toast.g f418783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BaseItemAdapter<v> f418784j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s f418785k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f418786l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RelativeLayout f418787m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f418788n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LKUIButton f418789o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f418790p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final y f418791q;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f418792a;

        public a(b0 r100) {
            this.f418792a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            KeyboardUtils.hideKeyboard(this.f418792a.f418775a.getActivity());
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f418793a;

        @Override // java.lang.Runnable
        public final void run() {
            KeyboardUtils.showKeyboard(this.f418793a.f418779e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(b0 r100) {
            this.f418793a = r100;
        }
    }

    public class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f418794a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public c(b0 r100) {
            this.f418794a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            String r101 = r100.toString().replace(" ", "");
            ImageView r102 = this.f418794a.f418780f;
            if (TextUtils.isEmpty(r101) == false) goto L5;
            int r103 = 8;
        L6:
            r102.setVisibility(r103);
            if (TextUtils.isEmpty(r101) == false) goto L10;
            b0 r104 = this.f418794a;
            boolean r105 = v.f418836h;
            r104.y4(new ArrayList());
            return;
        L10:
            b0 r106 = this.f418794a;
            LinearLayout r107 = r106.f418782h;
            if (r107 == null) goto L14;
            r107.setVisibility(8);
            r106.f418786l.setVisibility(0);
            r106.f418787m.setVisibility(0);
            r106.f418788n.setVisibility(8);
            BaseItemAdapter<v> r108 = r106.f418784j;
            boolean r109 = v.f418836h;
            r108.f448189a = new ArrayList();
            r106.f418784j.notifyDataSetChanged();
        L14:
            b0 r110 = this.f418794a;
            r110.getClass();
            if (r101.contains("@") == false) goto L17;
            r110.f418789o.setText(R.string.Lark_UserGrowth_InvitePeopleContactsSearchShareLinkEmail);
        L18:
            r110.f418790p.setText(r101);
            this.f418794a.getClass();
            return;
        L17:
            r110.f418789o.setText(R.string.Lark_UserGrowth_InvitePeopleContactsSearchShareLinkText);
            goto L18
        L5:
            r103 = 0;
            goto L6
        }
    }

    public class d implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f418795a;

        public d(b0 r100) {
            this.f418795a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 != 3) goto L6;
            b0 r103 = this.f418795a;
            r103.f418776b.x0(r103.f418779e.getText().toString().replace(" ", ""));
            KeyboardUtils.hideKeyboard(this.f418795a.f418775a.getActivity());
            return true;
        L6:
            return false;
        }
    }

    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f418796a;

        public e(b0 r100) {
            this.f418796a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f418796a.f418779e.setText("");
            this.f418796a.f418780f.setVisibility(8);
        }
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void A3() {
        s r100 = this.f418785k;
        if (r100 == null) goto L5;
        r100.g();
    L5:
        this.f418779e.setText("");
        this.f418786l.setVisibility(8);
        KeyboardUtils.showKeyboard(this.f418779e);
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void F2() {
        LinearLayout r100 = this.f418782h;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setVisibility(8);
        this.f418786l.setVisibility(0);
        this.f418787m.setVisibility(8);
        this.f418788n.setVisibility(0);
        if (this.f418779e.getText().toString().contains("@") == false) goto L8;
        this.f418789o.setText(R.string.Lark_UserGrowth_InvitePeopleContactsSearchShareLinkEmail);
        return;
    L8:
        this.f418789o.setText(R.string.Lark_UserGrowth_InvitePeopleContactsSearchShareLinkText);
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void N5() {
        LinearLayout r100 = this.f418782h;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setVisibility(0);
        this.f418786l.setVisibility(8);
        BaseItemAdapter<v> r101 = this.f418784j;
        boolean r102 = v.f418836h;
        r101.f448189a = new ArrayList();
        this.f418784j.notifyDataSetChanged();
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void V1() {
        s r100 = this.f418785k;
        if (r100 == null) goto L6;
        r100.l();
        return;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f418777c = (ConstraintLayout) this.f418775a.a(R.id.ipsRootCl);
        this.f418778d = (CommonTitleBar) this.f418775a.a(R.id.ipsTitleBar);
        this.f418779e = (EditText) this.f418775a.a(R.id.ipsSearchEt);
        this.f418780f = (ImageView) this.f418775a.a(R.id.ipsSearchClearIv);
        RelativeLayout r100 = (RelativeLayout) this.f418775a.a(R.id.ipsSearchRl);
        this.f418781g = (RecyclerView) this.f418775a.a(R.id.ipSearchResultRv);
        this.f418782h = (LinearLayout) this.f418775a.a(R.id.ipslRootLl);
        this.f418786l = (FrameLayout) this.f418775a.a(R.id.ipseRootFl);
        this.f418787m = (RelativeLayout) this.f418775a.a(R.id.ipseSearchRl);
        TextView r101 = (TextView) this.f418775a.a(R.id.ipseNoResultsTv);
        this.f418788n = (LinearLayout) this.f418775a.a(R.id.ipseInviteFl);
        this.f418789o = (LKUIButton) this.f418775a.a(R.id.ipseInviteBtn);
        this.f418790p = (TextView) this.f418775a.a(R.id.ipseSearchContentTv);
        this.f418777c.setOnClickListener(new a(this));
        this.f418779e.post(new b(this));
        this.f418779e.addTextChangedListener(new c(this));
        this.f418779e.setOnEditorActionListener(new d(this));
        this.f418778d.setImmersive(true);
        this.f418778d.setLeftClickListener(new x(this));
        if (ContactBaseModuleDependency.f418857b.isSmallB() == false) goto L5;
        this.f418778d.setTitle(R.string.Lark_NewContacts_AddContactsb);
    L6:
        int r102 = 0;
        com.ss.android.lark.utils.q.b(new View[]{this.f418780f});
        this.f418780f.setOnClickListener(new e(this));
        BaseItemAdapter<v> r103 = new BaseItemAdapter();
        this.f418784j = r103;
        boolean r104 = v.f418836h;
        r103.f448189a = new ArrayList();
        this.f418781g.setAdapter(this.f418784j);
        this.f418781g.setLayoutManager(new LinearLayoutManager(this.f418775a.getActivity()));
        this.f418786l.setOnClickListener(new c0(this));
        com.ss.android.lark.utils.q.a(this.f418787m);
        this.f418787m.setOnClickListener(new d0(this));
        this.f418789o.setOnClickListener(new e0(this));
        HashMap r105 = new HashMap();
        r105.put("APP_DISPLAY_NAME", UIHelper.getAppName());
        String r106 = UIHelper.mustacheFormat(R.string.Lark_UserGrowth_InvitePeopleSearchPrivacyTip, r105);
        f0 r107 = new f0(this);
        char[] r108 = r106.toCharArray();
        StringBuilder r109 = new StringBuilder();
        int r110 = r108.length;
        int r111 = 0;
        int r112 = 0;
    L7:
        if (r102 >= r110) goto L16;
        char r113 = r108[r102];
        if (r113 != '{') goto L12;
        r111 = r109.length();
    L15:
        r102 = r102 + 1;
        goto L7
    L12:
        if (r113 != '}') goto L14;
        r112 = r109.length();
        goto L15
    L14:
        r109.append(r113);
        goto L15
    L16:
        new SpannableString(r109.toString()).setSpan(r107, r111, r112, 33);
        return;
    L5:
        this.f418778d.setTitle(R.string.Lark_NewContacts_AddExternalContactsB);
        goto L6
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public Activity getActivity() {
        return this.f418775a.getActivity();
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void i0() {
        LinearLayout r100 = this.f418782h;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeCallbacks(this.f418791q);
        if (this.f418783i != null) goto L8;
        this.f418783i = x08.a.a(getActivity(), R.string.Lark_Legacy_InLoading);
    L8:
        this.f418783i.show();
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void l2() {
        if (this.f418783i != null) goto L5;
        return;
    L5:
        LinearLayout r100 = this.f418782h;
        if (r100 != null) goto L8;
        return;
    L8:
        r100.postDelayed(this.f418791q, 200);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.android.lark.contact.base.contact_search.y] */
    public b0(g0 r100) {
        this.f418791q = new y(this);
        this.f418775a = r100;
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void M0(String r100) {
        String r101 = this.f418779e.getText().toString();
        s r102 = new s(this.f418775a.getActivity(), r101, r100, new z(this, r101), new a0());
        r102.j();
        this.f418785k = r102;
        Statistics.sendEvent("invite_people_external_search_nomatch_search", InvHitPoint.b(null));
        Statistics.sendEvent("invite_people_external_search_invite_view", InvHitPoint.b(null));
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void O5(ProfileFinishResult r100) {
        BaseItemAdapter<v> r101 = this.f418784j;
        if (r101 == null) goto L22;
        Iterator r102 = r101.f448189a.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        v r103 = (v) r102.next();
        String r104 = r100.userId;
        Profile r105 = r103.f418837e;
        if (r105 != null) goto L10;
        boolean r106 = false;
    L11:
        if (r106 == false) goto L6;
        int r107 = r103.f418839g;
        r103.f418837e.setIsFriend(r100.isFriend);
        r103.f418837e.setIsRequestUserApplied(r100.isRequestUserApplied);
        r103.f418837e.setIsTargetUserApplied(r100.isTargetUserApplied);
    L14:
        if (r107 == (-1)) goto L23;
        this.f418784j.notifyItemChanged(r107);
        return;
    L23:
        return;
    L10:
        r106 = TextUtils.equals(r104, r105.getId());
        goto L11
    L13:
        r107 = -1;
        goto L14
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f418776b = (com.ss.android.lark.contact.base.contact_search.b.a) r100;
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void showToast(String r100) {
        LKUIToast.show(this.f418775a.getActivity(), r100);
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void v8(String r100) {
        if (this.f418781g.getItemDecorationCount() < 1) goto L5;
        this.f418781g.removeItemDecorationAt(0);
    L5:
        this.f418781g.addItemDecoration(new InviteExternalSearchDescoration(getActivity(), r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void y4(List<? extends bec.a> r100) {
        LinearLayout r101 = this.f418782h;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisibility(8);
        this.f418786l.setVisibility(8);
        BaseItemAdapter<v> r102 = this.f418784j;
        r102.f448189a = r100;
        r102.notifyDataSetChanged();
    }
}
