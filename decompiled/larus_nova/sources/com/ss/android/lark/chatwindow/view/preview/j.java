package com.ss.android.lark.chatwindow.view.preview;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UrlPreviewCollapsingHelper<BaseTextContentVO<?>> f417072a;

    public j(UrlPreviewCollapsingHelper<BaseTextContentVO<?>> r100) {
        this.f417072a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        if (this.f417072a.f417011e.getVisibility() != 8) goto L5;
        boolean r111 = true;
    L6:
        if (r111 == false) goto L11;
        final UrlPreviewCollapsingHelper<BaseTextContentVO<?>> r112 = this.f417072a;
        r112.b(false);
        UrlPreviewCollapsingHelper.a r100 = r112.f417018l;
        if (r100 == null) goto L10;
        r100.f417029g.cancel();
        View r101 = r100.f417027e;
        int r102 = r100.f417030h;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        r103.height = r102;
        r101.setLayoutParams(r103);
    L10:
        UrlPreviewCollapsingHelper.a r104 = new UrlPreviewCollapsingHelper.a(false, r112.f417010d, r112.f417012f, r112.f417015i, r112.f417011e, new UrlPreviewCollapsingHelper$expand$1(r112));
        r104.f417029g.start();
        r112.f417018l = r104;
        r112.d(R.string.Lark_IM_MsgHideLinkPreview_Button, true);
        return;
    L11:
        final UrlPreviewCollapsingHelper<BaseTextContentVO<?>> r113 = this.f417072a;
        r113.b(true);
        UrlPreviewCollapsingHelper.a r105 = r113.f417018l;
        if (r105 == null) goto L14;
        r105.f417029g.cancel();
        View r106 = r105.f417027e;
        int r107 = r105.f417030h;
        ViewGroup.LayoutParams r108 = r106.getLayoutParams();
        r108.height = r107;
        r106.setLayoutParams(r108);
    L14:
        UrlPreviewCollapsingHelper.a r109 = new UrlPreviewCollapsingHelper.a(true, r113.f417010d, r113.f417012f, r113.f417015i, r113.f417011e, new UrlPreviewCollapsingHelper$collapse$1(r113));
        r109.f417029g.start();
        r113.f417018l = r109;
        r113.d(R.string.Lark_IM_MsgShowLinkPreview_Button, true);
        return;
    L5:
        r111 = false;
        goto L6
    }
}
