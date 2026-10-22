package q8a;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f532050a = 0;

    static {
    }

    public static boolean b(Object r100) {
        if (r100 == null) goto L24;
        Method[] r101 = r100.getClass().getMethods();
        if (r101 == null) goto L25;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L18;
        Method r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getName(), "getTabLayout") == true) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == true) goto L16;
        r103 = r103 + 1;
        goto L8
    L16:
        boolean r106 = true;
    L19:
        if (r106 != true) goto L26;
        return true;
    L26:
        return false;
    L12:
        if (r104.getParameterCount() != 0) goto L14;
        r105 = true;
        goto L15
    L18:
        r106 = false;
        goto L19
    L25:
        return false;
    L24:
        return false;
    }

    public static void a(Object r100, Object r110) {
        Intrinsics.checkNotNullParameter(r100, "pager");
        Intrinsics.checkNotNullParameter(r110, "tabOwner");
        Method[] r101 = r100.getClass().getMethods();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        Method r104 = null;
        if (r103 >= r102) goto L16;
        Method r105 = r101[r103];
        if (Intrinsics.areEqual(r105.getName(), "setTabLayout") == true) goto L8;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == true) goto L17;
        r103 = r103 + 1;
    L17:
        if (r105 == null) goto L19;
        r105.invoke(r100, new Object[]{r110});
    L19:
        Method[] r111 = r100.getClass().getMethods();
        int r107 = r111.length;
        int r108 = 0;
    L20:
        if (r108 >= r107) goto L30;
        Method r109 = r111[r108];
        if (Intrinsics.areEqual(r109.getName(), "setTabBarElementAdded") == true) goto L24;
    L26:
        boolean r112 = false;
    L27:
        if (r112 == true) goto L28;
        r108 = r108 + 1;
        goto L20
    L28:
        r104 = r109;
        goto L30
    L24:
        if (r109.getParameterCount() != 1) goto L26;
        r112 = true;
    L30:
        if (r104 == null) goto L37;
        r104.invoke(r100, new Object[]{Boolean.FALSE});
        return;
    L37:
        return;
    L8:
        if (r105.getParameterCount() != 1) goto L12;
        if (r105.getParameterTypes()[0].isAssignableFrom(r110.getClass()) == false) goto L12;
        r106 = true;
        goto L13
    L16:
        r105 = null;
        goto L17
    }
}
