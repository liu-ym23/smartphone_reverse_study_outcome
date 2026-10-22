package com.bytedance.ee.bear.lark.selector;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class DocSearchItemHolderView$DocSearchItemViewHolder_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DocSearchItemHolderView$DocSearchItemViewHolder f227456a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        DocSearchItemHolderView$DocSearchItemViewHolder r100 = this.f227456a;
        if (r100 == null) goto L7;
        this.f227456a = null;
        r100.mSingleAvatorIV = null;
        r100.mNameTV = null;
        r100.mDescTV = null;
        r100.mCheckBox = null;
        r100.mTagTv = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public DocSearchItemHolderView$DocSearchItemViewHolder_ViewBinding(DocSearchItemHolderView$DocSearchItemViewHolder r100, View r101) {
        this.f227456a = r100;
        r100.mSingleAvatorIV = (ImageView) Utils.findRequiredViewAsType(r101, R.id.group_avatar, "field 'mSingleAvatorIV'", ImageView.class);
        r100.mNameTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.item_title, "field 'mNameTV'", TextView.class);
        r100.mDescTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.item_desc, "field 'mDescTV'", TextView.class);
        r100.mCheckBox = (UDCheckBox) Utils.findRequiredViewAsType(r101, R.id.select_box, "field 'mCheckBox'", UDCheckBox.class);
        r100.mTagTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.doc_tag, "field 'mTagTv'", TextView.class);
    }
}
