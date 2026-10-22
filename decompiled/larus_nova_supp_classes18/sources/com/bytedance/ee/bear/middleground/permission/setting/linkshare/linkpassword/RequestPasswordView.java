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
import ii5.i;
import ii5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RequestPasswordView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public LinearLayout a;
    public SpaceEmptyState b;
    public SpaceEditText c;
    public TextView d;
    public b e;

    public class a implements TextWatcher {
        public final /* synthetic */ RequestPasswordView a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(RequestPasswordView r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            if (TextUtils.isEmpty(r2.toString()) == true) goto L5;
            RequestPasswordView r3 = this.a;
            r3.d.setBackgroundResource(r3.getConfirmEnabledBgRes());
            this.a.d.setEnabled(true);
            return;
        L5:
            RequestPasswordView r4 = this.a;
            r4.d.setBackgroundResource(r4.getConfirmDisabledBgRes());
            this.a.d.setEnabled(false);
        }
    }

    public interface b {
        void a(String r1);
    }

    public int getConfirmDisabledBgRes() {
        return 2131247181;
    }

    public int getConfirmEnabledBgRes() {
        return 2131247180;
    }

    public int getContentLayoutRes() {
        return 2131564284;
    }

    public final void b() {
        if (this.e != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.c.getText().toString()) == false) goto L7;
        return;
    L7:
        if (com.bytedance.ee.util.ui.h.a(500) == false) goto L12;
        this.e.a(this.c.getText().toString());
        return;
    }

    public void c() {
        this.c.v();
    }

    public final void d() {
        this.a.setPadding(0, 0, 0, 0);
        this.a.setGravity(17);
        this.b.setImageSizeResource(2131165487);
        this.b.getImageView().requestLayout();
        this.b.setImageBottomMargin(n.d(4));
        this.b.setTitleTextAppearance(2131953912);
        setEmptyStateBottomMargin(n.d(4));
        setEditTextBottomMargin(n.d(0));
        this.d.setVisibility(8);
    }

    public final void e() {
        this.a.setPadding(0, n.d(75), 0, 0);
        this.a.setGravity(48);
        this.b.setImageSizeResource(2131165486);
        this.b.getImageView().requestLayout();
        this.b.setImageBottomMargin(n.d(12));
        this.b.setTitleTextAppearance(2131953915);
        setEmptyStateBottomMargin(n.d(20));
        setEditTextBottomMargin(n.d(12));
        this.d.setVisibility(0);
    }

    public RequestPasswordView(Context r1) {
        super(r1);
        a(r1);
    }

    private void setEmptyStateBottomMargin(int r2) {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        r0.bottomMargin = r2;
        this.b.setLayoutParams(r0);
    }

    public final void a(Context r2) {
        View.inflate(r2, getContentLayoutRes(), this);
        this.a = (LinearLayout) findViewById(2131381965);
        this.b = (SpaceEmptyState) findViewById(2131381964);
        this.c = (SpaceEditText) findViewById(2131381966);
        this.d = (TextView) findViewById(2131364690);
        this.c.setOnEditorActionListener(new i(this));
        this.d.setOnClickListener(new j(this));
        this.c.addTextChangedListener(new a(this));
    }

    public void setConfirmBtnVisibility(int r2) {
        this.d.setVisibility(r2);
    }

    public void setEditTextBottomMargin(int r2) {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        r0.bottomMargin = r2;
        this.c.setLayoutParams(r0);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setEditTextHint(int r2) {
        this.c.setHint(r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setInputVisibility(int r2) {
        this.c.setVisibility(r2);
    }

    public void setOnInputPasswordListener(b r1) {
        this.e = r1;
    }

    public void setTips(int r3) {
        this.b.setTitle(getContext().getString(r3));
    }

    public void setTips(String r2) {
        this.b.setTitle(r2);
    }

    public RequestPasswordView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }
}
