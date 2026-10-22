package com.ss.android.lark.feed.shared.data.appconfig;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements mpb.a {
    public d() {
    }

    @Override // mpb.a
    public final lpb.a a(String r100) {
        b r101 = new b();
        if (TextUtils.isEmpty(r100) == false) goto L12;
        Log.i("FeedLoadCountConfigHelp", "Feed load config is empty, use default value!");
    L11:
        return r101;
    L12:
        JSONObject r102 = JSON.parseObject(r100);     // Catch: Exception -> L9
        r102.getInteger("refresh").intValue();     // Catch: Exception -> L9
        r102.getInteger("refresh_buffer").intValue();     // Catch: Exception -> L9
        r102.getInteger("loadmore").intValue();     // Catch: Exception -> L9
        int r103 = r102.getInteger("buffer").intValue();     // Catch: Exception -> L9
        if (r103 <= 0) goto L11;
        r101.f421137a = r103;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.e("FeedLoadCountConfigHelp", "parse Feed load config fail :" + e.getMessage());
        goto L11
    }
}
