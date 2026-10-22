package rw5;

import com.bytedance.flow_audio.api.foundation.player.AudioPlayerStatus;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends pd6.a {
    void L0(d r100);

    void duck(float r100);

    AudioPlayerStatus getStatus();

    void pause();

    void resume();

    void start();

    void stop();
}
