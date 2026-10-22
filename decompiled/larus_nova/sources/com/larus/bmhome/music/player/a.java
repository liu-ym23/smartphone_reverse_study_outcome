package com.larus.bmhome.music.player;

import android.content.Context;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.SoundsSource;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.bmhome.music.player.a$a, reason: collision with other inner class name */
    public interface InterfaceC4089a {

        /* JADX INFO: renamed from: com.larus.bmhome.music.player.a$a$a, reason: collision with other inner class name */
        public static final class C4090a {
            public static void b() {
                GlobalAudioObserver.f289772a.f(GlobalAudioSceneEnum.TEXT_GENERATE_MUSIC, null, null);
                AudioServiceDelegate.f288288a.O().a(SoundsSource.TEXT_GENERATED_MUSIC);
            }

            public static void a(Map r100) {
                Intrinsics.checkNotNullParameter(r100, "bizExtra");
                GlobalAudioObserver.f289772a.c(GlobalAudioSceneEnum.TEXT_GENERATE_MUSIC, GlobalAudioStateEnum.STOPPED, r100);
                AudioServiceDelegate.f288288a.O().c(SoundsSource.TEXT_GENERATED_MUSIC);
            }

            public static void c(Map r100) {
                Intrinsics.checkNotNullParameter(r100, "bizExtra");
                GlobalAudioObserver.f289772a.c(GlobalAudioSceneEnum.TEXT_GENERATE_MUSIC, GlobalAudioStateEnum.PAUSED, r100);
            }

            public static void d(Map r100) {
                Intrinsics.checkNotNullParameter(r100, "bizExtra");
                AudioServiceDelegate.f288288a.O().e(SoundsSource.TEXT_GENERATED_MUSIC);
            }

            public static void e(String r100, Map r101) {
                Intrinsics.checkNotNullParameter(r100, "uniId");
                Intrinsics.checkNotNullParameter(r101, "bizExtra");
                GlobalAudioObserver r102 = GlobalAudioObserver.f289772a;
                r102.e(GlobalAudioSceneEnum.TEXT_GENERATE_MUSIC, r100, r101);
                r102.c(GlobalAudioSceneEnum.TEXT_GENERATE_MUSIC, GlobalAudioStateEnum.PLAYING, r101);
            }
        }

        void F6();

        void FK();

        void GP(Map<String, String> r100);

        void Ij(Map<String, String> r100);

        void Lf();

        void Lr();

        void OK();

        void Pe(float r100, boolean r101);

        void UY();

        void eb(Map<String, String> r100);

        void f20();

        CoroutineScope getScope();

        Context getViewContext();

        void hideLoadingView();

        void mP(int r100, boolean r101);

        void r30(String r100, Map<String, String> r101);

        void showLoadingView();
    }

    boolean a();

    void b(float r100);

    void c();

    void d(j r100);

    j data();

    void e(j r100);

    void f(boolean r100, boolean r101);

    void g();

    void h(boolean r100);

    void i();

    boolean isStreaming();

    int j(String r100, Function1<? super Integer, Unit> r101);

    void k(boolean r100);

    void onAttachedToWindow();

    void onDestroyed();

    void onDetachedFromWindow();

    void onPaused();

    void onResumed();

    void seekTo(int r100);
}
