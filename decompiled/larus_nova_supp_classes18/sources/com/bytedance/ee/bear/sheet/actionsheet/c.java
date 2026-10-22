package com.bytedance.ee.bear.sheet.actionsheet;

import com.bytedance.ee.bear.sheet.tab.jsdata.SheetModalPanelData;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class c {
    public final Object a;
    public final String b;
    public final boolean c;
    public Integer d;
    public e e;

    public c(SheetModalPanelData.ModalItem r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "text");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
