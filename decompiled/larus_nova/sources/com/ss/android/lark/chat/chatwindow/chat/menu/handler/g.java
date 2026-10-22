package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: classes35.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f412583a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f412584a = null;

        static {
            int[] r100 = new int[Message.Type.values().length];
            f412584a = r100;
            r100[Message.Type.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public g(FragmentActivity r100) {
        this.f412583a = r100;
    }
}
