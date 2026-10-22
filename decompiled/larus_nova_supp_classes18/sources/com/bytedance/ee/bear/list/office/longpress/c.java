package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements td5.a {
    public final /* synthetic */ Context a;

    public c(Context r1) {
        this.a = r1;
    }

    @Override // td5.a
    public final boolean a(Document r2) {
        Intrinsics.checkNotNullParameter(r2, "destFolder");
        FolderVersion.a r0 = FolderVersion.Companion;
        Integer r3 = Integer.valueOf(r2.L1);
        r0.getClass();
        return FolderVersion.a.c(r3);
    }

    @Override // td5.a
    public final void b(Document r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "destFolder");
        if (r3 != null) goto L5;
        r3 = this.a;
    L5:
        Toast.showText(r3, this.a.getString(2131887320));
    }
}
