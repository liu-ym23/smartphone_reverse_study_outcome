package com.bytedance.android.uicomponent.input.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import fm3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/uicomponent/input/view/SingleLineInputView;", "Lcom/bytedance/android/uicomponent/input/view/InputView;", "", "getLayoutID", "", "title", "", "setTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleLineInputView extends InputView {
    public ImageView l;
    public TextView m;
    public View n;
    public FrameLayout o;
    public FrameLayout p;
    public View q;
    public ImageView r;
    public int s;
    public boolean t;
    public boolean u;
    public String v;
    public int w;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SingleLineInputView a;

        public b(SingleLineInputView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.getMOnClearListener();
            this.a.getMEditText().setText(null);
        }
    }

    static {
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public int getLayoutID() {
        return 2131568111;
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void b() {
        if (this.s != 0) goto L9;
        View r0 = this.n;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLine");
    L7:
        r0.setBackgroundColor(getContext().getResources().getColor(2131108358));
        return;
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void c() {
        if (this.s != 0) goto L9;
        View r0 = this.n;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLine");
    L7:
        r0.setBackgroundColor(getContext().getResources().getColor(2131108352));
        return;
    }

    public final void i() {
        if (this.v != null) goto L5;
        return;
    L5:
        TextView r0 = this.m;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
    L8:
        r0.setVisibility(0);
        TextView r1 = this.m;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
    L11:
        r1.setText(this.v);
        if (this.u == false) goto L18;
        ImageView r2 = this.r;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mIsMustFillIv");
    L16:
        r2.setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void e() {
        this.q = findViewById(2131375424);
        this.o = (FrameLayout) findViewById(2131375432);
        this.p = (FrameLayout) findViewById(2131375431);
        if (this.w != 0) goto L5;
        TextView r0 = (TextView) findViewById(2131375435);
    L6:
        this.m = r0;
        if (this.w != 0) goto L9;
        ImageView r1 = (ImageView) findViewById(2131375436);
    L10:
        this.r = r1;
        i();
        ImageView r2 = (ImageView) findViewById(2131375423);
        this.l = r2;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mClearIV");
    L13:
        r2.setOnClickListener(new b(this));
        View r3 = findViewById(2131375429);
        this.n = r3;
        if (this.s != 0) goto L18;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mLine");
    L17:
        r3.setVisibility(0);
        return;
    L18:
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLine");
    L20:
        r3.setVisibility(8);
        View r4 = this.q;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L23:
        r4.setBackground(getContext().getResources().getDrawable(2131256336));
        View r5 = this.q;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L26:
        r5.setPadding((int) e.a(getContext(), 12.0f), (int) e.a(getContext(), 8.0f), (int) e.a(getContext(), 12.0f), (int) e.a(getContext(), 8.0f));
        return;
    L9:
        r1 = (ImageView) findViewById(2131375428);
        goto L10
    L5:
        r0 = (TextView) findViewById(2131375427);
        goto L6
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void a(Editable r3) {
        super.a(r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.toString().length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L10;
    L12:
        h(false);
        return;
    L10:
        if (this.t == false) goto L12;
        h(true);
        return;
    L7:
        r4 = false;
        goto L8
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void d(TypedArray r4) {
        Intrinsics.checkNotNullParameter(r4, "array");
        this.v = r4.getString(7);
        this.s = r4.getInt(3, 0);
        this.t = r4.getBoolean(0, false);
        this.u = r4.getBoolean(4, false);
        r4.getDimension(9, 0.0f);
        this.w = r4.getInt(8, 0);
    }

    public final void h(boolean r2) {
        if (r2 == false) goto L8;
        ImageView r3 = this.l;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mClearIV");
    L7:
        r3.setVisibility(0);
        return;
    L8:
        ImageView r4 = this.l;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mClearIV");
    L11:
        r4.setVisibility(8);
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.v = r2;
        i();
    }

    public SingleLineInputView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        super(r2, r3);
    }
}
