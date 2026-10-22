package com.ss.android.ugc.effectmanager.common.listener;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface IJsonConverter {
    <T> T convertJsonToObj(InputStream r100, Class<T> r101) throws Exception;

    <T> String convertObjToJson(T r100) throws Exception;
}
