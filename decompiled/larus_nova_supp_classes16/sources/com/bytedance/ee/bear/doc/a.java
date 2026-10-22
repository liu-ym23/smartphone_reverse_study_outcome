package com.bytedance.ee.bear.doc;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.doc.history.HistoryMoreItemV2;
import com.bytedance.ee.bear.doc.structure.StructureMoreItemV2;
import com.bytedance.ee.bear.doc.structure.StructurePlugin;
import com.bytedance.ee.bear.doc.translate.TranslateMoreItemV2;
import com.bytedance.ee.bear.doc.translate.i;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.tts.TtsMoreItemV3;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements ny4.a {
    public a() {
    }

    @Override // ny4.a
    public final StructureMoreItemV2 a(DocumentPluginHost r2) {
        if ((r2 instanceof DocumentPluginHost) == true) goto L5;
        return null;
    L5:
        return new StructureMoreItemV2(r2);
    }

    @Override // ny4.a
    public final ez4.a b(DocumentPluginHost r2) {
        if ((r2 instanceof DocumentPluginHost) == true) goto L5;
        return null;
    L5:
        return new ez4.a(r2);
    }

    @Override // ny4.a
    public final com.bytedance.ee.bear.more.protocol3.b c(DocumentPluginHost r7) {
        if ((r7 instanceof DocumentPluginHost) == true) goto L6;
        tt5.a.h("DocImpl", "is not DocumentPluginHost");
        return null;
    L6:
        boolean r2 = false;
        if (r7.a() == null) goto L12;
        DocViewModel r0 = r7.a();
        boolean r3 = TextUtils.equals(r0.getDocumentType(), e.o.getType());
        boolean r4 = TextUtils.equals(r0.getDocumentType(), e.h.getType());
        if (DocsOpenSource.vc != r0.getOpenSource()) goto L11;
        r2 = true;
    L11:
        boolean r1 = r2;
        r2 = r3;
    L13:
        tt5.a.h("DocImpl", "isDocx:" + r2 + " isInVc:" + r1 + " isSheet:" + r4);
        if (r2 == true) goto L19;
        if (r4 == true) goto L19;
        return new TranslateMoreItemV2(r7);
    L19:
        return new i(r7);
    L12:
        r1 = false;
        r4 = false;
        goto L13
    }

    @Override // ny4.a
    public final TtsMoreItemV3 e(DocumentPluginHost r2) {
        if ((r2 instanceof DocumentPluginHost) == true) goto L5;
        return null;
    L5:
        return new TtsMoreItemV3(r2);
    }

    @Override // ny4.a
    public final cy4.a f(DocumentPluginHost r2) {
        if ((r2 instanceof DocumentPluginHost) == true) goto L5;
        return null;
    L5:
        return new cy4.a(r2);
    }

    @Override // ny4.a
    public final HistoryMoreItemV2 g(DocumentPluginHost r2) {
        if ((r2 instanceof DocumentPluginHost) == true) goto L5;
        return null;
    L5:
        return new HistoryMoreItemV2(r2);
    }

    @Override // ny4.a
    public final void d(PluginHost r2, boolean r3) {
        if ((r2 instanceof DocumentPluginHost) == false) goto L8;
        StructurePlugin r4 = (StructurePlugin) r2.findPlugin(StructurePlugin.class);
        if (r4 == null) goto L9;
        r4.getStructureViewModel().floatingStructureVisible().setValue(Boolean.valueOf(r3));
        return;
    L9:
        return;
    }
}
