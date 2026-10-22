package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteContentState;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes34.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f406697a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406698a = null;

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
            f406698a = r100;
        }
    }

    static {
    }

    public static int a(AINoteContentState r100) {
        switch(a.f406698a[r100.ordinal()]) {
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
}
