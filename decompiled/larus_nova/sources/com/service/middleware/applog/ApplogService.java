package com.service.middleware.applog;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import iqa.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ApplogService extends IService {
    void onEvent(Context r100, String r101);

    void onEvent(Context r100, String r101, String r102);

    void onEvent(Context r100, String r101, String r102, String r103, long r104, long r105);

    void onEvent(Context r100, String r101, String r102, String r103, long r104, long r105, JSONObject r106);

    void onEvent(Context r100, String r101, String r102, String r103, long r104, long r105, boolean r106);

    void onEvent(Context r100, String r101, String r102, String r103, long r104, long r105, boolean r106, JSONObject r110);

    void registerHeaderCustomCallback(a r100);
}
