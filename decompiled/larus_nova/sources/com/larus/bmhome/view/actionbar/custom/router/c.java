package com.larus.bmhome.view.actionbar.custom.router;

import com.larus.bmhome.view.actionbar.api.IActionBarProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<b> f315987a = null;

    static {
        ArrayList<b> r100 = CollectionsKt.arrayListOf(new b[]{new e(), new d()});
        Iterator r101 = ServiceManager.get().getServices(IActionBarProvider.class, true).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.addAll(((IActionBarProvider) r101.next()).a());
        goto L4
    L6:
        r100.add(new f());
        r100.add(new a());
        f315987a = r100;
    }
}
