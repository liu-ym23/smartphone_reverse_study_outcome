package com.larus.navigation.impl.platform;

import androidx.camera.video.AudioStats;
import com.larus.platform.model.GeoLocationInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class j {
    public static final String a(e37.j r100) {
        JSONObject r101 = new JSONObject();
        r101.put("traceName", r100.f470927a);
        r101.put("traceId", r100.f470928b);
        String r102 = r100.f470929c;
        String r103 = null;
        if (r102 != null) goto L5;
    L10:
        String r104 = r100.f470930d;
        if (r104 == null) goto L18;
        if (StringsKt.isBlank(r104) == true) goto L15;
        r103 = r104;
    L15:
        if (r103 == null) goto L18;
        r101.put("widgetInstanceId", r103);
    L18:
        return r101.toString();
    L5:
        if (StringsKt.isBlank(r102) == false) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        r101.put("pageId", r102);
        goto L10
    }

    public static final b37.d b(GeoLocationInfo r110, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        double r100 = r110.getLatitude();
        double r101 = r110.getLongitude();
        double r102 = r110.getAltitude();
        float r103 = r110.getNaviAccuracy();
        float r111 = r110.getSpeed();
        if (r110.getLocationType() != 13) goto L5;
    L8:
        int r112 = 1;
    L10:
        if (r110.getAltitude() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        boolean r104 = true;
    L13:
        boolean r113 = !r104;
        Float r105 = r110.getBearing();
        if (r105 != null) goto L18;
        r105 = r110.getGpsDir();
        if (r105 != null) goto L18;
        float r106 = 0.0f;
    L21:
        if (r110.getLocationTime() <= 0) goto L23;
        long r114 = r110.getLocationTime();
    L24:
        if (r210 == false) goto L26;
        boolean r107 = r110.getValidLatlng();
    L28:
        return new b37.d(r100, r101, r102, r103, r106, r111, r114, r112, r113, r107);
    L26:
        r107 = true;
        goto L28
    L23:
        r114 = r110.getGpsTime();
    L18:
        r106 = r105.floatValue();
        goto L21
    L12:
        r104 = false;
        goto L13
    L5:
        if (r110.getLocationType() == 14) goto L8;
        r112 = r110.getLocationType();
        goto L10
    }
}
