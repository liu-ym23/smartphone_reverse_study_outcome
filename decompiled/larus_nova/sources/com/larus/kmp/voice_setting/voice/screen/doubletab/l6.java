package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.kmp.voice_setting.voice.component.VoiceRowActionKind;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class l6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f354461a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f354462a = null;

        static {
            int[] r100 = new int[VoiceRowActionKind.values().length];
            r100[VoiceRowActionKind.SCROLLABILITY_CHANGED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[VoiceRowActionKind.SCROLL_IN_PROGRESS_CHANGED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[VoiceRowActionKind.SCROLL_UP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[VoiceRowActionKind.ROW_FULLY_VISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f354462a = r100;
        }
    }

    static {
        f354461a = SetsKt.setOf(new String[]{"bot_image_setting", "bot_create_page", "bot_update"});
    }
}
