package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.ui.button.LKUIButton;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001b\u001a\u00020\u00172\b\b\u0001\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001dJ\u0010\u0010\u001f\u001a\u00020\u00172\b\b\u0001\u0010!\u001a\u00020\nJ\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001dJ\u000e\u0010'\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/contact/base/common_ui/ContactSimpleItemView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarView", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "nameView", "Landroid/widget/TextView;", "descView", "actionBtn", "Lcom/larksuite/component/ui/button/LKUIButton;", "actionBtnStatus", "splitLine", "Landroid/view/View;", "initViews", "", "avatar", "avatarModel", "Lcom/larksuite/component/ui/avatar/AvatarModel;", "setName", "name", "", "nameResId", "setDesc", "descStr", "descResId", "setActionBtn", "btnStr", "clickListener", "Landroid/view/View$OnClickListener;", "btnResId", "disableActionBtn", "disableBtnStr", "disableResId", "setSplitLine", "enable", "", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactSimpleItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f418538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f418539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f418540c;

    public final void a() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.contact_item_simple, this, false);
        addView(r100);
        int r101 = R.id.action_btn;
        if (((LKUIButton) ViewBindings.findChildViewById(r100, R.id.action_btn)) == null) goto L17;
        r101 = R.id.action_btn_status;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.action_btn_status)) == null) goto L17;
        r101 = R.id.avatar;
        if (((LarkAvatarView) ViewBindings.findChildViewById(r100, R.id.avatar)) == null) goto L17;
        r101 = R.id.desc;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.desc);
        if (r102 == null) goto L17;
        r101 = R.id.name;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.name);
        if (r103 == null) goto L17;
        r101 = R.id.split_line;
        View r104 = ViewBindings.findChildViewById(r100, R.id.split_line);
        if (r104 == null) goto L17;
        ConstraintLayout r105 = (ConstraintLayout) r100;
        this.f418538a = r103;
        this.f418539b = r102;
        this.f418540c = r104;
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public ContactSimpleItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a();
    }

    public final void setDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "descStr");
        TextView r101 = this.f418539b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descView");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        TextView r101 = this.f418538a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nameView");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public final void setSplitLine(boolean r100) {
        View r101 = this.f418540c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("splitLine");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public final void setDesc(int r100) {
        TextView r101 = this.f418539b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descView");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public final void setName(int r100) {
        TextView r101 = this.f418538a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nameView");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public ContactSimpleItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        a();
    }

    public ContactSimpleItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a();
    }
}
