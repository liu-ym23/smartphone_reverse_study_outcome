package com.ss.android.lark.contact.customized.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public final class ContactDbOfficeContactListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f419080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LKUIRoundedImageView f419081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f419082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f419083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f419084e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f419080a;
    }

    public static ContactDbOfficeContactListItemBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.contact_db_office_contact_list_item, r101, false);
        int r103 = R.id.contact_avatar_iv;
        LKUIRoundedImageView r104 = (LKUIRoundedImageView) ViewBindings.findChildViewById(r102, R.id.contact_avatar_iv);
        if (r104 == null) goto L13;
        r103 = R.id.contact_bio_tv;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, R.id.contact_bio_tv);
        if (r105 == null) goto L13;
        r103 = R.id.contact_content_layout;
        if (((LinearLayout) ViewBindings.findChildViewById(r102, R.id.contact_content_layout)) == null) goto L13;
        LinearLayout r106 = (LinearLayout) r102;
        r103 = R.id.contact_name_tv;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.contact_name_tv);
        if (r107 == null) goto L13;
        return new ContactDbOfficeContactListItemBinding(r106, r104, r105, r106, r107);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public ContactDbOfficeContactListItemBinding(LinearLayout r100, LKUIRoundedImageView r101, TextView r102, LinearLayout r103, TextView r104) {
        this.f419080a = r100;
        this.f419081b = r101;
        this.f419082c = r102;
        this.f419083d = r103;
        this.f419084e = r104;
    }
}
