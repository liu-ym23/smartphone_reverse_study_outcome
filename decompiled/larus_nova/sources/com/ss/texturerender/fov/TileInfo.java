package com.ss.texturerender.fov;

import android.util.Pair;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class TileInfo {
    int backgroundTileHeightCount;
    int backgroundTileWidthCount;
    int dstTileHeightCount;
    int dstTileWidthCount;
    LinkedList<Pair<Integer, Integer>> mappedBackgroundIndexPairs;
    LinkedList<Pair<Integer, Integer>> mappedOverlayIndexPairs;
    float normalizedBackgroundTileHeight;
    float normalizedBackgroundTileWidth;
    float normalizedDstTileHeight;
    float normalizedDstTileWidth;
    float normalizedSrcTileHeight;
    float normalizedSrcTileWidth;
    public int paddingY;
    int srcTileHeightCount;
    int srcTileWidthCount;
    int streamIndex;
    int tileHeight;
    int tileWidth;
    JSONArray visibleArray;

    public TileInfo() {
    }

    public int getBackgroundTexHeight() {
        return this.tileHeight * this.backgroundTileHeightCount;
    }

    public int getBackgroundTexWidth() {
        return this.tileWidth * this.backgroundTileWidthCount;
    }

    public int getDecodedFrameHeight() {
        return this.tileHeight * this.srcTileHeightCount;
    }

    public int getDecodedFrameWidth() {
        return this.tileWidth * this.srcTileWidthCount;
    }

    public boolean is3DInput() {
        if (this.tileHeight < (this.tileWidth * 2)) goto L5;
        return true;
    L5:
        return false;
    }

    public static TileInfo create(String r100) {
        if (r100 != null) goto L5;
    L21:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L21;
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L19
        TileInfo r102 = new TileInfo();     // Catch: JSONException -> L19
        r102.streamIndex = JSONObjectProtectorUtils.getInt(r101, "stream_index");     // Catch: JSONException -> L19
        r102.tileWidth = JSONObjectProtectorUtils.getInt(r101, "tile_width");     // Catch: JSONException -> L19
        r102.tileHeight = JSONObjectProtectorUtils.getInt(r101, "tile_height");     // Catch: JSONException -> L19
        r102.srcTileWidthCount = JSONObjectProtectorUtils.getInt(r101, "tile_width_count");     // Catch: JSONException -> L19
        int r103 = JSONObjectProtectorUtils.getInt(r101, "tile_height_count");     // Catch: JSONException -> L19
        r102.srcTileHeightCount = r103;     // Catch: JSONException -> L19
        r102.normalizedSrcTileWidth = 1.0f / r102.srcTileWidthCount;     // Catch: JSONException -> L19
        r102.normalizedSrcTileHeight = 1.0f / r103;     // Catch: JSONException -> L19
        r102.dstTileWidthCount = JSONObjectProtectorUtils.getInt(r101, "source_tile_width_count");     // Catch: JSONException -> L19
        int r104 = JSONObjectProtectorUtils.getInt(r101, "source_tile_height_count");     // Catch: JSONException -> L19
        r102.dstTileHeightCount = r104;     // Catch: JSONException -> L19
        r102.normalizedDstTileWidth = 1.0f / r102.dstTileWidthCount;     // Catch: JSONException -> L19
        r102.normalizedDstTileHeight = 1.0f / r104;     // Catch: JSONException -> L19
        r102.visibleArray = JSONObjectProtectorUtils.getJSONArray(r101, "tile_visible");     // Catch: JSONException -> L19
        r102.backgroundTileWidthCount = JSONObjectProtectorUtils.getInt(r101, "bg_tile_width_count");     // Catch: JSONException -> L19
        int r105 = JSONObjectProtectorUtils.getInt(r101, "bg_tile_height_count");     // Catch: JSONException -> L19
        r102.backgroundTileHeightCount = r105;     // Catch: JSONException -> L19
        r102.normalizedBackgroundTileWidth = 1.0f / r102.backgroundTileWidthCount;     // Catch: JSONException -> L19
        r102.normalizedBackgroundTileHeight = 1.0f / r105;     // Catch: JSONException -> L19
        r102.paddingY = r102.tileHeight % r102.tileWidth;     // Catch: JSONException -> L19
        LinkedList<Pair<Integer, Integer>> r106 = new LinkedList();     // Catch: JSONException -> L19
        LinkedList<Pair<Integer, Integer>> r107 = new LinkedList();     // Catch: JSONException -> L19
        int r108 = r102.backgroundTileWidthCount * r102.backgroundTileHeightCount;     // Catch: JSONException -> L19
        int r109 = 0;
    L9:
        if (r109 >= r102.visibleArray.length()) goto L17;
        int r110 = JSONArrayProtectorUtils.getInt(r102.visibleArray, r109);     // Catch: JSONException -> L19
        if (r110 < 0) goto L16;
        if (r109 >= r108) goto L15;
        r106.add(new Pair(Integer.valueOf(r109), Integer.valueOf(r110)));     // Catch: JSONException -> L19
        goto L16
    L15:
        r107.add(new Pair(Integer.valueOf(r109), Integer.valueOf(r110 - r108)));     // Catch: JSONException -> L19
    L16:
        r109 = r109 + 1;     // Catch: JSONException -> L19
        goto L9
    L17:
        r102.mappedBackgroundIndexPairs = r106;     // Catch: JSONException -> L19
        r102.mappedOverlayIndexPairs = r107;     // Catch: JSONException -> L19
        return r102;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }
}
