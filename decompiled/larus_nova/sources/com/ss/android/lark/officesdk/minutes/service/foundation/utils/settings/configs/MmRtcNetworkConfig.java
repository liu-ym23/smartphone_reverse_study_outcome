package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "vc_network_tips_config")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001#BA\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006$"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcNetworkConfig;", "Ljava/io/Serializable;", "toTcpThreshold", "", "tipsDelayTime", "", "networkQualityStrategy", "Lcom/google/gson/JsonObject;", "abTest", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcNetworkConfig$WeakNetworkABTest;", "noRtcNetConfig", "<init>", "(IJLcom/google/gson/JsonObject;Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcNetworkConfig$WeakNetworkABTest;Lcom/google/gson/JsonObject;)V", "getToTcpThreshold", "()I", "getTipsDelayTime", "()J", "getNetworkQualityStrategy", "()Lcom/google/gson/JsonObject;", "getAbTest", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcNetworkConfig$WeakNetworkABTest;", "getNoRtcNetConfig", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "WeakNetworkABTest", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRtcNetworkConfig implements Serializable {

    @SerializedName("meeting_weak_network_abtest")
    private final WeakNetworkABTest abTest;

    @SerializedName("meeting_network_quality_strategy")
    private final JsonObject networkQualityStrategy;

    @SerializedName("no_rtc_network_config")
    private final JsonObject noRtcNetConfig;

    @SerializedName("local_network_disconnect_tips_delay_time")
    private final long tipsDelayTime;

    @SerializedName("to_tcp_threshold")
    private final int toTcpThreshold;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcNetworkConfig$WeakNetworkABTest;", "Ljava/io/Serializable;", "enable", "", "didList", "", "", "userInWhiteList", "userInBlackList", "<init>", "(ZLjava/util/List;ZZ)V", "getEnable", "()Z", "getDidList", "()Ljava/util/List;", "getUserInWhiteList", "getUserInBlackList", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WeakNetworkABTest implements Serializable {

        @SerializedName(a.KEY_DID)
        private final List<String> didList;

        @SerializedName("enable")
        private final boolean enable;

        @SerializedName("user_in_black_list")
        private final boolean userInBlackList;

        @SerializedName("user_in_white_list")
        private final boolean userInWhiteList;

        public WeakNetworkABTest() {
            this(false, null, false, false, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WeakNetworkABTest copy$default(WeakNetworkABTest r100, boolean r101, List r102, boolean r103, boolean r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.enable;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.didList;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.userInWhiteList;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.userInBlackList;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final boolean component1() {
            return this.enable;
        }

        public final List<String> component2() {
            return this.didList;
        }

        public final boolean component3() {
            return this.userInWhiteList;
        }

        public final boolean component4() {
            return this.userInBlackList;
        }

        public final WeakNetworkABTest copy(boolean r100, List<String> r101, boolean r102, boolean r103) {
            return new WeakNetworkABTest(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof WeakNetworkABTest) == true) goto L8;
            return false;
        L8:
            WeakNetworkABTest r101 = (WeakNetworkABTest) r100;
            if (this.enable == r101.enable) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.didList, r101.didList) == true) goto L15;
            return false;
        L15:
            if (this.userInWhiteList == r101.userInWhiteList) goto L18;
            return false;
        L18:
            if (this.userInBlackList == r101.userInBlackList) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = 1231;
            if (this.enable == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            List<String> r103 = this.didList;
            if (r103 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r102 + r104) * 31;
            if (this.userInWhiteList == false) goto L13;
            int r106 = 1231;
        L14:
            int r107 = (r105 + r106) * 31;
            if (this.userInBlackList == true) goto L19;
            r100 = 1237;
        L19:
            return r107 + r100;
        L13:
            r106 = 1237;
            goto L14
        L9:
            r104 = r103.hashCode();
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public String toString() {
            return "WeakNetworkABTest(enable=" + this.enable + ", didList=" + this.didList + ", userInWhiteList=" + this.userInWhiteList + ", userInBlackList=" + this.userInBlackList + ')';
        }

        public final List<String> getDidList() {
            return this.didList;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final boolean getUserInBlackList() {
            return this.userInBlackList;
        }

        public final boolean getUserInWhiteList() {
            return this.userInWhiteList;
        }

        public WeakNetworkABTest(boolean r100, List<String> r101, boolean r102, boolean r103) {
            this.enable = r100;
            this.didList = r101;
            this.userInWhiteList = r102;
            this.userInBlackList = r103;
        }

        public /* synthetic */ WeakNetworkABTest(boolean r100, List r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = false;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = false;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    public MmRtcNetworkConfig() {
        this(0, 0, null, null, null, 31, null);
    }

    public MmRtcNetworkConfig(int r110) {
        this(r110, 0, null, null, null, 30, null);
    }

    public MmRtcNetworkConfig(int r110, long r111) {
        this(r110, r111, null, null, null, 28, null);
    }

    public MmRtcNetworkConfig(int r110, long r111, JsonObject r112) {
        this(r110, r111, r112, null, null, 24, null);
    }

    public MmRtcNetworkConfig(int r110, long r111, JsonObject r112, WeakNetworkABTest r113) {
        this(r110, r111, r112, r113, null, 16, null);
    }

    public static /* synthetic */ MmRtcNetworkConfig copy$default(MmRtcNetworkConfig r100, int r101, long r102, JsonObject r103, WeakNetworkABTest r104, JsonObject r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.toTcpThreshold;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.tipsDelayTime;
    L8:
        long r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.networkQualityStrategy;
    L11:
        JsonObject r113 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.abTest;
    L14:
        WeakNetworkABTest r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.noRtcNetConfig;
    L17:
        int r107 = r101;
        return r100.copy(r107, r105, r113, r106, r110);
    }

    public final int component1() {
        return this.toTcpThreshold;
    }

    public final long component2() {
        return this.tipsDelayTime;
    }

    public final JsonObject component3() {
        return this.networkQualityStrategy;
    }

    public final WeakNetworkABTest component4() {
        return this.abTest;
    }

    public final JsonObject component5() {
        return this.noRtcNetConfig;
    }

    public final MmRtcNetworkConfig copy(int r100, long r110, JsonObject r111, WeakNetworkABTest r112, JsonObject r113) {
        return new MmRtcNetworkConfig(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmRtcNetworkConfig) == true) goto L8;
        return false;
    L8:
        MmRtcNetworkConfig r101 = (MmRtcNetworkConfig) r100;
        if (this.toTcpThreshold == r101.toTcpThreshold) goto L12;
        return false;
    L12:
        if (this.tipsDelayTime == r101.tipsDelayTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.networkQualityStrategy, r101.networkQualityStrategy) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.abTest, r101.abTest) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.noRtcNetConfig, r101.noRtcNetConfig) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.toTcpThreshold * 31;
        long r101 = this.tipsDelayTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        JsonObject r103 = this.networkQualityStrategy;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        WeakNetworkABTest r107 = this.abTest;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        JsonObject r110 = this.noRtcNetConfig;
        if (r110 == null) goto L15;
        r104 = r110.hashCode();
    L15:
        return r109 + r104;
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public String toString() {
        return "MmRtcNetworkConfig(toTcpThreshold=" + this.toTcpThreshold + ", tipsDelayTime=" + this.tipsDelayTime + ", networkQualityStrategy=" + this.networkQualityStrategy + ", abTest=" + this.abTest + ", noRtcNetConfig=" + this.noRtcNetConfig + ')';
    }

    public final WeakNetworkABTest getAbTest() {
        return this.abTest;
    }

    public final JsonObject getNetworkQualityStrategy() {
        return this.networkQualityStrategy;
    }

    public final JsonObject getNoRtcNetConfig() {
        return this.noRtcNetConfig;
    }

    public final long getTipsDelayTime() {
        return this.tipsDelayTime;
    }

    public final int getToTcpThreshold() {
        return this.toTcpThreshold;
    }

    public MmRtcNetworkConfig(int r100, long r101, JsonObject r102, WeakNetworkABTest r103, JsonObject r104) {
        this.toTcpThreshold = r100;
        this.tipsDelayTime = r101;
        this.networkQualityStrategy = r102;
        this.abTest = r103;
        this.noRtcNetConfig = r104;
    }

    public /* synthetic */ MmRtcNetworkConfig(int r100, long r101, JsonObject r102, WeakNetworkABTest r103, JsonObject r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        long r104 = r101;
        if ((r111 & 4) == 0) goto L11;
        JsonObject r113 = null;
    L13:
        if ((r111 & 8) == 0) goto L15;
        WeakNetworkABTest r105 = null;
    L17:
        if ((r111 & 16) == 0) goto L19;
        JsonObject r106 = null;
    L20:
        this(r100, r104, r113, r105, r106);
        return;
    L19:
        r106 = r110;
        goto L20
    L15:
        r105 = r103;
        goto L17
    L11:
        r113 = r102;
        goto L13
    }
}
