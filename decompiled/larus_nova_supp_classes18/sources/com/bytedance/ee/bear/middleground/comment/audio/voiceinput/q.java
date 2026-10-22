package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.view.View;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q {
    public final LinkedHashMap<View, Integer> a;

    public final void a() {
        this.a.clear();
    }

    public final boolean b() {
        return !this.a.isEmpty();
    }

    public q() {
        this.a = new LinkedHashMap();
    }

    public final void c(Iterable<? extends View> r3, Integer r4) {
        if (r3 != null) goto L7;
        Iterator<Map.Entry<View, Integer>> r5 = this.a.entrySet().iterator();
    L5:
        if (r5.hasNext() == false) goto L17;
        Map.Entry<View, Integer> r6 = r5.next();
        r6.getKey().setVisibility(r6.getValue().intValue());
    L17:
        a();
        return;
    L7:
        Iterator<? extends View> r7 = r3.iterator();
    L9:
        if (r7.hasNext() == false) goto L17;
        View r0 = r7.next();
        Integer r1 = this.a.get(r0);
        if (r1 == null) goto L13;
        int r2 = r1.intValue();
    L16:
        r0.setVisibility(r2);
        goto L9
    L13:
        if (r4 == null) goto L15;
        r2 = r4.intValue();
        goto L16
    L15:
        r2 = r0.getVisibility();
        goto L16
    }

    public final void d(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (this.a.containsKey(r3) == true) goto L5;
        this.a.put(r3, Integer.valueOf(r3.getVisibility()));
    L5:
        r3.setVisibility(r4);
    }
}
