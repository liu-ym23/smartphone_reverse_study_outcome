package com.ss.ttvideoengine.model;

import com.ss.ttvideoengine.Resolution;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IVideoInfo {
    int fromMediaInfoJsonObject(JSONObject r100);

    MediaBitrateFitterInfo getBitrateFitterInfo();

    int getMediatype();

    Resolution getResolution();

    boolean getValueBool(int r100);

    float getValueFloat(int r100);

    int getValueInt(int r100);

    long getValueLong(int r100);

    String getValueStr(int r100);

    String[] getValueStrArr(int r100);

    JSONObject toBashJsonObject();

    Map<String, Object> toMediaInfo();
}
