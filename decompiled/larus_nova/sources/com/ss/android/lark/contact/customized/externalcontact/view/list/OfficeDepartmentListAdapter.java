package com.ss.android.lark.contact.customized.externalcontact.view.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.databinding.ContactDbOfficeContactListItemBinding;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0016J\u0014\u0010\u001d\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u001a\u0010\u001f\u001a\u00020\n2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeDepartmentListAdapter;", "Lcom/ss/android/lark/contact/base/contact_list/view/IndexRecyclerViewAdapter;", "Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeDepartmentListAdapter$ContactItemViewHolder;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;", "<init>", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onClickListener", "Lkotlin/Function1;", "", "getItemId", "", "position", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "genIndexData", "", "", "items", "", "diff", "newItems", "setOnClickListener", "listener", "ContactItemViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDepartmentListAdapter extends IndexRecyclerViewAdapter<ContactItemViewHolder, mtb.c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f419215d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeDepartmentListAdapter$ContactItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;", "<init>", "(Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;)V", "getBinding", "()Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ContactItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContactDbOfficeContactListItemBinding f419216a;

        public ContactItemViewHolder(ContactDbOfficeContactListItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f419080a);
            this.f419216a = r100;
        }
    }

    public OfficeDepartmentListAdapter() {
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return getItem(r100).hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        this.f419215d = r100.getContext();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter
    public final Map<Integer, String> z2(List<? extends mtb.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        return MapsKt.emptyMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ContactItemViewHolder r102 = (ContactItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        mtb.c r103 = getItem(r101);
        Context r104 = this.f419215d;
        if (r104 != null) goto L6;
        return;
    L6:
        if ((r103 instanceof mtb.i) == false) goto L9;
        r102.f419216a.f419081b.setImageResource(R.drawable.contact_db_department);
        r102.f419216a.f419084e.setText(((mtb.i) r103).f515684a);
        r102.f419216a.f419083d.setOnClickListener(new b(this, r103));
    L11:
        r102.f419216a.f419083d.setOnLongClickListener(d.f419225a);
        return;
    L9:
        if ((r103 instanceof mtb.j) == false) goto L14;
        int r105 = UIHelper.dp2px(48.0f);
        LKUIRoundedImageView r106 = r102.f419216a.f419081b;
        mtb.j r107 = (mtb.j) r103;
        String r108 = r107.f515688c;
        String r109 = r107.f515687b;
        LoadParams r110 = new LoadParams();
        r110.f426328a = r105;
        r110.f426329b = r105;
        ImageModule.a(r104, r106, r108, r109, r110);
        r102.f419216a.f419084e.setText(r107.f515686a);
        r102.f419216a.f419083d.setOnClickListener(new c(this, r103));
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ContactItemViewHolder(ContactDbOfficeContactListItemBinding.a(LayoutInflater.from(r100.getContext()), r100));
    }
}
