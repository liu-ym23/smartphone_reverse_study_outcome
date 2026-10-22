package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.lark.pb.videochat_my_ai.NotesBlock;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes34.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f406743a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406744a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f406745b = null;

        static {
            int[] r100 = new int[AINoteContentState.values().length];
            r100[AINoteContentState.USE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L43:
            r100[AINoteContentState.FINISH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L57:
            r100[AINoteContentState.NEED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L45:
            r100[AINoteContentState.NO_NEED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L47:
            r100[AINoteContentState.EDITING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L35:
            r100[AINoteContentState.REVERTED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L14:
            f406744a = r100;
            int[] r101 = new int[NotesBlock.PolishContentState.values().length];
            r101[NotesBlock.PolishContentState.NEED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L53:
            r101[NotesBlock.PolishContentState.NO_NEED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L39:
            r101[NotesBlock.PolishContentState.FINISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L51:
            r101[NotesBlock.PolishContentState.REVERTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L37:
            r101[NotesBlock.PolishContentState.USE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L49:
            r101[NotesBlock.PolishContentState.EDITING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L21:
            f406745b = r101;
        }
    }

    static {
    }

    public static int a(AINoteContentState r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L5:
        switch(r101) {
            case -1: goto L11;
            case 0: goto L7;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        return 1;
    L9:
        return 2;
    L10:
        return 3;
    L11:
        return 0;
    L7:
        throw new NoWhenBranchMatchedException();
    L4:
        r101 = a.f406744a[r100.ordinal()];
        goto L5
    }
}
