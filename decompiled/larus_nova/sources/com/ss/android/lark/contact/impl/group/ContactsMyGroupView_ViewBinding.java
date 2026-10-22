package com.ss.android.lark.contact.impl.group;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: classes35.dex */
public class ContactsMyGroupView_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContactsMyGroupView f419475a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        ContactsMyGroupView r100 = this.f419475a;
        if (r100 == null) goto L7;
        this.f419475a = null;
        r100.mTitleBar = null;
        r100.mMyGroupVP = null;
        r100.mIndicator = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public ContactsMyGroupView_ViewBinding(ContactsMyGroupView r100, View r101) {
        this.f419475a = r100;
        r100.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r101, R.id.titlebar, "field 'mTitleBar'", CommonTitleBar.class);
        r100.mMyGroupVP = (ViewPager) Utils.findRequiredViewAsType(r101, R.id.group_vp, "field 'mMyGroupVP'", ViewPager.class);
        r100.mIndicator = (UDTabLayout) Utils.findRequiredViewAsType(r101, R.id.indicator, "field 'mIndicator'", UDTabLayout.class);
    }
}
