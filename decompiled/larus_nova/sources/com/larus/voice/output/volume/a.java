package com.larus.voice.output.volume;

import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C4519a f376033a = null;

    /* JADX INFO: renamed from: com.larus.voice.output.volume.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes32.dex */
    public static final class C4519a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C4519a f376034a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final List<String> f376035b = null;

        public C4519a() {
        }

        static {
            f376034a = new C4519a();
            f376035b = CollectionsKt.listOf(new String[]{"video", GlobalAudioSceneEnum.PLUGIN_AUDIO, GlobalAudioSceneEnum.QQ_MUSIC, GlobalAudioSceneEnum.PLUGIN_MUSIC, GlobalAudioSceneEnum.PODCAST});
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b {
        public static boolean a(c r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (Intrinsics.areEqual(r100.f376038c, GlobalAudioSceneEnum.TTS_IM) == false) goto L11;
            Map<String, String> r101 = r100.f376039d;
            if (r101 == null) goto L7;
            String r102 = r101.get(AiProactiveTaskViewModel.PARAM_START_METHOD);
        L9:
            if (Intrinsics.areEqual(r102, "auto_play") == false) goto L11;
            return true;
        L7:
            r102 = null;
        L11:
            return false;
        }
    }

    static {
        f376033a = C4519a.f376034a;
    }

    void a(c r100);

    boolean b(c r100);
}
