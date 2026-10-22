package ac5;

import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final String a(int r1) {
        if (r1 != NavigationEnum.MY_SPACE.id) goto L6;
        return "personal";
    L6:
        if (r1 != NavigationEnum.SHARED_SPACE.id) goto L9;
        return "shared";
    L9:
        if (r1 != NavigationEnum.FAVORITE.id) goto L12;
        return "favorites";
    L12:
        if (r1 != NavigationEnum.MANUAL_OFFLINE.id) goto L14;
        return "offline";
    L14:
        return "";
    }
}
