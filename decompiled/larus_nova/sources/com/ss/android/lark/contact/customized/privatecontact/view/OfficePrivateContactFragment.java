package com.ss.android.lark.contact.customized.privatecontact.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficePrivateContactBinding;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n9b.b;
import n9b.c;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/contact/customized/privatecontact/view/OfficePrivateContactFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "binding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbFragmentOfficePrivateContactBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initTitleBar", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficePrivateContactFragment extends BaseFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f419399e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContactDbFragmentOfficePrivateContactBinding f419400d;

    public static final class a {
    }

    static {
    }

    public OfficePrivateContactFragment() {
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ContactDbFragmentOfficePrivateContactBinding r102 = this.f419400d;
        ContactDbFragmentOfficePrivateContactBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L5:
        r102.f419032c.setLeftIconClickListener(new n9b.a(this));
        ContactDbFragmentOfficePrivateContactBinding r104 = this.f419400d;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L8:
        r104.f419032c.setRightIconClickListener(new b(this));
        ContactDbFragmentOfficePrivateContactBinding r105 = this.f419400d;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        ContactOfficeTitleBar r106 = r103.f419032c;
        c r107 = new c(this);
        r106.getClass();
        FrameLayout r108 = new FrameLayout(r106.getContext());
        r108.setLayoutParams(new LinearLayout.LayoutParams(r106.a(44), r106.a(44)));
        r108.setClickable(true);
        r108.setFocusable(true);
        r108.setOnClickListener(new j9b.a(r107));
        ImageView r109 = new ImageView(r106.getContext());
        r109.setLayoutParams(new FrameLayout.LayoutParams(r106.a(24), r106.a(24), 17));
        r109.setImageResource(R.drawable.contact_db_icon_search);
        r108.addView(r109);
        r106.f418977c.addView(r108);
        if (getChildFragmentManager().findFragmentByTag("Contact_ExtContactFrag") != null) goto L20;
        int r110 = OfficeExternalContactFragment.f419163r;
        OfficeExternalContactFragment r111 = OfficeExternalContactFragment.a.a(true, false, "");
        FragmentTransaction r112 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r112, r111, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "Contact_ExtContactFrag", R.id.private_contact_container) == true) goto L18;
        r112.add(R.id.private_contact_container, r111, "Contact_ExtContactFrag");
    L18:
        r112.commitNow();
        return;
    L20:
        return;
    L11:
        r103 = r105;
        goto L12
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.contact_db_fragment_office_private_contact, r101, false);
        int r104 = R.id.private_contact_container;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.private_contact_container);
        if (r105 == null) goto L9;
        r104 = R.id.title_bar;
        ContactOfficeTitleBar r106 = (ContactOfficeTitleBar) ViewBindings.findChildViewById(r103, R.id.title_bar);
        if (r106 == null) goto L9;
        ContactDbFragmentOfficePrivateContactBinding r107 = new ContactDbFragmentOfficePrivateContactBinding((LinearLayout) r103, r105, r106);
        this.f419400d = r107;
        return r107.f419030a;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
