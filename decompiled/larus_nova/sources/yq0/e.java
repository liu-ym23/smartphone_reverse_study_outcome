package yq0;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0002\u0005\u001bB\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r¨\u0006!"}, d2 = {"Lyq0/e;", "", "", "hasLotteryGift", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setHasLotteryGift", "(Z)V", "", "lotteryGiftUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setLotteryGiftUrl", "(Ljava/lang/String;)V", "", "instantPlayToggleStatus", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setInstantPlayToggleStatus", "(Ljava/lang/Integer;)V", "instantPlayRequirementEnum", "getInstantPlayRequirementEnum", "setInstantPlayRequirementEnum", "instantPlayOpenStatus", "b", "setInstantPlayOpenStatus", "rtcInfo", "e", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("has_lottery_gift")
    private boolean hasLotteryGift;

    @SerializedName("instant_play_open_status")
    private Integer instantPlayOpenStatus;

    @SerializedName("instant_play_requirement_enum")
    private Integer instantPlayRequirementEnum;

    @SerializedName("instant_play_toggle_status")
    private Integer instantPlayToggleStatus;

    @SerializedName("lottery_gift_url")
    private String lotteryGiftUrl;

    @SerializedName("rtc_info")
    private final String rtcInfo;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lyq0/e$a;", "", "Lyq0/e$b;", "userRtcInfo", "Lyq0/e$b;", "b", "()Lyq0/e$b;", "", "podRtcInfo", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("pod")
        private final String podRtcInfo;

        @SerializedName("user")
        private final b userRtcInfo;

        public final String a() {
            return this.podRtcInfo;
        }

        public final b b() {
            return this.userRtcInfo;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lyq0/e$b;", "", "", "rtcExtInfo", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "rtcLiveCoreExtInfo", "getRtcLiveCoreExtInfo", "linkMicId", "getLinkMicId", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("link_mic_id")
        private final String linkMicId;

        @SerializedName("rtc_ext_info")
        private final String rtcExtInfo;

        @SerializedName("rtc_live_core_ext_info")
        private final String rtcLiveCoreExtInfo;

        public b() {
            Intrinsics.checkNotNullParameter("", "linkMicId");
            this.rtcExtInfo = "";
            this.rtcLiveCoreExtInfo = "";
            this.linkMicId = "";
        }

        public final String a() {
            return this.rtcExtInfo;
        }
    }

    public e() {
        this.lotteryGiftUrl = "";
        this.instantPlayToggleStatus = 0;
        this.instantPlayRequirementEnum = 0;
        this.instantPlayOpenStatus = 0;
    }

    public final boolean a() {
        return this.hasLotteryGift;
    }

    public final Integer b() {
        return this.instantPlayOpenStatus;
    }

    public final Integer c() {
        return this.instantPlayToggleStatus;
    }

    public final String d() {
        return this.lotteryGiftUrl;
    }

    public final String e() {
        return this.rtcInfo;
    }
}
