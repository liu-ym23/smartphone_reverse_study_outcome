package com.larus.bmhome.view.actionbar.custom;

import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.actionbar.model.ReplyOption;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<rs8.f> f315988a = null;

    static {
        f315988a = new CopyOnWriteArraySet();
    }

    public static void a() {
        Iterator<rs8.f> r100 = f315988a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().q0();
        goto L4
    }

    public static void b(com.larus.bmhome.actionbar.model.z0 r100, ReplyOption r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "targetOption");
        Iterator<rs8.f> r102 = f315988a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().w1(r100, r101);
        goto L4
    }
}
