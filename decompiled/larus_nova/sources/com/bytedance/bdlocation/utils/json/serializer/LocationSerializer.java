package com.bytedance.bdlocation.utils.json.serializer;

import android.location.Location;
import android.os.Build;
import com.bytedance.bdlocation.log.Logger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class LocationSerializer implements JsonSerializer<Location> {
    public LocationSerializer() {
    }

    /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
    public JsonElement serialize2(Location r100, Type r101, JsonSerializationContext r102) {
        JsonObject r103 = new JsonObject();
        r103.addProperty("mProvider", r100.getProvider());     // Catch: Exception -> L13
        r103.addProperty("mAccuracy", Float.valueOf(r100.getAccuracy()));     // Catch: Exception -> L13
        r103.addProperty("mAltitude", Double.valueOf(r100.getAltitude()));     // Catch: Exception -> L13
        r103.addProperty("mBearing", Float.valueOf(r100.getBearing()));     // Catch: Exception -> L13
        int r104 = Build.VERSION.SDK_INT;     // Catch: Exception -> L13
        if (r104 < 26) goto L6;
        r103.addProperty("mBearingAccuracyDegrees", Float.valueOf(r100.getBearingAccuracyDegrees()));     // Catch: Exception -> L13
    L6:
        r103.addProperty("mElapsedRealtimeNanos", Long.valueOf(r100.getElapsedRealtimeNanos()));     // Catch: Exception -> L13
        r103.addProperty("mLatitude", Double.valueOf(r100.getLatitude()));     // Catch: Exception -> L13
        r103.addProperty("mLongitude", Double.valueOf(r100.getLongitude()));     // Catch: Exception -> L13
        r103.addProperty("mProvider", r100.getProvider());     // Catch: Exception -> L13
        r103.addProperty("mSpeed", Float.valueOf(r100.getSpeed()));     // Catch: Exception -> L13
        if (r104 < 26) goto L9;
        r103.addProperty("mSpeedAccuracyMetersPerSecond", Float.valueOf(r100.getSpeedAccuracyMetersPerSecond()));     // Catch: Exception -> L13
    L9:
        r103.addProperty("mTime", Long.valueOf(r100.getTime()));     // Catch: Exception -> L13
        if (r104 < 26) goto L15;
        r103.addProperty("mVerticalAccuracyMeters", Float.valueOf(r100.getVerticalAccuracyMeters()));     // Catch: Exception -> L13
    L15:
        return r103;
    L13:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L15
    }

    @Override // com.google.gson.JsonSerializer
    public /* bridge */ /* synthetic */ JsonElement serialize(Location r100, Type r101, JsonSerializationContext r102) {
        return serialize2(r100, r101, r102);
    }
}
