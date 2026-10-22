package com.ss.android.lark.keyboard.statistics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class PostInputPluginHitPoint extends com.ss.android.lark.keyboard.statistics.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f430946a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/keyboard/statistics/PostInputPluginHitPoint$Scene;", "", "Companion", "keyboard-biz-common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Scene {
        public static final String AT = "mention";
        public static final a Companion = null;
        public static final String EMOJI = "emoji";
        public static final String PICTURE = "picture";
        public static final String SEND = "send";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f430947a = null;

            static {
                f430947a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f430947a;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.statistics.a
    public final String a() {
        return "im_chat_input_toolbar_rich_text";
    }

    @Override // com.ss.android.lark.keyboard.statistics.a
    public final String b() {
        return this.f430946a;
    }

    public PostInputPluginHitPoint(@Scene String r100) {
        Intrinsics.checkNotNullParameter(r100, "paramValue");
        this.f430946a = r100;
    }
}
