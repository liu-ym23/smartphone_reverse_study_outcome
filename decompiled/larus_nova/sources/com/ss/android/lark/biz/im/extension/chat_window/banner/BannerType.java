package com.ss.android.lark.biz.im.extension.chat_window.banner;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/biz/im/extension/chat_window/banner/BannerType;", "", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface BannerType {
    public static final int APPLY_ADD_FRIEND = 16;
    public static final int APPLY_MESSAGE = 32;
    public static final int BLOCK_OR_ADD_CONTACT = 8;
    public static final int BOT_AUTO_MUTE = 8192;
    public static final int CALENDAR_MEETING = 1;
    public static final int CALENDAR_REMINDER = 512;
    public static final int CHATTER_APPLY = 2;
    public static final int CHAT_AUTO_MUTE = 4096;
    public static final int CHAT_MUTE = 256;
    public static final a Companion = null;
    public static final int DEFAULT = 0;
    public static final int EDU_INVITE = 64;
    public static final int P2P_CHAT_READABLE = 2048;
    public static final int TOP_NOTICE_MESSAGE = 128;
    public static final int VC_ONGOING = 1024;
    public static final int VIDEO_CHAT_INFO = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f410492a = null;

        static {
            f410492a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f410492a;
    }
}
