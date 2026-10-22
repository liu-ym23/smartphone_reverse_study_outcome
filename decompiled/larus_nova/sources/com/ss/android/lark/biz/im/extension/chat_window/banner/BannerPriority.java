package com.ss.android.lark.biz.im.extension.chat_window.banner;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/biz/im/extension/chat_window/banner/BannerPriority;", "", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface BannerPriority {
    public static final a Companion = null;
    public static final int P_APPLY_ADD_FRIEND = 5;
    public static final int P_APPLY_MESSAGE = 4;
    public static final int P_BLOCK_OR_ADD_CONTACT = 6;
    public static final int P_BOT_AUTO_MUTE = 3;
    public static final int P_CALENDAR_MEETING = 9;
    public static final int P_CHATTER_APPLY = 2;
    public static final int P_CHAT_AUTO_MUTE = 3;
    public static final int P_P2P_READABLE = 1;
    public static final int P_TOP_NOTICE_MESSAGE = 7;
    public static final int P_TOP_NOTICE_THREAD_MESSAGE = 1;
    public static final int P_VC_ONGOING_NOTICE = 8;
    public static final int TOP = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f410491a = null;

        static {
            f410491a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f410491a;
    }
}
