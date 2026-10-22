package com.ss.android.lark.contact.customized.externalcontact.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.ICUUtils;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.databinding.ContactDbOfficeContactListItemBinding;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u001f\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001cR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeContactListAdapter;", "Lcom/ss/android/lark/contact/base/contact_list/view/IndexRecyclerViewAdapter;", "Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeContactListAdapter$ContactItemViewHolder;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactItemModel;", "<init>", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "itemClickListener", "Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeContactListAdapter$IItemClickListener;", "getItemId", "", "position", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "genIndexData", "", "", "items", "", "setItemClickListener", "listener", "diff", "newItems", "IItemClickListener", "ContactItemViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeContactListAdapter extends IndexRecyclerViewAdapter<ContactItemViewHolder, mtb.d> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f419158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f419159e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeContactListAdapter$ContactItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;", "<init>", "(Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;)V", "getBinding", "()Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ContactItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContactDbOfficeContactListItemBinding f419160a;

        public ContactItemViewHolder(ContactDbOfficeContactListItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f419080a);
            this.f419160a = r100;
        }
    }

    public interface a {
        void a(String r100);

        void b(View r100, long r101);
    }

    public OfficeContactListAdapter() {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void B2(List<mtb.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "newItems");
        final ArrayList r101 = new ArrayList(this.items);
        final ArrayList r102 = new ArrayList(r100);
        if (r101.isEmpty() == false) goto L6;
        this.items.clear();
        this.items.addAll(r102);
        notifyDataSetChanged();
        return;
    L6:
        DiffUtil.calculateDiff(new OfficeContactListAdapter$diff$diffResult$1(r101, r102)).dispatchUpdatesTo(this);
        this.items.clear();
        this.items.addAll(r102);
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return getItem(r100).f515662a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        this.f419158d = r100.getContext();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter
    public final Map<Integer, String> z2(List<? extends mtb.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100.isEmpty() == false) goto L5;
        return r101;
    L5:
        Lazy r102 = OfficeContactUtils.f418960a;
        r101.put(0, OfficeContactUtils.c(((mtb.d) ListProtector.get(r100, 0)).f515667f));
        int r103 = r100.size();
        int r104 = 1;
    L6:
        if (r104 >= r103) goto L11;
        Lazy r105 = OfficeContactUtils.f418960a;
        String r106 = OfficeContactUtils.c(((mtb.d) ListProtector.get(r100, r104 - 1)).f515667f);
        String r107 = OfficeContactUtils.c(((mtb.d) ListProtector.get(r100, r104)).f515667f);
        if (StringsKt.equals(r106, r107, true) == true) goto L10;
        r101.put(Integer.valueOf(r104), r107);
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        return r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ContactItemViewHolder r102 = (ContactItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        mtb.d r103 = getItem(r101);
        Context r104 = this.f419158d;
        if (r104 == null) goto L14;
        String r105 = r103.f515666e;
        r102.f419160a.f419084e.setText(r105);
        if (r103.f515665d.length() <= 0) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L11;
        ICUUtils.FormatArgsBuilder r107 = new ICUUtils.FormatArgsBuilder();
        r107.b(InstantPlayContext.NICKNAME, r103.f515664c);
        List<ICUUtils.UFormatPair> r108 = r107.f285892a;
        r102.f419160a.f419082c.setVisibility(0);
        r102.f419160a.f419082c.setText(ICUUtils.icuFormat(UIHelper.getString(R.string.LarkIM_Friend_Contacts_Nickname_Text), r108));
    L12:
        String r109 = String.valueOf(r103.f515662a);
        long r110 = r103.f515662a;
        int r111 = UIHelper.dp2px(48.0f);
        LKUIRoundedImageView r112 = r102.f419160a.f419081b;
        String r113 = r103.f515668g;
        LoadParams r114 = new LoadParams();
        r114.f426328a = r111;
        r114.f426329b = r111;
        ImageModule.a(r104, r112, r113, r109, r114);
        r102.f419160a.f419083d.setOnClickListener(new c(this, r109));
        r102.f419160a.f419083d.setOnLongClickListener(new d(this, r110));
        return;
    L11:
        r102.f419160a.f419082c.setVisibility(8);
        goto L12
    L8:
        r106 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ContactItemViewHolder(ContactDbOfficeContactListItemBinding.a(LayoutInflater.from(r100.getContext()), r100));
    }
}
