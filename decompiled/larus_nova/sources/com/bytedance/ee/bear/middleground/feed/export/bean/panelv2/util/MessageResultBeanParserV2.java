package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.util;

import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public final class MessageResultBeanParserV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f232614a = null;

    static {
        f232614a = LazyKt.lazy(MessageResultBeanParserV2$gson$2.INSTANCE);
    }

    @JvmStatic
    public static final MessageResultBean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messages");
        MessageResultBean r101 = new MessageResultBean();     // Catch: Exception -> L5
        r101.setMsg("");     // Catch: Exception -> L5
        r101.setData((MessageResultBean.Data) ((Gson) f232614a.getValue()).fromJson(JsonParser.parseString(r100), MessageResultBean.Data.class));     // Catch: Exception -> L5
        return r101;
    L5:
        e = move-exception;
        a.e("MessageResultBeanParserV2", "parser error: ", e, false);
        return null;
    }
}
