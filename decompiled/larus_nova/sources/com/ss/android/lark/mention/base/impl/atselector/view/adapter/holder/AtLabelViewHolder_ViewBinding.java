package com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class AtLabelViewHolder_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtLabelViewHolder f431840a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        AtLabelViewHolder r100 = this.f431840a;
        if (r100 == null) goto L7;
        this.f431840a = null;
        r100.mLabelTV = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public AtLabelViewHolder_ViewBinding(AtLabelViewHolder r100, View r101) {
        this.f431840a = r100;
        r100.mLabelTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.label, "field 'mLabelTV'", TextView.class);
    }
}
