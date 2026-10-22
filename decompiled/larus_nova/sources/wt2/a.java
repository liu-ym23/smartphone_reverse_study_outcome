package wt2;

import com.bytedance.android.livesdk.config.cl;
import com.bytedance.android.livesdk.config.n60;
import com.bytedance.android.livesdk.config.uk;
import com.bytedance.android.livesdk.config.uq0;
import com.bytedance.android.livesdk.config.zk;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f561182a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f561183b = null;

    static {
        f561182a = zk.f121772a.getValue();
        f561183b = cl.f119961a.getValue();
    }

    public static boolean g() {
        return uq0.f121394a.getValue().booleanValue();
    }

    public static boolean i() {
        return uk.f121381a.getValue().booleanValue();
    }

    public static int m() {
        return f561182a.intValue();
    }

    public static int n() {
        return f561183b.intValue();
    }

    public static boolean a() {
        if (n() != 1) goto L5;
        return true;
    L5:
        if (n() != 2) goto L7;
        return true;
    L7:
        if (n() != 3) goto L9;
        return true;
    L9:
        if (n() != 4) goto L11;
        return true;
    L11:
        if (i() == true) goto L19;
        return false;
    L19:
        return true;
    }

    public static boolean c() {
        if (m() == 1) goto L7;
        if (m() == 2) goto L7;
    L9:
        return false;
    L7:
        if (h() == true) goto L9;
        return true;
    }

    public static boolean h() {
        if (n() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean j() {
        if (h() == false) goto L5;
    L7:
        return false;
    L5:
        if (m() != 0) goto L7;
        return true;
    }

    public static boolean k() {
        if (m() != 1) goto L5;
        return true;
    L5:
        if (h() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean l() {
        if (h() == false) goto L5;
    L9:
        return false;
    L5:
        if (m() != 2) goto L7;
    L8:
        return true;
    L7:
        if (m() != 3) goto L9;
        goto L8
    }

    public static int o() {
        if (i() == false) goto L7;
        return 13;
    L7:
        if (k() == false) goto L11;
        return 2;
    L11:
        if (j() == false) goto L14;
        return 1;
    L14:
        return 3;
    }

    public static boolean b(Boolean r100) {
        if (r100 != null) goto L5;
        r100 = Boolean.FALSE;
    L5:
        if (h() == false) goto L7;
    L12:
        return true;
    L7:
        if (m() != 4) goto L12;
        if (r100.booleanValue() == true) goto L12;
        return false;
    }

    public static boolean d(Boolean r100) {
        if (r100 != null) goto L5;
        r100 = Boolean.FALSE;
    L5:
        if (f(r100) == true) goto L7;
    L9:
        return false;
    L7:
        if (n60.f120808a.getValue().booleanValue() == false) goto L9;
        return true;
    }

    public static boolean e(Boolean r100) {
        if (r100 != null) goto L5;
        r100 = Boolean.FALSE;
    L5:
        return !r100.booleanValue();
    }

    public static boolean f(Boolean r100) {
        if (r100 != null) goto L5;
        r100 = Boolean.FALSE;
    L5:
        if (h() == false) goto L7;
    L16:
        return true;
    L7:
        if (l() == true) goto L13;
        if (k() == true) goto L13;
        if (i() == true) goto L13;
    L15:
        return false;
    L13:
        if (r100.booleanValue() == true) goto L15;
        goto L15
    }
}
