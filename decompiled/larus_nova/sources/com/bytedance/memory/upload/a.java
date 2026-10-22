package com.bytedance.memory.upload;

import android.text.TextUtils;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.util.l;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f265534a;

    public final void a() {
        JSONObject r100 = new JSONObject();
        JSONArray r101 = new JSONArray();
        JSONObject r102 = new JSONObject();
        r102.put("d_s_t", System.currentTimeMillis());     // Catch: Throwable -> L8
        r102.put("event_type", UploadTypeInf.MEMORY_OBJ_MONITOR);     // Catch: Throwable -> L8
        r102.put("log_id", MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_HEIGHT);     // Catch: Throwable -> L8
        r102.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.MEMORY_OBJ_MONITOR);     // Catch: Throwable -> L8
        r102.put("memory_object", new JSONObject(this.f265534a).optJSONObject("memory_object"));     // Catch: Throwable -> L8
        r102.put("network_type", l.a(com.bytedance.apm.d.getContext()).getValue());     // Catch: Throwable -> L8
        String r103 = com.bytedance.apm.d.f190520h.getSessionId();     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r103) == true) goto L6;
        r102.put("session_id", r103);     // Catch: Throwable -> L8
    L6:
        r102.put(WsConstants.KEY_SESSION_ID, com.bytedance.apm.d.h());     // Catch: Throwable -> L8
        r102.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L8
        r101.put(r102);     // Catch: Throwable -> L8
        r100.put("data", r101);     // Catch: Throwable -> L8
        r100.put("header", com.bytedance.apm.d.f190519g);     // Catch: Throwable -> L8
    L10:
        Iterator<String> r104 = c.f265537c.iterator();
    L12:
        if (r104.hasNext() == false) goto L22;
        String r105 = r104.next();
        ff7.b r106 = com.bytedance.apm.d.a(r105, r100.toString().getBytes(), null);     // Catch: Exception -> L20
        if (r106 == null) goto L12;
        if (new JSONObject(new String(r106.f476669c)).optInt("error_code", -1) != 0) goto L12;
        r17.c.b("client analysis report success", new Object[0]);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L22:
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(String r100) {
        this.f265534a = r100;
    }
}
