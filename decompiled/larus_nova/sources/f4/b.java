package f4;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f475436a = null;

    static {
        f475436a = new b();
    }

    public b() {
    }

    public static String a(Context r100, Set r110) {
        if (Build.VERSION.SDK_INT < 33) goto L41;
        List r101 = CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO});
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Object r104 = r103.next();
        if (r110.contains((String) r104) == false) goto L6;
        r102.add(r104);
        goto L6
    L10:
        boolean r105 = false;
        if (Build.VERSION.SDK_INT >= 34) goto L13;
    L15:
        boolean r111 = false;
    L17:
        if (r102.isEmpty() == false) goto L21;
        if (r111 == true) goto L21;
        return null;
    L21:
        if ((!r102.isEmpty()) == true) goto L23;
    L34:
        if (r111 == true) goto L36;
    L39:
        return "denied";
    L36:
        if (d(r100, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L39;
        return "limited";
    L23:
        if (r102.isEmpty() == true) goto L31;
        Iterator r106 = r102.iterator();
    L27:
        if (r106.hasNext() == false) goto L31;
        String r107 = (String) r106.next();
        f475436a.getClass();
        if (d(r100, r107) == true) goto L27;
    L32:
        if (r105 == false) goto L34;
        return "full";
    L31:
        r105 = true;
        goto L32
    L13:
        if (r110.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L15;
        r111 = true;
        goto L17
    L41:
        if (r110.contains("android.permission.READ_EXTERNAL_STORAGE") == false) goto L47;
        if (d(r100, "android.permission.READ_EXTERNAL_STORAGE") == false) goto L56;
        return "full";
    L56:
        return "denied";
    L47:
        return null;
    }

    public static c c(Context r100, Set r101) {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        List r102 = CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"});
    L6:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (r101.contains((String) r105) == false) goto L8;
        r103.add(r105);
        goto L8
    L12:
        int r106 = 0;
        if (r103.isEmpty() == true) goto L23;
        Iterator r107 = r103.iterator();
    L17:
        if (r107.hasNext() == false) goto L23;
        String r108 = (String) r107.next();
        f475436a.getClass();
        if (d(r100, r108) == false) goto L17;
        r106 = r106 + 1;
        if (r106 >= 0) goto L17;
        CollectionsKt.throwCountOverflow();
    L23:
        String r109 = "denied";
        if ((!r103.isEmpty()) == true) goto L26;
    L28:
        String r110 = "denied";
    L30:
        if (r103.isEmpty() == false) goto L33;
        r109 = null;
    L38:
        return new c(r110, r109);
    L33:
        if (r106 != r103.size()) goto L35;
        r109 = "full";
        goto L38
    L35:
        if (r106 <= 0) goto L38;
        r109 = "partial";
        goto L38
    L26:
        if (r106 != r103.size()) goto L28;
        r110 = "authorized";
        goto L30
    L5:
        r102 = CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"});
        goto L6
    }

    public static boolean d(Context r100, String r101) {
        if (ContextCompat.checkSelfPermission(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static c e(Context r100, Set r110) {
        Set r101 = SetsKt.setOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"});
        boolean r102 = d(r100, "android.permission.ACCESS_COARSE_LOCATION");
        boolean r103 = d(r100, "android.permission.ACCESS_FINE_LOCATION");
        boolean r104 = false;
        boolean r105 = true;
        if (r102 == true) goto L7;
        if (r103 == true) goto L7;
        boolean r106 = false;
    L9:
        if (r106 == false) goto L11;
        String r107 = "authorized";
    L12:
        Set r111 = r110;
        if ((r111 instanceof Collection) == true) goto L15;
    L17:
        Iterator r112 = r111.iterator();
    L19:
        if (r112.hasNext() == false) goto L23;
        if (r101.contains((String) r112.next()) == false) goto L19;
    L24:
        if (r104 == true) goto L26;
        if (r106 == true) goto L31;
        return new c(r107, "denied");
    L31:
        if (Build.VERSION.SDK_INT < 29) goto L33;
        r105 = d(r100, "android.permission.ACCESS_BACKGROUND_LOCATION");
    L33:
        if (r105 == false) goto L36;
        if (r103 == false) goto L36;
        String r108 = "background precise";
    L42:
        return new c(r107, r108);
    L36:
        if (r105 == false) goto L38;
        r108 = "background approximate";
        goto L42
    L38:
        if (r103 == false) goto L40;
        r108 = "foreground precise";
        goto L42
    L40:
        r108 = "foreground approximate";
        goto L42
    L26:
        return new c(r107, null);
    L23:
        r104 = true;
        goto L24
    L15:
        if (r111.isEmpty() == false) goto L17;
    L11:
        r107 = "denied";
    L7:
        r106 = true;
        goto L9
    }

    public static c b(Context r100, Set r101, String r102) {
        boolean r103 = d(r100, r102);
        String r104 = "denied";
        if (r103 == false) goto L5;
        String r105 = "authorized";
    L7:
        if (r101.contains(r102) == true) goto L9;
        r104 = null;
    L12:
        return new c(r105, r104);
    L9:
        if (r103 == false) goto L12;
        r104 = "full";
        goto L12
    L5:
        r105 = "denied";
        goto L7
    }
}
