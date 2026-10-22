package com.ss.android.lark.todo.impl.features.center.v3;

import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f441621a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441622a = null;

        static {
            int[] r100 = new int[TaskFieldType.values().length];
            r100[TaskFieldType.CREATE_TIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[TaskFieldType.UPDATE_TIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[TaskFieldType.COMPLETE_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[TaskFieldType.DUE_TIME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[TaskFieldType.START_TIME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[TaskFieldType.TASK_DEFAULT_SORT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f441622a = r100;
        }
    }

    static {
    }

    public i() {
    }

    public static final int a(com.ss.android.lark.todo.impl.features.center.v3.data.f r100, com.ss.android.lark.todo.impl.features.center.v3.data.f r101) {
        int r102 = Intrinsics.compare(r101.f441564d, r100.f441564d);
        if (r102 == 0) goto L5;
        return r102;
    L5:
        return r100.f441561a.compareTo(r101.f441561a);
    }

    public static Comparator b(TaskFieldType r100, boolean r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "sortFieldType");
        Intrinsics.checkNotNullParameter(r102, "sections");
        switch(a.f441622a[r100.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L11;
        };
    L5:
        Intrinsics.checkNotNullParameter(r102, "sections");
        return new m(r102, r101);
    L6:
        Intrinsics.checkNotNullParameter(r102, "sections");
        return new n(r102, r101);
    L7:
        Intrinsics.checkNotNullParameter(r102, "sections");
        return new k(r102, r101);
    L8:
        Intrinsics.checkNotNullParameter(r102, "sections");
        return new j(r102, r101);
    L9:
        Intrinsics.checkNotNullParameter(r102, "sections");
        return new o(r102, r101);
    L10:
        Intrinsics.checkNotNullParameter(r102, "sections");
        return new l(r102, r101);
    L11:
        Intrinsics.checkNotNullParameter(r102, "sections");
        return new l(r102, r101);
    }
}
