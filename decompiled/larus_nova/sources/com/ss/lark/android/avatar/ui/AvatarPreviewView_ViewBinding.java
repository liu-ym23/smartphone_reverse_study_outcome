package com.ss.lark.android.avatar.ui;

import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.framework.ui.ViewPagerWithoutScroll;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: classes40.dex */
public class AvatarPreviewView_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AvatarPreviewView f456744a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        AvatarPreviewView r100 = this.f456744a;
        if (r100 == null) goto L7;
        this.f456744a = null;
        r100.mPhotoPagerFooterFL = null;
        r100.mMainVP = null;
        r100.mTitleBar = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public AvatarPreviewView_ViewBinding(AvatarPreviewView r100, View r101) {
        this.f456744a = r100;
        r100.mPhotoPagerFooterFL = (ViewGroup) Utils.findRequiredViewAsType(r101, R.id.photo_pager_footer, "field 'mPhotoPagerFooterFL'", ViewGroup.class);
        r100.mMainVP = (ViewPagerWithoutScroll) Utils.findRequiredViewAsType(r101, R.id.photo_pager_content, "field 'mMainVP'", ViewPagerWithoutScroll.class);
        r100.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r101, R.id.titlebar, "field 'mTitleBar'", CommonTitleBar.class);
    }
}
