package com.larus.ugc.perf.impl;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface d {

    public static final class a {
        public static e a(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            f r101 = f.f375107a;
            String r102 = r100.getReplyId();
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.getClass();
            return f.b(r102);
        }
    }

    void a(e r100);

    void c(e r100);

    void d(e r100);

    void h(e r100);
}
