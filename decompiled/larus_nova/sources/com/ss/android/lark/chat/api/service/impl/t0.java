package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.TranslateMessageUrlPreviewsRequest;
import com.bytedance.lark.pb.im.v1.GetTranslateLanguagesRequest;
import com.bytedance.lark.pb.im.v1.SetAutoTranslateGlobalSwitchRequest;
import com.bytedance.lark.pb.im.v1.SetTranslateLanguageRequest;
import com.bytedance.lark.pb.im.v1.TranslateMessagesV3Request;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: classes35.dex */
public interface t0 {
    void a(SetTranslateLanguageRequest.Builder r100, c2 r101, IGetDataCallback r102);

    void b(TranslateMessagesV3Request.Builder r100, d2 r101, IGetDataCallback r102);

    void c(GetTranslateLanguagesRequest.Builder r100, f2 r101, IGetDataCallback r102);

    void d(TranslateMessageUrlPreviewsRequest.Builder r100, e2 r101, IGetDataCallback r102);

    void e(SetAutoTranslateGlobalSwitchRequest.Builder r100, b2 r101, IGetDataCallback r102);
}
