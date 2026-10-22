package com.bytedance.ee.bear.bitable.plugin.more;

import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseUnspecifiedOrientationPlugin f214933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableTitleMorePlugin.a f214934b;

    public final void a() {
        this.f214933a.onOrientationSupportPanelDismiss(this.f214934b.f214929a);
        if (BitableTitleMorePlugin.access$300(this.f214934b.f214929a) == null) goto L6;
        BitableTitleMorePlugin.access$300(this.f214934b.f214929a).f214946g = null;
        return;
    }

    public d(BitableTitleMorePlugin.a r100, BaseUnspecifiedOrientationPlugin r101) {
        this.f214934b = r100;
        this.f214933a = r101;
    }
}
