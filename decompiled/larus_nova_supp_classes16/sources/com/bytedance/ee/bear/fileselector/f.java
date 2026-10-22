package com.bytedance.ee.bear.fileselector;

import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements itb.f {
    public final /* synthetic */ FileSelectConfig a;
    public final /* synthetic */ itb.g b;

    public final void onCancel() {
        g r0 = g.a;
        FileSelectConfig r1 = this.a;
        r0.getClass();
        g.b(r1);
    }

    public final void onError(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        tt5.a.k("OfficeMediaFileSelector", "selectFile failed: ".concat(r2));
        g r3 = g.a;
        FileSelectConfig r0 = this.a;
        r3.getClass();
        g.b(r0);
    }

    public final void onSuccess(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "filePaths");
        za5.a r0 = this.a.fileSelectListener;
        if (r0 == null) goto L25;
        g r1 = g.a;
        boolean r2 = this.b.f;
        r1.getClass();
        ArrayList r3 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
        int r4 = 0;
    L6:
        if (r11.hasNext() == false) goto L24;
        Object r5 = r11.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        String r7 = (String) r5;
        if (r7.length() != 0) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L16;
        tt5.a.k("OfficeMediaFileSelector", "buildFileBeans skip empty path");
        FileBean r9 = null;
    L21:
        if (r9 == null) goto L23;
        r3.add(r9);
    L23:
        r4 = r6;
        goto L6
    L16:
        PolarisFileWrapper r12 = new PolarisFileWrapper(r7);
        FileBean r13 = new FileBean();
        r13.setId(r4);
        r13.position = r4;
        r13.setPath(r7);
        r13.setMimeType(FileUtils.D(r7));
        if (r12.exists() == false) goto L19;
        long r14 = r12.length();
    L20:
        r13.setSize(r14);
        r13.setOrigin(r2);
        r9 = r13;
        goto L21
    L19:
        r14 = 0;
        goto L20
    L13:
        r8 = false;
        goto L14
    L24:
        r0.c(r3);
    L25:
        g r16 = g.a;
        FileSelectConfig r17 = this.a;
        r16.getClass();
        bb5.h r18 = r17.onDismissListener;
        if (r18 == null) goto L32;
        r18.onDismiss();
        return;
    }

    public f(FileSelectConfig r1, itb.g r2) {
        this.a = r1;
        this.b = r2;
    }
}
