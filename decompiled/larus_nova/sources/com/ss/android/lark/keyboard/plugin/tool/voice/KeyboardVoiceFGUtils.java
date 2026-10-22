package com.ss.android.lark.keyboard.plugin.tool.voice;

import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.audio.voiceinput.AudioPluginUseType;
import com.ss.android.lark.audio.voiceinput.utils.d;
import com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper;
import com.ss.android.lark.utils.CarUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
public final class KeyboardVoiceFGUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KeyboardVoiceFGUtils f429815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f429816b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f429817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f429818d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f429819e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f429820f = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f429821a = null;

        static {
            int[] r100 = new int[AudioPluginUseType.values().length];
            r100[AudioPluginUseType.NEVER_SET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AudioPluginUseType.NEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AudioPluginUseType.OLD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f429821a = r100;
        }
    }

    public KeyboardVoiceFGUtils() {
    }

    public static final boolean c() {
        return a("im.messenger.audio_quote", null);
    }

    public static final boolean d() {
        return a("im.messenger.voice_input_emoji", null);
    }

    public static final boolean e() {
        if (a("im.messenger.richtext_voice_input", null) == true) goto L5;
        return false;
    L5:
        if (h() == false) goto L20;
        int r100 = AudioPluginHelper.f430819f;
        Pair r101 = AudioPluginHelper.a.a();
        AudioPluginUseType r102 = (AudioPluginUseType) r101.component1();
        ((Boolean) r101.component2()).booleanValue();
        int r103 = a.f429821a[r102.ordinal()];
        if (r103 != 1) goto L9;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L21;
        return true;
    L21:
        return false;
    L9:
        if (r103 == 2) goto L15;
        if (r103 != 3) goto L14;
        r104 = false;
        goto L16
    L14:
        throw new NoWhenBranchMatchedException();
    L20:
        return false;
    }

    static {
        f429815a = new KeyboardVoiceFGUtils();
        f429816b = LazyKt.lazy(KeyboardVoiceFGUtils$isServerPointEnable$2.INSTANCE);
        f429817c = LazyKt.lazy(KeyboardVoiceFGUtils$isPostMessageEnableReverse$2.INSTANCE);
        f429818d = LazyKt.lazy(KeyboardVoiceFGUtils$isDictateRetry$2.INSTANCE);
        f429819e = LazyKt.lazy(KeyboardVoiceFGUtils$isVoiceSecondInputV2$2.INSTANCE);
        f429820f = LazyKt.lazy(KeyboardVoiceFGUtils$isVoiceInputMarkdownRound2$2.INSTANCE);
    }

    public static boolean i() {
        return ((Boolean) f429820f.getValue()).booleanValue();
    }

    public final boolean f() {
        return g(this, "im.messenger.second_voice_input");
    }

    public final boolean j() {
        if (g(this, "im.messenger.voice_input_markdown") == false) goto L5;
    L8:
        return true;
    L5:
        if (g(this, "im.messenger.voice_input_all_use_richtext") == false) goto L8;
        return false;
    }

    public static boolean b() {
        if (AudioRecordSettings.e().contains("im.messenger.text_by_default") == false) goto L5;
    L8:
        return true;
    L5:
        if (a("im.messenger.text_by_default", null) == true) goto L8;
        return false;
    }

    public static final boolean h() {
        if (CarUtils.a() == false) goto L6;
        return true;
    L6:
        if (AudioRecordSettings.e().contains("im.messenger.new_voice_input") == false) goto L8;
        return true;
    L8:
        if (a("im.messenger.new_voice_input", null) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean a(final String r100, d r101) {
        final boolean r102 = KeyboardVoiceModule.a().isCurrentFeatureEnable(r100);
        final Function0<Unit> r103 = new KeyboardVoiceFGUtils$isCurrentFgEnable$1$block$1(r100, r102);
        if (r101 == null) goto L5;
        r101.a(new KeyboardVoiceFGUtils$isCurrentFgEnable$1$1(r103));
    L6:
        return r102;
    L5:
        r103.invoke();
        goto L6
    }

    public static boolean g(KeyboardVoiceFGUtils r100, final String r101) {
        r100.getClass();
        final boolean r102 = KeyboardVoiceModule.a().isFeatureGatingEnable(r101);
        new KeyboardVoiceFGUtils$isFgEnable$1$block$1(r101, r102).invoke();
        return r102;
    }
}
