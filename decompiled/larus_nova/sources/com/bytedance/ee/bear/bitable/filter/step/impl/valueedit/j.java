package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes15.dex */
public final class j extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LinkFilterValueEditViewHolder.b.a f211996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LinkFilterValueEditViewHolder f211997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f211998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ LinkFilterValueEditViewHolder.b f211999f;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        boolean r101 = !this.f211996c.f211962b.isChecked();
        this.f211996c.f211962b.setChecked(r101);
        if (LinkFilterValueEditViewHolder.r(this.f211997d) == false) goto L5;
        ((ArrayList) this.f211997d.f211956t).clear();
    L5:
        if (r101 == false) goto L7;
        ((ArrayList) this.f211997d.f211956t).add(this.f211998e);
    L9:
        if (LinkFilterValueEditViewHolder.r(this.f211997d) == false) goto L12;
        this.f211999f.notifyDataSetChanged();
        return;
    L12:
        return;
    L7:
        ((ArrayList) this.f211997d.f211956t).remove(this.f211998e);
        goto L9
    }

    public j(LinkFilterValueEditViewHolder.b.a r100, LinkFilterValueEditViewHolder r101, String r102, LinkFilterValueEditViewHolder.b r103) {
        this.f211996c = r100;
        this.f211997d = r101;
        this.f211998e = r102;
        this.f211999f = r103;
    }
}
