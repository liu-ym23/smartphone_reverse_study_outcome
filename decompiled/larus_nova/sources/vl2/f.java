package vl2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.livesdk.utils.q1;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class f {
    public static m a(String r110, int r111) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110);
        JSONObject r101 = null;
        if (r100.exists() == true) goto L6;
    L7:
        File[] r102 = null;
    L17:
        boolean r103 = true;
    L19:
        if (r103 == false) goto L21;
        return null;
    L21:
        HashMap<String, Bitmap> r104 = new HashMap();
        int r105 = r102.length;
        int r106 = 0;
        boolean r107 = false;
    L22:
        if (r106 >= r105) goto L43;
        File r108 = r102[r106];
        String r109 = r108.getName();
        if (r108.isDirectory() == false) goto L32;
        File[] r112 = r108.listFiles();
        int r113 = r112.length;
        int r114 = 0;
    L26:
        if (r114 >= r113) goto L42;
        File r115 = r112[r114];
        String r116 = r115.getName();
        if (r116.contains(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == false) goto L30;
        r104.put(r116, BitmapFactory.decodeFile(r115.getAbsolutePath()));
    L30:
        r114 = r114 + 1;
    L42:
        r106 = r106 + 1;
        goto L22
    L32:
        if (r109.contains(InvRouter.FLOW_SUFFIX) == false) goto L42;
        if (r107 == true) goto L42;
        PolarisFileInputStreamWrapper r117 = new PolarisFileInputStreamWrapper(r108);     // Catch: Exception -> L40
        BufferedReader r118 = new BufferedReader(new InputStreamReader(r117));     // Catch: Exception -> L40
        StringBuilder r119 = new StringBuilder();     // Catch: Exception -> L40
    L35:
        String r120 = r118.readLine();     // Catch: Exception -> L40
        if (r120 == null) goto L38;
        r119.append(r120);     // Catch: Exception -> L40
        goto L35
    L38:
        r118.close();     // Catch: Exception -> L40
        r117.close();     // Catch: Exception -> L40
        r101 = new JSONObject(r119.toString());     // Catch: Exception -> L40
        r107 = true;
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L43:
        m r121 = new m();
        r121.f555666a = r111;
        r121.f555667b = r110;
        r121.f555668c = r101;
        r121.f555669d = r104;
        return r121;
    L6:
        if (r100.isFile() == true) goto L7;
        r102 = r100.listFiles();
        if (r102 == null) goto L17;
        if (r102.length == 1) goto L45;
    L18:
        r103 = false;
        goto L19
    L45:
        q1.b(r102[0].getPath(), r110);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
