package com.ss.android.lark.contact.customized.newcontact.view;

import android.content.Context;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeNewContactBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContactDbFragmentOfficeNewContactBinding f419382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f419383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f419384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OfficeNewContactAdapter f419385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f419386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public lt7.d f419387f;

    public interface a {
        void T();

        boolean canLoadMore();

        void j0(NewContactView.a r100);

        void t0(String r100, String r101);
    }

    public interface b {
        void A();

        void J(String r100, String r101);

        void y();

        void z();
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f419388a;

        public c(l r100) {
            this.f419388a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f419388a.f419383b.z();
        }
    }

    public final void a() {
        this.f419382a.f419028f.setEmptyIcon(R.drawable.contact_db_icon_load_empty);
        ContactDbFragmentOfficeNewContactBinding r100 = this.f419382a;
        r100.f419028f.setEmptyText(r100.f419023a.getContext().getString(R.string.LarkIM_Friend_NoNewContact_Empty));
        if (OfficeContactUtils.f() == false) goto L5;
        this.f419382a.f419028f.setHideActionButton(true);
        this.f419382a.f419028f.setOnActionClickListener(null);
    L6:
        this.f419382a.f419026d.setVisibility(8);
        this.f419382a.f419027e.setVisibility(0);
        this.f419382a.f419028f.setVisibility(0);
        this.f419382a.f419024b.setVisibility(8);
        lt7.d r101 = this.f419387f;
        if (r101 == null) goto L10;
        r101.a();
        return;
    L10:
        return;
    L5:
        ContactDbFragmentOfficeNewContactBinding r102 = this.f419382a;
        r102.f419028f.setEmptyActionText(r102.f419023a.getContext().getString(R.string.LarkIM_Friend_NoContactsAdd_Button));
        this.f419382a.f419028f.setOnActionClickListener(new c(this));
        goto L6
    }

    public final void b() {
        this.f419382a.f419026d.setVisibility(0);
        this.f419382a.f419027e.setVisibility(8);
        this.f419382a.f419028f.setVisibility(8);
        this.f419382a.f419024b.setVisibility(8);
        lt7.d r100 = this.f419387f;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public l(ContactDbFragmentOfficeNewContactBinding r100, OfficeNewContactFragment.b r101) {
        Intrinsics.checkNotNullParameter(r100, "viewBinding");
        Intrinsics.checkNotNullParameter(r101, "viewDependency");
        this.f419382a = r100;
        this.f419383b = r101;
    }
}
