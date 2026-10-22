package com.ss.android.lark.chat.utils;

import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class n1 {
    public static void a(String r100) {
        DevEnvUtil.isDebugMode(ChatCoreModule.a().getContext());
        Log.i(TitlebarViewModel.LOG_TAG, r100);
    }
}
