package com.ss.android.lark.contact.customized.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public final class ContactDbFragmentOfficeNewContactBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f419023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f419024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LKUIPtrClassicFrameLayout f419025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonRecyclerView f419026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f419027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ContactOfficeEmptyStateView f419028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ContactOfficeTitleBar f419029g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f419023a;
    }

    public ContactDbFragmentOfficeNewContactBinding(LinearLayout r100, LinearLayout r101, LKUIPtrClassicFrameLayout r102, CommonRecyclerView r103, FrameLayout r104, ContactOfficeEmptyStateView r105, ContactOfficeTitleBar r106) {
        this.f419023a = r100;
        this.f419024b = r101;
        this.f419025c = r102;
        this.f419026d = r103;
        this.f419027e = r104;
        this.f419028f = r105;
        this.f419029g = r106;
    }
}
