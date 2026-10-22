package com.ss.android.lark.search.doubao.dep;

import android.content.Context;
import com.larksuite.framework.callback.UIGetDataCallback;

/* JADX INFO: loaded from: classes38.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.search.doubao.dep.a$a, reason: collision with other inner class name */
    public interface InterfaceC5285a {
        void a(Context r100, String r101, int r102, int r103);

        void b(Context r100, String r101, int r102);

        void c(String r100, UIGetDataCallback r101);

        void d(Context r100, String r101, int r102);

        boolean isJumpToReplyInThread(int r100, String r101);
    }

    public interface b {
        void a(String r100, int r101);
    }

    InterfaceC5285a chatDependency();

    b feedDependency();

    String getLoginUserId();

    boolean isEnableDebug();
}
