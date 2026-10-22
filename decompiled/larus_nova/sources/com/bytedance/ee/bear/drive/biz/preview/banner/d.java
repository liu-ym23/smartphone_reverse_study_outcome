package com.bytedance.ee.bear.drive.biz.preview.banner;

import android.view.View;
import com.larksuite.component.universe_design.notice.UDNotice;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f223235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f223236b;

    public d(a.b r100, a r101) {
        this.f223235a = r100;
        this.f223236b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f223235a.f223232h.onClick(r100);
        UDNotice r101 = this.f223236b.f223209f;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        this.f223236b.f();
        this.f223236b.b();
    }
}
