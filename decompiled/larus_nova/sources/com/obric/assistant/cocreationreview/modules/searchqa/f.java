package com.obric.assistant.cocreationreview.modules.searchqa;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.entity.IObricEntityNavigationService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class f {
    public static final boolean a(s r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.f387585f;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L30;
        String r104 = r100.f387583d;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L31;
        String r106 = r100.f387584e;
        if (r106 != null) goto L21;
    L24:
        if (r102 == true) goto L33;
        IObricEntityNavigationService r107 = (IObricEntityNavigationService) ServiceManager.get().getService(IObricEntityNavigationService.class);
        if (r107 != null) goto L29;
        return false;
    L29:
        return r107.b(r100.f387583d);
    L33:
        return false;
    L21:
        if (StringsKt.isBlank(r106) == true) goto L24;
        r102 = false;
        goto L24
    L31:
        return false;
    L13:
        if (StringsKt.isBlank(r104) == true) goto L16;
        r105 = false;
        goto L17
    L30:
        return false;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r103 = false;
        goto L9
    }

    public static final boolean b(s r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((!r100.f387588i.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!r100.f387587h.isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static final boolean c(s r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.f387585f;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L29;
        String r103 = r100.f387583d;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L29;
        String r105 = r100.f387584e;
        if (r105 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L29;
        if (a(r100) == true) goto L29;
        return true;
    L21:
        if (StringsKt.isBlank(r105) == true) goto L24;
        r106 = false;
        goto L25
    L13:
        if (StringsKt.isBlank(r103) == true) goto L16;
        r104 = false;
    L29:
        return false;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final void d(s r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        IObricEntityNavigationService r101 = (IObricEntityNavigationService) ServiceManager.get().getService(IObricEntityNavigationService.class);
        if (r101 == null) goto L16;
        String r102 = r100.f387585f;
        String r103 = "";
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        String r104 = r100.f387583d;
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        String r105 = r100.f387584e;
        if (r105 == null) goto L14;
        r103 = r105;
    L14:
        r101.e(r102, r104, r103);
        return;
    }

    public static final void e(s r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        IObricEntityNavigationService r101 = (IObricEntityNavigationService) ServiceManager.get().getService(IObricEntityNavigationService.class);
        if (r101 == null) goto L6;
        r101.a(h(r100));
        return;
    }

    public static final List<zda.c> h(s r110) {
        if ((!r110.f387588i.isEmpty()) == false) goto L9;
        List<r> r111 = r110.f387588i;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L6:
        if (r112.hasNext() == false) goto L8;
        r r101 = (r) r112.next();
        r100.add(new zda.c(r101.f387574a, r101.f387575b, r101.f387576c, r101.f387577d, r101.f387578e, r101.f387579f));
        goto L6
    L8:
        return r100;
    L9:
        List<String> r113 = r110.f387587h;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r114 = r113.iterator();
    L11:
        if (r114.hasNext() == false) goto L13;
        r102.add(new zda.c((String) r114.next(), null, null, null, null, false));
        goto L11
    L13:
        return r102;
    }

    public static final void f(Context r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "reference");
        String r102 = r101.f387589j;
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (StringsKt.isBlank(r102) == false) goto L8;
        return;
    L8:
        IObricEntityNavigationService r103 = (IObricEntityNavigationService) ServiceManager.get().getService(IObricEntityNavigationService.class);
        if (r103 == null) goto L12;
        r103.d(r100, r102);
        return;
    }

    public static final View g(Context r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "reference");
        IObricEntityNavigationService r102 = (IObricEntityNavigationService) ServiceManager.get().getService(IObricEntityNavigationService.class);
        if (r102 == null) goto L5;
        RecyclerView r103 = r102.c(r100, h(r101));
    L6:
        if (r103 == null) goto L8;
        return r103;
    L8:
        return new View(r100);
    L5:
        r103 = null;
        goto L6
    }
}
