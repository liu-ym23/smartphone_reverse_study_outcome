package com.larus.im.internal.audio.session.omni;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f347329a = null;

    static {
        f347329a = new n();
    }

    public n() {
    }

    public final void a(qf9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        com.larus.im.internal.delegate.e1 r101 = com.larus.im.internal.delegate.f1.f348222a;
        o r102 = o.f347347a;
        Intrinsics.checkNotNullParameter(r102, "injection");
        com.larus.im.internal.delegate.f1.f348222a = r102;
        i0 r103 = new i0();
        Intrinsics.checkNotNullParameter(r103, ShortVideoSegments.KEY_PROP_PROVIDER);
        r100.f532751d = r103;
        r r104 = r.f347373a;
        Intrinsics.checkNotNullParameter(r104, "runtime");
        ((ArrayList) r100.f532752e).add(r104);
    }
}
