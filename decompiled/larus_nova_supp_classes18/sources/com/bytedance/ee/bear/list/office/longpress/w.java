package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements td5.a {
    public final /* synthetic */ Document a;
    public final /* synthetic */ SpaceSelectorBean b;
    public final /* synthetic */ Context c;

    @Override // td5.a
    public final boolean a(Document r4) {
        Intrinsics.checkNotNullParameter(r4, "destFolder");
        b0 r0 = b0.a;
        Document r1 = this.a;
        r0.getClass();
        if (TextUtils.equals(b0.i(r1), r4.c) == false) goto L6;
        return false;
    L6:
        if (this.b.g == false) goto L11;
        FolderVersion.a r2 = FolderVersion.Companion;
        Integer r3 = Integer.valueOf(r4.L1);
        r2.getClass();
        if (FolderVersion.a.c(r3) == true) goto L11;
        return false;
    L11:
        if (this.b.g == true) goto L15;
        FolderVersion.a r5 = FolderVersion.Companion;
        Integer r6 = Integer.valueOf(r4.L1);
        r5.getClass();
        if (FolderVersion.a.c(r6) == false) goto L17;
        return false;
    L17:
        return true;
    L15:
        return true;
    }

    @Override // td5.a
    public final void b(Document r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "destFolder");
        if (this.b.g == false) goto L8;
        FolderVersion.a r4 = FolderVersion.Companion;
        Integer r0 = Integer.valueOf(r2.L1);
        r4.getClass();
        if (FolderVersion.a.c(r0) == true) goto L8;
        Context r5 = this.c;
        Toast.showText(r5, r5.getString(2131887318));
    L8:
        if (this.b.g == true) goto L13;
        FolderVersion.a r6 = FolderVersion.Companion;
        Integer r7 = Integer.valueOf(r2.L1);
        r6.getClass();
        if (FolderVersion.a.c(r7) == false) goto L14;
        Context r8 = this.c;
        Toast.showText(r8, r8.getString(2131887319));
        return;
    L14:
        return;
    }

    public w(Document r1, SpaceSelectorBean r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
