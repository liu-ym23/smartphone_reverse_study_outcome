package mu4;

import android.content.Context;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.BitableShareParams;
import com.bytedance.ee.bear.share.EShareType;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EShareType.values().length];
            r0[EShareType.DASHBOARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[EShareType.DASHBOARD_REDIRECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[EShareType.FORM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[EShareType.Record.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[EShareType.BASE_ADD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[EShareType.BASE_ADD_SUBMIT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final String a(Context r1, EShareType r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "shareType");
        if (a.a[r2.ordinal()] != 3) goto L6;
        return r1.getString(2131886508);
    L6:
        return r1.getString(2131886827);
    }

    @JvmStatic
    public static final String c(Context r1, EShareType r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "shareType");
        switch(a.a[r2.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L4;
        };
    L4:
        return "";
    L12:
        return r1.getString(2131886743);
    L13:
        return r1.getString(2131886743);
    L14:
        return r1.getString(2131886842);
    L15:
        return r1.getString(2131886532);
    L10:
        return r1.getString(2131886841);
    }

    @JvmStatic
    public static final String b(Context r4, EShareType r5, BitableShareParams r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "shareType");
        Intrinsics.checkNotNullParameter(r6, "params");
        int r7 = a.a[r5.ordinal()];
        if (r7 == 1) goto L12;
        if (r7 == 3) goto L15;
        if (r7 == 4) goto L14;
        return "";
    L14:
        return xo5.a.c(r4, 2131886829, "title", r6.getDocName()) + ' ' + r6.getUrl();
    L15:
        return xo5.a.c(r4, 2131886533, "formName", r6.getDocName()) + ' ' + r6.getUrl();
    L12:
        return xo5.a.c(r4, 2131886399, "dashboardName", r6.getDocName()) + ' ' + r6.getUrl();
    }
}
