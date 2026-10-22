package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class WXLocationObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXLocationObject";
    public double lat;
    public double lng;

    public WXLocationObject() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public WXLocationObject(double r100, double r101) {
        this.lat = r100;
        this.lng = r101;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putDouble("_wxlocationobject_lat", this.lat);
        r100.putDouble("_wxlocationobject_lng", this.lng);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 30;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.lat = r100.getDouble("_wxlocationobject_lat");
        this.lng = r100.getDouble("_wxlocationobject_lng");
    }
}
