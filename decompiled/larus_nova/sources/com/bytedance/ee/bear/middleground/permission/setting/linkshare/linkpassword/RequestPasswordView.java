package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import ii5.i;
import ii5.j;

/* JADX INFO: loaded from: classes18.dex */
public class RequestPasswordView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f234165f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f234166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SpaceEmptyState f234167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpaceEditText f234168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f234169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f234170e;

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RequestPasswordView f234171a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(RequestPasswordView r100) {
            this.f234171a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (TextUtils.isEmpty(r100.toString()) == true) goto L5;
            RequestPasswordView r101 = this.f234171a;
            r101.f234169d.setBackgroundResource(r101.getConfirmEnabledBgRes());
            this.f234171a.f234169d.setEnabled(true);
            return;
        L5:
            RequestPasswordView r102 = this.f234171a;
            r102.f234169d.setBackgroundResource(r102.getConfirmDisabledBgRes());
            this.f234171a.f234169d.setEnabled(false);
        }
    }

    public interface b {
        void a(String r100);
    }

    public int getConfirmDisabledBgRes() {
        return R.drawable.password_view_encrypt_confirm_disable;
    }

    public int getConfirmEnabledBgRes() {
        return R.drawable.password_view_encrypt_confirm;
    }

    public int getContentLayoutRes() {
        return R.layout.request_password_layout;
    }

    public final void b() {
        if (this.f234170e != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f234168c.getText().toString()) == false) goto L7;
        return;
    L7:
        if (com.bytedance.ee.util.ui.h.a(500) == false) goto L12;
        this.f234170e.a(this.f234168c.getText().toString());
        return;
    }

    public void c() {
        this.f234168c.v();
    }

    public final void d() {
        this.f234166a.setPadding(0, 0, 0, 0);
        this.f234166a.setGravity(17);
        this.f234167b.setImageSizeResource(R.dimen.ccm_emptystate_image_size_small);
        this.f234167b.getImageView().requestLayout();
        this.f234167b.setImageBottomMargin(n.d(4));
        this.f234167b.setTitleTextAppearance(R.style.UDText_Caption1);
        setEmptyStateBottomMargin(n.d(4));
        setEditTextBottomMargin(n.d(0));
        this.f234169d.setVisibility(8);
    }

    public final void e() {
        this.f234166a.setPadding(0, n.d(75), 0, 0);
        this.f234166a.setGravity(48);
        this.f234167b.setImageSizeResource(R.dimen.ccm_emptystate_image_size_middle);
        this.f234167b.getImageView().requestLayout();
        this.f234167b.setImageBottomMargin(n.d(12));
        this.f234167b.setTitleTextAppearance(R.style.UDText_Headline);
        setEmptyStateBottomMargin(n.d(20));
        setEditTextBottomMargin(n.d(12));
        this.f234169d.setVisibility(0);
    }

    public RequestPasswordView(Context r100) {
        super(r100);
        a(r100);
    }

    private void setEmptyStateBottomMargin(int r100) {
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) this.f234167b.getLayoutParams();
        r101.bottomMargin = r100;
        this.f234167b.setLayoutParams(r101);
    }

    public final void a(Context r100) {
        View.inflate(r100, getContentLayoutRes(), this);
        this.f234166a = (LinearLayout) findViewById(R.id.password_encrypt_container);
        this.f234167b = (SpaceEmptyState) findViewById(R.id.password_empty_state);
        this.f234168c = (SpaceEditText) findViewById(R.id.password_locked_edit_password);
        this.f234169d = (TextView) findViewById(R.id.btn_confirm_password);
        this.f234168c.setOnEditorActionListener(new i(this));
        this.f234169d.setOnClickListener(new j(this));
        this.f234168c.addTextChangedListener(new a(this));
    }

    public void setConfirmBtnVisibility(int r100) {
        this.f234169d.setVisibility(r100);
    }

    public void setEditTextBottomMargin(int r100) {
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) this.f234168c.getLayoutParams();
        r101.bottomMargin = r100;
        this.f234168c.setLayoutParams(r101);
    }

    public void setEditTextHint(int r100) {
        this.f234168c.setHint(r100);
    }

    public void setInputVisibility(int r100) {
        this.f234168c.setVisibility(r100);
    }

    public void setOnInputPasswordListener(b r100) {
        this.f234170e = r100;
    }

    public void setTips(int r100) {
        this.f234167b.setTitle(getContext().getString(r100));
    }

    public void setTips(String r100) {
        this.f234167b.setTitle(r100);
    }

    public RequestPasswordView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }
}
