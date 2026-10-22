package com.bytedance.ee.bear.document.more;

import com.bytedance.ee.bear.document.ai.myai.MyAIPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements com.bytedance.ee.bear.more.a {
    public final /* synthetic */ i a;

    public final jdb.g a() {
        return this.a.c();
    }

    public final void b() {
        MyAIPlugin r0 = (MyAIPlugin) this.a.a.findPlugin(MyAIPlugin.class);
        if (r0 == null) goto L6;
        r0.clickItem();
        return;
    }

    public final boolean isVisible() {
        MyAIPlugin r0 = (MyAIPlugin) this.a.a.findPlugin(MyAIPlugin.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isVisible() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public j(i r1) {
        this.a = r1;
    }
}
