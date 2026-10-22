package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t implements td5.a {
    public final /* synthetic */ SpaceSelectorBean a;
    public final /* synthetic */ Context b;

    @Override // td5.a
    public final boolean a(Document r4) {
        Intrinsics.checkNotNullParameter(r4, "destFolder");
        if (this.a.g == false) goto L8;
        FolderVersion.a r0 = FolderVersion.Companion;
        Integer r2 = Integer.valueOf(r4.L1);
        r0.getClass();
        if (FolderVersion.a.c(r2) == true) goto L8;
        return false;
    L8:
        if (this.a.g == true) goto L12;
        FolderVersion.a r1 = FolderVersion.Companion;
        Integer r5 = Integer.valueOf(r4.L1);
        r1.getClass();
        if (FolderVersion.a.c(r5) == false) goto L14;
        return false;
    L14:
        return true;
    L12:
        return true;
    }

    public t(SpaceSelectorBean r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // td5.a
    public final void b(Document r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "destFolder");
        if (r4 != null) goto L6;
        r4 = this.b;
    L6:
        if (this.a.g == false) goto L11;
        FolderVersion.a r0 = FolderVersion.Companion;
        Integer r1 = Integer.valueOf(r3.L1);
        r0.getClass();
        if (FolderVersion.a.c(r1) == true) goto L11;
        Toast.showText(r4, r4.getString(2131887316));
    L11:
        if (this.a.g == true) goto L16;
        FolderVersion.a r2 = FolderVersion.Companion;
        Integer r5 = Integer.valueOf(r3.L1);
        r2.getClass();
        if (FolderVersion.a.c(r5) == false) goto L17;
        Toast.showText(r4, r4.getString(2131887317));
        return;
    L17:
        return;
    }
}
