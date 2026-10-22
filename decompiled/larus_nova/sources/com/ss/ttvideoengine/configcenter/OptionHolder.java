package com.ss.ttvideoengine.configcenter;

import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class OptionHolder {
    private static final String TAG = "OptionHolder";
    private final Map<Integer, Float> mFloatMap;
    private final Map<Integer, Integer> mIntMap;
    private final Map<Integer, Long> mLongMap;
    private final Map<Integer, String> mStringMap;

    public OptionHolder() {
        this.mIntMap = new ConcurrentHashMap();
        this.mLongMap = new ConcurrentHashMap();
        this.mFloatMap = new ConcurrentHashMap();
        this.mStringMap = new ConcurrentHashMap();
    }

    public void apply(MediaPlayer r100) {
        if (r100 != null) goto L24;
        return;
    L24:
        Iterator<Map.Entry<Integer, Integer>> r101 = this.mIntMap.entrySet().iterator();     // Catch: Exception -> L21
    L6:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<Integer, Integer> r102 = r101.next();     // Catch: Exception -> L21
        r100.setIntOption(r102.getKey().intValue(), r102.getValue().intValue());     // Catch: Exception -> L21
        goto L6
    L8:
        Iterator<Map.Entry<Integer, Long>> r103 = this.mLongMap.entrySet().iterator();     // Catch: Exception -> L21
    L10:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<Integer, Long> r104 = r103.next();     // Catch: Exception -> L21
        r100.setLongOption(r104.getKey().intValue(), r104.getValue().longValue());     // Catch: Exception -> L21
        goto L10
    L12:
        Iterator<Map.Entry<Integer, Float>> r105 = this.mFloatMap.entrySet().iterator();     // Catch: Exception -> L21
    L14:
        if (r105.hasNext() == false) goto L16;
        Map.Entry<Integer, Float> r106 = r105.next();     // Catch: Exception -> L21
        r100.setFloatOption(r106.getKey().intValue(), r106.getValue().floatValue());     // Catch: Exception -> L21
        goto L14
    L16:
        Iterator<Map.Entry<Integer, String>> r107 = this.mStringMap.entrySet().iterator();     // Catch: Exception -> L21
    L17:
        if (r107.hasNext() == false) goto L30;
        Map.Entry<Integer, String> r108 = r107.next();     // Catch: Exception -> L21
        r100.setStringOption(r108.getKey().intValue(), r108.getValue());     // Catch: Exception -> L21
        goto L17
    L30:
        return;
    L21:
        e = move-exception;
        TTVideoEngineLog.e(TAG, e.getMessage());
    }

    public int getIntOption(int r100, int r101) {
        if (this.mIntMap.containsKey(Integer.valueOf(r100)) == false) goto L8;
        Integer r102 = this.mIntMap.get(Integer.valueOf(r100));
        if (r102 == null) goto L8;
        return r102.intValue();
    L8:
        return r101;
    }

    public void setFloatOption(int r100, float r101) {
        this.mFloatMap.put(Integer.valueOf(r100), Float.valueOf(r101));
    }

    public void setIntOption(int r100, int r101) {
        this.mIntMap.put(Integer.valueOf(r100), Integer.valueOf(r101));
    }

    public void setLongOption(int r100, long r101) {
        this.mLongMap.put(Integer.valueOf(r100), Long.valueOf(r101));
    }

    public void setStringOption(int r100, String r101) {
        this.mStringMap.put(Integer.valueOf(r100), r101);
    }
}
