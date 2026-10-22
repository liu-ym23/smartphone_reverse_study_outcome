package com.ss.android.lark.chat.entity.chat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatJoinLeaveHistory$ValueType;", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface ChatJoinLeaveHistory$ValueType {
    public static final int BOT = 2;
    public static final int CHAT = 3;
    public static final a Companion = null;
    public static final int DEP = 6;
    public static final int DOC = 4;
    public static final int TEAM = 5;
    public static final int UNKNOWN_VALUE_TYPE = 0;
    public static final int USER = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f415144a = null;

        static {
            f415144a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f415144a;
    }
}
