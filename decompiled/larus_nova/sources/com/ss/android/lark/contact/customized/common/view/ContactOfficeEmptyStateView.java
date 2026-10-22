package com.ss.android.lark.contact.customized.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.ss.android.lark.contact.customized.databinding.ContactDbEmptyStatePageBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/contact/customized/common/view/ContactOfficeEmptyStateView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbEmptyStatePageBinding;", "setEmptyIcon", "", "resId", "setEmptyText", "text", "", "setEmptyActionText", "setOnActionClickListener", "listener", "Landroid/view/View$OnClickListener;", "setHideActionButton", "hide", "", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactOfficeEmptyStateView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContactDbEmptyStatePageBinding f418972a;

    public ContactOfficeEmptyStateView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ContactOfficeEmptyStateView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setEmptyActionText(CharSequence r100) {
        this.f418972a.f419005b.setText(r100);
    }

    public final void setEmptyIcon(int r100) {
        this.f418972a.f419006c.setImageResource(r100);
    }

    public final void setEmptyText(CharSequence r100) {
        this.f418972a.f419007d.setText(r100);
    }

    public final void setHideActionButton(boolean r100) {
        TextView r101 = this.f418972a.f419005b;
        if ((!r100) == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setOnActionClickListener(View.OnClickListener r100) {
        this.f418972a.f419005b.setOnClickListener(r100);
    }

    public ContactOfficeEmptyStateView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.contact_db_empty_state_page, this, false);
        addView(r103);
        int r104 = R.id.empty_state_action;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r103, R.id.empty_state_action);
        if (r105 == null) goto L36;
        r104 = R.id.empty_state_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r103, R.id.empty_state_container)) == null) goto L36;
        r104 = R.id.empty_state_icon;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r103, R.id.empty_state_icon);
        if (r106 == null) goto L36;
        r104 = R.id.empty_state_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r103, R.id.empty_state_text);
        if (r107 == null) goto L36;
        this.f418972a = new ContactDbEmptyStatePageBinding((FrameLayout) r103, r105, r106, r107);
        if (r101 == null) goto L37;
        TypedArray r108 = r100.obtainStyledAttributes(r101, new int[]{R.attr.actionText, R.attr.hideActionButton, R.attr.icon, R.attr.text}, r102, 0);
        int r109 = r108.getResourceId(2, -1);
        if (r109 == (-1)) goto L15;
        r106.setImageResource(r109);
    L15:
        String r110 = r108.getString(3);
        if (r110 != null) goto L18;
    L21:
        boolean r111 = true;
    L22:
        if (r111 == true) goto L24;
        r107.setText(r110);
    L24:
        String r112 = r108.getString(0);
        if (r112 != null) goto L27;
    L30:
        boolean r113 = true;
    L31:
        if (r113 == true) goto L33;
        r105.setText(r112);
    L33:
        setHideActionButton(r108.getBoolean(1, false));
        r108.recycle();
        return;
    L27:
        if (r112.length() == 0) goto L30;
        r113 = false;
        goto L31
    L18:
        if (r110.length() == 0) goto L21;
        r111 = false;
        goto L22
    L37:
        return;
    L36:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ ContactOfficeEmptyStateView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
