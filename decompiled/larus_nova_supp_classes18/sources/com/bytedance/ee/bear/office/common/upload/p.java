package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p extends za5.b {
    public final /* synthetic */ o a;
    public final /* synthetic */ Function1<List<OfficeSpaceUploadSelection>, Unit> b;
    public final /* synthetic */ Function0<Unit> c;

    public final void b() {
        tt5.a.h("OfficeUploadFileSelector", "file picker canceled");
        this.c.invoke();
    }

    public final void a(List<String> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "filePointerList");
        List r8 = CollectionsKt.distinct(r6);
        StringBuilder r0 = new StringBuilder("file picker selected, count=");
        r0.append(r8.size());
        r0.append(", isFileUseUri=");
        r0.append(r7);
        r0.append(", firstPointer=");
        o r1 = this.a;
        String r2 = (String) CollectionsKt.firstOrNull(r8);
        r1.getClass();
        r0.append(o.d(r2));
        tt5.a.h("OfficeUploadFileSelector", r0.toString());
        Function1<List<OfficeSpaceUploadSelection>, Unit> r3 = this.b;
        List r9 = r8;
        o r4 = this.a;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.add(o.a(r4, (String) r10.next(), r7, null));
        goto L4
    L6:
        r3.invoke(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(o r1, Function1<? super List<OfficeSpaceUploadSelection>, Unit> r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
