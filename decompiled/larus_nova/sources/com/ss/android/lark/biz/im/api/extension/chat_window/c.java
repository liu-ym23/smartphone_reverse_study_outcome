package com.ss.android.lark.biz.im.api.extension.chat_window;

import android.content.Context;
import com.ss.android.lark.scaffold.IComponent;

/* JADX INFO: loaded from: classes34.dex */
public interface c {
    <T extends IComponent> T a(Class<T> r100);

    ChatWindowOpenViewModel c();

    Context getContext();

    Object getHost();

    fxa.b u();
}
