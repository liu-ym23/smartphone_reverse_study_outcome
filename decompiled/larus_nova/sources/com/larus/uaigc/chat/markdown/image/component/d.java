package com.larus.uaigc.chat.markdown.image.component;

import android.view.View;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes31.dex */
public interface d {
    View a();

    Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> b();

    Function1<Continuation<? super Message>, Object> c();

    String getLogTag();
}
