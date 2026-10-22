package gu5;

import com.bytedance.ee.util.avatar.BaseAddAvatarUriSettings;
import com.bytedance.ee.util.ui.n;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer[] f482788a = null;

    static {
        f482788a = new Integer[]{32, 48, 64, 96, 128, 320, 640};
    }

    public static String a(String r110, int r111, BaseAddAvatarUriSettings r112) {
        Intrinsics.checkNotNullParameter(r110, "avatarKey");
        Integer r100 = null;
        if (r112 == null) goto L5;
        String[] r101 = r112.b();
    L7:
        if (r101 != null) goto L11;
        tt5.a.k("BaseAddAvatarUtils", "getAvatarUrl failed settingHost isNull " + r110);
        return "";
    L11:
        if (StringsKt.isBlank(r110) == false) goto L14;
        tt5.a.k("BaseAddAvatarUtils", "getAvatarUrl failed avatarKey isBlank");
        return "";
    L14:
        String r113 = r112.a();
        if (r113 != null) goto L17;
        r113 = "/static-resource/avatar";
    L17:
        char r102 = StringsKt.last(r110);
        String r103 = r101[r102 % r101.length];
        int r114 = n.d(r111);
        Integer[] r104 = f482788a;
        int r105 = 0;
    L19:
        if (r105 >= 7) goto L27;
        Integer r106 = r104[r105];
        if (r114 > r106.intValue()) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == true) goto L25;
        r105 = r105 + 1;
        goto L19
    L25:
        r100 = r106;
        goto L27
    L23:
        r107 = false;
    L27:
        if (r100 == null) goto L29;
        int r115 = r100.intValue();
    L30:
        tt5.a.h("BaseAddAvatarUtils", "getAvatarUrl hostsSize=" + r101.length + " suffixCode=" + r102 + " urlSize=" + r115);
        return r103 + r113 + '/' + r110 + '_' + r115 + ".webp";
    L29:
        r115 = r104[6].intValue();
        goto L30
    L5:
        r101 = null;
        goto L7
    }
}
