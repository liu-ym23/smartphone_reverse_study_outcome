package com.bytedance.android.livesdk.landscapeslide;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i {
    public static final /* synthetic */ int c = 0;
    public final String a;
    public final MatchMode b;

    public static final class a {
        @JvmStatic
        public static boolean a(List r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "list");
            Intrinsics.checkNotNullParameter(r6, "inputSource");
            Iterator r7 = r5.iterator();
        L4:
            if (r7.hasNext() == false) goto L15;
            i r1 = (i) r7.next();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r6, "inputSource");
            MatchMode r2 = r1.b;
            int r3 = j.a[r2.ordinal()];
            if (r3 != 1) goto L8;
            boolean r4 = Intrinsics.areEqual(r1.a, r6);
        L13:
            if (r4 == false) goto L4;
            return true;
        L8:
            if (r3 != 2) goto L11;
            r4 = Pattern.matches(r1.a, r6);
            goto L13
        L11:
            throw new NoWhenBranchMatchedException();
        L15:
            return false;
        }
    }

    static {
    }

    public i(String r2, MatchMode r3) {
        Intrinsics.checkNotNullParameter(r2, "validSource");
        Intrinsics.checkNotNullParameter(r3, "matchMode");
        this.a = r2;
        this.b = r3;
    }
}
