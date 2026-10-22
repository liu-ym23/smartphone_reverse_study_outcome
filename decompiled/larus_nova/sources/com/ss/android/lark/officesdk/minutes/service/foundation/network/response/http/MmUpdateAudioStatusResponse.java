package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.d;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmUpdateAudioStatusResponse;", "Ljava/io/Serializable;", "isForceSaveAudio", "", "forceSaveReason", "unavailableReason", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;", "benefitCenterUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;Ljava/lang/String;)V", "()Ljava/lang/String;", "getForceSaveReason", "getUnavailableReason", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;", "getBenefitCenterUrl", "shouldForceSaveAudio", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmUpdateAudioStatusResponse implements Serializable {

    @SerializedName("benefit_center_url")
    private final String benefitCenterUrl;

    @SerializedName("force_save_reason")
    private final String forceSaveReason;

    @SerializedName("is_force_save")
    private final String isForceSaveAudio;

    @SerializedName("unavailable_reason")
    private final d unavailableReason;

    public static final class a {
    }

    static {
    }

    public MmUpdateAudioStatusResponse() {
        this(null, null, null, null, 15, null);
    }

    public final boolean shouldForceSaveAudio() {
        return Intrinsics.areEqual(this.isForceSaveAudio, "1");
    }

    public final String getBenefitCenterUrl() {
        return this.benefitCenterUrl;
    }

    public final String getForceSaveReason() {
        return this.forceSaveReason;
    }

    public final d getUnavailableReason() {
        return this.unavailableReason;
    }

    public final String isForceSaveAudio() {
        return this.isForceSaveAudio;
    }

    public MmUpdateAudioStatusResponse(String r100, String r101, d r102, String r103) {
        this.isForceSaveAudio = r100;
        this.forceSaveReason = r101;
        this.unavailableReason = r102;
        this.benefitCenterUrl = r103;
    }

    public /* synthetic */ MmUpdateAudioStatusResponse(String r100, String r101, d r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
