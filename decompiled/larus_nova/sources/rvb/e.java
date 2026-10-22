package rvb;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class e {
    public static final boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceLang");
        Intrinsics.checkNotNullParameter(r101, "targetLang");
        String r102 = StringsKt.replace$default(StringsKt.trim(r100).toString(), '_', '-', false, 4, null);
        Locale r103 = Locale.ROOT;
        String r104 = r102.toLowerCase(r103);
        String r105 = StringsKt.replace$default(StringsKt.trim(r101).toString(), '_', '-', false, 4, null).toLowerCase(r103);
        if (r104.length() != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L8;
    L52:
        return false;
    L8:
        if (r105.length() != 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L52;
        if (Intrinsics.areEqual(r104, "zhen") == false) goto L16;
    L19:
        boolean r108 = true;
    L20:
        if (r108 == true) goto L52;
        if (Intrinsics.areEqual(r105, "zhen") == false) goto L24;
    L27:
        boolean r109 = true;
    L28:
        if (r109 == true) goto L52;
        if (Intrinsics.areEqual(r104, r105) == false) goto L34;
        return true;
    L34:
        if (Intrinsics.areEqual(r104, "zh") == false) goto L36;
    L39:
        boolean r110 = true;
    L40:
        if (r110 == true) goto L42;
    L50:
        return false;
    L42:
        if (Intrinsics.areEqual(r105, "zh") == false) goto L44;
    L47:
        boolean r111 = true;
    L48:
        if (r111 == false) goto L50;
        return true;
    L44:
        if (StringsKt.startsWith$default(r105, "zh-", false, 2, null) == true) goto L47;
        r111 = false;
        goto L48
    L36:
        if (StringsKt.startsWith$default(r104, "zh-", false, 2, null) == true) goto L39;
        r110 = false;
        goto L40
    L24:
        if (Intrinsics.areEqual(r105, "zh-cn-en-us") == true) goto L27;
        r109 = false;
        goto L28
    L16:
        if (Intrinsics.areEqual(r104, "zh-cn-en-us") == true) goto L19;
        r108 = false;
        goto L20
    L10:
        r107 = false;
        goto L11
    L5:
        r106 = false;
        goto L6
    }

    public static final h b(h r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "sourceContent");
        Intrinsics.checkNotNullParameter(r102, "targetContent");
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L19;
        if (r100.f435227f.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L19;
        if (r100.f435226e.length() <= 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L19;
        String r106 = r100.f435226e;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r100.f435227f = r106;
        goto L19
    L15:
        r105 = false;
        goto L16
    L10:
        r104 = false;
    L19:
        if (r101.length() <= 0) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == true) goto L24;
    L32:
        r100.f435236o = true;
        r100.f435235n = true;
        return r100;
    L24:
        if (r102.length() <= 0) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == false) goto L32;
        if (Intrinsics.areEqual(r101, r102) == true) goto L32;
        r100.f435236o = false;
        r100.f435235n = false;
        return r100;
    L26:
        r108 = false;
        goto L27
    L21:
        r107 = false;
        goto L22
    L5:
        r103 = false;
        goto L6
    }
}
