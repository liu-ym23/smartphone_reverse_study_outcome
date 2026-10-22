package com.ss.android.lark.keyboard.plugin.tool.face;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes36.dex */
public final class KeyboardEmojiModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f429642a = null;

    public interface a {
        int getFileUploadAuthorizatedDenyCode();

        int getFileUploadAuthorizatedDenyCodeByFilePolicy();

        String getUploadAuthorizationTip();

        void onAuthorizatedDeny(Context r100, String r101);
    }

    static {
        f429642a = LazyKt.lazy(KeyboardEmojiModule$dependency$2.INSTANCE);
    }
}
