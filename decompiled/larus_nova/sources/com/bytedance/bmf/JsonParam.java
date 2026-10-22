package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;

/* JADX INFO: loaded from: classes43.dex */
public class JsonParam extends Ptr {
    public String dump() {
        return API.bmf_json_dump(this.ptr);
    }

    public void free() {
        if (this.own == false) goto L6;
        API.bmf_json_free(this.ptr);
        return;
    }

    public JsonParam() {
        this.ptr = API.bmf_json_make();
        this.own = true;
    }

    public boolean erase(String r100) {
        return API.bmf_json_erase(this.ptr, r100);
    }

    public double getDouble(String r100) {
        return API.bmf_json_get_double(this.ptr, r100);
    }

    public double[] getDoubleList(String r100) {
        return API.bmf_json_get_double_list(this.ptr, r100);
    }

    public float getFloat(String r100) {
        return API.bmf_json_get_float(this.ptr, r100);
    }

    public float[] getFloatList(String r100) {
        return API.bmf_json_get_float_list(this.ptr, r100);
    }

    public int getInt(String r100) {
        return API.bmf_json_get_int(this.ptr, r100);
    }

    public int[] getIntList(String r100) {
        return API.bmf_json_get_int_list(this.ptr, r100);
    }

    public long getLong(String r100) {
        return API.bmf_json_get_long(this.ptr, r100);
    }

    public String getString(String r100) {
        return API.bmf_json_get_string(this.ptr, r100);
    }

    public String[] getStringList(String r100) {
        return API.bmf_json_get_string_list(this.ptr, r100);
    }

    public boolean hasKey(String r100) {
        return API.bmf_json_has_key(this.ptr, r100);
    }

    public JsonParam(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public static JsonParam wrap(long r100, boolean r101) {
        return new JsonParam(r100, r101);
    }

    public void set(String r100, Object r101) throws Exception {
        if ((r101 instanceof Integer) == false) goto L6;
        API.bmf_json_set_int(this.ptr, r100, ((Integer) r101).intValue());
        return;
    L6:
        if ((r101 instanceof Long) == false) goto L9;
        API.bmf_json_set_long(this.ptr, r100, ((Long) r101).longValue());
        return;
    L9:
        if ((r101 instanceof Float) == false) goto L12;
        API.bmf_json_set_float(this.ptr, r100, ((Float) r101).floatValue());
        return;
    L12:
        if ((r101 instanceof Double) == false) goto L15;
        API.bmf_json_set_double(this.ptr, r100, ((Double) r101).doubleValue());
        return;
    L15:
        if ((r101 instanceof String) == false) goto L18;
        API.bmf_json_set_string(this.ptr, r100, (String) r101);
        return;
    L18:
        if (r101.getClass().isArray() == false) goto L35;
        if ((r101 instanceof int[]) == false) goto L23;
        API.bmf_json_set_int_list(this.ptr, r100, (int[]) r101);
        return;
    L23:
        if ((r101 instanceof float[]) == false) goto L26;
        API.bmf_json_set_float_list(this.ptr, r100, (float[]) r101);
        return;
    L26:
        if ((r101 instanceof double[]) == false) goto L29;
        API.bmf_json_set_double_list(this.ptr, r100, (double[]) r101);
        return;
    L29:
        if ((r101 instanceof String[]) == false) goto L33;
        API.bmf_json_set_string_list(this.ptr, r100, (String[]) r101);
        return;
    L33:
        throw new IllegalArgumentException("Unknown array type for Jsonparam set()");
    L35:
        throw new IllegalArgumentException("Unknown type for Jsonparam set()");
    }
}
