package com.ss.android.lark.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.bytedance.supervisor.token.Token;
import com.ss.android.download.api.constant.BaseConstants;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public final class StoragePermissionUtils {

    public @interface PartialPermissionState {
    }

    public @interface StoragePermissions {
    }

    public interface a {
        void b(c r100);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f438542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f438543b;

        public b(String[] r100) {
            this.f438543b = r100;
            if (r100.length != 0) goto L5;
            boolean r101 = true;
        L6:
            this.f438542a = r101;
            return;
        L5:
            r101 = false;
            goto L6
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f438544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f438545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f438546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f438547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, Boolean> f438548e;

        public final String toString() {
            StringBuilder r100 = new StringBuilder("StoragePermissionState { image: ");
            int r101 = this.f438544a;
            String r102 = "NO_PERMISSION";
            if (r101 != 0) goto L5;
            String r103 = "FULL_PERMISSION";
        L10:
            r100.append(r103);
            r100.append(", video: ");
            int r104 = this.f438545b;
            if (r104 != 0) goto L13;
            r102 = "FULL_PERMISSION";
        L18:
            r100.append(r102);
            r100.append(", audio: ");
            r100.append(this.f438546c);
            r100.append(", writeMedia: ");
            r100.append(this.f438547d);
            r100.append(" }");
            return r100.toString();
        L13:
            if (r104 != 1) goto L15;
            r102 = "PARTIAL_PERMISSION";
            goto L18
        L15:
            if (r104 == 2) goto L18;
            r102 = "UNKNOWN";
            goto L18
        L5:
            if (r101 != 1) goto L7;
            r103 = "PARTIAL_PERMISSION";
            goto L10
        L7:
            if (r101 != 2) goto L9;
            r103 = "NO_PERMISSION";
            goto L10
        L9:
            r103 = "UNKNOWN";
            goto L10
        }

        public c(Context r100, String... r101) {
            this.f438548e = new HashMap();
            this.f438544a = StoragePermissionUtils.a(r100, StoragePermissionUtils.d(r100, 2));
            this.f438545b = StoragePermissionUtils.a(r100, StoragePermissionUtils.d(r100, 4));
            this.f438546c = StoragePermissionUtils.d(r100, 8);
            this.f438547d = StoragePermissionUtils.e(r100);
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            String r104 = r101[r103];
            Map<String, Boolean> r105 = this.f438548e;
            HashMap r106 = (HashMap) r105;
            r106.put(r104, Boolean.valueOf(com.ss.android.lark.permission.a.a(r100, r104)));
            r103 = r103 + 1;
            goto L3
        }
    }

    public static boolean b() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 30) goto L6;
        return true;
    L6:
        if (r100 >= 29) goto L15;
    L13:
        return false;
    L15:
        if (Environment.isExternalStorageLegacy() == true) goto L13;
        return true;
    L11:
        if (Build.VERSION.SDK_INT < 30) goto L13;
        return true;
    }

    public static boolean e(Context r100) {
        return d(r100, 16);
    }

    public static int a(Context r100, boolean r101) {
        if (r101 == false) goto L5;
        return 0;
    L5:
        if (com.ss.android.lark.permission.a.a(r100, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L7;
        return 1;
    L7:
        return 2;
    }

    public static boolean d(Context r100, int r101) {
        b r102 = c(r100, r101, new String[0]);
        if (r102.f438542a == false) goto L5;
    L4:
        return true;
    L5:
        String[] r103 = r102.f438543b;
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L4;
        if (com.ss.android.lark.permission.a.a(r100, r103[r105]) == false) goto L14;
        r105 = r105 + 1;
        goto L6
    L14:
        return false;
    }

    public static b c(Context r100, int r101, String... r110) {
        boolean r102 = b();
        boolean r103 = true;
        if ((r101 & 32) == 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L66;
    L18:
        boolean r105 = false;
    L20:
        if (Build.VERSION.SDK_INT >= 33) goto L22;
    L24:
        boolean r106 = false;
    L26:
        if ((r101 & 16) == 0) goto L28;
        boolean r107 = true;
    L30:
        if ((r101 & 2) == 0) goto L32;
        boolean r108 = true;
    L34:
        if ((r101 & 4) == 0) goto L36;
        boolean r109 = true;
    L38:
        if ((r101 & 8) == 0) goto L40;
        boolean r111 = true;
    L41:
        if (r108 == true) goto L45;
        if (r109 == true) goto L45;
        boolean r112 = false;
    L46:
        if (r112 == true) goto L50;
        if (r111 == true) goto L50;
        r103 = false;
    L50:
        ArrayList r113 = new ArrayList();
        if (r107 == false) goto L54;
        if (r102 == true) goto L54;
        r113.add("android.permission.WRITE_EXTERNAL_STORAGE");
    L54:
        if (r106 == false) goto L61;
        if (r108 == false) goto L57;
        r113.add(BaseConstants.PERMISSION_READ_MEDIA_IMAGES);
    L57:
        if (r109 == false) goto L59;
        r113.add(BaseConstants.PERMISSION_READ_MEDIA_VIDEO);
    L59:
        if (r111 == false) goto L64;
        r113.add(BaseConstants.PERMISSION_READ_MEDIA_AUDIO);
    L64:
        r113.addAll(Arrays.asList(r110));
        return new b((String[]) r113.toArray(new String[0]));
    L61:
        if (r103 == true) goto L63;
        if (r105 == false) goto L64;
    L63:
        r113.add("android.permission.READ_EXTERNAL_STORAGE");
    L45:
        r112 = true;
        goto L46
    L40:
        r111 = false;
        goto L41
    L36:
        r109 = false;
        goto L38
    L32:
        r108 = false;
        goto L34
    L28:
        r107 = false;
        goto L30
    L22:
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L24;
        r106 = true;
        goto L26
    L66:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        if (Environment.isExternalStorageLegacy() == true) goto L12;
    L11:
        boolean r114 = true;
    L16:
        if (r114 == true) goto L18;
        r105 = true;
    L12:
        r114 = false;
    L14:
        if (Build.VERSION.SDK_INT < 30) goto L12;
    L5:
        r104 = false;
        goto L6
    }

    public static void f(final Activity r100, final a r101, int r102, Token r103, final String... r104) {
        b r105 = c(r100, r102, r104);
        if (r105.f438542a == false) goto L5;
        r101.b(new c(r100, r104));
        return;
    L5:
        String[] r106 = r105.f438543b;
        o0c.c r107 = new o0c.c(r100);
        Observable.just(o0c.c.f521655b).compose(r107.c(r103, true, r106)).subscribe(new n0c.c(r101, r100, r104));
    }
}
