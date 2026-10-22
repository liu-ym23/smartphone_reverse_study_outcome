package ss1;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    @SerializedName("anchor_chat_delay")
    public long anchorChatDelay;

    @SerializedName("chat_max_delay")
    public long chatMaxDelay;

    @SerializedName("enable_delay")
    public boolean enable;

    @SerializedName("enable_delay_in_multi_queue_buffer_v2")
    public boolean enableInOldBuffer;

    @SerializedName("start_delay_sei_receive_count")
    public int startDelaySEICount;

    @SerializedName("stream_delay_max_value")
    public long streamDelayMaxValue;

    @SerializedName("stream_delay_min_value")
    public long streamDelayMinValue;

    @SerializedName("delay_threshold_coefficient")
    public float thresholdCoefficient;

    public a() {
        this.enable = false;
        this.enableInOldBuffer = true;
        this.anchorChatDelay = 500;
        this.streamDelayMinValue = 0;
        this.streamDelayMaxValue = 10000;
        this.startDelaySEICount = 10;
        this.chatMaxDelay = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        this.thresholdCoefficient = 0.5f;
    }
}
