package com.obric.assistant.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.larus.nova.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes33.dex */
public final class ItemObricLocalDataSearchSelectBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f389429a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f389429a;
    }

    public ItemObricLocalDataSearchSelectBinding(OCardListItem r100) {
        this.f389429a = r100;
    }

    public static ItemObricLocalDataSearchSelectBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.item_obric_local_data_search_select, r101, false);
        if (r102 == null) goto L7;
        return new ItemObricLocalDataSearchSelectBinding((OCardListItem) r102);
    L7:
        throw new NullPointerException("rootView");
    }
}
