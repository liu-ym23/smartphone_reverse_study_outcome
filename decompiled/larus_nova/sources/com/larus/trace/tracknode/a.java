package com.larus.trace.tracknode;

import by7.c;
import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface a extends c {

    /* JADX INFO: renamed from: com.larus.trace.tracknode.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes31.dex */
    public static final class C4500a {
        public static void a(a r100, TrackParams r101) {
            Intrinsics.checkNotNullParameter(r101, "params");
            String r102 = r100.k();
            if (r102.length() <= 0) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L9;
            r101.put("current_page", r102);
            return;
        L9:
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    String k();
}
