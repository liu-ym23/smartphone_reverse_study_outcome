package com.larus.home.impl.sdk;

import com.larus.perfdegrade.api.IPerfDegradeAbility;
import com.larus.perfdegrade.api.model.PerfDegradeScrollEvent;
import com.larus.perfdegrade.api.model.PerfDegradeType;
import com.larus.platform.api.ISdkPerfDegradeService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class z1 implements ISdkPerfDegradeService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z1 f346274a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f346275a = null;

        static {
            int[] r100 = new int[ISdkPerfDegradeService.ScrollState.values().length];
            r100[ISdkPerfDegradeService.ScrollState.DRAGGING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ISdkPerfDegradeService.ScrollState.SETTLING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ISdkPerfDegradeService.ScrollState.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ISdkPerfDegradeService.ScrollState.DETACH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f346275a = r100;
        }
    }

    static {
        f346274a = new z1();
    }

    public z1() {
    }

    @Override // com.larus.platform.api.ISdkPerfDegradeService
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return IPerfDegradeAbility.f363951a.c(PerfDegradeType.SCROLL_JANK, r100);
    }

    @Override // com.larus.platform.api.ISdkPerfDegradeService
    public final void a(String r100, String r101, ISdkPerfDegradeService.ScrollState r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "targetId");
        Intrinsics.checkNotNullParameter(r102, "state");
        IPerfDegradeAbility.Companion r103 = IPerfDegradeAbility.f363951a;
        PerfDegradeType r104 = PerfDegradeType.SCROLL_JANK;
        int r105 = a.f346275a[r102.ordinal()];
        if (r105 != 1) goto L5;
        PerfDegradeScrollEvent.ScrollState r106 = PerfDegradeScrollEvent.ScrollState.DRAGGING;
    L16:
        r103.b(new PerfDegradeScrollEvent(r104, r100, r101, r106));
        return;
    L5:
        if (r105 != 2) goto L7;
        r106 = PerfDegradeScrollEvent.ScrollState.SETTLING;
        goto L16
    L7:
        if (r105 != 3) goto L9;
        r106 = PerfDegradeScrollEvent.ScrollState.IDLE;
        goto L16
    L9:
        if (r105 != 4) goto L12;
        r106 = PerfDegradeScrollEvent.ScrollState.DETACH;
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
