package u2;

import com.bytedance.ai.applet.granting.GrantStatus;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f548392a = null;

        static {
            int[] r100 = new int[GrantStatus.values().length];
            r100[GrantStatus.PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[GrantStatus.GRANTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[GrantStatus.DENIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[GrantStatus.REVOKED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f548392a = r100;
        }
    }

    public static final int a(GrantStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f548392a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 0;
    L5:
        if (r101 != 2) goto L7;
        return 1;
    L7:
        if (r101 != 3) goto L9;
        return 2;
    L9:
        if (r101 != 4) goto L12;
        return 3;
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
