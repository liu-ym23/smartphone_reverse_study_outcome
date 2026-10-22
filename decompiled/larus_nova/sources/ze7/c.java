package ze7;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import f06.d;
import java.util.Locale;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f571557a = null;

    static {
        f571557a = Build.MANUFACTURER.toLowerCase(Locale.US);
    }

    public static Intent c(Context r100) {
        Intent r101 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r101.setData(Uri.fromParts("package", r100.getPackageName(), null));
        return r101;
    }

    public static Process b(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r113 = new f06.c();
        Object[] r114 = {r111, null, "title=? ", r112, null};
        f06.b r115 = new f06.b();
        d r100 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
        if (r100.f474982a == false) goto L6;
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, null, "title=? ", r112, null);
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r101, r115, true);
        return r101;
    }
}
