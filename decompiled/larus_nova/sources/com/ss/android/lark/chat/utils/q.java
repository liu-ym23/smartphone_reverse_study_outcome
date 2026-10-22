package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.core.api.ChatCoreModule;

/* JADX INFO: loaded from: classes35.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w4b.a f416718a = null;

    public interface a {
        boolean a();

        String getChatId();
    }

    static {
        f416718a = ChatCoreModule.a().getAuditDependency();
    }
}
