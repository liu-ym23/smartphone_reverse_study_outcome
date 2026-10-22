package com.bytedance.ee.bear.lark.selector;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocSearchItemHolderView$DocSearchItemViewHolder_ViewBinding implements Unbinder {
    public DocSearchItemHolderView$DocSearchItemViewHolder a;

    public final void unbind() {
        DocSearchItemHolderView$DocSearchItemViewHolder r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mSingleAvatorIV = null;
        r0.mNameTV = null;
        r0.mDescTV = null;
        r0.mCheckBox = null;
        r0.mTagTv = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public DocSearchItemHolderView$DocSearchItemViewHolder_ViewBinding(DocSearchItemHolderView$DocSearchItemViewHolder r4, View r5) {
        this.a = r4;
        r4.mSingleAvatorIV = (ImageView) Utils.findRequiredViewAsType(r5, 2131373927, "field 'mSingleAvatorIV'", ImageView.class);
        r4.mNameTV = (TextView) Utils.findRequiredViewAsType(r5, 2131375867, "field 'mNameTV'", TextView.class);
        r4.mDescTV = (TextView) Utils.findRequiredViewAsType(r5, 2131375727, "field 'mDescTV'", TextView.class);
        r4.mCheckBox = (UDCheckBox) Utils.findRequiredViewAsType(r5, 2131385785, "field 'mCheckBox'", UDCheckBox.class);
        r4.mTagTv = (TextView) Utils.findRequiredViewAsType(r5, 2131369360, "field 'mTagTv'", TextView.class);
    }
}
