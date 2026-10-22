package com.suite.lark.component.navroute.api;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public interface d {

    public static final class a {
        public static List<b<?>> b(d r100) {
            return rnc.c.f538747a.a(r100);
        }

        public static b<?> a(d r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, CloudControlInf.ROUTE);
            Iterator<T> r102 = r100.b().iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Object r103 = r102.next();
            if (Intrinsics.areEqual(((b) r103).getRoute(), r101) == false) goto L4;
        L10:
            return (b) r103;
        L8:
            r103 = null;
            goto L10
        }
    }

    b<?> a(String r100);

    List<b<?>> b();

    String getRoute();

    String getStart();
}
