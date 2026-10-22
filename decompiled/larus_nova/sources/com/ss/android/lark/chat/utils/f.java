package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.entity.message.Message;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes35.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<String> f416665a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f416666a = null;

        static {
            int[] r100 = new int[Message.Type.values().length];
            r100[Message.Type.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Message.Type.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Message.Type.POST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f416666a = r100;
        }
    }

    static {
        f416665a = new CopyOnWriteArraySet();
    }
}
