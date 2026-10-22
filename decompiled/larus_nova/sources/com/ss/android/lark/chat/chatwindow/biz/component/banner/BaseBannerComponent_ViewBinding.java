package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.view.SizeDetectFrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public class BaseBannerComponent_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseBannerComponent f411969a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        BaseBannerComponent r100 = this.f411969a;
        if (r100 == null) goto L7;
        this.f411969a = null;
        r100.mBannerRoot = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public BaseBannerComponent_ViewBinding(BaseBannerComponent r100, View r101) {
        this.f411969a = r100;
        r100.mBannerRoot = (SizeDetectFrameLayout) Utils.findRequiredViewAsType(r101, R.id.banner_root, "field 'mBannerRoot'", SizeDetectFrameLayout.class);
    }
}
