package com.ss.android.lark.keyboard.biz.voice.inject;

import android.text.Editable;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
public final class VoiceInputPreviewDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.b f428593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f428595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f428596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f428597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f428598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f428599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f428600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f428601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PreviewOriginMode f428602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f428603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f428604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f428605m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/keyboard/biz/voice/inject/VoiceInputPreviewDelegate$PreviewOriginMode;", "", "<init>", "(Ljava/lang/String;I)V", "INPUT_UNFOCUSED", "VOICE_MODE", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PreviewOriginMode extends Enum<PreviewOriginMode> {
        public static final PreviewOriginMode INPUT_UNFOCUSED = null;
        public static final PreviewOriginMode VOICE_MODE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PreviewOriginMode[] f428606a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f428607b = null;

        public static EnumEntries<PreviewOriginMode> getEntries() {
            return f428607b;
        }

        static {
            PreviewOriginMode r100 = new PreviewOriginMode("INPUT_UNFOCUSED", 0);
            INPUT_UNFOCUSED = r100;
            PreviewOriginMode r101 = new PreviewOriginMode("VOICE_MODE", 1);
            VOICE_MODE = r101;
            PreviewOriginMode[] r102 = {r100, r101};
            f428606a = r102;
            f428607b = EnumEntriesKt.enumEntries(r102);
        }

        public static PreviewOriginMode[] values() {
            return (PreviewOriginMode[]) f428606a.clone();
        }

        public static PreviewOriginMode valueOf(String r100) {
            return (PreviewOriginMode) r27.a.a(PreviewOriginMode.class, r100);
        }

        public PreviewOriginMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final fya.a.d b() {
        return (fya.a.d) this.f428598f.getValue();
    }

    public final String c() {
        Editable r100 = this.f428593a.L().c().getText();
        if (r100 == null) goto L8;
        String r101 = r100.toString();
        if (r101 == null) goto L8;
        String r102 = StringsKt.replace$default(r101, " ", "", false, 4, null);
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    public final void a(boolean r100) {
        if (this.f428600h != null) goto L12;
        fya.a.d r101 = b();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L12;
        return;
    L7:
        if (r101.isLoading() != true) goto L9;
        r102 = true;
    L12:
        Job r103 = this.f428600h;
        if (r103 == null) goto L15;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L15:
        this.f428600h = null;
        if (r100 == false) goto L32;
        fya.a.d r104 = b();
        if (r104 != null) goto L20;
    L22:
        boolean r105 = false;
    L23:
        if (r105 == false) goto L35;
        this.f428605m = true;
        fya.a.d r106 = b();     // Catch: Throwable -> L29
        if (r106 == null) goto L28;
        r106.b(this.f428593a.L().c());     // Catch: Throwable -> L29
    L28:
        this.f428605m = false;
        return;
    L29:
        th = move-exception;
        this.f428605m = false;
        throw th;
    L35:
        return;
    L20:
        if (r104.isLoading() != true) goto L22;
        r105 = true;
        goto L23
    }

    public VoiceInputPreviewDelegate(com.ss.android.lark.keyboard.b r100, com.ss.android.lark.biz.im.api.extension.chat_window.b r101, Function0<? extends fya.a.d> r102, Function0<Unit> r103, Function0<Boolean> r104) {
        Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
        Intrinsics.checkNotNullParameter(r101, "keyboardPluginContext");
        Intrinsics.checkNotNullParameter(r102, "previewAbilityProvider");
        Intrinsics.checkNotNullParameter(r103, "restoreVoiceMode");
        Intrinsics.checkNotNullParameter(r104, "isDestroyed");
        this.f428593a = r100;
        this.f428594b = r101;
        this.f428595c = r103;
        this.f428596d = r104;
        this.f428597e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f428598f = LazyKt.lazy(r102);
        this.f428599g = LazyKt.lazy(VoiceInputPreviewDelegate$voiceTextPostProcessService$2.INSTANCE);
        this.f428602j = PreviewOriginMode.INPUT_UNFOCUSED;
        this.f428604l = "";
    }
}
