package com.bytedance.bdturing.sensor;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.camera_export.CameraParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class SensorStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f202060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    List<Long> f202061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    List<Long> f202062c;

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    boolean f202063cb;

    /* JADX INFO: renamed from: ef, reason: collision with root package name */
    boolean f202064ef;

    /* JADX INFO: renamed from: ka, reason: collision with root package name */
    boolean f202065ka;

    /* JADX INFO: renamed from: ve, reason: collision with root package name */
    boolean f202066ve;

    public JSONObject toJsonObj() {
        JSONObject r100 = new JSONObject();
        r100.put("ka", this.f202065ka);     // Catch: Exception -> L13
        r100.put("cb", this.f202063cb);     // Catch: Exception -> L13
        r100.put("ef", this.f202064ef);     // Catch: Exception -> L13
        r100.put(CameraParam.TYPE_VE_CAMERA, this.f202066ve);     // Catch: Exception -> L13
        r100.put(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, this.f202060a);     // Catch: Exception -> L13
        JSONArray r101 = new JSONArray();     // Catch: Exception -> L13
        Iterator<Long> r102 = this.f202061b.iterator();     // Catch: Exception -> L13
    L5:
        if (r102.hasNext() == false) goto L7;
        r101.put(r102.next());     // Catch: Exception -> L13
        goto L5
    L7:
        r100.put("b", r101);     // Catch: Exception -> L13
        JSONArray r103 = new JSONArray();     // Catch: Exception -> L13
        Iterator<Long> r104 = this.f202062c.iterator();     // Catch: Exception -> L13
    L9:
        if (r104.hasNext() == false) goto L11;
        r103.put(r104.next());     // Catch: Exception -> L13
        goto L9
    L11:
        r100.put("c", r103);     // Catch: Exception -> L13
    L15:
        return r100;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public SensorStatus() {
        this.f202061b = new ArrayList();
        this.f202062c = new ArrayList();
    }
}
