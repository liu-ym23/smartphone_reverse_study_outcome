package com.bytedance.locallife.pdp.mob;

import com.ss.android.ugc.aweme.poi.mob.WriteActionRecord;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface d {
    void a(Map<String, String> r100, String r101, String r102);

    String b(String r100);

    JSONObject c();

    void d(String r100, String r101);

    void e(Map<String, String> r100, Map<String, String> r101);

    void f(String r100, String r101);

    Map<String, Map<String, List<WriteActionRecord>>> g();

    HashMap<String, String> h();

    boolean isAd();
}
