package com.bytedance.ee.bear.middleground.permission.apply;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NoPermissionFragment extends BaseFragment {
    public static final /* synthetic */ int D = 0;
    public String A;
    public String B;
    public String C;
    public int e;
    public TextView f;
    public TextView g;
    public SpaceEditText h;
    public BaseTitleBar i;
    public boolean j;
    public View k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public String p;
    public v q;
    public Disposable r;
    public String s;
    public String t;
    public int u;
    public SpaceEmptyState v;
    public boolean w;
    public String x;
    public boolean y;
    public boolean z;

    public class a implements View.OnClickListener {
        public final /* synthetic */ NoPermissionFragment a;

        public a(NoPermissionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r21) {
            NoPermissionFragment r1 = this.a;
            if (r1.j == false) goto L5;
            com.bytedance.ee.bear.middleground.permission.c.h(r1.l, sbb.e.g(r1.m), r1.x, r1.y, r1.z, r1.A, r1.B, r1.C, "apply_permission");
        L6:
            FragmentActivity r2 = r1.getActivity();
            if (r2 == null) goto L10;
            r2.finish();
            return;
        L10:
            return;
        L5:
            com.bytedance.ee.bear.middleground.permission.c.D(r1.l, sbb.e.g(r1.m), r1.x, r1.y, r1.z, r1.A, r1.B, r1.C);
            goto L6
        }
    }

    public final Spanned V90() {
        AccountService.Account r0 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2();
        if (r0 != null) goto L6;
        tt5.a.d("NoPermissionDialogFragment", "getOwnerText()...account is null");
        return null;
    L6:
        String r1 = ou5.a.d(((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a(), r0.displayName, r0.cnName, r0.enName);
        if (r0.isConsumer() == false) goto L9;
        String r2 = getString(2131888107);
    L11:
        return Html.fromHtml(xo5.a.c(getContext(), 2131888083, "user", b0.a(r2 + "-" + r1)));
    L9:
        r2 = r0.tenantName;
        goto L11
    }

    public final void X90() {
        BaseTitleBar r0 = (BaseTitleBar) this.k.findViewById(2131382173);
        this.i = r0;
        r0.setLeftIconVisibility(this.o);
        this.i.setLeftClickListener(new a(this));
        if (TextUtils.isEmpty(this.t) == true) goto L5;
    L9:
        this.i.setTitle(this.t);
        return;
    L5:
        if (this.n == false) goto L7;
        String r1 = getResources().getString(2131887732);
    L8:
        this.t = r1;
        goto L9
    L7:
        r1 = getResources().getString(2131887735);
        goto L8
    }

    public NoPermissionFragment() {
        this.e = 1;
        this.l = "";
        this.o = true;
        this.x = "";
        this.y = false;
        this.z = false;
        this.A = "";
        this.B = "";
        this.C = "";
    }

    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.r;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        this.r.dispose();
        return;
    }

    static {
    }

    public final int U90(boolean r4) {
        int r0 = getContext().getResources().getColor(2131105548);
        int r1 = getContext().getResources().getColor(2131106622);
        if (r4 == false) goto L6;
        return r0;
    L6:
        return r1;
    }

    public final void W90(boolean r3) {
        if (getContext() != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        Toast.showLoading(getContext(), getContext().getString(2131887769));
        return;
    L7:
        Toast.cancelLoading();
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Bundle r6 = getArguments();
        if (r6 == null) goto L5;
        this.j = r6.getBoolean("CAN_APPLY");
        this.l = r6.getString("TOKEN", "");
        this.m = r6.getString("DOCUMENT_TYPE", "");
        this.p = r6.getString("OWNER_NAME", "");
        this.s = r6.getString("TIP_TEXT", "");
        this.t = r6.getString("TITLE", "");
        this.u = r6.getInt("SUB_TITLE_ID", -1);
        this.n = r6.getBoolean("IS_FOLDER");
        this.o = r6.getBoolean("SHOW_BACK", true);
        this.x = r6.getString("SUB_TYPE", "");
        this.y = r6.getBoolean("FROM_VC", false);
        this.z = r6.getBoolean("IS_WIKI", false);
        this.A = r6.getString("MODULE", "");
        this.B = r6.getString("USER_PERM", "");
        this.C = r6.getString("PUBLIC_PERM", "");
        this.w = r6.getBoolean("IS_SHARE_FOLDER_V2", false);
    L5:
        this.q = new v((NetService) org.koin.java.a.a(NetService.class), this.l, this.m, this.w);
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        if (this.j == false) goto L14;
        View r16 = r13.inflate(2131563712, r14, false);
        this.k = r16;
        this.f = (TextView) r16.findViewById(2131382177);
        this.g = (TextView) this.k.findViewById(2131385928);
        this.h = (SpaceEditText) this.k.findViewById(2131371423);
        this.v = (SpaceEmptyState) this.k.findViewById(2131371597);
        Drawable r17 = getResources().getDrawable(2131236155);
        r17.setBounds(0, 0, r17.getMinimumWidth(), r17.getMinimumHeight());
        TextView r18 = this.f;
        if (this.n == false) goto L7;
        r17 = null;
    L7:
        r18.setCompoundDrawables(null, null, r17, null);
        this.v.setDesc(xo5.a.c(getContext(), 2131888024, "owner", this.p));
        X90();
        TextView r19 = this.f;
        if (this.n == true) goto L10;
    L12:
        String r110 = getResources().getString(2131887806);
    L13:
        r19.setText(r110);
        this.f.setOnClickListener(new d0(this));
        this.g.setOnClickListener(new e0(this));
        com.bytedance.ee.bear.middleground.permission.c.z(this.l, sbb.e.g(this.m), this.x, this.y, this.z, this.A, this.B, this.C, "apply_permission");
    L26:
        this.v.setTitle(this.s);
        float r111 = (getResources().getDimension(2131169381) * 2.0f) + getResources().getDimension(2131168379);
        ViewGroup.LayoutParams r112 = this.v.getLayoutParams();
        r112.width = (int) r111;
        this.v.setLayoutParams(r112);
        return this.k;
    L10:
        if (this.w == true) goto L12;
        r110 = getResources().getString(2131887773);
        goto L13
    L14:
        View r113 = r13.inflate(2131561151, r14, false);
        this.k = r113;
        this.v = (SpaceEmptyState) r113.findViewById(2131371597);
        if (TextUtils.isEmpty(V90()) == true) goto L18;
        this.v.setDesc(V90());
    L18:
        if (this.u == (-1)) goto L24;
        this.v.setDesc(getContext().getText(this.u));
        this.v.showDescription(true);
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) this.v.getLayoutParams();
        if (r114 != null) goto L22;
    L25:
        X90();
        com.bytedance.ee.bear.middleground.permission.c.X(this.l, sbb.e.g(this.m), this.x, this.y, this.z, this.A, this.B, this.C);
        goto L26
    L22:
        if (getResources() == null) goto L25;
        r114.width = cu5.c.a((getResources().getDimension(2131169381) * 2.0f) + getResources().getDimension(2131168381));
        this.v.setLayoutParams(r114);
        goto L25
    L24:
        this.v.showDescription(false);
        goto L25
    }
}
