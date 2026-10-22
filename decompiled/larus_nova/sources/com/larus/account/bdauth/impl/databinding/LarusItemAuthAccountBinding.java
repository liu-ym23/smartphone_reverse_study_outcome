package com.larus.account.bdauth.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusItemAuthAccountBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f286220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundAvatarImageView f286221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f286222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f286223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f286224e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f286220a;
    }

    public static LarusItemAuthAccountBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_auth_account, r101, false);
        int r103 = R.id.item_account_avatar;
        RoundAvatarImageView r104 = (RoundAvatarImageView) ViewBindings.findChildViewById(r102, R.id.item_account_avatar);
        if (r104 == null) goto L13;
        r103 = R.id.item_account_checkbox;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r102, R.id.item_account_checkbox);
        if (r105 == null) goto L13;
        ConstraintLayout r106 = (ConstraintLayout) r102;
        r103 = R.id.item_account_sub_title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.item_account_sub_title);
        if (r107 == null) goto L13;
        r103 = R.id.item_account_title;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r102, R.id.item_account_title);
        if (r108 == null) goto L13;
        return new LarusItemAuthAccountBinding(r106, r104, r105, r107, r108);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusItemAuthAccountBinding(ConstraintLayout r100, RoundAvatarImageView r101, ImageView r102, TextView r103, TextView r104) {
        this.f286220a = r100;
        this.f286221b = r101;
        this.f286222c = r102;
        this.f286223d = r103;
        this.f286224e = r104;
    }
}
