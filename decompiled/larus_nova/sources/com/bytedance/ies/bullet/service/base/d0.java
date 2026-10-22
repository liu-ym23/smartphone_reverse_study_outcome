package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import kotlin.Deprecated;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "建议使用已有的默认配置，无需自定义")
public interface d0 extends q26.c {
    void q0(Uri r100);

    com.bytedance.ies.bullet.service.prefetch.b v0(m16.b r100);

    void w(Uri r100);

    JSONObject z0(Uri r100);
}
