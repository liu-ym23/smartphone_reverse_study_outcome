package com.ss.android.lark.contact.customized.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;

/* JADX INFO: loaded from: classes35.dex */
public final class ContactDbFragmentOfficePrivateContactBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f419030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f419031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContactOfficeTitleBar f419032c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f419030a;
    }

    public ContactDbFragmentOfficePrivateContactBinding(LinearLayout r100, FrameLayout r101, ContactOfficeTitleBar r102) {
        this.f419030a = r100;
        this.f419031b = r101;
        this.f419032c = r102;
    }
}
