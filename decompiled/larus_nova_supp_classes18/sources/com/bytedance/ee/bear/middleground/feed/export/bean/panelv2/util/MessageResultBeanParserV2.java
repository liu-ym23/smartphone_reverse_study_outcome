package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.util;

import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class MessageResultBeanParserV2 {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(MessageResultBeanParserV2$gson$2.INSTANCE);
    }

    @JvmStatic
    public static final MessageResultBean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "messages");
        MessageResultBean r0 = new MessageResultBean();     // Catch: Exception -> L5
        r0.setMsg("");     // Catch: Exception -> L5
        r0.setData((MessageResultBean.Data) ((Gson) a.getValue()).fromJson(JsonParser.parseString(r3), MessageResultBean.Data.class));     // Catch: Exception -> L5
        return r0;
    L5:
        e = move-exception;
        a.e("MessageResultBeanParserV2", "parser error: ", e, false);
        return null;
    }
}
