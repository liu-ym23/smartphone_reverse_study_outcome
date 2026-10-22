package com.larus.im.internal.audio;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f347175a = null;

    static {
        f347175a = new b();
    }

    public b() {
    }

    public final void a(qf9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        Intrinsics.checkNotNullParameter("AVSDK", "<set-?>");
        r100.f532753f = "AVSDK";
        d r101 = new d();
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        r100.f532749b = r101;
        c r102 = new c();
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
        r100.f532750c = r102;
        a r103 = a.f347169a;
        Intrinsics.checkNotNullParameter(r103, "runtime");
        ((ArrayList) r100.f532752e).add(r103);
    }
}
