package com.ss.android.lark.ug.business.badge;

import com.larksuite.framework.callback.UICallbackExecutor;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements l {
    public e() {
    }

    @Override // com.ss.android.lark.ug.business.badge.l
    public final void onUpdate() {
        j r100 = BadgeManager.f444410a;
        if (BadgeManager.f444412c.get() == false) goto L7;
        UICallbackExecutor.execute(c.f444421a);
        return;
    }
}
