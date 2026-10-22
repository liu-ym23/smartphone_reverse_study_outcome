package com.bytedance.bdlocation.utils.json.deserializer;

import android.location.Location;
import android.os.Build;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class LocationDeserializer implements JsonDeserializer<Location> {
    public LocationDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Location deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        JsonObject r103 = r100.getAsJsonObject();
        Location r104 = new Location(r103.getAsJsonPrimitive("mProvider").getAsString());
        r104.setAccuracy(r103.getAsJsonPrimitive("mAccuracy").getAsFloat());
        r104.setAltitude(r103.getAsJsonPrimitive("mAltitude").getAsFloat());
        r104.setBearing(r103.getAsJsonPrimitive("mBearing").getAsFloat());
        int r105 = Build.VERSION.SDK_INT;
        if (r105 < 26) goto L5;
        r104.setBearingAccuracyDegrees(r103.getAsJsonPrimitive("mBearingAccuracyDegrees").getAsFloat());
    L5:
        r104.setElapsedRealtimeNanos(r103.getAsJsonPrimitive("mElapsedRealtimeNanos").getAsLong());
        r104.setLatitude(r103.getAsJsonPrimitive("mLatitude").getAsDouble());
        r104.setLongitude(r103.getAsJsonPrimitive("mLongitude").getAsDouble());
        r104.setProvider(r103.getAsJsonPrimitive("mProvider").getAsString());
        r104.setSpeed(r103.getAsJsonPrimitive("mSpeed").getAsFloat());
        if (r105 < 26) goto L8;
        r104.setSpeedAccuracyMetersPerSecond(r103.getAsJsonPrimitive("mSpeedAccuracyMetersPerSecond").getAsFloat());
    L8:
        r104.setTime(r103.getAsJsonPrimitive("mTime").getAsLong());
        if (r105 < 26) goto L11;
        r104.setVerticalAccuracyMeters(r103.getAsJsonPrimitive("mVerticalAccuracyMeters").getAsFloat());
    L11:
        return r104;
    }

    @Override // com.google.gson.JsonDeserializer
    public /* bridge */ /* synthetic */ Location deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        return deserialize(r100, r101, r102);
    }
}
