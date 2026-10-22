package com.bytedance.applet.debugger;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements p0 {
    public final /* synthetic */ AppletDebuggerHostFragment a;

    public final void confirm() {
        AppletDebuggerHostFragment r0 = this.a;
        int r1 = AppletDebuggerHostFragment.m;
        String r2 = r0.U90().currentConversationId();
        if (r2 == null) goto L6;
        this.a.U90().clearHistory(r2);
        return;
    }

    public n(AppletDebuggerHostFragment r1) {
        this.a = r1;
    }
}
