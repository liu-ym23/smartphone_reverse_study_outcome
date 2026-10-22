package com.larus.platform.api;

import android.content.Context;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: classes31.dex */
public interface i2 {

    public static final class a {
        public static /* synthetic */ void a(i2 r100, Message r110, String r111, boolean r112, String r113, Context r114, String r115, String r116) {
            r100.Q1(r110, r111, r112, r113, r114, r115, r116, null);
        }
    }

    void Q1(Message r100, String r101, boolean r102, String r103, Context r104, String r105, String r106, String r107);

    int R();

    String a(Message r100);

    String b(Message r100);

    String c(Message r100);

    String d(Message r100);

    Integer e(Message r100);
}
