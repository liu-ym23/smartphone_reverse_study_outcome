package com.larus.bmhome.chat.camera.command;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.platform.model.action.SuggestedAction;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, t> f297601a = null;

    static {
        f297601a = new ConcurrentHashMap();
    }

    public static void b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        f297601a.remove(r100);
        return;
    L11:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static String a(CameraOutputContext r100, SuggestedAction r101) {
        Intrinsics.checkNotNullParameter(r100, "outputContext");
        long r102 = System.currentTimeMillis();
        ConcurrentHashMap<String, t> r103 = f297601a;
        CollectionsKt.removeAll(r103.entrySet(), new j(r102));
        String r104 = UUID.randomUUID().toString();
        r103.put(r104, new t.a(r100, r101, System.currentTimeMillis()));
        return r104;
    }
}
