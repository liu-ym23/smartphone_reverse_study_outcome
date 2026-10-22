package com.ss.android.lark.chat.chatwindow.chat.model.preload;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.extension.message.TaskType;
import com.ss.android.lark.chat.core.api.e;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public interface b {
    void a(e r100);

    void b(List<? extends MessageInfo> r100);

    void c(@TaskType String r100, List<? extends MessageInfo> r101, String r102, String r103, IGetDataCallback<Map<String, String>> r104);

    void destroy();
}
