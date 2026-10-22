package io.ktor.util.date;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491955a;

    public static final class a {
    }

    static {
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pattern");
        this.f491955a = r100;
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        throw new IllegalStateException("Date parser pattern shouldn't be empty.".toString());
    L5:
        r101 = false;
        goto L6
    }

    public final hsc.a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dateString");
        hsc.b r101 = new hsc.b();
        char r102 = this.f491955a.charAt(0);
        int r103 = 1;
        int r104 = 0;
        int r105 = 0;
    L26:
        if (r103 >= this.f491955a.length()) goto L13;
        if (this.f491955a.charAt(r103) == r102) goto L7;
        int r106 = (r104 + r103) - r105;     // Catch: Throwable -> L23
        a(r101, r102, r100.substring(r104, r106));     // Catch: Throwable -> L23
        r102 = this.f491955a.charAt(r103);     // Catch: Throwable -> L11
        r105 = r103;
        r103 = r103 + 1;
        r104 = r106;
    L11:
        r104 = r106;
        goto L22
    L7:
        r103 = r103 + 1;     // Catch: Throwable -> L23
        goto L26
    L13:
        if (r104 >= r100.length()) goto L15;
        a(r101, r102, r100.substring(r104));     // Catch: Throwable -> L23
    L15:
        Integer r107 = r101.f487090a;
        Intrinsics.checkNotNull(r107);
        int r108 = r107.intValue();
        Integer r109 = r101.f487091b;
        Intrinsics.checkNotNull(r109);
        int r110 = r109.intValue();
        Integer r111 = r101.f487092c;
        Intrinsics.checkNotNull(r111);
        int r112 = r111.intValue();
        Integer r113 = r101.f487093d;
        Intrinsics.checkNotNull(r113);
        int r114 = r113.intValue();
        Month r115 = r101.f487094e;
        if (r115 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH);
        r115 = null;
    L19:
        Month r116 = r115;
        Integer r117 = r101.f487095f;
        Intrinsics.checkNotNull(r117);
        return io.ktor.util.date.a.a(r108, r110, r112, r114, r116, r117.intValue());
    L22:
        throw new InvalidDateStringException(r100, r104, this.f491955a);
    }

    public static void a(hsc.b r100, char r101, String r102) {
        if (r101 != 's') goto L6;
        r100.f487090a = Integer.valueOf(CastIntegerProtector.parseInt(r102));
        return;
    L6:
        if (r101 != 'm') goto L9;
        r100.f487091b = Integer.valueOf(CastIntegerProtector.parseInt(r102));
        return;
    L9:
        if (r101 != 'h') goto L12;
        r100.f487092c = Integer.valueOf(CastIntegerProtector.parseInt(r102));
        return;
    L12:
        if (r101 != 'd') goto L14;
        r100.f487093d = Integer.valueOf(CastIntegerProtector.parseInt(r102));
        return;
    L14:
        int r103 = 0;
        if (r101 != 'M') goto L28;
        Month.Companion.getClass();
        Intrinsics.checkNotNullParameter(r102, "value");
        Month[] r104 = Month.values();
        int r105 = r104.length;
    L17:
        if (r103 >= r105) goto L22;
        Month r106 = r104[r103];
        if (Intrinsics.areEqual(r106.getValue(), r102) == true) goto L23;
        r103 = r103 + 1;
    L23:
        if (r106 == null) goto L26;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r100.f487094e = r106;
        return;
    L26:
        throw new IllegalStateException(("Invalid month: " + r102).toString());
    L22:
        r106 = null;
        goto L23
    L28:
        if (r101 != 'Y') goto L31;
        r100.f487095f = Integer.valueOf(CastIntegerProtector.parseInt(r102));
        return;
    L31:
        if (r101 != 'z') goto L38;
        if (Intrinsics.areEqual(r102, "GMT") == false) goto L36;
        return;
    L36:
        throw new IllegalStateException("Check failed.".toString());
    L38:
        if (r101 == '*') goto L64;
        int r107 = 0;
    L40:
        boolean r108 = true;
        if (r107 >= r102.length()) goto L49;
        if (r102.charAt(r107) == r101) goto L46;
        r108 = false;
    L46:
        if (r108 == false) goto L50;
        r107 = r107 + 1;
    L50:
        if (r103 == 0) goto L53;
        return;
    L53:
        throw new IllegalStateException("Check failed.".toString());
    L49:
        r103 = 1;
        goto L50
    }
}
