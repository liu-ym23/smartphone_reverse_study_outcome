package com.ss.android.lark.chat.core.dependency;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes35.dex */
public interface BrowserDependency {

    @Retention(RetentionPolicy.SOURCE)
    public @interface SourceType {
        public static final int GROUP_CHAT = 1;
        public static final int P2P_CHAT = 0;
        public static final int THREAD_TOPIC = 2;
        public static final int UNKNOWN = -1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UrlClickType {
        public static final String CARD = "card";
        public static final String INLINE = "inline";
    }

    void a(Context r100, String r101, int r102);

    void b(Context r100, String r101, int r102, Bundle r103);

    void c(Context r100, String r101, int r102);

    void d(Context r100, String r101, int r102, String r103, Bundle r104, Fragment r105, String r106);

    void openUrl(Context r100, String r101);
}
