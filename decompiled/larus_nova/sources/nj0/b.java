package nj0;

import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.UpdateSubtitleType;
import kotlin.Pair;

/* JADX INFO: loaded from: classes46.dex */
public interface b {
    void Cf();

    void Ck(Pair<Float, Float> r100);

    void N5(IAudioSubtitleContent r100, UpdateSubtitleType r101, c r102);

    void anchorAudioSubtitleSwitchSetting(boolean r100, String r101, c r102);

    void guestAudioSubtitleSwitchSetting(boolean r100);

    boolean isRecording();

    void sd(String r100);
}
