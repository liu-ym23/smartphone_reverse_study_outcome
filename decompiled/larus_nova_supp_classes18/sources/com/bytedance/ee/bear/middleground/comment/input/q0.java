package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.fileselector.bean.FileBean;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q0<T, R> implements Function {
    public final /* synthetic */ InputComment a;
    public final /* synthetic */ List<FileBean> b;

    public q0(InputComment r1, List<? extends FileBean> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r14) {
        Intrinsics.checkNotNullParameter((List) r14, "it");
        InputComment r15 = this.a;
        List<FileBean> r0 = this.b;
        r15.getClass();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<FileBean> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        FileBean r3 = r2.next();
        int r5 = r3.getId();
        StringBuilder r6 = new StringBuilder();
        r6.append(r5);
        r6.append(System.currentTimeMillis());
        r3.setUuid(r6.toString());
        String r7 = r3.getPath();
        StringBuilder r12 = new StringBuilder("docsource://com.bytedance.net/file/f/");
        ((v45.a) org.koin.java.a.c(v45.a.class, null, null, 6)).c();
        r12.append(r3.getUuid());
        r12.append(r7.substring(StringsKt.lastIndexOf$default(r7, ".", 0, false, 6, null)));
        String r4 = r12.toString();
        r1.put(r4, r3.getPath());
        r3.setPath(r4);
        goto L4
    L7:
        return ((v45.a) org.koin.java.a.c(v45.a.class, null, null, 6)).i(r15.k.getDocUrl(), r15.a.i, r1);
    }
}
