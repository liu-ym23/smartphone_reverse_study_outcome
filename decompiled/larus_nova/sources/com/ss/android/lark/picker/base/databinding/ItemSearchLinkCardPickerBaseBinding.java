package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class ItemSearchLinkCardPickerBaseBinding implements ViewBinding {
    public final ItemSearchLinkInnerCardBinding innerLink1;
    public final ItemSearchLinkInnerCardBinding innerLink2;
    public final TextView innerLinkMore;
    public final ConstraintLayout linkInnerCard;
    private final ConstraintLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemSearchLinkCardPickerBaseBinding bind(View r100) {
        int r101 = R.id.inner_link_1;
        View r102 = ViewBindings.findChildViewById(r100, R.id.inner_link_1);
        if (r102 == null) goto L11;
        ItemSearchLinkInnerCardBinding r103 = ItemSearchLinkInnerCardBinding.bind(r102);
        r101 = R.id.inner_link_2;
        View r104 = ViewBindings.findChildViewById(r100, R.id.inner_link_2);
        if (r104 == null) goto L11;
        ItemSearchLinkInnerCardBinding r105 = ItemSearchLinkInnerCardBinding.bind(r104);
        r101 = R.id.inner_link_more;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r100, R.id.inner_link_more);
        if (r106 == null) goto L11;
        ConstraintLayout r107 = (ConstraintLayout) r100;
        return new ItemSearchLinkCardPickerBaseBinding(r107, r103, r105, r106, r107);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static ItemSearchLinkCardPickerBaseBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static ItemSearchLinkCardPickerBaseBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.item_search_link_card_picker_base, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private ItemSearchLinkCardPickerBaseBinding(ConstraintLayout r100, ItemSearchLinkInnerCardBinding r101, ItemSearchLinkInnerCardBinding r102, TextView r103, ConstraintLayout r104) {
        this.rootView = r100;
        this.innerLink1 = r101;
        this.innerLink2 = r102;
        this.innerLinkMore = r103;
        this.linkInnerCard = r104;
    }
}
