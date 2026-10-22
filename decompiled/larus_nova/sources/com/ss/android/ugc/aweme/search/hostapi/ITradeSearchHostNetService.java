package com.ss.android.ugc.aweme.search.hostapi;

import android.content.Context;
import com.bytedance.retrofit2.Converter;
import com.google.gson.Gson;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public interface ITradeSearchHostNetService {
    <T> T create(String r100, Class<T> r101);

    <T> T create(String r100, Class<T> r101, Converter.Factory r102, Map<String, Object> r103);

    <T> T create(String r100, Class<T> r101, Converter.Factory r102, Map<String, Object> r103, Gson r104);

    String getNetworkAccessType(Context r100);
}
