package com.ss.android.lark.keyboard.plugin.tool.face;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FaceKBPluginHitPoint extends com.ss.android.lark.keyboard.statistics.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f429635a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/face/FaceKBPluginHitPoint$Scene;", "", "Companion", "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Scene {
        public static final a Companion = null;
        public static final String EMOJI = "emoji";
        public static final String STICKER_PACK = "stickerpack";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f429636a = null;

            static {
                f429636a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f429636a;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.statistics.a
    public final String a() {
        return "im_chat_input_toolbar_sticker";
    }

    public FaceKBPluginHitPoint() {
        Intrinsics.checkNotNullParameter("emoji", "paramValue");
        this.f429635a = "emoji";
    }

    @Override // com.ss.android.lark.keyboard.statistics.a
    public final String b() {
        return this.f429635a;
    }
}
