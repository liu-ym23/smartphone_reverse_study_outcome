package oq1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Loq1/e;", "", "", "danmakuSpeed", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setDanmakuSpeed", "(I)V", "giftDanmakuMaxCount", "getGiftDanmakuMaxCount", "setGiftDanmakuMaxCount", "specialDanmakuMaxCount", "getSpecialDanmakuMaxCount", "setSpecialDanmakuMaxCount", "", "rightsPanelEnable", "Z", "getRightsPanelEnable", "()Z", "setRightsPanelEnable", "(Z)V", "<init>", "()V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("danmaku_speed")
    private int danmakuSpeed;

    @SerializedName("gift_danmaku_max_count")
    private int giftDanmakuMaxCount;

    @SerializedName("rights_panel_enable")
    private boolean rightsPanelEnable;

    @SerializedName("special_danmaku_max_count")
    private int specialDanmakuMaxCount;

    public e() {
        this.danmakuSpeed = 320;
        this.giftDanmakuMaxCount = 5;
        this.specialDanmakuMaxCount = 5;
        this.rightsPanelEnable = true;
    }

    public final int a() {
        return this.danmakuSpeed;
    }
}
