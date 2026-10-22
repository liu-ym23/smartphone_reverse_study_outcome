package com.ss.android.lark.contact.base.contact_new.mvp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public class NewContactView_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NewContactView f418730a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        NewContactView r100 = this.f418730a;
        if (r100 == null) goto L7;
        this.f418730a = null;
        r100.mTitleBar = null;
        r100.mContentView = null;
        r100.mNewContactRV = null;
        r100.mPtrFrame = null;
        r100.mNewContactEmptyLayout = null;
        r100.newContactAddExtRl = null;
        r100.newContactAddExtTv = null;
        r100.newContactSubTitleTv = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public NewContactView_ViewBinding(NewContactView r100, View r101) {
        this.f418730a = r100;
        r100.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r101, R.id.new_contact_title_bar, "field 'mTitleBar'", CommonTitleBar.class);
        r100.mContentView = (ViewGroup) Utils.findRequiredViewAsType(r101, R.id.content_view, "field 'mContentView'", ViewGroup.class);
        r100.mNewContactRV = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.new_contact_rv, "field 'mNewContactRV'", RecyclerView.class);
        r100.mPtrFrame = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r101, R.id.new_contact_ptr_layout, "field 'mPtrFrame'", LKUIPtrClassicFrameLayout.class);
        r100.mNewContactEmptyLayout = Utils.findRequiredView(r101, R.id.new_contact_empty_layout, "field 'mNewContactEmptyLayout'");
        r100.newContactAddExtRl = (RelativeLayout) Utils.findRequiredViewAsType(r101, R.id.newContactAddExtRl, "field 'newContactAddExtRl'", RelativeLayout.class);
        r100.newContactAddExtTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.newContactAddExtTv, "field 'newContactAddExtTv'", TextView.class);
        r100.newContactSubTitleTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.newContactSubTitleTv, "field 'newContactSubTitleTv'", TextView.class);
    }
}
