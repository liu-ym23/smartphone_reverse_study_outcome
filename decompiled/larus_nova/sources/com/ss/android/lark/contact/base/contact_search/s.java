package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.window.layout.WindowMetricsCalculator;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.dependency.BaseContactThirdBizService;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.entity.mobile.util.ContactMobileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.utils.a1;
import kotlin.Lazy;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes35.dex */
public final class s extends fcc.c<s> {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f418819l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f418820m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f418821n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f418822o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ApiUtils.a<Boolean> f418823p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinearLayout f418824q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public EditText f418825r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f418826s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LinearLayout f418827t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f418828u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public EditText f418829v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f418830w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f418831x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f418832y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f418833z;

    public interface a {
        void a(String r100, boolean r101, boolean r102);
    }

    @Override // fcc.c
    public final int e() {
        return R.layout.inv_invite_external_search_drawer_dialog_nothing;
    }

    public final void l() {
        this.f418830w.setText(this.f418829v.getText());
        this.f418830w.setVisibility(0);
        this.f418829v.setVisibility(8);
        this.f418832y.setEnabled(false);
    }

    @Override // fcc.c
    public final void f() {
        super.f();
    }

    public static void k(final s r100) {
        Activity r101 = ViewUtils.getActivityByContext(r100.f476418a);
        if (r101 == null) goto L7;
        r100.f418833z = true;
        super.f();
        ContactBaseModuleDependency.f418857b.openCountrySelect(r101);
        boolean r102 = a1.f444690f;
        a1.a.f444696a.a(R.id.UiMessageCountryCode, new e(r100));
        return;
    }

    @Override // fcc.c
    public final com.larksuite.component.ui.dialog.d d(com.larksuite.component.ui.dialog.d r100) {
        r100.f(1.0f);
        return r100;
    }

    @Override // fcc.c
    public final void i(LKUIDialog r100) {
        if (r100.getWindow() != null) goto L5;
        return;
    L5:
        RelativeLayout r101 = (RelativeLayout) h(R.id.iesnRootRl);
        LinearLayout r102 = (LinearLayout) h(R.id.iesnContentLl);
        this.f418824q = (LinearLayout) h(R.id.iesnContentMailLl);
        this.f418825r = (EditText) h(R.id.iesnMailToEt);
        this.f418826s = (TextView) h(R.id.iesnMailToErrorTv);
        this.f418827t = (LinearLayout) h(R.id.iesnContentMobileLl);
        this.f418828u = (TextView) h(R.id.iesnCountryCodeTv);
        this.f418829v = (EditText) h(R.id.iesnMobileEt);
        this.f418830w = (TextView) h(R.id.iesnMobileErrorTv);
        this.f418831x = (TextView) h(R.id.iesnContentTv);
        ImageView r103 = (ImageView) h(R.id.iesnSendIv);
        this.f418832y = r103;
        int r104 = 1;
        com.ss.android.lark.utils.q.b(new View[]{r103});
        String r105 = this.f418819l.replace(" ", "");
        if (this.f418822o == false) goto L8;
        this.f418831x.setText(this.f418820m);
        this.f418824q.setVisibility(0);
        this.f418825r.addTextChangedListener(new k(this));
        this.f418825r.setText(this.f418819l);
        this.f418825r.setOnFocusChangeListener(new l(this));
        this.f418825r.post(new m(this));
        this.f418825r.setOnEditorActionListener(new n(this));
        this.f418826s.setOnTouchListener(new o(this));
        this.f418832y.setOnClickListener(new p(this));
    L25:
        this.f476425h = new j(this);
        return;
    L8:
        this.f418831x.setText(this.f418820m);
        TextView r106 = this.f418828u;
        View.OnClickListener r107 = new d(this);
        if (r106 == null) goto L12;
        r106.setOnClickListener(new com.ss.android.lark.inv.export.util.a(r107));
    L12:
        this.f418829v.addTextChangedListener(new q(this));
        this.f418827t.setVisibility(0);
        if (r105.startsWith(Marker.ANY_NON_NULL_MARKER) == false) goto L19;
        int r108 = h9b.d.f484353a;
        Lazy r109 = BaseContactThirdBizService.f418856a;
        if ((!((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand()) == true) goto L18;
        r104 = 86;
    L18:
        Pair<Integer, String> r110 = ContactMobileUtils.e(r104, r105);
        this.f418828u.setText(Marker.ANY_NON_NULL_MARKER + r110.first);
        this.f418829v.setText((CharSequence) r110.second);
    L24:
        this.f418829v.setOnFocusChangeListener(new r(this));
        this.f418829v.post(new f(this));
        this.f418829v.setOnEditorActionListener(new g(this));
        this.f418830w.setOnTouchListener(new h(this));
        this.f418832y.setOnClickListener(new i(this));
        goto L25
    L19:
        TextView r111 = this.f418828u;
        int r112 = h9b.d.f484353a;
        StringBuilder r113 = new StringBuilder(Marker.ANY_NON_NULL_MARKER);
        Lazy r114 = BaseContactThirdBizService.f418856a;
        if ((!((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand()) == true) goto L23;
        r104 = 86;
    L23:
        r113.append(r104);
        r111.setText(r113.toString());
        this.f418829v.setText(h9b.b.a(r105));
        goto L24
    }

    public final void m(Boolean r100) {
        this.f418830w.setVisibility(8);
        this.f418829v.setVisibility(0);
        this.f418832y.setEnabled(r100.booleanValue());
    }

    public s(Context r100, String r101, String r102, a r103, ApiUtils.a<Boolean> r104) {
        boolean r105 = r101.contains("@");
        super(r100);
        this.B = false;
        this.f418819l = r101;
        this.f418820m = r102;
        this.f418821n = r103;
        this.f418823p = r104;
        this.f418822o = r105;
        this.f476427j = true;
        if (Build.VERSION.SDK_INT < 29) goto L10;
        if (r100 == null) goto L10;
        Activity r106 = ViewUtils.getActivityByContext(r100);
        if (r106 == null) goto L10;
        int r107 = WindowMetricsCalculator.CC.getOrCreate().computeCurrentWindowMetrics(r106).getBounds().height();
        Log.i("InviteExternalSearchNothingDrawerDialog", "screenHeight: " + r107);
        if (r107 <= 0) goto L10;
        int r108 = r107 - DeviceUtils.getStatusHeight(r100);
    L11:
        this.f476428k = r108 - UIHelper.dp2px(64.0f);
        return;
    L10:
        r108 = DeviceUtils.getScreenHeight(r100);
        goto L11
    }
}
