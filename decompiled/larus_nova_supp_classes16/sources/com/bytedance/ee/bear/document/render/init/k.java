package com.bytedance.ee.bear.document.render.init;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.s4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements s4 {
    public final DocViewModel a;
    public final Fragment b;
    public final PluginHost c;

    @Override // com.bytedance.ee.bear.document.s4
    public final Boolean canRead() {
        w05.b r0 = (w05.b) this.c.getHostAbilityOrNull(w05.b.class);
        if (r0 == null) goto L7;
        w05.i r1 = r0.getDocumentInfoProvider();
        if (r1 == null) goto L7;
        return r1.a();
    L7:
        return null;
    }

    @Override // com.bytedance.ee.bear.document.s4
    public final String getToken() {
        if (this.a.isEditionDoc() == false) goto L9;
        String r0 = this.a.getEditionToken();
        if (r0 != null) goto L8;
        return "";
    L8:
        return r0;
    L9:
        return "";
    }

    @Override // com.bytedance.ee.bear.document.s4
    public final String h7() {
        if (this.a.isEditionDoc() == false) goto L5;
        String r0 = this.a.getEditionName();
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        String r1 = (String) this.a.getDocName().getValue();
        if (r1 != null) goto L15;
        CharSequence r2 = (CharSequence) this.a.getTitle().getValue();
        if (r2 == null) goto L10;
        String r3 = r2.toString();
    L11:
        if (r3 != null) goto L16;
        return "";
    L16:
        return r3;
    L10:
        r3 = null;
        goto L11
    L15:
        return r1;
    }

    @Override // com.bytedance.ee.bear.document.s4
    public final Fragment getFragment() {
        return this.b;
    }

    public k(DocViewModel r2, Fragment r3, PluginHost r4) {
        Intrinsics.checkNotNullParameter(r2, "docViewModel");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "pluginHost");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
