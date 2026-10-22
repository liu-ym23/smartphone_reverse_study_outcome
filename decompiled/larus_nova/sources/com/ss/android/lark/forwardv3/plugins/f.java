package com.ss.android.lark.forwardv3.plugins;

import androidx.fragment.app.Fragment;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f425505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, i> f425506b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if ((!this.f425506b.isEmpty()) == false) goto L11;
        Iterator r100 = ((LinkedHashMap) this.f425506b).values().iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((i) r100.next()).d();
        goto L6
    L8:
        ((LinkedHashMap) this.f425506b).clear();
        return;
    }

    public f(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "rootFragment");
        this.f425505a = r100;
        this.f425506b = new LinkedHashMap();
    }

    public final i b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L10;
        return null;
    L10:
        if (this.f425506b.containsKey(r100) == true) goto L14;
        Log.e("ForwardPluginManager", "plugin not found or disabled");
        return null;
    L14:
        return (i) ((LinkedHashMap) this.f425506b).get(r100);
    L5:
        r101 = false;
        goto L7
    }

    public final void c(String r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.PLUGIN);
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f425506b.put(r100, r101);
        r101.c();
        return;
    L5:
        r102 = false;
        goto L6
    }
}
