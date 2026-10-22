package com.bytedance.android.uicomponent.search;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.uicomponent.input.view.SingleLineInputView;
import fm3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pm3.b;
import pm3.c;
import qm3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/uicomponent/search/SearchView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "listener", "", "setSearchBarOnClickListener", "Lqm3/a;", "setOnCancelListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchView extends FrameLayout {
    public TextView a;
    public SingleLineInputView b;
    public View.OnClickListener c;

    public final void setOnCancelListener(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setSearchBarOnClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    public SearchView(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "attributes");
        super(r5, r6);
        LayoutInflater.from(r5).inflate(2131568117, this, true);
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{R.attr.focusable, R.attr.maxWidth, R.attr.inputType, R.attr.imeOptions, 2130969509, 2130969592, 2130969739, 2130970170, 2130970313, 2130972368, 2130973705, 2130973706, 2130973952, 2130973953, 2130974056, 2130974325, 2130974337, 2130975046});
        boolean r8 = r7.getBoolean(14, false);
        r7.recycle();
        this.b = (SingleLineInputView) findViewById(2131385640);
        ((RelativeLayout) findViewById(2131385639)).setOnClickListener(new pm3.a(this));
        ImageView r9 = new ImageView(getContext());
        int r1 = (int) e.a(getContext(), 18.0f);
        r9.setLayoutParams(new ViewGroup.LayoutParams(r1, r1));
        r9.setPadding(0, 0, (int) e.a(getContext(), 4.0f), 0);
        r9.setImageResource(2131256346);
        SingleLineInputView r2 = this.b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L5:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "view");
        FrameLayout r3 = r2.o;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPreCusContainer");
    L8:
        r3.addView(r9);
        TextView r10 = (TextView) findViewById(2131385638);
        this.a = r10;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mCancelTv");
    L11:
        r10.setOnClickListener(new b(this));
        if (r8 == false) goto L17;
        TextView r11 = this.a;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mCancelTv");
    L16:
        r11.setVisibility(0);
        return;
    L17:
        SingleLineInputView r12 = this.b;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L20:
        EditText r13 = r12.e;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L23:
        r13.setEnabled(false);
        SingleLineInputView r14 = this.b;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L26:
        r14.h(false);
        SingleLineInputView r15 = this.b;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L29:
        r15.getEditText().setMovementMethod(null);
        SingleLineInputView r16 = this.b;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L32:
        r16.getEditText().setKeyListener(null);
        TextView r17 = this.a;
        if (r17 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mCancelTv");
    L35:
        r17.setVisibility(8);
        SingleLineInputView r18 = this.b;
        if (r18 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L38:
        r18.setOnClickListener(new c(this));
    }
}
