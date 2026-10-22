package com.ss.android.lark.contact.base.contact_list.mvp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public class ExternalContactView2_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExternalContactView2 f418588a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        ExternalContactView2 r100 = this.f418588a;
        if (r100 == null) goto L7;
        this.f418588a = null;
        r100.mExternalContactLayout = null;
        r100.mTitleBar = null;
        r100.mExternalAddLayout = null;
        r100.mExternalAddTv = null;
        r100.mExternalContactContentLayout = null;
        r100.mPtrFrame = null;
        r100.mExternalContactRV = null;
        r100.mExternalContactEmptyLayout = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public ExternalContactView2_ViewBinding(ExternalContactView2 r100, View r101) {
        this.f418588a = r100;
        r100.mExternalContactLayout = (ViewGroup) Utils.findRequiredViewAsType(r101, R.id.external_contact_layout, "field 'mExternalContactLayout'", ViewGroup.class);
        r100.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r101, R.id.external_contact_title_bar, "field 'mTitleBar'", CommonTitleBar.class);
        r100.mExternalAddLayout = Utils.findRequiredView(r101, R.id.external_add_layout, "field 'mExternalAddLayout'");
        r100.mExternalAddTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.external_add_tv, "field 'mExternalAddTv'", TextView.class);
        r100.mExternalContactContentLayout = (ViewGroup) Utils.findRequiredViewAsType(r101, R.id.external_contact_content_layout, "field 'mExternalContactContentLayout'", ViewGroup.class);
        r100.mPtrFrame = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r101, R.id.external_contact_ptr_layout, "field 'mPtrFrame'", LKUIPtrClassicFrameLayout.class);
        r100.mExternalContactRV = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.external_contact_rv, "field 'mExternalContactRV'", RecyclerView.class);
        r100.mExternalContactEmptyLayout = Utils.findRequiredView(r101, R.id.external_contact_empty_layout, "field 'mExternalContactEmptyLayout'");
    }
}
