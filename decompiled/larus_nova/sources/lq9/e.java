package lq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/platform/model/audio/AudioRetransmitModel;", "", "enable", "", "retryPingPongTimeout", "", "retryInterval", "", "<init>", "(ZI[I)V", "getEnable", "()Z", "getRetryPingPongTimeout", "()I", "getRetryInterval", "()[I", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("retry_interval")
    private final int[] retryInterval;

    @SerializedName("retry_ping_pong_timeout")
    private final int retryPingPongTimeout;

    public e() {
        this(0);
    }

    public final boolean a() {
        return this.enable;
    }

    public final int[] b() {
        return this.retryInterval;
    }

    public final int c() {
        return this.retryPingPongTimeout;
    }

    public /* synthetic */ e(int r100) {
        this(true, 0, new int[]{300, 600, 900, 1200, 1500});
    }

    public e(boolean r100, int r101, int[] r102) {
        this.enable = r100;
        this.retryPingPongTimeout = r101;
        this.retryInterval = r102;
    }
}
