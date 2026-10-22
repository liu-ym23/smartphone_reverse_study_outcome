package com.bytedance.ee.bear.debug;

import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends BaseTitleBar.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ AppendParamsActivity f217367k;

    public d(AppendParamsActivity r100) {
        this.f217367k = r100;
        super(R.drawable.ud_icon_more_add_outlined);
    }

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        this.f217367k.f217348j.add(new AppendParamsActivity.b("", ""));
        this.f217367k.f217349k.notifyDataSetChanged();
    }
}
