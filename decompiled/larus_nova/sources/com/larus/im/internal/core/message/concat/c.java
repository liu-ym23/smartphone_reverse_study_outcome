package com.larus.im.internal.core.message.concat;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.d0;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: classes4.dex */
public interface c {

    /* JADX INFO: loaded from: classes29.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static d0 a(c r100, d0 r101, d0 r110) {
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r110, "source");
            Map r102 = MapsKt.toMutableMap(r101);
            Iterator<String> r103 = r110.keySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L40;
            String r104 = r103.next();
            i r105 = (i) r110.get(r104);
            if (r105 == 0) goto L4;
            if (r102.containsKey(r104) == false) goto L10;
            if ((r105 instanceof d0) == true) goto L13;
            if ((r105 instanceof ouc.b) == true) goto L22;
            if (k.o(r105).c() == false) goto L38;
            if (StringsKt.isBlank(k.o(r105).a()) == false) goto L38;
            com.larus.im.internal.delegate.a.f348188b.w("IMessageConcatHelper", "warning empty value updated to json concat");
        L38:
            r102.put(r104, r105);
            goto L4
        L22:
            ArrayList r106 = new ArrayList();
            i r107 = (i) r101.get(r104);
            if (r107 == null) goto L28;
            Iterator<i> r108 = k.m(r107).iterator();
        L26:
            if (r108.hasNext() == false) goto L28;
            i r109 = r108.next();
            Intrinsics.checkNotNullParameter(r109, "element");
            r106.add(r109);
        L28:
            Iterator r111 = ((Iterable) r105).iterator();
        L30:
            if (r111.hasNext() == false) goto L32;
            i r112 = (i) r111.next();
            Intrinsics.checkNotNullParameter(r112, "element");
            r106.add(r112);
            goto L30
        L32:
            r102.put(r104, new ouc.b(r106));
            goto L4
        L13:
            i r113 = (i) r101.get(r104);
            if (r113 == null) goto L16;
            d0 r114 = k.n(r113);
        L17:
            if (r114 != null) goto L18;
            r102.put(r104, r105);
            goto L4
        L18:
            r102.put(r104, r100.a(r114, (d0) r105));
            goto L4
        L16:
            r114 = null;
            goto L17
        L10:
            r102.put(r104, r105);
            goto L4
        L40:
            return new d0(r102);
        }
    }

    d0 a(d0 r100, d0 r101);
}
