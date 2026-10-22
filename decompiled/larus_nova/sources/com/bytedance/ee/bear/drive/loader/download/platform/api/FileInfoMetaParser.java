package com.bytedance.ee.bear.drive.loader.download.platform.api;

import android.util.SparseArray;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class FileInfoMetaParser {
    private static final String KEY_DATA = "data";
    private static final List<String> KEY_FILE_META_TYPE_LIST = null;
    private static final String TAG = "FileInfoMetaParser";

    static {
        KEY_FILE_META_TYPE_LIST = Arrays.asList(new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(2), String.valueOf(3), String.valueOf(7), String.valueOf(8), String.valueOf(9), String.valueOf(11), String.valueOf(12), String.valueOf(13), String.valueOf(14), String.valueOf(15), String.valueOf(16), String.valueOf(17), String.valueOf(19), String.valueOf(20), String.valueOf(21)});
    }

    private FileInfoMetaParser() {
    }

    public static SparseArray<FileInfoMeta> parse(String r100) {
        SparseArray<FileInfoMeta> r101 = new SparseArray();
        if (r100 != null) goto L17;
        return r101;
    L17:
        JSONObject r102 = JSON.parseObject(r100).getJSONObject("data");     // Catch: JSONException -> L15
        if (r102 != null) goto L8;
        return r101;
    L8:
        int r103 = KEY_FILE_META_TYPE_LIST.size();     // Catch: JSONException -> L15
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L16;
        String r105 = (String) ListProtector.get(KEY_FILE_META_TYPE_LIST, r104);     // Catch: JSONException -> L15
        String r106 = r102.getString(r105);     // Catch: JSONException -> L15
        FileInfoMeta r107 = (FileInfoMeta) JSON.parseObject(r106, new AnonymousClass1(), new Feature[0]);     // Catch: JSONException -> L15
        if (r106 == null) goto L14;
        if (r107 == null) goto L14;
        r101.put(CastIntegerProtector.parseInt(r105), r107);     // Catch: JSONException -> L15
    L14:
        r104 = r104 + 1;
    L16:
        return r101;
    L15:
        tt5.a.d(TAG, "parse meta exception: ".concat(r100));
        goto L16
    }
}
