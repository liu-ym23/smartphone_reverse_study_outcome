package com.ss.ttm.player;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class AJMediaFormat {
    public int channelCount;
    public int colorFormat;
    public int colorTrans;
    public int height;
    private Map<String, Object> map;
    private android.media.MediaFormat mediaFormat;
    public int sampleRate;
    public int sliceHeight;
    public int stride;
    public int width;

    public void reset() {
        this.width = 0;
        this.height = 0;
        this.sampleRate = 0;
        this.channelCount = 0;
        this.colorFormat = 0;
        this.colorTrans = 0;
        this.sliceHeight = 0;
        this.stride = 0;
    }

    public AJMediaFormat() {
        this.mediaFormat = new android.media.MediaFormat();
        this.map = new HashMap();
    }

    public Map<String, Object> getMap() {
        return this.map;
    }

    public android.media.MediaFormat getMediaFormat() {
        return this.mediaFormat;
    }

    public String getString(String r100) {
        return this.mediaFormat.getString(r100);
    }

    public void getOptions(String[] r100, Object[] r101) {
        Iterator<Map.Entry<String, Object>> r102 = this.map.entrySet().iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, Object> r104 = r102.next();
        r100[r103] = r104.getKey();
        r101[r103] = r104.getValue();
        r103 = r103 + 1;
        goto L4
    }

    public void setByteBuffer(String r100, ByteBuffer r101) {
        this.mediaFormat.setByteBuffer(r100, r101);
        this.map.put(r100, r101);
    }

    public void setFeatureEnabled(String r100, boolean r101) {
        setInteger("feature-" + r100, r101 ? 1 : 0);
    }

    public void setInteger(String r100, int r101) {
        this.mediaFormat.setInteger(r100, r101);
        this.map.put(r100, Integer.valueOf(r101));
    }

    public void setString(String r100, String r101) {
        this.mediaFormat.setString(r100, r101);
        this.map.put(r100, r101);
    }
}
