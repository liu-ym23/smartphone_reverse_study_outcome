package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ KtvComponentSingleBroadcastStrategy a;

    public f(KtvComponentSingleBroadcastStrategy r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        List r7 = (List) r6;
        boolean r0 = true;
        Object r1 = null;
        if (r7 == null) goto L18;
        ArrayList r2 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        T r3 = r8.next();
        if ((!((SongUniqueInfo) r3).isPublic()) == false) goto L6;
        r2.add(r3);
        goto L6
    L10:
        Iterator r9 = r2.iterator();
    L12:
        if (r9.hasNext() == false) goto L16;
        Object r4 = r9.next();
        if (Intrinsics.areEqual(((SongUniqueInfo) r4).getUserId().toString(), gh0.a.c()) == false) goto L12;
        r1 = r4;
    L16:
        r1 = (SongUniqueInfo) r1;
    L18:
        if (r1 != null) goto L21;
        r0 = false;
    L21:
        if (r0 == true) goto L32;
        this.a.b = false;
        return;
    }
}
