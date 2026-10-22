package wt0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lwt0/e;", "", "", "luckyOpenAuth", "Z", "getLuckyOpenAuth", "()Z", "setLuckyOpenAuth", "(Z)V", "", "luckyBoxToast", "Ljava/lang/String;", "getLuckyBoxToast", "()Ljava/lang/String;", "setLuckyBoxToast", "(Ljava/lang/String;)V", "lotteryOpenAuth", "getLotteryOpenAuth", "setLotteryOpenAuth", "lotteryToast", "getLotteryToast", "setLotteryToast", "userpreviewToast", "getUserpreviewToast", "setUserpreviewToast", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("lottery_open_auth")
    private boolean lotteryOpenAuth;

    @SerializedName("lottery_toast")
    private String lotteryToast;

    @SerializedName("lucky_box_toast")
    private String luckyBoxToast;

    @SerializedName("lucky_box_open_auth")
    private boolean luckyOpenAuth;

    @SerializedName("userpreview_toast")
    private String userpreviewToast;

    public e() {
        this.luckyOpenAuth = true;
        this.luckyBoxToast = "本直播在抖音和火山分发红包记录火山可见";
        this.lotteryOpenAuth = true;
        this.lotteryToast = "本直播在抖音和火山分发福袋记录火山可见";
        this.userpreviewToast = "可前往抖音查看";
    }
}
