package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.view.View;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<View, Integer> f230510a;

    public final void a() {
        this.f230510a.clear();
    }

    public final boolean b() {
        return !this.f230510a.isEmpty();
    }

    public q() {
        this.f230510a = new LinkedHashMap();
    }

    public final void c(Iterable<? extends View> r100, Integer r101) {
        if (r100 != null) goto L7;
        Iterator<Map.Entry<View, Integer>> r102 = this.f230510a.entrySet().iterator();
    L5:
        if (r102.hasNext() == false) goto L17;
        Map.Entry<View, Integer> r103 = r102.next();
        r103.getKey().setVisibility(r103.getValue().intValue());
    L17:
        a();
        return;
    L7:
        Iterator<? extends View> r104 = r100.iterator();
    L9:
        if (r104.hasNext() == false) goto L17;
        View r105 = r104.next();
        Integer r106 = this.f230510a.get(r105);
        if (r106 == null) goto L13;
        int r107 = r106.intValue();
    L16:
        r105.setVisibility(r107);
        goto L9
    L13:
        if (r101 == null) goto L15;
        r107 = r101.intValue();
        goto L16
    L15:
        r107 = r105.getVisibility();
        goto L16
    }

    public final void d(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.f230510a.containsKey(r100) == true) goto L5;
        this.f230510a.put(r100, Integer.valueOf(r100.getVisibility()));
    L5:
        r100.setVisibility(r101);
    }
}
