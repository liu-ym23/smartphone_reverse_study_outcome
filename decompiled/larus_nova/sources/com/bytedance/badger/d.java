package com.bytedance.badger;

import java.util.List;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface d {
    void a(String r100, JSONObject r101);

    void b(List<? extends Pair<String, ? extends JSONObject>> r100);

    void d(String r100, String r101);

    void e(String r100, String r101);

    void e(String r100, String r101, Throwable r102);

    void i(String r100, String r101);

    void i(String r100, String r101, Throwable r102);

    void w(String r100, String r101);

    void w(String r100, String r101, Throwable r102);
}
