package com.ss.android.lark;

import android.content.Context;
import android.text.Annotation;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.widget.richtext.RichText;

/* JADX INFO: loaded from: classes34.dex */
public interface d {
    RichText decodeAndGetRichText(Annotation r100);

    String encodePbRichText(RichText r100);

    void getTempPreviewFromContent(String r100, long r101, long r102, IGetDataCallback<UrlInlinePreviewEntity> r103);

    void getUrlInlineFromContent(String r100, IGetDataCallback<UrlInlinePreviewEntity> r101);

    boolean isFeatureGatingCurrentEnable(String r100);

    boolean isFeatureGatingEnable(String r100);

    void openUrl(Context r100, String r101, String r102);
}
