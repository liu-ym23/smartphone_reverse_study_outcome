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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileInfoMetaParser {
    private static final String KEY_DATA = "data";
    private static final List<String> KEY_FILE_META_TYPE_LIST = null;
    private static final String TAG = "FileInfoMetaParser";

    static {
        KEY_FILE_META_TYPE_LIST = Arrays.asList(new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(2), String.valueOf(3), String.valueOf(7), String.valueOf(8), String.valueOf(9), String.valueOf(11), String.valueOf(12), String.valueOf(13), String.valueOf(14), String.valueOf(15), String.valueOf(16), String.valueOf(17), String.valueOf(19), String.valueOf(20), String.valueOf(21)});
    }

    private FileInfoMetaParser() {
    }

    public static SparseArray<FileInfoMeta> parse(String r9) {
        SparseArray<FileInfoMeta> r0 = new SparseArray();
        if (r9 != null) goto L17;
        return r0;
    L17:
        JSONObject r1 = JSON.parseObject(r9).getJSONObject(KEY_DATA);     // Catch: JSONException -> L15
        if (r1 != null) goto L8;
        return r0;
    L8:
        int r2 = KEY_FILE_META_TYPE_LIST.size();     // Catch: JSONException -> L15
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L16;
        String r5 = (String) ListProtector.get(KEY_FILE_META_TYPE_LIST, r4);     // Catch: JSONException -> L15
        String r6 = r1.getString(r5);     // Catch: JSONException -> L15
        FileInfoMeta r7 = (FileInfoMeta) JSON.parseObject(r6, new AnonymousClass1(), new Feature[0]);     // Catch: JSONException -> L15
        if (r6 == null) goto L14;
        if (r7 == null) goto L14;
        r0.put(CastIntegerProtector.parseInt(r5), r7);     // Catch: JSONException -> L15
    L14:
        r4 = r4 + 1;
    L16:
        return r0;
    L15:
        tt5.a.d(TAG, "parse meta exception: ".concat(r9));
        goto L16
    }
}
