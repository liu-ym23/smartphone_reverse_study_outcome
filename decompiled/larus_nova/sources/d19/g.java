package d19;

import android.animation.Animator;
import com.larus.voicecall.impl.continue_talk.f2;
import com.larus.voicecall.impl.continue_talk.g2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public interface g {
    void a(f2 r100, g2 r101);

    void b(Function1<? super Animator, Unit> r100, Function1<? super Animator, Unit> r101);

    void c();

    void d();

    void destroy();

    void init();

    void setAudioAmplitude(float r100);

    void setDarkMode(boolean r100);
}
