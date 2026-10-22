package com.bytedance.ee.bear.middleground.permission.apply;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class p0 implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f233057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseTitleBar f233058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f233059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f233060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f233061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f233062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SpaceEditText f233063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f233064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public n f233065i;

    @Override // com.bytedance.ee.bear.middleground.permission.apply.p
    public final void b() {
        this.f233063g.setText("");
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.p
    public final String getReason() {
        Editable r100 = this.f233063g.getText();
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.p
    public final View getRootView() {
        return this.f233057a;
    }

    public p0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f233057a = r100;
        this.f233058b = (BaseTitleBar) r100.findViewById(R.id.permission_title_bar);
        this.f233059c = (TextView) r100.findViewById(R.id.office_permission_title);
        this.f233060d = (TextView) r100.findViewById(R.id.office_permission_desc);
        this.f233061e = (LinearLayout) r100.findViewById(R.id.permission_type_choose);
        this.f233062f = (TextView) r100.findViewById(R.id.permission_type);
        this.f233063g = (SpaceEditText) r100.findViewById(R.id.edit_optional);
        this.f233064h = (TextView) r100.findViewById(R.id.send_request);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.p
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f233062f.setText(r100);
    }

    public final void d(o r110) {
        Intrinsics.checkNotNullParameter(r110, "state");
        int r100 = 0;
        this.f233058b.setDividerVisible(false);
        this.f233058b.setLeftIconVisibility(r110.f233053g);
        BaseTitleBar r101 = this.f233058b;
        if (r110.f233054h == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        this.f233059c.setText(r110.f233047a);
        TextView r103 = this.f233060d;
        SpannableString r104 = new SpannableString(r110.f233048b);
        String r105 = r104.toString();
        String r111 = r110.f233049c;
        int r106 = StringsKt.indexOf$default(r105, r111, 0, false, 6, null);
        int r107 = r111.length() + r106;
        if (r111.length() != 0) goto L9;
        boolean r108 = true;
    L10:
        if (r108 == true) goto L16;
        if (r106 < 0) goto L16;
        if (r107 > r105.length()) goto L16;
        r104.setSpan(new l0(this), r106, r107, 33);
    L16:
        r103.setText(r104);
        this.f233060d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f233060d.setHighlightColor(0);
        LinearLayout r109 = this.f233061e;
        if (r110.f233050d == true) goto L20;
        r100 = 8;
    L20:
        r109.setVisibility(r100);
        this.f233062f.setText(r110.f233051e);
        this.f233064h.setText(r110.f233052f);
        this.f233064h.setEnabled(true);
        this.f233064h.setBackgroundResource(R.drawable.office_permission_primary_button);
        return;
    L9:
        r108 = false;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final void e(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        ImageView r101 = this.f233058b.getLeftImage();
        if (r101 == null) goto L6;
        r101.setImageDrawable(r100);
        return;
    }

    public final void f(g r100) {
        Intrinsics.checkNotNullParameter(r100, "callbacks");
        this.f233065i = r100;
        this.f233058b.setLeftClickListener(new m0(r100));
        this.f233061e.setOnClickListener(new n0(r100));
        this.f233064h.setOnClickListener(new o0(r100, this));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.p
    public final void a(boolean r100, int r101) {
        this.f233064h.setEnabled(!r100);
        if (r100 == false) goto L5;
        this.f233064h.setText(R.string.LarkCCM_Perm_PermissionRequesting_Mobile);
        this.f233064h.setBackgroundResource(R.drawable.office_permission_primary_button_loading);
        return;
    L5:
        this.f233064h.setText(r101);
        this.f233064h.setBackgroundResource(R.drawable.office_permission_primary_button);
    }
}
