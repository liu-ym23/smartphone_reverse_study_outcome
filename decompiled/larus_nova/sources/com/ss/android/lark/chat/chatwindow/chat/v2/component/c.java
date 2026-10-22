package com.ss.android.lark.chat.chatwindow.chat.v2.component;

import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.plugin.NewIntentScrollMessagePlugin$newIntentHandler$2;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin;

/* JADX INFO: loaded from: classes35.dex */
public interface c extends com.ss.android.lark.biz.im.api.extension.chat_window.c, ChatBaseComponent.a, m2b.b {
    public static final /* synthetic */ int E1 = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f413556a = 0;

        static {
        }

        public a() {
        }
    }

    public interface b {
        boolean b(int r100, int r101, Intent r102);
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.c$c, reason: collision with other inner class name */
    public interface InterfaceC4820c {
        boolean l1();
    }

    public interface d {
        void a(fxa.b r100);
    }

    static {
        int r100 = a.f413556a;
    }

    void a0(Intent r100);

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.c
    /* synthetic */ Context getContext();

    ChatWindowOpenViewModel getViewModel(Class r100);

    void i(FlowMessageSelectPlugin.b r100);

    void k0(NewIntentScrollMessagePlugin$newIntentHandler$2.a r100);

    ChatWindowKeyboard n();

    void p(FlowMessageSelectPlugin.h r100);

    void s(FlowMessageSelectPlugin.b r100);

    void t(NewIntentScrollMessagePlugin$newIntentHandler$2.a r100);
}
