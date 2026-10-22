package com.bytedance.ee.bear.bitable.core.basemain.ability;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements MenuItem.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LegacyBitableBaseMainUIAbility f210134a;

    public f(LegacyBitableBaseMainUIAbility r100) {
        this.f210134a = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
    public final void a(MenuItem r100, View r101) {
        this.f210134a.m1();
    }
}
