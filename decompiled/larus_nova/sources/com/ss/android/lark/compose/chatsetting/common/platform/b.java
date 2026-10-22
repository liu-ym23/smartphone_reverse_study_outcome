package com.ss.android.lark.compose.chatsetting.common.platform;

import android.content.Context;
import com.lark.kmp.pb.basic.v1.Chat;
import com.ss.android.lark.compose.chatsetting.report.ChatSettingFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
public interface b {
    boolean a(Context r100, ChatSettingFunction r101);

    void b(Chat.Type r100, boolean r101, boolean r102);

    Object c(Context r100, String r101);

    boolean d(Context r100);

    Object e(Context r100, e r101);

    Object f(Context r100);

    boolean g(Context r100);

    void h(Chat r100);

    Object i(Context r100, d r101);

    void j(String r100, boolean r101);

    Object k(Context r100, String r101, CoroutineScope r102);

    void l(String r100, boolean r101);

    void m(Context r100, Throwable r101);

    void n(Context r100, c r101);

    void o(ChatSettingTrackEvent r100, Boolean r101);
}
