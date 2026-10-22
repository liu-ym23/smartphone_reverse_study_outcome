package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.Message;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f437622a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f437623a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f437624b = null;

        static {
            int[] r100 = new int[Message.AIInfo.ButtonConfig.Strategy.values().length];
            r100[Message.AIInfo.ButtonConfig.Strategy.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[Message.AIInfo.ButtonConfig.Strategy.CUSTOMIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L6:
            f437623a = r100;
            int[] r101 = new int[Message.AIInfo.ButtonConfig.Button.values().length];
            r101[Message.AIInfo.ButtonConfig.Button.LIKE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L33:
            r101[Message.AIInfo.ButtonConfig.Button.DISLIKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L27:
            r101[Message.AIInfo.ButtonConfig.Button.REGENERATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L29:
            r101[Message.AIInfo.ButtonConfig.Button.SHARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L21:
            r101[Message.AIInfo.ButtonConfig.Button.COPY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L12:
            f437624b = r101;
        }
    }

    static {
        f437622a = new Gson();
    }
}
