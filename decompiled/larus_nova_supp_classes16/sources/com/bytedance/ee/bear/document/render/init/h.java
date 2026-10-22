package com.bytedance.ee.bear.document.render.init;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ a a;
    public final /* synthetic */ DocViewModel b;
    public final /* synthetic */ ChameleonPluginHost c;

    public h(a r1, DocViewModel r2, ChameleonPluginHost r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r3) {
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L13;
        a r4 = this.a;
        DocViewModel r0 = this.b;
        r4.getClass();
        if (r0.getOpenSource() != DocsOpenSource.vc) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L14;
        com.bytedance.ee.util.ui.j.d(new g(this.a, this.c), 100);
        return;
    L14:
        return;
    L7:
        if (r0.getOpenSource() == DocsOpenSource.doc_component) goto L9;
        r5 = true;
        goto L10
    }
}
