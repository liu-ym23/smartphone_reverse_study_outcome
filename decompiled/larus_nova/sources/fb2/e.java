package fb2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f476259a = 0;

    static {
    }

    @JvmStatic
    public static final String a(IBaseUser r100) {
        int r101 = -1;
        if (r100 == null) goto L5;
        int r102 = r100.getGender();
    L6:
        if (r100 == null) goto L8;
        r101 = r100.getAgeRange();
    L8:
        int r103 = 5;
        if (r102 == 1) goto L37;
        if (r102 == 2) goto L24;
        if (r101 == 0) goto L23;
        if (r101 == 1) goto L22;
        if (r101 == 2) goto L21;
        if (r101 == 3) goto L20;
        if (r101 == 4) goto L19;
        if (r101 == 5) goto L18;
        r103 = 21;
    L50:
        return String.valueOf(r103);
    L18:
        r103 = 20;
        goto L50
    L19:
        r103 = 19;
        goto L50
    L20:
        r103 = 18;
        goto L50
    L21:
        r103 = 17;
        goto L50
    L22:
        r103 = 16;
        goto L50
    L23:
        r103 = 15;
        goto L50
    L24:
        if (r101 == 0) goto L36;
        if (r101 == 1) goto L35;
        if (r101 == 2) goto L34;
        if (r101 == 3) goto L33;
        if (r101 == 4) goto L32;
        if (r101 == 5) goto L31;
        r103 = 14;
        goto L50
    L31:
        r103 = 13;
        goto L50
    L32:
        r103 = 12;
        goto L50
    L33:
        r103 = 11;
        goto L50
    L34:
        r103 = 10;
        goto L50
    L35:
        r103 = 9;
        goto L50
    L36:
        r103 = 8;
        goto L50
    L37:
        if (r101 == 0) goto L48;
        if (r101 == 1) goto L47;
        if (r101 == 2) goto L46;
        if (r101 == 3) goto L45;
        if (r101 == 4) goto L50;
        if (r101 == 5) goto L44;
        r103 = 7;
        goto L50
    L44:
        r103 = 6;
        goto L50
    L45:
        r103 = 4;
        goto L50
    L46:
        r103 = 3;
        goto L50
    L47:
        r103 = 2;
        goto L50
    L48:
        r103 = 1;
        goto L50
    L5:
        r102 = -1;
        goto L6
    }
}
