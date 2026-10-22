package com.dtf.face.verify;

import android.content.Context;
import android.content.Intent;
import com.dtf.face.log.RecordService;
import com.dtf.face.ui.ToygerLandActivity;
import com.dtf.face.ui.ToygerPortActivity;
import hs7.a;
import java.util.Map;
import js7.b;

/* JADX INFO: loaded from: classes22.dex */
public class DTFaceFacade {
    public static Map<String, Object> S_EXTRAS;

    public static void release() {
        S_EXTRAS = null;
    }

    public DTFaceFacade() {
    }

    public static void startFace(Context r100, Map<String, Object> r101) {
        S_EXTRAS = r101;     // Catch: Throwable -> L40
        Intent r102 = null;
        String r103 = null;
        r103 = null;
        if (r101 == null) goto L30;
        Object r104 = r101.get("ext_params_key_screen_orientation");     // Catch: Throwable -> L40
        if (r104 != null) goto L9;
    L14:
        boolean r105 = false;
    L15:
        boolean r106 = b.g();     // Catch: Throwable -> L40
        if (r105 == true) goto L18;
    L21:
        if (r106 == false) goto L23;
    L22:
        Intent r107 = new Intent(r100, ToygerLandActivity.class);     // Catch: Throwable -> L40
        a.h().f487013y = true;     // Catch: Throwable -> L40
    L24:
        Object r108 = r101.get("comeFrom");     // Catch: Throwable -> L40
        if (r108 != null) goto L27;
    L29:
        Intent r109 = r107;
        String r110 = r103;
        r102 = r109;
    L31:
        if (r102 != null) goto L33;
        r102 = new Intent(r100, ToygerPortActivity.class);     // Catch: Throwable -> L40
        a.h().f487013y = false;     // Catch: Throwable -> L40
    L33:
        if (r110 == null) goto L36;
        r102.putExtra("comeFrom", r110);     // Catch: Throwable -> L40
    L36:
        if (r101.containsKey("isEquipmentCheck") == false) goto L38;
        r102.putExtra("isEquipmentCheck", String.valueOf(r101.get("isEquipmentCheck")));     // Catch: Throwable -> L40
    L38:
        a.h().O = "faceStart";     // Catch: Throwable -> L40
        r100.startActivity(r102);     // Catch: Throwable -> L40
        return;
    L27:
        if ((r108 instanceof String) == false) goto L29;
        r103 = (String) r108;     // Catch: Throwable -> L40
        goto L29
    L23:
        r107 = null;
        goto L24
    L18:
        if (a.h().l() == true) goto L21;
        if (a.h().n() == false) goto L22;
    L9:
        if ((r104 instanceof String) == false) goto L14;
        if ("ext_params_val_screen_land".equals((String) r104) == false) goto L14;
        r105 = true;
        goto L15
    L30:
        r110 = null;
    L40:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    }
}
