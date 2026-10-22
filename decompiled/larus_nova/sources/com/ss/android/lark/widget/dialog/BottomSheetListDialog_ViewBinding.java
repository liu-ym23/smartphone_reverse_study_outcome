package com.ss.android.lark.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class BottomSheetListDialog_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BottomSheetListDialog f445761a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        BottomSheetListDialog r100 = this.f445761a;
        if (r100 == null) goto L7;
        this.f445761a = null;
        r100.mRecyclerView = null;
        r100.mPositiveBtn = null;
        r100.mNegativeBtn = null;
        r100.mTitleView = null;
        r100.mMessageView = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public BottomSheetListDialog_ViewBinding(BottomSheetListDialog r100, View r101) {
        this.f445761a = r100;
        r100.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.bottom_sheet_dialog_content_list, "field 'mRecyclerView'", RecyclerView.class);
        r100.mPositiveBtn = (TextView) Utils.findRequiredViewAsType(r101, R.id.float_selector_right_btn, "field 'mPositiveBtn'", TextView.class);
        r100.mNegativeBtn = (TextView) Utils.findRequiredViewAsType(r101, R.id.float_selector_left_btn, "field 'mNegativeBtn'", TextView.class);
        r100.mTitleView = (TextView) Utils.findRequiredViewAsType(r101, R.id.bottom_sheet_dialog_title, "field 'mTitleView'", TextView.class);
        r100.mMessageView = (TextView) Utils.findRequiredViewAsType(r101, R.id.bottom_sheet_dialog_message, "field 'mMessageView'", TextView.class);
    }
}
