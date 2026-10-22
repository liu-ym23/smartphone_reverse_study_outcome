package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r extends za5.b {
    public final /* synthetic */ o a;
    public final /* synthetic */ Function1<List<OfficeSpaceUploadSelection>, Unit> b;
    public final /* synthetic */ Function0<Unit> c;

    public final void b() {
        tt5.a.h("OfficeUploadFileSelector", "media picker canceled");
        this.c.invoke();
    }

    public final void c(List<? extends FileBean> r8) {
        Intrinsics.checkNotNullParameter(r8, "fileList");
        StringBuilder r0 = new StringBuilder("media picker selected, count=");
        r0.append(r8.size());
        r0.append(", firstPath=");
        o r1 = this.a;
        FileBean r2 = (FileBean) CollectionsKt.firstOrNull(r8);
        if (r2 == null) goto L5;
        String r3 = r2.getPath();
    L6:
        r1.getClass();
        r0.append(o.d(r3));
        tt5.a.h("OfficeUploadFileSelector", r0.toString());
        Function1<List<OfficeSpaceUploadSelection>, Unit> r4 = this.b;
        o r5 = this.a;
        ArrayList r6 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L20;
        String r7 = ((FileBean) r9.next()).getPath();
        if (r7 != null) goto L12;
    L17:
        OfficeSpaceUploadSelection r10 = null;
    L18:
        if (r10 == null) goto L8;
        r6.add(r10);
        goto L8
    L12:
        if ((!StringsKt.isBlank(r7)) == true) goto L15;
        r7 = null;
    L15:
        if (r7 == null) goto L17;
        r5.getClass();
        r10 = o.a(r5, r7, false, o.b(r7));
        goto L18
    L20:
        r4.invoke(r6);
        return;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(o r1, Function1<? super List<OfficeSpaceUploadSelection>, Unit> r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
