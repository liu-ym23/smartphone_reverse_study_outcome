package uy6;

import com.bytedance.locallife.poi.newdetail.task.TaskStatus;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f552150a = null;

        static {
            int[] r100 = new int[TaskStatus.values().length];
            r100[TaskStatus.FAIL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TaskStatus.NOT_KNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TaskStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f552150a = r100;
        }
    }

    public static final String a(TaskStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f552150a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "fail";
    L5:
        if (r101 != 2) goto L7;
        return "loading";
    L7:
        if (r101 != 3) goto L10;
        return "success";
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
