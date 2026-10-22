package fc2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lfc2/h;", "", "", "enableFollowMsgClick", "Z", "b", "()Z", "setEnableFollowMsgClick", "(Z)V", "enableShareMsgClick", "d", "setEnableShareMsgClick", "enableSendGiftMsgClick", "c", "setEnableSendGiftMsgClick", "enableFansClubMsgClick", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnableFansClubMsgClick", "<init>", "()V", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("enable_fansclub_msg_click")
    private boolean enableFansClubMsgClick;

    @SerializedName("enable_follow_msg_click")
    private boolean enableFollowMsgClick;

    @SerializedName("enable_send_gift_msg_click")
    private boolean enableSendGiftMsgClick;

    @SerializedName("enable_share_msg_click")
    private boolean enableShareMsgClick;

    public h() {
        this.enableFollowMsgClick = true;
        this.enableSendGiftMsgClick = true;
    }

    public final boolean a() {
        return this.enableFansClubMsgClick;
    }

    public final boolean b() {
        return this.enableFollowMsgClick;
    }

    public final boolean c() {
        return this.enableSendGiftMsgClick;
    }

    public final boolean d() {
        return this.enableShareMsgClick;
    }
}
