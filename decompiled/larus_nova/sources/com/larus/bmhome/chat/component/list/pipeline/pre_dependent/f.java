package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.larus.extension.offline_message.api.OfflineMessageServiceDelegate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f301205a;

    public static final class a {
    }

    static {
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return true;
    }

    public f(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContextTask");
        this.f301205a = r100;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r100, xc8.b r101, xc8.b r102, List<xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        OfflineMessageServiceDelegate.f342907b.d(this.f301205a.o());
        return r103;
    }
}
