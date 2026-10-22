package com.bytedance.ee.bear.quoto;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0 {
    public static final List<Integer> a = null;
    public static final List<Integer> b = null;
    public static final List<Integer> c = null;
    public static final List<Integer> d = null;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.quoto.i0$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0138a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[SingleFileQuotaConfig.values().length];
                r0[SingleFileQuotaConfig.UPLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[SingleFileQuotaConfig.DUPLICATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[SingleFileQuotaConfig.SAVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }
    }

    static {
        a = CollectionsKt.listOf(new Integer[]{2131887243, 2131887227, 2131887237});
        b = CollectionsKt.listOf(new Integer[]{2131887234, 2131887230, 2131887232});
        c = CollectionsKt.listOf(new Integer[]{2131887233, 2131887229, 2131887231});
        d = CollectionsKt.listOf(new Integer[]{2131887244, 2131887228, 2131887238});
    }

    @JvmStatic
    public static final String a(Context r3, SingleFileQuotaConfig r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r4 != null) goto L5;
        int r5 = ((Number) ListProtector.get(a, 0)).intValue();
    L16:
        return xo5.a.c(r3, 2131887242, "operation_failed", r3.getString(r5));
    L5:
        int r6 = a.C0138a.a[r4.ordinal()];
        if (r6 != 1) goto L8;
        r5 = ((Number) ListProtector.get(a, 0)).intValue();
        goto L16
    L8:
        if (r6 != 2) goto L10;
        r5 = ((Number) ListProtector.get(a, 1)).intValue();
        goto L16
    L10:
        if (r6 == 3) goto L12;
        r5 = ((Number) ListProtector.get(a, 0)).intValue();
        goto L16
    L12:
        r5 = ((Number) ListProtector.get(a, 2)).intValue();
        goto L16
    }

    @JvmStatic
    public static final String b(Context r3, SingleFileQuotaConfig r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r4 != null) goto L5;
        int r6 = ((Number) ListProtector.get(b, 0)).intValue();
    L16:
        return xo5.a.c(r3, r6, "max_size", r5);
    L5:
        int r7 = a.C0138a.a[r4.ordinal()];
        if (r7 != 1) goto L8;
        r6 = ((Number) ListProtector.get(b, 0)).intValue();
        goto L16
    L8:
        if (r7 != 2) goto L10;
        r6 = ((Number) ListProtector.get(b, 1)).intValue();
        goto L16
    L10:
        if (r7 == 3) goto L12;
        r6 = ((Number) ListProtector.get(b, 0)).intValue();
        goto L16
    L12:
        r6 = ((Number) ListProtector.get(b, 2)).intValue();
        goto L16
    }
}
