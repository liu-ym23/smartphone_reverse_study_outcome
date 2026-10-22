package com.bytedance.ee.bear.bitable.share.view;

import com.bytedance.ee.bear.bitable.share.sharepanel.BitableFormShareLinkSettingPanelFragment;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements BitableFormShareLinkSettingPanelFragment.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableShareLinkShareSetView.a f215507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableShareLinkShareSetView f215508b;

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.BitableFormShareLinkSettingPanelFragment.b
    public final void a() {
        BitableShareLinkShareSetView.a r100 = this.f215508b.f215484k;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.BitableFormShareLinkSettingPanelFragment.b
    public final k b() {
        return this.f215507a.b();
    }

    public a(BitableShareLinkShareSetView.a r100, BitableShareLinkShareSetView r101) {
        this.f215507a = r100;
        this.f215508b = r101;
    }
}
