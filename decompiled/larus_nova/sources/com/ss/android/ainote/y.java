package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteContentState;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Long, n0> f407234a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f407235a = null;

        static {
            int[] r100 = new int[AINoteContentState.values().length];
            r100[AINoteContentState.USE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[AINoteContentState.FINISH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[AINoteContentState.NEED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[AINoteContentState.NO_NEED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[AINoteContentState.EDITING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[AINoteContentState.REVERTED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f407235a = r100;
        }
    }

    public y() {
        this.f407234a = new LinkedHashMap();
    }

    public static int b(AINoteContentState r100) {
        switch(a.f407235a[r100.ordinal()]) {
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return 1;
    L7:
        return 2;
    L8:
        return 3;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean a(n0 r110) {
        Intrinsics.checkNotNullParameter(r110, "mutation");
        long r100 = r110.f407152a;
        long r111 = r110.f407154c;
        long r112 = r110.f407153b;
        Iterator<T> r113 = this.f407234a.values().iterator();
        Object r114 = null;
    L4:
        if (r113.hasNext() == false) goto L9;
        Object r115 = r113.next();
        if (((n0) r115).a(r100, r111, r112) == false) goto L4;
        r114 = r115;
        goto L4
    L9:
        return Intrinsics.areEqual((n0) r114, r110);
    }
}
