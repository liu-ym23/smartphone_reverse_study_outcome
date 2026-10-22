package cy9;

import android.os.Bundle;
import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static UserCreation f465961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f465962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f465963c;

    static {
    }

    public static void a(Bundle r100) {
        if (r100 == null) goto L6;
        UserCreation r101 = (UserCreation) r100.getParcelable("ai_creation_applet_pending_user_creation");
        if (r101 == null) goto L6;
    L8:
        if (r101 == null) goto L10;
        String r102 = r101.f364987a;
    L11:
        f465963c = r102;
        if (r100 == null) goto L14;
        r100.remove("ai_creation_applet_pending_user_creation");
    L14:
        f465961a = null;
        f465962b = 0;
        return;
    L10:
        r102 = null;
    L6:
        r101 = f465961a;
        goto L8
    }

    public static UserCreation b(Bundle r100) {
        if (f465961a != null) goto L5;
    L7:
        if (r100 == null) goto L11;
        UserCreation r101 = (UserCreation) r100.getParcelable("ai_creation_applet_pending_user_creation");
        if (r101 == null) goto L11;
        return r101;
    L11:
        UserCreation r102 = f465961a;
        if (r102 == null) goto L27;
        String r103 = r102.f364987a;
        if (r103 != null) goto L17;
    L20:
        boolean r104 = true;
    L21:
        if (r104 == true) goto L26;
        if (Intrinsics.areEqual(r103, f465963c) == false) goto L26;
        return null;
    L26:
        return r102;
    L17:
        if (r103.length() == 0) goto L20;
        r104 = false;
        goto L21
    L27:
        return null;
    L5:
        if ((System.currentTimeMillis() - f465962b) <= 1800000) goto L7;
        f465961a = null;
        f465962b = 0;
        goto L7
    }
}
