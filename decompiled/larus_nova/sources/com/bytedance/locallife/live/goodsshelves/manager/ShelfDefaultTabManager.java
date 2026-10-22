package com.bytedance.locallife.live.goodsshelves.manager;

import com.bytedance.locallife.live.experiment.p0;
import com.bytedance.locallife.live.goodsshelves.bean.ClassifyTabData;
import com.bytedance.locallife.live.goodsshelves.bean.LynxTopbarData;
import com.bytedance.locallife.live.goodsshelves.bean.NewTopBarData;
import com.bytedance.locallife.live.goodsshelves.bean.Tab;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class ShelfDefaultTabManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f259680a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f259681b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f259682c = null;

    static {
        f259680a = LazyKt.lazy(ShelfDefaultTabManager$alwaysAllTabStrategy$2.INSTANCE);
        f259681b = LazyKt.lazy(ShelfDefaultTabManager$allTabPriorityStrategy$2.INSTANCE);
        f259682c = LazyKt.lazy(ShelfDefaultTabManager$guessLikeTabPriorityStrategy$2.INSTANCE);
    }

    public static int b() {
        boolean r100 = false;
        if (p0.b() != 1) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        m r102 = (m) f259681b.getValue();
    L18:
        return r102.getTabId();
    L12:
        if (p0.b() != 3) goto L14;
        r100 = true;
    L14:
        if (r100 == false) goto L16;
        r102 = (m) f259682c.getValue();
        goto L18
    L16:
        r102 = (m) f259680a.getValue();
        goto L18
    L5:
        if (p0.b() == 2) goto L8;
        r101 = false;
        goto L9
    }

    public static int a(LynxTopbarData r100) {
        int r101 = b();
        if (r100 == null) goto L29;
        NewTopBarData r102 = r100.getNewShelf();
        if (r102 == null) goto L30;
        ClassifyTabData r103 = r102.getClassifyTabs();
        if (r103 == null) goto L31;
        List<Tab> r104 = r103.getTabs();
        if (r104 == null) goto L32;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L19;
        Object r106 = r105.next();
        if (((Tab) r106).getId() != r101) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L12;
    L20:
        Tab r108 = (Tab) r106;
        if (r108 != null) goto L23;
        return 1;
    L23:
        return r108.getId();
    L16:
        r107 = false;
        goto L17
    L19:
        r106 = null;
        goto L20
    L32:
        return 1;
    L31:
        return 1;
    L30:
        return 1;
    L29:
        return 1;
    }
}
