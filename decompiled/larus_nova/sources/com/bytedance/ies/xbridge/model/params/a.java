package com.bytedance.ies.xbridge.model.params;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.s;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {
    public static final C3558a Companion = null;

    /* JADX INFO: renamed from: com.bytedance.ies.xbridge.model.params.a$a, reason: collision with other inner class name */
    public static final class C3558a {

        /* JADX INFO: renamed from: com.bytedance.ies.xbridge.model.params.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3559a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f249507a = null;

            static {
                int[] r100 = new int[XReadableType.values().length];
                r100[XReadableType.Int.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[XReadableType.Number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f249507a = r100;
            }
        }

        public C3558a() {
        }

        public static int a(XReadableMap r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "name");
            if (r100.hasKey(r101) == true) goto L6;
            return 0;
        L6:
            if (r100.get(r101).getType() != XReadableType.Int) goto L9;
            return s.d(r100, r101, 0);
        L9:
            if (r100.get(r101).getType() == XReadableType.Number) goto L11;
            return 0;
        L11:
            return (int) s.c(r100, r101, 0);
        }

        public static Long b(C3558a r100, XReadableMap r101, String r102) {
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "params");
            Intrinsics.checkNotNullParameter(r102, "name");
            int r103 = C3559a.f249507a[r101.get(r102).getType().ordinal()];
            if (r103 == 1) goto L9;
            if (r103 == 2) goto L11;
            return null;
        L11:
            return Long.valueOf((long) r101.getDouble(r102));
        L9:
            return Long.valueOf(r101.getInt(r102));
        }
    }

    static {
        Companion = new C3558a();
    }

    public a() {
    }

    public List<String> provideParamList() {
        return CollectionsKt.emptyList();
    }
}
